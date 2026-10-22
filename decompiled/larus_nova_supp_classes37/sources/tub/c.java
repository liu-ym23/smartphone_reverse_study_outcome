package tub;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final List<d> a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "RecordingPrioritySnapshot(activeInstances=" + this.a + ')';
    }

    public c(List<d> r2) {
        Intrinsics.checkNotNullParameter(r2, "activeInstances");
        this.a = r2;
    }
}
