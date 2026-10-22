package kotlin.collections;

import java.util.List;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    public CollectionsKt__ReversedViewsKt() {
    }

    public static final /* synthetic */ int access$reverseElementIndex(List r10, int r11) {
        return reverseElementIndex$CollectionsKt__ReversedViewsKt(r10, r11);
    }

    public static final /* synthetic */ int access$reverseIteratorIndex(List r10, int r11) {
        return reverseIteratorIndex$CollectionsKt__ReversedViewsKt(r10, r11);
    }

    public static final /* synthetic */ int access$reversePositionIndex(List r10, int r11) {
        return reversePositionIndex$CollectionsKt__ReversedViewsKt(r10, r11);
    }

    public static final <T> List<T> asReversed(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new ReversedListReadOnly(r10);
    }

    @JvmName(name = "asReversedMutable")
    public static <T> List<T> asReversedMutable(List<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new ReversedList(r10);
    }

    private static final int reverseElementIndex$CollectionsKt__ReversedViewsKt(List<?> r10, int r11) {
        if (new IntRange(0, CollectionsKt.getLastIndex(r10)).contains(r11) == false) goto L7;
        return CollectionsKt.getLastIndex(r10) - r11;
    L7:
        throw new IndexOutOfBoundsException("Element index " + r11 + " must be in range [" + new IntRange(0, CollectionsKt.getLastIndex(r10)) + "].");
    }

    private static final int reverseIteratorIndex$CollectionsKt__ReversedViewsKt(List<?> r10, int r11) {
        return CollectionsKt.getLastIndex(r10) - r11;
    }

    private static final int reversePositionIndex$CollectionsKt__ReversedViewsKt(List<?> r10, int r11) {
        if (new IntRange(0, r10.size()).contains(r11) == false) goto L7;
        return r10.size() - r11;
    L7:
        throw new IndexOutOfBoundsException("Position index " + r11 + " must be in range [" + new IntRange(0, r10.size()) + "].");
    }
}
