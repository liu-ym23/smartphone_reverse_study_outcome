package dv0;

import com.bytedance.android.live.profit.scoreboard.ScoreboardMatchManager;
import io.reactivex.Observable;
import java.util.Collection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface h {
    long a();

    long b();

    Observable<h> c();

    long d();

    long getActualFinishTime();

    ScoreboardMatchManager.b getCreator();

    String getMiniAppId();

    Collection<d> getPlayers();

    long getRoomId();

    long getRoundId();

    long getStartTime();

    boolean isFinished();
}
