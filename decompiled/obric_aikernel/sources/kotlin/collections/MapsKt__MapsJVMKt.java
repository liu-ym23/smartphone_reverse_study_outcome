package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.collections.builders.MapBuilder;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nMapsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,157:1\n1#2:158\n*E\n"})
class MapsKt__MapsJVMKt extends MapsKt__MapWithDefaultKt {
    private static final int INT_MAX_POWER_OF_TWO = 1073741824;

    public MapsKt__MapsJVMKt() {
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static <K, V> Map<K, V> build(Map<K, V> r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        return ((MapBuilder) r10).build();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <K, V> Map<K, V> buildMapInternal(int r10, Function1<? super Map<K, V>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        Map r12 = MapsKt.createMapBuilder(r10);
        r11.invoke(r12);
        return MapsKt.build(r12);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <K, V> Map<K, V> buildMapInternal(Function1<? super Map<K, V>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "builderAction");
        Map r11 = MapsKt.createMapBuilder();
        r10.invoke(r11);
        return MapsKt.build(r11);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static <K, V> Map<K, V> createMapBuilder() {
        return new MapBuilder();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static <K, V> Map<K, V> createMapBuilder(int r10) {
        return new MapBuilder(r10);
    }

    public static final <K, V> V getOrPut(ConcurrentMap<K, V> r10, K r11, Function0<? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        V r13 = r10.get(r11);
        if (r13 != null) goto L9;
        V r14 = r12.invoke();
        V r15 = r10.putIfAbsent(r11, r14);
        if (r15 != null) goto L8;
        return r14;
    L8:
        return r15;
    L9:
        return r13;
    }

    @PublishedApi
    public static int mapCapacity(int r10) {
        if (r10 >= 0) goto L5;
        return r10;
    L5:
        if (r10 >= 3) goto L8;
        return r10 + 1;
    L8:
        if (r10 < 1073741824) goto L13;
        return Integer.MAX_VALUE;
    L13:
        return (int) ((r10 / 0.75f) + 1.0f);
    }

    public static <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "pair");
        Map<K, V> r11 = Collections.singletonMap(r10.getFirst(), r10.getSecond());
        Intrinsics.checkNotNullExpressionValue(r11, "singletonMap(pair.first, pair.second)");
        return r11;
    }

    @SinceKotlin(version = "1.4")
    public static final <K, V> SortedMap<K, V> sortedMapOf(Comparator<? super K> r10, Pair<? extends K, ? extends V>... r11) {
        Intrinsics.checkNotNullParameter(r10, "comparator");
        Intrinsics.checkNotNullParameter(r11, "pairs");
        TreeMap r12 = new TreeMap(r10);
        MapsKt__MapsKt.putAll(r12, r11);
        return r12;
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> sortedMapOf(Pair<? extends K, ? extends V>... r10) {
        Intrinsics.checkNotNullParameter(r10, "pairs");
        TreeMap r11 = new TreeMap();
        MapsKt__MapsKt.putAll(r11, r10);
        return r11;
    }

    @InlineOnly
    private static final Properties toProperties(Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Properties r11 = new Properties();
        r11.putAll(r10);
        return r11;
    }

    public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Map.Entry<? extends K, ? extends V> r11 = r10.entrySet().iterator().next();
        Map<K, V> r12 = Collections.singletonMap(r11.getKey(), r11.getValue());
        Intrinsics.checkNotNullExpressionValue(r12, "with(entries.iterator().…ingletonMap(key, value) }");
        return r12;
    }

    @InlineOnly
    private static final <K, V> Map<K, V> toSingletonMapOrSelf(Map<K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return toSingletonMap(r10);
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new TreeMap(r10);
    }

    public static <K, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> r10, Comparator<? super K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        TreeMap r12 = new TreeMap(r11);
        r12.putAll(r10);
        return r12;
    }
}
