package gr;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f17170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f17171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f17172c;
    public float d;
    public float e;
    public float f;

    public final void a(float r16, float r17, int r18, int r19, float[] r20) {
        float r5 = r20[0];
        float r10 = r20[1];
        float r11 = (r16 - 0.5f) * 2.0f;
        float r12 = (r17 - 0.5f) * 2.0f;
        float r13 = r5 + this.f17172c;
        float r14 = r10 + this.d;
        float r15 = (this.f17170a * r11) + r13;
        float r21 = (this.f17171b * r12) + r14;
        float r22 = (float) Math.toRadians(this.f);
        float r23 = (float) Math.toRadians(this.e);
        double r110 = r22;
        double r24 = r19 * r12;
        float r25 = (((float) ((Math.sin(r110) * ((double) ((-r18) * r11))) - (Math.cos(r110) * r24))) * r23) + r15;
        float r26 = (r23 * ((float) ((Math.cos(r110) * ((double) (r18 * r11))) - (Math.sin(r110) * r24)))) + r21;
        r20[0] = r25;
        r20[1] = r26;
    }
}
