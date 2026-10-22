package com.lynx.tasm.behavior;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f10254m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f10255n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bb.b f10257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ym.o f10258c;
    public final ym.o d;
    public boolean e;
    public boolean f;
    public MotionEvent g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MotionEvent f10259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f10260i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f10261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f10262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f10263l;

    static {
        f10254m = ViewConfiguration.getLongPressTimeout();
        f10255n = ViewConfiguration.getTapTimeout();
    }

    public h(com.lynx.tasm.b0 r5, ym.o r10, Handler r11) {
        if (r5 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        this.f10257b = new bb.b(this, r11);
        this.f10258c = r10;
        this.d = r10;
        this.f10262k = true;
        this.f10263l = r12;
        if (r5 != null) goto L11;
        int r13 = ViewConfiguration.getTouchSlop();
    L12:
        this.f10256a = r13 * r13;
        return;
    L11:
        r13 = ViewConfiguration.get(r5).getScaledTouchSlop();
        goto L12
    L5:
        if (r5.getApplicationInfo().targetSdkVersion < 8) goto L7;
        r12 = true;
        goto L8
    }
}
