package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a3 {
    public final DoraObricGlassesMode a;
    public final boolean b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a3) == true) goto L8;
        return false;
    L8:
        a3 r6 = (a3) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraObricGlassesModeSheetOption(mode=" + this.a + ", isSelected=" + this.b + ')';
    }

    public a3(DoraObricGlassesMode r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        this.a = r2;
        this.b = r3;
    }
}
