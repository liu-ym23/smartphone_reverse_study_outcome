package com.facebook.imagepipeline.memory;

import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class BufferMemoryChunk implements MemoryChunk, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f8215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8217c;

    public BufferMemoryChunk(int r5) {
        this.f8215a = ByteBuffer.allocateDirect(r5);
        this.f8216b = r5;
        this.f8217c = System.identityHashCode(this);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized boolean a() {
        monitor-enter(this);
        ByteBuffer r5 = this.f8215a;     // Catch: Throwable -> L10
        monitor-exit(this);
        if (r5 != null) goto L8;
        return true;
    L8:
        return false;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized int b(int r5, byte[] r10, int r11, int r12) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (a() == true) goto L11;
        int r13 = Math.min(Math.max(0, this.f8216b - r5), r12);     // Catch: Throwable -> L8
        MemoryChunkUtil.a(r5, r10.length, r11, r13, this.f8216b);     // Catch: Throwable -> L8
        this.f8215a.position(r5);     // Catch: Throwable -> L8
        this.f8215a.put(r10, r11, r13);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r13;
    L11:
        throw new IllegalStateException();     // Catch: Throwable -> L8
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final int c() {
        return this.f8216b;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
        this.f8215a = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized ByteBuffer d() {
        monitor-enter(this);
        ByteBuffer r5 = this.f8215a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized int a(int r5, byte[] r10, int r11, int r12) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (a() == true) goto L11;
        int r13 = Math.min(Math.max(0, this.f8216b - r5), r12);     // Catch: Throwable -> L8
        MemoryChunkUtil.a(r5, r10.length, r11, r13, this.f8216b);     // Catch: Throwable -> L8
        this.f8215a.position(r5);     // Catch: Throwable -> L8
        this.f8215a.get(r10, r11, r13);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r13;
    L11:
        throw new IllegalStateException();     // Catch: Throwable -> L8
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final long b() {
        return this.f8217c;
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
        if (r5 >= this.f8216b) goto L14;
        byte r10 = this.f8215a.get(r5);     // Catch: Throwable -> L11
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
        if ((r5 instanceof BufferMemoryChunk) == false) goto L22;
        if (a() == true) goto L20;
        BufferMemoryChunk r11 = (BufferMemoryChunk) r5;
        if (r11.a() == true) goto L18;
        MemoryChunkUtil.a(0, r11.f8216b, 0, r10, this.f8216b);
        this.f8215a.position(0);
        monitor-enter(r11);
        ByteBuffer r12 = r11.f8215a;     // Catch: Throwable -> L14
        monitor-exit(r11);     // Catch: Throwable -> L14
        r12.position(0);
        byte[] r13 = new byte[r10];
        this.f8215a.get(r13, 0, r10);
        r11.d().put(r13, 0, r10);
        return;
    L14:
        th = move-exception;
        throw th;
    L18:
        throw new IllegalStateException();
    L20:
        throw new IllegalStateException();
    L22:
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final void a(MemoryChunk r5, int r10) {
        r5.getClass();
        if (r5.b() != this.f8217c) goto L5;
        Log.w("BufferMemoryChunk", "Copying from BufferMemoryChunk " + Long.toHexString(this.f8217c) + " to BufferMemoryChunk " + Long.toHexString(r5.b()) + " which are the same ");
        throw new IllegalArgumentException();
    L5:
        if (r5.b() >= this.f8217c) goto L19;
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
