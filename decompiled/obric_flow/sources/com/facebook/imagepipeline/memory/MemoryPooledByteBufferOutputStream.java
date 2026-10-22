package com.facebook.imagepipeline.memory;

import androidx.room.jarjarred.org.antlr.runtime.a;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryPooledByteBufferOutputStream extends PooledByteBufferOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MemoryChunkPool f8232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DefaultCloseableReference f8233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8234c;

    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool r5) {
        this(r5, r5.f8227j[0]);
    }

    public final MemoryPooledByteBuffer b() {
        if (CloseableReference.b(this.f8233b) == false) goto L7;
        return new MemoryPooledByteBuffer(this.f8233b, this.f8234c);
    L7:
        throw new InvalidStreamException();
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        DefaultCloseableReference r5 = this.f8233b;
        if (r5 == null) goto L5;
        r5.close();
    L5:
        this.f8233b = null;
        this.f8234c = -1;
        super.close();
    }

    @Override // java.io.OutputStream
    public final void write(int r5) {
        write(new byte[]{(byte) r5});
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r5, int r10, int r11) {
        if (r10 < 0) goto L27;
        if (r11 < 0) goto L27;
        if ((r10 + r11) > r5.length) goto L27;
        if (CloseableReference.b(this.f8233b) == false) goto L26;
        int r12 = this.f8234c + r11;
        if (CloseableReference.b(this.f8233b) == false) goto L24;
        DefaultCloseableReference r13 = this.f8233b;
        monitor-enter(r13);
        Object r14 = r13.f7671b.d();     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
        if (r12 <= ((MemoryChunk) r14).c()) goto L18;
        MemoryChunk r15 = (MemoryChunk) this.f8232a.get(r12);
        ((MemoryChunk) this.f8233b.c()).a(r15, this.f8234c);
        this.f8233b.close();
        this.f8233b = CloseableReference.a(r15, this.f8232a, CloseableReference.f);
    L18:
        ((MemoryChunk) this.f8233b.c()).b(this.f8234c, r5, r10, r11);
        this.f8234c += r11;
        return;
    L20:
        th = move-exception;
        throw th;
    L24:
        throw new InvalidStreamException();
    L26:
        throw new InvalidStreamException();
    L27:
        StringBuilder r16 = new StringBuilder("length=");
        a.C(r16, r5.length, "; regionStart=", r10, "; regionLength=");
        r16.append(r11);
        throw new ArrayIndexOutOfBoundsException(r16.toString());
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool r5, int r10) {
        if (r10 <= 0) goto L7;
        r5.getClass();
        this.f8232a = r5;
        this.f8234c = 0;
        this.f8233b = CloseableReference.a(r5.get(r10), r5, CloseableReference.f);
        return;
    L7:
        throw new IllegalArgumentException();
    }
}
