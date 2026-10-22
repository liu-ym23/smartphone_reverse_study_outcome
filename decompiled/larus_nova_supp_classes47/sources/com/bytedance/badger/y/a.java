package com.bytedance.badger.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final long a;
    public long b;

    public a(long r1, long r3) {
        this.a = r1;
        this.b = r3;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L5;
    L18:
        return true;
    L5:
        if ((r8 instanceof a) == false) goto L17;
        a r9 = (a) r8;
        if (this.a != r9.a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L17;
        if (this.b != r9.b) goto L14;
        boolean r10 = true;
    L15:
        if (r10 == false) goto L17;
    L14:
        r10 = false;
        goto L15
    L9:
        r1 = false;
    L17:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "EventTimes(createTimeMs=" + this.a + ", updateTimeMs=" + this.b + ")";
    }
}
