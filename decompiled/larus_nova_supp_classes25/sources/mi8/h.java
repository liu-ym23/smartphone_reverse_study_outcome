package mi8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public final List<String> a;
    public final f b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
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
        return "MoaGrantingPrepareRequest(schemaPayloads=" + this.a + ", messageContext=" + this.b + ')';
    }

    public h(List<String> r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "schemaPayloads");
        Intrinsics.checkNotNullParameter(r3, "messageContext");
        this.a = r2;
        this.b = r3;
    }
}
