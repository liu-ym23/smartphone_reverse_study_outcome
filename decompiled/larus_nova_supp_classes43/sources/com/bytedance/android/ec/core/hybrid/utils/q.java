package com.bytedance.android.ec.core.hybrid.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q {
    public final String a;
    public final int b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof q) == false) goto L10;
        q r11 = (q) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r11.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + this.b;
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "PrefetchData(data=" + this.a + ", status=" + this.b + ")";
    }

    public q(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        this.a = r10;
        this.b = r11;
    }
}
