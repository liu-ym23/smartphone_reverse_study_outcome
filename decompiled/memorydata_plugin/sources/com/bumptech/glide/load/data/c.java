package com.bumptech.glide.load.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class c extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OutputStream f682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f683b;
    private com.bumptech.glide.load.engine.bitmap_recycle.b c;
    private int d;

    public c(OutputStream r3, com.bumptech.glide.load.engine.bitmap_recycle.b r4) {
        this(r3, (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin"), 65536);
    }

    c(OutputStream r4, com.bumptech.glide.load.engine.bitmap_recycle.b r5, int r6) {
        com.bumptech.glide.load.engine.bitmap_recycle.b r7 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        this.f682a = r4;
        this.c = r7;
        this.f683b = (byte[]) ZeusTransformUtils.preCheckCast(r7.a(r6, byte[].class), byte[].class, "com.obric.memorydata.plugin");
    }

    private void a() {
        int r0 = this.d;
        if (r0 <= 0) goto L6;
        this.f682a.write(this.f683b, 0, r0);
        this.d = 0;
        return;
    }

    private void b() {
        if (this.d != this.f683b.length) goto L6;
        a();
        return;
    }

    private void c() {
        byte[] r0 = this.f683b;
        if (r0 == null) goto L6;
        this.c.a(r0);
        this.f683b = null;
        return;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        flush();     // Catch: Throwable -> L5
        this.f682a.close();
        c();
        return;
    L5:
        th = move-exception;
        this.f682a.close();
        throw th;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        a();
        this.f682a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int r4) {
        byte[] r0 = this.f683b;
        int r1 = this.d;
        this.d = r1 + 1;
        r0[r1] = (byte) r4;
        b();
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3) {
        write(r3, 0, r3.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r6, int r7, int r8) {
        int r0 = 0;
    L3:
        int r1 = r8 - r0;
        int r2 = r7 + r0;
        int r3 = this.d;
        if (r3 == 0) goto L6;
    L9:
        int r4 = Math.min(r1, this.f683b.length - r3);
        System.arraycopy(r6, r2, this.f683b, this.d, r4);
        this.d += r4;
        r0 = r0 + r4;
        b();
        if (r0 < r8) goto L3;
        return;
    L6:
        if (r1 < this.f683b.length) goto L9;
        this.f682a.write(r6, r2, r1);
    }
}
