package ns9;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final int a;
    public final Map<String, String> b;

    public b() {
        this(0, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        Map<String, String> r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ReachAction(type=" + this.a + ", data=" + this.b + ')';
    }

    public final int getType() {
        return this.a;
    }

    public b(int r1, Map<String, String> r2) {
        this.a = r1;
        this.b = r2;
    }
}
