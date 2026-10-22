package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class ReverseOrderComparator implements Comparator<Comparable<? super Object>> {
    public static final ReverseOrderComparator INSTANCE = null;

    static {
        INSTANCE = new ReverseOrderComparator();
    }

    private ReverseOrderComparator() {
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Comparable<Object> r10, Comparable<Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "a");
        Intrinsics.checkNotNullParameter(r11, "b");
        return r11.compareTo(r10);
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Comparable<? super Object> r10, Comparable<? super Object> r11) {
        return compare2(r10, r11);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return NaturalOrderComparator.INSTANCE;
    }
}
