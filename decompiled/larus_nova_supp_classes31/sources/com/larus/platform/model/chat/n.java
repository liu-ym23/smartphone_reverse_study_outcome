package com.larus.platform.model.chat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n {
    public final boolean a;
    public final boolean b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final int m;
    public final float n;

    public n() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (Float.compare(this.n, r6.n) == 0) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (((r2 + r3) * 31) + this.c) * 31;
        if (this.d == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.e == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.f == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.g == false) goto L25;
        int r11 = 1231;
    L26:
        int r12 = (r10 + r11) * 31;
        if (this.h == false) goto L29;
        int r13 = 1231;
    L30:
        int r14 = (r12 + r13) * 31;
        if (this.i == false) goto L33;
        int r15 = 1231;
    L34:
        int r16 = (r14 + r15) * 31;
        if (this.j == false) goto L37;
        int r17 = 1231;
    L38:
        int r18 = (r16 + r17) * 31;
        if (this.k == false) goto L41;
        int r19 = 1231;
    L42:
        int r20 = (r18 + r19) * 31;
        if (this.l == true) goto L47;
        r1 = 1237;
    L47:
        return ((((r20 + r1) * 31) + this.m) * 31) + Float.floatToIntBits(this.n);
    L41:
        r19 = 1237;
        goto L42
    L37:
        r17 = 1237;
        goto L38
    L33:
        r15 = 1237;
        goto L34
    L29:
        r13 = 1237;
        goto L30
    L25:
        r11 = 1237;
        goto L26
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreationPreviewPerformanceOptConfig(ugcPreviewArgb=" + this.a + ", bigImageFullSizeResize=" + this.b + ", bigImageFullSizeResizeSize=" + this.c + ", previewGalleryUseHeic=" + this.d + ", msgCardResize=" + this.e + ", feedRefResize=" + this.f + ", feedAvatarResize=" + this.g + ", feedArgb=" + this.h + ", feedCoverSr=" + this.i + ", videoCoverResize=" + this.j + ", videoCoverArgb=" + this.k + ", canvasResize=" + this.l + ", largeMemGb=" + this.m + ", srMinRatio=" + this.n + ')';
    }

    public /* synthetic */ n(int r16) {
        this(false, false, 5000, false, false, false, false, false, false, false, false, false, 6, 1.1f);
    }

    public n(boolean r1, boolean r2, int r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, int r13, float r14) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
    }
}
