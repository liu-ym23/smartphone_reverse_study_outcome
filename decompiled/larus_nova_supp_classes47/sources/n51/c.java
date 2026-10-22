package n51;

import com.bytedance.android.live.revenuelink.connect.n;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revlink.link.core.service.s;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends j implements a, h<p51.a> {
    public final g e;
    public final s f;
    public final ld.a g;
    public final com.bytedance.android.live.revlink.impl.global.c h;
    public final i i;
    public final n j;
    public final u51.a k;
    public final cy0.c l;
    public final com.bytedance.android.live.revenue.core.a m;
    public final com.bytedance.android.live.revenue.core.b n;
    public final com.bytedance.live.kmp.core.a o;
    public final p51.a p;

    public final String toString() {
        return "com.bytedance.android.live.revlink.link.biz.__ScopeImpl_RevLinkBizAnchorMultiScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r0 = this.n;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r0 = this.m;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    @Override // u51.b
    public final u51.a H() {
        u51.a r0 = this.k;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.link.infra.IRevLinkHostService");
    }

    @Override // u51.b
    public final i R1() {
        i r0 = this.i;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenuelink.rtc.IAnchorRtcManager");
    }

    @Override // u51.b
    public final s f() {
        s r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.link.core.service.RevenueDynamicLayoutClient");
    }

    @Override // n51.a, p51.a, o51.c, v51.b
    public g getContext() {
        g r0 = this.e;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.link.infra.lifecontrol.context.RevLinkBizAnchorContext");
    }

    @Override // u51.b
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.h;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.global.ILinkInstanceService");
    }

    @Override // u51.b
    public final ld.a getLinkInternalDataSet() {
        ld.a r0 = this.g;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.datacenter.ILinkInternalDataSet");
    }

    @Override // u51.b
    public final n getLinkOutManager() {
        n r0 = this.j;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenuelink.connect.ILinkOutManager");
    }

    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r0 = this.o;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // o11.a
    public final cy0.c v() {
        cy0.c r0 = this.l;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.scope.RevenueDataScope");
    }

    public final com.bytedance.android.scope.j r() {
        return this.p;
    }

    public c(p51.a r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.p = r2;
        Object r0 = k.a;
        this.e = r2.getContext();
        this.f = r2.f();
        this.g = r2.getLinkInternalDataSet();
        this.h = r2.getLinkInstanceService();
        this.i = r2.R1();
        this.j = r2.getLinkOutManager();
        this.k = r2.H();
        this.l = r2.v();
        this.m = r2.F();
        this.n = r2.A();
        this.o = r2.i();
    }
}
