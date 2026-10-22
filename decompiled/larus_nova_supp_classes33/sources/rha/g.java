package rha;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g {
    public final int a;
    public final int b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "SecondaryMenuItemInfo(id=" + this.a + ", imageSrc=" + this.b + ", title=" + this.c + ')';
    }

    public g(int r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "title");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
