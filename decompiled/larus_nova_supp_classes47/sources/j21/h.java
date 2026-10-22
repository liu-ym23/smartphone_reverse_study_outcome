package j21;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ g a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ a d;

    public h(g r1, int r2, long r3, e.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void accept(Object r12) {
        ExtraResponse r13 = (ExtraResponse) r12;
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a.b;
        LiveFullLinkPKMonitor r1 = null;
        if (r0 == null) goto L5;
        v r2 = r0.getMultiLinkMonitor();
    L6:
        if (r2 == null) goto L8;
        r2.p("linking_invite", this.b, t.a(this.c));
    L8:
        com.bytedance.android.live.revlink.impl.global.c r3 = this.a.b;
        if (r3 == null) goto L11;
        r1 = r3.getLiveFullLinkPKMonitor();
    L11:
        LiveFullLinkPKMonitor r4 = r1;
        if (r4 == null) goto L14;
        i97.a r5 = i97.a.a;
        LiveFullLinkPKMonitor.s(r4, "battle/rivals/recommend", System.currentTimeMillis() - this.c, 0, 0, null, 28);
    L14:
        this.d.a((IRivalRankRecommendResponse) r13.data);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
