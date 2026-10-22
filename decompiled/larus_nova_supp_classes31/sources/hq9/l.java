package hq9;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l {
    public final Map<String, Boolean> a;

    public l() {
        this(0);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof l) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((l) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Map<String, Boolean> r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "AppsAIChatFrameworkConfig(enabledPages=" + this.a + ')';
    }

    public /* synthetic */ l(int r1) {
        this(MapsKt.emptyMap());
    }

    public l(Map<String, Boolean> r1) {
        this.a = r1;
    }
}
