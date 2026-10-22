package d49;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c$f implements c {
    public final int a;
    public final z39.a b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c$f) == true) goto L8;
        return false;
    L8:
        c$f r6 = (c$f) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b.hashCode()) * 31) + this.c;
    }

    public final String toString() {
        return "OTAProgressing(otaTaskId=" + this.a + ", response=" + this.b + ", progress=" + this.c + ')';
    }

    public c$f(int r2, z39.a r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "response");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
