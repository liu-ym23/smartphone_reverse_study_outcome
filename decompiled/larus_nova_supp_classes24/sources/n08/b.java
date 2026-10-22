package n08;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final int a;
    public final a[] b;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + Arrays.hashCode(this.b);
    }

    public final String toString() {
        return "Week(row=" + this.a + ", baseDays=" + Arrays.toString(this.b) + ')';
    }

    public b(int r3) {
        a[] r0 = new a[7];
        Intrinsics.checkNotNullParameter(r0, "baseDays");
        this.a = r3;
        this.b = r0;
    }
}
