package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;

    public f() {
        this(0, 524287);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L44;
        f r4 = (f) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (this.i == r4.i) goto L24;
        return false;
    L24:
        if (this.j == r4.j) goto L26;
        return false;
    L26:
        if (this.k == r4.k) goto L28;
        return false;
    L28:
        if (this.l == r4.l) goto L30;
        return false;
    L30:
        if (this.m == r4.m) goto L32;
        return false;
    L32:
        if (this.n == r4.n) goto L34;
        return false;
    L34:
        if (this.o == r4.o) goto L36;
        return false;
    L36:
        if (this.p == r4.p) goto L38;
        return false;
    L38:
        if (this.q == r4.q) goto L40;
        return false;
    L40:
        if (this.r == r4.r) goto L42;
        return false;
    L42:
        if (this.s == r4.s) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public final int hashCode() {
        int r0 = ((((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
        boolean r1 = this.g;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return ((((((((((((((((((((((((r0 + r2) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31) + this.s;
    }

    public final String toString() {
        return "RangeSeekBarConfig(gravity=" + this.a + ", seekBarMode=" + this.b + ", progressColor=" + this.c + ", progressDefaultColor=" + this.d + ", progressHeight=" + this.e + ", progressRadius=" + this.f + ", isStepCircleStyle=" + this.g + ", stepsColor=" + this.h + ", stepsCircleBorderColor=" + this.i + ", stepsHeight=" + this.j + ", stepsWidth=" + this.k + ", thumbBorderColor=" + this.l + ", leftThumbHeight=" + this.m + ", leftThumbWidth=" + this.n + ", rightThumbHeight=" + this.o + ", rightThumbWidth=" + this.p + ", leftIndicatorShowMode=" + this.q + ", rightIndicatorShowMode=" + this.r + ", stepCount=" + this.s + ")";
    }

    public f(int r23, int r24) {
        int r4 = 2;
        if ((r24 & 1) == 0) goto L5;
        int r2 = 2;
    L7:
        if ((r24 & 2) == 0) goto L9;
        int r5 = 1;
    L11:
        if ((r24 & 4) == 0) goto L13;
        int r7 = 2131108290;
    L15:
        if ((r24 & 8) == 0) goto L17;
        int r8 = 2131108291;
    L18:
        int r10 = 3;
        if ((r24 & 16) == 0) goto L21;
        int r9 = 3;
    L23:
        if ((r24 & 32) != 0) goto L27;
        r4 = 0;
    L27:
        if ((r24 & 64) == 0) goto L29;
        boolean r11 = true;
    L31:
        if ((r24 & 128) == 0) goto L33;
        int r13 = 2131108294;
    L35:
        if ((r24 & 256) == 0) goto L37;
        int r14 = 2131108293;
    L39:
        if ((r24 & 512) == 0) goto L41;
        int r15 = 3;
    L43:
        if ((r24 & 1024) != 0) goto L47;
        r10 = 0;
    L47:
        if ((r24 & 2048) == 0) goto L49;
        int r16 = 2131108295;
    L51:
        if ((r24 & 4096) == 0) goto L53;
        int r3 = 12;
    L55:
        if ((r24 & 8192) == 0) goto L57;
        int r6 = 12;
    L58:
        int r17 = r6;
        if ((r24 & 16384) == 0) goto L61;
        int r18 = 12;
    L63:
        if ((r24 & 32768) == 0) goto L65;
        int r19 = 12;
    L67:
        if ((r24 & 65536) == 0) goto L69;
        int r20 = 1;
    L71:
        if ((r24 & 131072) == 0) goto L73;
        int r21 = 1;
    L75:
        if ((r24 & 262144) == 0) goto L77;
        int r1 = 0;
    L78:
        this.a = r2;
        this.b = r5;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r4;
        this.g = r11;
        this.h = r13;
        this.i = r14;
        this.j = r15;
        this.k = r10;
        this.l = r16;
        this.m = r3;
        this.n = r17;
        this.o = r18;
        this.p = r19;
        this.q = r20;
        this.r = r21;
        this.s = r1;
        return;
    L77:
        r1 = r23;
        goto L78
    L73:
        r21 = 0;
        goto L75
    L69:
        r20 = 0;
        goto L71
    L65:
        r19 = 0;
        goto L67
    L61:
        r18 = 0;
        goto L63
    L57:
        r6 = 0;
        goto L58
    L53:
        r3 = 0;
        goto L55
    L49:
        r16 = 0;
        goto L51
    L41:
        r15 = 0;
        goto L43
    L37:
        r14 = 0;
        goto L39
    L33:
        r13 = 0;
        goto L35
    L29:
        r11 = false;
        goto L31
    L21:
        r9 = 0;
        goto L23
    L17:
        r8 = 0;
        goto L18
    L13:
        r7 = 0;
        goto L15
    L9:
        r5 = 0;
        goto L11
    L5:
        r2 = 0;
        goto L7
    }
}
