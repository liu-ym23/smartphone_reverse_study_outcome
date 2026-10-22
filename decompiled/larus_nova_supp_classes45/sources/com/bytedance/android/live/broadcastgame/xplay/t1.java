package com.bytedance.android.live.broadcastgame.xplay;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t1 extends e33.j implements g1, e33.h<com.bytedance.android.scope.j> {
    public Object e;
    public Object f;
    public Object g;
    public final com.bytedance.android.scope.j h;

    public final String toString() {
        return "com.bytedance.android.live.broadcastgame.xplay.__ScopeImpl_XplayScope";
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.g1
    public final com.bytedance.android.live.broadcastgame.api.xplay.f a() {
        Object r0 = this.f;
        if (r0 == null) goto L7;
        return (com.bytedance.android.live.broadcastgame.api.xplay.f) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.xplay.IXplayInstance");
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.g1
    public final com.bytedance.android.live.broadcastgame.api.xplay.p h() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (com.bytedance.android.live.broadcastgame.api.xplay.p) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.xplay.XplayNewEnv");
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.g1
    public final XplayInternalContext x() {
        Object r0 = this.g;
        if (r0 == null) goto L7;
        return (XplayInternalContext) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.xplay.XplayInternalContext");
    }

    public final com.bytedance.android.scope.j r() {
        return this.h;
    }

    public t1(com.bytedance.android.scope.j r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.h = r2;
        Object r3 = e33.k.a;
        this.e = r3;
        this.f = r3;
        this.g = r3;
    }
}
