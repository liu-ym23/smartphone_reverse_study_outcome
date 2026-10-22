package d49;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c$b implements c {
    public final String a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof c$b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((c$b) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "LoadFailed(reason=" + this.a + ')';
    }

    public c$b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        this.a = r2;
    }
}
