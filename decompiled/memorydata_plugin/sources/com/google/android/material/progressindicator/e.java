package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: loaded from: classes2.dex */
final class e extends g<ObjectAnimator> {
    private static final int[] e = null;
    private static final int[] f = null;
    private static final int[] g = null;
    private static final Property<e, Float> o = null;
    private static final Property<e, Float> p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Animatable2Compat.AnimationCallback f4013a;
    private ObjectAnimator h;
    private ObjectAnimator i;
    private final FastOutSlowInInterpolator j;
    private final c k;
    private int l;
    private float m;
    private float n;

    static {
        e = new int[]{0, 1350, 2700, 4050};
        f = new int[]{667, 2017, 3367, 4717};
        g = new int[]{1000, 2350, 3700, 5050};
        final Class<Float> r1 = Float.class;
        final String r2 = "animationFraction";
        o = new AnonymousClass3(r1, r2);
        final Class<Float> r3 = Float.class;
        final String r4 = "completeEndFraction";
        p = new AnonymousClass4(r3, r4);
    }

    public e(CircularProgressIndicatorSpec r2) {
        super(1);
        this.l = 0;
        this.f4013a = null;
        this.k = r2;
        this.j = new FastOutSlowInInterpolator();
    }

    static /* synthetic */ int a(e r0) {
        return r0.l;
    }

    static /* synthetic */ int a(e r0, int r1) {
        r0.l = r1;
        return r1;
    }

    private void a(int r9) {
        this.c[0] = (this.m * 1520.0f) - 20.0f;
        this.c[1] = this.m * 1520.0f;
        int r0 = 0;
    L4:
        if (r0 >= 4) goto L6;
        float r1 = a(r9, e[r0], 667);
        float[] r5 = this.c;
        r5[1] = r5[1] + (this.j.getInterpolation(r1) * 250.0f);
        float r2 = a(r9, f[r0], 667);
        float[] r4 = this.c;
        r4[0] = r4[0] + (this.j.getInterpolation(r2) * 250.0f);
        r0 = r0 + 1;
        goto L4
    L6:
        float[] r10 = this.c;
        r10[0] = r10[0] + ((this.c[1] - this.c[0]) * this.n);
        float[] r11 = this.c;
        r11[0] = r11[0] / 360.0f;
        float[] r8 = this.c;
        r8[1] = r8[1] / 360.0f;
    }

    static /* synthetic */ void a(e r0, float r1) {
        r0.b(r1);
    }

    static /* synthetic */ c b(e r0) {
        return r0.k;
    }

    private void b(float r1) {
        this.n = r1;
    }

    private void b(int r5) {
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L16;
        float r2 = a(r5, g[r1], 333);
        if (r2 < 0.0f) goto L10;
        if (r2 > 1.0f) goto L10;
        int r3 = (r1 + this.l) % this.k.c.length;
        int r6 = (r3 + 1) % this.k.c.length;
        int r4 = com.google.android.material.c.a.b(this.k.c[r3], this.f4018b.getAlpha());
        int r7 = com.google.android.material.c.a.b(this.k.c[r6], this.f4018b.getAlpha());
        this.d[0] = com.google.android.material.a.c.a().a(this.j.getInterpolation(r2), Integer.valueOf(r4), Integer.valueOf(r7)).intValue();
        return;
    L10:
        r1 = r1 + 1;
        goto L4
    }

    static /* synthetic */ float c(e r0) {
        return r0.h();
    }

    static /* synthetic */ float d(e r0) {
        return r0.i();
    }

    private void g() {
        if (this.h != null) goto L6;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, o, new float[]{0.0f, 1.0f});
        this.h = r0;
        r0.setDuration(5400);
        this.h.setInterpolator(null);
        this.h.setRepeatCount(-1);
        this.h.addListener(new AnonymousClass1(this));
    L6:
        if (this.i != null) goto L9;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this, p, new float[]{0.0f, 1.0f});
        this.i = r1;
        r1.setDuration(333);
        this.i.setInterpolator(this.j);
        this.i.addListener(new AnonymousClass2(this));
        return;
    }

    private float h() {
        return this.m;
    }

    private float i() {
        return this.n;
    }

    @Override // com.google.android.material.progressindicator.g
    void a() {
        g();
        f();
        this.h.start();
    }

    void a(float r2) {
        this.m = r2;
        int r3 = (int) (r2 * 5400.0f);
        a(r3);
        b(r3);
        this.f4018b.invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.g
    public void a(Animatable2Compat.AnimationCallback r1) {
        this.f4013a = r1;
    }

    @Override // com.google.android.material.progressindicator.g
    void b() {
        ObjectAnimator r0 = this.h;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // com.google.android.material.progressindicator.g
    void c() {
        ObjectAnimator r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() == false) goto L8;
        return;
    L8:
        if (this.f4018b.isVisible() == false) goto L10;
        this.i.start();
        return;
    L10:
        b();
    }

    @Override // com.google.android.material.progressindicator.g
    public void d() {
        f();
    }

    @Override // com.google.android.material.progressindicator.g
    public void e() {
        this.f4013a = null;
    }

    void f() {
        this.l = 0;
        this.d[0] = com.google.android.material.c.a.b(this.k.c[0], this.f4018b.getAlpha());
        this.n = 0.0f;
    }
}
