package com.facebook.common.memory;

import com.facebook.common.logging.FLog;
import com.facebook.common.references.ResourceReleaser;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class PooledByteArrayBufferedInputStream extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f7663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f7664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ResourceReleaser f7665c;
    public int d;
    public int e;
    public boolean f;

    public PooledByteArrayBufferedInputStream(InputStream r5, byte[] r10, ResourceReleaser r11) {
        r5.getClass();
        this.f7663a = r5;
        r10.getClass();
        this.f7664b = r10;
        r11.getClass();
        this.f7665c = r11;
        this.d = 0;
        this.e = 0;
        this.f = false;
    }

    @Override // java.io.InputStream
    public final int available() {
        int r5 = this.e;
        int r10 = this.d;
        if (r5 > r10) goto L11;
        if (this.f == true) goto L9;
        int r11 = this.f7663a.available();
        return r11 + (r10 - r5);
    L9:
        throw new IOException("stream already closed");
    L11:
        throw new IllegalStateException();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f == true) goto L6;
        this.f = true;
        this.f7665c.release(this.f7664b);
        super.close();
        return;
    }

    public final void finalize() {
        if (this.f == true) goto L5;
        FLog.b("PooledByteInputStream", "Finalized without closing");
        close();
    L5:
        super.finalize();
    }

    @Override // java.io.InputStream
    public final int read() {
        int r5 = this.e;
        int r10 = this.d;
        if (r5 > r10) goto L18;
        if (this.f == true) goto L16;
        if (r5 < r10) goto L13;
        int r11 = this.f7663a.read(this.f7664b);
        if (r11 > 0) goto L12;
        return -1;
    L12:
        this.d = r11;
        this.e = 0;
    L13:
        byte[] r12 = this.f7664b;
        int r13 = this.e;
        this.e = r13 + 1;
        return r12[r13] & UByte.MAX_VALUE;
    L16:
        throw new IOException("stream already closed");
    L18:
        throw new IllegalStateException();
    }

    @Override // java.io.InputStream
    public final long skip(long r10) {
        int r5 = this.e;
        int r11 = this.d;
        if (r5 > r11) goto L15;
        if (this.f == true) goto L13;
        long r12 = r11 - r5;
        if (r12 < r10) goto L10;
        this.e = (int) (((long) r5) + r10);
        return r10;
    L10:
        this.e = r11;
        return this.f7663a.skip(r10 - r12) + r12;
    L13:
        throw new IOException("stream already closed");
    L15:
        throw new IllegalStateException();
    }

    @Override // java.io.InputStream
    public final int read(byte[] r5, int r10, int r11) {
        int r12 = this.e;
        int r13 = this.d;
        if (r12 > r13) goto L18;
        if (this.f == true) goto L16;
        if (r12 < r13) goto L13;
        int r14 = this.f7663a.read(this.f7664b);
        if (r14 > 0) goto L12;
        return -1;
    L12:
        this.d = r14;
        this.e = 0;
    L13:
        int r15 = Math.min(this.d - this.e, r11);
        System.arraycopy(this.f7664b, this.e, r5, r10, r15);
        this.e += r15;
        return r15;
    L16:
        throw new IOException("stream already closed");
    L18:
        throw new IllegalStateException();
    }
}
