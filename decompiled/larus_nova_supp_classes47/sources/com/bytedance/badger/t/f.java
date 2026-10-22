package com.bytedance.badger.t;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends l {
    public final byte[] a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof f) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((f) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        byte[] r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return Arrays.hashCode(r0);
    }

    public final String toString() {
        return "BytesVal(value=" + Arrays.toString(this.a) + ")";
    }

    public f(byte[] r1) {
        this.a = r1;
    }
}
