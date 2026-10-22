package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.ExperimentalStdlibApi;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public final class CollectionsKt extends CollectionsKt___CollectionsKt {
    private CollectionsKt() {
    }

    public static /* bridge */ /* synthetic */ <T> boolean addAll(Collection<? super T> r10, Iterable<? extends T> r11) {
        return CollectionsKt__MutableCollectionsKt.addAll(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> boolean addAll(Collection<? super T> r10, Sequence<? extends T> r11) {
        return CollectionsKt__MutableCollectionsKt.addAll(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> boolean addAll(Collection<? super T> r10, T[] r11) {
        return CollectionsKt__MutableCollectionsKt.addAll(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> boolean all(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        return CollectionsKt___CollectionsKt.all(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> ArrayList<T> arrayListOf(T... r10) {
        return CollectionsKt__CollectionsKt.arrayListOf(r10);
    }

    @JvmName(name = "asReversedMutable")
    public static /* bridge */ /* synthetic */ <T> List<T> asReversedMutable(List<T> r10) {
        return CollectionsKt__ReversedViewsKt.asReversedMutable(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Sequence<T> asSequence(Iterable<? extends T> r10) {
        return CollectionsKt___CollectionsKt.asSequence(r10);
    }

    public static /* bridge */ /* synthetic */ int binarySearch$default(List r10, Comparable r11, int r12, int r13, int r14, Object r15) {
        return CollectionsKt__CollectionsKt.binarySearch$default(r10, r11, r12, r13, r14, r15);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static /* bridge */ /* synthetic */ <E> List<E> build(List<E> r10) {
        return CollectionsKt__CollectionsJVMKt.build(r10);
    }

    @PublishedApi
    public static /* bridge */ /* synthetic */ <T> int collectionSizeOrDefault(Iterable<? extends T> r10, int r11) {
        return CollectionsKt__IterablesKt.collectionSizeOrDefault(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> boolean contains(Iterable<? extends T> r10, T r11) {
        return CollectionsKt___CollectionsKt.contains(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> Collection<T> convertToListIfNotCollection(Iterable<? extends T> r10) {
        return CollectionsKt__MutableCollectionsKt.convertToListIfNotCollection(r10);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static /* bridge */ /* synthetic */ <E> List<E> createListBuilder() {
        return CollectionsKt__CollectionsJVMKt.createListBuilder();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static /* bridge */ /* synthetic */ <E> List<E> createListBuilder(int r10) {
        return CollectionsKt__CollectionsJVMKt.createListBuilder(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> distinct(Iterable<? extends T> r10) {
        return CollectionsKt___CollectionsKt.distinct(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> drop(Iterable<? extends T> r10, int r11) {
        return CollectionsKt___CollectionsKt.drop(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> dropLast(List<? extends T> r10, int r11) {
        return CollectionsKt___CollectionsKt.dropLast(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> T elementAt(Iterable<? extends T> r10, int r11) {
        return (T) CollectionsKt___CollectionsKt.elementAt(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> emptyList() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static /* bridge */ /* synthetic */ <T> List<T> filter(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        return CollectionsKt___CollectionsKt.filter(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <R> List<R> filterIsInstance(Iterable<?> r10, Class<R> r11) {
        return CollectionsKt___CollectionsJvmKt.filterIsInstance(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> filterNotNull(Iterable<? extends T> r10) {
        return CollectionsKt___CollectionsKt.filterNotNull(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T first(Iterable<? extends T> r10) {
        return (T) CollectionsKt___CollectionsKt.first(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T first(List<? extends T> r10) {
        return (T) CollectionsKt___CollectionsKt.first(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T firstOrNull(Iterable<? extends T> r10) {
        return (T) CollectionsKt___CollectionsKt.firstOrNull(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T firstOrNull(List<? extends T> r10) {
        return (T) CollectionsKt___CollectionsKt.firstOrNull(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> flatten(Iterable<? extends Iterable<? extends T>> r10) {
        return CollectionsKt__IterablesKt.flatten(r10);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(Collection<?> r10) {
        return CollectionsKt__CollectionsKt.getIndices(r10);
    }

    public static /* bridge */ /* synthetic */ <T> int getLastIndex(List<? extends T> r10) {
        return CollectionsKt__CollectionsKt.getLastIndex(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T getOrNull(List<? extends T> r10, int r11) {
        return (T) CollectionsKt___CollectionsKt.getOrNull(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> int indexOf(List<? extends T> r10, T r11) {
        return CollectionsKt___CollectionsKt.indexOf(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> Set<T> intersect(Iterable<? extends T> r10, Iterable<? extends T> r11) {
        return CollectionsKt___CollectionsKt.intersect(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> Iterator<T> iterator(Enumeration<T> r10) {
        return CollectionsKt__IteratorsJVMKt.iterator(r10);
    }

    public static /* bridge */ /* synthetic */ Appendable joinTo$default(Iterable r10, Appendable r11, CharSequence r12, CharSequence r13, CharSequence r14, int r15, CharSequence r16, Function1 r17, int r18, Object r19) {
        return CollectionsKt___CollectionsKt.joinTo$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(Iterable r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1 r16, int r17, Object r18) {
        return CollectionsKt___CollectionsKt.joinToString$default(r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* bridge */ /* synthetic */ <T> T last(Iterable<? extends T> r10) {
        return (T) CollectionsKt___CollectionsKt.last(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T last(List<? extends T> r10) {
        return (T) CollectionsKt___CollectionsKt.last(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T lastOrNull(Iterable<? extends T> r10) {
        return (T) CollectionsKt___CollectionsKt.lastOrNull(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T lastOrNull(List<? extends T> r10) {
        return (T) CollectionsKt___CollectionsKt.lastOrNull(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> listOf(T r10) {
        return CollectionsKt__CollectionsJVMKt.listOf(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> listOf(T... r10) {
        return CollectionsKt__CollectionsKt.listOf(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> listOfNotNull(T r10) {
        return CollectionsKt__CollectionsKt.listOfNotNull(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> listOfNotNull(T... r10) {
        return CollectionsKt__CollectionsKt.listOfNotNull(r10);
    }

    public static /* bridge */ /* synthetic */ <T, R> List<R> map(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        return CollectionsKt___CollectionsKt.map(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    public static /* bridge */ /* synthetic */ <T extends Comparable<? super T>> T minOrNull(Iterable<? extends T> r10) {
        return (T) CollectionsKt___CollectionsKt.minOrNull(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> minus(Iterable<? extends T> r10, T r11) {
        return CollectionsKt___CollectionsKt.minus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> mutableListOf(T... r10) {
        return CollectionsKt__CollectionsKt.mutableListOf(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> plus(Iterable<? extends T> r10, Iterable<? extends T> r11) {
        return CollectionsKt___CollectionsKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> plus(Iterable<? extends T> r10, T r11) {
        return CollectionsKt___CollectionsKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> plus(Collection<? extends T> r10, Iterable<? extends T> r11) {
        return CollectionsKt___CollectionsKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> plus(Collection<? extends T> r10, T r11) {
        return CollectionsKt___CollectionsKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> boolean removeAll(List<T> r10, Function1<? super T, Boolean> r11) {
        return CollectionsKt__MutableCollectionsKt.removeAll(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* bridge */ /* synthetic */ <T> T removeLast(List<T> r10) {
        return (T) CollectionsKt__MutableCollectionsKt.removeLast(r10);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* bridge */ /* synthetic */ <T> T removeLastOrNull(List<T> r10) {
        return (T) CollectionsKt__MutableCollectionsKt.removeLastOrNull(r10);
    }

    public static /* bridge */ /* synthetic */ <T> boolean retainAll(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        return CollectionsKt__MutableCollectionsKt.retainAll(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> void reverse(List<T> r10) {
        CollectionsKt___CollectionsJvmKt.reverse(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> reversed(Iterable<? extends T> r10) {
        return CollectionsKt___CollectionsKt.reversed(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T single(Iterable<? extends T> r10) {
        return (T) CollectionsKt___CollectionsKt.single(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T single(List<? extends T> r10) {
        return (T) CollectionsKt___CollectionsKt.single(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T singleOrNull(Iterable<? extends T> r10) {
        return (T) CollectionsKt___CollectionsKt.singleOrNull(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T singleOrNull(List<? extends T> r10) {
        return (T) CollectionsKt___CollectionsKt.singleOrNull(r10);
    }

    public static /* bridge */ /* synthetic */ <T extends Comparable<? super T>> void sort(List<T> r10) {
        CollectionsKt__MutableCollectionsJVMKt.sort(r10);
    }

    public static /* bridge */ /* synthetic */ <T> void sortWith(List<T> r10, Comparator<? super T> r11) {
        CollectionsKt__MutableCollectionsJVMKt.sortWith(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T extends Comparable<? super T>> List<T> sorted(Iterable<? extends T> r10) {
        return CollectionsKt___CollectionsKt.sorted(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> sortedWith(Iterable<? extends T> r10, Comparator<? super T> r11) {
        return CollectionsKt___CollectionsKt.sortedWith(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> take(Iterable<? extends T> r10, int r11) {
        return CollectionsKt___CollectionsKt.take(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> takeLast(List<? extends T> r10, int r11) {
        return CollectionsKt___CollectionsKt.takeLast(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static /* bridge */ /* synthetic */ void throwCountOverflow() {
        CollectionsKt__CollectionsKt.throwCountOverflow();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static /* bridge */ /* synthetic */ void throwIndexOverflow() {
        CollectionsKt__CollectionsKt.throwIndexOverflow();
    }

    public static /* bridge */ /* synthetic */ boolean[] toBooleanArray(Collection<Boolean> r10) {
        return CollectionsKt___CollectionsKt.toBooleanArray(r10);
    }

    public static /* bridge */ /* synthetic */ double[] toDoubleArray(Collection<Double> r10) {
        return CollectionsKt___CollectionsKt.toDoubleArray(r10);
    }

    public static /* bridge */ /* synthetic */ float[] toFloatArray(Collection<Float> r10) {
        return CollectionsKt___CollectionsKt.toFloatArray(r10);
    }

    public static /* bridge */ /* synthetic */ int[] toIntArray(Collection<Integer> r10) {
        return CollectionsKt___CollectionsKt.toIntArray(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> toList(Iterable<? extends T> r10) {
        return CollectionsKt___CollectionsKt.toList(r10);
    }

    public static /* bridge */ /* synthetic */ long[] toLongArray(Collection<Long> r10) {
        return CollectionsKt___CollectionsKt.toLongArray(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> toMutableList(Collection<? extends T> r10) {
        return CollectionsKt___CollectionsKt.toMutableList(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Set<T> toMutableSet(Iterable<? extends T> r10) {
        return CollectionsKt___CollectionsKt.toMutableSet(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Set<T> toSet(Iterable<? extends T> r10) {
        return CollectionsKt___CollectionsKt.toSet(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Set<T> union(Iterable<? extends T> r10, Iterable<? extends T> r11) {
        return CollectionsKt___CollectionsKt.union(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> Iterable<IndexedValue<T>> withIndex(Iterable<? extends T> r10) {
        return CollectionsKt___CollectionsKt.withIndex(r10);
    }

    public static /* bridge */ /* synthetic */ <T, R> List<Pair<T, R>> zip(Iterable<? extends T> r10, Iterable<? extends R> r11) {
        return CollectionsKt___CollectionsKt.zip(r10, r11);
    }
}
