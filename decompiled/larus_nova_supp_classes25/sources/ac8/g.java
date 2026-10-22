package ac8;

import com.larus.bmhome.chat.ab.InputRowCollapseStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public static final g d = null;
    public final boolean a;
    public final InputRowCollapseStyle b;
    public final boolean c;

    public static final class a {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b.hashCode()) * 31;
        if (this.c == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "InputRowLayoutResolution(doubleRowEnabled=" + this.a + ", collapseStyle=" + this.b + ", sugIndexHideEnabled=" + this.c + ')';
    }

    static {
        d = new g(false, InputRowCollapseStyle.NONE, false);
    }

    public g(boolean r2, InputRowCollapseStyle r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "collapseStyle");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
