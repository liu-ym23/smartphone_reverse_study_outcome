package org.tensorflow.lite;

import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    default void close() {
    }

    long getNativeHandle();
}
