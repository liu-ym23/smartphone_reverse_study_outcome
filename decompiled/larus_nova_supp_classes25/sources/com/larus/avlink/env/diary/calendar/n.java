package com.larus.avlink.env.diary.calendar;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n {
    public final int a;
    public final int b;
    public final List<a.C0005a> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (this.a == r6.a) goto L12;
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
        return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "MonthCalendarData(year=" + this.a + ", month=" + this.b + ", days=" + this.c + ')';
    }

    public static n a(n r2, List r3) {
        int r0 = r2.a;
        int r4 = r2.b;
        Intrinsics.checkNotNullParameter(r3, "days");
        return new n(r0, r4, r3);
    }

    public n(int r2, int r3, List<a.C0005a> r4) {
        Intrinsics.checkNotNullParameter(r4, "days");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
