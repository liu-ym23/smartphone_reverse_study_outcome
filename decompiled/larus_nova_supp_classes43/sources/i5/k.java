package i5;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public final Map<String, ? extends Object> a;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof k) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((k) r10).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "UpdateTitleBar(settings=" + this.a + ')';
    }

    public k(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "settings");
        this.a = r10;
    }
}
