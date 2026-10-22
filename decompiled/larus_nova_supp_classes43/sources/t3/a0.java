package t3;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a0<T> implements Comparator {
    public a0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r10) {
        return ComparisonsKt.compareValues(((l0) r1).a, ((l0) r10).a);
    }
}
