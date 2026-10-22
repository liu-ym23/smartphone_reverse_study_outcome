package com.bytedance.ai.applet.douyinAuth;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public final String a;
    public final String b;
    public final String c;

    public f() {
        this(null, 7);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.b;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.c;
        if (r15 == null) goto L15;
        r1 = r15.hashCode();
    L15:
        return r14 + r1;
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "DouyinGeneralAuthTokenResult(openId=" + this.a + ", accessToken=" + this.b + ", errorMsg=" + this.c + ')';
    }

    public /* synthetic */ f(String r10, int r11) {
        if ((r11 & 4) == 0) goto L5;
        r10 = null;
    L5:
        this(null, null, r10);
    }

    public f(String r1, String r10, String r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
