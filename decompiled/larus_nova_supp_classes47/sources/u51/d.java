package u51;

import com.bytedance.android.live.revenuelink.connect.n;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revlink.link.core.service.s;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends j implements b, h<o11.a> {
    public Object e;
    public Object f;
    public Object g;
    public Object h;
    public Object i;
    public Object j;
    public final cy0.c k;
    public final com.bytedance.android.live.revenue.core.a l;
    public final com.bytedance.android.live.revenue.core.b m;
    public final com.bytedance.live.kmp.core.a n;
    public final o11.a o;

    public final String toString() {
        return "com.bytedance.android.live.revlink.link.infra.__ScopeImpl_RevLinkInfraAnchorScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r0 = this.m;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r0 = this.l;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    @Override // u51.b
    public final a H() {
        Object r0 = this.j;
        if (r0 == null) goto L7;
        return (a) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.link.infra.IRevLinkHostService");
    }

    @Override // u51.b
    public final i R1() {
        Object r0 = this.h;
        if (r0 == null) goto L7;
        return (i) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenuelink.rtc.IAnchorRtcManager");
    }

    @Override // u51.b
    public final s f() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (s) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.link.core.service.RevenueDynamicLayoutClient");
    }

    @Override // u51.b
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        Object r0 = this.g;
        if (r0 == null) goto L7;
        return (com.bytedance.android.live.revlink.impl.global.c) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.global.ILinkInstanceService");
    }

    @Override // u51.b
    public final ld.a getLinkInternalDataSet() {
        Object r0 = this.f;
        if (r0 == null) goto L7;
        return (ld.a) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.datacenter.ILinkInternalDataSet");
    }

    @Override // u51.b
    public final n getLinkOutManager() {
        Object r0 = this.i;
        if (r0 == null) goto L7;
        return (n) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenuelink.connect.ILinkOutManager");
    }

    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r0 = this.n;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // o11.a
    public final cy0.c v() {
        cy0.c r0 = this.k;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.scope.RevenueDataScope");
    }

    public final com.bytedance.android.scope.j r() {
        return this.o;
    }

    public d(o11.a r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.o = r2;
        Object r0 = k.a;
        this.e = r0;
        this.f = r0;
        this.g = r0;
        this.h = r0;
        this.i = r0;
        this.j = r0;
        this.k = r2.v();
        this.l = r2.F();
        this.m = r2.A();
        this.n = r2.i();
    }
}
