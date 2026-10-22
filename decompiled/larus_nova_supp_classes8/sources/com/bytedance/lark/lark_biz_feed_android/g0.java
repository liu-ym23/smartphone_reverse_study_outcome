package com.bytedance.lark.lark_biz_feed_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g0 {
    public final f0 a;
    public final l b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r6 = (g0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "LarkFeedListContextWrapped(inner=" + this.a + ", containerScope=" + this.b + ')';
    }

    public g0(f0 r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "inner");
        Intrinsics.checkNotNullParameter(r3, "containerScope");
        this.a = r2;
        this.b = r3;
    }
}
