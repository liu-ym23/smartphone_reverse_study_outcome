package h3a;

import com.larus.voicecall.impl.component.dialog.RealtimeDialogTriggerTime;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements t1a.c {
    public final Lazy a;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            ((h3a.a) r1).getPriority();
            ((h3a.a) r2).getPriority();
            return ComparisonsKt.compareValues(10000, 10000);
        }
    }

    public c() {
        this.a = LazyKt.lazy(new b());
    }

    public final void a(RealtimeDialogTriggerTime r4) {
        Intrinsics.checkNotNullParameter(r4, "triggerTime");
        List r0 = (List) ((Map) this.a.getValue()).get(r4);
        if (r0 == null) goto L14;
        Iterator r1 = CollectionsKt.sortedWith(r0, new a()).iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        h3a.a r2 = (h3a.a) r1.next();
        if (r2.a(r4) == false) goto L6;
        r2.b(r4);
        return;
    L15:
        return;
    }
}
