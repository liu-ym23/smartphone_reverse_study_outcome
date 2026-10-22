package com.larus.canvas.feature.component.resultdisplay.image;

import com.larus.canvas.feature.component.base.ImageRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y {
    public final String a;
    public final ImageRes b;
    public final ImageRes c;
    public final int d;
    public final int e;
    public final int f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final w j;
    public final ImageRes k;
    public final boolean l;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof y) == true) goto L8;
        return false;
    L8:
        y r6 = (y) r5;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
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
        int r0 = this.a.hashCode() * 31;
        ImageRes r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ImageRes r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((((r4 + r6) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g.hashCode()) * 31;
        int r8 = 1231;
        if (this.h == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.i == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (((r10 + r11) * 31) + this.j.hashCode()) * 31;
        ImageRes r13 = this.k;
        if (r13 == null) goto L22;
        r2 = r13.hashCode();
    L22:
        int r14 = (r12 + r2) * 31;
        if (this.l == true) goto L27;
        r8 = 1237;
    L27:
        return r14 + r8;
    L17:
        r11 = 1237;
        goto L18
    L13:
        r9 = 1237;
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PageItemData(id=" + this.a + ", lowImageRes=" + this.b + ", imageRes=" + this.c + ", width=" + this.d + ", height=" + this.e + ", status=" + this.f + ", description=" + this.g + ", showCompareBtn=" + this.h + ", showRegenerateBtn=" + this.i + ", saveActionState=" + this.j + ", compareRes=" + this.k + ", willBeRemove=" + this.l + ')';
    }

    public y(String r2, ImageRes r3, ImageRes r4, int r5, int r6, @PageItemStatus int r7, String r8, boolean r9, boolean r10, w r11, ImageRes r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r8, "description");
        Intrinsics.checkNotNullParameter(r11, "saveActionState");
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
        this.l = r13;
    }
}
