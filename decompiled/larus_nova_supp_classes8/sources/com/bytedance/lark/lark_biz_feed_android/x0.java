package com.bytedance.lark.lark_biz_feed_android;

import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x0 {
    public final long a;
    public final boolean b;
    public final String c;
    public final int d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof x0) == true) goto L8;
        return false;
    L8:
        x0 r9 = (x0) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ULong.hashCode-impl(this.a) * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((r0 + r1) * 31) + this.c.hashCode()) * 31) + this.d;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "ToastStatusFailure(version=" + ULong.toString-impl(this.a) + ", isRemind=" + this.b + ", errorMessage=" + this.c + ", errorCode=" + this.d + ')';
    }

    public x0(long r2, boolean r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "errorMessage");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
