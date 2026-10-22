package cd8;

import jc8.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements l {
    public final int a;
    public final int b;

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
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b;
    }

    public final String toString() {
        return "MaxWidthDataWrapper(maxContentWidth=" + this.a + ", maxBoxWidth=" + this.b + ')';
    }

    public a(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
