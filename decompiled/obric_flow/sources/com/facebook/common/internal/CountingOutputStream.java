package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;

/* JADX INFO: loaded from: classes2.dex */
@Nullsafe(Nullsafe.Mode.STRICT)
public class CountingOutputStream extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f7650a;

    public CountingOutputStream(FileOutputStream r5) {
        super(r5);
        this.f7650a = 0;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] r5, int r10, int r11) {
        ((FilterOutputStream) this).out.write(r5, r10, r11);
        this.f7650a += (long) r11;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int r5) {
        ((FilterOutputStream) this).out.write(r5);
        this.f7650a++;
    }
}
