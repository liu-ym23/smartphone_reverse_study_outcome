package d49;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c$e implements c {
    public final int a;
    public final z39.a b;
    public final String c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c$e) == true) goto L8;
        return false;
    L8:
        c$e r6 = (c$e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "OTAFailed(otaTaskId=" + this.a + ", response=" + this.b + ", reason=" + this.c + ", deviceVersion=" + this.d + ')';
    }

    public c$e(int r2, z39.a r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r4, "reason");
        Intrinsics.checkNotNullParameter(r5, "deviceVersion");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
