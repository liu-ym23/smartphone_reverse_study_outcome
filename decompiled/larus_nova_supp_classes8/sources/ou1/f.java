package ou1;

import java.util.Comparator;
import ju1.i;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T> implements Comparator<T> {
    public f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((i) r1).c()), Integer.valueOf(((i) r2).c()));
    }
}
