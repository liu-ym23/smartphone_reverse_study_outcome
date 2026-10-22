package cq8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m extends a0 {
    public final String c;
    public final z d;
    public final String e;
    public final com.larus.bmhome.actionbar.model.i f;
    public final List<com.larus.bmhome.actionbar.model.h> g;
    public final Integer h;
    public final String i;
    public final boolean j;
    public final z0 k;
    public final boolean l;

    public m() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
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
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L30;
        return false;
    L30:
        if (this.j == r6.j) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L36;
        return false;
    L36:
        if (this.l == r6.l) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.i r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<com.larus.bmhome.actionbar.model.h> r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.h;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.i;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        int r12 = (r10 + r2) * 31;
        int r13 = 1231;
        if (this.j == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (((r12 + r14) * 31) + this.k.hashCode()) * 31;
        if (this.l == true) goto L27;
        r13 = 1237;
    L27:
        return r15 + r13;
    L21:
        r14 = 1237;
        goto L22
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DropdownListSelectorDescriptor(widgetId=" + this.c + ", actionChannel=" + this.d + ", version=" + this.e + ", template=" + this.f + ", allDropdownBoxList=" + this.g + ", marginTop=" + this.h + ", subTitle=" + this.i + ", enableBottomLine=" + this.j + ", trackingContext=" + this.k + ", isMemorized=" + this.l + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.e;
    }

    public m(String r3, com.larus.bmhome.instruction.core.impl.base.b.C0015b r4, com.larus.bmhome.actionbar.model.i r5, List r6, Integer r7, String r8, boolean r9, z0 r10, boolean r11) {
        String r0 = a0.a.a();
        Intrinsics.checkNotNullParameter(r3, "widgetId");
        Intrinsics.checkNotNullParameter(r4, "actionChannel");
        Intrinsics.checkNotNullParameter(r0, "version");
        Intrinsics.checkNotNullParameter(r10, "trackingContext");
        super("DropdownListSelectorDescriptor");
        this.c = r3;
        this.d = r4;
        this.e = r0;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
        this.l = r11;
    }
}
