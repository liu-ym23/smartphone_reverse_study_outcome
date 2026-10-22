package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface l9 {
    Set cellSet();

    void clear();

    Map column(Object r5);

    Set columnKeySet();

    Map columnMap();

    boolean contains(Object r5, Object r10);

    boolean containsColumn(Object r5);

    boolean containsRow(Object r5);

    boolean containsValue(Object r5);

    boolean equals(Object r5);

    Object get(Object r5, Object r10);

    int hashCode();

    boolean isEmpty();

    Object put(Object r5, Object r10, Object r11);

    void putAll(l9 r5);

    Object remove(Object r5, Object r10);

    Map row(Object r5);

    Set rowKeySet();

    Map rowMap();

    int size();

    Collection values();
}
