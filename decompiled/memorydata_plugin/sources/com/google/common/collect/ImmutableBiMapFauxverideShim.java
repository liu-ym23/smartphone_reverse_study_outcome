package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
abstract class ImmutableBiMapFauxverideShim<K, V> extends ImmutableMap<K, V> {
    ImmutableBiMapFauxverideShim() {
    }

    @Deprecated
    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3) {
        Function r4 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3, BinaryOperator<V> r4) {
        Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        BinaryOperator r7 = (BinaryOperator) ZeusTransformUtils.wrapperContextForParams(r4, BinaryOperator.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }
}
