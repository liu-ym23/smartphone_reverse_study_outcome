package com.bumptech.glide.load.data;

import java.io.FileOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class c extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileOutputStream f1422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f1423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.f f1424c;
    public int d;

    public c(FileOutputStream r5, com.bumptech.glide.load.engine.bitmap_recycle.f r10) {
        this.f1422a = r5;
        this.f1424c = r10;
        this.f1423b = (byte[]) r10.c(65536, byte[].class);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        FileOutputStream r5 = this.f1422a;
        flush();     // Catch: Throwable -> L8
        r5.close();
        byte[] r10 = this.f1423b;
        if (r10 == null) goto L13;
        this.f1424c.h(r10);
        this.f1423b = null;
        return;
    L13:
        return;
    L8:
        th = move-exception;
        r5.close();
        throw th;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        int r5 = this.d;
        FileOutputStream r10 = this.f1422a;
        if (r5 <= 0) goto L5;
        r10.write(this.f1423b, 0, r5);
        this.d = 0;
    L5:
        r10.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int r5) {
        byte[] r10 = this.f1423b;
        int r11 = this.d;
        int r12 = r11 + 1;
        this.d = r12;
        r10[r11] = (byte) r5;
        if (r12 != r10.length) goto L7;
        if (r12 <= 0) goto L8;
        this.f1422a.write(r10, 0, r12);
        this.d = 0;
        return;
    L8:
        return;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r5) {
        write(r5, 0, r5.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r10, int r11, int r12) {
        int r5 = 0;
    L3:
        int r13 = r12 - r5;
        int r14 = r11 + r5;
        int r15 = this.d;
        FileOutputStream r16 = this.f1422a;
        if (r15 == 0) goto L6;
    L9:
        int r17 = Math.min(r13, this.f1423b.length - r15);
        System.arraycopy(r10, r14, this.f1423b, this.d, r17);
        int r18 = this.d + r17;
        this.d = r18;
        r5 = r5 + r17;
        byte[] r19 = this.f1423b;
        if (r18 != r19.length) goto L13;
        if (r18 <= 0) goto L13;
        r16.write(r19, 0, r18);
        this.d = 0;
    L13:
        if (r5 < r12) goto L3;
        return;
    L6:
        if (r13 < this.f1423b.length) goto L9;
        r16.write(r10, r14, r13);
    }
}
