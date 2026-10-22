package com.bumptech.glide.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<byte[]> f968a = null;

    /* JADX INFO: renamed from: com.bumptech.glide.util.a$a, reason: collision with other inner class name */
    private static class C0074a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f970b;

        C0074a(ByteBuffer r2) {
            this.f970b = -1;
            this.f969a = r2;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f969a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int r1) {
            monitor-enter(this);
            this.f970b = this.f969a.position();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f969a.hasRemaining() == true) goto L7;
            return -1;
        L7:
            return this.f969a.get() & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] r2, int r3, int r4) {
            if (this.f969a.hasRemaining() == true) goto L6;
            return -1;
        L6:
            int r5 = Math.min(r4, available());
            this.f969a.get(r2, r3, r5);
            return r5;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            monitor-enter(this);
            int r0 = this.f970b;     // Catch: Throwable -> L10
            if (r0 == (-1)) goto L9;
            this.f969a.position(r0);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L9:
            throw new IOException("Cannot reset to unset mark position");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.io.InputStream
        public long skip(long r3) {
            if (this.f969a.hasRemaining() == true) goto L6;
            return -1;
        L6:
            long r4 = Math.min(r3, available());
            ByteBuffer r2 = this.f969a;
            r2.position((int) (((long) r2.position()) + r4));
            return r4;
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f972b;
        final byte[] c;

        b(byte[] r1, int r2, int r3) {
            this.c = r1;
            this.f971a = r2;
            this.f972b = r3;
        }
    }

    static {
        f968a = new AtomicReference();
    }

    public static ByteBuffer a(File r8) {
        FileChannel r0 = null;
        long r5 = r8.length();     // Catch: Throwable -> L19
        if (r5 > 2147483647L) goto L18;
        if (r5 == 0) goto L16;
        RandomAccessFile r7 = new RandomAccessFile(r8, "r");     // Catch: Throwable -> L19
        r0 = r7.getChannel();     // Catch: Throwable -> L13
        MappedByteBuffer r9 = r0.map(FileChannel.MapMode.READ_ONLY, 0, r5).load();     // Catch: Throwable -> L13
        if (r0 != null) goto L37;
    L35:
        r7.close();     // Catch: IOException -> L27
    L12:
        return r9;
    L37:
        r0.close();     // Catch: IOException -> L26
    L13:
        th = th;
    L21:
        if (r0 != null) goto L39;
    L23:
        if (r7 == null) goto L41;
        r7.close();     // Catch: IOException -> L29
        throw th;
    L42:
        throw th;
    L41:
        throw th;
    L39:
        r0.close();     // Catch: IOException -> L28
        goto L23
    L16:
        throw new IOException("File unsuitable for memory mapping");     // Catch: Throwable -> L19
    L18:
        throw new IOException("File too large to map into memory");     // Catch: Throwable -> L19
    L19:
        th = th;
        r7 = null;
        goto L21
    }

    public static ByteBuffer a(InputStream r5) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(16384);
        byte[] r2 = (byte[]) ZeusTransformUtils.preCheckCast(f968a.getAndSet(null), byte[].class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        r2 = new byte[16384];
    L5:
        int r1 = r5.read(r2);
        if (r1 < 0) goto L8;
        r0.write(r2, 0, r1);
        goto L5
    L8:
        f968a.set(r2);
        byte[] r6 = r0.toByteArray();
        return c(ByteBuffer.allocateDirect(r6.length).put(r6));
    }

    public static void a(ByteBuffer r3, File r4) {
        c(r3);
        FileChannel r0 = null;
        RandomAccessFile r1 = new RandomAccessFile(r4, "rw");     // Catch: Throwable -> L11
        r0 = r1.getChannel();     // Catch: Throwable -> L9
        r0.write(r3);     // Catch: Throwable -> L9
        r0.force(false);     // Catch: Throwable -> L9
        r0.close();     // Catch: Throwable -> L9
        r1.close();     // Catch: Throwable -> L9
        if (r0 != null) goto L30;
    L26:
        r1.close();     // Catch: IOException -> L19
        return;
    L34:
        return;
    L30:
        r0.close();     // Catch: IOException -> L18
    L9:
        th = th;
    L13:
        if (r0 != null) goto L32;
    L15:
        if (r1 == null) goto L35;
        r1.close();     // Catch: IOException -> L21
        throw th;
    L36:
        throw th;
    L35:
        throw th;
    L32:
        r0.close();     // Catch: IOException -> L20
    L11:
        th = th;
        r1 = null;
        goto L13
    }

    public static byte[] a(ByteBuffer r2) {
        b r0 = d(r2);
        if (r0 != null) goto L5;
    L9:
        ByteBuffer r3 = r2.asReadOnlyBuffer();
        byte[] r1 = new byte[r3.limit()];
        c(r3);
        r3.get(r1);
        return r1;
    L5:
        if (r0.f971a != 0) goto L9;
        if (r0.f972b != r0.c.length) goto L9;
        return r2.array();
    }

    public static InputStream b(ByteBuffer r1) {
        return new C0074a(r1);
    }

    public static ByteBuffer c(ByteBuffer r2) {
        return (ByteBuffer) ZeusTransformUtils.preCheckCast(r2.position(0), ByteBuffer.class, "com.obric.memorydata.plugin");
    }

    private static b d(ByteBuffer r3) {
        if (r3.isReadOnly() == false) goto L5;
        return null;
    L5:
        if (r3.hasArray() == true) goto L7;
        return null;
    L7:
        return new b(r3.array(), r3.arrayOffset(), r3.limit());
    }
}
