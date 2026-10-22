package com.larus.bmhome.chat.component.bottom.core.inputtext;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q1 {
    public final String a;
    public final List<be8.b> b;
    public final boolean c;
    public final boolean d;

    public q1() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q1) == true) goto L8;
        return false;
    L8:
        q1 r6 = (q1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        int r2 = 1231;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.d == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "SkillPanelGroup(title=" + this.a + ", skills=" + this.b + ", isRecommended=" + this.c + ", isRecentlyUsed=" + this.d + ')';
    }

    public q1(String r3, List r4, boolean r5, boolean r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r5 = false;
    L6:
        if ((r7 & 8) == 0) goto L8;
        r6 = false;
    L8:
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "skills");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
