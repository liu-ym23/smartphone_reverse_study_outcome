package com.bytedance.badger.network;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g0 extends l0 {
    public final boolean a;
    public final int b;
    public final int c;

    @Override // com.bytedance.badger.network.l0
    public final boolean a() {
        return this.a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
    L18:
        return true;
    L5:
        if ((r5 instanceof g0) == false) goto L17;
        g0 r6 = (g0) r5;
        if (this.b != r6.b) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L17;
        if (this.c != r6.c) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L17;
    L14:
        r7 = false;
        goto L15
    L9:
        r1 = false;
    L17:
        return false;
    }

    public final int hashCode() {
        return (this.b * 31) + this.c;
    }

    public final String toString() {
        return "ImmediateRetry(currentRetryCount=" + this.b + ", remainingRetryCount=" + this.c + ")";
    }

    public g0(int r1, int r2) {
        this.b = r1;
        this.c = r2;
        if (r2 > 0) goto L5;
        boolean r3 = true;
    L6:
        this.a = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }
}
