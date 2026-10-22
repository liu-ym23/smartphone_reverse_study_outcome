package com.bytedance.crash.upload;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4102b;

    public c(OutputStream r5) {
        super(r5);
        this.f4101a = 0;
        this.f4102b = 0;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int r5) {
        this.f4101a++;
        ((FilterOutputStream) this).out.write(r5);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] r5, int r10, int r11) {
        this.f4101a += (long) r11;
        ((FilterOutputStream) this).out.write(r5, r10, r11);
    }
}
