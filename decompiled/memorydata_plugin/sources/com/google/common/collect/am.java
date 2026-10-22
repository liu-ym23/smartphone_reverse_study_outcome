package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
public interface am<K, V> {
    private static /* synthetic */ void a(BiConsumer r2, Map.Entry r3) {
        BiConsumer r4 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r2, BiConsumer.class, "com.obric.memorydata.plugin");
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        r4.accept(r5.getKey(), r5.getValue());
    }

    static /* synthetic */ void lambda$ekzTZiDZTJ0TApXou90LyLZVMbo(BiConsumer r0, Map.Entry r1) {
        a(r0, r1);
    }

    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(Object r1, Object r2);

    boolean containsKey(Object r1);

    boolean containsValue(Object r1);

    Collection<Map.Entry<K, V>> entries();

    boolean equals(Object r1);

    default void forEach(BiConsumer<? super K, ? super V> r3) {
        final BiConsumer r4 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        entries().forEach(new $$Lambda$am$ekzTZiDZTJ0TApXou90LyLZVMbo(r4));
    }

    Collection<V> get(K r1);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    an<K> keys();

    boolean put(K r1, V r2);

    boolean putAll(am<? extends K, ? extends V> r1);

    boolean putAll(K r1, Iterable<? extends V> r2);

    boolean remove(Object r1, Object r2);

    Collection<V> removeAll(Object r1);

    Collection<V> replaceValues(K r1, Iterable<? extends V> r2);

    int size();

    Collection<V> values();
}
