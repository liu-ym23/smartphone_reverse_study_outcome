package com.bytedance.android.live.revlink.impl.multianchor.scope;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends j implements a, h<com.bytedance.android.scope.j> {
    public Object e;
    public Object f;
    public Object g;
    public final com.bytedance.android.scope.j h;

    public final String toString() {
        return "com.bytedance.android.live.revlink.impl.multianchor.scope.__ScopeImpl_MultiLinkAnchorControlScope";
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.scope.a
    public Context getContext() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (Context) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.scope.a
    public final LifecycleOwner getLifeCycle() {
        Object r0 = this.f;
        if (r0 == null) goto L7;
        return (LifecycleOwner) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.scope.a
    public final i11.b getLinkUserCenter() {
        Object r0 = this.g;
        if (r0 == null) goto L7;
        return (i11.b) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenuelink.usercenter.IAnchorLinkUserCenter");
    }

    public final com.bytedance.android.scope.j r() {
        return this.h;
    }

    public e(u51.b r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.h = r2;
        Object r3 = k.a;
        this.e = r3;
        this.f = r3;
        this.g = r3;
    }
}
