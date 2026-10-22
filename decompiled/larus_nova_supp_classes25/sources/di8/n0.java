package di8;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n0 {
    public final Map<String, List<d0>> a;
    public final List<String> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r6 = (n0) r5;
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
        return "NestedMenuSubMenuModel(menuItemModels=" + this.a + ", sectionOrder=" + this.b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n0(Map<String, ? extends List<? extends d0>> r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "menuItemModels");
        Intrinsics.checkNotNullParameter(r3, "sectionOrder");
        this.a = r2;
        this.b = r3;
    }
}
