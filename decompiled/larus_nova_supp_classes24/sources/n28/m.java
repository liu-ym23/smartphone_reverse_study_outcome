package n28;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m extends a {
    public final int a;
    public final int b;
    public final Function2<Integer, Integer, Unit> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
    L20:
        return true;
    L5:
        if ((r5 instanceof m) == false) goto L19;
        m r6 = (m) r5;
        if (this.a != r6.a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L19;
        if (this.b != r6.b) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L19;
        if (Intrinsics.areEqual(this.c, r6.c) == false) goto L19;
    L14:
        r2 = false;
        goto L15
    L9:
        r1 = false;
    L19:
        return false;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        Function2<Integer, Integer, Unit> r1 = this.c;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "OnMeasureParam(widthMeasureSpec=" + this.a + ", heightMeasureSpec=" + this.b + ", superMethod=" + this.c + ")";
    }

    @Override // n28.a
    public final void b() {
        this.c.invoke(Integer.valueOf(this.a), Integer.valueOf(this.b));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(int r1, int r2, Function2<? super Integer, ? super Integer, Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
