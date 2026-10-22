package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface be<R, C, V> {

    public interface a<R, C, V> {
        C getColumnKey();

        R getRowKey();

        V getValue();
    }

    Set<a<R, C, V>> cellSet();

    void clear();

    Map<R, V> column(C r1);

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    boolean contains(Object r1, Object r2);

    boolean containsColumn(Object r1);

    boolean containsRow(Object r1);

    boolean containsValue(Object r1);

    boolean equals(Object r1);

    V get(Object r1, Object r2);

    int hashCode();

    boolean isEmpty();

    V put(R r1, C r2, V r3);

    void putAll(be<? extends R, ? extends C, ? extends V> r1);

    V remove(Object r1, Object r2);

    Map<C, V> row(R r1);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();

    Collection<V> values();
}
