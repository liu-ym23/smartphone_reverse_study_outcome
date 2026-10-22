package pc0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public final int a;
    public final Integer b;
    public final Integer c;
    public final int d;
    public final int e;

    public d() {
        this(null, 31);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L16;
        d r4 = (d) r3;
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
        if (this.e == r4.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        Integer r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.c;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return ((((r4 + r2) * 31) + this.d) * 31) + this.e;
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "PkExposeData(leftTime=" + this.a + ", pkState=" + this.b + ", playMode=" + this.c + ", iconId=" + this.d + ", loadStatus=" + this.e + ")";
    }

    public /* synthetic */ d(Integer r7, int r8) {
        if ((r8 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(0, r7, null, 0, 0);
    }

    public d(int r1, Integer r2, Integer r3, int r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
