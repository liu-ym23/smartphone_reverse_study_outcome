package kc8;

import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t0 {
    public final ExpandCardViewMode a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof t0) == true) goto L9;
        return false;
    L9:
        if (this.a == ((t0) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "SearchMixedMediaConfig(msgExpandMode=" + this.a + ')';
    }

    public t0() {
        this(ExpandCardViewMode.NORMAL);
    }

    public t0(ExpandCardViewMode r2) {
        Intrinsics.checkNotNullParameter(r2, "msgExpandMode");
        this.a = r2;
    }
}
