package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
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

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nCollectionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionsJVM.kt\nkotlin/collections/CollectionsKt__CollectionsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,122:1\n1#2:123\n*E\n"})
class CollectionsKt__CollectionsJVMKt {
    public CollectionsKt__CollectionsJVMKt() {
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static <E> List<E> build(List<E> r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        return ((ListBuilder) r10).build();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> List<E> buildListInternal(int r10, Function1<? super List<E>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        List r12 = CollectionsKt.createListBuilder(r10);
        r11.invoke(r12);
        return CollectionsKt.build(r12);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> List<E> buildListInternal(Function1<? super List<E>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "builderAction");
        List r11 = CollectionsKt.createListBuilder();
        r10.invoke(r11);
        return CollectionsKt.build(r11);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final int checkCountOverflow(int r10) {
        if (r10 < 0) goto L4;
    L8:
        return r10;
    L4:
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L7;
        CollectionsKt.throwCountOverflow();
        goto L8
    L7:
        throw new ArithmeticException("Count overflow has happened.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final int checkIndexOverflow(int r10) {
        if (r10 < 0) goto L4;
    L8:
        return r10;
    L4:
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L7;
        CollectionsKt.throwIndexOverflow();
        goto L8
    L7:
        throw new ArithmeticException("Index overflow has happened.");
    }

    @InlineOnly
    private static final Object[] copyToArrayImpl(Collection<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "collection");
        return CollectionToArray.toArray(r10);
    }

    @InlineOnly
    private static final <T> T[] copyToArrayImpl(Collection<?> r10, T[] r11) {
        Intrinsics.checkNotNullParameter(r10, "collection");
        Intrinsics.checkNotNullParameter(r11, "array");
        return (T[]) CollectionToArray.toArray(r10, r11);
    }

    public static final <T> Object[] copyToArrayOfAny(T[] r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 == true) goto L5;
    L7:
        Object[] r12 = Arrays.copyOf(r10, r10.length, Object[].class);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, this.size, Array<Any?>::class.java)");
        return r12;
    L5:
        if (Intrinsics.areEqual(r10.getClass(), Object[].class) == false) goto L7;
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static <E> List<E> createListBuilder() {
        return new ListBuilder();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static <E> List<E> createListBuilder(int r10) {
        return new ListBuilder(r10);
    }

    public static <T> List<T> listOf(T r10) {
        List<T> r11 = Collections.singletonList(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "singletonList(element)");
        return r11;
    }

    @SinceKotlin(version = "1.2")
    public static final <T> List<T> shuffled(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        List<T> r11 = CollectionsKt___CollectionsKt.toMutableList(r10);
        Collections.shuffle(r11);
        return r11;
    }

    @SinceKotlin(version = "1.2")
    public static final <T> List<T> shuffled(Iterable<? extends T> r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        List<T> r12 = CollectionsKt___CollectionsKt.toMutableList(r10);
        Collections.shuffle(r12, r11);
        return r12;
    }

    @InlineOnly
    private static final <T> List<T> toList(Enumeration<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArrayList r11 = Collections.list(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "list(this)");
        return r11;
    }
}
