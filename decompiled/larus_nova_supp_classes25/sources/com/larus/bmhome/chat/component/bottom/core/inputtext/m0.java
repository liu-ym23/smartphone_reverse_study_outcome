package com.larus.bmhome.chat.component.bottom.core.inputtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m0 {
    public final String a;
    public final d0 b;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "InputReferencePlaceholder(token=" + this.a + ", reference=" + this.b + ')';
    }

    public m0(String r2, d0 r3) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r3, "reference");
        this.a = r2;
        this.b = r3;
    }
}
