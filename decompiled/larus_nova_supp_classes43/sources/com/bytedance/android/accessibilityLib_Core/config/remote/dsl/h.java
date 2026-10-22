package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public int a;
    public int b;
    public final String c;
    public final String d;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof h) == false) goto L14;
        h r11 = (h) r10;
        if (this.a == r11.a) goto L8;
        return false;
    L8:
        if (this.b == r11.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        String r1 = this.c;
        int r10 = 0;
        if (r1 == null) goto L5;
        int r11 = r1.hashCode();
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.d;
        if (r13 == null) goto L10;
        r10 = r13.hashCode();
    L10:
        return r12 + r10;
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        return "ViewIdentifyDsl(layoutId=" + this.a + ", viewId=" + this.b + ", layoutIdName=" + this.c + ", viewIdName=" + this.d + ')';
    }

    public h(int r1, int r10, String r11, String r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }
}
