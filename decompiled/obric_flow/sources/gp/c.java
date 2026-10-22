package gp;

import com.lynx.tasm.animation.keyframe.e;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f17121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f17123c;
    public double d;
    public double e;
    public float f;
    public float g;

    public final e a(float r16, float r17, long r18) {
        if (this.f17122b == false) goto L6;
    L16:
        double r5 = r18 / 1000.0d;
        float r10 = r16 - this.g;
        float r11 = this.f;
        if (r11 <= 1) goto L20;
        double r12 = r10;
        double r13 = this.d;
        double r14 = ((r13 * r12) - ((double) r17)) / (r13 - this.f17123c);
        double r15 = r12 - r14;
        double r19 = (Math.exp(this.f17123c * r5) * r14) + (Math.exp(r13 * r5) * r15);
        double r20 = this.d;
        double r21 = Math.exp(r20 * r5) * (r15 * r20);
        double r22 = this.f17123c;
        double r23 = (Math.exp(r22 * r5) * (r14 * r22)) + r21;
    L23:
        long r24 = Float.floatToRawIntBits((float) (r19 + ((double) this.g)));
        return new e((((long) Float.floatToRawIntBits((float) r23)) & 4294967295L) | (r24 << 32));
    L20:
        if (r11 != 1.0f) goto L22;
        double r25 = this.f17121a;
        double r26 = r10;
        double r110 = (r25 * r26) + ((double) r17);
        double r27 = (r110 * r5) + r26;
        double r28 = Math.exp((-r25) * r5) * r27;
        double r29 = Math.exp((-this.f17121a) * r5) * r27;
        double r30 = -this.f17121a;
        double r31 = (Math.exp(r30 * r5) * r110) + (r29 * r30);
        r19 = r28;
        r23 = r31;
        goto L23
    L22:
        double r32 = ((double) 1) / this.e;
        double r111 = this.f17121a;
        double r33 = r10;
        double r34 = (((((double) r11) * r111) * r33) + ((double) r17)) * r32;
        double r35 = Math.exp((((double) (-r11)) * r111) * r5) * ((Math.sin(this.e * r5) * r34) + (Math.cos(this.e * r5) * r33));
        double r112 = this.f17121a;
        float r36 = this.f;
        double r113 = ((-r112) * r35) * ((double) r36);
        double r37 = Math.exp((((double) (-r36)) * r112) * r5);
        double r114 = this.e;
        double r38 = Math.sin(r114 * r5) * ((-r114) * r33);
        double r115 = this.e;
        r23 = (((Math.cos(r115 * r5) * (r34 * r115)) + r38) * r37) + r113;
        r19 = r35;
        goto L23
    L6:
        if (this.g == Float.MAX_VALUE) goto L26;
        float r39 = this.f;
        double r40 = r39;
        double r41 = r40 * r40;
        float r42 = 1;
        if (r39 <= r42) goto L11;
        double r43 = this.f17121a;
        double r44 = r41 - ((double) 1);
        this.f17123c = (Math.sqrt(r44) * r43) + (((double) (-r39)) * r43);
        double r45 = -this.f;
        double r46 = this.f17121a;
        this.d = (r45 * r46) - (Math.sqrt(r44) * r46);
    L15:
        this.f17122b = true;
        goto L16
    L11:
        if (r39 < 0) goto L15;
        if (r39 >= r42) goto L15;
        this.e = Math.sqrt(((double) 1) - r41) * this.f17121a;
        goto L15
    L26:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }
}
