package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class LimitedInputStream extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7688b;

    public LimitedInputStream(InputStream r5, int r10) {
        super(r5);
        if (r10 < 0) goto L7;
        this.f7687a = r10;
        this.f7688b = -1;
        return;
    L7:
        throw new IllegalArgumentException("limit must be >= 0");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        return Math.min(((FilterInputStream) this).in.available(), this.f7687a);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int r5) {
        if (((FilterInputStream) this).in.markSupported() == false) goto L6;
        ((FilterInputStream) this).in.mark(r5);
        this.f7688b = this.f7687a;
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        if (this.f7687a != 0) goto L5;
        return -1;
    L5:
        int r5 = ((FilterInputStream) this).in.read();
        if (r5 == (-1)) goto L8;
        this.f7687a--;
    L8:
        return r5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        if (((FilterInputStream) this).in.markSupported() == false) goto L11;
        if (this.f7688b == (-1)) goto L9;
        ((FilterInputStream) this).in.reset();
        this.f7687a = this.f7688b;
        return;
    L9:
        throw new IOException("mark not set");
    L11:
        throw new IOException("mark is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long r5) {
        long r10 = ((FilterInputStream) this).in.skip(Math.min(r5, this.f7687a));
        this.f7687a = (int) (((long) this.f7687a) - r10);
        return r10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r5, int r10, int r11) {
        int r12 = this.f7687a;
        if (r12 != 0) goto L6;
        return -1;
    L6:
        int r13 = ((FilterInputStream) this).in.read(r5, r10, Math.min(r11, r12));
        if (r13 <= 0) goto L9;
        this.f7687a -= r13;
    L9:
        return r13;
    }
}
