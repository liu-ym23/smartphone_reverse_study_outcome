package com.larus.business.markdown.impl.markwon.custom.title;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final int a;
    public final int b;
    public final Integer c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
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
        if (this.l == r6.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        Integer r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((((((((((((r0 + r2) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "CodeBlockTitleStyleConfig(titleVerticalPadding=" + this.a + ", copyButton=" + this.b + ", fullScreenButton=" + this.c + ", previewButtonPaddingEnd=" + this.d + ", previewButtonPaddingStart=" + this.e + ", copyButtonPaddingEnd=" + this.f + ", copyButtonPaddingStart=" + this.g + ", fullScreenButtonPaddingEnd=" + this.h + ", fullScreenButtonPaddingStart=" + this.i + ", downloadButtonPaddingEnd=" + this.j + ", downloadButtonPaddingStart=" + this.k + ", titlePaddingEnd=" + this.l + ')';
    }

    public a(int r1, int r2, Integer r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12) {
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
    }
}
