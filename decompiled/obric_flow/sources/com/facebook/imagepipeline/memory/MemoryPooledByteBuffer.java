package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryPooledByteBuffer implements PooledByteBuffer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CloseableReference f8229b;

    public MemoryPooledByteBuffer(DefaultCloseableReference r5, int r10) {
        r5.getClass();
        if (r10 < 0) goto L15;
        monitor-enter(r5);
        Object r11 = r5.f7671b.d();     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
        if (r10 > ((MemoryChunk) r11).c()) goto L15;
        this.f8229b = r5.clone();
        this.f8228a = r10;
        return;
    L11:
        th = move-exception;
        throw th;
    L15:
        throw new IllegalArgumentException();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public final synchronized byte a(int r5) {
        monitor-enter(this);
        b();     // Catch: Throwable -> L10
        if (r5 < 0) goto L15;
        if (r5 >= this.f8228a) goto L13;
        byte r10 = ((MemoryChunk) this.f8229b.c()).a(r5);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r10;
    L13:
        throw new IllegalArgumentException();     // Catch: Throwable -> L10
    L15:
        throw new IllegalArgumentException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (a() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        throw new PooledByteBuffer.ClosedException();     // Catch: Throwable -> L9
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
        CloseableReference r5 = this.f8229b;     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        r5.close();     // Catch: Throwable -> L6
    L8:
        this.f8229b = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public final synchronized int size() {
        monitor-enter(this);
        b();     // Catch: Throwable -> L6
        int r5 = this.f8228a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public final synchronized int a(int r5, byte[] r10, int r11, int r12) {
        monitor-enter(this);
        b();     // Catch: Throwable -> L8
        if ((r5 + r12) > this.f8228a) goto L11;
        int r13 = ((MemoryChunk) this.f8229b.c()).a(r5, r10, r11, r12);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r13;
    L11:
        throw new IllegalArgumentException();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public final synchronized boolean a() {
        monitor-enter(this);
        boolean r5 = !CloseableReference.b(this.f8229b);
        monitor-exit(this);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }
}
