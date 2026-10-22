package rib;

import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a<T> implements Comparator {
    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((SearchBaseInfo) r4).getTimeStamp()), Long.valueOf(((SearchBaseInfo) r3).getTimeStamp()));
    }
}
