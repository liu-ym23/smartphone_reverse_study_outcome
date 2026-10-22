package jf;

import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import com.qualcomm.qti.qesdk.QesdkUtils;
import com.sdk.bwdl.StateMachine.BWDLDataStructure;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements f, e, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte[] f8828m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public s f8829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8830b;

    public class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f8831a;

        public a(d r8) {
            this.f8831a = r8;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public final void flush() {
        }

        public final String toString() {
            return this.f8831a + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public final void write(int r8) {
            this.f8831a.G((byte) r8);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] r8, int r10, int r11) {
            this.f8831a.D(r10, r11, r8);
        }
    }

    public class b extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f8832a;

        public b(d r8) {
            this.f8832a = r8;
        }

        @Override // java.io.InputStream
        public final int available() {
            return (int) Math.min(this.f8832a.f8830b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // java.io.InputStream
        public final int read() {
            d r8 = this.f8832a;
            if (r8.f8830b > 0) goto L5;
            return -1;
        L5:
            return r8.readByte() & 255;
        }

        public final String toString() {
            return this.f8832a + ".inputStream()";
        }

        @Override // java.io.InputStream
        public final int read(byte[] r8, int r10, int r11) {
            return this.f8832a.read(r8, r10, r11);
        }
    }

    public static final class c implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f8833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f8834b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public s f8835m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f8836n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public byte[] f8837o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f8838p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f8839q;

        public c() {
            this.f8836n = -1;
            this.f8838p = -1;
            this.f8839q = -1;
        }

        public final int a(long r14) {
            if (r14 < (-1)) goto L38;
            d r8 = this.f8833a;
            long r10 = r8.f8830b;
            if (r14 > r10) goto L38;
            if (r14 == (-1)) goto L35;
            if (r14 == r10) goto L35;
            s r11 = r8.f8829a;
            s r12 = this.f8835m;
            long r13 = 0;
            if (r12 == null) goto L15;
            long r15 = this.f8836n - ((long) (this.f8838p - r12.f8871b));
            if (r15 <= r14) goto L14;
            r10 = r15;
        L17:
            if ((r10 - r14) <= (r14 - r13)) goto L22;
        L18:
            long r16 = ((long) (r11.f8872c - r11.f8871b)) + r13;
            if (r14 < r16) goto L26;
            r11 = r11.f8875f;
            r13 = r16;
        L26:
            if (this.f8834b == true) goto L28;
        L33:
            this.f8835m = r11;
            this.f8836n = r14;
            this.f8837o = r11.f8870a;
            int r17 = r11.f8871b + ((int) (r14 - r13));
            this.f8838p = r17;
            int r18 = r11.f8872c;
            this.f8839q = r18;
            return r18 - r17;
        L28:
            if (r11.f8873d == false) goto L33;
            s r19 = new s((byte[]) r11.f8870a.clone(), r11.f8871b, r11.f8872c, false, true);
            d r20 = this.f8833a;
            if (r20.f8829a != r11) goto L32;
            r20.f8829a = r19;
        L32:
            r11.b(r19);
            r19.f8876g.a();
            r11 = r19;
        L22:
            if (r10 <= r14) goto L24;
            r12 = r12.f8876g;
            r10 = r10 - ((long) (r12.f8872c - r12.f8871b));
            goto L22
        L24:
            r11 = r12;
            r13 = r10;
            goto L26
        L14:
            r13 = r15;
            r12 = r11;
            r11 = r12;
            goto L17
        L15:
            r12 = r11;
        L35:
            this.f8835m = null;
            this.f8836n = r14;
            this.f8837o = null;
            this.f8838p = -1;
            this.f8839q = -1;
            return -1;
        L38:
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(r14), Long.valueOf(this.f8833a.f8830b)}));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f8833a == null) goto L7;
            this.f8833a = null;
            this.f8835m = null;
            this.f8836n = -1;
            this.f8837o = null;
            this.f8838p = -1;
            this.f8839q = -1;
            return;
        L7:
            throw new IllegalStateException("not attached to a buffer");
        }
    }

    static {
        f8828m = new byte[]{BWDLDataStructure.DataLinkParamStructure.NFC, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    }

    public d() {
    }

    public final String A() {
        return z(this.f8830b, y.f8885a);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public final String B(long r8) {
        if (r8 <= 0) goto L8;
        long r10 = r8 - 1;
        if (n(r10) != 13) goto L8;
        String r11 = P(r10);
        skip(2);
        return r11;
    L8:
        String r12 = P(r8);
        skip(1);
        return r12;
    }

    public final s C(int r8) {
        if (r8 < 1) goto L17;
        if (r8 > 8192) goto L17;
        s r10 = this.f8829a;
        if (r10 != null) goto L10;
        s r11 = t.b();
        this.f8829a = r11;
        r11.f8876g = r11;
        r11.f8875f = r11;
        return r11;
    L10:
        s r12 = r10.f8876g;
        if ((r12.f8872c + r8) <= 8192) goto L13;
    L14:
        s r13 = t.b();
        r12.b(r13);
        return r13;
    L13:
        if (r12.f8874e == false) goto L14;
        return r12;
    L17:
        throw new IllegalArgumentException();
    }

    public final void D(int r10, int r11, byte[] r12) {
        if (r12 == null) goto L9;
        long r8 = r11;
        y.a(r12.length, r10, r8);
        int r13 = r11 + r10;
    L4:
        if (r10 >= r13) goto L6;
        s r14 = C(1);
        int r15 = Math.min(r13 - r10, 8192 - r14.f8872c);
        System.arraycopy(r12, r10, r14.f8870a, r14.f8872c, r15);
        r10 = r10 + r15;
        r14.f8872c += r15;
        goto L4
    L6:
        this.f8830b += r8;
        return;
    L9:
        throw new IllegalArgumentException("source == null");
    }

    public final void E(g r8) {
        if (r8 == null) goto L6;
        r8.q(this);
        return;
    L6:
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // jf.f
    public final long F() {
        return y.b(readLong());
    }

    public final void G(int r8) {
        s r10 = C(1);
        int r11 = r10.f8872c;
        r10.f8872c = r11 + 1;
        r10.f8870a[r11] = (byte) r8;
        this.f8830b++;
    }

    public final d H(long r13) {
        if (r13 != 0) goto L6;
        G(48);
        return this;
    L6:
        int r8 = 1;
        boolean r10 = false;
        if (r13 >= 0) goto L14;
        r13 = -r13;
        if (r13 >= 0) goto L12;
        c0(0, 20, "-9223372036854775808");
        return this;
    L12:
        r10 = true;
    L14:
        if (r13 >= 100000000) goto L38;
        if (r13 >= 10000) goto L28;
        if (r13 >= 100) goto L24;
        if (r13 < 10) goto L68;
        r8 = 2;
    L68:
        if (r10 == false) goto L70;
        r8 = r8 + 1;
    L70:
        s r11 = C(r8);
        int r12 = r11.f8872c + r8;
    L71:
        byte[] r14 = r11.f8870a;
        if (r13 == 0) goto L74;
        r12 = r12 - 1;
        r14[r12] = f8828m[(int) (r13 % 10)];
        r13 = r13 / 10;
        goto L71
    L74:
        if (r10 == false) goto L76;
        r14[r12 - 1] = 45;
    L76:
        r11.f8872c += r8;
        this.f8830b += (long) r8;
        return this;
    L24:
        if (r13 >= 1000) goto L26;
        r8 = 3;
        goto L68
    L26:
        r8 = 4;
        goto L68
    L28:
        if (r13 >= BwdlDropUtils.DROP_SHOW_MEGABYTES) goto L34;
        if (r13 >= 100000) goto L32;
        r8 = 5;
        goto L68
    L32:
        r8 = 6;
        goto L68
    L34:
        if (r13 >= 10000000) goto L36;
        r8 = 7;
        goto L68
    L36:
        r8 = 8;
        goto L68
    L38:
        if (r13 >= 1000000000000L) goto L50;
        if (r13 >= 10000000000L) goto L46;
        if (r13 >= BwdlDropUtils.DROP_SHOW_GIGABYTES) goto L44;
        r8 = 9;
        goto L68
    L44:
        r8 = 10;
        goto L68
    L46:
        if (r13 >= 100000000000L) goto L48;
        r8 = 11;
        goto L68
    L48:
        r8 = 12;
        goto L68
    L50:
        if (r13 >= 1000000000000000L) goto L59;
        if (r13 >= 10000000000000L) goto L55;
        r8 = 13;
        goto L68
    L55:
        if (r13 >= 100000000000000L) goto L57;
        r8 = 14;
        goto L68
    L57:
        r8 = 15;
        goto L68
    L59:
        if (r13 >= 100000000000000000L) goto L65;
        if (r13 >= 10000000000000000L) goto L63;
        r8 = 16;
        goto L68
    L63:
        r8 = 17;
        goto L68
    L65:
        if (r13 >= 1000000000000000000L) goto L67;
        r8 = 18;
        goto L68
    L67:
        r8 = 19;
        goto L68
    }

    public final d I(long r10) {
        if (r10 != 0) goto L6;
        G(48);
        return this;
    L6:
        int r8 = (Long.numberOfTrailingZeros(Long.highestOneBit(r10)) / 4) + 1;
        s r11 = C(r8);
        int r12 = r11.f8872c;
        int r13 = r12 + r8;
    L7:
        r13 = r13 - 1;
        if (r13 < r12) goto L10;
        r11.f8870a[r13] = f8828m[(int) (15 & r10)];
        r10 = r10 >>> 4;
        goto L7
    L10:
        r11.f8872c += r8;
        this.f8830b += (long) r8;
        return this;
    }

    public final void J(int r8) {
        s r10 = C(4);
        int r11 = r10.f8872c;
        int r12 = r11 + 1;
        byte[] r13 = r10.f8870a;
        r13[r11] = (byte) ((r8 >>> 24) & 255);
        int r14 = r12 + 1;
        r13[r12] = (byte) ((r8 >>> 16) & 255);
        int r15 = r14 + 1;
        r13[r14] = (byte) ((r8 >>> 8) & 255);
        r13[r15] = (byte) (r8 & 255);
        r10.f8872c = r15 + 1;
        this.f8830b += 4;
    }

    public final void K(long r11) {
        s r8 = C(8);
        int r10 = r8.f8872c;
        int r12 = r10 + 1;
        byte[] r13 = r8.f8870a;
        r13[r10] = (byte) ((r11 >>> 56) & 255);
        int r14 = r12 + 1;
        r13[r12] = (byte) ((r11 >>> 48) & 255);
        int r15 = r14 + 1;
        r13[r14] = (byte) ((r11 >>> 40) & 255);
        int r16 = r15 + 1;
        r13[r15] = (byte) ((r11 >>> 32) & 255);
        int r17 = r16 + 1;
        r13[r16] = (byte) ((r11 >>> 24) & 255);
        int r18 = r17 + 1;
        r13[r17] = (byte) ((r11 >>> 16) & 255);
        int r19 = r18 + 1;
        r13[r18] = (byte) ((r11 >>> 8) & 255);
        r13[r19] = (byte) (r11 & 255);
        r8.f8872c = r19 + 1;
        this.f8830b += 8;
    }

    @Override // jf.f
    public final void L(long r8) {
        if (this.f8830b < r8) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // jf.e
    public final /* bridge */ /* synthetic */ e N(long r8) {
        H(r8);
        return this;
    }

    @Override // jf.f
    public final String P(long r8) {
        return z(r8, y.f8885a);
    }

    @Override // jf.f
    public final g Q(long r8) {
        return new g(w(r8));
    }

    @Override // jf.e
    public final e T(int r8) {
        Charset r10 = y.f8885a;
        int r11 = ((((-16777216) & r8) >>> 24) | ((16711680 & r8) >>> 8)) | ((65280 & r8) << 8);
        J(((r8 & 255) << 24) | r11);
        return this;
    }

    @Override // jf.f
    public final boolean U() {
        if (this.f8830b != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void V(int r8) {
        s r10 = C(2);
        int r11 = r10.f8872c;
        int r12 = r11 + 1;
        byte[] r13 = r10.f8870a;
        r13[r11] = (byte) ((r8 >>> 8) & 255);
        r13[r12] = (byte) (r8 & 255);
        r10.f8872c = r12 + 1;
        this.f8830b += 2;
    }

    @Override // jf.e
    public final long X(w r8) {
        if (r8 == null) goto L9;
        long r10 = 0;
    L4:
        long r11 = r8.u(this, 8192);
        if (r11 == (-1)) goto L7;
        r10 = r10 + r11;
        goto L4
    L7:
        return r10;
    L9:
        throw new IllegalArgumentException("source == null");
    }

    public final void a() {
        skip(this.f8830b);     // Catch: EOFException -> L4
        return;
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // jf.f, jf.e
    public final d b() {
        return this;
    }

    @Override // jf.f
    public final String b0(Charset r8) {
        return z(this.f8830b, r8);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public final void c0(int r8, int r10, String r11) {
        if (r11 == null) goto L48;
        if (r8 < 0) goto L46;
        if (r10 < r8) goto L44;
        if (r10 > r11.length()) goto L41;
    L7:
        if (r8 >= r10) goto L40;
        char r12 = r11.charAt(r8);
        if (r12 < 128) goto L10;
        if (r12 < 2048) goto L20;
        if (r12 < 55296) goto L38;
        if (r12 > 57343) goto L38;
        int r13 = r8 + 1;
        if (r13 >= r10) goto L29;
        char r14 = r11.charAt(r13);
    L31:
        if (r12 > 56319) goto L37;
        if (r14 < 56320) goto L37;
        if (r14 > 57343) goto L37;
        int r15 = (((r12 & 10239) << 10) | (9215 & r14)) + 65536;
        G((r15 >> 18) | 240);
        G(((r15 >> 12) & 63) | 128);
        G(((r15 >> 6) & 63) | 128);
        G((r15 & 63) | 128);
        r8 = r8 + 2;
    L37:
        G(63);
        r8 = r13;
        goto L7
    L29:
        r14 = 0;
    L38:
        G((r12 >> '\f') | 224);
        int r16 = ((r12 >> 6) & 63) | 128;
    L39:
        G(r16);
        G((r12 & '?') | 128);
        r8 = r8 + 1;
        goto L7
    L20:
        r16 = (r12 >> 6) | 192;
        goto L39
    L10:
        s r17 = C(1);
        int r18 = r17.f8872c - r8;
        int r19 = Math.min(r10, 8192 - r18);
        int r20 = r8 + 1;
        byte[] r21 = r17.f8870a;
        r21[r8 + r18] = (byte) r12;
    L11:
        r8 = r20;
        if (r8 >= r19) goto L17;
        char r22 = r11.charAt(r8);
        if (r22 >= 128) goto L17;
        r20 = r8 + 1;
        r21[r8 + r18] = (byte) r22;
    L17:
        int r23 = r17.f8872c;
        int r24 = (r18 + r8) - r23;
        r17.f8872c = r23 + r24;
        this.f8830b += (long) r24;
        goto L7
    L40:
        return;
    L41:
        StringBuilder r25 = defpackage.b.f("endIndex > string.length: ", r10, " > ");
        r25.append(r11.length());
        throw new IllegalArgumentException(r25.toString());
    L44:
        throw new IllegalArgumentException("endIndex < beginIndex: " + r10 + " < " + r8);
    L46:
        throw new IllegalArgumentException(defpackage.a.d("beginIndex < 0: ", r8));
    L48:
        throw new IllegalArgumentException("string == null");
    }

    public final Object clone() {
        d r8 = new d();
        if (this.f8830b == 0) goto L10;
        s r10 = this.f8829a.c();
        r8.f8829a = r10;
        r10.f8876g = r10;
        r10.f8875f = r10;
        s r11 = this.f8829a;
    L6:
        r11 = r11.f8875f;
        if (r11 == this.f8829a) goto L9;
        r8.f8829a.f8876g.b(r11.c());
        goto L6
    L9:
        r8.f8830b = this.f8830b;
    L10:
        return r8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, jf.v
    public final void close() {
    }

    @Override // jf.f
    public final void d(d r8, long r10) {
        long r11 = this.f8830b;
        if (r11 < r10) goto L6;
        r8.write(this, r10);
        return;
    L6:
        r8.write(this, r11);
        throw new EOFException();
    }

    @Override // jf.e
    public final /* bridge */ /* synthetic */ e d0(long r8) {
        I(r8);
        return this;
    }

    public final void e0(int r8) {
        if (r8 >= 128) goto L6;
    L21:
        G(r8);
        return;
    L6:
        if (r8 >= 2048) goto L9;
        int r10 = (r8 >> 6) | 192;
    L20:
        G(r10);
        r8 = (r8 & 63) | 128;
        goto L21
    L9:
        if (r8 >= 65536) goto L17;
        if (r8 >= 55296) goto L13;
    L15:
        int r11 = (r8 >> 12) | 224;
    L19:
        G(r11);
        r10 = ((r8 >> 6) & 63) | 128;
        goto L20
    L13:
        if (r8 > 57343) goto L15;
        G(63);
        return;
    L17:
        if (r8 > 1114111) goto L24;
        G((r8 >> 18) | 240);
        r11 = ((r8 >> 12) & 63) | 128;
        goto L19
    L24:
        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(r8));
    }

    public final boolean equals(Object r14) {
        if (this != r14) goto L6;
        return true;
    L6:
        if ((r14 instanceof d) == true) goto L8;
        return false;
    L8:
        d r15 = (d) r14;
        long r8 = this.f8830b;
        if (r8 == r15.f8830b) goto L11;
        return false;
    L11:
        long r10 = 0;
        if (r8 != 0) goto L14;
        return true;
    L14:
        s r11 = this.f8829a;
        s r16 = r15.f8829a;
        int r12 = r11.f8871b;
        int r13 = r16.f8871b;
    L16:
        if (r10 >= this.f8830b) goto L31;
        long r17 = Math.min(r11.f8872c - r12, r16.f8872c - r13);
        int r18 = 0;
    L19:
        if (r18 >= r17) goto L25;
        int r19 = r12 + 1;
        int r110 = r13 + 1;
        if (r11.f8870a[r12] != r16.f8870a[r13]) goto L22;
        r18 = r18 + 1;
        r12 = r19;
        r13 = r110;
        goto L19
    L22:
        return false;
    L25:
        if (r12 != r11.f8872c) goto L28;
        r11 = r11.f8875f;
        r12 = r11.f8871b;
    L28:
        if (r13 != r16.f8872c) goto L30;
        r16 = r16.f8875f;
        r13 = r16.f8871b;
    L30:
        r10 = r10 + r17;
        goto L16
    L31:
        return true;
    }

    @Override // jf.e
    public final e f() {
        return this;
    }

    @Override // jf.e, jf.v, java.io.Flushable
    public final void flush() {
    }

    @Override // jf.e
    public final e h(long r8) {
        K(y.b(r8));
        return this;
    }

    public final int hashCode() {
        s r8 = this.f8829a;
        if (r8 != null) goto L6;
        return 0;
    L6:
        int r10 = 1;
    L7:
        int r11 = r8.f8871b;
        int r12 = r8.f8872c;
    L8:
        if (r11 >= r12) goto L10;
        r10 = (r10 * 31) + r8.f8870a[r11];
        r11 = r11 + 1;
        goto L8
    L10:
        r8 = r8.f8875f;
        if (r8 != this.f8829a) goto L7;
        return r10;
    }

    public final long i() {
        long r8 = this.f8830b;
        if (r8 != 0) goto L5;
        return 0;
    L5:
        s r10 = this.f8829a.f8876g;
        int r11 = r10.f8872c;
        if (r11 < 8192) goto L8;
        return r8;
    L8:
        if (r10.f8874e == true) goto L10;
        return r8;
    L10:
        return r8 - ((long) (r11 - r10.f8871b));
    }

    @Override // jf.f
    public final int i0() {
        int r8 = readInt();
        Charset r10 = y.f8885a;
        int r11 = ((((-16777216) & r8) >>> 24) | ((16711680 & r8) >>> 8)) | ((65280 & r8) << 8);
        return ((r8 & 255) << 24) | r11;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // jf.f
    public final boolean j(g r10) {
        byte[] r8 = r10.f8842a;
        int r11 = r8.length;
        if (r11 >= 0) goto L5;
        return false;
    L5:
        if ((this.f8830b - 0) >= r11) goto L7;
        return false;
    L7:
        if ((r8.length - 0) < r11) goto L21;
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L15;
        if (n(((long) r12) + 0) != r10.f8842a[0 + r12]) goto L22;
        r12 = r12 + 1;
        goto L10
    L22:
        return false;
    L15:
        return true;
    L21:
        return false;
    }

    public final void k(d r8, long r10, long r11) {
        if (r8 == null) goto L19;
        y.a(this.f8830b, r10, r11);
        if (r11 != 0) goto L6;
        return;
    L6:
        r8.f8830b += r11;
        s r12 = this.f8829a;
    L7:
        long r13 = r12.f8872c - r12.f8871b;
        if (r10 < r13) goto L11;
        r10 = r10 - r13;
        r12 = r12.f8875f;
    L11:
        if (r11 <= 0) goto L17;
        s r14 = r12.c();
        int r15 = (int) (((long) r14.f8871b) + r10);
        r14.f8871b = r15;
        r14.f8872c = Math.min(r15 + ((int) r11), r14.f8872c);
        s r16 = r8.f8829a;
        if (r16 != null) goto L15;
        r14.f8876g = r14;
        r14.f8875f = r14;
        r8.f8829a = r14;
    L16:
        r11 = r11 - ((long) (r14.f8872c - r14.f8871b));
        r12 = r12.f8875f;
        r10 = 0;
        goto L11
    L15:
        r16.f8876g.b(r14);
        goto L16
    L17:
        return;
    L19:
        throw new IllegalArgumentException("out == null");
    }

    @Override // jf.f
    public final String l(long r12) {
        if (r12 < 0) goto L23;
        long r8 = Long.MAX_VALUE;
        if (r12 == Long.MAX_VALUE) goto L8;
        r8 = r12 + 1;
    L8:
        long r10 = r((byte) 10, 0, r8);
        if (r10 == (-1)) goto L13;
        return B(r10);
    L13:
        if (r8 < this.f8830b) goto L15;
    L20:
        d r11 = new d();
        k(r11, 0, Math.min(32, this.f8830b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f8830b, r12) + " content=" + r11.x().f() + 8230);
    L15:
        if (n(r8 - 1) != 13) goto L20;
        if (n(r8) != 10) goto L20;
        return B(r8);
    L23:
        throw new IllegalArgumentException(android.aimedia.a.d("limit < 0: ", r12));
    }

    @Override // jf.e
    public final /* bridge */ /* synthetic */ e l0(int r8, int r10, byte[] r11) {
        D(r8, r10, r11);
        return this;
    }

    public final byte n(long r8) {
        y.a(this.f8830b, r8, 1);
        long r10 = this.f8830b;
        if ((r10 - r8) <= r8) goto L10;
        s r11 = this.f8829a;
    L5:
        int r12 = r11.f8872c;
        int r13 = r11.f8871b;
        long r14 = r12 - r13;
        if (r8 < r14) goto L8;
        r8 = r8 - r14;
        r11 = r11.f8875f;
        goto L5
    L8:
        return r11.f8870a[r13 + ((int) r8)];
    L10:
        long r15 = r8 - r10;
        s r16 = this.f8829a;
    L11:
        r16 = r16.f8876g;
        int r17 = r16.f8872c;
        int r18 = r16.f8871b;
        r15 = r15 + ((long) (r17 - r18));
        if (r15 < 0) goto L11;
        return r16.f8870a[r18 + ((int) r15)];
    }

    @Override // jf.e
    public final OutputStream n0() {
        return new a(this);
    }

    @Override // jf.f
    public final long o0() {
        if (this.f8830b == 0) goto L41;
        int r8 = 0;
        boolean r10 = false;
        long r11 = 0;
    L5:
        s r12 = this.f8829a;
        byte[] r13 = r12.f8870a;
        int r14 = r12.f8871b;
        int r15 = r12.f8872c;
    L6:
        if (r14 >= r15) goto L32;
        byte r16 = r13[r14];
        if (r16 < 48) goto L13;
        if (r16 > 57) goto L13;
        int r17 = r16 - 48;
    L24:
        if (((-1152921504606846976L) & r11) != 0) goto L26;
        r11 = (r11 << 4) | ((long) r17);
        r14 = r14 + 1;
        r8 = r8 + 1;
        goto L6
    L26:
        d r18 = new d();
        r18.I(r11);
        r18.G(r16);
        throw new NumberFormatException("Number too large: ".concat(r18.A()));
    L13:
        if (r16 < 97) goto L18;
        if (r16 > 102) goto L18;
        int r19 = r16 - 97;
    L22:
        r17 = r19 + 10;
    L18:
        if (r16 < 65) goto L28;
        if (r16 > 70) goto L28;
        r19 = r16 - 65;
    L28:
        if (r8 == 0) goto L31;
        r10 = true;
        goto L32
    L31:
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(r16));
    L32:
        if (r14 != r15) goto L34;
        this.f8829a = r12.a();
        t.a(r12);
    L35:
        if (r10 == true) goto L38;
        if (this.f8829a != null) goto L5;
    L38:
        this.f8830b -= (long) r8;
        return r11;
    L34:
        r12.f8871b = r14;
        goto L35
    L41:
        throw new IllegalStateException("size == 0");
    }

    @Override // jf.e
    public final e p(String r8) {
        c0(0, r8.length(), r8);
        return this;
    }

    @Override // jf.f
    public final InputStream p0() {
        return new b(this);
    }

    public final long r(byte r15, long r16, long r18) {
        long r8 = 0;
        if (r16 < 0) goto L38;
        if (r18 < r16) goto L38;
        long r10 = this.f8830b;
        if (r18 <= r10) goto L9;
        long r11 = r10;
    L11:
        if (r16 != r11) goto L13;
        return -1;
    L13:
        s r12 = this.f8829a;
        if (r12 != null) goto L17;
        return -1;
    L17:
        if ((r10 - r16) < r16) goto L19;
    L21:
        long r13 = ((long) (r12.f8872c - r12.f8871b)) + r8;
        if (r13 >= r16) goto L24;
        r12 = r12.f8875f;
        r8 = r13;
        goto L21
    L24:
        r10 = r8;
    L25:
        s r14 = r12;
        long r17 = r16;
    L27:
        if (r10 >= r11) goto L36;
        byte[] r19 = r14.f8870a;
        int r110 = (int) Math.min(r14.f8872c, (((long) r14.f8871b) + r11) - r10);
        int r20 = (int) ((((long) r14.f8871b) + r17) - r10);
    L29:
        if (r20 >= r110) goto L35;
        if (r19[r20] == r15) goto L33;
        r20 = r20 + 1;
        goto L29
    L33:
        return ((long) (r20 - r14.f8871b)) + r10;
    L35:
        r10 = r10 + ((long) (r14.f8872c - r14.f8871b));
        r14 = r14.f8875f;
        r17 = r10;
        goto L27
    L36:
        return -1;
    L19:
        if (r10 <= r16) goto L25;
        r12 = r12.f8876g;
        r10 = r10 - ((long) (r12.f8872c - r12.f8871b));
        goto L19
    L9:
        r11 = r18;
    L38:
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f8830b), Long.valueOf(r16), Long.valueOf(r18)}));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer r8) {
        s r10 = this.f8829a;
        if (r10 != null) goto L6;
        return -1;
    L6:
        int r11 = Math.min(r8.remaining(), r10.f8872c - r10.f8871b);
        r8.put(r10.f8870a, r10.f8871b, r11);
        int r12 = r10.f8871b + r11;
        r10.f8871b = r12;
        this.f8830b -= (long) r11;
        if (r12 != r10.f8872c) goto L9;
        this.f8829a = r10.a();
        t.a(r10);
    L9:
        return r11;
    }

    @Override // jf.f
    public final byte readByte() {
        long r8 = this.f8830b;
        if (r8 == 0) goto L10;
        s r10 = this.f8829a;
        int r11 = r10.f8871b;
        int r12 = r10.f8872c;
        int r13 = r11 + 1;
        byte r14 = r10.f8870a[r11];
        this.f8830b = r8 - 1;
        if (r13 != r12) goto L7;
        this.f8829a = r10.a();
        t.a(r10);
    L8:
        return r14;
    L7:
        r10.f8871b = r13;
        goto L8
    L10:
        throw new IllegalStateException("size == 0");
    }

    @Override // jf.f
    public final void readFully(byte[] r8) {
        int r10 = 0;
    L4:
        if (r10 >= r8.length) goto L10;
        int r11 = read(r8, r10, r8.length - r10);
        if (r11 == (-1)) goto L9;
        r10 = r10 + r11;
        goto L4
    L9:
        throw new EOFException();
    }

    @Override // jf.f
    public final int readInt() {
        long r8 = this.f8830b;
        if (r8 < 4) goto L14;
        s r10 = this.f8829a;
        int r11 = r10.f8871b;
        int r12 = r10.f8872c;
        if ((r12 - r11) < 4) goto L7;
        int r13 = r11 + 1;
        byte[] r14 = r10.f8870a;
        int r15 = r13 + 1;
        int r16 = ((r14[r11] & 255) << 24) | ((r14[r13] & 255) << 16);
        int r17 = r15 + 1;
        int r18 = r16 | ((r14[r15] & 255) << 8);
        int r19 = r17 + 1;
        int r20 = r18 | (r14[r17] & 255);
        this.f8830b = r8 - 4;
        if (r19 != r12) goto L11;
        this.f8829a = r10.a();
        t.a(r10);
    L12:
        return r20;
    L11:
        r10.f8871b = r19;
        goto L12
    L7:
        return (readByte() & 255) | ((((readByte() & 255) << 24) | ((readByte() & 255) << 16)) | ((readByte() & 255) << 8));
    L14:
        throw new IllegalStateException("size < 4: " + this.f8830b);
    }

    @Override // jf.f
    public final long readLong() {
        long r8 = this.f8830b;
        if (r8 < 8) goto L14;
        s r10 = this.f8829a;
        int r11 = r10.f8871b;
        int r12 = r10.f8872c;
        if ((r12 - r11) < 8) goto L7;
        int r13 = r11 + 1;
        byte[] r14 = r10.f8870a;
        long r15 = (((long) r14[r11]) & 255) << 56;
        int r16 = r13 + 1;
        long r17 = ((((long) r14[r13]) & 255) << 48) | r15;
        int r18 = r16 + 1;
        long r19 = r17 | ((((long) r14[r16]) & 255) << 40);
        int r20 = r18 + 1;
        long r21 = r19 | ((((long) r14[r18]) & 255) << 32);
        int r22 = r20 + 1;
        long r23 = r21 | ((((long) r14[r20]) & 255) << 24);
        int r24 = r22 + 1;
        long r25 = r23 | ((((long) r14[r22]) & 255) << 16);
        int r26 = r24 + 1;
        long r27 = r25 | ((((long) r14[r24]) & 255) << 8);
        int r28 = r26 + 1;
        long r29 = r27 | (((long) r14[r26]) & 255);
        this.f8830b = r8 - 8;
        if (r28 != r12) goto L11;
        this.f8829a = r10.a();
        t.a(r10);
    L12:
        return r29;
    L11:
        r10.f8871b = r28;
        goto L12
    L7:
        return ((((long) readInt()) & QesdkUtils.LIMITS.UINT_32_UPPER) << 32) | (QesdkUtils.LIMITS.UINT_32_UPPER & ((long) readInt()));
    L14:
        throw new IllegalStateException("size < 8: " + this.f8830b);
    }

    @Override // jf.f
    public final short readShort() {
        long r8 = this.f8830b;
        if (r8 < 2) goto L15;
        s r10 = this.f8829a;
        int r11 = r10.f8871b;
        int r12 = r10.f8872c;
        if ((r12 - r11) < 2) goto L7;
        int r13 = r11 + 1;
        byte[] r14 = r10.f8870a;
        int r15 = r13 + 1;
        int r16 = ((r14[r11] & 255) << 8) | (r14[r13] & 255);
        this.f8830b = r8 - 2;
        if (r15 != r12) goto L11;
        this.f8829a = r10.a();
        t.a(r10);
    L13:
        return (short) r16;
    L11:
        r10.f8871b = r15;
        goto L13
    L7:
        return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
    L15:
        throw new IllegalStateException("size < 2: " + this.f8830b);
    }

    @Override // jf.e
    public final /* bridge */ /* synthetic */ e s(g r8) {
        E(r8);
        return this;
    }

    public final long size() {
        return this.f8830b;
    }

    @Override // jf.f
    public final void skip(long r8) {
    L3:
        if (r8 <= 0) goto L11;
        s r10 = this.f8829a;
        if (r10 == null) goto L10;
        int r11 = (int) Math.min(r8, r10.f8872c - r10.f8871b);
        long r12 = r11;
        this.f8830b -= r12;
        r8 = r8 - r12;
        s r13 = this.f8829a;
        int r14 = r13.f8871b + r11;
        r13.f8871b = r14;
        if (r14 != r13.f8872c) goto L3;
        this.f8829a = r13.a();
        t.a(r13);
        goto L3
    L10:
        throw new EOFException();
    }

    @Override // jf.w
    public final x timeout() {
        return x.f8881d;
    }

    public final String toString() {
        long r8 = this.f8830b;
        if (r8 > 2147483647L) goto L11;
        int r10 = (int) r8;
        if (r10 != 0) goto L7;
        g r11 = g.f8841o;
    L9:
        return r11.toString();
    L7:
        r11 = new u(this, r10);
        goto L9
    L11:
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f8830b);
    }

    @Override // jf.w
    public final long u(d r8, long r10) {
        if (r8 == null) goto L17;
        if (r10 < 0) goto L15;
        long r11 = this.f8830b;
        if (r11 != 0) goto L10;
        return -1;
    L10:
        if (r10 <= r11) goto L12;
        r10 = r11;
    L12:
        r8.write(this, r10);
        return r10;
    L15:
        throw new IllegalArgumentException(android.aimedia.a.d("byteCount < 0: ", r10));
    L17:
        throw new IllegalArgumentException("sink == null");
    }

    public final void v(c r8) {
        if (r8.f8833a != null) goto L7;
        r8.f8833a = this;
        r8.f8834b = true;
        return;
    L7:
        throw new IllegalStateException("already attached to a buffer");
    }

    public final byte[] w(long r8) {
        y.a(this.f8830b, 0, r8);
        if (r8 > 2147483647L) goto L7;
        byte[] r10 = new byte[(int) r8];
        readFully(r10);
        return r10;
    L7:
        throw new IllegalArgumentException(android.aimedia.a.d("byteCount > Integer.MAX_VALUE: ", r8));
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer r8) {
        if (r8 == null) goto L9;
        int r10 = r8.remaining();
        int r11 = r10;
    L4:
        if (r11 <= 0) goto L6;
        s r12 = C(1);
        int r13 = Math.min(r11, 8192 - r12.f8872c);
        r8.get(r12.f8870a, r12.f8872c, r13);
        r11 = r11 - r13;
        r12.f8872c += r13;
        goto L4
    L6:
        this.f8830b += (long) r10;
        return r10;
    L9:
        throw new IllegalArgumentException("source == null");
    }

    @Override // jf.e
    public final /* bridge */ /* synthetic */ e writeByte(int r8) {
        G(r8);
        return this;
    }

    @Override // jf.e
    public final /* bridge */ /* synthetic */ e writeInt(int r8) {
        J(r8);
        return this;
    }

    @Override // jf.e
    public final /* bridge */ /* synthetic */ e writeShort(int r8) {
        V(r8);
        return this;
    }

    public final g x() {
        return new g(w(this.f8830b));
    L6:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // jf.f
    public final String y() {
        return l(Long.MAX_VALUE);
    }

    public final String z(long r8, Charset r10) {
        y.a(this.f8830b, 0, r8);
        if (r10 == null) goto L21;
        if (r8 > 2147483647L) goto L19;
        if (r8 != 0) goto L10;
        return "";
    L10:
        s r11 = this.f8829a;
        if ((((long) r11.f8871b) + r8) > r11.f8872c) goto L13;
        String r12 = new String(r11.f8870a, r11.f8871b, (int) r8, r10);
        int r13 = (int) (((long) r11.f8871b) + r8);
        r11.f8871b = r13;
        this.f8830b -= r8;
        if (r13 != r11.f8872c) goto L17;
        this.f8829a = r11.a();
        t.a(r11);
    L17:
        return r12;
    L13:
        return new String(w(r8), r10);
    L19:
        throw new IllegalArgumentException(android.aimedia.a.d("byteCount > Integer.MAX_VALUE: ", r8));
    L21:
        throw new IllegalArgumentException("charset == null");
    }

    public final int read(byte[] r8, int r10, int r11) {
        y.a(r8.length, r10, r11);
        s r12 = this.f8829a;
        if (r12 != null) goto L6;
        return -1;
    L6:
        int r13 = Math.min(r11, r12.f8872c - r12.f8871b);
        System.arraycopy(r12.f8870a, r12.f8871b, r8, r10, r13);
        int r14 = r12.f8871b + r13;
        r12.f8871b = r14;
        this.f8830b -= (long) r13;
        if (r14 != r12.f8872c) goto L9;
        this.f8829a = r12.a();
        t.a(r12);
    L9:
        return r13;
    }

    @Override // jf.e
    public final /* bridge */ /* synthetic */ e write(byte[] r8) {
        m15write(r8);
        return this;
    }

    @Override // jf.v
    public final void write(d r10, long r11) {
        if (r10 == null) goto L57;
        if (r10 == this) goto L55;
        y.a(r10.f8830b, 0, r11);
    L6:
        if (r11 <= 0) goto L53;
        s r8 = r10.f8829a;
        int r12 = r8.f8872c - r8.f8871b;
        int r13 = 0;
        if (r11 >= r12) goto L34;
        s r14 = this.f8829a;
        if (r14 == null) goto L12;
        s r15 = r14.f8876g;
    L13:
        if (r15 != null) goto L15;
    L24:
        int r16 = (int) r11;
        if (r16 <= 0) goto L33;
        if (r16 > r12) goto L33;
        if (r16 < 1024) goto L30;
        s r17 = r8.c();
    L31:
        r17.f8872c = r17.f8871b + r16;
        r8.f8871b += r16;
        r8.f8876g.b(r17);
        r10.f8829a = r17;
        goto L34
    L30:
        r17 = t.b();
        System.arraycopy(r8.f8870a, r8.f8871b, r17.f8870a, 0, r16);
    L33:
        throw new IllegalArgumentException();
    L15:
        if (r15.f8874e == false) goto L24;
        long r18 = ((long) r15.f8872c) + r11;
        if (r15.f8873d == false) goto L19;
        int r19 = 0;
    L21:
        if ((r18 - ((long) r19)) > 8192) goto L24;
        r8.d(r15, (int) r11);
        r10.f8830b -= r11;
        this.f8830b += r11;
        return;
    L19:
        r19 = r15.f8871b;
        goto L21
    L12:
        r15 = null;
    L34:
        s r20 = r10.f8829a;
        long r21 = r20.f8872c - r20.f8871b;
        r10.f8829a = r20.a();
        s r22 = this.f8829a;
        if (r22 != null) goto L37;
        this.f8829a = r20;
        r20.f8876g = r20;
        r20.f8875f = r20;
    L50:
        r10.f8830b -= r21;
        this.f8830b += r21;
        r11 = r11 - r21;
        goto L6
    L37:
        r22.f8876g.b(r20);
        s r23 = r20.f8876g;
        if (r23 == r20) goto L52;
        if (r23.f8874e == false) goto L50;
        int r24 = r20.f8872c - r20.f8871b;
        int r25 = 8192 - r23.f8872c;
        if (r23.f8873d == true) goto L47;
        r13 = r23.f8871b;
    L47:
        if (r24 > (r25 + r13)) goto L50;
        r20.d(r23, r24);
        r20.a();
        t.a(r20);
        goto L50
    L52:
        throw new IllegalStateException();
    L53:
        return;
    L55:
        throw new IllegalArgumentException("source == this");
    L57:
        throw new IllegalArgumentException("source == null");
    }

    /* JADX INFO: renamed from: write, reason: collision with other method in class */
    public final void m15write(byte[] r8) {
        if (r8 == null) goto L6;
        D(0, r8.length, r8);
        return;
    L6:
        throw new IllegalArgumentException("source == null");
    }
}
