package kotlin.collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public final class ArraysKt extends ArraysKt___ArraysKt {
    private ArraysKt() {
    }

    public static /* bridge */ /* synthetic */ boolean any(byte[] r10) {
        return ArraysKt___ArraysKt.any(r10);
    }

    public static /* bridge */ /* synthetic */ boolean any(int[] r10) {
        return ArraysKt___ArraysKt.any(r10);
    }

    public static /* bridge */ /* synthetic */ boolean any(long[] r10) {
        return ArraysKt___ArraysKt.any(r10);
    }

    public static /* bridge */ /* synthetic */ boolean any(short[] r10) {
        return ArraysKt___ArraysKt.any(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Iterable<T> asIterable(T[] r10) {
        return ArraysKt___ArraysKt.asIterable(r10);
    }

    public static /* bridge */ /* synthetic */ List<Double> asList(double[] r10) {
        return ArraysKt___ArraysJvmKt.asList(r10);
    }

    public static /* bridge */ /* synthetic */ List<Integer> asList(int[] r10) {
        return ArraysKt___ArraysJvmKt.asList(r10);
    }

    public static /* bridge */ /* synthetic */ List<Long> asList(long[] r10) {
        return ArraysKt___ArraysJvmKt.asList(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> asList(T[] r10) {
        return ArraysKt___ArraysJvmKt.asList(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Sequence<T> asSequence(T[] r10) {
        return ArraysKt___ArraysKt.asSequence(r10);
    }

    public static /* bridge */ /* synthetic */ boolean contains(byte[] r10, byte r11) {
        return ArraysKt___ArraysKt.contains(r10, r11);
    }

    public static /* bridge */ /* synthetic */ boolean contains(char[] r10, char r11) {
        return ArraysKt___ArraysKt.contains(r10, r11);
    }

    public static /* bridge */ /* synthetic */ boolean contains(int[] r10, int r11) {
        return ArraysKt___ArraysKt.contains(r10, r11);
    }

    public static /* bridge */ /* synthetic */ boolean contains(long[] r10, long r11) {
        return ArraysKt___ArraysKt.contains(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> boolean contains(T[] r10, T r11) {
        return ArraysKt___ArraysKt.contains(r10, r11);
    }

    public static /* bridge */ /* synthetic */ boolean contains(short[] r10, short r11) {
        return ArraysKt___ArraysKt.contains(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    public static /* bridge */ /* synthetic */ byte[] copyInto(byte[] r10, byte[] r11, int r12, int r13, int r14) {
        return ArraysKt___ArraysJvmKt.copyInto(r10, r11, r12, r13, r14);
    }

    @SinceKotlin(version = "1.3")
    public static /* bridge */ /* synthetic */ int[] copyInto(int[] r10, int[] r11, int r12, int r13, int r14) {
        return ArraysKt___ArraysJvmKt.copyInto(r10, r11, r12, r13, r14);
    }

    @SinceKotlin(version = "1.3")
    public static /* bridge */ /* synthetic */ long[] copyInto(long[] r10, long[] r11, int r12, int r13, int r14) {
        return ArraysKt___ArraysJvmKt.copyInto(r10, r11, r12, r13, r14);
    }

    @SinceKotlin(version = "1.3")
    public static /* bridge */ /* synthetic */ <T> T[] copyInto(T[] r10, T[] r11, int r12, int r13, int r14) {
        return (T[]) ArraysKt___ArraysJvmKt.copyInto(r10, r11, r12, r13, r14);
    }

    @SinceKotlin(version = "1.3")
    public static /* bridge */ /* synthetic */ short[] copyInto(short[] r10, short[] r11, int r12, int r13, int r14) {
        return ArraysKt___ArraysJvmKt.copyInto(r10, r11, r12, r13, r14);
    }

    public static /* bridge */ /* synthetic */ byte[] copyInto$default(byte[] r10, byte[] r11, int r12, int r13, int r14, int r15, Object r16) {
        return ArraysKt___ArraysJvmKt.copyInto$default(r10, r11, r12, r13, r14, r15, r16);
    }

    public static /* bridge */ /* synthetic */ Object[] copyInto$default(Object[] r10, Object[] r11, int r12, int r13, int r14, int r15, Object r16) {
        return ArraysKt___ArraysJvmKt.copyInto$default(r10, r11, r12, r13, r14, r15, r16);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static /* bridge */ /* synthetic */ byte[] copyOfRange(byte[] r10, int r11, int r12) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r10, r11, r12);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static /* bridge */ /* synthetic */ int[] copyOfRange(int[] r10, int r11, int r12) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r10, r11, r12);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static /* bridge */ /* synthetic */ long[] copyOfRange(long[] r10, int r11, int r12) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r10, r11, r12);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static /* bridge */ /* synthetic */ <T> T[] copyOfRange(T[] r10, int r11, int r12) {
        return (T[]) ArraysKt___ArraysJvmKt.copyOfRange(r10, r11, r12);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static /* bridge */ /* synthetic */ short[] copyOfRange(short[] r10, int r11, int r12) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ void fill(byte[] r10, byte r11, int r12, int r13) {
        ArraysKt___ArraysJvmKt.fill(r10, r11, r12, r13);
    }

    public static /* bridge */ /* synthetic */ void fill(int[] r10, int r11, int r12, int r13) {
        ArraysKt___ArraysJvmKt.fill(r10, r11, r12, r13);
    }

    public static /* bridge */ /* synthetic */ void fill(long[] r10, long r11, int r12, int r13) {
        ArraysKt___ArraysJvmKt.fill(r10, r11, r12, r13);
    }

    public static /* bridge */ /* synthetic */ <T> void fill(T[] r10, T r11, int r12, int r13) {
        ArraysKt___ArraysJvmKt.fill(r10, r11, r12, r13);
    }

    public static /* bridge */ /* synthetic */ void fill(short[] r10, short r11, int r12, int r13) {
        ArraysKt___ArraysJvmKt.fill(r10, r11, r12, r13);
    }

    public static /* bridge */ /* synthetic */ void fill$default(int[] r10, int r11, int r12, int r13, int r14, Object r15) {
        ArraysKt___ArraysJvmKt.fill$default(r10, r11, r12, r13, r14, r15);
    }

    public static /* bridge */ /* synthetic */ void fill$default(Object[] r10, Object r11, int r12, int r13, int r14, Object r15) {
        ArraysKt___ArraysJvmKt.fill$default(r10, r11, r12, r13, r14, r15);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> filterNotNull(T[] r10) {
        return ArraysKt___ArraysKt.filterNotNull(r10);
    }

    public static /* bridge */ /* synthetic */ byte first(byte[] r10) {
        return ArraysKt___ArraysKt.first(r10);
    }

    public static /* bridge */ /* synthetic */ int first(int[] r10) {
        return ArraysKt___ArraysKt.first(r10);
    }

    public static /* bridge */ /* synthetic */ long first(long[] r10) {
        return ArraysKt___ArraysKt.first(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T first(T[] r10) {
        return (T) ArraysKt___ArraysKt.first(r10);
    }

    public static /* bridge */ /* synthetic */ short first(short[] r10) {
        return ArraysKt___ArraysKt.first(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T firstOrNull(T[] r10) {
        return (T) ArraysKt___ArraysKt.firstOrNull(r10);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(byte[] r10) {
        return ArraysKt___ArraysKt.getIndices(r10);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(int[] r10) {
        return ArraysKt___ArraysKt.getIndices(r10);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(long[] r10) {
        return ArraysKt___ArraysKt.getIndices(r10);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(short[] r10) {
        return ArraysKt___ArraysKt.getIndices(r10);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(byte[] r10) {
        return ArraysKt___ArraysKt.getLastIndex(r10);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(int[] r10) {
        return ArraysKt___ArraysKt.getLastIndex(r10);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(long[] r10) {
        return ArraysKt___ArraysKt.getLastIndex(r10);
    }

    public static /* bridge */ /* synthetic */ <T> int getLastIndex(T[] r10) {
        return ArraysKt___ArraysKt.getLastIndex(r10);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(short[] r10) {
        return ArraysKt___ArraysKt.getLastIndex(r10);
    }

    public static /* bridge */ /* synthetic */ Integer getOrNull(int[] r10, int r11) {
        return ArraysKt___ArraysKt.getOrNull(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> T getOrNull(T[] r10, int r11) {
        return (T) ArraysKt___ArraysKt.getOrNull(r10, r11);
    }

    public static /* bridge */ /* synthetic */ int indexOf(byte[] r10, byte r11) {
        return ArraysKt___ArraysKt.indexOf(r10, r11);
    }

    public static /* bridge */ /* synthetic */ int indexOf(int[] r10, int r11) {
        return ArraysKt___ArraysKt.indexOf(r10, r11);
    }

    public static /* bridge */ /* synthetic */ int indexOf(long[] r10, long r11) {
        return ArraysKt___ArraysKt.indexOf(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> int indexOf(T[] r10, T r11) {
        return ArraysKt___ArraysKt.indexOf(r10, r11);
    }

    public static /* bridge */ /* synthetic */ int indexOf(short[] r10, short r11) {
        return ArraysKt___ArraysKt.indexOf(r10, r11);
    }

    public static /* bridge */ /* synthetic */ Appendable joinTo$default(Object[] r10, Appendable r11, CharSequence r12, CharSequence r13, CharSequence r14, int r15, CharSequence r16, Function1 r17, int r18, Object r19) {
        return ArraysKt___ArraysKt.joinTo$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(int[] r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1 r16, int r17, Object r18) {
        return ArraysKt___ArraysKt.joinToString$default(r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(Object[] r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1 r16, int r17, Object r18) {
        return ArraysKt___ArraysKt.joinToString$default(r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* bridge */ /* synthetic */ byte last(byte[] r10) {
        return ArraysKt___ArraysKt.last(r10);
    }

    public static /* bridge */ /* synthetic */ int last(int[] r10) {
        return ArraysKt___ArraysKt.last(r10);
    }

    public static /* bridge */ /* synthetic */ long last(long[] r10) {
        return ArraysKt___ArraysKt.last(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T last(T[] r10) {
        return (T) ArraysKt___ArraysKt.last(r10);
    }

    public static /* bridge */ /* synthetic */ short last(short[] r10) {
        return ArraysKt___ArraysKt.last(r10);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(byte[] r10, byte r11) {
        return ArraysKt___ArraysKt.lastIndexOf(r10, r11);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(int[] r10, int r11) {
        return ArraysKt___ArraysKt.lastIndexOf(r10, r11);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(long[] r10, long r11) {
        return ArraysKt___ArraysKt.lastIndexOf(r10, r11);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(short[] r10, short r11) {
        return ArraysKt___ArraysKt.lastIndexOf(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T, R> List<R> map(T[] r10, Function1<? super T, ? extends R> r11) {
        return ArraysKt___ArraysKt.map(r10, r11);
    }

    public static /* bridge */ /* synthetic */ byte[] plus(byte[] r10, byte r11) {
        return ArraysKt___ArraysJvmKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ byte[] plus(byte[] r10, byte[] r11) {
        return ArraysKt___ArraysJvmKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ int[] plus(int[] r10, int r11) {
        return ArraysKt___ArraysJvmKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ int[] plus(int[] r10, int[] r11) {
        return ArraysKt___ArraysJvmKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ long[] plus(long[] r10, long r11) {
        return ArraysKt___ArraysJvmKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ long[] plus(long[] r10, long[] r11) {
        return ArraysKt___ArraysJvmKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ short[] plus(short[] r10, short r11) {
        return ArraysKt___ArraysJvmKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ short[] plus(short[] r10, short[] r11) {
        return ArraysKt___ArraysJvmKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ void reverse(byte[] r10) {
        ArraysKt___ArraysKt.reverse(r10);
    }

    @SinceKotlin(version = "1.4")
    public static /* bridge */ /* synthetic */ void reverse(byte[] r10, int r11, int r12) {
        ArraysKt___ArraysKt.reverse(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ void reverse(int[] r10) {
        ArraysKt___ArraysKt.reverse(r10);
    }

    @SinceKotlin(version = "1.4")
    public static /* bridge */ /* synthetic */ void reverse(int[] r10, int r11, int r12) {
        ArraysKt___ArraysKt.reverse(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ void reverse(long[] r10) {
        ArraysKt___ArraysKt.reverse(r10);
    }

    @SinceKotlin(version = "1.4")
    public static /* bridge */ /* synthetic */ void reverse(long[] r10, int r11, int r12) {
        ArraysKt___ArraysKt.reverse(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ void reverse(short[] r10) {
        ArraysKt___ArraysKt.reverse(r10);
    }

    @SinceKotlin(version = "1.4")
    public static /* bridge */ /* synthetic */ void reverse(short[] r10, int r11, int r12) {
        ArraysKt___ArraysKt.reverse(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ byte[] reversedArray(byte[] r10) {
        return ArraysKt___ArraysKt.reversedArray(r10);
    }

    public static /* bridge */ /* synthetic */ int[] reversedArray(int[] r10) {
        return ArraysKt___ArraysKt.reversedArray(r10);
    }

    public static /* bridge */ /* synthetic */ long[] reversedArray(long[] r10) {
        return ArraysKt___ArraysKt.reversedArray(r10);
    }

    public static /* bridge */ /* synthetic */ short[] reversedArray(short[] r10) {
        return ArraysKt___ArraysKt.reversedArray(r10);
    }

    public static /* bridge */ /* synthetic */ byte single(byte[] r10) {
        return ArraysKt___ArraysKt.single(r10);
    }

    public static /* bridge */ /* synthetic */ char single(char[] r10) {
        return ArraysKt___ArraysKt.single(r10);
    }

    public static /* bridge */ /* synthetic */ int single(int[] r10) {
        return ArraysKt___ArraysKt.single(r10);
    }

    public static /* bridge */ /* synthetic */ long single(long[] r10) {
        return ArraysKt___ArraysKt.single(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T single(T[] r10) {
        return (T) ArraysKt___ArraysKt.single(r10);
    }

    public static /* bridge */ /* synthetic */ short single(short[] r10) {
        return ArraysKt___ArraysKt.single(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T singleOrNull(T[] r10) {
        return (T) ArraysKt___ArraysKt.singleOrNull(r10);
    }

    public static /* bridge */ /* synthetic */ byte[] sliceArray(byte[] r10, Collection<Integer> r11) {
        return ArraysKt___ArraysKt.sliceArray(r10, r11);
    }

    public static /* bridge */ /* synthetic */ byte[] sliceArray(byte[] r10, IntRange r11) {
        return ArraysKt___ArraysKt.sliceArray(r10, r11);
    }

    public static /* bridge */ /* synthetic */ int[] sliceArray(int[] r10, Collection<Integer> r11) {
        return ArraysKt___ArraysKt.sliceArray(r10, r11);
    }

    public static /* bridge */ /* synthetic */ int[] sliceArray(int[] r10, IntRange r11) {
        return ArraysKt___ArraysKt.sliceArray(r10, r11);
    }

    public static /* bridge */ /* synthetic */ long[] sliceArray(long[] r10, Collection<Integer> r11) {
        return ArraysKt___ArraysKt.sliceArray(r10, r11);
    }

    public static /* bridge */ /* synthetic */ long[] sliceArray(long[] r10, IntRange r11) {
        return ArraysKt___ArraysKt.sliceArray(r10, r11);
    }

    public static /* bridge */ /* synthetic */ short[] sliceArray(short[] r10, Collection<Integer> r11) {
        return ArraysKt___ArraysKt.sliceArray(r10, r11);
    }

    public static /* bridge */ /* synthetic */ short[] sliceArray(short[] r10, IntRange r11) {
        return ArraysKt___ArraysKt.sliceArray(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> T[] sortedArrayWith(T[] r10, Comparator<? super T> r11) {
        return (T[]) ArraysKt___ArraysKt.sortedArrayWith(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> sortedWith(T[] r10, Comparator<? super T> r11) {
        return ArraysKt___ArraysKt.sortedWith(r10, r11);
    }

    public static /* bridge */ /* synthetic */ int sum(int[] r10) {
        return ArraysKt___ArraysKt.sum(r10);
    }

    public static /* bridge */ /* synthetic */ long sum(long[] r10) {
        return ArraysKt___ArraysKt.sum(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> takeLast(T[] r10, int r11) {
        return ArraysKt___ArraysKt.takeLast(r10, r11);
    }

    public static /* bridge */ /* synthetic */ List<Byte> toList(byte[] r10) {
        return ArraysKt___ArraysKt.toList(r10);
    }

    public static /* bridge */ /* synthetic */ List<Character> toList(char[] r10) {
        return ArraysKt___ArraysKt.toList(r10);
    }

    public static /* bridge */ /* synthetic */ List<Double> toList(double[] r10) {
        return ArraysKt___ArraysKt.toList(r10);
    }

    public static /* bridge */ /* synthetic */ List<Float> toList(float[] r10) {
        return ArraysKt___ArraysKt.toList(r10);
    }

    public static /* bridge */ /* synthetic */ List<Integer> toList(int[] r10) {
        return ArraysKt___ArraysKt.toList(r10);
    }

    public static /* bridge */ /* synthetic */ List<Long> toList(long[] r10) {
        return ArraysKt___ArraysKt.toList(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> toList(T[] r10) {
        return ArraysKt___ArraysKt.toList(r10);
    }

    public static /* bridge */ /* synthetic */ List<Short> toList(short[] r10) {
        return ArraysKt___ArraysKt.toList(r10);
    }

    public static /* bridge */ /* synthetic */ List<Boolean> toList(boolean[] r10) {
        return ArraysKt___ArraysKt.toList(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> toMutableList(T[] r10) {
        return ArraysKt___ArraysKt.toMutableList(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Set<T> toSet(T[] r10) {
        return ArraysKt___ArraysKt.toSet(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Iterable<IndexedValue<T>> withIndex(T[] r10) {
        return ArraysKt___ArraysKt.withIndex(r10);
    }

    public static /* bridge */ /* synthetic */ <T, R> List<Pair<T, R>> zip(T[] r10, R[] r11) {
        return ArraysKt___ArraysKt.zip(r10, r11);
    }
}
