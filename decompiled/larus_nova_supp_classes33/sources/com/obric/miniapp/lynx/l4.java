package com.obric.miniapp.lynx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l4 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;
    public final Integer g;
    public final Integer h;
    public final Integer i;
    public final Integer j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l4) == true) goto L8;
        return false;
    L8:
        l4 r6 = (l4) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
        if (this.f == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        Integer r3 = this.g;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        Integer r7 = this.h;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.i;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.j;
        if (r13 == null) goto L23;
        r4 = r13.hashCode();
    L23:
        return r12 + r4;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MenuContentSnapshot(left=" + this.a + ", top=" + this.b + ", width=" + this.c + ", height=" + this.d + ", depth=" + this.e + ", isLeaf=" + this.f + ", boundLeft=" + this.g + ", boundTop=" + this.h + ", boundRight=" + this.i + ", boundBottom=" + this.j + ')';
    }

    public l4(int r1, int r2, int r3, int r4, int r5, boolean r6, Integer r7, Integer r8, Integer r9, Integer r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
