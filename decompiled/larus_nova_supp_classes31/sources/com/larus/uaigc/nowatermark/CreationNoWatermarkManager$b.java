package com.larus.uaigc.nowatermark;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationNoWatermarkManager$b<T> {
    public final T a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CreationNoWatermarkManager$b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((CreationNoWatermarkManager$b) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        T r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "CachedValue(value=" + this.a + ')';
    }

    public CreationNoWatermarkManager$b(T r1) {
        this.a = r1;
    }
}
