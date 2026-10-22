package n28;

import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l extends a {
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final Function5<Boolean, Integer, Integer, Integer, Integer, Unit> f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
    L35:
        return true;
    L5:
        if ((r5 instanceof l) == false) goto L34;
        l r6 = (l) r5;
        if (this.a != r6.a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L34;
        if (this.b != r6.b) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L34;
        if (this.c != r6.c) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L34;
        if (this.d != r6.d) goto L24;
        boolean r4 = true;
    L25:
        if (r4 == false) goto L34;
        if (this.e != r6.e) goto L29;
        boolean r7 = true;
    L30:
        if (r7 == false) goto L34;
        if (Intrinsics.areEqual(this.f, r6.f) == false) goto L34;
    L29:
        r7 = false;
        goto L30
    L24:
        r4 = false;
        goto L25
    L19:
        r3 = false;
        goto L20
    L14:
        r2 = false;
        goto L15
    L9:
        r1 = false;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = ((((((((r1 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
        Function5<Boolean, Integer, Integer, Integer, Integer, Unit> r3 = this.f;
        if (r3 == null) goto L8;
        int r4 = r3.hashCode();
    L10:
        return r2 + r4;
    L8:
        r4 = 0;
        goto L10
    }

    public final String toString() {
        return "OnLayoutParam(changed=" + this.a + ", l=" + this.b + ", t=" + this.c + ", r=" + this.d + ", b=" + this.e + ", superMethod=" + this.f + ")";
    }

    @Override // n28.a
    public final void b() {
        this.f.invoke(Boolean.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(boolean r1, int r2, int r3, int r4, int r5, Function5<? super Boolean, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
