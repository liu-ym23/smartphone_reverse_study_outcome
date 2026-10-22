package pn0;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public final int a;
    public final int b;
    public final Map<Integer, List<Integer>> c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L12;
        g r4 = (g) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        Map<Integer, List<Integer>> r1 = this.c;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("{modifiedUILayout = ");
        r0.append(this.a);
        r0.append(", modifiedOrientation = ");
        r0.append(this.b);
        r0.append("}, modifyUIFeatureConfigOffsetMapSize = ");
        Map<Integer, List<Integer>> r1 = this.c;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.size());
    L6:
        r0.append(r2);
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(int r1, int r2, Map<Integer, ? extends List<Integer>> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
