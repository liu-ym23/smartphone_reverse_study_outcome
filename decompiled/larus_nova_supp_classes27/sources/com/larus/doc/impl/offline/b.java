package com.larus.doc.impl.offline;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final CreateDocByMessageActionType a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.d == true) goto L15;
        r2 = 1237;
    L15:
        return r5 + r2;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreateDocByMessageState(action=" + this.a + ", hasRealToken=" + this.b + ", hasUserChanges=" + this.c + ", hasFrontendLinked=" + this.d + ')';
    }

    public b(CreateDocByMessageActionType r2, boolean r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
