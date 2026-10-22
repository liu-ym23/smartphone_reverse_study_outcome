package nb0;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.karaokestation.model.d;
import com.bytedance.android.live.ktv.common.karaokestation.model.x;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.model.api.o0;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface b {
    void a(d r1, List<o0> r2);

    void addFavorite(MusicPanel r1, ic0.a r2);

    void addSong(Context r1, MusicPanel r2, RecyclerView.ViewHolder r3);

    void b(boolean r1, Throwable r2, y r3, long r4);

    String c();

    void d(boolean r1, Throwable r2, d r3, long r4);

    void delFavorite(MusicPanel r1, ic0.a r2);

    t61 e();

    Map<String, y> f(d r1);

    int g();

    String getRequiredSongInfo();

    x getRoomInfo();

    String h();

    void postSyncSongListData(y r1);

    void postSyncTabListData(d r1);

    void updateMusicPanelState(MusicPanel r1);
}
