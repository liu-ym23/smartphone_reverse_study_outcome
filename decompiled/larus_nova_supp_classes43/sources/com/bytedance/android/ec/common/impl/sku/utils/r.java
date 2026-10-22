package com.bytedance.android.ec.common.impl.sku.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r {
    public final int a;
    public final long b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof r) == false) goto L10;
        r r11 = (r) r10;
        if (this.a == r11.a) goto L8;
        return false;
    L8:
        if (this.b == r11.b) goto L16;
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
        return "SkuTradeModeData(selectIndex=" + this.a + ", timestamp=" + this.b + ")";
    }

    public r(int r1, long r10) {
        this.a = r1;
        this.b = r10;
    }
}
