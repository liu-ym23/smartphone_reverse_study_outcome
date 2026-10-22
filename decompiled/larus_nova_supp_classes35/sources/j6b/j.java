package j6b;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j<T> implements Comparator {
    public final /* synthetic */ Comparator a;

    public j(i r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        int r0 = this.a.compare(r2, r3);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return ComparisonsKt.compareValues((Comparable) ((Pair) r2).getFirst(), (Comparable) ((Pair) r3).getFirst());
    }
}
