package com.bytedance.lark.lark_bitable_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final String e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof j) == true) goto L8;
        return false;
    L8:
        j r11 = (j) r10;
        if (this.a == r11.a) goto L12;
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
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r10 = r0 * 31;
        if (this.b == false) goto L9;
        int r11 = 1231;
    L10:
        int r12 = (r10 + r11) * 31;
        if (this.c == true) goto L14;
        r1 = 1237;
    L14:
        int r13 = (r12 + r1) * 31;
        String r14 = this.d;
        int r15 = 0;
        if (r14 != null) goto L17;
        int r16 = 0;
    L18:
        int r17 = (r13 + r16) * 31;
        String r18 = this.e;
        if (r18 == null) goto L23;
        r15 = r18.hashCode();
    L23:
        return r17 + r15;
    L17:
        r16 = r14.hashCode();
        goto L18
    L9:
        r11 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "BitableMorePanelPermission(canChangeWorkspace=" + this.a + ", canMoveOutWorkspace=" + this.b + ", canMoveInWorkspace=" + this.c + ", workspaceToken=" + this.d + ", workspaceName=" + this.e + ')';
    }

    public j(boolean r1, boolean r10, boolean r11, String r12, String r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }
}
