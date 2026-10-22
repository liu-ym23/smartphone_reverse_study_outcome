package t3;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z<T> implements Comparator {
    public z() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r10) {
        return ComparisonsKt.compareValues(((d0) r1).a, ((d0) r10).a);
    }
}
