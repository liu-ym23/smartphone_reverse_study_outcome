package b30;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b0 {
    public final Map<String, String> a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof b0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((b0) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, String> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "SetStarGraphTaskEvent(args=" + this.a + ")";
    }

    public b0(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        this.a = r2;
    }
}
