package org.apache.poi.openxml4j.opc.internal;

import java.io.OutputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;

/* JADX INFO: loaded from: classes7.dex */
public final class MemoryPackagePartOutputStream extends OutputStream {
    private final UnsynchronizedByteArrayOutputStream _buff;
    private final MemoryPackagePart _part;

    public MemoryPackagePartOutputStream(MemoryPackagePart r1) {
        this._part = r1;
        this._buff = new UnsynchronizedByteArrayOutputStream();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        flush();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this._buff.flush();
        if (this._part.data == null) goto L5;
        byte[] r0 = new byte[this._part.data.length + this._buff.size()];
        System.arraycopy(this._part.data, 0, r0, 0, this._part.data.length);
        byte[] r1 = this._buff.toByteArray();
        System.arraycopy(r1, 0, r0, this._part.data.length, r1.length);
        this._part.data = r0;
    L6:
        this._buff.reset();
        return;
    L5:
        MemoryPackagePart r2 = this._part;
        r2.data = this._buff.toByteArray();
        goto L6
    }

    @Override // java.io.OutputStream
    public void write(int r1) {
        this._buff.write(r1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r1) {
        this._buff.write(r1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r1, int r2, int r3) {
        this._buff.write(r1, r2, r3);
    }
}
