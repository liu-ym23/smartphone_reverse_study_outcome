package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: loaded from: classes.dex */
final class d extends f<ObjectAnimator> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int[] f3531l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int[] f3532m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f3533n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Property<d, Float> f3534o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Property<d, Float> f3535p = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObjectAnimator f3536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ObjectAnimator f3537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FastOutSlowInInterpolator f3538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f3539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3540h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f3541i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f3542j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Animatable2Compat.AnimationCallback f3543k;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f3544c;

        a(d r10) {
            this.f3544c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
            super.onAnimationRepeat(r10);
            d r11 = this.f3544c;
            d.j(r11, (d.i(r11) + 4) % d.k(this.f3544c).f3523c.length);
        }
    }

    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f3545c;

        b(d r10) {
            this.f3545c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            super.onAnimationEnd(r10);
            this.f3545c.a();
            d r11 = this.f3545c;
            Animatable2Compat.AnimationCallback r12 = r11.f3543k;
            if (r12 == null) goto L6;
            r12.onAnimationEnd(r11.f3548a);
            return;
        }
    }

    class c extends Property<d, Float> {
        c(Class r10, String r11) {
            super(r10, r11);
        }

        public Float a(d r10) {
            return Float.valueOf(d.l(r10));
        }

        public void b(d r10, Float r11) {
            r10.t(r11.floatValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(d r10) {
            return a(r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(d r10, Float r11) {
            b(r10, r11);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.progressindicator.d$d, reason: collision with other inner class name */
    class C0083d extends Property<d, Float> {
        C0083d(Class r10, String r11) {
            super(r10, r11);
        }

        public Float a(d r10) {
            return Float.valueOf(d.m(r10));
        }

        public void b(d r10, Float r11) {
            d.n(r10, r11.floatValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(d r10) {
            return a(r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(d r10, Float r11) {
            b(r10, r11);
        }
    }

    static {
        f3531l = new int[]{0, 1350, 2700, 4050};
        f3532m = new int[]{667, 2017, 3367, 4717};
        f3533n = new int[]{1000, 2350, 3700, 5050};
        f3534o = new c(Float.class, "animationFraction");
        f3535p = new C0083d(Float.class, "completeEndFraction");
    }

    public d(@NonNull CircularProgressIndicatorSpec r10) {
        super(1);
        this.f3540h = 0;
        this.f3543k = null;
        this.f3539g = r10;
        this.f3538f = new FastOutSlowInInterpolator();
    }

    static /* synthetic */ int i(d r10) {
        return r10.f3540h;
    }

    static /* synthetic */ int j(d r10, int r11) {
        r10.f3540h = r11;
        return r11;
    }

    static /* synthetic */ com.google.android.material.progressindicator.b k(d r10) {
        return r10.f3539g;
    }

    static /* synthetic */ float l(d r10) {
        return r10.o();
    }

    static /* synthetic */ float m(d r10) {
        return r10.p();
    }

    static /* synthetic */ void n(d r10, float r11) {
        r10.u(r11);
    }

    private float o() {
        return this.f3541i;
    }

    private float p() {
        return this.f3542j;
    }

    private void q() {
        if (this.f3536d != null) goto L6;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this, f3534o, new float[]{0.0f, 1.0f});
        this.f3536d = r10;
        r10.setDuration(5400);
        this.f3536d.setInterpolator(null);
        this.f3536d.setRepeatCount(-1);
        this.f3536d.addListener(new a(this));
    L6:
        if (this.f3537e != null) goto L9;
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this, f3535p, new float[]{0.0f, 1.0f});
        this.f3537e = r11;
        r11.setDuration(333);
        this.f3537e.setInterpolator(this.f3538f);
        this.f3537e.addListener(new b(this));
        return;
    }

    private void r(int r10) {
        int r11 = 0;
    L4:
        if (r11 >= 4) goto L16;
        float r12 = b(r10, f3533n[r11], 333);
        if (r12 < 0.0f) goto L10;
        if (r12 > 1.0f) goto L10;
        int r13 = r11 + this.f3540h;
        int[] r14 = this.f3539g.f3523c;
        int r15 = r13 % r14.length;
        int r16 = (r15 + 1) % r14.length;
        int r17 = t5.a.a(r14[r15], this.f3548a.getAlpha());
        int r18 = t5.a.a(this.f3539g.f3523c[r16], this.f3548a.getAlpha());
        this.f3550c[0] = r5.c.b().a(this.f3538f.getInterpolation(r12), Integer.valueOf(r17), Integer.valueOf(r18)).intValue();
        return;
    L10:
        r11 = r11 + 1;
        goto L4
    }

    private void u(float r10) {
        this.f3542j = r10;
    }

    private void v(int r10) {
        float[] r11 = this.f3549b;
        float r12 = this.f3541i;
        r11[0] = (r12 * 1520.0f) - 20.0f;
        r11[1] = r12 * 1520.0f;
        int r13 = 0;
    L4:
        if (r13 >= 4) goto L6;
        float r14 = b(r10, f3531l[r13], 667);
        float[] r15 = this.f3549b;
        r15[1] = r15[1] + (this.f3538f.getInterpolation(r14) * 250.0f);
        float r16 = b(r10, f3532m[r13], 667);
        float[] r17 = this.f3549b;
        r17[0] = r17[0] + (this.f3538f.getInterpolation(r16) * 250.0f);
        r13 = r13 + 1;
        goto L4
    L6:
        float[] r18 = this.f3549b;
        r18[0] = r18[0] + ((r18[1] - r18[0]) * this.f3542j);
        r18[0] = r18[0] / 360.0f;
        r18[1] = r18[1] / 360.0f;
    }

    @Override // com.google.android.material.progressindicator.f
    void a() {
        ObjectAnimator r10 = this.f3536d;
        if (r10 == null) goto L6;
        r10.cancel();
        return;
    }

    @Override // com.google.android.material.progressindicator.f
    public void c() {
        s();
    }

    @Override // com.google.android.material.progressindicator.f
    public void d(@NonNull Animatable2Compat.AnimationCallback r10) {
        this.f3543k = r10;
    }

    @Override // com.google.android.material.progressindicator.f
    void f() {
        ObjectAnimator r10 = this.f3537e;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isRunning() == false) goto L8;
        return;
    L8:
        if (this.f3548a.isVisible() == false) goto L10;
        this.f3537e.start();
        return;
    L10:
        a();
    }

    @Override // com.google.android.material.progressindicator.f
    void g() {
        q();
        s();
        this.f3536d.start();
    }

    @Override // com.google.android.material.progressindicator.f
    public void h() {
        this.f3543k = null;
    }

    @VisibleForTesting
    void s() {
        this.f3540h = 0;
        this.f3550c[0] = t5.a.a(this.f3539g.f3523c[0], this.f3548a.getAlpha());
        this.f3542j = 0.0f;
    }

    @VisibleForTesting
    void t(float r10) {
        this.f3541i = r10;
        int r11 = (int) (r10 * 5400.0f);
        v(r11);
        r(r11);
        this.f3548a.invalidateSelf();
    }
}
