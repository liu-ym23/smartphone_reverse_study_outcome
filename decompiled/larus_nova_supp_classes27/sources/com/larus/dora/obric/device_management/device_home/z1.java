package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z1 {
    public final DoraObricDeviceModeEntryLabel a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final float e;
    public final DoraObricDeviceModeIndicator f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof z1) == true) goto L8;
        return false;
    L8:
        z1 r6 = (z1) r5;
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
        if (Float.compare(this.e, r6.e) == 0) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.d == true) goto L15;
        r2 = 1237;
    L15:
        return ((((r5 + r2) * 31) + Float.floatToIntBits(this.e)) * 31) + this.f.hashCode();
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraObricDeviceModeEntryPresentation(label=" + this.a + ", isEnabled=" + this.b + ", isInteractive=" + this.c + ", showChevron=" + this.d + ", contentAlpha=" + this.e + ", indicator=" + this.f + ')';
    }

    public z1(DoraObricDeviceModeEntryLabel r2, boolean r3, boolean r4, boolean r5, float r6, DoraObricDeviceModeIndicator r7) {
        Intrinsics.checkNotNullParameter(r2, "label");
        Intrinsics.checkNotNullParameter(r7, "indicator");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
