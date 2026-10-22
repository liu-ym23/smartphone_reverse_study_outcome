package o11;

import cy0.c;
import cy0.f;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends j implements a, h<f> {
    public Object e;
    public final com.bytedance.android.live.revenue.core.a f;
    public final com.bytedance.android.live.revenue.core.b g;
    public final com.bytedance.live.kmp.core.a h;
    public final f i;

    public final String toString() {
        return "com.bytedance.android.live.revlink.api.scope.__ScopeImpl_LinkScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r0 = this.g;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r0 = this.h;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // o11.a
    public final c v() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (c) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.scope.RevenueDataScope");
    }

    public final com.bytedance.android.scope.j r() {
        return this.i;
    }

    public b(f r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.i = r2;
        this.e = k.a;
        this.f = r2.F();
        this.g = r2.A();
        this.h = r2.i();
    }
}
