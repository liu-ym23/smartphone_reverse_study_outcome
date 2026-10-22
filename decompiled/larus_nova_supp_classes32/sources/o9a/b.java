package o9a;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final /* synthetic */ int b = 0;
    public final List<c> a;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "MenuBean(menuItems=" + this.a + ')';
    }

    public b() {
        this(CollectionsKt.emptyList());
    }

    public b(List<c> r2) {
        Intrinsics.checkNotNullParameter(r2, "menuItems");
        this.a = r2;
    }
}
