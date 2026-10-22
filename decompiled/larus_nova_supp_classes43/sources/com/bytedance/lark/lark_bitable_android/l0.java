package com.bytedance.lark.lark_bitable_android;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l0 {
    public final boolean a;
    public final boolean b;
    public final boolean c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r11 = (l0) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r10 = r0 * 31;
        if (this.b == false) goto L9;
        int r11 = 1231;
    L10:
        int r12 = (r10 + r11) * 31;
        if (this.c == true) goto L15;
        r1 = 1237;
    L15:
        return r12 + r1;
    L9:
        r11 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "HomepageTagConfig(showTemplate=" + this.a + ", showExternal=" + this.b + ", showFileRiskTag=" + this.c + ')';
    }

    public l0(boolean r1, boolean r10, boolean r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
