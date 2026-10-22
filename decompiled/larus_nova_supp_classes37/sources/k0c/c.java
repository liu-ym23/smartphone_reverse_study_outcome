package k0c;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c<T> implements Comparator {
    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((b.C0158b) ((Map.Entry) r4).getValue()).d), Long.valueOf(((b.C0158b) ((Map.Entry) r3).getValue()).d));
    }
}
