package com.obric.assistant.cocreationreview;

import android.view.View;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w5 {
    public final String a;
    public final int b;
    public final e c;
    public final a5 d;
    public final boolean e;
    public final List<d> f;
    public final View g;
    public final boolean h;
    public final List<c> i;
    public final z4 j;
    public final b k;
    public final List<b5> l;
    public final boolean m;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w5) == true) goto L8;
        return false;
    L8:
        w5 r6 = (w5) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        int r2 = 1231;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((((r0 + r1) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        if (this.h == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((((((((r3 + r4) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31;
        if (this.m == true) goto L15;
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
        return "UsageCardTemplate(recordId=" + this.a + ", backgroundStackCount=" + this.b + ", title=" + this.c + ", feedback=" + this.d + ", readOnly=" + this.e + ", headerTags=" + this.f + ", domainContent=" + this.g + ", domainContentOpensDetail=" + this.h + ", footTags=" + this.i + ", detailView=" + this.j + ", feedbackState=" + this.k + ", feedbackMedia=" + this.l + ", showsFeedbackValue=" + this.m + ')';
    }

    public w5(String r2, int r3, e r4, a5 r5, boolean r6, List<d> r7, View r8, boolean r9, List<c> r10, z4 r11, b r12, List<b5> r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r2, "recordId");
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "feedback");
        Intrinsics.checkNotNullParameter(r7, "headerTags");
        Intrinsics.checkNotNullParameter(r8, "domainContent");
        Intrinsics.checkNotNullParameter(r10, "footTags");
        Intrinsics.checkNotNullParameter(r11, "detailView");
        Intrinsics.checkNotNullParameter(r12, "feedbackState");
        Intrinsics.checkNotNullParameter(r13, "feedbackMedia");
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
        this.m = r14;
    }
}
