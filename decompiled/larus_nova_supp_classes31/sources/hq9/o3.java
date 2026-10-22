package hq9;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o3 {
    public final boolean a;
    public final Set<String> b;

    public o3() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o3) == true) goto L8;
        return false;
    L8:
        o3 r6 = (o3) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.b.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeTaskSettingsDisplayConfig(enableFilter=" + this.a + ", itemAllowList=" + this.b + ')';
    }

    public o3(Object r2) {
        Set<String> r3 = SetsKt.emptySet();
        Intrinsics.checkNotNullParameter(r3, "itemAllowList");
        this.a = false;
        this.b = r3;
    }
}
