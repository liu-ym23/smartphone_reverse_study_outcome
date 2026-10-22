package com.bytedance.lark.lark_bitable_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m0 {
    public final String a;
    public final long b;
    public final int c;
    public final Long d;
    public final String e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r11 = (m0) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r10 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c) * 31;
        Long r11 = this.d;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return ((r10 + r12) * 31) + this.e.hashCode();
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public final String toString() {
        return "InvokeHookInfo(moduleName=" + this.a + ", libraryId=" + this.b + ", libId=" + this.c + ", instance=" + this.d + ", methodName=" + this.e + ')';
    }

    public m0(Long r10, String r11) {
        Intrinsics.checkNotNullParameter("lark_bitable", "moduleName");
        Intrinsics.checkNotNullParameter(r11, "methodName");
        this.a = "lark_bitable";
        this.b = -4859419532938133078L;
        this.c = 1554039210;
        this.d = r10;
        this.e = r11;
    }
}
