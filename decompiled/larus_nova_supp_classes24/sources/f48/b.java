package f48;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b<T> implements Comparator {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        ((c) r2).priority();
        ((c) r1).priority();
        return ComparisonsKt.compareValues(0, 0);
    }
}
