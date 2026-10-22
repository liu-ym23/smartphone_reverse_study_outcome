package y7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public final boolean a;
    public final boolean b;
    public final String c;
    public final String d;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof g) == true) goto L8;
        return false;
    L8:
        g r11 = (g) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r10 = r0 * 31;
        if (this.b == true) goto L10;
        r1 = 1237;
    L10:
        int r11 = (((r10 + r1) * 31) + this.c.hashCode()) * 31;
        String r12 = this.d;
        if (r12 != null) goto L13;
        int r13 = 0;
    L15:
        return r11 + r13;
    L13:
        r13 = r12.hashCode();
        goto L15
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfflineState(offline=" + this.a + ", useForest=" + this.b + ", resFrom=" + this.c + ", version=" + this.d + ')';
    }

    public g(boolean r10, boolean r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "resFrom");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
    }
}
