package r2;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final List<e> a;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((c) r10).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "AppletChatActionBarConfig(items=" + this.a + ')';
    }

    public c() {
        this(CollectionsKt.emptyList());
    }

    public c(List<e> r10) {
        Intrinsics.checkNotNullParameter(r10, "items");
        this.a = r10;
    }
}
