package kc8;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public final HashMap<String, Boolean> a;
    public final HashMap<String, i0> b;

    public e() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
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
        return "BlockPipeTransferConfig(deepThinkHideSplitHashMap=" + this.a + ", promotedBlockSourceContextMap=" + this.b + ')';
    }

    public e(Object r3) {
        HashMap<String, Boolean> r4 = new HashMap();
        HashMap<String, i0> r0 = new HashMap();
        Intrinsics.checkNotNullParameter(r4, "deepThinkHideSplitHashMap");
        Intrinsics.checkNotNullParameter(r0, "promotedBlockSourceContextMap");
        this.a = r4;
        this.b = r0;
    }
}
