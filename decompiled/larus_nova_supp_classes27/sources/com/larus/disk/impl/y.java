package com.larus.disk.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class y {
    public final long a;
    public final long b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof y) == true) goto L8;
        return false;
    L8:
        y r9 = (y) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "DeviceStorageInfo(totalBytes=" + this.a + ", availableBytes=" + this.b + ')';
    }

    public final String a() {
        long r0 = this.a;
        if (r0 > 34359738368L) goto L6;
        return "0_32_gib";
    L6:
        if (r0 > 68719476736L) goto L9;
        return "32_64_gib";
    L9:
        if (r0 > 137438953472L) goto L12;
        return "64_128_gib";
    L12:
        if (r0 > 274877906944L) goto L14;
        return "128_256_gib";
    L14:
        return "256_gib_plus";
    }

    public y(long r1, long r3) {
        this.a = r1;
        this.b = r3;
    }
}
