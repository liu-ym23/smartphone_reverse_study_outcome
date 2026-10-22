package v3;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c<T> implements Comparator {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r10, T r11) {
        Double r12 = ((e) r11).d;
        double r0 = -1.0d;
        if (r12 == null) goto L5;
        double r13 = r12.doubleValue();
    L6:
        Double r14 = Double.valueOf(r13);
        Double r15 = ((e) r10).d;
        if (r15 == null) goto L10;
        r0 = r15.doubleValue();
    L10:
        return ComparisonsKt.compareValues(r14, Double.valueOf(r0));
    L5:
        r13 = -1.0d;
        goto L6
    }
}
