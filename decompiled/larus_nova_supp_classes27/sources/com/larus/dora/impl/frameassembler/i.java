package com.larus.dora.impl.frameassembler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i {
    public final long a;
    public final long b;
    public final int c;
    public final int d;

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
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        return ((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "DoraSessionKey(dataId=" + this.a + ", associateId=" + this.b + ", scene=" + this.c + ", type=" + this.d + ')';
    }

    public final int getType() {
        return this.d;
    }

    public i(long r1, long r3, int r5, int r6) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r6;
    }
}
