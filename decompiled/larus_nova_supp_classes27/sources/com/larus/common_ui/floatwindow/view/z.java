package com.larus.common_ui.floatwindow.view;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z {
    public final SingleFloatBall a;
    public View.OnClickListener b;
    public final int c;
    public final int d;
    public float e;
    public float f;
    public int g;
    public long h;
    public boolean i;

    public z(SingleFloatBall r2) {
        Intrinsics.checkNotNullParameter(r2, "ball");
        this.a = r2;
        ViewConfiguration r3 = ViewConfiguration.get(r2.getContext());     // Catch: Exception -> L5
        int r0 = r3.getScaledTouchSlop() * r3.getScaledTouchSlop();
    L6:
        this.c = r0;
        this.d = ViewConfiguration.getTapTimeout();
        return;
    L5:
        r0 = 576;
        goto L6
    }

    public final void a(View r3, MotionEvent r4) {
        this.e = r4.getRawX();
        this.f = r4.getRawY();
        ViewParent r5 = r3.getParent();
        boolean r0 = r5 instanceof ViewGroup;
        if (r0 == false) goto L5;
        int r1 = ((ViewGroup) r5).getWidth();
    L6:
        this.g = r1;
        if (r0 == false) goto L9;
        ((ViewGroup) r5).getHeight();
    L11:
        if (this.b == null) goto L13;
        this.h = SystemClock.uptimeMillis();
    L13:
        this.i = false;
        return;
    L9:
        int r6 = com.larus.utils.m0.a;
        com.larus.utils.m0.a(r3.getContext());
        goto L11
    L5:
        r1 = com.larus.utils.i.d(r3.getContext());
        goto L6
    }
}
