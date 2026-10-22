package com.bumptech.glide.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public final class c extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Queue<c> f975a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InputStream f976b;
    private IOException c;

    static {
        f975a = k.b(0);
    }

    c() {
    }

    public static c a(InputStream r4) {
        Queue<c> r0 = f975a;
        monitor-enter(r0);
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0.poll(), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        r1 = new c();
    L8:
        r1.b(r4);
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public IOException a() {
        return this.c;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f976b.available();
    }

    public void b() {
        this.c = null;
        this.f976b = null;
        Queue<c> r0 = f975a;
        monitor-enter(r0);
        r0.offer(this);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void b(InputStream r1) {
        this.f976b = r1;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f976b.close();
    }

    @Override // java.io.InputStream
    public void mark(int r1) {
        this.f976b.mark(r1);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f976b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        return this.f976b.read();
    L4:
        e = move-exception;
        this.c = e;
        throw e;
    }

    @Override // java.io.InputStream
    public int read(byte[] r2) {
        return this.f976b.read(r2);
    L4:
        e = move-exception;
        this.c = e;
        throw e;
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        return this.f976b.read(r2, r3, r4);
    L4:
        e = move-exception;
        this.c = e;
        throw e;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        this.f976b.reset();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public long skip(long r2) {
        return this.f976b.skip(r2);
    L4:
        e = move-exception;
        this.c = e;
        throw e;
    }
}
