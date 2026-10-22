package a20;

import com.bytedance.android.live.broadcastgame.api.model.OpenFeatureScene;
import com.bytedance.android.live.broadcastgame.api.model.l0;
import com.bytedance.android.live.broadcastgame.api.model.m0;
import com.bytedance.android.live.broadcastgame.api.model.p;
import io.reactivex.Observable;
import java.util.LinkedList;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface k {
    LinkedList<String> a();

    void b();

    Observable<com.bytedance.android.live.network.response.e<p>> c(long r1, long r3, int r5, String r6, int r7, String r8);

    Observable<com.bytedance.android.live.network.response.e<p>> d(long r1, long r3, int r5, String r6, String r7, int r8, String r9);

    Observable<p> e(@OpenFeatureScene long r1, String r3);

    Observable<Unit> f(p r1, String r2);

    Observable<com.bytedance.android.live.network.response.e<m0>> g(@OpenFeatureScene long r1, Long r3, int r4, String r5);

    void h(String r1);

    Observable<com.bytedance.android.live.network.response.e<l0>> i(long r1, String r3);

    Observable<com.bytedance.android.live.network.response.e<m0>> j(@OpenFeatureScene long r1, Long r3, int r4, String r5);
}
