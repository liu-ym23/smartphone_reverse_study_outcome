package com.larksuite.common_selection;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class p {
    public final o a;
    public final o b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public p() {
        this(new o(0), new o(0));
    }

    public final String toString() {
        return "SelectionRange(start=" + this.a + ", end=" + this.b + ')';
    }

    public static p a(p r2) {
        o r0 = r2.a;
        o r3 = r2.b;
        Intrinsics.checkNotNullParameter(r0, "start");
        Intrinsics.checkNotNullParameter(r3, "end");
        return new p(r0, r3);
    }

    public p(o r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "start");
        Intrinsics.checkNotNullParameter(r3, "end");
        this.a = r2;
        this.b = r3;
    }
}
