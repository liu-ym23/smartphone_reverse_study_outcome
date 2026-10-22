package com.bytedance.lark.lark_biz_feed_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m {
    public final String a;
    public final long b;
    public final int c;
    public final Long d;
    public final String e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof m) == true) goto L8;
        return false;
    L8:
        m r9 = (m) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c) * 31;
        Long r3 = this.d;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return ((r2 + r4) * 31) + this.e.hashCode();
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public final String toString() {
        return "InvokeHookInfo(moduleName=" + this.a + ", libraryId=" + this.b + ", libId=" + this.c + ", instance=" + this.d + ", methodName=" + this.e + ')';
    }

    public m(String r3) {
        Intrinsics.checkNotNullParameter("lark_biz_feed", "moduleName");
        Intrinsics.checkNotNullParameter(r3, "methodName");
        this.a = "lark_biz_feed";
        this.b = 5912850658444239768L;
        this.c = -1568611432;
        this.d = null;
        this.e = r3;
    }
}
