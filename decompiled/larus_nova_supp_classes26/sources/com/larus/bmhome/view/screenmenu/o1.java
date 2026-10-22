package com.larus.bmhome.view.screenmenu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o1 implements ot8.a {
    public final int a;
    public final boolean b;
    public final ot8.a c;
    public final ot8.a d;
    public final ot8.a e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o1) == true) goto L8;
        return false;
    L8:
        o1 r6 = (o1) r5;
        if (this.a == r6.a) goto L12;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((((r0 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "TripleTinyMenu(id=" + this.a + ", removeAroundDivider=" + this.b + ", firstMenu=" + this.c + ", middleMenu=" + this.d + ", lastMenu=" + this.e + ')';
    }

    @Override // ot8.a
    public final boolean a() {
        return this.b;
    }

    @Override // ot8.a
    public final int getId() {
        return this.a;
    }

    public o1(ot8.a r2, ot8.a r3, ot8.a r4) {
        Intrinsics.checkNotNullParameter(r2, "firstMenu");
        Intrinsics.checkNotNullParameter(r3, "middleMenu");
        Intrinsics.checkNotNullParameter(r4, "lastMenu");
        this.a = 0;
        this.b = false;
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
