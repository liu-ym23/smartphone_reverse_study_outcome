package com.bytedance.lark.lark_biz_feed_android;

import kotlin.ULong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f1 {
    public final long a;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f1) == true) goto L9;
        return false;
    L9:
        if (this.a == ((f1) r8).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return ULong.hashCode-impl(this.a);
    }

    public final String toString() {
        return "UserForegroundScope(uid=" + ULong.toString-impl(this.a) + ')';
    }

    public f1(long r1) {
        this.a = r1;
    }
}
