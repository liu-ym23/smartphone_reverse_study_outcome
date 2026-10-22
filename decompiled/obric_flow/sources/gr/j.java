package gr;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f17155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f17156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f17157c;
    public float d;
    public float e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f17158h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17159i;

    @Override // gr.l
    public final float a() {
        return 0.0f;
    }

    @Override // gr.l
    public final boolean b() {
        double r5 = ((double) this.e) - this.f17157c;
        double r10 = this.f17156b;
        double r11 = this.f;
        if (Math.sqrt((((r10 * r5) * r5) + ((r11 * r11) * ((double) this.g))) / r10) > this.f17158h) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // gr.l
    public final float getInterpolation(float r26) {
        j r5 = this;
        double r10 = r26 - r5.d;
        if (r10 > 0.0d) goto L5;
        j r11 = r5;
        float r12 = r26;
    L21:
        r11.d = r12;
        if (b() == false) goto L25;
        r11.e = (float) r11.f17157c;
    L25:
        return r11.e;
    L5:
        double r13 = r5.f17156b;
        double r14 = r5.f17155a;
        int r15 = (int) ((9.0d / ((Math.sqrt(r13 / ((double) r5.g)) * r10) * 4.0d)) + 1.0d);
        double r16 = r10 / ((double) r15);
        int r17 = 0;
    L6:
        if (r17 >= r15) goto L20;
        float r18 = r5.e;
        double r19 = r18;
        double r110 = r5.f17157c;
        int r111 = r15;
        int r112 = r17;
        double r20 = (-r13) * (r19 - r110);
        float r113 = r5.f;
        double r114 = r13;
        double r21 = r113;
        double r22 = r5.g;
        double r23 = ((((r20 - (r14 * r21)) / r22) * r16) / 2.0d) + r21;
        double r115 = ((((-((((r16 * r23) / 2.0d) + r19) - r110)) * r114) - (r23 * r14)) / r22) * r16;
        float r116 = r113 + ((float) r115);
        this.f = r116;
        float r117 = r18 + ((float) (((r115 / 2.0d) + r21) * r16));
        this.e = r117;
        int r24 = this.f17159i;
        if (r24 <= 0) goto L19;
        if (r117 < 0.0f) goto L12;
    L14:
        float r25 = this.e;
        if (r25 <= 1.0f) goto L19;
        if ((r24 & 2) != 2) goto L19;
        this.e = 2.0f - r25;
        this.f = -this.f;
        goto L19
    L12:
        if ((r24 & 1) != 1) goto L14;
        this.e = -r117;
        this.f = -r116;
    L19:
        r17 = r112 + 1;
        r5 = this;
        r15 = r111;
        r13 = r114;
        goto L6
    L20:
        r11 = r5;
        r12 = r26;
        goto L21
    }
}
