package com.larus.avlink.env.diary.style;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f0 {
    public final List<e0> a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r6 = (f0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        return "DiaryStyleListUiData(styles=" + this.a + ", maxCount=" + this.b + ')';
    }

    public f0(List<e0> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "styles");
        this.a = r2;
        this.b = r3;
    }
}
