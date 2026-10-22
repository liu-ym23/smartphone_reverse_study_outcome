package com.larus.bmhome.chat.component.bottom.core.inputtext;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t1 {
    public final be8.b a;
    public final List<n1> b;
    public final List<n1> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t1) == true) goto L8;
        return false;
    L8:
        t1 r6 = (t1) r5;
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
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "SkillSearchMatch(skill=" + this.a + ", titleRanges=" + this.b + ", descriptionRanges=" + this.c + ')';
    }

    public t1(be8.b r2, List<n1> r3, List<n1> r4) {
        Intrinsics.checkNotNullParameter(r2, "skill");
        Intrinsics.checkNotNullParameter(r3, "titleRanges");
        Intrinsics.checkNotNullParameter(r4, "descriptionRanges");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
