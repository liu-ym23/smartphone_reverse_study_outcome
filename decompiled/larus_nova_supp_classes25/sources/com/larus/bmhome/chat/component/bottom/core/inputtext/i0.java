package com.larus.bmhome.chat.component.bottom.core.inputtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i0 {
    public final String a;
    public final int b;
    public final String c;
    public final String d;

    public i0() {
        int r2 = 0;
        this(r2, null, 15);
    }

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "InputReferenceDocumentIcon(token=" + this.a + ", objType=" + this.b + ", iconInfo=" + this.c + ", url=" + this.d + ')';
    }

    public /* synthetic */ i0(int r5, String r6, int r7) {
        String r1 = null;
        if ((r7 & 1) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r7 & 2) == 0) goto L10;
        r5 = 0;
    L10:
        if ((r7 & 4) == 0) goto L13;
        r1 = "";
    L13:
        if ((r7 & 8) == 0) goto L15;
        r6 = "";
    L15:
        this(r0, r5, r1, r6);
        return;
    L5:
        r0 = null;
        goto L7
    }

    public i0(String r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r4, "iconInfo");
        Intrinsics.checkNotNullParameter(r5, "url");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
