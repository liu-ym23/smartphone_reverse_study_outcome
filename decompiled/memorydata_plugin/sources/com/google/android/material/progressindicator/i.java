package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class i extends g<ObjectAnimator> {
    private static final Property<i, Float> j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObjectAnimator f4019a;
    private FastOutSlowInInterpolator e;
    private final c f;
    private int g;
    private boolean h;
    private float i;

    static {
        final Class<Float> r1 = Float.class;
        final String r2 = "animationFraction";
        j = new AnonymousClass2(r1, r2);
    }

    public i(LinearProgressIndicatorSpec r2) {
        super(3);
        this.g = 1;
        this.f = r2;
        this.e = new FastOutSlowInInterpolator();
    }

    static /* synthetic */ int a(i r0) {
        return r0.g;
    }

    static /* synthetic */ int a(i r0, int r1) {
        r0.g = r1;
        return r1;
    }

    private void a(int r5) {
        this.c[0] = 0.0f;
        float r6 = a(r5, 0, 667);
        float[] r0 = this.c;
        float[] r1 = this.c;
        float r2 = this.e.getInterpolation(r6);
        r1[2] = r2;
        r0[1] = r2;
        float[] r3 = this.c;
        float[] r4 = this.c;
        FastOutSlowInInterpolator r7 = this.e;
        float r8 = r7.getInterpolation(r6 + 0.49925038f);
        r4[4] = r8;
        r3[3] = r8;
        this.c[5] = 1.0f;
    }

    static /* synthetic */ boolean a(i r0, boolean r1) {
        r0.h = r1;
        return r1;
    }

    static /* synthetic */ c b(i r0) {
        return r0.f;
    }

    static /* synthetic */ float c(i r0) {
        return r0.i();
    }

    private void g() {
        if (this.f4019a != null) goto L6;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, j, new float[]{0.0f, 1.0f});
        this.f4019a = r0;
        r0.setDuration(333);
        this.f4019a.setInterpolator(null);
        this.f4019a.setRepeatCount(-1);
        this.f4019a.addListener(new AnonymousClass1(this));
        return;
    }

    private void h() {
        if (this.h == true) goto L5;
        return;
    L5:
        if (this.c[3] >= 1.0f) goto L9;
        this.d[2] = this.d[1];
        this.d[1] = this.d[0];
        this.d[0] = com.google.android.material.c.a.b(this.f.c[this.g], this.f4018b.getAlpha());
        this.h = false;
        return;
    }

    private float i() {
        return this.i;
    }

    @Override // com.google.android.material.progressindicator.g
    public void a() {
        g();
        f();
        this.f4019a.start();
    }

    void a(float r2) {
        this.i = r2;
        a((int) (r2 * 333.0f));
        h();
        this.f4018b.invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.g
    public void a(Animatable2Compat.AnimationCallback r1) {
    }

    @Override // com.google.android.material.progressindicator.g
    public void b() {
        ObjectAnimator r0 = this.f4019a;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // com.google.android.material.progressindicator.g
    public void c() {
    }

    @Override // com.google.android.material.progressindicator.g
    public void d() {
        f();
    }

    @Override // com.google.android.material.progressindicator.g
    public void e() {
    }

    void f() {
        this.h = true;
        this.g = 1;
        Arrays.fill(this.d, com.google.android.material.c.a.b(this.f.c[0], this.f4018b.getAlpha()));
    }
}
