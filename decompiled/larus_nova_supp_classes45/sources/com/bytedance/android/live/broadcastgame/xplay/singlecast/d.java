package com.bytedance.android.live.broadcastgame.xplay.singlecast;

import com.bytedance.android.live.broadcastgame.api.xplay.f;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.xplay.XplayInternalContext;
import com.bytedance.android.live.broadcastgame.xplay.g1;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends j implements b, h<g1> {
    public final p e;
    public final f f;
    public final XplayInternalContext g;
    public final g1 h;

    public final String toString() {
        return "com.bytedance.android.live.broadcastgame.xplay.singlecast.__ScopeImpl_XplaySingleCastScope";
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.g1
    public final f a() {
        f r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.xplay.IXplayInstance");
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.g1
    public final p h() {
        p r0 = this.e;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.xplay.XplayNewEnv");
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.g1
    public final XplayInternalContext x() {
        XplayInternalContext r0 = this.g;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.xplay.XplayInternalContext");
    }

    public final com.bytedance.android.scope.j r() {
        return this.h;
    }

    public d(g1 r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.h = r2;
        Object r0 = k.a;
        this.e = r2.h();
        this.f = r2.a();
        this.g = r2.x();
    }
}
