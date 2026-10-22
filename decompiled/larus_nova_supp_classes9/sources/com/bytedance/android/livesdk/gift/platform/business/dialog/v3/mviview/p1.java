package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p1 extends e33.j implements n1, e33.h<com.bytedance.android.scope.j> {
    public Object e;
    public final com.bytedance.android.scope.j f;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.__ScopeImpl_ReceiverViewScope";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.n1
    public Context getContext() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (Context) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    public final com.bytedance.android.scope.j r() {
        return this.f;
    }

    public p1(com.bytedance.android.scope.j r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.f = r2;
        this.e = e33.k.a;
    }
}
