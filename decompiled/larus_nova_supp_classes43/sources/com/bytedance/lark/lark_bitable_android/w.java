package com.bytedance.lark.lark_bitable_android;

import kotlin.ULong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w {
    public final long a;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof w) == true) goto L9;
        return false;
    L9:
        if (this.a == ((w) r10).a) goto L11;
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

    public w(long r1) {
        this.a = r1;
    }
}
