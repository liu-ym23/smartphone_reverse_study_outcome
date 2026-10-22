package com.larus.avlink.gallery.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y {
    public final boolean a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final String f;
    public final boolean g;
    public final boolean h;
    public final Function0<Unit> i;

    public y() {
        this(0);
    }

    public static y a(boolean r11, String r12, int r13, int r14, int r15, String r16, boolean r17, boolean r18, Function0 r19) {
        Intrinsics.checkNotNullParameter(r12, "title");
        Intrinsics.checkNotNullParameter(r16, "buttonText");
        Intrinsics.checkNotNullParameter(r19, "onButtonClick");
        return new y(r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof y) == true) goto L8;
        return false;
    L8:
        y r6 = (y) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((((((((((r0 * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f.hashCode()) * 31;
        if (this.g == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.h == true) goto L15;
        r1 = 1237;
    L15:
        return ((r4 + r1) * 31) + this.i.hashCode();
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "BannerState(isVisible=" + this.a + ", title=" + this.b + ", titleDrawable=" + this.c + ", bgDrawable=" + this.d + ", btnColor=" + this.e + ", buttonText=" + this.f + ", showCloseBtn=" + this.g + ", showRotate=" + this.h + ", onButtonClick=" + this.i + ')';
    }

    public /* synthetic */ y(int r11) {
        this(false, "", 2131240824, 2131102512, 2131103146, "", false, false, new x());
    }

    public y(boolean r2, String r3, int r4, int r5, int r6, String r7, boolean r8, boolean r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r7, "buttonText");
        Intrinsics.checkNotNullParameter(r10, "onButtonClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
