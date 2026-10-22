package kotlin.collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
public final class MapsKt extends MapsKt___MapsKt {
    private MapsKt() {
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> build(Map<K, V> r10) {
        return MapsKt__MapsJVMKt.build(r10);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> createMapBuilder() {
        return MapsKt__MapsJVMKt.createMapBuilder();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> createMapBuilder(int r10) {
        return MapsKt__MapsJVMKt.createMapBuilder(r10);
    }

    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> emptyMap() {
        return MapsKt__MapsKt.emptyMap();
    }

    @SinceKotlin(version = "1.1")
    public static /* bridge */ /* synthetic */ <K, V> V getValue(Map<K, ? extends V> r10, K r11) {
        return (V) MapsKt__MapsKt.getValue(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <K, V> HashMap<K, V> hashMapOf(Pair<? extends K, ? extends V>... r10) {
        return MapsKt__MapsKt.hashMapOf(r10);
    }

    public static /* bridge */ /* synthetic */ <K, V> LinkedHashMap<K, V> linkedMapOf(Pair<? extends K, ? extends V>... r10) {
        return MapsKt__MapsKt.linkedMapOf(r10);
    }

    @PublishedApi
    public static /* bridge */ /* synthetic */ int mapCapacity(int r10) {
        return MapsKt__MapsJVMKt.mapCapacity(r10);
    }

    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V> r10) {
        return MapsKt__MapsJVMKt.mapOf(r10);
    }

    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V>... r10) {
        return MapsKt__MapsKt.mapOf(r10);
    }

    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> mutableMapOf(Pair<? extends K, ? extends V>... r10) {
        return MapsKt__MapsKt.mutableMapOf(r10);
    }

    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> plus(Map<? extends K, ? extends V> r10, Map<? extends K, ? extends V> r11) {
        return MapsKt__MapsKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> plus(Map<? extends K, ? extends V> r10, Pair<? extends K, ? extends V> r11) {
        return MapsKt__MapsKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> toMap(Iterable<? extends Pair<? extends K, ? extends V>> r10) {
        return MapsKt__MapsKt.toMap(r10);
    }

    @SinceKotlin(version = "1.1")
    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> toMap(Map<? extends K, ? extends V> r10) {
        return MapsKt__MapsKt.toMap(r10);
    }

    @SinceKotlin(version = "1.1")
    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> toMutableMap(Map<? extends K, ? extends V> r10) {
        return MapsKt__MapsKt.toMutableMap(r10);
    }

    public static /* bridge */ /* synthetic */ <K, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> r10, Comparator<? super K> r11) {
        return MapsKt__MapsJVMKt.toSortedMap(r10, r11);
    }
}
