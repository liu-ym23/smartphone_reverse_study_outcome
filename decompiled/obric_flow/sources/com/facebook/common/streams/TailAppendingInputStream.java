package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class TailAppendingInputStream extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f7689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7691c;

    public TailAppendingInputStream(InputStream r5, byte[] r10) {
        super(r5);
        this.f7689a = r10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int r5) {
        if (((FilterInputStream) this).in.markSupported() == false) goto L6;
        super.mark(r5);
        this.f7691c = this.f7690b;
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int r5 = ((FilterInputStream) this).in.read();
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = this.f7690b;
        byte[] r11 = this.f7689a;
        if (r10 < r11.length) goto L8;
        return -1;
    L8:
        this.f7690b = r10 + 1;
        return r11[r10] & UByte.MAX_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        if (((FilterInputStream) this).in.markSupported() == false) goto L7;
        ((FilterInputStream) this).in.reset();
        this.f7690b = this.f7691c;
        return;
    L7:
        throw new IOException("mark is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r5) {
        return read(r5, 0, r5.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r10, int r11, int r12) {
        int r5 = ((FilterInputStream) this).in.read(r10, r11, r12);
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r13 = 0;
        if (r12 != 0) goto L8;
        return 0;
    L8:
        if (r13 >= r12) goto L16;
        int r14 = this.f7690b;
        byte[] r15 = this.f7689a;
        if (r14 < r15.length) goto L12;
        int r16 = -1;
    L13:
        if (r16 == (-1)) goto L16;
        r10[r11 + r13] = (byte) r16;
        r13 = r13 + 1;
        goto L8
    L12:
        this.f7690b = r14 + 1;
        r16 = r15[r14] & UByte.MAX_VALUE;
    L16:
        if (r13 <= 0) goto L18;
        return r13;
    L18:
        return -1;
    }
}
