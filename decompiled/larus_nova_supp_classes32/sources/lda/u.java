package lda;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u {
    public final String a;
    public final List<b0> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r6 = (u) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "OmniRecordsChange(reason=" + this.a + ", records=" + this.b + ')';
    }

    public u(String r2, List<b0> r3) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        Intrinsics.checkNotNullParameter(r3, "records");
        this.a = r2;
        this.b = r3;
    }
}
