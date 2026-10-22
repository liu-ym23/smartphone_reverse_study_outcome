package ad2;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Comparator<T> {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        return ComparisonsKt.compareValues(Integer.valueOf(this.a.a.indexOf(((Pair) r2).getFirst())), Integer.valueOf(this.a.a.indexOf(((Pair) r3).getFirst())));
    }
}
