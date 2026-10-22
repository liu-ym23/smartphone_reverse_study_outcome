package com.larus.uaigc.nowatermark;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationNoWatermarkManager$c {
    public final com.larus.uaigc.api.c a;
    public final com.larus.uaigc.api.c b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationNoWatermarkManager$c) == true) goto L8;
        return false;
    L8:
        CreationNoWatermarkManager$c r6 = (CreationNoWatermarkManager$c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        com.larus.uaigc.api.c r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        com.larus.uaigc.api.c r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "NoWatermarkImageResource(preview=" + this.a + ", download=" + this.b + ')';
    }

    public CreationNoWatermarkManager$c(com.larus.uaigc.api.c r1, com.larus.uaigc.api.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
