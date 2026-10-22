package com.bytedance.android.livesdk.chatroom.vs_base.base;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.DataCenter;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends j implements c, h<b> {
    public Object e;
    public Object f;
    public Object g;
    public final hq1.a h;
    public final DataCenter i;
    public final Object j;
    public final FragmentActivity k;
    public final Object l;
    public final b m;

    public final String toString() {
        return "com.bytedance.android.livesdk.chatroom.vs_base.base.__ScopeImpl_ReplayInteractionFragmentScope";
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.c
    public final zq1.a E() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (zq1.a) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.vs_base.interact.video.IReplayInteractionFragment");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final int g() {
        Object r0 = this.j;
        if (r0 == null) goto L7;
        return ((Integer) r0).intValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final Bundle getArguments() {
        return (Bundle) this.l;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final DataCenter getDataCenter() {
        DataCenter r0 = this.i;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.DataCenter");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final hq1.a z() {
        hq1.a r0 = this.h;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.vs_base.base.listener.IReplayPlayFragment");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final FragmentActivity b() {
        return this.k;
    }

    public final com.bytedance.android.scope.j r() {
        return this.m;
    }

    public e(b r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.m = r2;
        Object r0 = k.a;
        this.e = r0;
        this.f = r0;
        this.g = r0;
        this.h = r2.z();
        this.i = r2.getDataCenter();
        this.j = Integer.valueOf(r2.g());
        this.k = r2.b();
        this.l = r2.getArguments();
    }
}
