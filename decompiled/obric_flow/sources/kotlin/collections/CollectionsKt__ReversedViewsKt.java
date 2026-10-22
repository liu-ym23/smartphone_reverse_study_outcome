package kotlin.collections;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\b\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\n\u001a\u001d\u0010\u000b\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"asReversed", "", ExifInterface.GPS_DIRECTION_TRUE, "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reverseIteratorIndex", "reverseIteratorIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    public CollectionsKt__ReversedViewsKt() {
    }

    public static final /* synthetic */ int access$reverseElementIndex(List r5, int r10) {
        return reverseElementIndex$CollectionsKt__ReversedViewsKt(r5, r10);
    }

    public static final /* synthetic */ int access$reverseIteratorIndex(List r5, int r10) {
        return reverseIteratorIndex$CollectionsKt__ReversedViewsKt(r5, r10);
    }

    public static final /* synthetic */ int access$reversePositionIndex(List r5, int r10) {
        return reversePositionIndex$CollectionsKt__ReversedViewsKt(r5, r10);
    }

    public static final <T> List<T> asReversed(List<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new ReversedListReadOnly(r5);
    }

    @JvmName(name = "asReversedMutable")
    public static <T> List<T> asReversedMutable(List<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new ReversedList(r5);
    }

    private static final int reverseElementIndex$CollectionsKt__ReversedViewsKt(List<?> r5, int r10) {
        if (r10 >= 0) goto L4;
    L7:
        StringBuilder r11 = j0.s(r10, "Element index ", " must be in range [");
        r11.append(new IntRange(0, CollectionsKt__CollectionsKt.getLastIndex(r5)));
        r11.append("].");
        throw new IndexOutOfBoundsException(r11.toString());
    L4:
        if (r10 > CollectionsKt__CollectionsKt.getLastIndex(r5)) goto L7;
        return CollectionsKt__CollectionsKt.getLastIndex(r5) - r10;
    }

    private static final int reverseIteratorIndex$CollectionsKt__ReversedViewsKt(List<?> r5, int r10) {
        return CollectionsKt__CollectionsKt.getLastIndex(r5) - r10;
    }

    private static final int reversePositionIndex$CollectionsKt__ReversedViewsKt(List<?> r5, int r10) {
        if (r10 >= 0) goto L4;
    L7:
        StringBuilder r11 = j0.s(r10, "Position index ", " must be in range [");
        r11.append(new IntRange(0, r5.size()));
        r11.append("].");
        throw new IndexOutOfBoundsException(r11.toString());
    L4:
        if (r10 > r5.size()) goto L7;
        return r5.size() - r10;
    }
}
