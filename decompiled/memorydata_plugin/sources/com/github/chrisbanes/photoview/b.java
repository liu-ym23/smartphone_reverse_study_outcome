package com.github.chrisbanes.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3727b;
    private final ScaleGestureDetector c;
    private VelocityTracker d;
    private boolean e;
    private float f;
    private float g;
    private final float h;
    private final float i;
    private c j;

    b(Context r3, c r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        this.f3726a = -1;
        this.f3727b = 0;
        ViewConfiguration r0 = ViewConfiguration.get(r5);
        this.i = r0.getScaledMinimumFlingVelocity();
        this.h = r0.getScaledTouchSlop();
        this.j = r6;
        this.c = new ScaleGestureDetector(r5, new AnonymousClass1(this));
    }

    static /* synthetic */ c a(b r0) {
        return r0.j;
    }

    private float b(MotionEvent r1) {
        return r1.getX(this.f3727b);
    L5:
        return r1.getX();
    }

    private float c(MotionEvent r1) {
        return r1.getY(this.f3727b);
    L5:
        return r1.getY();
    }

    private boolean d(MotionEvent r12) {
        int r0 = r12.getAction() & 255;
        int r3 = 0;
        if (r0 != 0) goto L5;
        this.f3726a = r12.getPointerId(0);
        VelocityTracker r1 = VelocityTracker.obtain();
        this.d = r1;
        if (r1 == null) goto L47;
        r1.addMovement(r12);
    L47:
        this.f = b(r12);
        this.g = c(r12);
        this.e = false;
    L48:
        int r2 = this.f3726a;
        if (r2 == (-1)) goto L51;
        r3 = r2;
    L51:
        this.f3727b = r12.findPointerIndex(r3);
        return true;
    L5:
        if (r0 != 1) goto L7;
        this.f3726a = -1;
        if (this.e == true) goto L37;
    L41:
        VelocityTracker r4 = this.d;
        if (r4 == null) goto L48;
    L21:
        r4.recycle();
        this.d = null;
        goto L48
    L37:
        if (this.d == null) goto L41;
        this.f = b(r12);
        this.g = c(r12);
        this.d.addMovement(r12);
        this.d.computeCurrentVelocity(1000);
        float r5 = this.d.getXVelocity();
        float r6 = this.d.getYVelocity();
        if (Math.max(Math.abs(r5), Math.abs(r6)) < this.i) goto L41;
        this.j.a(this.f, this.g, -r5, -r6);
        goto L41
    L7:
        if (r0 != 2) goto L9;
        float r7 = b(r12);
        float r8 = c(r12);
        float r9 = r7 - this.f;
        float r10 = r8 - this.g;
        if (this.e == true) goto L30;
        if (Math.sqrt((r9 * r9) + (r10 * r10)) < this.h) goto L27;
        boolean r11 = true;
    L28:
        this.e = r11;
        goto L30
    L27:
        r11 = false;
    L30:
        if (this.e == false) goto L48;
        this.j.a(r9, r10);
        this.f = r7;
        this.g = r8;
        VelocityTracker r13 = this.d;
        if (r13 == null) goto L48;
        r13.addMovement(r12);
        goto L48
    L9:
        if (r0 != 3) goto L11;
        this.f3726a = -1;
        r4 = this.d;
        if (r4 == null) goto L48;
    L11:
        if (r0 != 6) goto L48;
        int r14 = l.a(r12.getAction());
        if (r12.getPointerId(r14) != this.f3726a) goto L48;
        if (r14 != 0) goto L17;
        int r15 = 1;
    L18:
        this.f3726a = r12.getPointerId(r15);
        this.f = r12.getX(r15);
        this.g = r12.getY(r15);
        goto L48
    L17:
        r15 = 0;
        goto L18
    }

    public boolean a() {
        return this.c.isInProgress();
    }

    public boolean a(MotionEvent r2) {
        this.c.onTouchEvent(r2);     // Catch: IllegalArgumentException -> L4
        return d(r2);
    L4:
        return true;
    }

    public boolean b() {
        return this.e;
    }
}
