package com.lynx.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import m6a.f;
import m6a.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BezierRadarHeader extends p6a.b implements f {
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public final boolean i;
    public final Path j;
    public final Paint k;
    public int l;
    public int m;
    public int n;
    public int o;
    public float p;
    public float q;
    public final float r;
    public float s;
    public int t;
    public final float u;
    public final float v;
    public float w;
    public Animator x;
    public final RectF y;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RefreshState.values().length];
            a = r0;
            r0[RefreshState.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[RefreshState.PullDownToRefresh.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final byte a;
        public final /* synthetic */ BezierRadarHeader b;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            byte r0 = this.a;
            if (r0 != 0) goto L6;
            BezierRadarHeader r1 = this.b;
            r1.w = ((Float) r4.getAnimatedValue()).floatValue();
        L20:
            this.b.invalidate();
            return;
        L6:
            if (1 != r0) goto L12;
            BezierRadarHeader r2 = this.b;
            if (r2.h == false) goto L11;
            r4.cancel();
            return;
        L11:
            r2.m = ((Integer) r4.getAnimatedValue()).intValue() / 2;
            goto L20
        L12:
            if (2 != r0) goto L15;
            BezierRadarHeader r3 = this.b;
            r3.p = ((Float) r4.getAnimatedValue()).floatValue();
            goto L20
        L15:
            if (3 != r0) goto L18;
            BezierRadarHeader r5 = this.b;
            r5.s = ((Float) r4.getAnimatedValue()).floatValue();
            goto L20
        L18:
            if (4 != r0) goto L20;
            BezierRadarHeader r6 = this.b;
            r6.t = ((Integer) r4.getAnimatedValue()).intValue();
            goto L20
        }

        public b(BezierRadarHeader r1, byte r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator r0 = this.x;
        if (r0 == null) goto L6;
        r0.removeAllListeners();
        this.x.end();
        this.x = null;
        return;
    }

    @Override // p6a.b, m6a.g
    public final boolean a() {
        return this.i;
    }

    public BezierRadarHeader(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r21) {
        int r1 = getWidth();
        if (isInEditMode() == false) goto L5;
        int r2 = getHeight();
    L6:
        int r8 = r2;
        this.j.reset();
        this.j.lineTo(0.0f, this.l);
        Path r3 = this.j;
        int r4 = this.n;
        float r10 = 2.0f;
        if (r4 < 0) goto L9;
        float r5 = r4;
    L10:
        int r6 = this.l;
        float r11 = r1;
        r3.quadTo(r5, this.m + r6, r11, r6);
        this.j.lineTo(r11, 0.0f);
        this.k.setColor(this.e);
        r21.drawPath(this.j, this.k);
        if (this.p <= 0.0f) goto L26;
        this.k.setColor(this.d);
        float r7 = r8;
        float r9 = r7 / r6a.b.b;
        float r12 = 1.0f;
        float r13 = 7.0f;
        float r14 = (r11 * 1.0f) / 7.0f;
        float r15 = this.q;
        float r16 = r14 * r15;
        if (r15 <= 1.0f) goto L15;
        float r17 = ((r15 - 1.0f) * r14) / r15;
    L16:
        float r18 = r16 - r17;
        if (r15 <= 1.0f) goto L19;
        float r19 = (((r15 - 1.0f) * r7) / 2.0f) / r15;
    L20:
        float r20 = r7 - r19;
        int r22 = 0;
    L22:
        if (r22 >= 7) goto L24;
        float r23 = (r22 + r12) - 4.0f;
        this.k.setAlpha((int) (((double) (this.p * ((r12 - ((Math.abs(r23) / r13) * r10)) * 255.0f))) * (1.0d - (1.0d / Math.pow((((double) r9) / 800.0d) + 1.0d, 15.0d)))));
        float r24 = this.r * (1.0f - (1.0f / ((r9 / 10.0f) + 1.0f)));
        r21.drawCircle(((r11 / 2.0f) - (r24 / 2.0f)) + (r18 * r23), r20 / 2.0f, r24, this.k);
        r22 = r22 + 1;
        r12 = 1.0f;
        r13 = 7.0f;
        r10 = 2.0f;
        goto L22
    L24:
        this.k.setAlpha(255);
        goto L26
    L19:
        r19 = 0.0f;
        goto L20
    L15:
        r17 = 0.0f;
    L26:
        if (this.x == null) goto L28;
    L29:
        float r25 = this.u;
        float r26 = this.w;
        float r27 = r25 * r26;
        float r28 = this.v * r26;
        this.k.setColor(this.d);
        this.k.setStyle(Paint.Style.FILL);
        float r29 = r11 / 2.0f;
        float r110 = r8 / 2.0f;
        r21.drawCircle(r29, r110, r27, this.k);
        this.k.setStyle(Paint.Style.STROKE);
        float r111 = r28 + r27;
        r21.drawCircle(r29, r110, r111, this.k);
        this.k.setColor((this.e & 16777215) | 1426063360);
        this.k.setStyle(Paint.Style.FILL);
        this.y.set(r29 - r27, r110 - r27, r29 + r27, r27 + r110);
        r21.drawArc(this.y, 270.0f, this.t, true, this.k);
        this.k.setStyle(Paint.Style.STROKE);
        this.y.set(r29 - r111, r110 - r111, r29 + r111, r110 + r111);
        r21.drawArc(this.y, 270.0f, this.t, false, this.k);
        this.k.setStyle(Paint.Style.FILL);
    L31:
        if (this.s <= 0.0f) goto L33;
        this.k.setColor(this.d);
        r21.drawCircle(r11 / 2.0f, r8 / 2.0f, this.s, this.k);
    L33:
        super.dispatchDraw(r21);
        return;
    L28:
        if (isInEditMode() == false) goto L31;
    L9:
        r5 = r1 / 2.0f;
        goto L10
    L5:
        r2 = this.o;
        goto L6
    }

    @Override // p6a.b, m6a.g
    public void setPrimaryColors(int... r4) {
        if (r4.length <= 0) goto L8;
        if (this.f == true) goto L8;
        this.e = r4[0];
        this.f = false;
    L8:
        if (r4.length > 1) goto L10;
        return;
    L10:
        if (this.g == true) goto L14;
        this.d = r4[1];
        this.g = false;
        return;
    }

    public BezierRadarHeader(Context r8, AttributeSet r9) {
        super(r8, r9, 0);
        this.i = false;
        this.n = -1;
        this.o = 0;
        this.t = 0;
        this.u = 0.0f;
        this.v = 0.0f;
        this.w = 0.0f;
        this.y = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.b = n6a.b.e;
        this.j = new Path();
        Paint r3 = new Paint();
        this.k = r3;
        r3.setAntiAlias(true);
        this.r = r6a.b.c(7.0f);
        this.u = r6a.b.c(20.0f);
        this.v = r6a.b.c(7.0f);
        r3.setStrokeWidth(r6a.b.c(3.0f));
        setMinimumHeight(r6a.b.c(100.0f));
        if (isInEditMode() == false) goto L5;
        this.l = 1000;
        this.w = 1.0f;
        this.t = 270;
    L6:
        TypedArray r10 = r8.obtainStyledAttributes(r9, new int[]{2130974146, 2130974165, 2130974196});
        this.i = r10.getBoolean(1, false);
        this.d = r10.getColor(0, -1);
        this.g = true;
        this.e = r10.getColor(2, -14540254);
        this.f = true;
        this.g = r10.hasValue(0);
        this.f = r10.hasValue(2);
        r10.recycle();
        return;
    L5:
        this.w = 0.0f;
        goto L6
    }

    @Override // p6a.b, m6a.g
    public final int e(SmartRefreshLayout r3, boolean r4) {
        Animator r5 = this.x;
        if (r5 == null) goto L5;
        r5.removeAllListeners();
        this.x.end();
        this.x = null;
    L5:
        int r6 = getWidth();
        int r7 = this.o;
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{this.u, (float) Math.sqrt((r6 * r6) + (r7 * r7))});
        r8.setDuration(400);
        r8.addUpdateListener(new b(this, (byte) 3));
        r8.start();
        return 400;
    }

    @Override // p6a.b, m6a.g
    public final void d(float r1, int r2, int r3) {
        this.n = r2;
        invalidate();
    }

    @Override // p6a.b, q6a.e
    public final void i(i r1, RefreshState r2, RefreshState r3) {
        int r4 = a.a[r3.ordinal()];
        if (r4 != 1) goto L5;
    L7:
        this.p = 1.0f;
        this.w = 0.0f;
        this.s = 0.0f;
        return;
    L5:
        if (r4 == 2) goto L7;
    }

    @Override // p6a.b, m6a.g
    public final void k(i r8, int r9, int r10) {
        this.l = r9 - 1;
        this.h = false;
        r6a.b r11 = new r6a.b(1);
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r1.setInterpolator(r11);
        r1.addUpdateListener(new b(this, (byte) 2));
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.setInterpolator(r11);
        r2.addUpdateListener(new b(this, (byte) 0));
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{0, 360});
        r12.setDuration(720);
        r12.setRepeatCount(-1);
        r12.setInterpolator(new AccelerateDecelerateInterpolator());
        r12.addUpdateListener(new b(this, (byte) 4));
        AnimatorSet r3 = new AnimatorSet();
        r3.playSequentially(new Animator[]{r1, r2, r12});
        r3.start();
        int r4 = this.m;
        float r5 = r4;
        ValueAnimator r13 = ValueAnimator.ofInt(new int[]{r4, 0, -((int) (0.8f * r5)), 0, -((int) (r5 * 0.4f)), 0});
        r13.addUpdateListener(new b(this, (byte) 1));
        r13.setInterpolator(new r6a.b(1));
        r13.setDuration(800);
        r13.start();
        this.x = r3;
    }

    @Override // p6a.b, m6a.g
    public final void b(boolean r1, float r2, int r3, int r4, int r5) {
        this.o = r3;
        if (r1 == false) goto L5;
    L6:
        this.h = true;
        this.l = Math.min(r4, r3);
        this.m = (int) (Math.max(0, r3 - r4) * 1.9f);
        this.q = r2;
        invalidate();
        return;
    L5:
        if (this.h == true) goto L6;
    }
}
