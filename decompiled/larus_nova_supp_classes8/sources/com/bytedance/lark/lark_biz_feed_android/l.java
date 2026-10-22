package com.bytedance.lark.lark_biz_feed_android;

import kotlin.ULong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l {
    public final long a;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof l) == true) goto L9;
        return false;
    L9:
        if (this.a == ((l) r8).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return ULong.hashCode-impl(this.a);
    }

    public final String toString() {
        return "ForegroundUserContainerScope(uid=" + ULong.toString-impl(this.a) + ')';
    }

    public l(long r1) {
        this.a = r1;
    }
}
