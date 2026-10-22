package com.larus.contextwindow.impl.ui;

import com.larus.contextwindow.api.ContextWindowSnapshot;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final ContextWindowSnapshot a;
    public final boolean b;
    public final j c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        j r3 = this.c;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return r2 + r4;
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ContextWindowPanelState(contextSnapshot=" + this.a + ", isContextCompressing=" + this.b + ", membership=" + this.c + ')';
    }

    public a(ContextWindowSnapshot r2, boolean r3, j r4) {
        Intrinsics.checkNotNullParameter(r2, "contextSnapshot");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
