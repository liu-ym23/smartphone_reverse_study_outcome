package p70;

import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public Set<? extends a<?>> a;

    public b() {
        this.a = null;
    }

    public final <T extends a<?>> T a(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "classChain");
        Set<? extends a<?>> r0 = this.a;
        Object r1 = null;
        if (r0 == null) goto L15;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((a) r3).getClass(), r5) == false) goto L6;
        r1 = r3;
    L11:
        return (T) r1;
    L15:
        return null;
    }
}
