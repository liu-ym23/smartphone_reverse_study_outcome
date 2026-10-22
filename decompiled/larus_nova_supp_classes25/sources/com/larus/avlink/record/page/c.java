package com.larus.avlink.record.page;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public final boolean a;
    public final long b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.b;
        return (r0 * 31) + ((int) (r1 ^ (r1 >>> 32)));
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeleteResult(isSuccess=" + this.a + ", time=" + this.b + ')';
    }

    public c(boolean r1, long r2) {
        this.a = r1;
        this.b = r2;
    }
}
