package com.bytedance.frameworks.baselib.network.http;

import com.bytedance.retrofit2.client.SsCall;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class e extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InputStream f2429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SsCall f2430b;

    public e() {
    }

    public e(InputStream r3, SsCall r4) {
        SsCall r5 = (SsCall) ZeusTransformUtils.wrapperContextForParams(r4, SsCall.class, "com.obric.memorydata.plugin");
        this.f2429a = r3;
        this.f2430b = r5;
    }

    @Override // java.io.InputStream
    public int available() {
        InputStream r0 = this.f2429a;
        if (r0 == null) goto L7;
        return r0.available();
    L7:
        return super.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream r0 = this.f2429a;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.close();     // Catch: Throwable -> L9
    L5:
        SsCall r1 = this.f2430b;     // Catch: Throwable -> L9
        if (r1 == null) goto L11;
        r1.cancel();     // Catch: Throwable -> L9
    L11:
        super.close();
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    @Override // java.io.InputStream
    public synchronized void mark(int r2) {
        monitor-enter(this);
        InputStream r0 = this.f2429a;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.mark(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        super.mark(r2);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream r0 = this.f2429a;
        if (r0 == null) goto L7;
        return r0.markSupported();
    L7:
        return super.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        InputStream r0 = this.f2429a;     // Catch: Throwable -> L10 IOException -> L12
        if (r0 == null) goto L6;
        int r1 = r0.read();     // Catch: Throwable -> L10 IOException -> L12
    L7:
        if (r1 != (-1)) goto L9;
        close();
    L9:
        return r1;
    L6:
        r1 = -1;
    L10:
        th = move-exception;
        throw th;
    L12:
        e = move-exception;
        throw e;     // Catch: Throwable -> L10
    }

    @Override // java.io.InputStream
    public int read(byte[] r2) {
        InputStream r0 = this.f2429a;     // Catch: Throwable -> L10 IOException -> L12
        if (r0 == null) goto L5;
        int r3 = r0.read(r2);     // Catch: Throwable -> L10 IOException -> L12
    L7:
        if (r3 != (-1)) goto L9;
        close();
    L9:
        return r3;
    L5:
        r3 = super.read(r2);     // Catch: Throwable -> L10 IOException -> L12
    L10:
        th = move-exception;
        throw th;
    L12:
        e = move-exception;
        throw e;     // Catch: Throwable -> L10
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        InputStream r0 = this.f2429a;     // Catch: Throwable -> L10 IOException -> L12
        if (r0 == null) goto L5;
        int r5 = r0.read(r2, r3, r4);     // Catch: Throwable -> L10 IOException -> L12
    L7:
        if (r5 != (-1)) goto L9;
        close();
    L9:
        return r5;
    L5:
        r5 = super.read(r2, r3, r4);     // Catch: Throwable -> L10 IOException -> L12
    L10:
        th = move-exception;
        throw th;
    L12:
        e = move-exception;
        throw e;     // Catch: Throwable -> L10
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        InputStream r0 = this.f2429a;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.reset();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        super.reset();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public long skip(long r2) {
        InputStream r0 = this.f2429a;
        if (r0 == null) goto L7;
        return r0.skip(r2);
    L7:
        return super.skip(r2);
    }
}
