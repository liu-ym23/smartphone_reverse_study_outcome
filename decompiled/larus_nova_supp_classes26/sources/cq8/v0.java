package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v0 extends a0 {
    public final String c;
    public final z d;
    public final String e;
    public final com.larus.bmhome.actionbar.model.l0 f;
    public final String g;
    public final String h;
    public final boolean i;
    public final z0 j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v0) == true) goto L8;
        return false;
    L8:
        v0 r6 = (v0) r5;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L27;
        return false;
    L27:
        if (this.i == r6.i) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.l0 r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.h;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        int r9 = (r7 + r2) * 31;
        if (this.i == false) goto L17;
        int r10 = 1231;
    L19:
        return ((r9 + r10) * 31) + this.j.hashCode();
    L17:
        r10 = 1237;
        goto L19
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "TranslatorDescriptor(widgetId=" + this.c + ", actionChannel=" + this.d + ", version=" + this.e + ", template=" + this.f + ", subTitle=" + this.g + ", displaySubTitleName=" + this.h + ", enableBottomLine=" + this.i + ", trackingContext=" + this.j + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.e;
    }

    public v0(String r3, com.larus.bmhome.instruction.core.impl.base.b.C0015b r4, com.larus.bmhome.actionbar.model.l0 r5, String r6, String r7, boolean r8, z0 r9) {
        String r0 = a0.a.a();
        Intrinsics.checkNotNullParameter(r3, "widgetId");
        Intrinsics.checkNotNullParameter(r4, "actionChannel");
        Intrinsics.checkNotNullParameter(r0, "version");
        Intrinsics.checkNotNullParameter(r9, "trackingContext");
        super("TranslatorDescriptor");
        this.c = r3;
        this.d = r4;
        this.e = r0;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
    }
}
