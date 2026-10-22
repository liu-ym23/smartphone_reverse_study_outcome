package kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    public SetsKt__SetsKt() {
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <E> Set<E> buildSet(int r10, @BuilderInference Function1<? super Set<E>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        Set r12 = SetsKt.createSetBuilder(r10);
        r11.invoke(r12);
        return SetsKt.build(r12);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <E> Set<E> buildSet(@BuilderInference Function1<? super Set<E>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "builderAction");
        Set r11 = SetsKt.createSetBuilder();
        r10.invoke(r11);
        return SetsKt.build(r11);
    }

    public static <T> Set<T> emptySet() {
        return EmptySet.INSTANCE;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> HashSet<T> hashSetOf() {
        return new HashSet();
    }

    public static <T> HashSet<T> hashSetOf(T... r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        return (HashSet) ArraysKt___ArraysKt.toCollection(r10, new HashSet(MapsKt.mapCapacity(r10.length)));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> LinkedHashSet<T> linkedSetOf() {
        return new LinkedHashSet();
    }

    public static <T> LinkedHashSet<T> linkedSetOf(T... r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        return (LinkedHashSet) ArraysKt___ArraysKt.toCollection(r10, new LinkedHashSet(MapsKt.mapCapacity(r10.length)));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> Set<T> mutableSetOf() {
        return new LinkedHashSet();
    }

    public static <T> Set<T> mutableSetOf(T... r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        return (Set) ArraysKt___ArraysKt.toCollection(r10, new LinkedHashSet(MapsKt.mapCapacity(r10.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> optimizeReadOnlySet(Set<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.size();
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L10;
        return r10;
    L10:
        return SetsKt.setOf(r10.iterator().next());
    L9:
        return SetsKt.emptySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> Set<T> orEmpty(Set<? extends T> r10) {
        if (r10 == 0) goto L4;
        return r10;
    L4:
        return SetsKt.emptySet();
    }

    @InlineOnly
    private static final <T> Set<T> setOf() {
        return SetsKt.emptySet();
    }

    public static <T> Set<T> setOf(T... r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        if (r10.length <= 0) goto L6;
        return ArraysKt.toSet(r10);
    L6:
        return SetsKt.emptySet();
    }

    @SinceKotlin(version = "1.4")
    public static final <T> Set<T> setOfNotNull(T r10) {
        if (r10 == null) goto L5;
        return SetsKt.setOf(r10);
    L5:
        return SetsKt.emptySet();
    }

    @SinceKotlin(version = "1.4")
    public static final <T> Set<T> setOfNotNull(T... r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        return (Set) ArraysKt___ArraysKt.filterNotNullTo(r10, new LinkedHashSet());
    }
}
