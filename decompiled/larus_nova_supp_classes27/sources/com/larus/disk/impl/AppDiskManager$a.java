package com.larus.disk.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AppDiskManager$a {
    public final long a;
    public final long b;
    public final k0 c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof AppDiskManager$a) == true) goto L8;
        return false;
    L8:
        AppDiskManager$a r9 = (AppDiskManager$a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        return ((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "AggregateScanResult(sizeBytes=" + this.a + ", fileCount=" + this.b + ", accessUsage=" + this.c + ')';
    }

    public /* synthetic */ AppDiskManager$a(long r7, long r9) {
        this(r7, r9, new k0(0));
    }

    public AppDiskManager$a(long r2, long r4, k0 r6) {
        Intrinsics.checkNotNullParameter(r6, "accessUsage");
        this.a = r2;
        this.b = r4;
        this.c = r6;
    }
}
