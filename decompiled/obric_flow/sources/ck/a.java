package ck;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream[] f1211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1212b;

    public a(InputStream[] r5) {
        if (r5.length < 2) goto L7;
        this.f1211a = r5;
        this.f1212b = 0;
        return;
    L7:
        throw new IllegalArgumentException("Streams must be non-null and have more than 1 entry");
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f1211a[this.f1212b].available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int r5 = this.f1212b;
        IOException r10 = null;
        int r11 = 0;
    L3:
        InputStream[] r12 = this.f1211a;
        if (r11 >= r12.length) goto L17;
        r12[r11].close();     // Catch: IOException -> L7
    L16:
        r11 = r11 + 1;
    L7:
        e = e;
        if (r11 == r5) goto L12;
        if (r10 == null) goto L12;
        e = r10;
    L12:
        if (r10 == null) goto L15;
        if (r10 == e) goto L15;
        Log.w("CompositeInputStream", "Suppressing exception", r10);
    L15:
        r10 = e;
        goto L16
    }

    @Override // java.io.InputStream
    public final void mark(int r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r5) {
        return read(r5, 0, r5.length);
    }

    @Override // java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public final long skip(long r5) {
        int r10 = (int) r5;
        int r11 = read(new byte[r10], 0, r10);
        if (r11 >= 0) goto L5;
        return -1;
    L5:
        return r11;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r5, int r10, int r11) {
    L2:
        int r12 = this.f1212b;
        InputStream[] r13 = this.f1211a;
        int r14 = r13[r12].read(r5, r10, r11);
        if (r14 != (-1)) goto L7;
        int r15 = this.f1212b + 1;
        if (r15 >= r13.length) goto L7;
        this.f1212b = r15;
    L7:
        return r14;
    }

    @Override // java.io.InputStream
    public final int read() {
    L2:
        int r5 = this.f1212b;
        InputStream[] r10 = this.f1211a;
        int r11 = r10[r5].read();
        if (r11 != (-1)) goto L7;
        int r12 = this.f1212b + 1;
        if (r12 >= r10.length) goto L7;
        this.f1212b = r12;
    L7:
        return r11;
    }
}
