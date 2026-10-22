package com.bytedance.android.livesdk.chatroom.vs_base.base;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.DataCenter;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends j implements b, h<mm1.a> {
    public Object e;
    public Object f;
    public Object g;
    public Object h;
    public Object i;
    public final mm1.a j;

    public final String toString() {
        return "com.bytedance.android.livesdk.chatroom.vs_base.base.__ScopeImpl_ReplayFragmentScope";
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final FragmentActivity b() {
        return (FragmentActivity) this.h;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final int g() {
        Object r0 = this.g;
        if (r0 == null) goto L7;
        return ((Integer) r0).intValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final Bundle getArguments() {
        return (Bundle) this.i;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final DataCenter getDataCenter() {
        Object r0 = this.f;
        if (r0 == null) goto L7;
        return (DataCenter) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.DataCenter");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final hq1.a z() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (hq1.a) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.vs_base.base.listener.IReplayPlayFragment");
    }

    public final com.bytedance.android.scope.j r() {
        return this.j;
    }

    public d(mm1.a r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.j = r2;
        Object r3 = k.a;
        this.e = r3;
        this.f = r3;
        this.g = r3;
        this.h = r3;
        this.i = r3;
    }
}
