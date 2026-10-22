package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryPooledByteBufferFactory implements PooledByteBufferFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PooledByteStreams f8230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MemoryChunkPool f8231b;

    public MemoryPooledByteBufferFactory(MemoryChunkPool r5, PooledByteStreams r10) {
        this.f8231b = r5;
        this.f8230a = r10;
    }

    public final MemoryPooledByteBuffer a(byte[] r5) {
        MemoryPooledByteBufferOutputStream r10 = new MemoryPooledByteBufferOutputStream(this.f8231b, r5.length);
        r10.write(r5, 0, r5.length);     // Catch: Throwable -> L6 IOException -> L8
        MemoryPooledByteBuffer r11 = r10.b();     // Catch: Throwable -> L6 IOException -> L8
        r10.close();
        return r11;
    L8:
        e = move-exception;
        Throwables.a(e, Error.class);     // Catch: Throwable -> L6
        Throwables.a(e, RuntimeException.class);     // Catch: Throwable -> L6
        throw new RuntimeException(e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r10.close();
        throw th;
    }
}
