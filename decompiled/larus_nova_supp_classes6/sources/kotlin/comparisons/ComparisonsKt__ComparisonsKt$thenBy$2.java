package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "T", "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 9, 0}, xi = 176)
public final class ComparisonsKt__ComparisonsKt$thenBy$2<T> implements Comparator {
    final /* synthetic */ Comparator<? super K> $comparator;
    final /* synthetic */ Function1<T, K> $selector;
    final /* synthetic */ Comparator<T> $this_thenBy;

    /* JADX WARN: Multi-variable type inference failed */
    public ComparisonsKt__ComparisonsKt$thenBy$2(Comparator<T> r1, Comparator<? super K> r2, Function1<? super T, ? extends K> r3) {
        this.$this_thenBy = r1;
        this.$comparator = r2;
        this.$selector = r3;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        int r0 = this.$this_thenBy.compare(r3, r4);
        if (r0 != 0) goto L7;
        Comparator<? super K> r1 = this.$comparator;
        Function1<T, K> r2 = this.$selector;
        Object r5 = r2.invoke(r3);
        return r1.compare((Object) r5, (Object) r2.invoke(r4));
    L7:
        return r0;
    }
}
