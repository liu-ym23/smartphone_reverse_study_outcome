package d49;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c$c implements c {
    public final z39.a a;
    public final String b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c$c) == true) goto L8;
        return false;
    L8:
        c$c r6 = (c$c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        z39.a r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        String r4 = this.c;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "LoadSuccess(response=" + this.a + ", deviceVersion=" + this.b + ", newVersion=" + this.c + ')';
    }

    public c$c(z39.a r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "deviceVersion");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
