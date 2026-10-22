package com.larus.dora.obric.device_management.device_home;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s1 {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    public s1() {
        boolean r0 = false;
        this(r0, r0, r0, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s1) == true) goto L8;
        return false;
    L8:
        s1 r6 = (s1) r5;
        if (this.a == r6.a) goto L12;
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
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.d == true) goto L19;
        r1 = 1237;
    L19:
        return r6 + r1;
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraObricDeviceHomeUsageEvidence(hasBoundGlasses=" + this.a + ", hasBoundEarbuds=" + this.b + ", hasBoundGlassesHistory=" + this.c + ", hasDiaryData=" + this.d + ')';
    }

    public /* synthetic */ s1(boolean r3, boolean r4, boolean r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = false;
    L11:
        this(r3, r4, r5, false);
    }

    public static s1 a(s1 r3, boolean r4, boolean r5, int r6) {
        boolean r1 = false;
        if ((r6 & 1) == 0) goto L5;
        boolean r0 = r3.a;
    L7:
        if ((r6 & 2) == 0) goto L10;
        r1 = r3.b;
    L10:
        if ((r6 & 4) == 0) goto L13;
        r4 = r3.c;
    L13:
        if ((r6 & 8) == 0) goto L15;
        r5 = r3.d;
    L15:
        r3.getClass();
        return new s1(r0, r1, r4, r5);
    L5:
        r0 = false;
        goto L7
    }

    public s1(boolean r1, boolean r2, boolean r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
