package com.larus.common.account.bdauth.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r4 = this.d;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.e;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        int r8 = (r6 + r1) * 31;
        int r9 = 1231;
        if (this.f == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r8 + r10) * 31;
        if (this.g == false) goto L21;
        int r12 = 1231;
    L22:
        int r13 = (r11 + r12) * 31;
        if (this.h == false) goto L25;
        int r14 = 1231;
    L26:
        int r15 = (r13 + r14) * 31;
        if (this.i == true) goto L31;
        r9 = 1237;
    L31:
        return r15 + r9;
    L25:
        r14 = 1237;
        goto L26
    L21:
        r12 = 1237;
        goto L22
    L17:
        r10 = 1237;
        goto L18
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "BDAuthorizeAccountUiModel(userId=" + this.a + ", secUserId=" + this.b + ", displayName=" + this.c + ", subtitle=" + this.d + ", avatarUrl=" + this.e + ", isCurrent=" + this.f + ", isSelected=" + this.g + ", isEnterprise=" + this.h + ", hasValidLogin=" + this.i + ')';
    }

    public a(String r2, String r3, String r4, String r5, String r6, boolean r7, boolean r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r3, "secUserId");
        Intrinsics.checkNotNullParameter(r4, "displayName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
