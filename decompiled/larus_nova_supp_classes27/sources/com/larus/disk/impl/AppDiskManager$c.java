package com.larus.disk.impl;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AppDiskManager$c {
    public final long a;
    public final Map<String, Long> b;
    public final Set<String> c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof AppDiskManager$c) == true) goto L8;
        return false;
    L8:
        AppDiskManager$c r9 = (AppDiskManager$c) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "CleanableSizeResult(totalBytes=" + this.a + ", categoryBytes=" + this.b + ", unavailableBusinesses=" + this.c + ')';
    }

    public AppDiskManager$c(long r2, Map<String, Long> r4, Set<String> r5) {
        Intrinsics.checkNotNullParameter(r4, "categoryBytes");
        Intrinsics.checkNotNullParameter(r5, "unavailableBusinesses");
        this.a = r2;
        this.b = r4;
        this.c = r5;
    }
}
