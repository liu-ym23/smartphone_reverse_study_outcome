package vp9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public final op9.d a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "CurSelected(curSelectedUIMediaItem=" + this.a + ')';
    }

    public d(op9.d r2) {
        Intrinsics.checkNotNullParameter(r2, "curSelectedUIMediaItem");
        this.a = r2;
    }
}
