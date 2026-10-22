package com.bytedance.android.livesdk.gift.platform.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final int a;
    public final long b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof a) == false) goto L10;
        a r6 = (a) r5;
        if (this.a == r6.a) goto L8;
        return false;
    L8:
        if (this.b == r6.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "AssetFrequentStruct(times=" + this.a + ", lastFetchTimeStamp=" + this.b + ")";
    }

    public a(int r1, long r2) {
        this.a = r1;
        this.b = r2;
    }
}
