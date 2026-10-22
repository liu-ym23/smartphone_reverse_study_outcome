package nu;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f20349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f20351c;

    public x(c0 r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        this.f20351c = r5;
        this.f20349a = new j();
    }

    @Override // nu.l
    public final String A(Charset r5) {
        Intrinsics.checkNotNullParameter(r5, "charset");
        c0 r10 = this.f20351c;
        j r11 = this.f20349a;
        r11.G(r10);
        return r11.A(r5);
    }

    @Override // nu.l
    public final ByteString C() {
        c0 r5 = this.f20351c;
        j r10 = this.f20349a;
        r10.G(r5);
        return r10.v(r10.f20328b);
    }

    @Override // nu.l
    public final int D(u r10) {
        Intrinsics.checkNotNullParameter(r10, "options");
        if (this.f20350b == true) goto L14;
    L4:
        j r5 = this.f20349a;
        int r11 = ou.a.b(r5, r10, true);
        if (r11 != (-2)) goto L6;
        if (this.f20351c.read(r5, 8192) != (-1)) goto L4;
    L18:
        return -1;
    L6:
        if (r11 == (-1)) goto L18;
        r5.skip(r10.f20341a[r11].size());
        return r11;
    L14:
        throw new IllegalStateException("closed");
    }

    @Override // nu.l
    public final int E() {
        s(4);
        return this.f20349a.E();
    }

    @Override // nu.l
    public final long H() {
        s(1);
        int r5 = 0;
    L3:
        int r10 = r5 + 1;
        boolean r11 = request(r10);
        j r12 = this.f20349a;
        if (r11 == false) goto L24;
        byte r13 = r12.m(r5);
        if (r13 < ((byte) 48)) goto L10;
        if (r13 > ((byte) 57)) goto L10;
    L18:
        r5 = r10;
    L10:
        if (r13 < ((byte) 97)) goto L14;
        if (r13 <= ((byte) 102)) goto L18;
    L14:
        if (r13 < ((byte) 65)) goto L19;
        if (r13 <= ((byte) 70)) goto L18;
    L19:
        if (r5 != 0) goto L24;
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toString(r13, CharsKt.checkRadix(CharsKt.checkRadix(16))));
    L24:
        return r12.H();
    }

    @Override // nu.l
    public final InputStream I() {
        return new h(this, 1);
    }

    @Override // nu.l
    public final void a(j r5, long r10) {
        j r11 = this.f20349a;
        Intrinsics.checkNotNullParameter(r5, "sink");
        s(r10);     // Catch: EOFException -> L6
        r11.a(r5, r10);
        return;
    L6:
        e = move-exception;
        r5.G(r11);
        throw e;
    }

    public final long b(byte r10, long r11, long r13) {
        if (this.f20350b == true) goto L21;
        long r12 = 0;
        if (r13 < 0) goto L19;
    L7:
        if (r12 >= r13) goto L26;
        j r5 = this.f20349a;
        long r14 = r5.n(r10, r12, r13);
        if (r14 != (-1)) goto L17;
        long r15 = r5.f20328b;
        if (r15 >= r13) goto L27;
        if (this.f20351c.read(r5, 8192) == (-1)) goto L28;
        r12 = Math.max(r12, r15);
        goto L7
    L28:
        return -1;
    L27:
        return -1;
    L17:
        return r14;
    L26:
        return -1;
    L19:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r13, "fromIndex=0 toIndex=").toString());
    L21:
        throw new IllegalStateException("closed");
    }

    @Override // nu.l
    public final String c(long r23) {
        if (r23 < 0) goto L26;
        if (r23 != Long.MAX_VALUE) goto L7;
        long r13 = Long.MAX_VALUE;
    L8:
        byte r15 = (byte) 10;
        long r5 = b(r15, 0, r13);
        j r10 = this.f20349a;
        if (r5 == (-1)) goto L12;
        return ou.a.a(r10, r5);
    L12:
        if (r13 < Long.MAX_VALUE) goto L14;
    L23:
        j r11 = new j();
        r10.g(0, r11, Math.min(32, r10.f20328b));
        throw new EOFException("\\n not found: limit=" + Math.min(r10.f20328b, r23) + " content=" + r11.v(r11.f20328b).hex() + "…");
    L14:
        if (request(r13) == false) goto L23;
        if (r10.m(r13 - 1) != ((byte) 13)) goto L23;
        if (request(1 + r13) == false) goto L23;
        if (r10.m(r13) != r15) goto L23;
        return ou.a.a(r10, r13);
    L7:
        r13 = r23 + 1;
        goto L8
    L26:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r23, "limit < 0: ").toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.f20350b == true) goto L7;
        this.f20350b = true;
        this.f20351c.close();
        this.f20349a.b();
        return;
    }

    public final long d(ByteString r11) {
        Intrinsics.checkNotNullParameter(r11, "targetBytes");
        Intrinsics.checkNotNullParameter(r11, "targetBytes");
        if (this.f20350b == true) goto L14;
        long r5 = 0;
    L5:
        j r10 = this.f20349a;
        long r12 = r10.q(r11, r5);
        if (r12 != (-1)) goto L17;
        long r13 = r10.f20328b;
        if (this.f20351c.read(r10, 8192) == (-1)) goto L11;
        r5 = Math.max(r5, r13);
        goto L5
    L11:
        return -1;
    L17:
        return r12;
    L14:
        throw new IllegalStateException("closed");
    }

    public final long e() {
        s(1);
        long r5 = 0;
    L3:
        long r10 = r5 + 1;
        boolean r11 = request(r10);
        j r12 = this.f20349a;
        if (r11 == false) goto L20;
        byte r13 = r12.m(r5);
        if (r13 < ((byte) 48)) goto L10;
        if (r13 > ((byte) 57)) goto L10;
    L14:
        r5 = r10;
    L10:
        if (r5 != 0) goto L15;
        if (r13 == ((byte) 45)) goto L14;
    L15:
        if (r5 != 0) goto L20;
        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toString(r13, CharsKt.checkRadix(CharsKt.checkRadix(16))));
    L20:
        if (r12.f20328b == 0) goto L61;
        int r15 = 0;
        long r14 = 0;
        long r16 = -7;
        boolean r17 = false;
        boolean r18 = false;
    L22:
        y r19 = r12.f20327a;
        Intrinsics.checkNotNull(r19);
        byte[] r20 = r19.f20352a;
        int r21 = r19.f20353b;
        int r110 = r19.f20354c;
    L23:
        if (r21 >= r110) goto L49;
        byte r111 = r20[r21];
        byte r112 = (byte) 48;
        if (r111 < r112) goto L41;
        if (r111 > ((byte) 57)) goto L41;
        int r113 = r112 - r111;
        if (r14 < (-922337203685477580L)) goto L35;
        if (r14 == (-922337203685477580L)) goto L32;
    L34:
        r14 = (r14 * 10) + ((long) r113);
    L44:
        r21 = r21 + 1;
        r15 = r15 + 1;
        goto L23
    L32:
        if (r113 >= r16) goto L34;
    L35:
        j r114 = new j();
        r114.U(r14);
        r114.T(r111);
        if (r17 == true) goto L39;
        r114.readByte();
    L39:
        throw new NumberFormatException("Number too large: ".concat(r114.M()));
    L41:
        if (r111 != ((byte) 45)) goto L45;
        if (r15 != 0) goto L45;
        r16 = r16 - 1;
        r17 = true;
    L45:
        if (r15 == 0) goto L48;
        r18 = true;
        goto L49
    L48:
        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x".concat(f4.a.o(r111)));
    L49:
        if (r21 != r110) goto L51;
        r12.f20327a = r19.a();
        z.a(r19);
    L52:
        if (r18 == true) goto L55;
        if (r12.f20327a != null) goto L22;
    L55:
        r12.f20328b -= (long) r15;
        if (r17 == false) goto L59;
        return r14;
    L59:
        return -r14;
    L51:
        r19.f20353b = r21;
        goto L52
    L61:
        throw new EOFException();
    }

    @Override // nu.l, nu.k
    public final j h() {
        return this.f20349a;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f20350b;
    }

    @Override // nu.l
    public final String o() {
        return c(Long.MAX_VALUE);
    }

    @Override // nu.l
    public final x peek() {
        return f4.b.e(new v(this));
    }

    @Override // nu.l
    public final long r() {
        s(8);
        return this.f20349a.r();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer r10) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        j r5 = this.f20349a;
        if (r5.f20328b != 0) goto L9;
        if (this.f20351c.read(r5, 8192) != (-1)) goto L9;
        return -1;
    L9:
        return r5.read(r10);
    }

    @Override // nu.l
    public final byte readByte() {
        s(1);
        return this.f20349a.readByte();
    }

    @Override // nu.l
    public final void readFully(byte[] r10) {
        j r5 = this.f20349a;
        Intrinsics.checkNotNullParameter(r10, "sink");
        s(r10.length);     // Catch: EOFException -> L6
        r5.readFully(r10);
        return;
    L6:
        e = move-exception;
        int r11 = 0;
    L8:
        long r12 = r5.f20328b;
        if (r12 <= 0) goto L15;
        int r13 = r5.read(r10, r11, (int) r12);
        if (r13 == (-1)) goto L14;
        r11 = r11 + r13;
        goto L8
    L14:
        throw new AssertionError();
    L15:
        throw e;
    }

    @Override // nu.l
    public final int readInt() {
        s(4);
        return this.f20349a.readInt();
    }

    @Override // nu.l
    public final long readLong() {
        s(8);
        return this.f20349a.readLong();
    }

    @Override // nu.l
    public final short readShort() {
        s(2);
        return this.f20349a.readShort();
    }

    @Override // nu.l
    public final boolean request(long r5) {
        if (r5 < 0) goto L16;
        if (this.f20350b == true) goto L14;
    L6:
        j r10 = this.f20349a;
        if (r10.f20328b >= r5) goto L11;
        if (this.f20351c.read(r10, 8192) != (-1)) goto L6;
        return false;
    L11:
        return true;
    L14:
        throw new IllegalStateException("closed");
    L16:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r5, "byteCount < 0: ").toString());
    }

    @Override // nu.l
    public final void s(long r5) {
        if (request(r5) == false) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // nu.l
    public final void skip(long r10) {
        if (this.f20350b == true) goto L16;
    L5:
        if (r10 <= 0) goto L14;
        j r5 = this.f20349a;
        if (r5.f20328b != 0) goto L13;
        if (this.f20351c.read(r5, 8192) != (-1)) goto L13;
        throw new EOFException();
    L13:
        long r11 = Math.min(r10, r5.f20328b);
        r5.skip(r11);
        r10 = r10 - r11;
        goto L5
    L14:
        return;
    L16:
        throw new IllegalStateException("closed");
    }

    @Override // nu.c0
    public final f0 timeout() {
        return this.f20351c.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f20351c + ')';
    }

    @Override // nu.l
    public final String u(long r5) {
        s(r5);
        j r10 = this.f20349a;
        r10.getClass();
        return r10.L(r5, Charsets.UTF_8);
    }

    @Override // nu.l
    public final ByteString v(long r5) {
        s(r5);
        return this.f20349a.v(r5);
    }

    @Override // nu.l
    public final byte[] w() {
        c0 r5 = this.f20351c;
        j r10 = this.f20349a;
        r10.G(r5);
        return r10.K(r10.f20328b);
    }

    @Override // nu.l
    public final boolean y() {
        if (this.f20350b == true) goto L12;
        j r5 = this.f20349a;
        if (r5.y() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.f20351c.read(r5, 8192) != (-1)) goto L9;
        return true;
    L12:
        throw new IllegalStateException("closed");
    }

    @Override // nu.l
    public final long z(j r10) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        long r5 = 0;
    L3:
        j r11 = this.f20349a;
        if (this.f20351c.read(r11, 8192) == (-1)) goto L8;
        long r12 = r11.f();
        if (r12 <= 0) goto L3;
        r5 = r5 + r12;
        r10.write(r11, r12);
        goto L3
    L8:
        long r13 = r11.f20328b;
        if (r13 <= 0) goto L17;
        long r14 = r5 + r13;
        r10.write(r11, r13);
        return r14;
    L17:
        return r5;
    }

    @Override // nu.c0
    public final long read(j r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        if (r11 < 0) goto L16;
        if (this.f20350b == true) goto L14;
        j r5 = this.f20349a;
        if (r5.f20328b != 0) goto L12;
        if (this.f20351c.read(r5, 8192) != (-1)) goto L12;
        return -1;
    L12:
        return r5.read(r10, Math.min(r11, r5.f20328b));
    L14:
        throw new IllegalStateException("closed");
    L16:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r11, "byteCount < 0: ").toString());
    }
}
