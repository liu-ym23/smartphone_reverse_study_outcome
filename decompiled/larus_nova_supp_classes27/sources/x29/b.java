package x29;

import com.larus.contextwindow.api.ContextWindowHiddenReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final ContextWindowHiddenReason a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.a == ((b) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Failure(reason=" + this.a + ')';
    }

    public b(ContextWindowHiddenReason r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        this.a = r2;
    }
}
