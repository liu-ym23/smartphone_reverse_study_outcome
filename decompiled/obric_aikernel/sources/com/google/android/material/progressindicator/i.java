package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class i extends f<ObjectAnimator> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int[] f3562l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int[] f3563m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Property<i, Float> f3564n = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObjectAnimator f3565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ObjectAnimator f3566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Interpolator[] f3567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f3568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3570i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f3571j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Animatable2Compat.AnimationCallback f3572k;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f3573c;

        a(i r10) {
            this.f3573c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
            super.onAnimationRepeat(r10);
            i r11 = this.f3573c;
            i.j(r11, (i.i(r11) + 1) % i.k(this.f3573c).f3523c.length);
            i.l(this.f3573c, true);
        }
    }

    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f3574c;

        b(i r10) {
            this.f3574c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            super.onAnimationEnd(r10);
            this.f3574c.a();
            i r11 = this.f3574c;
            Animatable2Compat.AnimationCallback r12 = r11.f3572k;
            if (r12 == null) goto L6;
            r12.onAnimationEnd(r11.f3548a);
            return;
        }
    }

    class c extends Property<i, Float> {
        c(Class r10, String r11) {
            super(r10, r11);
        }

        public Float a(i r10) {
            return Float.valueOf(i.m(r10));
        }

        public void b(i r10, Float r11) {
            r10.r(r11.floatValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(i r10) {
            return a(r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(i r10, Float r11) {
            b(r10, r11);
        }
    }

    static {
        f3562l = new int[]{533, 567, 850, 750};
        f3563m = new int[]{1267, 1000, 333, 0};
        f3564n = new c(Float.class, "animationFraction");
    }

    public i(@NonNull Context r10, @NonNull LinearProgressIndicatorSpec r11) {
        super(2);
        this.f3569h = 0;
        this.f3572k = null;
        this.f3568g = r11;
        this.f3567f = new Interpolator[]{AnimationUtilsCompat.loadInterpolator(r10, q5.a.linear_indeterminate_line1_head_interpolator), AnimationUtilsCompat.loadInterpolator(r10, q5.a.linear_indeterminate_line1_tail_interpolator), AnimationUtilsCompat.loadInterpolator(r10, q5.a.linear_indeterminate_line2_head_interpolator), AnimationUtilsCompat.loadInterpolator(r10, q5.a.linear_indeterminate_line2_tail_interpolator)};
    }

    static /* synthetic */ int i(i r10) {
        return r10.f3569h;
    }

    static /* synthetic */ int j(i r10, int r11) {
        r10.f3569h = r11;
        return r11;
    }

    static /* synthetic */ com.google.android.material.progressindicator.b k(i r10) {
        return r10.f3568g;
    }

    static /* synthetic */ boolean l(i r10, boolean r11) {
        r10.f3570i = r11;
        return r11;
    }

    static /* synthetic */ float m(i r10) {
        return r10.n();
    }

    private float n() {
        return this.f3571j;
    }

    private void o() {
        if (this.f3565d != null) goto L6;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this, f3564n, new float[]{0.0f, 1.0f});
        this.f3565d = r10;
        r10.setDuration(1800);
        this.f3565d.setInterpolator(null);
        this.f3565d.setRepeatCount(-1);
        this.f3565d.addListener(new a(this));
    L6:
        if (this.f3566e != null) goto L9;
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this, f3564n, new float[]{1.0f});
        this.f3566e = r11;
        r11.setDuration(1800);
        this.f3566e.setInterpolator(null);
        this.f3566e.addListener(new b(this));
        return;
    }

    private void p() {
        if (this.f3570i == false) goto L6;
        Arrays.fill(this.f3550c, t5.a.a(this.f3568g.f3523c[this.f3569h], this.f3548a.getAlpha()));
        this.f3570i = false;
        return;
    }

    private void s(int r10) {
        int r11 = 0;
    L4:
        if (r11 >= 4) goto L6;
        float r12 = b(r10, f3563m[r11], f3562l[r11]);
        float r13 = this.f3567f[r11].getInterpolation(r12);
        this.f3549b[r11] = Math.max(0.0f, Math.min(1.0f, r13));
        r11 = r11 + 1;
        goto L4
    }

    @Override // com.google.android.material.progressindicator.f
    public void a() {
        ObjectAnimator r10 = this.f3565d;
        if (r10 == null) goto L6;
        r10.cancel();
        return;
    }

    @Override // com.google.android.material.progressindicator.f
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.f
    public void d(@NonNull Animatable2Compat.AnimationCallback r10) {
        this.f3572k = r10;
    }

    @Override // com.google.android.material.progressindicator.f
    public void f() {
        ObjectAnimator r10 = this.f3566e;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isRunning() == true) goto L13;
        a();
        if (this.f3548a.isVisible() == false) goto L12;
        this.f3566e.setFloatValues(new float[]{this.f3571j, 1.0f});
        this.f3566e.setDuration((long) ((1.0f - this.f3571j) * 1800.0f));
        this.f3566e.start();
        return;
    L12:
        return;
    }

    @Override // com.google.android.material.progressindicator.f
    public void g() {
        o();
        q();
        this.f3565d.start();
    }

    @Override // com.google.android.material.progressindicator.f
    public void h() {
        this.f3572k = null;
    }

    @VisibleForTesting
    void q() {
        this.f3569h = 0;
        int r10 = t5.a.a(this.f3568g.f3523c[0], this.f3548a.getAlpha());
        int[] r11 = this.f3550c;
        r11[0] = r10;
        r11[1] = r10;
    }

    @VisibleForTesting
    void r(float r10) {
        this.f3571j = r10;
        s((int) (r10 * 1800.0f));
        p();
        this.f3548a.invalidateSelf();
    }
}
