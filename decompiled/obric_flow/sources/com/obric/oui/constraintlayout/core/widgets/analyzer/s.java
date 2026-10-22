package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public hr.f f12593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f12594c;
    public ConstraintWidget$DimensionBehaviour d;
    public final h e;
    public int f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f12595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f12596i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WidgetRun$RunType f12597j;

    public s(hr.f r5) {
        this.e = new h(this);
        this.f = 0;
        this.g = false;
        this.f12595h = new g(this);
        this.f12596i = new g(this);
        this.f12597j = WidgetRun$RunType.NONE;
        this.f12593b = r5;
    }

    public static void b(g r5, g r10, int r11) {
        r5.f12578l.add(r10);
        r5.f = r11;
        r10.f12577k.add(r5);
    }

    public static g h(hr.d r5) {
        hr.d r10 = r5.f;
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = r.f12591a[r10.e.ordinal()];
        hr.f r12 = r10.d;
        if (r11 == 1) goto L21;
        if (r11 == 2) goto L25;
        if (r11 == 3) goto L24;
        if (r11 == 4) goto L23;
        if (r11 == 5) goto L22;
        return null;
    L22:
        return r12.e.f12596i;
    L23:
        return r12.e.f12586k;
    L24:
        return r12.e.f12595h;
    L25:
        return r12.d.f12596i;
    L21:
        return r12.d.f12595h;
    }

    public static g i(hr.d r5, int r10) {
        hr.d r11 = r5.f;
        if (r11 != null) goto L5;
        return null;
    L5:
        hr.f r12 = r11.d;
        if (r10 != 0) goto L8;
        s r13 = r12.d;
    L9:
        int r14 = r.f12591a[r11.e.ordinal()];
        if (r14 == 1) goto L20;
        if (r14 == 2) goto L21;
        if (r14 == 3) goto L20;
        if (r14 == 5) goto L21;
        return null;
    L21:
        return r13.f12596i;
    L20:
        return r13.f12595h;
    L8:
        r13 = r12.e;
        goto L9
    }

    public final void c(g r5, g r10, int r11, h r12) {
        r5.f12578l.add(r10);
        r5.f12578l.add(this.e);
        r5.f12574h = r11;
        r5.f12575i = r12;
        r10.f12577k.add(r5);
        r12.f12577k.add(r5);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int r5, int r10) {
        if (r10 != 0) goto L8;
        hr.f r11 = this.f12593b;
        int r12 = r11.f17427v;
        int r13 = Math.max(r11.f17426u, r5);
        if (r12 <= 0) goto L6;
        r13 = Math.min(r12, r5);
    L6:
        if (r13 != r5) goto L13;
        return r5;
    L13:
        return r13;
    L8:
        hr.f r14 = this.f12593b;
        int r15 = r14.f17430y;
        r13 = Math.max(r14.f17429x, r5);
        if (r15 <= 0) goto L11;
        r13 = Math.min(r15, r5);
    L11:
        if (r13 != r5) goto L13;
        return r5;
    }

    public long j() {
        h r5 = this.e;
        if (r5.f12576j == true) goto L5;
        return 0;
    L5:
        return r5.g;
    }

    public abstract boolean k();

    public final void l(hr.d r13, hr.d r14, int r15) {
        g r5 = h(r13);
        g r10 = h(r14);
        if (r5.f12576j == true) goto L5;
        return;
    L5:
        if (r10.f12576j == false) goto L66;
        int r16 = r13.e() + r5.g;
        int r11 = r10.g - r14.e();
        int r17 = r11 - r16;
        h r12 = this.e;
        if (r12.f12576j == true) goto L52;
        ConstraintWidget$DimensionBehaviour r18 = this.d;
        ConstraintWidget$DimensionBehaviour r19 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r18 != r19) goto L52;
        int r20 = this.f12592a;
        if (r20 != 0) goto L14;
        r12.d(g(r17, r15));
        goto L52
    L14:
        if (r20 != 1) goto L16;
        r12.d(Math.min(g(r12.f12579m, r15), r17));
        goto L52
    L16:
        if (r20 != 2) goto L18;
        hr.f r21 = this.f12593b;
        hr.f r22 = r21.V;
        if (r22 == null) goto L52;
        if (r15 != 0) goto L42;
        s r23 = r22.d;
    L43:
        h r24 = r23.e;
        if (r24.f12576j == false) goto L52;
        if (r15 != 0) goto L47;
        float r25 = r21.f17428w;
    L48:
        r12.d(g((int) ((r24.g * r25) + 0.5f), r15));
        goto L52
    L47:
        r25 = r21.f17431z;
        goto L48
    L42:
        r23 = r22.e;
        goto L43
    L18:
        if (r20 != 3) goto L52;
        hr.f r26 = this.f12593b;
        s r27 = r26.d;
        if (r27.d == r19) goto L23;
    L29:
        if (r15 != 0) goto L31;
        r27 = r26.e;
    L31:
        h r28 = r27.e;
        if (r28.f12576j == false) goto L52;
        float r29 = r26.Y;
        if (r15 != 1) goto L36;
        int r30 = (int) ((r28.g / r29) + 0.5f);
    L37:
        r12.d(r30);
        goto L52
    L36:
        r30 = (int) ((r29 * r28.g) + 0.5f);
        goto L37
    L23:
        if (r27.f12592a != 3) goto L29;
        p r110 = r26.e;
        if (r110.d != r19) goto L29;
        if (r110.f12592a != 3) goto L29;
    L52:
        if (r12.f12576j == true) goto L54;
        return;
    L54:
        int r31 = r12.g;
        g r32 = this.f12596i;
        g r33 = this.f12595h;
        if (r31 != r17) goto L58;
        r33.d(r16);
        r32.d(r11);
        return;
    L58:
        if (r15 != 0) goto L60;
        float r111 = this.f12593b.f17402f0;
    L61:
        if (r5 != r10) goto L63;
        r16 = r5.g;
        r11 = r10.g;
        r111 = 0.5f;
    L63:
        r33.d((int) ((((r11 - r16) - r31) * r111) + (r16 + 0.5f)));
        r32.d(r33.g + r12.g);
        return;
    L60:
        r111 = this.f12593b.g0;
        goto L61
    }
}
