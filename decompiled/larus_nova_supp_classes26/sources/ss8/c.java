package ss8;

import com.larus.bmhome.view.actionbar.api.IActionBarFilter;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c<T> implements Comparator {
    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((IActionBarFilter) r1).getPriority()), Integer.valueOf(((IActionBarFilter) r2).getPriority()));
    }
}
