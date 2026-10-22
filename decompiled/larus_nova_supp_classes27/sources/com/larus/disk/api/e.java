package com.larus.disk.api;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e {
    public final long a;
    public final List<g> b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "DiskCacheBreakdownMetric(totalBytes=" + this.a + ", categories=" + this.b + ')';
    }

    public e(long r2, List<g> r4) {
        Intrinsics.checkNotNullParameter(r4, "categories");
        this.a = r2;
        this.b = r4;
    }
}
