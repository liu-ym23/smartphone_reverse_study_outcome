package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.collections.builders.SetBuilder;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class SetsKt__SetsJVMKt {
    public SetsKt__SetsJVMKt() {
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static <E> Set<E> build(Set<E> r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        return ((SetBuilder) r10).build();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> Set<E> buildSetInternal(int r10, Function1<? super Set<E>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        Set r12 = SetsKt.createSetBuilder(r10);
        r11.invoke(r12);
        return SetsKt.build(r12);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> Set<E> buildSetInternal(Function1<? super Set<E>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "builderAction");
        Set r11 = SetsKt.createSetBuilder();
        r10.invoke(r11);
        return SetsKt.build(r11);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static <E> Set<E> createSetBuilder() {
        return new SetBuilder();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static <E> Set<E> createSetBuilder(int r10) {
        return new SetBuilder(r10);
    }

    public static <T> Set<T> setOf(T r10) {
        Set<T> r11 = Collections.singleton(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "singleton(element)");
        return r11;
    }

    public static final <T> TreeSet<T> sortedSetOf(Comparator<? super T> r10, T... r11) {
        Intrinsics.checkNotNullParameter(r10, "comparator");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return (TreeSet) ArraysKt___ArraysKt.toCollection(r11, new TreeSet(r10));
    }

    public static final <T> TreeSet<T> sortedSetOf(T... r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        return (TreeSet) ArraysKt___ArraysKt.toCollection(r10, new TreeSet());
    }
}
