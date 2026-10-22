package d49;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c$g implements c {
    public final int a;
    public final z39.a b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c$g) == true) goto L8;
        return false;
    L8:
        c$g r6 = (c$g) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "OTASuccess(otaTaskId=" + this.a + ", response=" + this.b + ", version=" + this.c + ')';
    }

    public c$g(int r2, z39.a r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r4, "version");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
