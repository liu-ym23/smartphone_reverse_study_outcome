package ac8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public final boolean a;
    public final int b;
    public final boolean c;
    public final List<String> d;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b) * 31;
        if (this.c == true) goto L11;
        r1 = 1237;
    L11:
        return ((r2 + r1) * 31) + this.d.hashCode();
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "InputMultilineConfig(doubleLineEnabled=" + this.a + ", shrinkType=" + this.b + ", hideSugIndexWithText=" + this.c + ", blockedScenes=" + this.d + ')';
    }

    public d(boolean r2, int r3, boolean r4, List<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "blockedScenes");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
