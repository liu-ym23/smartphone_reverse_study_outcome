package com.larus.bmhome.share.panel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public g() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "NewShareData(newQRCodeUrl=" + this.a + ", oldQRCodeUrl=" + this.b + ", newShareUrl=" + this.c + ", oldShareUrl=" + this.d + ')';
    }

    public /* synthetic */ g(int r1) {
        this("", "", "", "");
    }

    public g(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "newQRCodeUrl");
        Intrinsics.checkNotNullParameter(r3, "oldQRCodeUrl");
        Intrinsics.checkNotNullParameter(r4, "newShareUrl");
        Intrinsics.checkNotNullParameter(r5, "oldShareUrl");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
