package tt8;

import kotlin.jvm.internal.Intrinsics;
import ut8.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final int a;
    public final int b;
    public final boolean c;
    public final f d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
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
        int r0 = ((this.a * 31) + this.b) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        f r3 = this.d;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return r2 + r4;
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "SelectorRestoreInfo(startCursorPos=" + this.a + ", endCursorPos=" + this.b + ", isTextViewDetachedWithSelector=" + this.c + ", outsideTouchInterceptor=" + this.d + ')';
    }

    public c(int r1, int r2, f r3) {
        this.a = r1;
        this.b = r2;
        this.c = true;
        this.d = r3;
    }
}
