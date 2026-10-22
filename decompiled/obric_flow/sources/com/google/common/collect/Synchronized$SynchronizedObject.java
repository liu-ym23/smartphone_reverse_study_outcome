package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedObject implements Serializable {
    private static final long serialVersionUID = 0;
    final Object delegate;
    final Object mutex;

    public Synchronized$SynchronizedObject(Object r5, Object r10) {
        r5.getClass();
        this.delegate = r5;
        if (r10 != null) goto L5;
        r10 = this;
    L5:
        this.mutex = r10;
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        Object r10 = this.mutex;
        monitor-enter(r10);
        r5.defaultWriteObject();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Object delegate() {
        return this.delegate;
    }

    public String toString() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        String r10 = this.delegate.toString();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }
}
