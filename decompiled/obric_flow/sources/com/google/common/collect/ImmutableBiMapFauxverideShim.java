package com.google.common.collect;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
abstract class ImmutableBiMapFauxverideShim<K, V> extends ImmutableMap<K, V> {
    public ImmutableBiMapFauxverideShim() {
    }

    @Deprecated
    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> r5, Function<? super T, ? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> r5, Function<? super T, ? extends V> r10, BinaryOperator<V> r11) {
        throw new UnsupportedOperationException();
    }
}
