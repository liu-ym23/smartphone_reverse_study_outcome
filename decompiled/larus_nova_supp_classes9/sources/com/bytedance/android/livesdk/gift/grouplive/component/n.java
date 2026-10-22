package com.bytedance.android.livesdk.gift.grouplive.component;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n extends e33.j implements k, e33.h<i12.e> {
    public final Object e;
    public final DataCenter f;
    public final Object g;
    public final com.bytedance.android.livesdk.revenue.room.a h;
    public final i12.g i;
    public final i12.e j;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.grouplive.component.__ScopeImpl_GroupScope";
    }

    public final void I() {
        Object r0 = e33.k.a;
        if (this.e != r0) goto L6;
        String r1 = "context";
    L18:
        if (r1 != null) goto L21;
        return;
    L21:
        throw new UninitializedPropertyAccessException(r1);
    L6:
        if (this.f != r0) goto L9;
        r1 = "dataCenter";
        goto L18
    L9:
        if (this.g != r0) goto L12;
        r1 = "isInLive";
        goto L18
    L12:
        if (this.h != r0) goto L15;
        r1 = "roomContext";
        goto L18
    L15:
        if (this.i != r0) goto L17;
        r1 = "roomInstance";
        goto L18
    L17:
        r1 = null;
        goto L18
    }

    @Override // com.bytedance.android.livesdk.gift.grouplive.component.k, i12.e
    public Context getContext() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (Context) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // i12.e
    public final DataCenter getDataCenter() {
        DataCenter r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.DataCenter");
    }

    @Override // i12.e
    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        com.bytedance.android.livesdk.revenue.room.a r0 = this.h;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.revenue.room.IRevRoomContext");
    }

    @Override // i12.e
    public final i12.g i() {
        i12.g r0 = this.i;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.scope.IJsLiveRoomInstance");
    }

    @Override // i12.e
    public final boolean m() {
        Object r0 = this.g;
        if (r0 == null) goto L7;
        return ((Boolean) r0).booleanValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final com.bytedance.android.scope.j r() {
        return this.j;
    }

    public n(i12.e r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.j = r2;
        Object r0 = e33.k.a;
        this.e = r2.getContext();
        this.f = r2.getDataCenter();
        this.g = Boolean.valueOf(r2.m());
        this.h = r2.getRoomContext();
        this.i = r2.i();
    }
}
