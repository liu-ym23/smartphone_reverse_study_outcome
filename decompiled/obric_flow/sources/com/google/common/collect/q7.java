package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
public interface q7 {
    Map asMap();

    void clear();

    boolean containsEntry(Object r5, Object r10);

    boolean containsKey(Object r5);

    boolean containsValue(Object r5);

    Collection entries();

    boolean equals(Object r5);

    void forEach(BiConsumer r5);

    Collection get(Object r5);

    int hashCode();

    boolean isEmpty();

    Set keySet();

    z7 keys();

    boolean put(Object r5, Object r10);

    boolean putAll(q7 r5);

    boolean putAll(Object r5, Iterable r10);

    boolean remove(Object r5, Object r10);

    Collection removeAll(Object r5);

    Collection replaceValues(Object r5, Iterable r10);

    int size();

    Collection values();
}
