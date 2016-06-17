package mc.bukkit.test.xboxfly15;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Main extends JavaPlugin implements Listener {
 
 static Plugin plugin;
 
 public void onEnable() {
  plugin = this;
  Bukkit.getServer().getPluginManager().registerEvents(this, this);
  Bukkit.getConsoleSender().sendMessage("Scoreboard test plugin enabled!");
  
 }
 
 
 ScoreboardManager manager = Bukkit.getScoreboardManager();
 Scoreboard board = manager.getNewScoreboard();
 Objective objective = board.registerNewObjective("test", "dummy");

 
 @EventHandler
 public void PlayerJoin(PlayerJoinEvent e) {

  
  final Player p = e.getPlayer();

  
  Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
   public void run() {
    
    ScoreboardManager manager = Bukkit.getScoreboardManager();
    final Scoreboard board = manager.getNewScoreboard();
    final Objective objective = board.registerNewObjective("test", "dummy");
    
    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
    objective.setDisplayName(ChatColor.RED + "EndlessX");

    Score score = objective.getScore(ChatColor.AQUA + "Player name:");
    score.setScore(10);
    
    Score score1 = objective.getScore(ChatColor.GRAY + p.getName());
    score1.setScore(9);
    
    Score score2 = objective.getScore(ChatColor.AQUA + "Health:");
    score2.setScore(8);
    
    long health = Math.round(p.getHealth());
    
    Score score3 = objective.getScore(ChatColor.GRAY + String.valueOf(health));
    score3.setScore(7);
    
    p.setScoreboard(board);

   }
  },0, 20 * 10);
  
 }

}