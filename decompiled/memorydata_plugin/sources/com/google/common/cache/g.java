package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
interface g<K, V> {
    long getAccessTime();

    int getHash();

    K getKey();

    g<K, V> getNext();

    g<K, V> getNextInAccessQueue();

    g<K, V> getNextInWriteQueue();

    g<K, V> getPreviousInAccessQueue();

    g<K, V> getPreviousInWriteQueue();

    LocalCache.r<K, V> getValueReference();

    long getWriteTime();

    void setAccessTime(long r1);

    void setNextInAccessQueue(g<K, V> r1);

    void setNextInWriteQueue(g<K, V> r1);

    void setPreviousInAccessQueue(g<K, V> r1);

    void setPreviousInWriteQueue(g<K, V> r1);

    void setValueReference(LocalCache.r<K, V> r1);

    void setWriteTime(long r1);
}
