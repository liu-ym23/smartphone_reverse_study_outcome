package cja;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    public double a;
    public boolean b;
    public double c;
    public double d;
    public double e;
    public float f;
    public float g;

    public e() {
        this.g = 1.0f;
        this.a = Math.sqrt(50.0f);
        this.f = 1.0f;
    }

    public final void a(float r5) {
        double r0 = this.a;
        if (((float) (r0 * r0)) <= 0) goto L7;
        this.a = Math.sqrt(r5);
        this.b = false;
        return;
    L7:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public final d b(float r17, float r18, long r19) {
        if (this.b == false) goto L6;
    L16:
        double r4 = r19 / 1000.0d;
        float r2 = r17 - this.g;
        float r6 = this.f;
        if (r6 <= 1) goto L20;
        double r3 = r2;
        double r7 = this.d;
        double r10 = r18;
        double r12 = this.c;
        double r8 = r3 - (((r7 * r3) - r10) / (r7 - r12));
        double r5 = ((r3 * r7) - r10) / (r7 - r12);
        double r9 = (Math.exp(r7 * r4) * r8) + (Math.exp(this.c * r4) * r5);
        double r11 = this.d;
        double r13 = (r8 * r11) * Math.exp(r11 * r4);
        double r14 = this.c;
        double r15 = r13 + ((r5 * r14) * Math.exp(r14 * r4));
    L23:
        long r16 = Float.floatToRawIntBits((float) (r9 + ((double) this.g)));
        return new d((((long) Float.floatToRawIntBits((float) r15)) & 4294967295L) | (r16 << 32));
    L20:
        if (r6 != 1.0f) goto L22;
        double r20 = this.a;
        double r1 = r2;
        double r21 = ((double) r18) + (r20 * r1);
        double r22 = r1 + (r21 * r4);
        double r23 = Math.exp((-r20) * r4) * r22;
        double r24 = r22 * Math.exp((-this.a) * r4);
        double r110 = this.a;
        double r25 = (r24 * (-r110)) + (r21 * Math.exp((-r110) * r4));
        r9 = r23;
        r15 = r25;
        goto L23
    L22:
        double r26 = ((double) 1) / this.e;
        double r111 = this.a;
        double r27 = r2;
        double r28 = r26 * (((((double) r6) * r111) * r27) + ((double) r18));
        double r29 = Math.exp((((double) (-r6)) * r111) * r4) * ((Math.cos(this.e * r4) * r27) + (Math.sin(this.e * r4) * r28));
        double r112 = this.a;
        float r30 = this.f;
        double r113 = ((-r112) * r29) * ((double) r30);
        double r31 = Math.exp((((double) (-r30)) * r112) * r4);
        double r114 = this.e;
        double r115 = ((-r114) * r27) * Math.sin(r114 * r4);
        double r32 = this.e;
        r15 = r113 + (r31 * (r115 + ((r28 * r32) * Math.cos(r32 * r4))));
        r9 = r29;
        goto L23
    L6:
        if (this.g == Float.MAX_VALUE) goto L26;
        float r33 = this.f;
        double r34 = r33;
        double r35 = r34 * r34;
        float r36 = 1;
        if (r33 <= r36) goto L11;
        double r37 = this.a;
        double r38 = r35 - ((double) 1);
        this.c = (((double) (-r33)) * r37) + (r37 * Math.sqrt(r38));
        double r39 = -this.f;
        double r40 = this.a;
        this.d = (r39 * r40) - (r40 * Math.sqrt(r38));
    L15:
        this.b = true;
        goto L16
    L11:
        if (r33 < 0) goto L15;
        if (r33 >= r36) goto L15;
        this.e = this.a * Math.sqrt(((double) 1) - r35);
        goto L15
    L26:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }
}
