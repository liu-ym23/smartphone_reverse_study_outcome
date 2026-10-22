package hq9;

import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public final boolean a;
    public final Set<String> b;
    public final Set<String> c;
    public final Map<String, String> d;
    public final String e;

    public c() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        String r2 = this.e;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "AboutAppDisplayConfig(enableFilter=" + this.a + ", sectionAllowList=" + this.b + ", itemAllowList=" + this.c + ", itemLinkMap=" + this.d + ", appDisplayName=" + this.e + ')';
    }

    public c(Object r4) {
        Set<String> r5 = SetsKt.emptySet();
        Set<String> r0 = SetsKt.emptySet();
        Map<String, String> r1 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r5, "sectionAllowList");
        Intrinsics.checkNotNullParameter(r0, "itemAllowList");
        Intrinsics.checkNotNullParameter(r1, "itemLinkMap");
        this.a = false;
        this.b = r5;
        this.c = r0;
        this.d = r1;
        this.e = null;
    }
}
