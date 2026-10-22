package com.larus.community.impl.share;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r {
    public final String a;
    public final Long b;
    public final Long c;
    public final boolean d;
    public final boolean e;
    public final int f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
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
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Long r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.c;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (r4 + r2) * 31;
        int r7 = 1231;
        if (this.d == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.e == true) goto L19;
        r7 = 1237;
    L19:
        return ((r9 + r7) * 31) + this.f;
    L13:
        r8 = 1237;
        goto L14
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShareImageSingleItem(previewImageUrl=" + this.a + ", defaultWidth=" + this.b + ", defaultHeight=" + this.c + ", hasPuzzleImage=" + this.d + ", isVideo=" + this.e + ", videoDuration=" + this.f + ')';
    }

    public r(String r2, Long r3, Long r4, boolean r5, boolean r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "previewImageUrl");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
