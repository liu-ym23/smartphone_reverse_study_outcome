package com.larus.bmhome.chat.layout.item;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f1 {
    public int a;
    public Integer b;
    public Boolean c;
    public Boolean d;
    public int e;

    public f1() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f1) == true) goto L8;
        return false;
    L8:
        f1 r6 = (f1) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        Integer r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Boolean r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Boolean r8 = this.d;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((r7 + r2) * 31) + this.e;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MessageBoxWidthInfo(lastBoxType=" + this.a + ", immerseBgColor=" + this.b + ", isShareMode=" + this.c + ", isSharePicMode=" + this.d + ", expandMaxWidth=" + this.e + ')';
    }

    public f1(int r2) {
        this.a = Integer.MIN_VALUE;
        this.b = Integer.MIN_VALUE;
        this.c = null;
        this.d = null;
        this.e = -1;
    }
}
