package ic8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r {
    public final String a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof r) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((r) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "DriveImageExtraInfo(fileToken=" + this.a + ')';
    }

    public r(String r1) {
        this.a = r1;
    }
}
