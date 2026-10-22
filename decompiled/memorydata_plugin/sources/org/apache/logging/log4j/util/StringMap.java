package org.apache.logging.log4j.util;

/* JADX INFO: loaded from: classes6.dex */
public interface StringMap extends ReadOnlyStringMap {
    void clear();

    boolean equals(Object r1);

    void freeze();

    int hashCode();

    boolean isFrozen();

    void putAll(ReadOnlyStringMap r1);

    void putValue(String r1, Object r2);

    void remove(String r1);
}
