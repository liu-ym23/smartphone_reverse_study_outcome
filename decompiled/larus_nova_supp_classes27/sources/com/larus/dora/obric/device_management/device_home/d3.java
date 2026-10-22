package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d3 {
    public final f3 a;
    public final y2 b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d3) == true) goto L8;
        return false;
    L8:
        d3 r6 = (d3) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        y2 r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoraObricGlassesModeSheetResult(state=" + this.a + ", effect=" + this.b + ')';
    }

    public d3(f3 r2, y2 r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a = r2;
        this.b = r3;
    }
}
