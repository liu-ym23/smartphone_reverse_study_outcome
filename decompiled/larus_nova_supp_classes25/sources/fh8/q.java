package fh8;

import android.text.Spanned;
import io.noties.markwon.ext.tables.TableRowSpan2;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q<T> implements Comparator {
    public final /* synthetic */ Spanned a;

    public q(Spanned r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        Spanned r0 = this.a;
        Integer r4 = Integer.valueOf(r0.getSpanStart((TableRowSpan2) r2));
        Spanned r1 = this.a;
        return ComparisonsKt.compareValues(r4, Integer.valueOf(r1.getSpanStart((TableRowSpan2) r3)));
    }
}
