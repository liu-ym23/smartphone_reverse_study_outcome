package com.larus.bmhome.view.screenmenu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y implements ot8.a {
    public final int a;
    public final boolean b;
    public final ot8.a c;
    public final ot8.a d;

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
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((r0 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoubleTinyMenu(id=" + this.a + ", removeAroundDivider=" + this.b + ", leftMenu=" + this.c + ", rightMenu=" + this.d + ')';
    }

    @Override // ot8.a
    public final boolean a() {
        return this.b;
    }

    @Override // ot8.a
    public final int getId() {
        return this.a;
    }

    public y(ot8.a r2, ot8.a r3) {
        Intrinsics.checkNotNullParameter(r2, "leftMenu");
        Intrinsics.checkNotNullParameter(r3, "rightMenu");
        this.a = 0;
        this.b = false;
        this.c = r2;
        this.d = r3;
    }
}
