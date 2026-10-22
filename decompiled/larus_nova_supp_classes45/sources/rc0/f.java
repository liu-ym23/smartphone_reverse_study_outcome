package rc0;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface f {
    void E(cy0.a r1);

    void a(AbsLivePlayerView r1);

    void b(AbsLivePlayerView r1);

    boolean c();

    void d();

    void e();

    boolean f(Context r1, String r2, LiveMode r3, boolean r4, IRoom r5, Pair<Integer, Integer> r6);

    void g(j r1, IRoom r2, Pair<Integer, Integer> r3);

    Pair<Integer, Integer> h();
}
