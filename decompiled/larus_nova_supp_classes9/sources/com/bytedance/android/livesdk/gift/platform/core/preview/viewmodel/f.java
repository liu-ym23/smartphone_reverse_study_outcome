package com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel;

import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends j implements d, h<com.bytedance.android.scope.j> {
    public Object e;
    public Object f;
    public final com.bytedance.android.scope.j g;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.__ScopeImpl_UgcPoolPanelScope";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.d
    public final String getClickFrom() {
        Object r0 = this.f;
        if (r0 == null) goto L7;
        return (String) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.d
    public final int getSourceFrom() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return ((Integer) r0).intValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final com.bytedance.android.scope.j r() {
        return this.g;
    }

    public f(com.bytedance.android.scope.j r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.g = r2;
        Object r3 = k.a;
        this.e = r3;
        this.f = r3;
    }
}
