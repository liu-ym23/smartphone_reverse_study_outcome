package com.bytedance.android.livesdk.chatroom.vs.gesture;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VSGestureViewManagerHelper$createSaasGestureManager$1 extends b {
    public final /* synthetic */ View l;
    public final /* synthetic */ ViewGroup m;

    @Override // com.bytedance.android.livesdk.chatroom.vs.gesture.b, ko1.c
    public final boolean b(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "resetType");
        ko1.c r0 = VSGestureViewManagerHelper.a;
        g r1 = VSGestureViewManagerHelper.b;
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.c(r3, new VSGestureViewManagerHelper$createSaasGestureManager$1$resetPlayerView$1(this, r3));
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs.gesture.b, ko1.c
    public final boolean c(final MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        ko1.c r0 = VSGestureViewManagerHelper.a;
        g r1 = VSGestureViewManagerHelper.b;
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.a(r3, new VSGestureViewManagerHelper$createSaasGestureManager$1$handleOnTouchEvent$1(this, r3));
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs.gesture.b
    public final void d(boolean r3) {
        ko1.c r0 = VSGestureViewManagerHelper.a;
        g r1 = VSGestureViewManagerHelper.b;
        if (r1 == null) goto L6;
        r1.b(r3, new VSGestureViewManagerHelper$createSaasGestureManager$1$isInZoomStateChange$1(this));
        return;
    }

    public static final /* synthetic */ boolean e(VSGestureViewManagerHelper$createSaasGestureManager$1 r0, MotionEvent r1) {
        return super.c(r1);
    }

    public static final /* synthetic */ boolean f(VSGestureViewManagerHelper$createSaasGestureManager$1 r0, String r1) {
        return super.b(r1);
    }

    public VSGestureViewManagerHelper$createSaasGestureManager$1(View r1, ViewGroup r2, Context r3, View r4, ViewGroup r5) {
        this.l = r1;
        this.m = r2;
        super(r3, r4, r5);
    }
}
