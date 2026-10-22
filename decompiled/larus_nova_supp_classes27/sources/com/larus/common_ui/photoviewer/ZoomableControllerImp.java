package com.larus.common_ui.photoviewer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import j19.n;
import j19.o;
import j19.p;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import k19.d;
import k19.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public class ZoomableControllerImp extends com.larus.common_ui.photoviewer.a {
    public com.larus.common_ui.photoviewer.a.InterfaceC0013a A;
    public final RectF B;
    public boolean C;
    public final float[] o;
    public final float[] p;
    public final float[] q;
    public final Matrix r;
    public final Matrix s;
    public final Matrix t;
    public boolean u;
    public boolean v;
    public final ValueAnimator w;
    public long x;
    public final p y;
    public final Scroller z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LimitFlag {
    }

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ ZoomableControllerImp b;

        public final void a() {
            this.b.w.removeAllUpdateListeners();
            this.b.w.removeAllListeners();
            ZoomableControllerImp r0 = this.b;
            if (r0.u == false) goto L12;
            com.larus.common_ui.photoviewer.a.InterfaceC0013a r1 = r0.A;
            if (r1 == null) goto L11;
            r0.l.getValues(r0.n);
            if (r0.n[0] <= 1.001f) goto L9;
            boolean r2 = true;
        L10:
            r1.a(r2);
            goto L11
        L9:
            r2 = false;
        L11:
            this.b.u = false;
        L12:
            Runnable r3 = this.a;
            if (r3 == null) goto L16;
            r3.run();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
            a();
        }

        public a(ZoomableControllerImp r1, Runnable r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final boolean l() {
        if (this.w.isRunning() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.z.computeScrollOffset() == true) goto L8;
        return false;
    }

    public boolean n() {
        if (this.v == false) goto L24;
        e r0 = this.a;
        if (Math.abs(this.k.left - this.i.left) >= 0.001f) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L12;
        if (m() == true) goto L12;
    L15:
        if (Math.abs(this.k.right - this.i.right) >= 0.001f) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == true) goto L22;
        if (m() == false) goto L24;
    L22:
        if (r0.l != 1) goto L24;
        return true;
    L17:
        r3 = false;
    L12:
        if (r0.l != 3) goto L15;
        return true;
    L7:
        r2 = false;
    L24:
        return false;
    }

    public final void w() {
        if (this.w.isRunning() == false) goto L6;
        this.w.cancel();
        this.w.removeAllUpdateListeners();
        this.w.removeAllListeners();
        return;
    }

    public void x() {
        this.r.set(this.l);
        RectF r0 = this.i;
        if ((o(this.r, r0.centerX(), r0.centerY()) | p(this.r)) == false) goto L6;
        this.C = true;
        u(this.r, this.x, this.y, null);
        return;
    }

    public final boolean m() {
        if (l() == true) goto L17;
        this.l.getValues(this.n);
        float[] r0 = this.n;
        r0[0] = r0[0] - 1.0f;
        r0[4] = r0[4] - 1.0f;
        r0[8] = r0[8] - 1.0f;
        int r1 = 0;
    L6:
        if (r1 >= 9) goto L11;
        if (Math.abs(this.n[r1]) > 0.001f) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        r2 = true;
        goto L12
    L17:
        return false;
    }

    @Override // k19.b
    public /* bridge */ /* synthetic */ void onGestureBegin(e r1) {
        q(r1);
    }

    @Override // k19.b
    public /* bridge */ /* synthetic */ void onGestureEnd(e r1) {
        r(r1);
    }

    @Override // k19.b
    public /* bridge */ /* synthetic */ void onGestureUpdate(e r1) {
        s(r1);
    }

    public final boolean p(Matrix r11) {
        RectF r0 = this.B;
        RectF r1 = this.j;
        RectF r2 = this.i;
        r0.set(r1);
        r11.mapRect(r0);
        float r3 = k(r0.left, r0.right, r2.left, r2.right, r1.centerX());
        float r4 = k(r0.top, r0.bottom, r2.top, r2.bottom, r1.centerY());
        if (r3 == 0.0f) goto L5;
    L9:
        r11.postTranslate(r3, r4);
        return true;
    L5:
        if (r4 != 0.0f) goto L9;
        return false;
    }

    public void q(e r2) {
        if (this.C == false) goto L5;
        return;
    L5:
        w();
        if (this.z.computeScrollOffset() == false) goto L9;
        this.z.forceFinished(true);
        return;
    }

    public void r(e r4) {
        if (this.C == false) goto L6;
        return;
    L6:
        if (this.u == false) goto L16;
        com.larus.common_ui.photoviewer.a.InterfaceC0013a r5 = this.A;
        if (r5 == null) goto L14;
        this.l.getValues(this.n);
        if (this.n[0] <= 1.001f) goto L12;
        boolean r1 = true;
    L13:
        r5.a(r1);
        goto L14
    L12:
        r1 = false;
    L14:
        this.u = false;
        return;
    }

    public void s(e r7) {
        if (this.C == false) goto L6;
        return;
    L6:
        if (l() == false) goto L8;
        return;
    L8:
        boolean r1 = false;
        if (this.d == true) goto L11;
    L16:
        boolean r0 = false;
    L17:
        if (r0 == true) goto L19;
    L23:
        d r8 = r7.b;
        int r2 = r8.a;
        if (r2 == r8.b) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L33;
        if (r2 != 1) goto L30;
        boolean r10 = true;
    L31:
        if (r10 == false) goto L33;
        x();
        return;
    L30:
        r10 = false;
    L33:
        Matrix r11 = this.l;
        e r3 = this.a;
        r11.set(r11);
        if (this.e == false) goto L37;
        r11.postTranslate(r3.i, r3.j);
    L37:
        if (this.d == false) goto L45;
        if (r3.b.a <= 1) goto L41;
        boolean r4 = true;
    L42:
        if (r4 == false) goto L45;
        float r5 = r3.k;
        r11.postScale(r5, r5, r3.g, r3.h);
        goto L45
    L41:
        r4 = false;
    L45:
        if (r3.b.a != 1) goto L47;
        r1 = true;
    L47:
        if (r1 == false) goto L49;
    L50:
        p(r11);
    L51:
        d();
        return;
    L49:
        if (this.d == true) goto L51;
    L26:
        r9 = false;
        goto L27
    L19:
        if (this.u == true) goto L23;
        this.u = true;
        com.larus.common_ui.photoviewer.a.InterfaceC0013a r6 = this.A;
        if (r6 == null) goto L23;
        r6.b();
        goto L23
    L11:
        if (r7.b.a <= 1) goto L13;
        boolean r12 = true;
    L14:
        if (r12 == false) goto L16;
        r0 = true;
        goto L17
    L13:
        r12 = false;
        goto L14
    }

    public final boolean t(MotionEvent r5) {
        if (r5.getAction() != 3) goto L10;
        if (this.c == false) goto L7;
        this.a.b(r5);
        return true;
    L7:
        return false;
    L10:
        if (n() == false) goto L13;
        return false;
    L13:
        if (this.c == false) goto L15;
        this.a.b(r5);
        return true;
    L15:
        return false;
    }

    public final void v(Matrix r2) {
        if (this.w.isRunning() == false) goto L5;
        w();
    L5:
        this.s.set(r2);
        this.l.set(r2);
        d();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [j19.p] */
    public ZoomableControllerImp(e r3, Context r4) {
        super(r3);
        this.o = new float[9];
        this.p = new float[9];
        this.q = new float[9];
        this.r = new Matrix();
        this.s = new Matrix();
        this.t = new Matrix();
        this.u = false;
        this.v = false;
        this.x = 400;
        this.y = new p(this);
        this.B = new RectF();
        this.C = false;
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.w = r5;
        r5.setInterpolator(new DecelerateInterpolator(1.2f));
        this.z = new Scroller(r4);
    }

    public final void j(Matrix r3, float r4, PointF r5) {
        PointF r6 = a(r5);
        r3.setScale(r4, r4, r6.x, r6.y);
        o(r3, r6.x, r6.y);
        p(r3);
    }

    public final boolean o(Matrix r6, float r7, float r8) {
        r6.getValues(this.n);
        float r0 = this.n[0];
        float r2 = Math.max(this.f, r0);
        float r3 = this.g;
        if (r3 != 0.0f) goto L5;
        r3 = this.h;
    L5:
        float r4 = Math.min(r2, r3);
        if (r4 == r0) goto L9;
        float r5 = r4 / r0;
        r6.postScale(r5, r5, r7, r8);
        return true;
    L9:
        return false;
    }

    public final void u(Matrix r2, long r3, Runnable r5, final ValueAnimator.AnimatorUpdateListener r6) {
        if (this.w.isRunning() == false) goto L5;
        w();
    L5:
        this.w.setDuration(r3);
        this.l.getValues(this.o);
        r2.getValues(this.p);
        this.w.addUpdateListener(new o(this, r6));
        this.w.addListener(new a(this, r5));
        this.w.start();
    }

    public void y(float r7, PointF r8, Runnable r9, ValueAnimator.AnimatorUpdateListener r10) {
        if (this.d == true) goto L6;
        return;
    L6:
        if (this.w.isRunning() == false) goto L9;
        w();
    L9:
        if (this.u == true) goto L13;
        this.u = true;
        com.larus.common_ui.photoviewer.a.InterfaceC0013a r11 = this.A;
        if (r11 == null) goto L13;
        r11.b();
    L13:
        this.C = true;
        Runnable r4 = new n(this);
        this.r.reset();
        j(this.r, r7, r8);
        u(this.r, this.x, r4, null);
    }

    public final float k(float r5, float r6, float r7, float r8, float r9) {
        float r0 = r6 - r5;
        float r1 = r8 - r7;
        if (r0 >= (Math.min(r9 - r7, r8 - r9) * 2.0f)) goto L7;
        return r9 - ((r6 + r5) / 2.0f);
    L7:
        if (r0 >= r1) goto L15;
        if (r9 >= ((r7 + r8) / 2.0f)) goto L13;
        return r7 - r5;
    L13:
        return r8 - r6;
    L15:
        if (r5 <= r7) goto L19;
        return r7 - r5;
    L19:
        if (r6 < r8) goto L21;
        return 0.0f;
    L21:
        return r8 - r6;
    }
}
