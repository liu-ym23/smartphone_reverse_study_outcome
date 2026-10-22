package com.bytedance.badger.network;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e0 extends l0 {
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;

    @Override // com.bytedance.badger.network.l0
    public final boolean a() {
        return this.a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
    L23:
        return true;
    L5:
        if ((r5 instanceof e0) == false) goto L22;
        e0 r6 = (e0) r5;
        if (this.b != r6.b) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L22;
        if (this.c != r6.c) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L22;
        if (this.d != r6.d) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
    L19:
        r7 = false;
        goto L20
    L14:
        r2 = false;
        goto L15
    L9:
        r1 = false;
    L22:
        return false;
    }

    public final int hashCode() {
        return (((this.b * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "DelayedRetry(immediateRetryCount=" + this.b + ", currentRetryCount=" + this.c + ", remainingRetryCount=" + this.d + ")";
    }

    public e0(int r1, int r2, int r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        if (r3 > 0) goto L5;
        boolean r4 = true;
    L6:
        this.a = r4;
        return;
    L5:
        r4 = false;
        goto L6
    }
}
