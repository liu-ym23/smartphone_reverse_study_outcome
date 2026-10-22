package com.larus.audio.utils;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b1 implements Closeable {
    public final InputStream a;
    public final Charset b;
    public byte[] c;
    public int d;
    public int e;

    public class a extends ByteArrayOutputStream {
        public final /* synthetic */ b1 a;

        @Override // java.io.ByteArrayOutputStream
        public final String toString() {
            int r0 = ((ByteArrayOutputStream) this).count;
            if (r0 > 0) goto L5;
        L12:
            return new String(((ByteArrayOutputStream) this).buf, 0, r0, this.a.b.name());
        L9:
            e = move-exception;
            throw new AssertionError(e);
        L5:
            if (((ByteArrayOutputStream) this).buf[r0 - 1] != 13) goto L12;
            r0 = r0 - 1;
            goto L12
        }

        public a(b1 r1, int r2) {
            this.a = r1;
            super(r2);
        }
    }

    public final String a() throws IOException {
        InputStream r0 = this.a;
        monitor-enter(r0);
        byte[] r1 = this.c;     // Catch: Throwable -> L47
        if (r1 == null) goto L46;
        if (this.d < this.e) goto L13;
        int r2 = this.a.read(r1, 0, r1.length);     // Catch: Throwable -> L47
        if (r2 == (-1)) goto L12;
        this.d = 0;     // Catch: Throwable -> L47
        this.e = r2;     // Catch: Throwable -> L47
        goto L13
    L12:
        throw new EOFException();     // Catch: Throwable -> L47
    L13:
        int r3 = this.d;     // Catch: Throwable -> L47
    L15:
        if (r3 == this.e) goto L28;
        byte[] r4 = this.c;     // Catch: Throwable -> L47
        if (r4[r3] == 10) goto L18;
        r3 = r3 + 1;     // Catch: Throwable -> L47
        goto L15
    L18:
        int r5 = this.d;     // Catch: Throwable -> L47
        if (r3 == r5) goto L23;
        int r6 = r3 - 1;     // Catch: Throwable -> L47
        if (r4[r6] != 13) goto L23;
    L24:
        String r7 = new String(r4, r5, r6 - r5, this.b.name());     // Catch: Throwable -> L47
        this.d = r3 + 1;     // Catch: Throwable -> L47
        monitor-exit(r0);     // Catch: Throwable -> L47
        return r7;
    L23:
        r6 = r3;
        goto L24
    L28:
        a r8 = new a(this, (this.e - this.d) + 80);     // Catch: Throwable -> L47
    L29:
        byte[] r9 = this.c;     // Catch: Throwable -> L47
        int r10 = this.d;     // Catch: Throwable -> L47
        r8.write(r9, r10, this.e - r10);     // Catch: Throwable -> L47
        this.e = -1;     // Catch: Throwable -> L47
        InputStream r11 = this.a;     // Catch: Throwable -> L47
        byte[] r12 = this.c;     // Catch: Throwable -> L47
        int r13 = r11.read(r12, 0, r12.length);     // Catch: Throwable -> L47
        if (r13 == (-1)) goto L44;
        this.d = 0;     // Catch: Throwable -> L47
        this.e = r13;     // Catch: Throwable -> L47
        int r14 = 0;
    L33:
        if (r14 == this.e) goto L29;
        byte[] r15 = this.c;     // Catch: Throwable -> L47
        if (r15[r14] == 10) goto L36;
        r14 = r14 + 1;     // Catch: Throwable -> L47
        goto L33
    L36:
        int r16 = this.d;     // Catch: Throwable -> L47
        if (r14 == r16) goto L39;
        r8.write(r15, r16, r14 - r16);     // Catch: Throwable -> L47
    L39:
        this.d = r14 + 1;     // Catch: Throwable -> L47
        String r17 = r8.toString();     // Catch: Throwable -> L47
        monitor-exit(r0);     // Catch: Throwable -> L47
        return r17;
    L44:
        throw new EOFException();     // Catch: Throwable -> L47
    L46:
        throw new IOException("LineReader is closed");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        InputStream r0 = this.a;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.c == null) goto L7;
        this.c = null;     // Catch: Throwable -> L9
        this.a.close();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public b1(PolarisFileInputStreamWrapper r2, Charset r3) {
        if (r3 == null) goto L11;
        if (r3.equals(StandardCharsets.US_ASCII) == false) goto L9;
        this.a = r2;
        this.b = r3;
        this.c = new byte[8192];
        return;
    L9:
        throw new IllegalArgumentException("Unsupported encoding");
    L11:
        throw null;
    }
}
