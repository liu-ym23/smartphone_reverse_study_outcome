package cy0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l extends e33.j implements g, e33.h<u60.a> {
    public Object e;
    public final com.bytedance.live.kmp.core.a f;
    public final u60.a g;

    public final String toString() {
        return "com.bytedance.android.live.revenue.core.scope.__ScopeImpl_RevenueInstanceScopeExt";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (com.bytedance.android.live.revenue.core.b) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    public final com.bytedance.android.scope.j r() {
        return this.g;
    }

    public l(u60.a r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.g = r2;
        this.e = e33.k.a;
        this.f = r2.i();
    }
}
