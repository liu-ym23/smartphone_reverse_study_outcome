package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u001a-\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000\u001a9\u0010\u000b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u0010\u001a9\u0010\u000b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00112\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u0010\u001a(\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0014\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0015\u001a.\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n¢\u0006\u0002\u0010\u0016\u001a)\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0087\n\u001a)\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\n\u001a(\u0010\u0017\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0014\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0015\u001a.\u0010\u0017\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n¢\u0006\u0002\u0010\u0016\u001a)\u0010\u0017\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0087\n\u001a)\u0010\u0017\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\n\u001a-\u0010\u0018\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0019*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0014\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u001a\u001a&\u0010\u0018\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0087\b¢\u0006\u0002\u0010\u001d\u001a-\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010\u001e\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0019*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\nH\u0087\b\u001a*\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e\u001a*\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00112\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e\u001a\u001d\u0010\u001f\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001a\u001f\u0010!\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001a\u001d\u0010\"\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001a\u001f\u0010#\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001a-\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010$\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0019*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\nH\u0087\b\u001a*\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e\u001a*\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00112\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e\u001a\u0015\u0010%\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0002\b&¨\u0006'"}, d2 = {"addAll", "", ExifInterface.GPS_DIRECTION_TRUE, "", "elements", "", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "convertToListIfNotCollection", "", "filterInPlace", "", "predicate", "Lkotlin/Function1;", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "", "minusAssign", "", "element", "(Ljava/util/Collection;Ljava/lang/Object;)V", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "plusAssign", "remove", "Lkotlin/internal/OnlyInputTypes;", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "index", "", "(Ljava/util/List;I)Ljava/lang/Object;", "removeAll", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    public CollectionsKt__MutableCollectionsKt() {
    }

    public static <T> boolean addAll(Collection<? super T> r5, Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        if ((r10 instanceof Collection) == true) goto L5;
        Iterator<? extends T> r11 = r10.iterator();
        boolean r12 = false;
    L8:
        if (r11.hasNext() == false) goto L12;
        if (r5.add(r11.next()) == false) goto L8;
        r12 = true;
        goto L8
    L12:
        return r12;
    L5:
        return r5.addAll((Collection) r10);
    }

    public static <T> Collection<T> convertToListIfNotCollection(Iterable<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof Collection) == false) goto L6;
        return (Collection) r5;
    L6:
        return CollectionsKt___CollectionsKt.toList(r5);
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(Iterable<? extends T> r5, Function1<? super T, Boolean> r10, boolean r11) {
        Iterator<? extends T> r12 = r5.iterator();
        boolean r13 = false;
    L4:
        if (r12.hasNext() == false) goto L8;
        if (r10.invoke(r12.next()).booleanValue() != r11) goto L4;
        r12.remove();
        r13 = true;
        goto L4
    L8:
        return r13;
    }

    @InlineOnly
    private static final <T> void minusAssign(Collection<? super T> r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.remove(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> void plusAssign(Collection<? super T> r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.add(r10);
    }

    @InlineOnly
    private static final <T> boolean remove(Collection<? extends T> r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return TypeIntrinsics.asMutableCollection(r5).remove(r10);
    }

    @InlineOnly
    private static final <T> boolean removeAll(Collection<? extends T> r5, Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        return TypeIntrinsics.asMutableCollection(r5).removeAll(r10);
    }

    @SinceKotlin(version = "1.4")
    public static <T> T removeFirst(List<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == true) goto L7;
        return r5.remove(0);
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    @SinceKotlin(version = "1.4")
    public static final <T> T removeFirstOrNull(List<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == false) goto L6;
        return null;
    L6:
        return r5.remove(0);
    }

    @SinceKotlin(version = "1.4")
    public static <T> T removeLast(List<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == true) goto L7;
        return r5.remove(CollectionsKt__CollectionsKt.getLastIndex(r5));
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    @SinceKotlin(version = "1.4")
    public static final <T> T removeLastOrNull(List<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == false) goto L6;
        return null;
    L6:
        return r5.remove(CollectionsKt__CollectionsKt.getLastIndex(r5));
    }

    @InlineOnly
    private static final <T> boolean retainAll(Collection<? extends T> r5, Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        return TypeIntrinsics.asMutableCollection(r5).retainAll(r10);
    }

    private static final boolean retainNothing$CollectionsKt__MutableCollectionsKt(Collection<?> r5) {
        boolean r10 = !r5.isEmpty();
        r5.clear();
        return r10;
    }

    @InlineOnly
    private static final <T> void minusAssign(Collection<? super T> r5, Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        removeAll(r5, r10);
    }

    @InlineOnly
    private static final <T> void plusAssign(Collection<? super T> r5, Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        addAll(r5, r10);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use removeAt(index) instead.", replaceWith = @ReplaceWith(expression = "removeAt(index)", imports = {}))
    @InlineOnly
    private static final <T> T remove(List<T> r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.remove(r10);
    }

    public static <T> boolean removeAll(Collection<? super T> r5, Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        return r5.removeAll(convertToListIfNotCollection(r10));
    }

    public static <T> boolean retainAll(Collection<? super T> r5, Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        return r5.retainAll(convertToListIfNotCollection(r10));
    }

    @InlineOnly
    private static final <T> void minusAssign(Collection<? super T> r5, T[] r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        removeAll(r5, r10);
    }

    @InlineOnly
    private static final <T> void plusAssign(Collection<? super T> r5, T[] r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        addAll(r5, r10);
    }

    public static <T> boolean removeAll(Collection<? super T> r5, Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        List r11 = SequencesKt.toList(r10);
        if (r11.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (r5.removeAll(r11) == false) goto L7;
        return true;
    }

    public static final <T> boolean retainAll(Collection<? super T> r5, T[] r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        if (r10.length != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L10;
        return r5.retainAll(ArraysKt___ArraysJvmKt.asList(r10));
    L10:
        return retainNothing$CollectionsKt__MutableCollectionsKt(r5);
    L5:
        r11 = false;
        goto L6
    }

    public static <T> boolean addAll(Collection<? super T> r5, Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        Iterator<? extends T> r11 = r10.iterator();
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L8;
        if (r5.add(r11.next()) == false) goto L4;
        r12 = true;
        goto L4
    L8:
        return r12;
    }

    @InlineOnly
    private static final <T> void minusAssign(Collection<? super T> r5, Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        removeAll(r5, r10);
    }

    @InlineOnly
    private static final <T> void plusAssign(Collection<? super T> r5, Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        addAll(r5, r10);
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(List<T> r10, Function1<? super T, Boolean> r11, boolean r12) {
        if ((r10 instanceof RandomAccess) == true) goto L6;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(TypeIntrinsics.asMutableIterable(r10), r11, r12);
    L6:
        int r5 = CollectionsKt__CollectionsKt.getLastIndex(r10);
        if (r5 < 0) goto L17;
        int r13 = 0;
        int r14 = 0;
    L9:
        T r15 = r10.get(r13);
        if (r11.invoke(r15).booleanValue() == r12) goto L15;
        if (r14 == r13) goto L14;
        r10.set(r14, r15);
    L14:
        r14 = r14 + 1;
    L15:
        if (r13 == r5) goto L19;
        r13 = r13 + 1;
    L19:
        if (r14 >= r10.size()) goto L27;
        int r16 = CollectionsKt__CollectionsKt.getLastIndex(r10);
        if (r14 > r16) goto L25;
    L22:
        r10.remove(r16);
        if (r16 == r14) goto L30;
        r16 = r16 - 1;
        goto L22
    L30:
        return true;
    L25:
        return true;
    L27:
        return false;
    L17:
        r14 = 0;
        goto L19
    }

    public static <T> boolean removeAll(Collection<? super T> r5, T[] r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        if (r10.length != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        return false;
    L8:
        if (r5.removeAll(ArraysKt___ArraysJvmKt.asList(r10)) == true) goto L10;
        return false;
    L10:
        return true;
    L5:
        r11 = false;
        goto L6
    }

    public static <T> boolean addAll(Collection<? super T> r5, T[] r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        return r5.addAll(ArraysKt___ArraysJvmKt.asList(r10));
    }

    public static <T> boolean removeAll(Iterable<? extends T> r5, Function1<? super T, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(r5, r10, true);
    }

    public static final <T> boolean retainAll(Collection<? super T> r5, Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        List r11 = SequencesKt.toList(r10);
        if (r11.isEmpty() == true) goto L7;
        return r5.retainAll(r11);
    L7:
        return retainNothing$CollectionsKt__MutableCollectionsKt(r5);
    }

    public static <T> boolean removeAll(List<T> r5, Function1<? super T, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(r5, r10, true);
    }

    public static <T> boolean retainAll(Iterable<? extends T> r5, Function1<? super T, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(r5, r10, false);
    }

    public static final <T> boolean retainAll(List<T> r5, Function1<? super T, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(r5, r10, false);
    }
}
