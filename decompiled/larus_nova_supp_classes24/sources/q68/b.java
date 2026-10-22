package q68;

import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final <T> void a(Set<T> r1, Function1<? super T, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "observers");
        Intrinsics.checkNotNullParameter(r2, "action");
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.invoke(r3.next());
        goto L4
    }
}
