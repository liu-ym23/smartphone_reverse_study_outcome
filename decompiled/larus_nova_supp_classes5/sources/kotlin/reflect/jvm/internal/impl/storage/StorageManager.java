package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface StorageManager {
    <T> T compute(Function0<? extends T> r1);

    <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues();

    <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues();

    <T> NotNullLazyValue<T> createLazyValue(Function0<? extends T> r1);

    <T> NotNullLazyValue<T> createLazyValueWithPostCompute(Function0<? extends T> r1, Function1<? super Boolean, ? extends T> r2, Function1<? super T, Unit> r3);

    <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> r1);

    <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> r1);

    <T> NullableLazyValue<T> createNullableLazyValue(Function0<? extends T> r1);

    <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(Function0<? extends T> r1, T r2);
}
