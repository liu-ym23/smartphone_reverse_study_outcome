package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L16;
        i r4 = (i) r3;
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
        if (this.e == r4.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        return (((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public final String toString() {
        return "LynxLayout(widthPx=" + this.a + ", heightPx=" + this.b + ", leftMarginPx=" + this.c + ", topMarginPx=" + this.d + ", zOrder=" + this.e + ")";
    }

    public /* synthetic */ i(int r7, int r8, int r9, int r10) {
        this(r7, r8, r9, r10, 0);
    }

    public i(int r1, int r2, int r3, int r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
