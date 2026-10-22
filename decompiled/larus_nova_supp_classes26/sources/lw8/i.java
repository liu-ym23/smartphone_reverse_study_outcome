package lw8;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public final boolean a;
    public final View b;
    public final boolean c;
    public final String d;

    public i() {
        this(false, null, false, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        View r4 = this.b;
        int r5 = 0;
        if (r4 != null) goto L8;
        int r6 = 0;
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.c;
        if (r8 == true) goto L13;
        r1 = r8;
    L13:
        int r9 = (r7 + r1) * 31;
        String r10 = this.d;
        if (r10 == null) goto L18;
        r5 = r10.hashCode();
    L18:
        return r9 + r5;
    L8:
        r6 = r4.hashCode();
        goto L9
    }

    public final String toString() {
        return "IncrementalTextSpanParams(abilitySwitch=" + this.a + ", viewGroup=" + this.b + ", incrementalConditionMet=" + this.c + ", incrementalText=" + this.d + ')';
    }

    public i(boolean r1, View r2, boolean r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
