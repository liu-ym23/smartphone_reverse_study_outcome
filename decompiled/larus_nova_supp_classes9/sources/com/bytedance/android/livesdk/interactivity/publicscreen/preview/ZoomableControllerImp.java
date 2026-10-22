package com.bytedance.android.livesdk.interactivity.publicscreen.preview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class ZoomableControllerImp extends a {
    public final float[] k;
    public final float[] l;
    public final float[] m;
    public final Matrix n;
    public final Matrix o;
    public final Matrix p;
    public final ValueAnimator q;
    public final long r;
    public final i s;
    public final Scroller t;
    public final RectF u;
    public boolean v;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LimitFlag {
    }

    public final void j() {
        if (this.q.isRunning() == false) goto L6;
        this.q.cancel();
        this.q.removeAllUpdateListeners();
        this.q.removeAllListeners();
        return;
    }

    public final boolean e(Matrix r9) {
        RectF r0 = this.u;
        RectF r1 = this.f;
        RectF r2 = this.e;
        r0.set(r1);
        r9.mapRect(r0);
        float r3 = d(r0.left, r0.right, r2.left, r2.right, r1.centerX());
        float r4 = d(r0.top, r0.bottom, r2.top, r2.bottom, r1.centerY());
        if (r3 == 0.0f) goto L5;
    L9:
        r9.postTranslate(r3, r4);
        return true;
    L5:
        if (r4 != 0.0f) goto L9;
        return false;
    }

    public void f(ba2.e r2) {
        if (this.v == false) goto L5;
        return;
    L5:
        j();
        if (this.t.computeScrollOffset() == false) goto L9;
        this.t.forceFinished(true);
        return;
    }

    public void g(ba2.e r10) {
        if (this.v == false) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        boolean r1 = false;
        if (this.q.isRunning() == false) goto L10;
    L13:
        boolean r0 = true;
    L14:
        if (r0 == false) goto L16;
        return;
    L16:
        ba2.d r11 = r10.b;
        int r2 = r11.a;
        if (r2 == r11.b) goto L19;
        boolean r13 = true;
    L20:
        if (r13 == false) goto L31;
        if (r2 != 1) goto L23;
        boolean r14 = true;
    L24:
        if (r14 == false) goto L31;
        this.n.set(this.h);
        RectF r15 = this.e;
        Matrix r3 = this.n;
        float r4 = r15.centerX();
        float r16 = r15.centerY();
        r3.getValues(this.j);
        float r5 = this.j[0];
        float r6 = Math.min(Math.max(1.0f, r5), this.d);
        if (r6 == r5) goto L29;
        float r7 = r6 / r5;
        r3.postScale(r7, r7, r4, r16);
        r1 = true;
    L29:
        if ((e(this.n) | r1) == false) goto L45;
        this.v = true;
        i(this.n, this.r, this.s, null);
        return;
    L45:
        return;
    L23:
        r14 = false;
    L31:
        Matrix r17 = this.h;
        ba2.e r8 = this.a;
        r17.set(r17);
        r17.postTranslate(r8.i, r8.j);
        if (r8.b.a <= 1) goto L34;
        boolean r9 = true;
    L35:
        if (r9 == false) goto L38;
        float r18 = r8.k;
        r17.postScale(r18, r18, r8.g, r8.h);
    L38:
        if (r8.b.a != 1) goto L40;
        r1 = true;
    L40:
        if (r1 == false) goto L43;
        e(r17);
    L43:
        a();
        return;
    L34:
        r9 = false;
        goto L35
    L19:
        r13 = false;
        goto L20
    L10:
        if (this.t.computeScrollOffset() == true) goto L13;
        r0 = false;
        goto L14
    }

    public final boolean h(MotionEvent r9) {
        int r0 = 0;
        if (r9 != null) goto L6;
        return false;
    L6:
        if (this.c == false) goto L53;
        ba2.e r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "event");
        ba2.d r2 = r1.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "event");
        int r3 = r9.getActionMasked();
        if (r3 == 0) goto L44;
        if (r3 != 1) goto L11;
        r2.b(r9);
        if (r2.a != 0) goto L41;
        r2.a();
    L48:
        return true;
    L41:
        ba2.b<ba2.d> r10 = r2.j;
        if (r10 == null) goto L48;
        r10.onGestureUpdate(r2);
        goto L48
    L11:
        if (r3 != 2) goto L13;
        r2.b = r2.a;
    L30:
        if (r0 >= 2) goto L35;
        int r4 = r9.findPointerIndex(r2.c[r0]);
        if (r4 == (-1)) goto L34;
        float[] r5 = r2.h;
        float[] r6 = r2.f;
        r5[r0] = r6[r0];
        r2.i[r0] = r2.g[r0];
        r6[r0] = r9.getX(r4);
        r2.g[r0] = r9.getY(r4);
    L34:
        r0 = r0 + 1;
        goto L30
    L35:
        ba2.b<ba2.d> r11 = r2.j;
        if (r11 == null) goto L48;
        r11.onGestureUpdate(r2);
        goto L48
    L13:
        if (r3 != 3) goto L15;
        r2.a();
        goto L48
    L15:
        if (r3 != 5) goto L17;
        r2.b(r9);
        ba2.b<ba2.d> r13 = r2.j;
        if (r13 == null) goto L48;
        r13.onGestureUpdate(r2);
        goto L48
    L17:
        if (r3 != 6) goto L48;
        r2.b(r9);
        if (r2.a != 0) goto L22;
        r2.a();
        goto L48
    L22:
        ba2.b<ba2.d> r14 = r2.j;
        if (r14 == null) goto L48;
        r14.onGestureUpdate(r2);
        goto L48
    L44:
        ba2.b<ba2.d> r7 = r2.j;
        if (r7 == null) goto L47;
        r7.onGestureBegin(r2);
    L47:
        r2.b(r9);
        goto L48
    L53:
        return false;
    }

    @Override // ba2.b
    public /* bridge */ /* synthetic */ void onGestureBegin(ba2.e r1) {
        f(r1);
    }

    @Override // ba2.b
    public /* bridge */ /* synthetic */ void onGestureUpdate(ba2.e r1) {
        g(r1);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.bytedance.android.livesdk.interactivity.publicscreen.preview.i] */
    public ZoomableControllerImp(ba2.e r3, Context r4) {
        super(r3);
        this.k = new float[9];
        this.l = new float[9];
        this.m = new float[9];
        this.n = new Matrix();
        this.o = new Matrix();
        this.p = new Matrix();
        this.r = 400;
        this.s = new i(this);
        this.u = new RectF();
        this.v = false;
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.q = r5;
        r5.setInterpolator(new DecelerateInterpolator(1.2f));
        this.t = new Scroller(r4);
    }

    public final void i(Matrix r2, long r3, Runnable r5, final ca2.c.b r6) {
        if (this.q.isRunning() == false) goto L5;
        j();
    L5:
        this.q.setDuration(r3);
        this.h.getValues(this.k);
        r2.getValues(this.l);
        this.q.addUpdateListener(new g(this, r6));
        this.q.addListener(new j(this, r5));
        this.q.start();
    }

    public static float d(float r4, float r5, float r6, float r7, float r8) {
        float r0 = r5 - r4;
        float r1 = r7 - r6;
        if (r0 >= (Math.min(r8 - r6, r7 - r8) * 2.0f)) goto L7;
        return r8 - ((r5 + r4) / 2.0f);
    L7:
        if (r0 >= r1) goto L15;
        if (r8 >= ((r6 + r7) / 2.0f)) goto L13;
        return r6 - r4;
    L13:
        return r7 - r5;
    L15:
        if (r4 <= r6) goto L19;
        return r6 - r4;
    L19:
        if (r5 < r7) goto L21;
        return 0.0f;
    L21:
        return r7 - r5;
    }
}
