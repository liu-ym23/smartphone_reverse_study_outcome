package vz1;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final int[] a;
    public final int[] b;

    public b() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L10;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int[] r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = Arrays.hashCode(r0);
    L6:
        int r3 = r2 * 31;
        int[] r4 = this.b;
        if (r4 == null) goto L10;
        r1 = Arrays.hashCode(r4);
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "CounterBgColor(sectionBgStartColor=" + Arrays.toString(this.a) + ", sectionBgEndColor=" + Arrays.toString(this.b) + ")";
    }

    public /* synthetic */ b(int r2) {
        this(new int[0], new int[0]);
    }

    public b(int[] r2, int[] r3) {
        Intrinsics.checkNotNullParameter(r2, "sectionBgStartColor");
        Intrinsics.checkNotNullParameter(r3, "sectionBgEndColor");
        this.a = r2;
        this.b = r3;
    }
}
