package com.bytedance.android.live.profit.redpacket;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n1 extends e33.j implements w0, e33.h<cy0.f> {
    public Object e;
    public Object f;
    public final com.bytedance.android.live.revenue.core.a g;
    public final com.bytedance.android.live.revenue.core.b h;
    public final com.bytedance.live.kmp.core.a i;
    public final cy0.f j;

    public final String toString() {
        return "com.bytedance.android.live.profit.redpacket.__ScopeImpl_RedPacketScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r0 = this.h;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r0 = this.g;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    @Override // com.bytedance.android.live.profit.redpacket.w0
    public Context getContext() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (Context) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r0 = this.i;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // com.bytedance.android.live.profit.redpacket.w0
    public final l p() {
        Object r0 = this.f;
        if (r0 == null) goto L7;
        return (l) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.redpacket.RedPacketContext");
    }

    public final com.bytedance.android.scope.j r() {
        return this.j;
    }

    public n1(cy0.f r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.j = r2;
        Object r0 = e33.k.a;
        this.e = r0;
        this.f = r0;
        this.g = r2.F();
        this.h = r2.A();
        this.i = r2.i();
    }
}
