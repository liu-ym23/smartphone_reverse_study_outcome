package com.bytedance.android.ec.common.impl.sku.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l {
    public final boolean a;
    public final long b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof l) == false) goto L10;
        l r11 = (l) r10;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        long r10 = this.b;
        return (r1 * 31) + ((int) (r10 ^ (r10 >>> 32)));
    }

    public final String toString() {
        return "SkuBigPicModeData(isBigPicMode=" + this.a + ", timestamp=" + this.b + ")";
    }

    public l(boolean r1, long r10) {
        this.a = r1;
        this.b = r10;
    }
}
