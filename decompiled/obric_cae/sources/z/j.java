package z;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final j f14157k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f14158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f14159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f14160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f14161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f14162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f14163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f14164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f14165h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f14166i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f14167j;

    static {
        float[] r8 = zc.b.f14335e;
        float r10 = (float) ((((double) zc.b.i()) * 63.66197723675813d) / 100.0d);
        float[][] r11 = zc.b.f14333c;
        float r12 = r8[0];
        float[] r13 = r11[0];
        float r14 = r13[0] * r12;
        float r15 = r8[1];
        float r16 = (r13[1] * r15) + r14;
        float r17 = r8[2];
        float r18 = (r13[2] * r17) + r16;
        float[] r19 = r11[1];
        float r110 = (r19[2] * r17) + ((r19[1] * r15) + (r19[0] * r12));
        float[] r20 = r11[2];
        float r111 = (r17 * r20[2]) + ((r15 * r20[1]) + (r12 * r20[0]));
        if (1.0f < 0.9d) goto L5;
        float r21 = 0.100000046f;
        float r112 = 0.59f;
    L6:
        float r113 = r21 + r112;
        float r22 = (1.0f - (((float) Math.exp(((-r10) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double r114 = r22;
        if (r114 <= 1.0d) goto L10;
        r22 = 1.0f;
    L12:
        float[] r115 = {(((100.0f / r18) * r22) + 1.0f) - r22, (((100.0f / r110) * r22) + 1.0f) - r22, (((100.0f / r111) * r22) + 1.0f) - r22};
        float r23 = 1.0f / ((5.0f * r10) + 1.0f);
        float r116 = ((r23 * r23) * r23) * r23;
        float r24 = 1.0f - r116;
        float r25 = (((0.1f * r24) * r24) * ((float) Math.cbrt(((double) r10) * 5.0d))) + (r116 * r10);
        float r117 = zc.b.i() / r8[1];
        double r26 = r117;
        float r27 = ((float) Math.sqrt(r26)) + 1.48f;
        float r28 = 0.725f / ((float) Math.pow(r26, 0.2d));
        float r29 = (float) Math.pow(((double) ((r115[2] * r25) * r111)) / 100.0d, 0.42d);
        float[] r30 = {(float) Math.pow(((double) ((r115[0] * r25) * r18)) / 100.0d, 0.42d), (float) Math.pow(((double) ((r115[1] * r25) * r110)) / 100.0d, 0.42d), r29};
        float r31 = r30[0];
        float r32 = r30[1];
        f14157k = new j(r117, ((((400.0f * r29) / (r29 + 27.13f)) * 0.05f) + ((((r31 * 400.0f) / (r31 + 27.13f)) * 2.0f) + ((r32 * 400.0f) / (r32 + 27.13f)))) * r28, r28, r28, r113, 1.0f, r115, r25, (float) Math.pow(r25, 0.25d), r27);
        return;
    L10:
        if (r114 >= 0.0d) goto L12;
        r22 = 0.0f;
        goto L12
    L5:
        r21 = 0.12999998f;
        r112 = 0.525f;
        goto L6
    }

    public j(float r8, float r10, float r11, float r12, float r13, float r14, float[] r15, float r16, float r17, float r18) {
        this.f14163f = r8;
        this.f14158a = r10;
        this.f14159b = r11;
        this.f14160c = r12;
        this.f14161d = r13;
        this.f14162e = r14;
        this.f14164g = r15;
        this.f14165h = r16;
        this.f14166i = r17;
        this.f14167j = r18;
    }
}
