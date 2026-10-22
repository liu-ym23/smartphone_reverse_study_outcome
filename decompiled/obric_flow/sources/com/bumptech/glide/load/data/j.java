package com.bumptech.glide.load.data;

import ai.j0;
import java.io.FilterInputStream;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class j extends FilterInputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f1429c = null;
    public static final int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f1430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1431b;

    static {
        f1429c = new byte[]{-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        d = 31;
    }

    public j(InputStream r5, int r10) {
        super(r5);
        if (r10 < (-1)) goto L9;
        if (r10 > 8) goto L9;
        this.f1430a = (byte) r10;
        return;
    L9:
        throw new IllegalArgumentException(j0.g(r10, "Cannot add invalid orientation: "));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int r5 = this.f1431b;
        if (r5 < 2) goto L10;
        int r10 = d;
        if (r5 > r10) goto L10;
        if (r5 != r10) goto L9;
        int r11 = this.f1430a;
    L12:
        if (r11 == (-1)) goto L14;
        this.f1431b++;
    L14:
        return r11;
    L9:
        r11 = f1429c[r5 - 2] & UByte.MAX_VALUE;
    L10:
        r11 = super.read();
        goto L12
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long r5) {
        long r10 = super.skip(r5);
        if (r10 <= 0) goto L5;
        this.f1431b = (int) (((long) this.f1431b) + r10);
    L5:
        return r10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r5, int r10, int r11) {
        int r12 = this.f1431b;
        int r13 = d;
        if (r12 <= r13) goto L5;
        int r14 = super.read(r5, r10, r11);
    L11:
        if (r14 <= 0) goto L13;
        this.f1431b += r14;
    L13:
        return r14;
    L5:
        if (r12 != r13) goto L8;
        r5[r10] = this.f1430a;
        r14 = 1;
        goto L11
    L8:
        if (r12 >= 2) goto L10;
        r14 = super.read(r5, r10, 2 - r12);
        goto L11
    L10:
        int r15 = Math.min(r13 - r12, r11);
        System.arraycopy(f1429c, this.f1431b - 2, r5, r10, r15);
        r14 = r15;
        goto L11
    }
}
