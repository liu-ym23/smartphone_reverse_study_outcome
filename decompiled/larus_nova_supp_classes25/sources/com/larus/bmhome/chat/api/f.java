package com.larus.bmhome.chat.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final r0 a;
    public final u0 b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final boolean g;
    public final String h;
    public final String i;
    public final boolean j;
    public final boolean k;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
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
        if (this.k == r6.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        int r2 = 1231;
        if (this.g == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((((r0 + r1) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        if (this.j == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.k == true) goto L15;
        r2 = 1237;
    L15:
        return r5 + r2;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "CardModel(msgData=" + this.a + ", permissionType=" + this.b + ", icon=" + this.c + ", sourceName=" + this.d + ", title=" + this.e + ", subtitle=" + this.f + ", showOperateButton=" + this.g + ", agreeTitle=" + this.h + ", rejectedTitle=" + this.i + ", agreeLoading=" + this.j + ", rejectedLoading=" + this.k + ')';
    }

    public f(r0 r2, com.bytedance.applet.impl.k r3, String r4, String r5, String r6, String r7, boolean r8, String r9, String r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r2, "msgData");
        Intrinsics.checkNotNullParameter(r3, "permissionType");
        Intrinsics.checkNotNullParameter(r4, "icon");
        Intrinsics.checkNotNullParameter(r5, "sourceName");
        Intrinsics.checkNotNullParameter(r6, "title");
        Intrinsics.checkNotNullParameter(r7, "subtitle");
        Intrinsics.checkNotNullParameter(r9, "agreeTitle");
        Intrinsics.checkNotNullParameter(r10, "rejectedTitle");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }
}
