package com.bytedance.badger.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i extends l {
    public final long a;

    public final boolean equals(Object r8) {
        if (this != r8) goto L5;
    L13:
        return true;
    L5:
        if ((r8 instanceof i) == true) goto L7;
    L12:
        return false;
    L7:
        if (this.a != ((i) r8).a) goto L9;
        boolean r9 = true;
    L10:
        if (r9 == false) goto L12;
    L9:
        r9 = false;
        goto L10
    }

    public final int hashCode() {
        long r0 = this.a;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public final String toString() {
        return "LongVal(value=" + this.a + ")";
    }

    public i(long r1) {
        this.a = r1;
    }
}
