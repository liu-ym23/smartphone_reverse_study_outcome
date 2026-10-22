package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
public interface v0 {
    long getAccessTime();

    int getHash();

    Object getKey();

    v0 getNext();

    v0 getNextInAccessQueue();

    v0 getNextInWriteQueue();

    v0 getPreviousInAccessQueue();

    v0 getPreviousInWriteQueue();

    g0 getValueReference();

    long getWriteTime();

    void setAccessTime(long r5);

    void setNextInAccessQueue(v0 r5);

    void setNextInWriteQueue(v0 r5);

    void setPreviousInAccessQueue(v0 r5);

    void setPreviousInWriteQueue(v0 r5);

    void setValueReference(g0 r5);

    void setWriteTime(long r5);
}
