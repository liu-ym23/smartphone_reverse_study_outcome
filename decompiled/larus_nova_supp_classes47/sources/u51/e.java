package u51;

import com.bytedance.android.live.revlink.link.core.service.s;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends j implements c, h<o11.a> {
    public Object e;
    public Object f;
    public final cy0.c g;
    public final com.bytedance.android.live.revenue.core.a h;
    public final com.bytedance.android.live.revenue.core.b i;
    public final com.bytedance.live.kmp.core.a j;
    public final o11.a k;

    public final String toString() {
        return "com.bytedance.android.live.revlink.link.infra.__ScopeImpl_RevLinkInfraAudienceScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r0 = this.i;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r0 = this.h;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    @Override // u51.c
    public final s f() {
        Object r0 = this.f;
        if (r0 == null) goto L7;
        return (s) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.link.core.service.RevenueDynamicLayoutClient");
    }

    @Override // u51.c
    public final ld.a getLinkInternalDataSet() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (ld.a) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.datacenter.ILinkInternalDataSet");
    }

    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r0 = this.j;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // o11.a
    public final cy0.c v() {
        cy0.c r0 = this.g;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.scope.RevenueDataScope");
    }

    public final com.bytedance.android.scope.j r() {
        return this.k;
    }

    public e(o11.a r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.k = r2;
        Object r0 = k.a;
        this.e = r0;
        this.f = r0;
        this.g = r2.v();
        this.h = r2.F();
        this.i = r2.A();
        this.j = r2.i();
    }
}
