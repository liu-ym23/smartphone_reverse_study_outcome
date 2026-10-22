package com.larus.video.impl.sdk.prefetch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public final long a;
    public final int b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof i) == true) goto L8;
        return false;
    L8:
        i r9 = (i) r8;
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
        return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b;
    }

    public final String toString() {
        return "CachedRefreshCount(cacheValidTimeStamp=" + this.a + ", refreshCount=" + this.b + ')';
    }

    public i(long r1, int r3) {
        this.a = r1;
        this.b = r3;
    }
}
