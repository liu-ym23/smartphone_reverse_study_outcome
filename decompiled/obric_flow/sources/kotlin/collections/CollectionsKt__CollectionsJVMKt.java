package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.collections.builders.ListBuilder;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u001d\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0081\bø\u0001\u0000\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001d\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0081\bø\u0001\u0000\u001a\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0081\b\u001a\u0011\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0081\b\u001a\"\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0081\b¢\u0006\u0002\u0010\u0015\u001a4\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0011\"\u0004\b\u0000\u0010\u00162\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0011H\u0081\b¢\u0006\u0002\u0010\u0018\u001a\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u0002H\u0001\u001a\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u001b\u001a\u0002H\u0016¢\u0006\u0002\u0010\u001c\u001a/\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0011\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u001e\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0011H\u0000¢\u0006\u0002\u0010\u001f\u001a1\u0010 \u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u0011\"\u0004\b\u0000\u0010\u0016*\n\u0012\u0006\b\u0001\u0012\u0002H\u00160\u00112\u0006\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\u0010#\u001a\u001e\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160%H\u0007\u001a&\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160%2\u0006\u0010&\u001a\u00020'H\u0007\u001a\u001f\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160)H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*"}, d2 = {"build", "", ExifInterface.LONGITUDE_EAST, "builder", "", "buildListInternal", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "checkCountOverflow", "count", "checkIndexOverflow", "index", "collectionToArray", "", "", "collection", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "createListBuilder", "listOf", "element", "(Ljava/lang/Object;)Ljava/util/List;", "terminateCollectionToArray", "collectionSize", "(I[Ljava/lang/Object;)[Ljava/lang/Object;", "copyToArrayOfAny", "isVarargs", "", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "shuffled", "", "random", "Ljava/util/Random;", "toList", "Ljava/util/Enumeration;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
@SourceDebugExtension({"SMAP\nCollectionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionsJVM.kt\nkotlin/collections/CollectionsKt__CollectionsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,131:1\n1#2:132\n*E\n"})
class CollectionsKt__CollectionsJVMKt {
    public CollectionsKt__CollectionsJVMKt() {
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static <E> List<E> build(List<E> r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        return ((ListBuilder) r5).build();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> List<E> buildListInternal(Function1<? super List<E>, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "builderAction");
        List r10 = createListBuilder();
        r5.invoke(r10);
        return build(r10);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final int checkCountOverflow(int r5) {
        if (r5 < 0) goto L4;
    L8:
        return r5;
    L4:
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L7;
        CollectionsKt__CollectionsKt.throwCountOverflow();
        goto L8
    L7:
        throw new ArithmeticException("Count overflow has happened.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final int checkIndexOverflow(int r5) {
        if (r5 < 0) goto L4;
    L8:
        return r5;
    L4:
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L7;
        CollectionsKt__CollectionsKt.throwIndexOverflow();
        goto L8
    L7:
        throw new ArithmeticException("Index overflow has happened.");
    }

    @InlineOnly
    private static final Object[] collectionToArray(Collection<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "collection");
        return CollectionToArray.toArray(r5);
    }

    public static final <T> Object[] copyToArrayOfAny(T[] r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 == false) goto L8;
        if (Intrinsics.areEqual(r5.getClass(), Object[].class) == false) goto L8;
        return r5;
    L8:
        return Arrays.copyOf(r5, r5.length, Object[].class);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static <E> List<E> createListBuilder() {
        int r5 = 0;
        return new ListBuilder(r5, 1, null);
    }

    public static <T> List<T> listOf(T r5) {
        return Collections.singletonList(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final <T> List<T> shuffled(Iterable<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        List<T> r10 = CollectionsKt___CollectionsKt.toMutableList(r5);
        Collections.shuffle(r10);
        return r10;
    }

    public static <T> T[] terminateCollectionToArray(int r5, T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        if (r5 >= r10.length) goto L5;
        r10[r5] = null;
    L5:
        return r10;
    }

    @InlineOnly
    private static final <T> List<T> toList(Enumeration<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Collections.list(r5);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> List<E> buildListInternal(int r5, Function1<? super List<E>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "builderAction");
        List r11 = createListBuilder(r5);
        r10.invoke(r11);
        return build(r11);
    }

    @InlineOnly
    private static final <T> T[] collectionToArray(Collection<?> r5, T[] r10) {
        Intrinsics.checkNotNullParameter(r5, "collection");
        Intrinsics.checkNotNullParameter(r10, "array");
        return (T[]) CollectionToArray.toArray(r5, r10);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static <E> List<E> createListBuilder(int r5) {
        return new ListBuilder(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final <T> List<T> shuffled(Iterable<? extends T> r5, Random r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "random");
        List<T> r11 = CollectionsKt___CollectionsKt.toMutableList(r5);
        Collections.shuffle(r11, r10);
        return r11;
    }
}
