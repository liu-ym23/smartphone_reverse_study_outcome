package com.bytedance.badger.t;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends l {
    public final List a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof h) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((h) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "ListVal(items=" + this.a + ")";
    }

    public h(List r1) {
        this.a = r1;
    }
}
