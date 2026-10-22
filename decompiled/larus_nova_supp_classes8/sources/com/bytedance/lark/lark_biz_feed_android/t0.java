package com.bytedance.lark.lark_biz_feed_android;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t0 {
    public final boolean a;
    public final boolean b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r6 = (t0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ListStatus(isLoading=" + this.a + ", isEmpty=" + this.b + ')';
    }

    public t0(boolean r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
