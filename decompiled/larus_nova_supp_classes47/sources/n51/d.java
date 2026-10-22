package n51;

import com.bytedance.android.live.revlink.link.core.service.s;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends j implements b, h<p51.b> {
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h e;
    public final ld.a f;
    public final s g;
    public final cy0.c h;
    public final com.bytedance.android.live.revenue.core.a i;
    public final com.bytedance.android.live.revenue.core.b j;
    public final com.bytedance.live.kmp.core.a k;
    public final p51.b l;

    public final String toString() {
        return "com.bytedance.android.live.revlink.link.biz.__ScopeImpl_RevLinkBizAudienceMultiScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r0 = this.j;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r0 = this.i;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    @Override // u51.c
    public final s f() {
        s r0 = this.g;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.link.core.service.RevenueDynamicLayoutClient");
    }

    @Override // n51.b, p51.b, o51.d
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h getContext() {
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h r0 = this.e;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.link.infra.lifecontrol.context.RevLinkBizAudienceContext");
    }

    @Override // u51.c
    public final ld.a getLinkInternalDataSet() {
        ld.a r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.datacenter.ILinkInternalDataSet");
    }

    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r0 = this.k;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // o11.a
    public final cy0.c v() {
        cy0.c r0 = this.h;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.scope.RevenueDataScope");
    }

    public final com.bytedance.android.scope.j r() {
        return this.l;
    }

    public d(p51.b r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.l = r2;
        Object r0 = k.a;
        this.e = r2.getContext();
        this.f = r2.getLinkInternalDataSet();
        this.g = r2.f();
        this.h = r2.v();
        this.i = r2.F();
        this.j = r2.A();
        this.k = r2.i();
    }
}
