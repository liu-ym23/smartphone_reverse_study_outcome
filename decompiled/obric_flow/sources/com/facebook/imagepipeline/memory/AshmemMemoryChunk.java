package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(27)
public class AshmemMemoryChunk implements MemoryChunk, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedMemory f8196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f8197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8198c;

    public AshmemMemoryChunk(int r5) {
        if (r5 <= 0) goto L11;
        SharedMemory r10 = SharedMemory.create("AshmemMemoryChunk", r5);     // Catch: ErrnoException -> L7
        this.f8196a = r10;     // Catch: ErrnoException -> L7
        this.f8197b = r10.mapReadWrite();     // Catch: ErrnoException -> L7
        this.f8198c = System.identityHashCode(this);
        return;
    L7:
        e = move-exception;
        throw new RuntimeException("Fail to create AshmemMemory", e);
    L11:
        throw new IllegalArgumentException();
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized boolean a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f8197b == null) goto L13;
        if (this.f8196a == null) goto L13;
        monitor-exit(this);
        return false;
    L13:
        monitor-exit(this);
        return true;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized int b(int r5, byte[] r10, int r11, int r12) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (a() == true) goto L11;
        int r13 = Math.min(Math.max(0, c() - r5), r12);     // Catch: Throwable -> L8
        MemoryChunkUtil.a(r5, r10.length, r11, r13, c());     // Catch: Throwable -> L8
        this.f8197b.position(r5);     // Catch: Throwable -> L8
        this.f8197b.put(r10, r11, r13);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r13;
    L11:
        throw new IllegalStateException();     // Catch: Throwable -> L8
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final int c() {
        if (a() == true) goto L7;
        return this.f8196a.getSize();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (a() == true) goto L10;
        SharedMemory.unmap(this.f8197b);     // Catch: Throwable -> L8
        this.f8196a.close();     // Catch: Throwable -> L8
        this.f8197b = null;     // Catch: Throwable -> L8
        this.f8196a = null;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        monitor-exit(this);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized int a(int r5, byte[] r10, int r11, int r12) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (a() == true) goto L11;
        int r13 = Math.min(Math.max(0, c() - r5), r12);     // Catch: Throwable -> L8
        MemoryChunkUtil.a(r5, r10.length, r11, r13, c());     // Catch: Throwable -> L8
        this.f8197b.position(r5);     // Catch: Throwable -> L8
        this.f8197b.get(r10, r11, r13);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r13;
    L11:
        throw new IllegalStateException();     // Catch: Throwable -> L8
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final long b() {
        return this.f8198c;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized byte a(int r5) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (a() == true) goto L18;
        if (r5 < 0) goto L16;
        if (r5 >= c()) goto L14;
        byte r10 = this.f8197b.get(r5);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r10;
    L14:
        throw new IllegalArgumentException();     // Catch: Throwable -> L11
    L16:
        throw new IllegalArgumentException();     // Catch: Throwable -> L11
    L18:
        throw new IllegalStateException();     // Catch: Throwable -> L11
    }

    public final void b(MemoryChunk r5, int r10) {
        if ((r5 instanceof AshmemMemoryChunk) == false) goto L15;
        if (a() == true) goto L13;
        AshmemMemoryChunk r11 = (AshmemMemoryChunk) r5;
        if (r11.a() == true) goto L11;
        MemoryChunkUtil.a(0, r11.c(), 0, r10, c());
        this.f8197b.position(0);
        r11.f8197b.position(0);
        byte[] r12 = new byte[r10];
        this.f8197b.get(r12, 0, r10);
        r11.f8197b.put(r12, 0, r10);
        return;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    L15:
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final void a(MemoryChunk r5, int r10) {
        r5.getClass();
        if (r5.b() != this.f8198c) goto L5;
        Log.w("AshmemMemoryChunk", "Copying from AshmemMemoryChunk " + Long.toHexString(this.f8198c) + " to AshmemMemoryChunk " + Long.toHexString(r5.b()) + " which are the same ");
        throw new IllegalArgumentException();
    L5:
        if (r5.b() >= this.f8198c) goto L19;
        monitor-enter(r5);
        monitor-enter(this);     // Catch: Throwable -> L12
        b(r5, r10);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        monitor-exit(r5);     // Catch: Throwable -> L12
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L19:
        monitor-enter(this);
        monitor-enter(r5);     // Catch: Throwable -> L25
        b(r5, r10);     // Catch: Throwable -> L27
        monitor-exit(r5);     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }
}
