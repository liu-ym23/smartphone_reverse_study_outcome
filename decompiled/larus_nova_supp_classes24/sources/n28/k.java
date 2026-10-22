package n28;

import android.graphics.Rect;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k extends a {
    public final boolean a;
    public final int b;
    public final Rect c;
    public final Function3<Boolean, Integer, Rect, Unit> d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
    L22:
        return true;
    L5:
        if ((r5 instanceof k) == false) goto L21;
        k r6 = (k) r5;
        if (this.a != r6.a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L21;
        if (this.b != r6.b) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L21;
        if (Intrinsics.areEqual(this.c, r6.c) == false) goto L21;
        if (Intrinsics.areEqual(this.d, r6.d) == false) goto L21;
    L14:
        r2 = false;
        goto L15
    L9:
        r1 = false;
    L21:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = ((r1 * 31) + this.b) * 31;
        Rect r3 = this.c;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        Function3<Boolean, Integer, Rect, Unit> r7 = this.d;
        if (r7 == null) goto L13;
        r4 = r7.hashCode();
    L13:
        return r6 + r4;
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "OnFocusChangedParam(gainFocus=" + this.a + ", direction=" + this.b + ", previouslyFocusedRect=" + this.c + ", superMethod=" + this.d + ")";
    }

    @Override // n28.a
    public final void b() {
        this.d.invoke(Boolean.valueOf(this.a), Integer.valueOf(this.b), this.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(boolean r1, int r2, Rect r3, Function3<? super Boolean, ? super Integer, ? super Rect, Unit> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
