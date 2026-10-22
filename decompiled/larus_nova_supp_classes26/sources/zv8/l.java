package zv8;

import com.larus.business.debug.base.register.EntranceGroup;
import java.util.Comparator;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l<T> implements Comparator {
    public l() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        EntranceGroup[] r0 = EntranceGroup.values();
        Integer r4 = Integer.valueOf(ArraysKt.indexOf(r0, (EntranceGroup) r2));
        EntranceGroup[] r1 = EntranceGroup.values();
        return ComparisonsKt.compareValues(r4, Integer.valueOf(ArraysKt.indexOf(r1, (EntranceGroup) r3)));
    }
}
