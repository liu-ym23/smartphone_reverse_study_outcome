package ru0;

import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends j implements a, h<a> {
    public Object e;
    public final com.bytedance.android.live.revenue.core.a f;
    public final com.bytedance.android.live.revenue.core.b g;
    public final com.bytedance.live.kmp.core.a h;
    public final a i;

    public final String toString() {
        return "com.bytedance.android.live.profit.livepet.scopes.__ScopeImpl_LivePetInstanceScope";
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

    public final com.bytedance.android.scope.j r() {
        return this.i;
    }

    public b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.i = r2;
        this.e = k.a;
        this.f = r2.F();
        this.g = r2.A();
        this.h = r2.i();
    }
}
