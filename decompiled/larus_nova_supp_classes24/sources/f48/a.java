package f48;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: f48.a$a, reason: collision with other inner class name */
    public static final class C0107a<T> implements Comparator {
        public C0107a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            ((c) r2).priority();
            ((c) r1).priority();
            return ComparisonsKt.compareValues(0, 0);
        }
    }

    static {
    }

    public static boolean a(Iterable r1, Function1 r2) {
        Intrinsics.checkNotNullParameter(r1, "services");
        Intrinsics.checkNotNullParameter(r2, "block");
        List r3 = CollectionsKt.sortedWith(r1, new C0107a());
        if ((r3 instanceof Collection) == true) goto L5;
    L7:
        Iterator r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        if (((Boolean) r2.invoke(r4.next())).booleanValue() == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r3.isEmpty() == false) goto L7;
        goto L7
    }
}
