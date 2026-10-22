package o8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public String a;

    public f() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((f) r10).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "MonitorConfig(virtualAid=" + this.a + ')';
    }

    public f(int r10) {
        Intrinsics.checkNotNullParameter("88888", "virtualAid");
        this.a = "88888";
    }
}
