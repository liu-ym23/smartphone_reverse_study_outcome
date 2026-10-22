package org.apache.logging.log4j.util;

/* JADX INFO: loaded from: classes6.dex */
public interface IndexedReadOnlyStringMap extends ReadOnlyStringMap {
    String getKeyAt(int r1);

    <V> V getValueAt(int r1);

    int indexOfKey(String r1);
}
