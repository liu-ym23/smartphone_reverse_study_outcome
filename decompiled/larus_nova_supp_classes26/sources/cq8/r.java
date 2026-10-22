package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r extends a0 {
    public final String c;
    public final z d;
    public final String e;
    public final com.larus.bmhome.actionbar.model.l f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final z0 j;
    public final int k;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L24;
        return false;
    L24:
        if (this.h == r6.h) goto L27;
        return false;
    L27:
        if (this.i == r6.i) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L33;
        return false;
    L33:
        if (this.k == r6.k) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.l r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.g;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (r4 + r2) * 31;
        int r7 = 1231;
        if (this.h == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.i == true) goto L19;
        r7 = 1237;
    L19:
        return ((((r9 + r7) * 31) + this.j.hashCode()) * 31) + this.k;
    L13:
        r8 = 1237;
        goto L14
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageListSelectorDescriptor(widgetId=" + this.c + ", actionChannel=" + this.d + ", version=" + this.e + ", template=" + this.f + ", subTitle=" + this.g + ", enableBottomLine=" + this.h + ", isStyleRadio=" + this.i + ", trackingContext=" + this.j + ", scrollToPosition=" + this.k + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.e;
    }

    public r(String r3, com.larus.bmhome.instruction.core.impl.base.b.C0015b r4, com.larus.bmhome.actionbar.model.l r5, String r6, boolean r7, boolean r8, z0 r9, int r10) {
        String r0 = a0.a.a();
        Intrinsics.checkNotNullParameter(r3, "widgetId");
        Intrinsics.checkNotNullParameter(r4, "actionChannel");
        Intrinsics.checkNotNullParameter(r0, "version");
        Intrinsics.checkNotNullParameter(r9, "trackingContext");
        super("ImageListSelectorDescriptor");
        this.c = r3;
        this.d = r4;
        this.e = r0;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
    }
}
