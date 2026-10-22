package c61;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public final int a;
    public final Float b;
    public final Float c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    public h() {
        this(0, 0, 127);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof h) == false) goto L20;
        h r4 = (h) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
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

    public final int hashCode() {
        int r0 = this.a * 31;
        Float r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        Float r5 = this.c;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return ((((((((r4 + r2) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g;
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "InitLocationConfig(initGravity=" + this.a + ", initX=" + this.b + ", initY=" + this.c + ", leftX=" + this.d + ", topY=" + this.e + ", rightX=" + this.f + ", bottomY=" + this.g + ")";
    }

    public h(int r6, int r7, int r8) {
        if ((r8 & 1) == 0) goto L5;
        r6 = 3;
    L5:
        int r2 = 0;
        if ((r8 & 8) == 0) goto L8;
        int r0 = -1;
    L10:
        if ((r8 & 16) == 0) goto L12;
        int r3 = -1;
    L14:
        if ((r8 & 32) == 0) goto L17;
        r2 = -1;
    L17:
        if ((r8 & 64) == 0) goto L19;
        r7 = -1;
    L19:
        this.a = r6;
        this.b = null;
        this.c = null;
        this.d = r0;
        this.e = r3;
        this.f = r2;
        this.g = r7;
        return;
    L12:
        r3 = 0;
        goto L14
    L8:
        r0 = 0;
        goto L10
    }
}
