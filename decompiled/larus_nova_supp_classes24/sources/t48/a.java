package t48;

import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final boolean a;
    public final Map<String, String> b;
    public final Set<String> c;

    public a() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "AboutAppHostConfig(isOversea=" + this.a + ", itemLinkMap=" + this.b + ", disabledActionItems=" + this.c + ')';
    }

    public /* synthetic */ a(int r3) {
        this(false, MapsKt.emptyMap(), SetsKt.emptySet());
    }

    public a(boolean r2, Map<String, String> r3, Set<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "itemLinkMap");
        Intrinsics.checkNotNullParameter(r4, "disabledActionItems");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
