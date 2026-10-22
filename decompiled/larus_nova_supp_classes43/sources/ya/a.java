package ya;

import java.util.Comparator;
import java.util.Map;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a<T> implements Comparator<T> {
    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r10) {
        return ComparisonsKt.compareValues((Double) ((Pair) ((Map.Entry) r10).getValue()).getSecond(), (Double) ((Pair) ((Map.Entry) r1).getValue()).getSecond());
    }
}
