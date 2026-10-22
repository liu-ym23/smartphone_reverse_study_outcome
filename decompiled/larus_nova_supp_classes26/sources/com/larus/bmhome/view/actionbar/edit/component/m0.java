package com.larus.bmhome.view.actionbar.edit.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m0 {
    public final String a;
    public final int b;
    public final int c;
    public final Integer d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r6 = (m0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31;
        Integer r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "CollaboratedUpgradeBadge(iconUrl=" + this.a + ", widthDp=" + this.b + ", heightDp=" + this.c + ", radiusDp=" + this.d + ')';
    }

    public m0(String r2, int r3, int r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r2, "iconUrl");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
