package n28;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n extends a {
    public final View a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final Function5<View, Integer, Integer, Integer, Integer, Unit> f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
    L32:
        return true;
    L5:
        if ((r5 instanceof n) == false) goto L31;
        n r6 = (n) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == false) goto L31;
        if (this.b != r6.b) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L31;
        if (this.c != r6.c) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L31;
        if (this.d != r6.d) goto L21;
        boolean r3 = true;
    L22:
        if (r3 == false) goto L31;
        if (this.e != r6.e) goto L26;
        boolean r4 = true;
    L27:
        if (r4 == false) goto L31;
        if (Intrinsics.areEqual(this.f, r6.f) == false) goto L31;
    L26:
        r4 = false;
        goto L27
    L21:
        r3 = false;
        goto L22
    L16:
        r2 = false;
        goto L17
    L11:
        r1 = false;
    L31:
        return false;
    }

    public final int hashCode() {
        View r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((((((r2 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
        Function5<View, Integer, Integer, Integer, Integer, Unit> r4 = this.f;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OnNestedScrollParam(target=" + this.a + ", dxConsumed=" + this.b + ", dyConsumed=" + this.c + ", dxUnconsumed=" + this.d + ", dyUnconsumed=" + this.e + ", superMethod=" + this.f + ")";
    }

    @Override // n28.a
    public final void b() {
        this.f.invoke(this.a, Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(View r1, int r2, int r3, int r4, int r5, Function5<? super View, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
