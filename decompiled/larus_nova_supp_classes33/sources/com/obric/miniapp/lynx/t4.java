package com.obric.miniapp.lynx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class t4 {
    public final String a;
    public final int b;
    public final String c;
    public final boolean d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t4) == true) goto L8;
        return false;
    L8:
        t4 r6 = (t4) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "MiniAppDialogActionItem(title=" + this.a + ", buttonStyleResId=" + this.b + ", eventType=" + this.c + ", disabled=" + this.d + ')';
    }

    public t4(String r2, int r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r4, "eventType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
