package jf;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f8862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f8863b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8864m;

    public class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f8865a;

        public a(q r8) {
            this.f8865a = r8;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.f8865a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public final void flush() {
            q r8 = this.f8865a;
            if (r8.f8864m == true) goto L6;
            r8.flush();
            return;
        }

        public final String toString() {
            return this.f8865a + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public final void write(int r8) {
            q r10 = this.f8865a;
            if (r10.f8864m == true) goto L7;
            r10.f8862a.G((byte) r8);
            r10.a();
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // java.io.OutputStream
        public final void write(byte[] r8, int r10, int r11) {
            q r12 = this.f8865a;
            if (r12.f8864m == true) goto L7;
            r12.f8862a.D(r10, r11, r8);
            r12.a();
            return;
        L7:
            throw new IOException("closed");
        }
    }

    public q(v r8) {
        this.f8862a = new d();
        if (r8 == null) goto L7;
        this.f8863b = r8;
        return;
    L7:
        throw new NullPointerException("sink == null");
    }

    @Override // jf.e
    public final e N(long r8) {
        if (this.f8864m == true) goto L7;
        this.f8862a.H(r8);
        a();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // jf.e
    public final e T(int r8) {
        if (this.f8864m == true) goto L7;
        d r10 = this.f8862a;
        r10.getClass();
        Charset r11 = y.f8885a;
        int r12 = ((((-16777216) & r8) >>> 24) | ((16711680 & r8) >>> 8)) | ((65280 & r8) << 8);
        r10.J(((r8 & 255) << 24) | r12);
        a();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // jf.e
    public final long X(w r8) {
        long r10 = 0;
    L3:
        long r11 = ((n) r8).u(this.f8862a, 8192);
        if (r11 == (-1)) goto L6;
        r10 = r10 + r11;
        a();
        goto L3
    L6:
        return r10;
    }

    public final e a() {
        if (this.f8864m == true) goto L9;
        d r8 = this.f8862a;
        long r10 = r8.i();
        if (r10 <= 0) goto L7;
        this.f8863b.write(r8, r10);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed");
    }

    @Override // jf.e
    public final d b() {
        return this.f8862a;
    }

    @Override // jf.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        v r8 = this.f8863b;
        if (this.f8864m == false) goto L20;
        return;
    L20:
        d r10 = this.f8862a;     // Catch: Throwable -> L9
        long r11 = r10.f8830b;     // Catch: Throwable -> L9
        if (r11 <= 0) goto L8;
        r8.write(r10, r11);     // Catch: Throwable -> L9
    L8:
        th = null;
    L22:
        r8.close();     // Catch: Throwable -> L12
    L15:
        this.f8864m = true;
        if (th != null) goto L18;
        return;
    L18:
        Charset r12 = y.f8885a;
        throw th;
    L12:
        th = move-exception;
        if (th != null) goto L15;
        th = th;
    L9:
        th = th;
        goto L22
    }

    @Override // jf.e
    public final e d0(long r8) {
        if (this.f8864m == true) goto L7;
        this.f8862a.I(r8);
        a();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // jf.e
    public final e f() {
        if (this.f8864m == true) goto L9;
        d r8 = this.f8862a;
        long r10 = r8.f8830b;
        if (r10 <= 0) goto L7;
        this.f8863b.write(r8, r10);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed");
    }

    @Override // jf.e, jf.v, java.io.Flushable
    public final void flush() {
        if (this.f8864m == true) goto L10;
        d r8 = this.f8862a;
        long r10 = r8.f8830b;
        v r11 = this.f8863b;
        if (r10 <= 0) goto L7;
        r11.write(r8, r10);
    L7:
        r11.flush();
        return;
    L10:
        throw new IllegalStateException("closed");
    }

    @Override // jf.e
    public final e h(long r8) {
        if (this.f8864m == true) goto L7;
        d r10 = this.f8862a;
        r10.getClass();
        r10.K(y.b(r8));
        a();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f8864m;
    }

    @Override // jf.e
    public final e l0(int r8, int r10, byte[] r11) {
        if (this.f8864m == true) goto L7;
        this.f8862a.D(r8, r10, r11);
        a();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // jf.e
    public final OutputStream n0() {
        return new a(this);
    }

    @Override // jf.e
    public final e p(String r8) {
        if (this.f8864m == true) goto L7;
        d r10 = this.f8862a;
        r10.getClass();
        r10.c0(0, r8.length(), r8);
        a();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // jf.e
    public final e s(g r8) {
        if (this.f8864m == true) goto L7;
        this.f8862a.E(r8);
        a();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // jf.v
    public final x timeout() {
        return this.f8863b.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f8863b + ")";
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer r8) {
        if (this.f8864m == true) goto L7;
        int r10 = this.f8862a.write(r8);
        a();
        return r10;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // jf.e
    public final e writeByte(int r8) {
        if (this.f8864m == true) goto L7;
        this.f8862a.G(r8);
        a();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // jf.e
    public final e writeInt(int r8) {
        if (this.f8864m == true) goto L7;
        this.f8862a.J(r8);
        a();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // jf.e
    public final e writeShort(int r8) {
        if (this.f8864m == true) goto L7;
        this.f8862a.V(r8);
        a();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // jf.e
    public final e write(byte[] r8) {
        if (this.f8864m == true) goto L7;
        this.f8862a.m15write(r8);
        a();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // jf.v
    public final void write(d r8, long r10) {
        if (this.f8864m == true) goto L7;
        this.f8862a.write(r8, r10);
        a();
        return;
    L7:
        throw new IllegalStateException("closed");
    }
}
