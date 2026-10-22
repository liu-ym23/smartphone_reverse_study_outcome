package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes2.dex */
class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    public CollectionsKt__MutableCollectionsKt() {
    }

    public static <T> boolean addAll(Collection<? super T> r10, Iterable<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        if ((r11 instanceof Collection) == true) goto L5;
        boolean r12 = false;
        Iterator<? extends T> r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L12;
        if (r10.add(r13.next()) == false) goto L8;
        r12 = true;
        goto L8
    L12:
        return r12;
    L5:
        return r10.addAll((Collection) r11);
    }

    public static <T> boolean addAll(Collection<? super T> r10, Sequence<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        Iterator<? extends T> r12 = r11.iterator();
        boolean r13 = false;
    L4:
        if (r12.hasNext() == false) goto L8;
        if (r10.add(r12.next()) == false) goto L4;
        r13 = true;
        goto L4
    L8:
        return r13;
    }

    public static <T> boolean addAll(Collection<? super T> r10, T[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return r10.addAll(ArraysKt.asList(r11));
    }

    public static <T> Collection<T> convertToListIfNotCollection(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L6;
        return (Collection) r10;
    L6:
        return CollectionsKt.toList(r10);
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(Iterable<? extends T> r10, Function1<? super T, Boolean> r11, boolean r12) {
        Iterator<? extends T> r13 = r10.iterator();
        boolean r14 = false;
    L4:
        if (r13.hasNext() == false) goto L8;
        if (r11.invoke(r13.next()).booleanValue() != r12) goto L4;
        r13.remove();
        r14 = true;
        goto L4
    L8:
        return r14;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(List<T> r10, Function1<? super T, Boolean> r11, boolean r12) {
        if ((r10 instanceof RandomAccess) == true) goto L6;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(TypeIntrinsics.asMutableIterable(r10), r11, r12);
    L6:
        ?? r13 = new IntRange(0, CollectionsKt.getLastIndex(r10)).iterator2();
        int r14 = 0;
    L8:
        if (r13.hasNext() == false) goto L16;
        int r15 = r13.nextInt();
        T r16 = r10.get(r15);
        if (r11.invoke(r16).booleanValue() == r12) goto L8;
        if (r14 == r15) goto L14;
        r10.set(r14, r16);
    L14:
        r14 = r14 + 1;
        goto L8
    L16:
        if (r14 >= r10.size()) goto L24;
        int r17 = CollectionsKt.getLastIndex(r10);
        if (r14 > r17) goto L22;
    L19:
        r10.remove(r17);
        if (r17 == r14) goto L31;
        r17 = r17 - 1;
        goto L19
    L31:
        return true;
    L22:
        return true;
    L24:
        return false;
    }

    @InlineOnly
    private static final <T> void minusAssign(Collection<? super T> r10, Iterable<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        removeAll(r10, r11);
    }

    @InlineOnly
    private static final <T> void minusAssign(Collection<? super T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.remove(r11);
    }

    @InlineOnly
    private static final <T> void minusAssign(Collection<? super T> r10, Sequence<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        removeAll(r10, r11);
    }

    @InlineOnly
    private static final <T> void minusAssign(Collection<? super T> r10, T[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        removeAll(r10, r11);
    }

    @InlineOnly
    private static final <T> void plusAssign(Collection<? super T> r10, Iterable<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        CollectionsKt.addAll(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> void plusAssign(Collection<? super T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.add(r11);
    }

    @InlineOnly
    private static final <T> void plusAssign(Collection<? super T> r10, Sequence<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        CollectionsKt.addAll(r10, r11);
    }

    @InlineOnly
    private static final <T> void plusAssign(Collection<? super T> r10, T[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        CollectionsKt.addAll(r10, r11);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use removeAt(index) instead.", replaceWith = @ReplaceWith(expression = "removeAt(index)", imports = {}))
    @InlineOnly
    private static final <T> T remove(List<T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.remove(r11);
    }

    @InlineOnly
    private static final <T> boolean remove(Collection<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return TypeIntrinsics.asMutableCollection(r10).remove(r11);
    }

    public static final <T> boolean removeAll(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(r10, r11, true);
    }

    public static final <T> boolean removeAll(Collection<? super T> r10, Iterable<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return r10.removeAll(CollectionsKt.convertToListIfNotCollection(r11));
    }

    @InlineOnly
    private static final <T> boolean removeAll(Collection<? extends T> r10, Collection<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return TypeIntrinsics.asMutableCollection(r10).removeAll(r11);
    }

    public static final <T> boolean removeAll(Collection<? super T> r10, Sequence<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        List r12 = SequencesKt.toList(r11);
        if ((!r12.isEmpty()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r10.removeAll(r12) == false) goto L7;
        return true;
    }

    public static final <T> boolean removeAll(Collection<? super T> r10, T[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        if (r11.length != 0) goto L5;
        boolean r12 = true;
    L7:
        if ((!r12) == true) goto L9;
        return false;
    L9:
        if (r10.removeAll(ArraysKt.asList(r11)) == true) goto L11;
        return false;
    L11:
        return true;
    L5:
        r12 = false;
        goto L7
    }

    public static <T> boolean removeAll(List<T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(r10, r11, true);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T removeFirst(List<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.remove(0);
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T removeFirstOrNull(List<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return r10.remove(0);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static <T> T removeLast(List<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.remove(CollectionsKt.getLastIndex(r10));
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static <T> T removeLastOrNull(List<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return r10.remove(CollectionsKt.getLastIndex(r10));
    }

    public static <T> boolean retainAll(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(r10, r11, false);
    }

    public static final <T> boolean retainAll(Collection<? super T> r10, Iterable<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return r10.retainAll(CollectionsKt.convertToListIfNotCollection(r11));
    }

    @InlineOnly
    private static final <T> boolean retainAll(Collection<? extends T> r10, Collection<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return TypeIntrinsics.asMutableCollection(r10).retainAll(r11);
    }

    public static final <T> boolean retainAll(Collection<? super T> r10, Sequence<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        List r12 = SequencesKt.toList(r11);
        if ((!r12.isEmpty()) == false) goto L7;
        return r10.retainAll(r12);
    L7:
        return retainNothing$CollectionsKt__MutableCollectionsKt(r10);
    }

    public static final <T> boolean retainAll(Collection<? super T> r10, T[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        if (r11.length != 0) goto L5;
        boolean r12 = true;
    L7:
        if ((!r12) == false) goto L11;
        return r10.retainAll(ArraysKt.asList(r11));
    L11:
        return retainNothing$CollectionsKt__MutableCollectionsKt(r10);
    L5:
        r12 = false;
        goto L7
    }

    public static final <T> boolean retainAll(List<T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(r10, r11, false);
    }

    private static final boolean retainNothing$CollectionsKt__MutableCollectionsKt(Collection<?> r10) {
        boolean r11 = !r10.isEmpty();
        r10.clear();
        return r11;
    }
}
