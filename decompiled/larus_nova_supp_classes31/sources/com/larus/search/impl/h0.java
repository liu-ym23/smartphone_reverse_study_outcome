package com.larus.search.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h0 {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final float e;
    public final float f;
    public final float g;
    public final Function0<Unit> h;
    public final Function0<Unit> i;
    public final e j;

    public h0() {
        this(false, 511);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r6 = (h0) r5;
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
        if (Float.compare(this.e, r6.e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f, r6.f) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.g, r6.g) == 0) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
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
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.d == true) goto L19;
        r1 = 1237;
    L19:
        return ((((((((((r6 + r1) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31) + Float.floatToIntBits(this.g)) * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "WebDialogConfig(dismissOnTouchOutside=" + this.a + ", dismissOnBackPressed=" + this.b + ", dismissOnDialogDragged=" + this.c + ", transferTouchEvent=" + this.d + ", backgroundAlpha=" + this.e + ", topOffset=" + this.f + ", foldingHeight=" + this.g + ", dismissListener=" + this.h + ", cancelListener=" + this.i + ')';
    }

    public h0(boolean r9, int r10) {
        boolean r2 = true;
        if ((r10 & 1) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r10 & 2) == 0) goto L10;
        r9 = false;
    L10:
        if ((r10 & 4) != 0) goto L13;
        r2 = false;
    L13:
        float r4 = 0.0f;
        if ((r10 & 16) == 0) goto L16;
        float r3 = 0.5f;
    L18:
        if ((r10 & 32) == 0) goto L20;
        float r5 = 12.0f;
    L22:
        if ((r10 & 64) == 0) goto L24;
        r4 = 368.0f;
    L24:
        Function0<Unit> r7 = null;
        if ((r10 & 128) == 0) goto L27;
        Function0<Unit> r6 = new f0();
    L29:
        if ((r10 & 256) == 0) goto L31;
        r7 = new g0();
    L31:
        Intrinsics.checkNotNullParameter(r6, "dismissListener");
        Intrinsics.checkNotNullParameter(r7, "cancelListener");
        this.a = r0;
        this.b = r9;
        this.c = r2;
        this.d = false;
        this.e = r3;
        this.f = r5;
        this.g = r4;
        this.h = r6;
        this.i = r7;
        this.j = new e(this);
        return;
    L27:
        r6 = null;
        goto L29
    L20:
        r5 = 0.0f;
        goto L22
    L16:
        r3 = 0.0f;
        goto L18
    L5:
        r0 = false;
        goto L7
    }
}
