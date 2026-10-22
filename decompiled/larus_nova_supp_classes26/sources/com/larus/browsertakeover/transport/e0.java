package com.larus.browsertakeover.transport;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e0 {
    public final int a;
    public final long b;
    public final int c;
    public final long d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r9 = (e0) r8;
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
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c) * 31;
        long r3 = this.d;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "RtsQueueBudgetSnapshot(queuedPackets=" + this.a + ", queuedBytes=" + this.b + ", maxQueuedPackets=" + this.c + ", maxQueuedBytes=" + this.d + ')';
    }

    public e0(int r1, long r2, int r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }
}
