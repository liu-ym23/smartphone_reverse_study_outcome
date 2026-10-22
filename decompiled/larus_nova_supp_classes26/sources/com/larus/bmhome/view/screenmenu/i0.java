package com.larus.bmhome.view.screenmenu;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i0 implements ot8.a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final Drawable e;
    public final int f;
    public final int g;
    public final boolean h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r6 = (i0) r5;
        if (this.a == r6.a) goto L12;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        Drawable r1 = this.e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((((r0 + r2) * 31) + this.f) * 31) + this.g) * 31;
        if (this.h == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MenuDivider(id=" + this.a + ", backgroundColorId=" + this.b + ", backgroundColor=" + this.c + ", backgroundDrawableRes=" + this.d + ", backgroundDrawable=" + this.e + ", height=" + this.f + ", width=" + this.g + ", removeAroundDivider=" + this.h + ')';
    }

    @Override // ot8.a
    public final boolean a() {
        return this.h;
    }

    @Override // ot8.a
    public final int getId() {
        return this.a;
    }

    public i0(int r3, int r4) {
        int r0 = i5.r0();
        int r1 = i5.F();
        this.a = r3;
        this.b = 0;
        this.c = r4;
        this.d = 0;
        this.e = null;
        this.f = r0;
        this.g = r1;
        this.h = true;
    }
}
