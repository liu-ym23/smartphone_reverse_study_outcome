package jf;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f8866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f8867b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8868m;

    public class a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f8869a;

        public a(r r8) {
            this.f8869a = r8;
        }

        @Override // java.io.InputStream
        public final int available() {
            r r8 = this.f8869a;
            if (r8.f8868m == true) goto L7;
            return (int) Math.min(r8.f8866a.f8830b, 2147483647L);
        L7:
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.f8869a.close();
        }

        @Override // java.io.InputStream
        public final int read() {
            r r8 = this.f8869a;
            if (r8.f8868m == true) goto L13;
            d r10 = r8.f8866a;
            if (r10.f8830b != 0) goto L11;
            if (r8.f8867b.u(r10, 8192) != (-1)) goto L11;
            return -1;
        L11:
            return r8.f8866a.readByte() & 255;
        L13:
            throw new IOException("closed");
        }

        public final String toString() {
            return this.f8869a + ".inputStream()";
        }

        @Override // java.io.InputStream
        public final int read(byte[] r8, int r10, int r11) {
            r r12 = this.f8869a;
            if (r12.f8868m == true) goto L13;
            y.a(r8.length, r10, r11);
            d r13 = r12.f8866a;
            if (r13.f8830b != 0) goto L11;
            if (r12.f8867b.u(r13, 8192) != (-1)) goto L11;
            return -1;
        L11:
            return r12.f8866a.read(r8, r10, r11);
        L13:
            throw new IOException("closed");
        }
    }

    public r(w r8) {
        this.f8866a = new d();
        if (r8 == null) goto L7;
        this.f8867b = r8;
        return;
    L7:
        throw new NullPointerException("source == null");
    }

    @Override // jf.f
    public final long F() {
        L(8);
        return this.f8866a.F();
    }

    @Override // jf.f
    public final void L(long r8) {
        if (i(r8) == false) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // jf.f
    public final String P(long r8) {
        L(r8);
        return this.f8866a.P(r8);
    }

    @Override // jf.f
    public final g Q(long r8) {
        L(r8);
        return this.f8866a.Q(r8);
    }

    @Override // jf.f
    public final boolean U() {
        if (this.f8868m == true) goto L12;
        d r8 = this.f8866a;
        if (r8.U() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.f8867b.u(r8, 8192) != (-1)) goto L9;
        return true;
    L12:
        throw new IllegalStateException("closed");
    }

    public final long a(byte r10, long r11, long r13) {
        if (this.f8868m == true) goto L21;
        long r12 = 0;
        if (r13 < 0) goto L19;
    L7:
        if (r12 >= r13) goto L17;
        long r8 = this.f8866a.r(r10, r12, r13);
        if (r8 != (-1)) goto L10;
        d r14 = this.f8866a;
        long r15 = r14.f8830b;
        if (r15 >= r13) goto L17;
        if (this.f8867b.u(r14, 8192) == (-1)) goto L17;
        r12 = Math.max(r12, r15);
        goto L7
    L10:
        return r8;
    L17:
        return -1;
    L19:
        throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{0L, Long.valueOf(r13)}));
    L21:
        throw new IllegalStateException("closed");
    }

    @Override // jf.f, jf.e
    public final d b() {
        return this.f8866a;
    }

    @Override // jf.f
    public final String b0(Charset r8) {
        if (r8 == null) goto L6;
        w r10 = this.f8867b;
        d r11 = this.f8866a;
        r11.X(r10);
        return r11.b0(r8);
    L6:
        throw new IllegalArgumentException("charset == null");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.f8868m == false) goto L5;
        return;
    L5:
        this.f8868m = true;
        this.f8867b.close();
        this.f8866a.a();
    }

    @Override // jf.f
    public final void d(d r8, long r10) {
        d r11 = this.f8866a;
        L(r10);     // Catch: EOFException -> L6
        r11.d(r8, r10);
        return;
    L6:
        e = move-exception;
        r8.X(r11);
        throw e;
    }

    public final boolean i(long r8) {
        if (r8 < 0) goto L17;
        if (this.f8868m == true) goto L15;
    L6:
        d r10 = this.f8866a;
        if (r10.f8830b >= r8) goto L12;
        if (this.f8867b.u(r10, 8192) != (-1)) goto L6;
        return false;
    L12:
        return true;
    L15:
        throw new IllegalStateException("closed");
    L17:
        throw new IllegalArgumentException(android.aimedia.a.d("byteCount < 0: ", r8));
    }

    @Override // jf.f
    public final int i0() {
        L(4);
        return this.f8866a.i0();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f8868m;
    }

    @Override // jf.f
    public final boolean j(g r8) {
        byte[] r10 = r8.f8842a;
        int r11 = r10.length;
        if (this.f8868m == true) goto L21;
        if (r11 >= 0) goto L7;
        return false;
    L7:
        if ((r10.length - 0) < r11) goto L26;
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L18;
        long r13 = ((long) r12) + 0;
        if (i(1 + r13) == false) goto L27;
        if (this.f8866a.n(r13) != r8.f8842a[0 + r12]) goto L28;
        r12 = r12 + 1;
        goto L10
    L28:
        return false;
    L27:
        return false;
    L18:
        return true;
    L26:
        return false;
    L21:
        throw new IllegalStateException("closed");
    }

    @Override // jf.f
    public final String l(long r22) {
        if (r22 < 0) goto L27;
        if (r22 != Long.MAX_VALUE) goto L7;
        long r13 = Long.MAX_VALUE;
    L8:
        long r8 = a((byte) 10, 0, r13);
        d r10 = this.f8866a;
        if (r8 == (-1)) goto L13;
        return r10.B(r8);
    L13:
        if (r13 < Long.MAX_VALUE) goto L15;
    L24:
        d r11 = new d();
        r10.k(r11, 0, Math.min(32, r10.f8830b));
        throw new EOFException("\\n not found: limit=" + Math.min(r10.f8830b, r22) + " content=" + r11.x().f() + 8230);
    L15:
        if (i(r13) == false) goto L24;
        if (r10.n(r13 - 1) != 13) goto L24;
        if (i(1 + r13) == false) goto L24;
        if (r10.n(r13) != 10) goto L24;
        return r10.B(r13);
    L7:
        r13 = r22 + 1;
        goto L8
    L27:
        throw new IllegalArgumentException(android.aimedia.a.d("limit < 0: ", r22));
    }

    @Override // jf.f
    public final long o0() {
        L(1);
        int r8 = 0;
    L3:
        int r10 = r8 + 1;
        boolean r11 = i(r10);
        d r12 = this.f8866a;
        if (r11 == false) goto L24;
        byte r13 = r12.n(r8);
        if (r13 < 48) goto L10;
        if (r13 > 57) goto L10;
    L18:
        r8 = r10;
    L10:
        if (r13 < 97) goto L14;
        if (r13 <= 102) goto L18;
    L14:
        if (r13 < 65) goto L19;
        if (r13 <= 70) goto L18;
    L19:
        if (r8 != 0) goto L24;
        throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(r13)}));
    L24:
        return r12.o0();
    }

    @Override // jf.f
    public final InputStream p0() {
        return new a(this);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer r8) {
        d r10 = this.f8866a;
        if (r10.f8830b != 0) goto L9;
        if (this.f8867b.u(r10, 8192) != (-1)) goto L9;
        return -1;
    L9:
        return r10.read(r8);
    }

    @Override // jf.f
    public final byte readByte() {
        L(1);
        return this.f8866a.readByte();
    }

    @Override // jf.f
    public final void readFully(byte[] r8) {
        d r10 = this.f8866a;
        L(r8.length);     // Catch: EOFException -> L6
        r10.readFully(r8);
        return;
    L6:
        e = move-exception;
        int r11 = 0;
    L8:
        long r12 = r10.f8830b;
        if (r12 <= 0) goto L15;
        int r13 = r10.read(r8, r11, (int) r12);
        if (r13 == (-1)) goto L14;
        r11 = r11 + r13;
        goto L8
    L14:
        throw new AssertionError();
    L15:
        throw e;
    }

    @Override // jf.f
    public final int readInt() {
        L(4);
        return this.f8866a.readInt();
    }

    @Override // jf.f
    public final long readLong() {
        L(8);
        return this.f8866a.readLong();
    }

    @Override // jf.f
    public final short readShort() {
        L(2);
        return this.f8866a.readShort();
    }

    @Override // jf.f
    public final void skip(long r8) {
        if (this.f8868m == true) goto L16;
    L5:
        if (r8 <= 0) goto L14;
        d r10 = this.f8866a;
        if (r10.f8830b != 0) goto L13;
        if (this.f8867b.u(r10, 8192) != (-1)) goto L13;
        throw new EOFException();
    L13:
        long r11 = Math.min(r8, r10.f8830b);
        r10.skip(r11);
        r8 = r8 - r11;
        goto L5
    L14:
        return;
    L16:
        throw new IllegalStateException("closed");
    }

    @Override // jf.w
    public final x timeout() {
        return this.f8867b.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f8867b + ")";
    }

    @Override // jf.w
    public final long u(d r8, long r10) {
        if (r8 == null) goto L19;
        if (r10 < 0) goto L17;
        if (this.f8868m == true) goto L15;
        d r11 = this.f8866a;
        if (r11.f8830b != 0) goto L13;
        if (this.f8867b.u(r11, 8192) != (-1)) goto L13;
        return -1;
    L13:
        return r11.u(r8, Math.min(r10, r11.f8830b));
    L15:
        throw new IllegalStateException("closed");
    L17:
        throw new IllegalArgumentException(android.aimedia.a.d("byteCount < 0: ", r10));
    L19:
        throw new IllegalArgumentException("sink == null");
    }

    @Override // jf.f
    public final String y() {
        return l(Long.MAX_VALUE);
    }
}
