package com.larus.cache;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f$c {
    public final f.d a;
    public final boolean[] b;
    public boolean c;
    public final /* synthetic */ f d;

    public final class a extends FilterOutputStream {
        public final /* synthetic */ f$c a;

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            ((FilterOutputStream) this).out.close();     // Catch: IOException -> L4
            return;
        L4:
            this.a.c = true;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
        public final void flush() {
            ((FilterOutputStream) this).out.flush();     // Catch: IOException -> L4
            return;
        L4:
            this.a.c = true;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(int r2) {
            ((FilterOutputStream) this).out.write(r2);     // Catch: IOException -> L4
            return;
        L4:
            this.a.c = true;
        }

        public a(f$c r1, PolarisFileOutputStreamWrapper r2) {
            this.a = r1;
            super(r2);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(byte[] r2, int r3, int r4) {
            ((FilterOutputStream) this).out.write(r2, r3, r4);     // Catch: IOException -> L4
            return;
        L4:
            this.a.c = true;
        }
    }

    public final void a() throws IOException {
        f.a(this.d, this, false);
    }

    public final OutputStream b() throws IOException {
        f r0 = this.d;
        if (r0.g <= 0) goto L27;
        monitor-enter(r0);
        f.d r1 = this.a;     // Catch: Throwable -> L23
        if (r1.d != this) goto L22;
        if (r1.c == true) goto L10;
        this.b[0] = true;     // Catch: Throwable -> L23
    L10:
        PolarisFileWrapper r2 = r1.b(0);     // Catch: Throwable -> L23
        PolarisFileOutputStreamWrapper r3 = new PolarisFileOutputStreamWrapper(r2);     // Catch: FileNotFoundException -> L13 Throwable -> L23
    L15:
        a r4 = new a(this, r3);     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return r4;
    L13:
        this.d.a.mkdirs();     // Catch: Throwable -> L23
        r3 = new PolarisFileOutputStreamWrapper(r2);     // Catch: FileNotFoundException -> L18 Throwable -> L23
    L20:
        return f.p;
    L22:
        throw new IOException("currentEditor changed");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L27:
        throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + this.d.g);
    }

    public f$c(f r1, f.d r2) {
        this.d = r1;
        this.a = r2;
        if (r2.c == false) goto L5;
        boolean[] r3 = null;
    L6:
        this.b = r3;
        return;
    L5:
        r3 = new boolean[r1.g];
        goto L6
    }
}
