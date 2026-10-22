package e19;

import com.larus.common_ui.floatwindow.manager.IFloatWindowHostProvider;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d<T> implements Comparator {
    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((IFloatWindowHostProvider) r2).getPriority()), Integer.valueOf(((IFloatWindowHostProvider) r1).getPriority()));
    }
}
