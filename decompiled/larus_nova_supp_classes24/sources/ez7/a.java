package ez7;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final /* synthetic */ int b = 0;
    public final Map<String, Boolean> a;

    /* JADX INFO: renamed from: ez7.a$a, reason: collision with other inner class name */
    public static final class C0106a {
    }

    static {
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "FgInfo(fgMap=" + this.a + ')';
    }

    public a(Map<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "fgMap");
        this.a = r2;
    }
}
