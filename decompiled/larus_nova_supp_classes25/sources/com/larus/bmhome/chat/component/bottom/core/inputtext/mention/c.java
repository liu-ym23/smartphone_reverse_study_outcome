package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public final qp8.c a;
    public final List<String> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        List<String> r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MentionContactEntry(contact=" + this.a + ", titleHighlights=" + this.b + ')';
    }

    public c(qp8.c r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "contact");
        this.a = r2;
        this.b = r3;
    }
}
