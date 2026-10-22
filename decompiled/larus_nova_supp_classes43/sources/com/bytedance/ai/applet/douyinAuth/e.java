package com.bytedance.ai.applet.douyinAuth;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final boolean a;
    public final String b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L8;
        return false;
    L8:
        e r11 = (e) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        String r10 = this.b;
        if (r10 != null) goto L9;
        int r11 = 0;
    L11:
        return r1 + r11;
    L9:
        r11 = r10.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "DouyinGeneralAuthStatusResult(isAuthorized=" + this.a + ", errorMsg=" + this.b + ')';
    }

    public e(boolean r1, String r10) {
        this.a = r1;
        this.b = r10;
    }
}
