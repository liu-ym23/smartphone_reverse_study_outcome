package y82;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public final a a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l) == false) goto L16;
        l r4 = (l) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
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
        a r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (((((((r1 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "MediaSpecificationParams(windowFrame=" + this.a + ", playerTopMargin=" + this.b + ", playerLeftMargin=" + this.c + ", playerWidth=" + this.d + ", playerHeight=" + this.e + ")";
    }

    public l(a r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "windowFrame");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
