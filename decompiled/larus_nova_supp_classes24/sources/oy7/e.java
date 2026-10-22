package oy7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final String h;
    public final String i;
    public final int j;
    public final String k;
    public final boolean l;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.f == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.g == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        String r10 = this.h;
        int r11 = 0;
        if (r10 != null) goto L21;
        int r12 = 0;
    L22:
        int r13 = (r9 + r12) * 31;
        String r14 = this.i;
        if (r14 == null) goto L26;
        r11 = r14.hashCode();
    L26:
        int r15 = (((((r13 + r11) * 31) + this.j) * 31) + this.k.hashCode()) * 31;
        if (this.l == true) goto L31;
        r2 = 1237;
    L31:
        return r15 + r2;
    L21:
        r12 = r10.hashCode();
        goto L22
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "HashTagViewData(id=" + this.a + ", tagInstanceId=" + this.b + ", name=" + this.c + ", isCollected=" + this.d + ", isAdded=" + this.e + ", isAuthorized=" + this.f + ", isDeletable=" + this.g + ", appLink=" + this.h + ", hashTagOwnerName=" + this.i + ", permissionType=" + this.j + ", teamworkerCount=" + this.k + ", isNeedCreate=" + this.l + ')';
    }

    public e(String r3, String r4, String r5, boolean r6, boolean r7, boolean r8, boolean r9, String r10, String r11, int r12, String r13, boolean r14, int r15) {
        if ((r15 & 512) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 1024) == 0) goto L9;
        r13 = "";
    L9:
        if ((r15 & 2048) == 0) goto L11;
        r14 = false;
    L11:
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r4, "tagInstanceId");
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r13, "teamworkerCount");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }
}
