package com.larus.dora.impl.frameassembler;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    public final i a;
    public final long b;
    public final long c;
    public final int d;
    public final boolean e;
    public final long f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h) == true) goto L8;
        return false;
    L8:
        h r9 = (h) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d) * 31;
        if (this.e == false) goto L5;
        int r5 = 1231;
    L6:
        int r6 = (r4 + r5) * 31;
        long r7 = this.f;
        return r6 + ((int) (r7 ^ (r7 >>> 32)));
    L5:
        r5 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraSessionContext(key=" + this.a + ", createdAtMillis=" + this.b + ", lastUpdatedAtMillis=" + this.c + ", expectedTotalSeq=" + this.d + ", usingDisk=" + this.e + ", receivedBytes=" + this.f + ')';
    }

    public h(i r2, long r3, long r5, int r7, boolean r8, long r9) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r9;
    }
}
