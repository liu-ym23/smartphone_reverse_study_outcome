package com.larus.bmhome.chat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MarkdownResolver$a {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public MarkdownResolver$a() {
        this(false, false, false, false, false, false, false, false, false);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MarkdownResolver$a) == true) goto L8;
        return false;
    L8:
        MarkdownResolver$a r6 = (MarkdownResolver$a) r5;
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
        if (this.i == r6.i) goto L35;
        return false;
    L35:
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
        int r4 = (r2 + r3) * 31;
        if (this.c == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.d == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.e == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.f == false) goto L25;
        int r11 = 1231;
    L26:
        int r12 = (r10 + r11) * 31;
        if (this.g == false) goto L29;
        int r13 = 1231;
    L30:
        int r14 = (r12 + r13) * 31;
        if (this.h == false) goto L33;
        int r15 = 1231;
    L34:
        int r16 = (r14 + r15) * 31;
        if (this.i == true) goto L39;
        r1 = 1237;
    L39:
        return r16 + r1;
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
        return "LinkInfo(isSoftLink=" + this.a + ", isBrowserLink=" + this.b + ", isAppletLink=" + this.c + ", isExternalAppLink=" + this.d + ", isBlueSoftWithoutUnderLine=" + this.e + ", isSSLocalLink=" + this.f + ", isSSLocalWebViewLink=" + this.g + ", isSSBrowserLink=" + this.h + ", isSSOpenFileLink=" + this.i + ')';
    }

    public MarkdownResolver$a(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
