package com.larus.bmhome.chat.cell.slot;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g0 implements ei9.f {
    public final Object a;
    public final xc8.b b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r6 = (g0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Object r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.b.hashCode()) * 31) + this.c;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "MessageRetryBlockState(holder=" + this.a + ", data=" + this.b + ", boxType=" + this.c + ')';
    }

    public g0(xc8.b r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a = null;
        this.b = r2;
        this.c = r3;
    }
}
