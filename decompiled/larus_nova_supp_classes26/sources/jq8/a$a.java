package jq8;

import com.larus.bmhome.interactionpanel.m;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a$a<T> implements Comparator {
    public a$a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((m) r3).h), Long.valueOf(((m) r4).h));
    }
}
