package jc8;

import com.larus.bmhome.chat.block.base.IBlockProvider;
import java.util.Comparator;
import java.util.List;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g<T> implements Comparator {
    public final /* synthetic */ List a;

    public g(List r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        return ComparisonsKt.compareValues(Integer.valueOf(this.a.indexOf(((IBlockProvider) r2).N0())), Integer.valueOf(this.a.indexOf(((IBlockProvider) r3).N0())));
    }
}
