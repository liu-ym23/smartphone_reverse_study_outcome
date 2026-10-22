package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class ReversedComparator<T> implements Comparator<T> {
    private final Comparator<T> comparator;

    public ReversedComparator(Comparator<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "comparator");
        this.comparator = r10;
    }

    @Override // java.util.Comparator
    public int compare(T r10, T r11) {
        return this.comparator.compare(r11, r10);
    }

    public final Comparator<T> getComparator() {
        return this.comparator;
    }

    @Override // java.util.Comparator
    public final Comparator<T> reversed() {
        return this.comparator;
    }
}
