package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c1 {
    public final com.larus.bmhome.chat.component.bottom.core.inputtext.d0 a;
    public final List<String> b;
    public final Long c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c1) == true) goto L8;
        return false;
    L8:
        c1 r6 = (c1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        List<String> r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MentionSearchEntry(reference=" + this.a + ", titleHighlights=" + this.b + ", accessTimeSec=" + this.c + ')';
    }

    public c1(com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r2, List<String> r3, Long r4) {
        Intrinsics.checkNotNullParameter(r2, "reference");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public /* synthetic */ c1(com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r3, List r4, Long r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        this(r3, r4, r5);
    }
}
