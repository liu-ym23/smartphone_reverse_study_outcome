package j21;

import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.utils.t;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ g a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;

    public i(g r1, int r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r10) {
        Throwable r12 = (Throwable) r10;
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a.b;
        if (r0 == null) goto L5;
        v r1 = r0.getMultiLinkMonitor();
    L6:
        if (r1 == null) goto L8;
        r1.o("linking_invite", this.b, t.a(this.c), r12);
    L8:
        com.bytedance.android.live.revlink.impl.global.c r2 = this.a.b;
        if (r2 == null) goto L11;
        LiveFullLinkPKMonitor r3 = r2.getLiveFullLinkPKMonitor();
    L12:
        if (r3 == null) goto L15;
        i97.a r4 = i97.a.a;
        LiveFullLinkPKMonitor.r(r3, "battle/rivals/recommend", r12, System.currentTimeMillis() - this.c, 0, 0, null, 56);
        return;
    L15:
        return;
    L11:
        r3 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }
}
