package mn0;

import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final boolean a;
    public final Triple<Boolean, Integer, Integer> b;
    public final boolean c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L12;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        Triple<Boolean, Integer, Integer> r4 = this.b;
        if (r4 == null) goto L8;
        int r5 = r4.hashCode();
    L9:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        if (r7 == true) goto L14;
        r1 = r7;
    L14:
        return r6 + r1;
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "{needAdjustXScreen = " + this.a + ", livePlayerVideoSizeAdapt = " + this.b + '}';
    }

    public a(Triple r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "livePlayerVideoSizeAdapt");
        this.a = false;
        this.b = r2;
        this.c = r3;
    }
}
