package va8;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p0 {
    public final Set<String> a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof p0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((p0) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "PreviewRoundMessageFilterConfig(queryIds=" + this.a + ')';
    }

    public p0(Set<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "queryIds");
        this.a = r2;
    }
}
