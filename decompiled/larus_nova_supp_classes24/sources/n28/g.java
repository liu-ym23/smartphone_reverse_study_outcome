package n28;

import android.content.res.Configuration;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g extends a {
    public final Configuration a;
    public final Function1<Configuration, Unit> b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L10;
        g r4 = (g) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Configuration r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Function1<Configuration, Unit> r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OnConfigurationChangedParam(newConfig=" + this.a + ", superMethod=" + this.b + ")";
    }

    @Override // n28.a
    public final void b() {
        this.b.invoke(this.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Configuration r1, Function1<? super Configuration, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }
}
