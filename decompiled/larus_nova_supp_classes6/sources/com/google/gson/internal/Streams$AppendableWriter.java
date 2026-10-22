package com.google.gson.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class Streams$AppendableWriter extends Writer {
    private final Appendable appendable;
    private final CurrentWrite currentWrite;

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public Streams$AppendableWriter(Appendable r3) {
        this.currentWrite = new CurrentWrite(null);
        this.appendable = r3;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence r2) throws IOException {
        this.appendable.append(r2);
        return this;
    }

    @Override // java.io.Writer
    public void write(int r2) throws IOException {
        this.appendable.append((char) r2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r1) throws IOException {
        return append(r1);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence r2, int r3, int r4) throws IOException {
        this.appendable.append(r2, r3, r4);
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] r2, int r3, int r4) throws IOException {
        this.currentWrite.setChars(r2);
        this.appendable.append(this.currentWrite, r3, r4 + r3);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r1, int r2, int r3) throws IOException {
        return append(r1, r2, r3);
    }

    @Override // java.io.Writer
    public void write(String r2, int r3, int r4) throws IOException {
        Objects.requireNonNull(r2);
        this.appendable.append(r2, r3, r4 + r3);
    }
}
