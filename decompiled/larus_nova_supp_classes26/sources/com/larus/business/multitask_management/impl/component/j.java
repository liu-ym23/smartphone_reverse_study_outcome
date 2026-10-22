package com.larus.business.multitask_management.impl.component;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public final String a;
    public final boolean b;
    public final int c;
    public final SectionCardStyle d;
    public final int e;
    public final int f;
    public final int g;

    public j() {
        this(null, false, 0, null, 0, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
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
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((((((((r0 + r1) * 31) + this.c) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f) * 31) + this.g;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "SectionRenderConfig(title=" + this.a + ", showTitle=" + this.b + ", spanCount=" + this.c + ", cardStyle=" + this.d + ", topMargin=" + this.e + ", horizontalSpacing=" + this.f + ", verticalSpacing=" + this.g + ')';
    }

    public final j a(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        int r7 = r11.getResources().getDimensionPixelSize(this.e);
        int r8 = r11.getResources().getDimensionPixelSize(this.f);
        int r9 = r11.getResources().getDimensionPixelSize(this.g);
        String r3 = this.a;
        boolean r4 = this.b;
        int r5 = this.c;
        SectionCardStyle r6 = this.d;
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r6, "cardStyle");
        return new j(r3, r4, r5, r6, r7, r8, r9);
    }

    public /* synthetic */ j(String r9, boolean r10, int r11, SectionCardStyle r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r9 = "";
    L5:
        String r1 = r9;
        if ((r14 & 2) == 0) goto L8;
        boolean r2 = true;
    L10:
        if ((r14 & 4) == 0) goto L12;
        int r3 = 1;
    L14:
        if ((r14 & 8) == 0) goto L16;
        r12 = SectionCardStyle.SMALL;
    L16:
        SectionCardStyle r4 = r12;
        if ((r14 & 16) == 0) goto L19;
        r13 = v19.c.b(2130971343, null, 2131167056);
    L19:
        int r5 = r13;
        if ((r14 & 32) == 0) goto L22;
        int r6 = v19.c.b(2130971163, null, 2131166696);
    L24:
        if ((r14 & 64) == 0) goto L26;
        int r7 = v19.c.b(2130971163, null, 2131166696);
    L27:
        this(r1, r2, r3, r4, r5, r6, r7);
        return;
    L26:
        r7 = 0;
        goto L27
    L22:
        r6 = 0;
        goto L24
    L12:
        r3 = r11;
        goto L14
    L8:
        r2 = r10;
        goto L10
    }

    public j(String r2, boolean r3, int r4, SectionCardStyle r5, int r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r5, "cardStyle");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
