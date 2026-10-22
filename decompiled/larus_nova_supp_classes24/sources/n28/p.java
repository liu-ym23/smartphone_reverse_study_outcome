package n28;

import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class p extends a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final Function4<Integer, Integer, Integer, Integer, Unit> e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
    L30:
        return true;
    L5:
        if ((r5 instanceof p) == false) goto L29;
        p r6 = (p) r5;
        if (this.a != r6.a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L29;
        if (this.b != r6.b) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L29;
        if (this.c != r6.c) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L29;
        if (this.d != r6.d) goto L24;
        boolean r4 = true;
    L25:
        if (r4 == false) goto L29;
        if (Intrinsics.areEqual(this.e, r6.e) == false) goto L29;
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
    L29:
        return false;
    }

    public final int hashCode() {
        int r0 = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        Function4<Integer, Integer, Integer, Integer, Unit> r1 = this.e;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "OnSizeChangedParam(w=" + this.a + ", h=" + this.b + ", oldw=" + this.c + ", oldh=" + this.d + ", superMethod=" + this.e + ")";
    }

    @Override // n28.a
    public final void b() {
        this.e.invoke(Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(int r1, int r2, int r3, int r4, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
