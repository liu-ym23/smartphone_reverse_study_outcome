package com.larus.bmhome.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public final String a;
    public final int b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final Function1<View, Unit> f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (r3 + r2) * 31;
        Function1<View, Unit> r5 = this.f;
        if (r5 != null) goto L13;
        int r6 = 0;
    L15:
        return r4 + r6;
    L13:
        r6 = r5.hashCode();
        goto L15
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "BottomMenuItem(id=" + this.a + ", iconRes=" + this.b + ", nameRes=" + this.c + ", enabled=" + this.d + ", visible=" + this.e + ", onClick=" + this.f + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(String r2, int r3, int r4, boolean r5, boolean r6, Function1<? super View, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
