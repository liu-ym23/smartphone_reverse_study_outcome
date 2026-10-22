package cq8;

import com.larus.platform.kmp.chat.TemplateInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w extends a0 {
    public final String c;
    public final z d;
    public final String e;
    public final com.larus.bmhome.actionbar.model.n f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final TemplateInfo.TemplateInfo k;
    public final z0 l;
    public final int m;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
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
        if (this.j == r6.j) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L39;
        return false;
    L39:
        if (this.m == r6.m) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.n r1 = this.f;
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
        int r8 = 1231;
        if (this.h == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.i == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r10 + r11) * 31;
        if (this.j == true) goto L22;
        r8 = 1237;
    L22:
        int r13 = (r12 + r8) * 31;
        TemplateInfo.TemplateInfo r14 = this.k;
        if (r14 == null) goto L27;
        r2 = r14.hashCode();
    L27:
        return ((((r13 + r2) * 31) + this.l.hashCode()) * 31) + this.m;
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
        return "ImageTemplateSelectorWithMoreDescriptor(widgetId=" + this.c + ", actionChannel=" + this.d + ", version=" + this.e + ", template=" + this.f + ", subTitle=" + this.g + ", enableBottomLine=" + this.h + ", isStyleRadio=" + this.i + ", showCover=" + this.j + ", selectedTemplate=" + this.k + ", trackingContext=" + this.l + ", scrollToPosition=" + this.m + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.e;
    }

    public w(String r3, com.larus.bmhome.instruction.core.impl.base.b.C0015b r4, com.larus.bmhome.actionbar.model.n r5, String r6, boolean r7, boolean r8, boolean r9, TemplateInfo.TemplateInfo r10, z0 r11, int r12) {
        String r0 = a0.a.a();
        Intrinsics.checkNotNullParameter(r3, "widgetId");
        Intrinsics.checkNotNullParameter(r4, "actionChannel");
        Intrinsics.checkNotNullParameter(r0, "version");
        Intrinsics.checkNotNullParameter(r11, "trackingContext");
        super("ImageTemplateSelectorWithMoreDescriptor");
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
        this.m = r12;
    }
}
