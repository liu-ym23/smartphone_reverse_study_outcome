package com.larus.disk.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AppDiskManager$f {
    public final m0 a;
    public final s0 b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AppDiskManager$f) == true) goto L8;
        return false;
    L8:
        AppDiskManager$f r6 = (AppDiskManager$f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "RegisteredCacheUsageEntry(scanInfo=" + this.a + ", usageInfo=" + this.b + ')';
    }

    public final m0 a() {
        return this.a;
    }

    public final s0 b() {
        return this.b;
    }

    public AppDiskManager$f(m0 r2, s0 r3) {
        Intrinsics.checkNotNullParameter(r2, "scanInfo");
        Intrinsics.checkNotNullParameter(r3, "usageInfo");
        this.a = r2;
        this.b = r3;
    }
}
