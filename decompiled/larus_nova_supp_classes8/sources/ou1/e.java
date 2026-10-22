package ou1;

import java.util.Iterator;
import java.util.Map;
import ju1.h;
import ju1.i;
import ju1.j;
import ju1.k;
import ju1.n;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements nu1.f<j> {
    public final nu1.b a;

    public static final class a {
    }

    static {
    }

    public e() {
        nu1.a r0 = nu1.a.a;
        Intrinsics.checkNotNullParameter(r0, "expressionExecutor");
        this.a = r0;
    }

    @Override // nu1.f
    public final n a(h r5, Map r6) {
        j r7 = (j) r5;
        Intrinsics.checkNotNullParameter(r7, "strategy");
        Intrinsics.checkNotNullParameter(r6, "stateMap");
        CollectionsKt.sortedWith(r7.j(), new f());
        Iterator<T> r0 = r7.j().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        i r1 = (i) r0.next();
        if (Intrinsics.areEqual(this.a.a(r1.b(), r6), Boolean.TRUE) == false) goto L4;
        return new k(r1.a(), false);
    L9:
        return new k(r7.g(), true);
    }
}
