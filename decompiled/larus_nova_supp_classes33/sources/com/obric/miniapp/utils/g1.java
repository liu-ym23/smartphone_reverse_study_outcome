package com.obric.miniapp.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g1 {
    public final int a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g1) == true) goto L8;
        return false;
    L8:
        g1 r6 = (g1) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b;
    }

    public final String toString() {
        return "TransitionRes(enterAnim=" + this.a + ", exitAnim=" + this.b + ')';
    }

    public g1(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
