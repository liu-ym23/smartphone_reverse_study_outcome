package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class h extends f<ObjectAnimator> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Property<h, Float> f3554j = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObjectAnimator f3555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FastOutSlowInInterpolator f3556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f3557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f3560i;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f3561c;

        a(h r10) {
            this.f3561c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
            super.onAnimationRepeat(r10);
            h r11 = this.f3561c;
            h.j(r11, (h.i(r11) + 1) % h.k(this.f3561c).f3523c.length);
            h.l(this.f3561c, true);
        }
    }

    class b extends Property<h, Float> {
        b(Class r10, String r11) {
            super(r10, r11);
        }

        public Float a(h r10) {
            return Float.valueOf(h.m(r10));
        }

        public void b(h r10, Float r11) {
            r10.r(r11.floatValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(h r10) {
            return a(r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(h r10, Float r11) {
            b(r10, r11);
        }
    }

    static {
        f3554j = new b(Float.class, "animationFraction");
    }

    public h(@NonNull LinearProgressIndicatorSpec r10) {
        super(3);
        this.f3558g = 1;
        this.f3557f = r10;
        this.f3556e = new FastOutSlowInInterpolator();
    }

    static /* synthetic */ int i(h r10) {
        return r10.f3558g;
    }

    static /* synthetic */ int j(h r10, int r11) {
        r10.f3558g = r11;
        return r11;
    }

    static /* synthetic */ com.google.android.material.progressindicator.b k(h r10) {
        return r10.f3557f;
    }

    static /* synthetic */ boolean l(h r10, boolean r11) {
        r10.f3559h = r11;
        return r11;
    }

    static /* synthetic */ float m(h r10) {
        return r10.n();
    }

    private float n() {
        return this.f3560i;
    }

    private void o() {
        if (this.f3555d != null) goto L6;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this, f3554j, new float[]{0.0f, 1.0f});
        this.f3555d = r10;
        r10.setDuration(333);
        this.f3555d.setInterpolator(null);
        this.f3555d.setRepeatCount(-1);
        this.f3555d.addListener(new a(this));
        return;
    }

    private void p() {
        if (this.f3559h == true) goto L5;
        return;
    L5:
        if (this.f3549b[3] >= 1.0f) goto L9;
        int[] r10 = this.f3550c;
        r10[2] = r10[1];
        r10[1] = r10[0];
        r10[0] = t5.a.a(this.f3557f.f3523c[this.f3558g], this.f3548a.getAlpha());
        this.f3559h = false;
        return;
    }

    private void s(int r10) {
        this.f3549b[0] = 0.0f;
        float r11 = b(r10, 0, 667);
        float[] r12 = this.f3549b;
        float r13 = this.f3556e.getInterpolation(r11);
        r12[2] = r13;
        r12[1] = r13;
        float[] r14 = this.f3549b;
        FastOutSlowInInterpolator r15 = this.f3556e;
        float r16 = r15.getInterpolation(r11 + 0.49925038f);
        r14[4] = r16;
        r14[3] = r16;
        this.f3549b[5] = 1.0f;
    }

    @Override // com.google.android.material.progressindicator.f
    public void a() {
        ObjectAnimator r10 = this.f3555d;
        if (r10 == null) goto L6;
        r10.cancel();
        return;
    }

    @Override // com.google.android.material.progressindicator.f
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.f
    public void d(@Nullable Animatable2Compat.AnimationCallback r10) {
    }

    @Override // com.google.android.material.progressindicator.f
    public void f() {
    }

    @Override // com.google.android.material.progressindicator.f
    public void g() {
        o();
        q();
        this.f3555d.start();
    }

    @Override // com.google.android.material.progressindicator.f
    public void h() {
    }

    @VisibleForTesting
    void q() {
        this.f3559h = true;
        this.f3558g = 1;
        Arrays.fill(this.f3550c, t5.a.a(this.f3557f.f3523c[0], this.f3548a.getAlpha()));
    }

    @VisibleForTesting
    void r(float r10) {
        this.f3560i = r10;
        s((int) (r10 * 333.0f));
        p();
        this.f3548a.invalidateSelf();
    }
}
