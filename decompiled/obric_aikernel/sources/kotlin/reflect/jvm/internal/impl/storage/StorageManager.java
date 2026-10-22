package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public interface StorageManager {
    <T> T compute(Function0<? extends T> r10);

    <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues();

    <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues();

    <T> NotNullLazyValue<T> createLazyValue(Function0<? extends T> r10);

    <T> NotNullLazyValue<T> createLazyValueWithPostCompute(Function0<? extends T> r10, Function1<? super Boolean, ? extends T> r11, Function1<? super T, Unit> r12);

    <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> r10);

    <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> r10);

    <T> NullableLazyValue<T> createNullableLazyValue(Function0<? extends T> r10);

    <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(Function0<? extends T> r10, T r11);
}
