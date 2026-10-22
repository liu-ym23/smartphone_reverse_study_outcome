package com.bytedance.android.live.recharge.panel.dynamic;

import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends j implements b, h<com.bytedance.android.live.recharge.core.b> {
    public Object e;
    public final com.bytedance.android.live.recharge.core.b f;

    public final String toString() {
        return "com.bytedance.android.live.recharge.panel.dynamic.__ScopeImpl_DynamicRechargePanelScope";
    }

    @Override // com.bytedance.android.live.recharge.panel.dynamic.b
    public final com.bytedance.android.live.recharge.panel.context.f c() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (com.bytedance.android.live.recharge.panel.context.f) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.panel.context.RechargePanelContext");
    }

    public final com.bytedance.android.scope.j r() {
        return this.f;
    }

    public g(com.bytedance.android.live.recharge.core.b r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.f = r2;
        this.e = k.a;
    }
}
