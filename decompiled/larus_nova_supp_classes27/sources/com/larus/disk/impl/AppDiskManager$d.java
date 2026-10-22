package com.larus.disk.impl;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AppDiskManager$d {
    public final long a;
    public final Set<String> b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof AppDiskManager$d) == true) goto L8;
        return false;
    L8:
        AppDiskManager$d r9 = (AppDiskManager$d) r8;
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
        return "CustomBizCleanResult(cleanedBytes=" + this.a + ", failedBizTags=" + this.b + ')';
    }

    public final long a() {
        return this.a;
    }

    public final Set<String> b() {
        return this.b;
    }

    public AppDiskManager$d(long r2, Set<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "failedBizTags");
        this.a = r2;
        this.b = r4;
    }
}
