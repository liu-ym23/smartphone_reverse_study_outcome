package g90;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final Matrix a;
    public final RectF b;
    public final String c;
    public final int d;
    public final b e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L16;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Matrix r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        RectF r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((r6 + r8) * 31) + this.d) * 31;
        b r11 = this.e;
        if (r11 == null) goto L18;
        r1 = r11.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "InteractStatus(gridMatrix=" + this.a + ", visibleArea=" + this.b + ", seiRaw=" + this.c + ", uiLayoutIndex=" + this.d + ", businessData=" + this.e + ")";
    }

    public a(Matrix r2, RectF r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "gridMatrix");
        Intrinsics.checkNotNullParameter(r3, "visibleArea");
        Intrinsics.checkNotNullParameter(r4, "seiRaw");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = null;
    }
}
