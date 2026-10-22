package gr;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f17160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f17161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f17162c;
    public float d;
    public float e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f17163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f17164i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f17165j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f17166k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f17167l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f17168m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f17169n;

    @Override // gr.l
    public final float a() {
        if (this.f17166k == false) goto L6;
        return -c(this.f17169n);
    L6:
        return c(this.f17169n);
    }

    @Override // gr.l
    public final boolean b() {
        if (a() < 1.0E-5f) goto L5;
    L7:
        return false;
    L5:
        if (Math.abs(this.f17164i - this.f17168m) >= 1.0E-5f) goto L7;
        return true;
    }

    public final float c(float r5) {
        float r10 = this.d;
        if (r5 > r10) goto L6;
        float r11 = this.f17160a;
        return (((this.f17161b - r11) * r5) / r10) + r11;
    L6:
        int r12 = this.f17165j;
        if (r12 != 1) goto L9;
        return 0.0f;
    L9:
        float r13 = r5 - r10;
        float r14 = this.e;
        if (r13 >= r14) goto L14;
        float r15 = this.f17161b;
        return (((this.f17162c - r15) * r13) / r14) + r15;
    L14:
        if (r12 != 2) goto L16;
        return 0.0f;
    L16:
        float r16 = r13 - r14;
        float r17 = this.f;
        if (r16 >= r17) goto L20;
        float r18 = this.f17162c;
        return r18 - ((r16 * r18) / r17);
    L20:
        return 0.0f;
    }

    public final void d(float r10, float r11, float r12, float r13, float r14) {
        this.f17164i = r11;
        if (r10 != 0.0f) goto L5;
        r10 = 1.0E-4f;
    L5:
        float r5 = r10 / r12;
        float r15 = (r5 * r10) / 2.0f;
        if (r10 >= 0.0f) goto L14;
        float r16 = (float) Math.sqrt((r11 - ((((-r10) / r12) * r10) / 2.0f)) * r12);
        if (r16 >= r13) goto L11;
        this.f17165j = 2;
        this.f17160a = r10;
        this.f17161b = r16;
        this.f17162c = 0.0f;
        float r17 = (r16 - r10) / r12;
        this.d = r17;
        this.e = r16 / r12;
        this.g = ((r10 + r16) * r17) / 2.0f;
        this.f17163h = r11;
        this.f17164i = r11;
        return;
    L11:
        this.f17165j = 3;
        this.f17160a = r10;
        this.f17161b = r13;
        this.f17162c = r13;
        float r18 = (r13 - r10) / r12;
        this.d = r18;
        float r19 = r13 / r12;
        this.f = r19;
        float r20 = ((r10 + r13) * r18) / 2.0f;
        float r110 = (r19 * r13) / 2.0f;
        this.e = ((r11 - r20) - r110) / r13;
        this.g = r20;
        this.f17163h = r11 - r110;
        this.f17164i = r11;
        return;
    L14:
        if (r15 < r11) goto L17;
        this.f17165j = 1;
        this.f17160a = r10;
        this.f17161b = 0.0f;
        this.g = r11;
        this.d = (2.0f * r11) / r10;
        return;
    L17:
        float r21 = r11 - r15;
        float r22 = r21 / r10;
        if ((r22 + r5) >= r14) goto L21;
        this.f17165j = 2;
        this.f17160a = r10;
        this.f17161b = r10;
        this.f17162c = 0.0f;
        this.g = r21;
        this.f17163h = r11;
        this.d = r22;
        this.e = r5;
        return;
    L21:
        float r111 = (float) Math.sqrt(((r10 * r10) / 2.0f) + (r12 * r11));
        float r23 = (r111 - r10) / r12;
        this.d = r23;
        float r24 = r111 / r12;
        this.e = r24;
        if (r111 >= r13) goto L25;
        this.f17165j = 2;
        this.f17160a = r10;
        this.f17161b = r111;
        this.f17162c = 0.0f;
        this.d = r23;
        this.e = r24;
        this.g = ((r10 + r111) * r23) / 2.0f;
        this.f17163h = r11;
        return;
    L25:
        this.f17165j = 3;
        this.f17160a = r10;
        this.f17161b = r13;
        this.f17162c = r13;
        float r112 = (r13 - r10) / r12;
        this.d = r112;
        float r113 = r13 / r12;
        this.f = r113;
        float r25 = ((r10 + r13) * r112) / 2.0f;
        float r114 = (r113 * r13) / 2.0f;
        this.e = ((r11 - r25) - r114) / r13;
        this.g = r25;
        this.f17163h = r11 - r114;
        this.f17164i = r11;
    }

    @Override // gr.l
    public final float getInterpolation(float r10) {
        float r5 = this.d;
        if (r10 > r5) goto L5;
        float r11 = this.f17160a;
        float r12 = (((this.f17161b - r11) * r10) * r10) / (r5 * 2.0f);
        float r13 = r12 + (r11 * r10);
    L18:
        this.f17168m = r13;
        this.f17169n = r10;
        boolean r14 = this.f17166k;
        float r15 = this.f17167l;
        if (r14 == false) goto L22;
        return r15 - r13;
    L22:
        return r15 + r13;
    L5:
        int r16 = this.f17165j;
        if (r16 != 1) goto L8;
        r13 = this.g;
        goto L18
    L8:
        float r17 = r10 - r5;
        float r18 = this.e;
        if (r17 >= r18) goto L12;
        float r19 = this.g;
        float r20 = this.f17161b;
        float r21 = (r20 * r17) + r19;
        r13 = ((((this.f17162c - r20) * r17) * r17) / (r18 * 2.0f)) + r21;
        goto L18
    L12:
        if (r16 != 2) goto L14;
        r13 = this.f17163h;
        goto L18
    L14:
        float r22 = r17 - r18;
        float r23 = this.f;
        if (r22 > r23) goto L17;
        float r24 = this.f17163h;
        float r25 = this.f17162c * r22;
        r13 = (r24 + r25) - ((r25 * r22) / (r23 * 2.0f));
        goto L18
    L17:
        r13 = this.f17164i;
        goto L18
    }
}
