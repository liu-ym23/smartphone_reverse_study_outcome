package com.obric.assistant.cocreationreview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u5 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u5) == true) goto L8;
        return false;
    L8:
        u5 r6 = (u5) r5;
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
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public final String toString() {
        return "SummaryStats(total=" + this.a + ", completed=" + this.b + ", pending=" + this.c + ", up=" + this.d + ", down=" + this.e + ')';
    }

    public u5(int r1, int r2, int r3, int r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
