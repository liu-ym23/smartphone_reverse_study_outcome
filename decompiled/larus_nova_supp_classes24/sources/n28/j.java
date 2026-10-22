package n28;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j extends a {
    public final Function0<Unit> a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof j) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((j) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Function0<Unit> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "OnFinishInflateParam(superMethod=" + this.a + ")";
    }

    @Override // n28.a
    public final void b() {
        this.a.invoke();
    }

    public j(Function0<Unit> r1) {
        this.a = r1;
    }
}
