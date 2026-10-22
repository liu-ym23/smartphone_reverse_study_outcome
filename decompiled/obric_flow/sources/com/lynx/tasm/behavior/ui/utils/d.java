package com.lynx.tasm.behavior.ui.utils;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f10742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f10743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c[] f10744c;
    public float[] d;

    public d() {
        this.f10742a = 0.0f;
        this.f10743b = 0.0f;
    }

    public final boolean a(float r5, float r10) {
        if (r5 >= 0.0f) goto L5;
    L7:
        r5 = 0.0f;
    L9:
        if (r10 >= 0.0f) goto L11;
    L13:
        r10 = 0.0f;
    L15:
        if (com.lynx.tasm.utils.a.k(r5, this.f10742a) == true) goto L17;
    L23:
        this.f10742a = r5;
        this.f10743b = r10;
        this.d = null;
        return true;
    L17:
        if (com.lynx.tasm.utils.a.k(r10, this.f10743b) == false) goto L23;
        if (this.d != null) goto L21;
        return true;
    L21:
        return false;
    L11:
        if (ym.k.b(r10) == true) goto L13;
    L5:
        if (ym.k.b(r5) == true) goto L7;
        goto L7
    }

    public final boolean b(int r5, c r10) {
        if (r5 >= 0) goto L5;
    L14:
        return false;
    L5:
        if (r5 >= 4) goto L14;
        if (this.f10744c != null) goto L11;
        this.f10744c = new c[4];
    L11:
        if (r10.equals(this.f10744c[r5]) == true) goto L14;
        this.f10744c[r5] = r10;
        return true;
    }

    public final float[] c() {
        float[] r5 = this.d;
        if (r5 == null) goto L5;
        return r5;
    L5:
        float[] r10 = new float[8];
        int r11 = 0;
        if (this.f10744c != null) goto L10;
        int r12 = 0;
    L8:
        if (r12 >= 8) goto L20;
        r10[r12] = 0.0f;
        r12 = r12 + 1;
    L20:
        this.d = r10;
        if (com.lynx.tasm.utils.a.k(this.f10742a, 0.0f) == true) goto L51;
        if (com.lynx.tasm.utils.a.k(this.f10743b, 0.0f) == true) goto L51;
        float[] r13 = this.d;
        float r14 = r13[0] + r13[2];
        float r15 = this.f10742a;
        if (r14 <= r15) goto L30;
        float r16 = r15 / r14;
        if (r16 >= 1.0f) goto L30;
    L31:
        float r17 = r13[4] + r13[6];
        if (r17 <= r15) goto L36;
        float r18 = r15 / r17;
        if (r18 >= r16) goto L36;
        r16 = r18;
    L36:
        float r19 = r13[1] + r13[7];
        float r20 = this.f10743b;
        if (r19 <= r20) goto L41;
        float r21 = r20 / r19;
        if (r21 >= r16) goto L41;
        r16 = r21;
    L41:
        float r22 = r13[3] + r13[5];
        if (r22 <= r20) goto L47;
        float r23 = r20 / r22;
        if (r23 >= r16) goto L47;
        r16 = r23;
    L47:
        if (r16 >= 1.0f) goto L51;
    L48:
        if (r11 >= 8) goto L51;
        r13[r11] = r13[r11] * r16;
        r11 = r11 + 1;
    L30:
        r16 = 1.0f;
    L51:
        return this.d;
    L10:
        int r24 = 0;
    L11:
        if (r24 >= 4) goto L20;
        c r25 = this.f10744c[r24];
        int r26 = r24 * 2;
        int r27 = r26 + 1;
        if (r25 == null) goto L18;
        k r28 = r25.f10740a;
        if (r28 == null) goto L18;
        float r110 = this.f10742a;
        r10[r26] = k.b(r28.f10754c, r28.f10753b, r28.f10752a, r110);
        k r29 = r25.f10741b;
        r10[r27] = k.b(r29.f10754c, r29.f10753b, r29.f10752a, this.f10743b);
    L19:
        r24 = r24 + 1;
    L18:
        r10[r27] = 0.0f;
        r10[r26] = 0.0f;
        goto L19
    }

    public final boolean d() {
        c[] r10 = this.f10744c;
        if (r10 == null) goto L23;
        int r5 = r10.length;
        int r11 = 0;
    L5:
        if (r11 >= r5) goto L23;
        c r12 = r10[r11];
        if (r12 == null) goto L22;
        k r13 = r12.f10740a;
        if (r13 == null) goto L22;
        if (r13.f10752a == 2) goto L20;
        if (r13.f10753b != 0.0f) goto L32;
        k r14 = r12.f10741b;
        if (r14.f10752a == 2) goto L33;
        if (r14.f10753b == 0.0f) goto L22;
        return true;
    L33:
        return true;
    L32:
        return true;
    L20:
        return true;
    L22:
        r11 = r11 + 1;
    L23:
        return false;
    }
}
