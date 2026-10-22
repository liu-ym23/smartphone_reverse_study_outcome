package com.facebook.common.memory;

import com.facebook.common.internal.Throwables;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PooledByteBufferOutputStream extends OutputStream {
    public PooledByteBufferOutputStream() {
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        Throwables.a(e, Error.class);
        Throwables.a(e, RuntimeException.class);
        throw new RuntimeException(e);
    }
}
