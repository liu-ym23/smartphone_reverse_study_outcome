package com.larksuite.component.universe_design.dialog.compose;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final String a;
    public final Function0<Unit> b;
    public final UDDialogActionRole c;
    public final boolean d;
    public final boolean e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "UDDialogAction(text=" + this.a + ", onClick=" + this.b + ", role=" + this.c + ", enabled=" + this.d + ", autoDismiss=" + this.e + ')';
    }

    public static b a(b r6, boolean r7) {
        String r1 = r6.a;
        Function0<Unit> r2 = r6.b;
        UDDialogActionRole r3 = r6.c;
        boolean r5 = r6.e;
        Intrinsics.checkNotNullParameter(r1, "text");
        Intrinsics.checkNotNullParameter(r2, "onClick");
        Intrinsics.checkNotNullParameter(r3, "role");
        return new b(r1, r2, r3, r7, r5);
    }

    public b(String r2, Function0<Unit> r3, UDDialogActionRole r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "onClick");
        Intrinsics.checkNotNullParameter(r4, "role");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
