package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final int a;
    public final int b;
    public final tb2.c c;
    public final py.k d;
    public final int e;
    public final int f;
    public final float g;
    public final wb2.g h;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L22;
        b r4 = (b) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (Float.compare(this.g, r4.g) == 0) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        tb2.c r1 = this.c;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        py.k r5 = this.d;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (((((((r4 + r6) * 31) + this.e) * 31) + this.f) * 31) + Float.floatToIntBits(this.g)) * 31;
        wb2.g r8 = this.h;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "AsyncPieceInfo(startIndex=" + this.a + ", endIndex=" + this.b + ", tar=" + this.c + ", toloadImg=" + this.d + ", w=" + this.e + ", h=" + this.f + ", scale=" + this.g + ", placeHolderSpan=" + this.h + ")";
    }

    public b(int r2, int r3, tb2.c r4, py.k r5, int r6, int r7, float r8, wb2.g r9) {
        Intrinsics.checkNotNullParameter(r4, "tar");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
