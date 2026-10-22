package kotlin.comparisons;

import java.util.Comparator;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
public final class ComparisonsKt extends ComparisonsKt___ComparisonsKt {
    private ComparisonsKt() {
    }

    public static /* bridge */ /* synthetic */ <T extends Comparable<?>> int compareValues(T r10, T r11) {
        return ComparisonsKt__ComparisonsKt.compareValues(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    public static /* bridge */ /* synthetic */ <T extends Comparable<? super T>> T maxOf(T r10, T r11) {
        return (T) ComparisonsKt___ComparisonsJvmKt.maxOf(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return ComparisonsKt__ComparisonsKt.naturalOrder();
    }

    public static /* bridge */ /* synthetic */ <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        return ComparisonsKt__ComparisonsKt.reverseOrder();
    }
}
