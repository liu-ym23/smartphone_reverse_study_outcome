package kba;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o extends View {
    public static final float[] s = null;
    public static final float[] t = null;
    public static final PathInterpolator u = null;
    public static final PathInterpolator v = null;
    public final Paint a;
    public float b;
    public long c;
    public float[][] d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public boolean j;
    public boolean k;
    public long l;
    public float m;
    public boolean n;
    public final ArrayDeque<Float> o;
    public AnimatorSet p;
    public AnimatorSet q;
    public final ValueAnimator r;

    public static final class a {
    }

    public final void e() {
        this.j = false;
        this.r.cancel();
        this.o.clear();
        AnimatorSet r1 = this.p;
        this.p = null;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        AnimatorSet r2 = this.q;
        this.q = null;
        if (r2 == null) goto L8;
        r2.cancel();
    L8:
        this.n = false;
        this.k = false;
        this.l = 0;
        this.m = 0.0f;
        this.c = 0;
        this.b = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        invalidate();
    }

    static {
        s = new float[]{5.5f, 9.8f, 14.2f, 3.7f, 19.5f};
        t = new float[]{1.0f, 0.8f, 0.6f, 0.7f, 0.4f};
        u = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        v = new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f);
    }

    public final void a() {
        float[][] r0 = this.d;
        if (r0.length != 5) goto L16;
        int r1 = r0.length;
        int r5 = 0;
    L5:
        boolean r6 = true;
        if (r5 >= r1) goto L14;
        if (r0[r5].length == 36) goto L11;
        r6 = false;
    L11:
        if (r6 == false) goto L12;
        r5 = r5 + 1;
        goto L5
    L12:
        r6 = false;
    L14:
        if (r6 == false) goto L16;
        return;
    L16:
        float[][] r2 = new float[5][];
        int r3 = 0;
    L17:
        if (r3 >= 5) goto L19;
        r2[r3] = new float[36];
        r3 = r3 + 1;
        goto L17
    L19:
        this.d = r2;
        int r4 = 0;
    L20:
        if (r4 >= 5) goto L25;
        int r7 = 0;
    L22:
        if (r7 >= 36) goto L24;
        this.d[r4][r7] = Random.Default.nextFloat() * 6.2831855f;
        r7 = r7 + 1;
        goto L22
    L24:
        r4 = r4 + 1;
        goto L20
    }

    public final void c() {
        if (this.j == true) goto L5;
        return;
    L5:
        if (this.q == null) goto L7;
        return;
    L7:
        if (this.o.isEmpty() == true) goto L13;
        float r2 = ((Number) this.o.removeFirst()).floatValue();
        AnimatorSet r7 = new AnimatorSet();
        float r1 = this.e;
        PathInterpolator r11 = u;
        r7.playTogether(new Animator[]{g(r1, r2, 300, r11, new f(this)), g(this.f, 0.0f, 300, r11, new g(this)), g(this.g, 0.0f, 300, r11, new h(this))});
        r7.addListener(new p(this));
        r7.start();
        this.q = r7;
        return;
    }

    public final void d() {
        if (this.j == true) goto L5;
        return;
    L5:
        if (this.n == true) goto L7;
        return;
    L7:
        if (isAttachedToWindow() == true) goto L9;
        return;
    L9:
        if (getWidth() > 0) goto L11;
        return;
    L11:
        if (getHeight() <= 0) goto L25;
        this.n = false;
        AnimatorSet r1 = this.p;
        this.p = null;
        if (r1 == null) goto L16;
        r1.cancel();
    L16:
        AnimatorSet r2 = this.q;
        this.q = null;
        if (r2 == null) goto L19;
        r2.cancel();
    L19:
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        invalidate();
        PathInterpolator r3 = v;
        ValueAnimator r4 = g(0.0f, 1.0f, 700, r3, new j(this));
        ValueAnimator r5 = g(0.0f, 1.0f, 700, r3, new k(this));
        ValueAnimator r6 = g(0.0f, 1.0f, 350, u, new l(this));
        ValueAnimator r7 = g(0.0f, 1.0f, 1000, r3, new m(this));
        AnimatorSet r8 = new AnimatorSet();
        r8.playTogether(new Animator[]{r4, r5, r6, r7});
        r8.addListener(new q(this));
        r8.start();
        this.p = r8;
        return;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.j == true) goto L5;
        return;
    L5:
        if (isAttachedToWindow() == true) goto L7;
    L9:
        d();
        return;
    L7:
        if (this.r.isRunning() == true) goto L9;
        this.r.start();
        goto L9
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        e();
        super.onDetachedFromWindow();
    }

    public o(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        Paint r6 = new Paint(1);
        r6.setColor(-1);
        this.a = r6;
        this.d = new float[0][];
        this.o = new ArrayDeque();
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.setDuration(1000);
        r1.setRepeatCount(-1);
        r1.setInterpolator(new LinearInterpolator());
        r1.addUpdateListener(new i(this));
        this.r = r1;
        setImportantForAccessibility(2);
        setVisibility(4);
    }

    public final void b(boolean r5) {
        if (this.j == true) goto L9;
        this.j = true;
        this.k = false;
        this.l = SystemClock.uptimeMillis();
        this.m = 0.0f;
        this.o.clear();
        a();
        if (isAttachedToWindow() == false) goto L9;
        if (this.r.isRunning() == true) goto L9;
        this.r.start();
    L9:
        if (r5 == false) goto L11;
        this.n = true;
    L11:
        d();
    }

    public final void f(float r2) {
        this.o.addLast(Float.valueOf(r2));
        if (this.n == false) goto L5;
        return;
    L5:
        if (this.p != null) goto L14;
        AnimatorSet r3 = this.q;
        if (r3 != null) goto L10;
        c();
        return;
    L10:
        r3.cancel();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r29) {
        Intrinsics.checkNotNullParameter(r29, "canvas");
        float r1 = getWidth();
        float r2 = getHeight();
        float r11 = 0.0f;
        if (r1 > 0.0f) goto L5;
        return;
    L5:
        if (r2 <= 0.0f) goto L40;
        a();
        Resources r3 = getResources();
        float r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density;
        float r5 = 2.4f * r4;
        float r6 = 3.6f * r4;
        float r7 = 7.0f * r4;
        float r8 = 24.0f * r4;
        float r9 = r4 * 1.0f;
        float r10 = 60.0f * r4;
        float r12 = r4 * 6.0f;
        float r14 = 36;
        float r13 = 35;
        float r15 = (r14 * r5) + (r13 * r6);
        if (r15 > r1) goto L10;
    L12:
        float r16 = r5;
        float r17 = r10;
        float r18 = Math.min(1.0f, r2 / Math.max(1.0E-4f, r8));
        float r19 = r7 * r18;
        float r20 = r8 * r18;
        float r110 = r12 * r18;
        float r111 = r9 * r18;
        float r21 = r16 + r6;
        float r112 = (r14 * r16) + (r13 * r6);
        float r22 = (r1 - r112) * 0.5f;
        float r23 = r2 * 0.5f;
        int r24 = 0;
    L14:
        if (r24 >= 36) goto L41;
        int r113 = r24 + 1;
        if (this.e <= r11) goto L22;
        int r25 = r113 - 1;
        int r26 = 0;
        float r27 = 0.0f;
        float r28 = 0.0f;
    L19:
        if (r26 >= 5) goto L21;
        float r114 = t[r26];
        r28 = r28 + (((float) Math.sin((this.b * s[r26]) + this.d[r26][r25])) * r114);
        r27 = r27 + r114;
        r26 = r26 + 1;
        goto L19
    L21:
        float r30 = (((((r20 - r19) * (((float) Math.pow(((RangesKt.coerceIn(1.7f * r28, -r27, r27) / r27) * 0.5f) + 0.5f, 1.6f)) * (((-0.5f) * (Math.abs((r25 / 35.0f) - 0.5f) * 2.0f)) + 1.0f))) + r19) - r19) * this.e) + r19;
    L24:
        if (this.f <= 0.0f) goto L26;
        float r31 = Math.abs(((r113 - 1) / 35.0f) - 0.5f) * 2.0f;
        float r32 = Math.max(0.075f, 0.001f);
        float r33 = RangesKt.coerceIn(((((this.g * (r32 + 1.0f)) - r31) / r32) + 1.0f) * 0.5f, 0.0f, 1.0f);
        r30 = r30 + ((r110 - r30) * (((r33 * r33) * (3.0f - (r33 * 2.0f))) * this.f));
    L26:
        r11 = 0.0f;
        if (this.h <= 0.0f) goto L34;
        float r34 = r113 - 1;
        float r35 = (r34 * r21) + (r16 / 2.0f);
        float r36 = r112 / 2.0f;
        float r210 = r17 / 2.0f;
        float r115 = this.i * (r36 + r210);
        float r37 = Math.min(Math.abs(r35 - (r36 - r115)), Math.abs(r35 - (r36 + r115)));
        if (r37 < r210) goto L31;
        float r38 = r19;
    L32:
        r30 = r30 + ((Math.max(r30, r38) - r30) * this.h);
        goto L34
    L31:
        r38 = ((r20 - r19) * (((((float) Math.cos((r37 / r210) * 3.1415927f)) + 1.0f) / 2.0f) * (((-1.0f) * (Math.abs((r34 / 35.0f) - 0.5f) * 2.0f)) + 1.0f))) + r19;
    L34:
        float r39 = r22 + (r24 * r21);
        float r40 = RangesKt.coerceIn(r30, r19, r20) * 0.5f;
        r29.drawRoundRect(r39, r23 - r40, r39 + r16, r23 + r40, r111, r111, this.a);
        r24 = r113;
        r20 = r20;
        r19 = r19;
        goto L14
    L22:
        r30 = r19;
        goto L24
    L41:
        return;
    L10:
        if (r15 <= 0.0f) goto L12;
        float r116 = r1 / r15;
        r5 = r5 * r116;
        r6 = r6 * r116;
        r9 = r9 * r116;
        r10 = r10 * r116;
        goto L12
    }

    public final void setAmplitude(float r9) {
        if (this.j == true) goto L5;
        return;
    L5:
        long r0 = SystemClock.uptimeMillis();
        float r10 = RangesKt.coerceIn(r9, 0.0f, 1.0f);
        if (this.k == true) goto L9;
        this.k = true;
        this.l = r0;
        this.m = 0.0f;
        f(r10);
        return;
    L9:
        float r11 = Math.max(this.m, r10);
        this.m = r11;
        if ((r0 - this.l) >= 400) goto L12;
        return;
    L12:
        this.m = 0.0f;
        this.l = r0;
        f(r11);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        d();
    }

    public final ValueAnimator g(float r3, float r4, long r5, TimeInterpolator r7, final Function1<? super Float, Unit> r8) {
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{r3, r4});
        r6.setDuration(r5);
        r6.setInterpolator(r7);
        r6.addUpdateListener(new n(r8, this));
        return r6;
    }
}
