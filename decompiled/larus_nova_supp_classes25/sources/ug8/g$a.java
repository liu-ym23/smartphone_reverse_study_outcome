package ug8;

import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g$a {
    public final Function0<String> a;
    public final Set<String> b;
    public final List<b> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g$a) == true) goto L8;
        return false;
    L8:
        g$a r6 = (g$a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "Config(errorTextProvider=" + this.a + ", blockedIds=" + this.b + ", extraInterceptors=" + this.c + ')';
    }

    public g$a(f r2, Set r3, List r4) {
        Intrinsics.checkNotNullParameter(r2, "errorTextProvider");
        Intrinsics.checkNotNullParameter(r3, "blockedIds");
        Intrinsics.checkNotNullParameter(r4, "extraInterceptors");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
