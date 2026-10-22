package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nMaps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,804:1\n403#1:814\n414#1:819\n511#1,6:824\n536#1,6:830\n1#2:805\n1238#3,4:806\n1238#3,4:810\n1238#3,4:815\n1238#3,4:820\n*S KotlinDebug\n*F\n+ 1 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n453#1:814\n468#1:819\n526#1:824,6\n551#1:830,6\n403#1:806,4\n414#1:810,4\n453#1:815,4\n468#1:820,4\n*E\n"})
class MapsKt__MapsKt extends MapsKt__MapsJVMKt {
    public MapsKt__MapsKt() {
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <K, V> Map<K, V> buildMap(int r10, @BuilderInference Function1<? super Map<K, V>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        Map r12 = MapsKt.createMapBuilder(r10);
        r11.invoke(r12);
        return MapsKt.build(r12);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <K, V> Map<K, V> buildMap(@BuilderInference Function1<? super Map<K, V>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "builderAction");
        Map r11 = MapsKt.createMapBuilder();
        r10.invoke(r11);
        return MapsKt.build(r11);
    }

    @InlineOnly
    private static final <K, V> K component1(Map.Entry<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getKey();
    }

    @InlineOnly
    private static final <K, V> V component2(Map.Entry<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getValue();
    }

    @InlineOnly
    private static final <K, V> boolean contains(Map<? extends K, ? extends V> r10, K r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.containsKey(r11);
    }

    @InlineOnly
    private static final <K> boolean containsKey(Map<? extends K, ?> r10, K r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.containsKey(r11);
    }

    @InlineOnly
    private static final <K, V> boolean containsValue(Map<K, ? extends V> r10, V r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.containsValue(r11);
    }

    public static <K, V> Map<K, V> emptyMap() {
        EmptyMap r10 = EmptyMap.INSTANCE;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return r10;
    }

    public static final <K, V> Map<K, V> filter(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<Map.Entry<? extends K, ? extends V>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Map.Entry<? extends K, ? extends V> r14 = r13.next();
        if (r11.invoke(r14).booleanValue() == false) goto L4;
        r12.put(r14.getKey(), r14.getValue());
        goto L4
    L8:
        return r12;
    }

    public static final <K, V> Map<K, V> filterKeys(Map<? extends K, ? extends V> r10, Function1<? super K, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<Map.Entry<? extends K, ? extends V>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Map.Entry<? extends K, ? extends V> r14 = r13.next();
        if (r11.invoke(r14.getKey()).booleanValue() == false) goto L4;
        r12.put(r14.getKey(), r14.getValue());
        goto L4
    L8:
        return r12;
    }

    public static final <K, V> Map<K, V> filterNot(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<Map.Entry<? extends K, ? extends V>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Map.Entry<? extends K, ? extends V> r14 = r13.next();
        if (r11.invoke(r14).booleanValue() == true) goto L4;
        r12.put(r14.getKey(), r14.getValue());
        goto L4
    L8:
        return r12;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M filterNotTo(Map<? extends K, ? extends V> r10, M r11, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        Iterator<Map.Entry<? extends K, ? extends V>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Map.Entry<? extends K, ? extends V> r14 = r13.next();
        if (r12.invoke(r14).booleanValue() == true) goto L4;
        r11.put(r14.getKey(), r14.getValue());
        goto L4
    L8:
        return r11;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M filterTo(Map<? extends K, ? extends V> r10, M r11, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        Iterator<Map.Entry<? extends K, ? extends V>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Map.Entry<? extends K, ? extends V> r14 = r13.next();
        if (r12.invoke(r14).booleanValue() == false) goto L4;
        r11.put(r14.getKey(), r14.getValue());
        goto L4
    L8:
        return r11;
    }

    public static final <K, V> Map<K, V> filterValues(Map<? extends K, ? extends V> r10, Function1<? super V, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<Map.Entry<? extends K, ? extends V>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Map.Entry<? extends K, ? extends V> r14 = r13.next();
        if (r11.invoke(r14.getValue()).booleanValue() == false) goto L4;
        r12.put(r14.getKey(), r14.getValue());
        goto L4
    L8:
        return r12;
    }

    @InlineOnly
    private static final <K, V> V get(Map<? extends K, ? extends V> r10, K r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.get(r11);
    }

    @InlineOnly
    private static final <K, V> V getOrElse(Map<K, ? extends V> r10, K r11, Function0<? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        V r13 = r10.get(r11);
        if (r13 == null) goto L5;
        return r13;
    L5:
        return r12.invoke();
    }

    public static final <K, V> V getOrElseNullable(Map<K, ? extends V> r10, K r11, Function0<? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        V r13 = r10.get(r11);
        if (r13 == null) goto L5;
    L8:
        return r13;
    L5:
        if (r10.containsKey(r11) == true) goto L8;
        return r12.invoke();
    }

    public static final <K, V> V getOrPut(Map<K, V> r10, K r11, Function0<? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        V r13 = r10.get(r11);
        if (r13 != null) goto L6;
        V r14 = r12.invoke();
        r10.put(r11, r14);
        return r14;
    L6:
        return r13;
    }

    @SinceKotlin(version = "1.1")
    public static <K, V> V getValue(Map<K, ? extends V> r10, K r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (V) MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> HashMap<K, V> hashMapOf() {
        return new HashMap();
    }

    public static <K, V> HashMap<K, V> hashMapOf(Pair<? extends K, ? extends V>... r10) {
        Intrinsics.checkNotNullParameter(r10, "pairs");
        HashMap<K, V> r11 = new HashMap(MapsKt.mapCapacity(r10.length));
        putAll(r11, r10);
        return r11;
    }

    /* JADX WARN: Incorrect types in method signature: <M::Ljava/util/Map<**>;:TR;R:Ljava/lang/Object;>(TM;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final Object ifEmpty(Map r10, Function0 r11) {
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        if (r10.isEmpty() == true) goto L5;
        return r10;
    L5:
        return r11.invoke();
    }

    @InlineOnly
    private static final <K, V> boolean isNotEmpty(Map<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return !r10.isEmpty();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <K, V> boolean isNullOrEmpty(Map<? extends K, ? extends V> r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.isEmpty() == true) goto L7;
        return false;
    }

    @InlineOnly
    private static final <K, V> Iterator<Map.Entry<K, V>> iterator(Map<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.entrySet().iterator();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> LinkedHashMap<K, V> linkedMapOf() {
        return new LinkedHashMap();
    }

    public static <K, V> LinkedHashMap<K, V> linkedMapOf(Pair<? extends K, ? extends V>... r10) {
        Intrinsics.checkNotNullParameter(r10, "pairs");
        return (LinkedHashMap) toMap(r10, new LinkedHashMap(MapsKt.mapCapacity(r10.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R> Map<R, V> mapKeys(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        LinkedHashMap r12 = new LinkedHashMap(MapsKt.mapCapacity(r10.size()));
        Iterator<T> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry r14 = (Object) r13.next();
        r12.put(r11.invoke(r14), r14.getValue());
        goto L4
    L6:
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R, M extends Map<? super R, ? super V>> M mapKeysTo(Map<? extends K, ? extends V> r10, M r11, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<T> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry r14 = (Object) r13.next();
        r11.put(r12.invoke(r14), r14.getValue());
        goto L4
    L6:
        return r11;
    }

    @InlineOnly
    private static final <K, V> Map<K, V> mapOf() {
        return MapsKt.emptyMap();
    }

    public static <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V>... r10) {
        Intrinsics.checkNotNullParameter(r10, "pairs");
        if (r10.length <= 0) goto L6;
        return toMap(r10, new LinkedHashMap(MapsKt.mapCapacity(r10.length)));
    L6:
        return MapsKt.emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R> Map<K, R> mapValues(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        LinkedHashMap r12 = new LinkedHashMap(MapsKt.mapCapacity(r10.size()));
        Iterator<T> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry r14 = (Object) r13.next();
        r12.put(r14.getKey(), r11.invoke(r14));
        goto L4
    L6:
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R, M extends Map<? super K, ? super R>> M mapValuesTo(Map<? extends K, ? extends V> r10, M r11, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<T> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry r14 = (Object) r13.next();
        r11.put(r14.getKey(), r12.invoke(r14));
        goto L4
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> r10, Iterable<? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keys");
        Map r12 = MapsKt.toMutableMap(r10);
        CollectionsKt__MutableCollectionsKt.removeAll(r12.keySet(), r11);
        return optimizeReadOnlyMap(r12);
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> r10, K r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Map r12 = MapsKt.toMutableMap(r10);
        r12.remove(r11);
        return optimizeReadOnlyMap(r12);
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> r10, Sequence<? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keys");
        Map r12 = MapsKt.toMutableMap(r10);
        CollectionsKt__MutableCollectionsKt.removeAll(r12.keySet(), r11);
        return optimizeReadOnlyMap(r12);
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> r10, K[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keys");
        Map r12 = MapsKt.toMutableMap(r10);
        CollectionsKt__MutableCollectionsKt.removeAll(r12.keySet(), r11);
        return optimizeReadOnlyMap(r12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(Map<K, V> r10, Iterable<? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keys");
        CollectionsKt__MutableCollectionsKt.removeAll(r10.keySet(), r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(Map<K, V> r10, K r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.remove(r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(Map<K, V> r10, Sequence<? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keys");
        CollectionsKt__MutableCollectionsKt.removeAll(r10.keySet(), r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(Map<K, V> r10, K[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keys");
        CollectionsKt__MutableCollectionsKt.removeAll(r10.keySet(), r11);
    }

    @InlineOnly
    @JvmName(name = "mutableIterator")
    private static final <K, V> Iterator<Map.Entry<K, V>> mutableIterator(Map<K, V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.entrySet().iterator();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> Map<K, V> mutableMapOf() {
        return new LinkedHashMap();
    }

    public static <K, V> Map<K, V> mutableMapOf(Pair<? extends K, ? extends V>... r10) {
        Intrinsics.checkNotNullParameter(r10, "pairs");
        LinkedHashMap r11 = new LinkedHashMap(MapsKt.mapCapacity(r10.length));
        putAll(r11, r10);
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> optimizeReadOnlyMap(Map<K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.size();
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L10;
        return r10;
    L10:
        return MapsKt__MapsJVMKt.toSingletonMap(r10);
    L9:
        return MapsKt.emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <K, V> Map<K, V> orEmpty(Map<K, ? extends V> r10) {
        if (r10 == 0) goto L4;
        return r10;
    L4:
        return MapsKt.emptyMap();
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> r10, Iterable<? extends Pair<? extends K, ? extends V>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "pairs");
        if (r10.isEmpty() == true) goto L7;
        LinkedHashMap r12 = new LinkedHashMap(r10);
        putAll(r12, r11);
        return r12;
    L7:
        return MapsKt.toMap(r11);
    }

    public static <K, V> Map<K, V> plus(Map<? extends K, ? extends V> r10, Map<? extends K, ? extends V> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "map");
        LinkedHashMap r12 = new LinkedHashMap(r10);
        r12.putAll(r11);
        return r12;
    }

    public static <K, V> Map<K, V> plus(Map<? extends K, ? extends V> r10, Pair<? extends K, ? extends V> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "pair");
        if (r10.isEmpty() == true) goto L7;
        LinkedHashMap r12 = new LinkedHashMap(r10);
        r12.put(r11.getFirst(), r11.getSecond());
        return r12;
    L7:
        return MapsKt.mapOf(r11);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> r10, Sequence<? extends Pair<? extends K, ? extends V>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "pairs");
        LinkedHashMap r12 = new LinkedHashMap(r10);
        putAll(r12, r11);
        return optimizeReadOnlyMap(r12);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> r10, Pair<? extends K, ? extends V>[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "pairs");
        if (r10.isEmpty() == true) goto L7;
        LinkedHashMap r12 = new LinkedHashMap(r10);
        putAll(r12, r11);
        return r12;
    L7:
        return toMap(r11);
    }

    @InlineOnly
    private static final <K, V> void plusAssign(Map<? super K, ? super V> r10, Iterable<? extends Pair<? extends K, ? extends V>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "pairs");
        putAll(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <K, V> void plusAssign(Map<? super K, ? super V> r10, Map<K, ? extends V> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "map");
        r10.putAll(r11);
    }

    @InlineOnly
    private static final <K, V> void plusAssign(Map<? super K, ? super V> r10, Pair<? extends K, ? extends V> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "pair");
        r10.put(r11.getFirst(), r11.getSecond());
    }

    @InlineOnly
    private static final <K, V> void plusAssign(Map<? super K, ? super V> r10, Sequence<? extends Pair<? extends K, ? extends V>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "pairs");
        putAll(r10, r11);
    }

    @InlineOnly
    private static final <K, V> void plusAssign(Map<? super K, ? super V> r10, Pair<? extends K, ? extends V>[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "pairs");
        putAll(r10, r11);
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> r10, Iterable<? extends Pair<? extends K, ? extends V>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "pairs");
        Iterator<? extends Pair<? extends K, ? extends V>> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Pair<? extends K, ? extends V> r13 = r12.next();
        r10.put(r13.component1(), r13.component2());
        goto L4
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> r10, Sequence<? extends Pair<? extends K, ? extends V>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "pairs");
        Iterator<? extends Pair<? extends K, ? extends V>> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Pair<? extends K, ? extends V> r13 = r12.next();
        r10.put(r13.component1(), r13.component2());
        goto L4
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> r10, Pair<? extends K, ? extends V>[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "pairs");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        Pair<? extends K, ? extends V> r14 = r11[r13];
        r10.put(r14.component1(), r14.component2());
        r13 = r13 + 1;
        goto L3
    }

    @InlineOnly
    private static final <K, V> V remove(Map<? extends K, V> r10, K r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (V) TypeIntrinsics.asMutableMap(r10).remove(r11);
    }

    @InlineOnly
    private static final <K, V> void set(Map<K, V> r10, K r11, V r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.put(r11, r12);
    }

    public static <K, V> Map<K, V> toMap(Iterable<? extends Pair<? extends K, ? extends V>> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L17;
        Collection r11 = (Collection) r10;
        int r12 = r11.size();
        if (r12 == 0) goto L15;
        if (r12 == 1) goto L10;
        return toMap(r10, new LinkedHashMap(MapsKt.mapCapacity(r11.size())));
    L10:
        if ((r10 instanceof List) == false) goto L12;
        Pair<? extends K, ? extends V> r13 = (Pair<? extends K, ? extends V>) ((List) r10).get(0);
    L19:
        return MapsKt.mapOf(r13);
    L12:
        r13 = r10.iterator().next();
        goto L19
    L15:
        return MapsKt.emptyMap();
    L17:
        return optimizeReadOnlyMap(toMap(r10, new LinkedHashMap()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Iterable<? extends Pair<? extends K, ? extends V>> r10, M r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        putAll(r11, r10);
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static <K, V> Map<K, V> toMap(Map<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.size();
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L11;
        return MapsKt.toMutableMap(r10);
    L11:
        return MapsKt__MapsJVMKt.toSingletonMap(r10);
    L9:
        return MapsKt.emptyMap();
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Map<? extends K, ? extends V> r10, M r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        r11.putAll(r10);
        return r11;
    }

    public static final <K, V> Map<K, V> toMap(Sequence<? extends Pair<? extends K, ? extends V>> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return optimizeReadOnlyMap(toMap(r10, new LinkedHashMap()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Sequence<? extends Pair<? extends K, ? extends V>> r10, M r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        putAll(r11, r10);
        return r11;
    }

    public static final <K, V> Map<K, V> toMap(Pair<? extends K, ? extends V>[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length;
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L11;
        return toMap(r10, new LinkedHashMap(MapsKt.mapCapacity(r10.length)));
    L11:
        return MapsKt.mapOf(r10[0]);
    L9:
        return MapsKt.emptyMap();
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Pair<? extends K, ? extends V>[] r10, M r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        putAll(r11, r10);
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static <K, V> Map<K, V> toMutableMap(Map<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new LinkedHashMap(r10);
    }

    @InlineOnly
    private static final <K, V> Pair<K, V> toPair(Map.Entry<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new Pair(r10.getKey(), r10.getValue());
    }
}
