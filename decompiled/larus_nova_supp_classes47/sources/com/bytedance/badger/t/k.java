package com.bytedance.badger.t;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k extends l {
    public final String a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof k) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((k) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "StringVal(value=" + this.a + ")";
    }

    public k(String r1) {
        this.a = r1;
    }
}
