package com.bytedance.android.live.revlink.impl.multianchor.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s {
    public final int a;
    public final int b;
    public final boolean c;
    public final c d;
    public final d e;
    public final int f;
    public final int g;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof s) == false) goto L20;
        s r4 = (s) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        boolean r1 = this.c;
        ?? r2 = r1;
        if (r1 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = (r0 + r2) * 31;
        c r4 = this.d;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        d r8 = this.e;
        if (r8 == null) goto L13;
        r5 = r8.hashCode();
    L13:
        return ((((r7 + r5) * 31) + this.f) * 31) + this.g;
    L8:
        r6 = 0;
        goto L9
    }

    public final String toString() {
        return "PkBarLayoutParams(width=" + this.a + ", height=" + this.b + ", isFloat=" + this.c + ", fixParam=" + this.d + ", floatOffset=" + this.e + ", horizontalContentMargin=" + this.f + ", horizontalScreenMargin=" + this.g + ")";
    }

    public s(int r2, int r3, boolean r4, c r5, d r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "fixParam");
        Intrinsics.checkNotNullParameter(r6, "floatOffset");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
