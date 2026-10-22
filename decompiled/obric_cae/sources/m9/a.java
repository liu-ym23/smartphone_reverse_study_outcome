package m9;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f9301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f9304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f9305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f9306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f9307h;

    public a(int r8, float r10, float r11, float r12, int r13, float r14, int r15, float r16, int r17, float r18) {
        this.f9300a = r8;
        float r19 = t2.b.o(r10, r11, r12);
        this.f9301b = r19;
        this.f9302c = r13;
        this.f9304e = r14;
        this.f9303d = r15;
        this.f9305f = r16;
        this.f9306g = r17;
        float r20 = r17;
        float r21 = (r14 * r15) + (r16 * r20);
        float r110 = r13;
        float r22 = r18 - ((r110 * r19) + r21);
        if (r13 > 0) goto L5;
    L7:
        if (r13 > 0) goto L9;
    L12:
        int r23 = this.f9302c;
        if (r23 <= 0) goto L15;
        float r24 = this.f9301b;
    L16:
        this.f9301b = r24;
        int r25 = this.f9303d;
        if (r23 <= 0) goto L19;
        float r26 = r24;
    L20:
        float r27 = r25;
        float r28 = r27 / 2.0f;
        float r111 = (r18 - ((r23 + r28) * r26)) / (r28 + r20);
        this.f9305f = r111;
        float r29 = (r24 + r111) / 2.0f;
        this.f9304e = r29;
        if (r25 > 0) goto L23;
    L28:
        boolean r30 = true;
        if (r17 > 0) goto L31;
    L39:
        if (r17 > 0) goto L41;
    L46:
        if (r30 == true) goto L48;
        float r31 = Float.MAX_VALUE;
    L49:
        this.f9307h = r31;
        return;
    L48:
        r31 = r8 * Math.abs(r16 - this.f9305f);
        goto L49
    L41:
        if (this.f9302c <= 0) goto L46;
        if (this.f9305f > this.f9301b) goto L46;
    L45:
        r30 = false;
        goto L46
    L31:
        if (this.f9302c <= 0) goto L39;
        if (this.f9303d <= 0) goto L39;
        float r32 = this.f9305f;
        float r33 = this.f9304e;
        if (r32 <= r33) goto L45;
        if (r33 <= this.f9301b) goto L45;
    L23:
        if (r111 == r16) goto L28;
        float r34 = (r16 - r111) * r20;
        float r35 = Math.min(Math.abs(r34), (r29 * 0.1f) * r27);
        if (r34 <= 0.0f) goto L27;
        this.f9304e -= r35 / this.f9303d;
        this.f9305f = (r35 / r20) + this.f9305f;
        goto L28
    L27:
        this.f9304e = (r35 / this.f9303d) + this.f9304e;
        this.f9305f -= r35 / r20;
        goto L28
    L19:
        r26 = 0.0f;
        goto L20
    L15:
        r24 = 0.0f;
        goto L16
    L9:
        if (r22 >= 0.0f) goto L12;
        float r36 = Math.max(r22 / r110, r11 - r19);
    L11:
        this.f9301b = r36 + r19;
        goto L12
    L5:
        if (r22 <= 0.0f) goto L7;
        r36 = Math.min(r22 / r110, r12 - r19);
        goto L11
    }

    public static a a(float r25, float r26, float r27, float r28, int[] r29, float r30, int[] r31, float r32, int[] r33) {
        int r8 = r33.length;
        a r10 = null;
        int r11 = 1;
        int r12 = 0;
    L3:
        if (r12 >= r8) goto L19;
        int r19 = r33[r12];
        int r15 = r31.length;
        int r14 = 0;
    L5:
        if (r14 >= r15) goto L18;
        int r20 = r31[r14];
        int r13 = r29.length;
        int r16 = 0;
    L7:
        if (r16 >= r13) goto L17;
        int r17 = r11;
        int r21 = r16;
        int r22 = r13;
        int r23 = r14;
        int r24 = r15;
        a r18 = new a(r17, r26, r27, r28, r29[r16], r30, r20, r32, r19, r25);
        float r34 = r18.f9307h;
        if (r10 == null) goto L13;
        if (r34 < r10.f9307h) goto L13;
    L16:
        r11 = r11 + 1;
        r16 = r21 + 1;
        r13 = r22;
        r14 = r23;
        r15 = r24;
    L13:
        if (r34 == 0.0f) goto L14;
        r10 = r18;
        goto L16
    L14:
        return r18;
    L17:
        r14 = r14 + 1;
        goto L5
    L18:
        r12 = r12 + 1;
        goto L3
    L19:
        return r10;
    }

    public final String toString() {
        return "Arrangement [priority=" + this.f9300a + ", smallCount=" + this.f9302c + ", smallSize=" + this.f9301b + ", mediumCount=" + this.f9303d + ", mediumSize=" + this.f9304e + ", largeCount=" + this.f9306g + ", largeSize=" + this.f9305f + ", cost=" + this.f9307h + "]";
    }
}
