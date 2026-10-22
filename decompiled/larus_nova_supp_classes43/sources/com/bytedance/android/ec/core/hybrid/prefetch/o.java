package com.bytedance.android.ec.core.hybrid.prefetch;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o {
    public final String a;
    public final int b;
    public final String c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof o) == false) goto L12;
        o r11 = (o) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r11.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = ((r10 * 31) + this.b) * 31;
        String r12 = this.c;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return r11 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "NativePrefetchResult(data=" + this.a + ", status=" + this.b + ", errorMessage=" + this.c + ")";
    }

    public o(String r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "data");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
