package com.bytedance.lark.lark_bitable_android;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public final int a;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L9;
        return false;
    L9:
        if (this.a == ((f) r10).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "BitableAppInfo(bizType=" + this.a + ')';
    }

    public f(int r1) {
        this.a = r1;
    }
}
