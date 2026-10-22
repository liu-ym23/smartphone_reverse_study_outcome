package com.obric.common.oea.foundation.animation.c;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    double f7701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    double f7702b;
    private boolean c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    private double i;
    private final b.a j;

    public f() {
        this.f7701a = Math.sqrt(1500.0d);
        this.f7702b = 0.5d;
        this.c = false;
        this.i = Double.MAX_VALUE;
        this.j = new b.a();
    }

    public f(float r3) {
        this.f7701a = Math.sqrt(1500.0d);
        this.f7702b = 0.5d;
        this.c = false;
        this.i = Double.MAX_VALUE;
        this.j = new b.a();
        this.i = r3;
    }

    private void b() {
        if (this.c == false) goto L6;
        return;
    L6:
        if (this.i == Double.MAX_VALUE) goto L18;
        double r0 = this.f7702b;
        if (r0 <= 1.0d) goto L11;
        double r6 = this.f7701a;
        this.f = ((-r0) * r6) + (r6 * Math.sqrt((r0 * r0) - 1.0d));
        double r1 = this.f7702b;
        double r7 = this.f7701a;
        this.g = ((-r1) * r7) - (r7 * Math.sqrt((r1 * r1) - 1.0d));
    L15:
        this.c = true;
        return;
    L11:
        if (r0 < 0.0d) goto L15;
        if (r0 >= 1.0d) goto L15;
        this.h = this.f7701a * Math.sqrt(1.0d - (r0 * r0));
        goto L15
    L18:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    public float a() {
        return (float) this.i;
    }

    b.a a(double r17, double r19, long r21) {
        b();
        double r1 = r21 / 1000.0d;
        double r3 = r17 - this.i;
        double r5 = this.f7702b;
        if (r5 <= 1.0d) goto L6;
        double r6 = this.g;
        double r12 = this.f;
        double r7 = r3 - (((r6 * r3) - r19) / (r6 - r12));
        double r4 = ((r3 * r6) - r19) / (r6 - r12);
        double r8 = (Math.pow(2.718281828459045d, r6 * r1) * r7) + (Math.pow(2.718281828459045d, this.f * r1) * r4);
        double r13 = this.g;
        double r9 = (r7 * r13) * Math.pow(2.718281828459045d, r13 * r1);
        double r14 = this.f;
        double r10 = r9 + ((r4 * r14) * Math.pow(2.718281828459045d, r14 * r1));
    L9:
        this.j.f7697a = (float) (r8 + this.i);
        this.j.f7698b = (float) r10;
        return this.j;
    L6:
        if (r5 != 1.0d) goto L8;
        double r11 = this.f7701a;
        double r15 = r19 + (r11 * r3);
        double r16 = r3 + (r15 * r1);
        r8 = Math.pow(2.718281828459045d, (-r11) * r1) * r16;
        double r18 = r16 * Math.pow(2.718281828459045d, (-this.f7701a) * r1);
        double r110 = this.f7701a;
        r10 = (r15 * Math.pow(2.718281828459045d, (-r110) * r1)) + (r18 * (-r110));
        goto L9
    L8:
        double r20 = 1.0d / this.h;
        double r111 = this.f7701a;
        double r22 = r20 * (((r5 * r111) * r3) + r19);
        double r23 = Math.pow(2.718281828459045d, ((-r5) * r111) * r1) * ((Math.cos(this.h * r1) * r3) + (Math.sin(this.h * r1) * r22));
        double r112 = this.f7701a;
        double r113 = this.f7702b;
        double r114 = ((-r112) * r23) * r113;
        double r24 = Math.pow(2.718281828459045d, ((-r113) * r112) * r1);
        double r115 = this.h;
        double r25 = ((-r115) * r3) * Math.sin(r115 * r1);
        double r26 = this.h;
        r10 = r114 + (r24 * (r25 + ((r22 * r26) * Math.cos(r26 * r1))));
        r8 = r23;
        goto L9
    }

    public f a(float r3) {
        if (r3 <= 0.0f) goto L7;
        this.f7701a = Math.sqrt(r3);
        this.c = false;
        return this;
    L7:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    void a(double r3) {
        double r4 = Math.abs(r3);
        this.d = r4;
        this.e = r4 * 62.5d;
    }

    public boolean a(float r5, float r6) {
        if (Math.abs(r6) < this.e) goto L5;
        return false;
    L5:
        if (Math.abs(r5 - a()) >= this.d) goto L10;
        return true;
    L10:
        return false;
    }

    public f b(float r3) {
        if (r3 < 0.0f) goto L7;
        this.f7702b = r3;
        this.c = false;
        return this;
    L7:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public f c(float r3) {
        this.i = r3;
        return this;
    }
}
