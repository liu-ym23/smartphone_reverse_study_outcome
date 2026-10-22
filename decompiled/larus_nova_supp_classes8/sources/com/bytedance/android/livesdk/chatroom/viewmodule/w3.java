package com.bytedance.android.livesdk.chatroom.viewmodule;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w3 extends e33.j implements u2, e33.h<com.bytedance.android.scope.j> {
    public Object e;
    public final com.bytedance.android.scope.j f;

    public final String toString() {
        return "com.bytedance.android.livesdk.chatroom.viewmodule.__ScopeImpl_StickerScope";
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.u2
    public final y0 n() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (y0) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.IStickerManager");
    }

    public final com.bytedance.android.scope.j r() {
        return this.f;
    }

    public w3(com.bytedance.android.scope.j r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.f = r2;
        this.e = e33.k.a;
    }
}
