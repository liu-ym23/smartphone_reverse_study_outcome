package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VSPlayerService$createGestureViewManager$manager$1 extends ko1.b {
    public final /* synthetic */ bq1.a n;
    public final /* synthetic */ View o;
    public final /* synthetic */ ViewGroup p;

    @Override // ko1.b, ko1.c
    public final boolean b(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "resetType");
        return this.n.c(r3, new VSPlayerService$createGestureViewManager$manager$1$resetPlayerView$1(this, r3));
    }

    @Override // ko1.b, ko1.c
    public final boolean c(final MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        return this.n.a(r3, new VSPlayerService$createGestureViewManager$manager$1$handleOnTouchEvent$1(this, r3));
    }

    @Override // ko1.b
    public final void d(boolean r3) {
        this.n.b(r3, new VSPlayerService$createGestureViewManager$manager$1$isInZoomStateChange$1(this));
    }

    public static final /* synthetic */ boolean f(VSPlayerService$createGestureViewManager$manager$1 r0, MotionEvent r1) {
        return super.c(r1);
    }

    public static final /* synthetic */ void g(VSPlayerService$createGestureViewManager$manager$1 r0, boolean r1) {
        super.d(r1);
    }

    public static final /* synthetic */ boolean h(VSPlayerService$createGestureViewManager$manager$1 r0, String r1) {
        return super.b(r1);
    }

    public VSPlayerService$createGestureViewManager$manager$1(com.bytedance.android.livesdk.chatroom.vs.gesture.g r7, View r8, ViewGroup r9, Context r10, View r11, ViewGroup r12) {
        this.n = r7;
        this.o = r8;
        this.p = r9;
        super(r10, r11, r12, null, null);
    }
}
