package com.larus.disk.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h0 {
    public final long a;
    public final k0 b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r9 = (h0) r8;
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
        return "FileAccessFileSnapshot(sizeBytes=" + this.a + ", usage=" + this.b + ')';
    }

    public h0(long r2, k0 r4) {
        Intrinsics.checkNotNullParameter(r4, "usage");
        this.a = r2;
        this.b = r4;
    }
}
