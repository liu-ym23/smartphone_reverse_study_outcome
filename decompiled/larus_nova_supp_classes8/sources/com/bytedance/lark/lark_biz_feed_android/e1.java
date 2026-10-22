package com.bytedance.lark.lark_biz_feed_android;

import kotlin.ULong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e1 {
    public final long a;
    public final boolean b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e1) == true) goto L8;
        return false;
    L8:
        e1 r9 = (e1) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = ULong.hashCode-impl(this.a) * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "ToastStatusSuccess(version=" + ULong.toString-impl(this.a) + ", isRemind=" + this.b + ')';
    }

    public e1(long r1, boolean r3) {
        this.a = r1;
        this.b = r3;
    }
}
