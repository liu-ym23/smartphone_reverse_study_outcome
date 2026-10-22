package hda;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i0 {
    public final String a;
    public final boolean b;
    public final int c;
    public final int d;
    public final String e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r6 = (i0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((r0 + r1) * 31) + this.c) * 31) + this.d;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "MemoryReviewImageRequest(uriText=" + this.a + ", preferFullSize=" + this.b + ", targetWidthPx=" + this.c + ", targetHeightPx=" + this.d + ')';
    }

    public i0(String r2, boolean r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "uriText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        StringBuilder r0 = new StringBuilder();
        r0.append(r2);
        r0.append('@');
        if (r3 == false) goto L5;
        String r6 = "full";
    L6:
        r0.append(r6);
        r0.append(':');
        r0.append(r4);
        r0.append('x');
        r0.append(r5);
        this.e = r0.toString();
        return;
    L5:
        r6 = "thumb";
        goto L6
    }
}
