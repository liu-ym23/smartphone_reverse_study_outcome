package com.bytedance.android.live.profit.taskcenter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l extends e33.j implements j, e33.h<cy0.f> {
    public final com.bytedance.android.live.revenue.core.a e;
    public final com.bytedance.android.live.revenue.core.b f;
    public final com.bytedance.live.kmp.core.a g;
    public final cy0.f h;

    public final String toString() {
        return "com.bytedance.android.live.profit.taskcenter.__ScopeImpl_TaskCenterScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r0 = this.e;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r0 = this.g;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    public final com.bytedance.android.scope.j r() {
        return this.h;
    }

    public l(cy0.f r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.h = r2;
        Object r0 = e33.k.a;
        this.e = r2.F();
        this.f = r2.A();
        this.g = r2.i();
    }
}
