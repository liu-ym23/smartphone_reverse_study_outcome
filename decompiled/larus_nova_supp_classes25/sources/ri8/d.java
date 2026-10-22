package ri8;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d<T> implements Comparator {
    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues((Integer) ((Pair) r1).getSecond(), (Integer) ((Pair) r2).getSecond());
    }
}
