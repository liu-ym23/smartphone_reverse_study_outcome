package j6b;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i<T> implements Comparator {
    public i() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues((Comparable) ((Pair) r1).getSecond(), (Comparable) ((Pair) r2).getSecond());
    }
}
