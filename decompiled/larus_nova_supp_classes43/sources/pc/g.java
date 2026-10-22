package pc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public final String a;
    public final b b;

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final boolean equals(Object r10) {
        if ((r10 instanceof g) == false) goto L9;
        g r11 = (g) r10;
        if (Intrinsics.areEqual(r11.a, this.a) == false) goto L9;
        if (Intrinsics.areEqual(r11.b, this.b) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public g(String r1, b r10) {
        this.a = r1;
        this.b = r10;
    }
}
