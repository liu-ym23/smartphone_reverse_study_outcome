package js8;

import is8.g;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final List<c> a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends c> r2) {
        Intrinsics.checkNotNullParameter(r2, "providers");
        this.a = r2;
    }

    public final Object a(g r5, is8.a r6, Continuation<? super b> r7) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((c) r1).b(r6.a) == false) goto L4;
    L9:
        c r2 = (c) r1;
        if (r2 == null) goto L14;
        return r2.a(r5, r6, r7);
    L14:
        throw new IllegalStateException("No credential provider bound for auth mode: " + r6.a);
    L8:
        r1 = null;
        goto L9
    }
}
