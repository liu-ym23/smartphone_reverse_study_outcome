package nu;

import ai.j0;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.connection.RealConnection;
import okio.ByteString;
import okio.SegmentedByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements l, k, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f20327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f20328b;

    public static void Z(j r10, ByteArrayOutputStream r11) {
        long r12 = r10.f20328b;
        Intrinsics.checkNotNullParameter(r11, "out");
        f4.a.d(r10.f20328b, 0, r12);
        y r5 = r10.f20327a;
    L4:
        if (r12 <= 0) goto L8;
        Intrinsics.checkNotNull(r5);
        int r13 = (int) Math.min(r12, r5.f20354c - r5.f20353b);
        r11.write(r5.f20352a, r5.f20353b, r13);
        int r14 = r5.f20353b + r13;
        r5.f20353b = r14;
        long r15 = r13;
        r10.f20328b -= r15;
        r12 = r12 - r15;
        if (r14 != r5.f20354c) goto L4;
        y r16 = r5.a();
        r10.f20327a = r16;
        z.a(r5);
        r5 = r16;
        goto L4
    }

    @Override // nu.l
    public final String A(Charset r5) {
        Intrinsics.checkNotNullParameter(r5, "charset");
        return L(this.f20328b, r5);
    }

    @Override // nu.k
    public final /* bridge */ /* synthetic */ k B(long r5) {
        V(r5);
        return this;
    }

    @Override // nu.l
    public final ByteString C() {
        return v(this.f20328b);
    }

    @Override // nu.l
    public final int D(u r5) {
        Intrinsics.checkNotNullParameter(r5, "options");
        int r10 = ou.a.b(this, r5, false);
        if (r10 == (-1)) goto L7;
        skip(r5.f20341a[r10].size());
        return r10;
    L7:
        return -1;
    }

    @Override // nu.l
    public final int E() {
        return f4.a.l(readInt());
    }

    @Override // nu.k
    public final /* bridge */ /* synthetic */ k F(ByteString r5) {
        Q(r5);
        return this;
    }

    @Override // nu.k
    public final long G(c0 r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        long r5 = 0;
    L3:
        long r11 = r10.read(this, 8192);
        if (r11 == (-1)) goto L5;
        r5 = r5 + r11;
        goto L3
    L5:
        return r5;
    }

    @Override // nu.l
    public final long H() {
        if (this.f20328b == 0) goto L40;
        int r5 = 0;
        boolean r10 = false;
        long r11 = 0;
    L5:
        y r12 = this.f20327a;
        Intrinsics.checkNotNull(r12);
        byte[] r13 = r12.f20352a;
        int r14 = r12.f20353b;
        int r15 = r12.f20354c;
    L6:
        if (r14 >= r15) goto L31;
        byte r16 = r13[r14];
        byte r17 = (byte) 48;
        if (r16 >= r17) goto L10;
    L12:
        byte r18 = (byte) 97;
        if (r16 >= r18) goto L15;
    L17:
        r18 = (byte) 65;
        if (r16 < r18) goto L27;
        if (r16 > ((byte) 70)) goto L27;
    L16:
        int r19 = (r16 - r18) + 10;
    L23:
        if (((-1152921504606846976L) & r11) != 0) goto L25;
        r11 = (r11 << 4) | ((long) r19);
        r14 = r14 + 1;
        r5 = r5 + 1;
        goto L6
    L25:
        j r110 = new j();
        r110.V(r11);
        r110.T(r16);
        throw new NumberFormatException("Number too large: ".concat(r110.M()));
    L27:
        if (r5 == 0) goto L30;
        r10 = true;
        goto L31
    L30:
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(f4.a.o(r16)));
    L15:
        if (r16 > ((byte) 102)) goto L17;
    L10:
        if (r16 > ((byte) 57)) goto L12;
        r19 = r16 - r17;
    L31:
        if (r14 != r15) goto L33;
        this.f20327a = r12.a();
        z.a(r12);
    L34:
        if (r10 == true) goto L37;
        if (this.f20327a != null) goto L5;
    L37:
        this.f20328b -= (long) r5;
        return r11;
    L33:
        r12.f20353b = r14;
        goto L34
    L40:
        throw new EOFException();
    }

    @Override // nu.l
    public final InputStream I() {
        return new h(this, 0);
    }

    public final void J(g r5) {
        Intrinsics.checkNotNullParameter(r5, "unsafeCursor");
        if (r5.f20321a != null) goto L7;
        r5.f20321a = this;
        r5.f20322b = true;
        return;
    L7:
        throw new IllegalStateException("already attached to a buffer");
    }

    public final byte[] K(long r5) {
        if (r5 >= 0) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L16;
        if (this.f20328b < r5) goto L14;
        byte[] r11 = new byte[(int) r5];
        readFully(r11);
        return r11;
    L14:
        throw new EOFException();
    L16:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r5, "byteCount: ").toString());
    L5:
        if (r5 > Integer.MAX_VALUE) goto L7;
        r10 = true;
        goto L8
    }

    public final String L(long r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r11, "charset");
        if (r10 >= 0) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == false) goto L25;
        if (this.f20328b < r10) goto L23;
        if (r10 != 0) goto L14;
        return "";
    L14:
        y r12 = this.f20327a;
        Intrinsics.checkNotNull(r12);
        int r13 = r12.f20353b;
        if ((((long) r13) + r10) > r12.f20354c) goto L17;
        int r14 = (int) r10;
        String r15 = new String(r12.f20352a, r13, r14, r11);
        int r16 = r12.f20353b + r14;
        r12.f20353b = r16;
        this.f20328b -= r10;
        if (r16 != r12.f20354c) goto L21;
        this.f20327a = r12.a();
        z.a(r12);
    L21:
        return r15;
    L17:
        return new String(K(r10), r11);
    L23:
        throw new EOFException();
    L25:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r10, "byteCount: ").toString());
    L5:
        if (r10 > Integer.MAX_VALUE) goto L7;
        r5 = true;
        goto L8
    }

    public final String M() {
        return L(this.f20328b, Charsets.UTF_8);
    }

    public final int N() {
        if (this.f20328b == 0) goto L40;
        byte r5 = m(0);
        int r10 = 1;
        if ((r5 & ByteCompanionObject.MIN_VALUE) != 0) goto L8;
        int r11 = r5 & ByteCompanionObject.MAX_VALUE;
        int r12 = 0;
        int r13 = 1;
    L16:
        long r14 = r13;
        if (this.f20328b < r14) goto L35;
    L18:
        if (r10 >= r13) goto L23;
        long r15 = r10;
        byte r16 = m(r15);
        if ((r16 & 192) != 128) goto L22;
        r11 = (r11 << 6) | (r16 & 63);
        r10 = r10 + 1;
        goto L18
    L22:
        skip(r15);
        return 65533;
    L23:
        skip(r14);
        if (r11 <= 1114111) goto L27;
        return 65533;
    L27:
        if (55296 <= r11) goto L30;
    L32:
        if (r11 >= r12) goto L44;
        return 65533;
    L44:
        return r11;
    L30:
        if (57343 < r11) goto L32;
        return 65533;
    L35:
        StringBuilder r17 = j0.s(r13, "size < ", ": ");
        r17.append(this.f20328b);
        r17.append(" (to read code point prefixed 0x");
        r17.append(f4.a.o(r5));
        r17.append(')');
        throw new EOFException(r17.toString());
    L8:
        if ((r5 & 224) != 192) goto L11;
        r11 = r5 & 31;
        r13 = 2;
        r12 = 128;
        goto L16
    L11:
        if ((r5 & 240) != 224) goto L14;
        r11 = r5 & 15;
        r13 = 3;
        r12 = 2048;
        goto L16
    L14:
        if ((r5 & 248) != 240) goto L37;
        r11 = r5 & 7;
        r13 = 4;
        r12 = 65536;
        goto L16
    L37:
        skip(1);
        return 65533;
    L40:
        throw new EOFException();
    }

    public final ByteString O(int r10) {
        if (r10 == 0) goto L19;
        f4.a.d(this.f20328b, 0, r10);
        y r5 = this.f20327a;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L5:
        if (r12 >= r10) goto L11;
        Intrinsics.checkNotNull(r5);
        int r14 = r5.f20354c;
        int r15 = r5.f20353b;
        if (r14 == r15) goto L10;
        r12 = r12 + (r14 - r15);
        r13 = r13 + 1;
        r5 = r5.f;
        goto L5
    L10:
        throw new AssertionError("s.limit == s.pos");
    L11:
        byte[][] r16 = new byte[r13][];
        int[] r17 = new int[r13 * 2];
        y r18 = this.f20327a;
        int r19 = 0;
    L12:
        if (r11 >= r10) goto L15;
        Intrinsics.checkNotNull(r18);
        r16[r19] = r18.f20352a;
        r11 = r11 + (r18.f20354c - r18.f20353b);
        r17[r19] = Math.min(r11, r10);
        r17[r19 + r13] = r18.f20353b;
        r18.d = true;
        r19 = r19 + 1;
        r18 = r18.f;
        goto L12
    L15:
        return new SegmentedByteString(r16, r17);
    L19:
        return ByteString.EMPTY;
    }

    public final y P(int r5) {
        if (r5 < 1) goto L18;
        if (r5 > 8192) goto L18;
        y r10 = this.f20327a;
        if (r10 != null) goto L9;
        y r11 = z.b();
        this.f20327a = r11;
        r11.g = r11;
        r11.f = r11;
        return r11;
    L9:
        Intrinsics.checkNotNull(r10);
        y r12 = r10.g;
        Intrinsics.checkNotNull(r12);
        if ((r12.f20354c + r5) <= 8192) goto L12;
    L15:
        y r13 = z.b();
        r12.b(r13);
        return r13;
    L12:
        if (r12.e == false) goto L15;
        return r12;
    L18:
        throw new IllegalArgumentException("unexpected capacity");
    }

    public final void Q(ByteString r5) {
        Intrinsics.checkNotNullParameter(r5, "byteString");
        r5.write$okio(this, 0, r5.size());
    }

    public final void R(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        S(r5, 0, r5.length);
    }

    public final void S(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        long r13 = r12;
        f4.a.d(r10.length, r11, r13);
        int r14 = r12 + r11;
    L3:
        if (r11 >= r14) goto L5;
        y r5 = P(1);
        int r15 = Math.min(r14 - r11, 8192 - r5.f20354c);
        int r16 = r11 + r15;
        ArraysKt.copyInto(r10, r5.f20352a, r5.f20354c, r11, r16);
        r5.f20354c += r15;
        r11 = r16;
        goto L3
    L5:
        this.f20328b += r13;
    }

    public final void T(int r5) {
        y r10 = P(1);
        int r11 = r10.f20354c;
        r10.f20354c = r11 + 1;
        r10.f20352a[r11] = (byte) r5;
        this.f20328b++;
    }

    public final void U(long r14) {
        if (r14 != 0) goto L5;
        T(48);
        return;
    L5:
        int r5 = 1;
        if (r14 >= 0) goto L11;
        r14 = -r14;
        if (r14 >= 0) goto L10;
        b0("-9223372036854775808");
        return;
    L10:
        boolean r10 = true;
    L13:
        if (r14 >= 100000000) goto L37;
        if (r14 >= 10000) goto L27;
        if (r14 >= 100) goto L23;
        if (r14 < 10) goto L67;
        r5 = 2;
    L67:
        if (r10 == false) goto L69;
        r5 = r5 + 1;
    L69:
        y r11 = P(r5);
        int r12 = r11.f20354c + r5;
    L70:
        byte[] r13 = r11.f20352a;
        if (r14 == 0) goto L73;
        long r15 = 10;
        r12 = r12 - 1;
        r13[r12] = ou.a.f21306a[(int) (r14 % r15)];
        r14 = r14 / r15;
        goto L70
    L73:
        if (r10 == false) goto L75;
        r13[r12 - 1] = (byte) 45;
    L75:
        r11.f20354c += r5;
        this.f20328b += (long) r5;
        return;
    L23:
        if (r14 >= 1000) goto L25;
        r5 = 3;
        goto L67
    L25:
        r5 = 4;
        goto L67
    L27:
        if (r14 >= 1000000) goto L33;
        if (r14 >= 100000) goto L31;
        r5 = 5;
        goto L67
    L31:
        r5 = 6;
        goto L67
    L33:
        if (r14 >= 10000000) goto L35;
        r5 = 7;
        goto L67
    L35:
        r5 = 8;
        goto L67
    L37:
        if (r14 >= 1000000000000L) goto L49;
        if (r14 >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) goto L45;
        if (r14 >= 1000000000) goto L43;
        r5 = 9;
        goto L67
    L43:
        r5 = 10;
        goto L67
    L45:
        if (r14 >= 100000000000L) goto L47;
        r5 = 11;
        goto L67
    L47:
        r5 = 12;
        goto L67
    L49:
        if (r14 >= 1000000000000000L) goto L58;
        if (r14 >= 10000000000000L) goto L54;
        r5 = 13;
        goto L67
    L54:
        if (r14 >= 100000000000000L) goto L56;
        r5 = 14;
        goto L67
    L56:
        r5 = 15;
        goto L67
    L58:
        if (r14 >= 100000000000000000L) goto L64;
        if (r14 >= 10000000000000000L) goto L62;
        r5 = 16;
        goto L67
    L62:
        r5 = 17;
        goto L67
    L64:
        if (r14 >= 1000000000000000000L) goto L66;
        r5 = 18;
        goto L67
    L66:
        r5 = 19;
        goto L67
    L11:
        r10 = false;
        goto L13
    }

    public final void V(long r13) {
        if (r13 != 0) goto L5;
        T(48);
        return;
    L5:
        long r5 = (r13 >>> 1) | r13;
        long r10 = r5 | (r5 >>> 2);
        long r11 = r10 | (r10 >>> 4);
        long r12 = r11 | (r11 >>> 8);
        long r14 = r12 | (r12 >>> 16);
        long r15 = r14 | (r14 >>> 32);
        long r16 = r15 - ((r15 >>> 1) & 6148914691236517205L);
        long r17 = ((r16 >>> 2) & 3689348814741910323L) + (r16 & 3689348814741910323L);
        long r18 = ((r17 >>> 4) + r17) & 1085102592571150095L;
        long r19 = r18 + (r18 >>> 8);
        long r20 = r19 + (r19 >>> 16);
        int r21 = (int) ((((r20 & 63) + ((r20 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        y r22 = P(r21);
        int r23 = r22.f20354c;
        int r24 = (r23 + r21) - 1;
    L6:
        if (r24 < r23) goto L8;
        r22.f20352a[r24] = ou.a.f21306a[(int) (15 & r13)];
        r13 = r13 >>> 4;
        r24 = r24 - 1;
        goto L6
    L8:
        r22.f20354c += r21;
        this.f20328b += (long) r21;
    }

    public final void W(int r10) {
        y r5 = P(4);
        int r11 = r5.f20354c;
        byte[] r12 = r5.f20352a;
        r12[r11] = (byte) ((r10 >>> 24) & 255);
        r12[r11 + 1] = (byte) ((r10 >>> 16) & 255);
        r12[r11 + 2] = (byte) ((r10 >>> 8) & 255);
        r12[r11 + 3] = (byte) (r10 & 255);
        r5.f20354c = r11 + 4;
        this.f20328b += 4;
    }

    public final void X(long r11) {
        y r5 = P(8);
        int r10 = r5.f20354c;
        byte[] r12 = r5.f20352a;
        r12[r10] = (byte) ((r11 >>> 56) & 255);
        r12[r10 + 1] = (byte) ((r11 >>> 48) & 255);
        r12[r10 + 2] = (byte) ((r11 >>> 40) & 255);
        r12[r10 + 3] = (byte) ((r11 >>> 32) & 255);
        r12[r10 + 4] = (byte) ((r11 >>> 24) & 255);
        r12[r10 + 5] = (byte) ((r11 >>> 16) & 255);
        r12[r10 + 6] = (byte) ((r11 >>> 8) & 255);
        r12[r10 + 7] = (byte) (r11 & 255);
        r5.f20354c = r10 + 8;
        this.f20328b += 8;
    }

    public final void Y(int r10) {
        y r5 = P(2);
        int r11 = r5.f20354c;
        byte[] r12 = r5.f20352a;
        r12[r11] = (byte) ((r10 >>> 8) & 255);
        r12[r11 + 1] = (byte) (r10 & 255);
        r5.f20354c = r11 + 2;
        this.f20328b += 2;
    }

    @Override // nu.l
    public final void a(j r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "sink");
        long r11 = this.f20328b;
        if (r11 < r10) goto L6;
        r5.write(this, r10);
        return;
    L6:
        r5.write(this, r11);
        throw new EOFException();
    }

    public final void a0(int r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "string");
        if (r10 < 0) goto L45;
        if (r11 < r10) goto L43;
        if (r11 > r12.length()) goto L40;
    L7:
        if (r10 >= r11) goto L39;
        char r5 = r12.charAt(r10);
        if (r5 < 128) goto L10;
        if (r5 < 2048) goto L19;
        if (r5 < 55296) goto L38;
        if (r5 > 57343) goto L38;
        int r13 = r10 + 1;
        if (r13 >= r11) goto L29;
        char r14 = r12.charAt(r13);
    L31:
        if (r5 > 56319) goto L37;
        if (56320 > r14) goto L37;
        if (57343 < r14) goto L37;
        int r15 = (((r5 & 1023) << 10) | (r14 & 1023)) + 65536;
        y r16 = P(4);
        int r17 = r16.f20354c;
        byte[] r18 = r16.f20352a;
        r18[r17] = (byte) ((r15 >> 18) | 240);
        r18[r17 + 1] = (byte) (((r15 >> 12) & 63) | 128);
        r18[r17 + 2] = (byte) (((r15 >> 6) & 63) | 128);
        r18[r17 + 3] = (byte) ((r15 & 63) | 128);
        r16.f20354c = r17 + 4;
        this.f20328b += 4;
        r10 = r10 + 2;
    L37:
        T(63);
        r10 = r13;
        goto L7
    L29:
        r14 = 0;
    L38:
        y r19 = P(3);
        int r20 = r19.f20354c;
        byte[] r21 = r19.f20352a;
        r21[r20] = (byte) ((r5 >> '\f') | 224);
        r21[r20 + 1] = (byte) ((63 & (r5 >> 6)) | 128);
        r21[r20 + 2] = (byte) ((r5 & '?') | 128);
        r19.f20354c = r20 + 3;
        this.f20328b += 3;
    L20:
        r10 = r10 + 1;
        goto L7
    L19:
        y r22 = P(2);
        int r23 = r22.f20354c;
        byte[] r24 = r22.f20352a;
        r24[r23] = (byte) ((r5 >> 6) | 192);
        r24[r23 + 1] = (byte) ((r5 & '?') | 128);
        r22.f20354c = r23 + 2;
        this.f20328b += 2;
        goto L20
    L10:
        y r25 = P(1);
        int r26 = r25.f20354c - r10;
        int r27 = Math.min(r11, 8192 - r26);
        int r28 = r10 + 1;
        byte[] r29 = r25.f20352a;
        r29[r10 + r26] = (byte) r5;
    L11:
        if (r28 >= r27) goto L16;
        char r110 = r12.charAt(r28);
        if (r110 >= 128) goto L16;
        r29[r28 + r26] = (byte) r110;
        r28 = r28 + 1;
    L16:
        int r111 = r25.f20354c;
        int r30 = (r26 + r28) - r111;
        r25.f20354c = r111 + r30;
        this.f20328b += (long) r30;
        r10 = r28;
        goto L7
    L39:
        return;
    L40:
        StringBuilder r31 = j0.s(r11, "endIndex > string.length: ", " > ");
        r31.append(r12.length());
        throw new IllegalArgumentException(r31.toString().toString());
    L43:
        throw new IllegalArgumentException(j0.f(r11, r10, "endIndex < beginIndex: ", " < ").toString());
    L45:
        throw new IllegalArgumentException(j0.g(r10, "beginIndex < 0: ").toString());
    }

    public final void b() {
        skip(this.f20328b);
    }

    public final void b0(String r5) {
        Intrinsics.checkNotNullParameter(r5, "string");
        a0(0, r5.length(), r5);
    }

    @Override // nu.l
    public final String c(long r12) {
        if (r12 < 0) goto L22;
        long r5 = Long.MAX_VALUE;
        if (r12 == Long.MAX_VALUE) goto L8;
        r5 = r12 + 1;
    L8:
        byte r10 = (byte) 10;
        long r11 = n(r10, 0, r5);
        if (r11 == (-1)) goto L12;
        return ou.a.a(this, r11);
    L12:
        if (r5 < this.f20328b) goto L14;
    L19:
        j r13 = new j();
        g(0, r13, Math.min(32, this.f20328b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f20328b, r12) + " content=" + r13.v(r13.f20328b).hex() + 8230);
    L14:
        if (m(r5 - 1) != ((byte) 13)) goto L19;
        if (m(r5) != r10) goto L19;
        return ou.a.a(this, r5);
    L22:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r12, "limit < 0: ").toString());
    }

    public final void c0(int r19) {
        int r5 = 0;
        if (r19 >= 128) goto L6;
        T(r19);
        return;
    L6:
        if (r19 >= 2048) goto L9;
        y r10 = P(2);
        int r11 = r10.f20354c;
        byte[] r12 = r10.f20352a;
        r12[r11] = (byte) ((r19 >> 6) | 192);
        r12[1 + r11] = (byte) ((r19 & 63) | 128);
        r10.f20354c = r11 + 2;
        this.f20328b += 2;
        return;
    L9:
        if (55296 > r19) goto L15;
        if (57343 < r19) goto L15;
        T(63);
        return;
    L15:
        if (r19 >= 65536) goto L18;
        y r13 = P(3);
        int r14 = r13.f20354c;
        byte[] r15 = r13.f20352a;
        r15[r14] = (byte) ((r19 >> 12) | 224);
        r15[1 + r14] = (byte) (((r19 >> 6) & 63) | 128);
        r15[2 + r14] = (byte) ((r19 & 63) | 128);
        r13.f20354c = r14 + 3;
        this.f20328b += 3;
        return;
    L18:
        if (r19 > 1114111) goto L21;
        y r16 = P(4);
        int r17 = r16.f20354c;
        byte[] r18 = r16.f20352a;
        r18[r17] = (byte) ((r19 >> 18) | 240);
        r18[1 + r17] = (byte) (((r19 >> 12) & 63) | 128);
        r18[2 + r17] = (byte) (((r19 >> 6) & 63) | 128);
        r18[3 + r17] = (byte) ((r19 & 63) | 128);
        r16.f20354c = r17 + 4;
        this.f20328b += 4;
        return;
    L21:
        StringBuilder r20 = new StringBuilder("Unexpected code point: 0x");
        if (r19 == 0) goto L29;
        char[] r110 = ou.b.f21307a;
        char[] r111 = {r110[(r19 >> 28) & 15], r110[(r19 >> 24) & 15], r110[(r19 >> 20) & 15], r110[(r19 >> 16) & 15], r110[(r19 >> 12) & 15], r110[(r19 >> 8) & 15], r110[(r19 >> 4) & 15], r110[r19 & 15]};
    L24:
        if (r5 >= 8) goto L28;
        if (r111[r5] != '0') goto L28;
        r5 = r5 + 1;
    L28:
        String r21 = new String(r111, r5, 8 - r5);
    L30:
        r20.append(r21);
        throw new IllegalArgumentException(r20.toString());
    L29:
        r21 = "0";
        goto L30
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return e();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, nu.a0
    public final void close() {
    }

    public final j e() {
        j r5 = new j();
        if (this.f20328b == 0) goto L9;
        y r10 = this.f20327a;
        Intrinsics.checkNotNull(r10);
        y r11 = r10.c();
        r5.f20327a = r11;
        r11.g = r11;
        r11.f = r11;
        y r12 = r10.f;
    L6:
        if (r12 == r10) goto L8;
        y r13 = r11.g;
        Intrinsics.checkNotNull(r13);
        Intrinsics.checkNotNull(r12);
        r13.b(r12.c());
        r12 = r12.f;
        goto L6
    L8:
        r5.f20328b = this.f20328b;
    L9:
        return r5;
    }

    public final boolean equals(Object r19) {
        if (this != r19) goto L6;
    L4:
        return true;
    L6:
        if ((r19 instanceof j) == true) goto L8;
    L7:
        return false;
    L8:
        long r5 = this.f20328b;
        j r10 = (j) r19;
        if (r5 != r10.f20328b) goto L7;
        if (r5 == 0) goto L4;
        y r11 = this.f20327a;
        Intrinsics.checkNotNull(r11);
        y r12 = r10.f20327a;
        Intrinsics.checkNotNull(r12);
        int r13 = r11.f20353b;
        int r14 = r12.f20353b;
        long r15 = 0;
    L16:
        if (r15 >= this.f20328b) goto L4;
        long r16 = Math.min(r11.f20354c - r13, r12.f20354c - r14);
        long r17 = 0;
    L19:
        if (r17 >= r16) goto L25;
        int r18 = r13 + 1;
        byte r20 = r11.f20352a[r13];
        int r21 = r14 + 1;
        if (r20 != r12.f20352a[r14]) goto L7;
        r17 = r17 + 1;
        r14 = r21;
        r13 = r18;
        goto L19
    L25:
        if (r13 != r11.f20354c) goto L28;
        y r22 = r11.f;
        Intrinsics.checkNotNull(r22);
        r13 = r22.f20353b;
        r11 = r22;
    L28:
        if (r14 != r12.f20354c) goto L30;
        r12 = r12.f;
        Intrinsics.checkNotNull(r12);
        r14 = r12.f20353b;
    L30:
        r15 = r15 + r16;
        goto L16
    }

    public final long f() {
        long r5 = this.f20328b;
        if (r5 == 0) goto L12;
        y r10 = this.f20327a;
        Intrinsics.checkNotNull(r10);
        y r11 = r10.g;
        Intrinsics.checkNotNull(r11);
        int r12 = r11.f20354c;
        if (r12 >= 8192) goto L11;
        if (r11.e == false) goto L11;
        r5 = r5 - ((long) (r12 - r11.f20353b));
    L11:
        return r5;
    L12:
        return 0;
    }

    @Override // nu.k, nu.a0, java.io.Flushable
    public final void flush() {
    }

    public final void g(long r10, j r11, long r12) {
        Intrinsics.checkNotNullParameter(r11, "out");
        f4.a.d(this.f20328b, r10, r12);
        if (r12 == 0) goto L16;
        r11.f20328b += r12;
        y r13 = this.f20327a;
    L6:
        Intrinsics.checkNotNull(r13);
        long r5 = r13.f20354c - r13.f20353b;
        if (r10 < r5) goto L10;
        r10 = r10 - r5;
        r13 = r13.f;
    L10:
        if (r12 <= 0) goto L21;
        Intrinsics.checkNotNull(r13);
        y r14 = r13.c();
        int r15 = r14.f20353b + ((int) r10);
        r14.f20353b = r15;
        r14.f20354c = Math.min(r15 + ((int) r12), r14.f20354c);
        y r16 = r11.f20327a;
        if (r16 != null) goto L14;
        r14.g = r14;
        r14.f = r14;
        r11.f20327a = r14;
    L15:
        r12 = r12 - ((long) (r14.f20354c - r14.f20353b));
        r13 = r13.f;
        r10 = 0;
        goto L10
    L14:
        Intrinsics.checkNotNull(r16);
        y r17 = r16.g;
        Intrinsics.checkNotNull(r17);
        r17.b(r14);
        goto L15
    L21:
        return;
    }

    @Override // nu.l, nu.k
    public final j h() {
        return this;
    }

    public final int hashCode() {
        y r5 = this.f20327a;
        if (r5 == null) goto L11;
        int r10 = 1;
    L5:
        int r11 = r5.f20353b;
        int r12 = r5.f20354c;
    L6:
        if (r11 >= r12) goto L8;
        r10 = (r10 * 31) + r5.f20352a[r11];
        r11 = r11 + 1;
        goto L6
    L8:
        r5 = r5.f;
        Intrinsics.checkNotNull(r5);
        if (r5 != this.f20327a) goto L5;
        return r10;
    L11:
        return 0;
    }

    @Override // nu.k
    public final k i() {
        return this;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // nu.k
    public final k j(long r5) {
        X(f4.a.m(r5));
        return this;
    }

    @Override // nu.k
    public final k k() {
        return this;
    }

    @Override // nu.k
    public final /* bridge */ /* synthetic */ k l(String r5) {
        b0(r5);
        return this;
    }

    public final byte m(long r10) {
        f4.a.d(this.f20328b, r10, 1);
        y r5 = this.f20327a;
        if (r5 == null) goto L16;
        long r11 = this.f20328b;
        if ((r11 - r10) < r10) goto L7;
        long r12 = 0;
    L11:
        long r13 = ((long) (r5.f20354c - r5.f20353b)) + r12;
        if (r13 > r10) goto L13;
        r5 = r5.f;
        Intrinsics.checkNotNull(r5);
        r12 = r13;
        goto L11
    L13:
        Intrinsics.checkNotNull(r5);
        int r14 = (int) ((((long) r5.f20353b) + r10) - r12);
        return r5.f20352a[r14];
    L7:
        if (r11 <= r10) goto L9;
        r5 = r5.g;
        Intrinsics.checkNotNull(r5);
        r11 = r11 - ((long) (r5.f20354c - r5.f20353b));
        goto L7
    L9:
        Intrinsics.checkNotNull(r5);
        int r15 = (int) ((((long) r5.f20353b) + r10) - r11);
        return r5.f20352a[r15];
    L16:
        Intrinsics.checkNotNull(null);
        throw null;
    }

    public final long n(byte r16, long r17, long r19) {
        long r5 = r17;
        long r10 = r19;
        long r11 = 0;
        if (0 <= r5) goto L6;
    L8:
        boolean r12 = false;
    L9:
        if (r12 == false) goto L45;
        long r13 = this.f20328b;
        if (r10 <= r13) goto L14;
        r10 = r13;
    L14:
        if (r5 != r10) goto L16;
    L15:
        return -1;
    L16:
        y r14 = this.f20327a;
        if (r14 == null) goto L15;
        if ((r13 - r5) < r5) goto L21;
    L32:
        long r15 = ((long) (r14.f20354c - r14.f20353b)) + r11;
        if (r15 > r5) goto L35;
        r14 = r14.f;
        Intrinsics.checkNotNull(r14);
        r11 = r15;
    L35:
        if (r11 >= r10) goto L15;
        byte[] r18 = r14.f20352a;
        int r20 = (int) Math.min(r14.f20354c, (((long) r14.f20353b) + r10) - r11);
        int r21 = (int) ((((long) r14.f20353b) + r5) - r11);
    L37:
        if (r21 >= r20) goto L42;
        if (r18[r21] == r16) goto L56;
        r21 = r21 + 1;
        goto L37
    L56:
        return ((long) (r21 - r14.f20353b)) + r11;
    L42:
        r11 = r11 + ((long) (r14.f20354c - r14.f20353b));
        r14 = r14.f;
        Intrinsics.checkNotNull(r14);
        r5 = r11;
    L21:
        if (r13 <= r5) goto L24;
        r14 = r14.g;
        Intrinsics.checkNotNull(r14);
        r13 = r13 - ((long) (r14.f20354c - r14.f20353b));
    L24:
        if (r13 >= r10) goto L15;
        byte[] r22 = r14.f20352a;
        int r23 = (int) Math.min(r14.f20354c, (((long) r14.f20353b) + r10) - r13);
        int r24 = (int) ((((long) r14.f20353b) + r5) - r13);
    L26:
        if (r24 >= r23) goto L31;
        if (r22[r24] == r16) goto L55;
        r24 = r24 + 1;
        goto L26
    L55:
        return ((long) (r24 - r14.f20353b)) + r13;
    L31:
        r13 = r13 + ((long) (r14.f20354c - r14.f20353b));
        r14 = r14.f;
        Intrinsics.checkNotNull(r14);
        r5 = r13;
        goto L24
    L45:
        StringBuilder r25 = new StringBuilder("size=");
        r25.append(this.f20328b);
        kotlin.collections.a.o(r25, " fromIndex=", r5, " toIndex=");
        r25.append(r10);
        throw new IllegalArgumentException(r25.toString().toString());
    L6:
        if (r10 < r5) goto L8;
        r12 = true;
        goto L9
    }

    @Override // nu.l
    public final String o() {
        return c(Long.MAX_VALUE);
    }

    public final long p(ByteString r5) {
        Intrinsics.checkNotNullParameter(r5, "targetBytes");
        return q(r5, 0);
    }

    @Override // nu.l
    public final x peek() {
        return f4.b.e(new v(this));
    }

    public final long q(ByteString r12, long r13) {
        Intrinsics.checkNotNullParameter(r12, "targetBytes");
        long r5 = 0;
        if (r13 < 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L75;
        y r11 = this.f20327a;
        if (r11 == null) goto L73;
        long r14 = this.f20328b;
        if ((r14 - r13) < r13) goto L12;
    L42:
        long r15 = ((long) (r11.f20354c - r11.f20353b)) + r5;
        if (r15 > r13) goto L45;
        r11 = r11.f;
        Intrinsics.checkNotNull(r11);
        r5 = r15;
        goto L42
    L45:
        if (r12.size() != 2) goto L59;
        byte r16 = r12.getByte(0);
        byte r17 = r12.getByte(1);
    L48:
        if (r5 >= this.f20328b) goto L98;
        byte[] r18 = r11.f20352a;
        int r19 = (int) ((((long) r11.f20353b) + r13) - r5);
        int r110 = r11.f20354c;
    L50:
        if (r19 >= r110) goto L58;
        byte r20 = r18[r19];
        if (r20 == r16) goto L56;
        if (r20 == r17) goto L56;
        r19 = r19 + 1;
    L56:
        int r111 = r11.f20353b;
    L95:
        return ((long) (r19 - r111)) + r5;
    L58:
        r5 = r5 + ((long) (r11.f20354c - r11.f20353b));
        r11 = r11.f;
        Intrinsics.checkNotNull(r11);
        r13 = r5;
        goto L48
    L98:
        return -1;
    L59:
        byte[] r112 = r12.internalArray$okio();
    L61:
        if (r5 >= this.f20328b) goto L99;
        byte[] r21 = r11.f20352a;
        r19 = (int) ((((long) r11.f20353b) + r13) - r5);
        int r113 = r11.f20354c;
    L63:
        if (r19 >= r113) goto L71;
        byte r22 = r21[r19];
        int r23 = r112.length;
        int r24 = 0;
    L65:
        if (r24 >= r23) goto L70;
        if (r22 == r112[r24]) goto L68;
        r24 = r24 + 1;
        goto L65
    L68:
        r111 = r11.f20353b;
        goto L95
    L70:
        r19 = r19 + 1;
        goto L63
    L71:
        r5 = r5 + ((long) (r11.f20354c - r11.f20353b));
        r11 = r11.f;
        Intrinsics.checkNotNull(r11);
        r13 = r5;
        goto L61
    L99:
        return -1;
    L12:
        if (r14 <= r13) goto L15;
        r11 = r11.g;
        Intrinsics.checkNotNull(r11);
        r14 = r14 - ((long) (r11.f20354c - r11.f20353b));
        goto L12
    L15:
        if (r12.size() != 2) goto L29;
        byte r25 = r12.getByte(0);
        byte r114 = r12.getByte(1);
    L18:
        if (r14 >= this.f20328b) goto L96;
        byte[] r26 = r11.f20352a;
        int r115 = (int) ((((long) r11.f20353b) + r13) - r14);
        int r116 = r11.f20354c;
    L20:
        if (r115 >= r116) goto L28;
        byte r27 = r26[r115];
        if (r27 == r25) goto L26;
        if (r27 == r114) goto L26;
        r115 = r115 + 1;
    L26:
        int r117 = r11.f20353b;
    L94:
        return ((long) (r115 - r117)) + r14;
    L28:
        r14 = r14 + ((long) (r11.f20354c - r11.f20353b));
        r11 = r11.f;
        Intrinsics.checkNotNull(r11);
        r13 = r14;
        goto L18
    L96:
        return -1;
    L29:
        byte[] r118 = r12.internalArray$okio();
    L31:
        if (r14 >= this.f20328b) goto L97;
        byte[] r28 = r11.f20352a;
        r115 = (int) ((((long) r11.f20353b) + r13) - r14);
        int r119 = r11.f20354c;
    L33:
        if (r115 >= r119) goto L41;
        byte r29 = r28[r115];
        int r30 = r118.length;
        int r31 = 0;
    L35:
        if (r31 >= r30) goto L40;
        if (r29 == r118[r31]) goto L38;
        r31 = r31 + 1;
        goto L35
    L38:
        r117 = r11.f20353b;
        goto L94
    L40:
        r115 = r115 + 1;
        goto L33
    L41:
        r14 = r14 + ((long) (r11.f20354c - r11.f20353b));
        r11 = r11.f;
        Intrinsics.checkNotNull(r11);
        r13 = r14;
        goto L31
    L97:
        return -1;
    L73:
        return -1;
    L75:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r13, "fromIndex < 0: ").toString());
    L5:
        r10 = false;
        goto L6
    }

    @Override // nu.l
    public final long r() {
        return f4.a.m(readLong());
    }

    @Override // nu.c0
    public final long read(j r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "sink");
        if (r10 < 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L16;
        long r12 = this.f20328b;
        if (r12 != 0) goto L11;
        return -1;
    L11:
        if (r10 <= r12) goto L13;
        r10 = r12;
    L13:
        r5.write(this, r10);
        return r10;
    L16:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r10, "byteCount < 0: ").toString());
    L5:
        r11 = false;
        goto L6
    }

    @Override // nu.l
    public final byte readByte() {
        if (this.f20328b == 0) goto L10;
        y r5 = this.f20327a;
        Intrinsics.checkNotNull(r5);
        int r10 = r5.f20353b;
        int r11 = r5.f20354c;
        int r12 = r10 + 1;
        byte r13 = r5.f20352a[r10];
        this.f20328b--;
        if (r12 != r11) goto L7;
        this.f20327a = r5.a();
        z.a(r5);
    L8:
        return r13;
    L7:
        r5.f20353b = r12;
        goto L8
    L10:
        throw new EOFException();
    }

    @Override // nu.l
    public final void readFully(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "sink");
        int r10 = 0;
    L4:
        if (r10 >= r5.length) goto L10;
        int r11 = read(r5, r10, r5.length - r10);
        if (r11 == (-1)) goto L9;
        r10 = r10 + r11;
        goto L4
    L9:
        throw new EOFException();
    }

    @Override // nu.l
    public final int readInt() {
        if (this.f20328b < 4) goto L14;
        y r5 = this.f20327a;
        Intrinsics.checkNotNull(r5);
        int r10 = r5.f20353b;
        int r11 = r5.f20354c;
        if ((r11 - r10) < 4) goto L15;
        byte[] r12 = r5.f20352a;
        int r13 = ((r12[r10 + 1] & UByte.MAX_VALUE) << 16) | ((r12[r10] & UByte.MAX_VALUE) << 24);
        int r14 = r10 + 3;
        int r15 = r13 | ((r12[r10 + 2] & UByte.MAX_VALUE) << 8);
        int r16 = r10 + 4;
        int r17 = r15 | (r12[r14] & UByte.MAX_VALUE);
        this.f20328b -= 4;
        if (r16 != r11) goto L10;
        this.f20327a = r5.a();
        z.a(r5);
    L12:
        return r17;
    L10:
        r5.f20353b = r16;
        goto L12
    L15:
        return (readByte() & UByte.MAX_VALUE) | ((((readByte() & UByte.MAX_VALUE) << 24) | ((readByte() & UByte.MAX_VALUE) << 16)) | ((readByte() & UByte.MAX_VALUE) << 8));
    L14:
        throw new EOFException();
    }

    @Override // nu.l
    public final long readLong() {
        if (this.f20328b < 8) goto L14;
        y r5 = this.f20327a;
        Intrinsics.checkNotNull(r5);
        int r10 = r5.f20353b;
        int r11 = r5.f20354c;
        if ((r11 - r10) < 8) goto L15;
        byte[] r12 = r5.f20352a;
        long r13 = ((((((long) r12[r10 + 3]) & 255) << 32) | ((((((long) r12[r10]) & 255) << 56) | ((((long) r12[r10 + 1]) & 255) << 48)) | ((((long) r12[r10 + 2]) & 255) << 40))) | ((((long) r12[r10 + 4]) & 255) << 24)) | ((((long) r12[r10 + 5]) & 255) << 16);
        int r14 = r10 + 7;
        long r15 = r13 | ((((long) r12[r10 + 6]) & 255) << 8);
        int r16 = r10 + 8;
        long r17 = r15 | (((long) r12[r14]) & 255);
        this.f20328b -= 8;
        if (r16 != r11) goto L10;
        this.f20327a = r5.a();
        z.a(r5);
    L12:
        return r17;
    L10:
        r5.f20353b = r16;
        goto L12
    L15:
        return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
    L14:
        throw new EOFException();
    }

    @Override // nu.l
    public final short readShort() {
        if (this.f20328b < 2) goto L14;
        y r5 = this.f20327a;
        Intrinsics.checkNotNull(r5);
        int r10 = r5.f20353b;
        int r11 = r5.f20354c;
        if ((r11 - r10) < 2) goto L15;
        int r12 = r10 + 1;
        byte[] r13 = r5.f20352a;
        int r14 = (r13[r10] & UByte.MAX_VALUE) << 8;
        int r15 = r10 + 2;
        int r16 = (r13[r12] & UByte.MAX_VALUE) | r14;
        this.f20328b -= 2;
        if (r15 != r11) goto L10;
        this.f20327a = r5.a();
        z.a(r5);
    L12:
        return (short) r16;
    L10:
        r5.f20353b = r15;
        goto L12
    L15:
        return (short) ((readByte() & UByte.MAX_VALUE) | ((readByte() & UByte.MAX_VALUE) << 8));
    L14:
        throw new EOFException();
    }

    @Override // nu.l
    public final boolean request(long r5) {
        if (this.f20328b < r5) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // nu.l
    public final void s(long r5) {
        if (this.f20328b < r5) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // nu.l
    public final void skip(long r10) {
    L3:
        if (r10 <= 0) goto L11;
        y r5 = this.f20327a;
        if (r5 == null) goto L10;
        int r11 = (int) Math.min(r10, r5.f20354c - r5.f20353b);
        long r12 = r11;
        this.f20328b -= r12;
        r10 = r10 - r12;
        int r13 = r5.f20353b + r11;
        r5.f20353b = r13;
        if (r13 != r5.f20354c) goto L3;
        this.f20327a = r5.a();
        z.a(r5);
        goto L3
    L10:
        throw new EOFException();
    }

    @Override // nu.k
    public final /* bridge */ /* synthetic */ k t(long r5) {
        U(r5);
        return this;
    }

    @Override // nu.c0
    public final f0 timeout() {
        return f0.NONE;
    }

    public final String toString() {
        long r5 = this.f20328b;
        if (r5 > Integer.MAX_VALUE) goto L7;
        return O((int) r5).toString();
    L7:
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f20328b).toString());
    }

    @Override // nu.l
    public final String u(long r5) {
        return L(r5, Charsets.UTF_8);
    }

    @Override // nu.l
    public final ByteString v(long r5) {
        if (r5 >= 0) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L19;
        if (this.f20328b < r5) goto L17;
        if (r5 < 4096) goto L15;
        ByteString r11 = O((int) r5);
        skip(r5);
        return r11;
    L15:
        return new ByteString(K(r5));
    L17:
        throw new EOFException();
    L19:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r5, "byteCount: ").toString());
    L5:
        if (r5 > Integer.MAX_VALUE) goto L7;
        r10 = true;
        goto L8
    }

    @Override // nu.l
    public final byte[] w() {
        return K(this.f20328b);
    }

    @Override // nu.k
    public final /* bridge */ /* synthetic */ k write(byte[] r5) {
        R(r5);
        return this;
    }

    @Override // nu.k
    public final /* bridge */ /* synthetic */ k writeByte(int r5) {
        T(r5);
        return this;
    }

    @Override // nu.k
    public final /* bridge */ /* synthetic */ k writeInt(int r5) {
        W(r5);
        return this;
    }

    @Override // nu.k
    public final /* bridge */ /* synthetic */ k writeShort(int r5) {
        Y(r5);
        return this;
    }

    @Override // nu.k
    public final k x(int r5) {
        W(f4.a.l(r5));
        return this;
    }

    @Override // nu.l
    public final boolean y() {
        if (this.f20328b != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // nu.l
    public final long z(j r5) {
        Intrinsics.checkNotNullParameter(r5, "sink");
        long r10 = this.f20328b;
        if (r10 <= 0) goto L5;
        r5.write(this, r10);
    L5:
        return r10;
    }

    @Override // nu.k
    public final /* bridge */ /* synthetic */ k write(byte[] r5, int r10, int r11) {
        S(r5, r10, r11);
        return this;
    }

    @Override // nu.a0
    public final void write(j r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        if (r10 == this) goto L55;
        f4.a.d(r10.f20328b, 0, r11);
    L6:
        if (r11 <= 0) goto L65;
        y r5 = r10.f20327a;
        Intrinsics.checkNotNull(r5);
        int r12 = r5.f20354c;
        y r13 = r10.f20327a;
        Intrinsics.checkNotNull(r13);
        long r14 = r12 - r13.f20353b;
        int r15 = 0;
        if (r11 >= r14) goto L34;
        y r16 = this.f20327a;
        if (r16 == null) goto L12;
        Intrinsics.checkNotNull(r16);
        y r17 = r16.g;
    L13:
        if (r17 != null) goto L15;
    L23:
        y r18 = r10.f20327a;
        Intrinsics.checkNotNull(r18);
        int r19 = (int) r11;
        r18.getClass();
        if (r19 <= 0) goto L33;
        if (r19 > (r18.f20354c - r18.f20353b)) goto L33;
        if (r19 < 1024) goto L30;
        y r20 = r18.c();
    L31:
        r20.f20354c = r20.f20353b + r19;
        r18.f20353b += r19;
        y r21 = r18.g;
        Intrinsics.checkNotNull(r21);
        r21.b(r20);
        r10.f20327a = r20;
        goto L34
    L30:
        r20 = z.b();
        int r22 = r18.f20353b;
        byte[] r23 = r20.f20352a;
        ArraysKt.e(r18.f20352a, r22, r22 + r19, r23);
    L33:
        throw new IllegalArgumentException("byteCount out of range");
    L15:
        if (r17.e == false) goto L23;
        long r24 = ((long) r17.f20354c) + r11;
        if (r17.d == false) goto L19;
        int r25 = 0;
    L21:
        if ((r24 - ((long) r25)) > 8192) goto L23;
        y r26 = r10.f20327a;
        Intrinsics.checkNotNull(r26);
        r26.d(r17, (int) r11);
        r10.f20328b -= r11;
        this.f20328b += r11;
        return;
    L19:
        r25 = r17.f20353b;
        goto L21
    L12:
        r17 = null;
    L34:
        y r27 = r10.f20327a;
        Intrinsics.checkNotNull(r27);
        long r28 = r27.f20354c - r27.f20353b;
        r10.f20327a = r27.a();
        y r29 = this.f20327a;
        if (r29 != null) goto L37;
        this.f20327a = r27;
        r27.g = r27;
        r27.f = r27;
    L50:
        r10.f20328b -= r28;
        this.f20328b += r28;
        r11 = r11 - r28;
        goto L6
    L37:
        Intrinsics.checkNotNull(r29);
        y r30 = r29.g;
        Intrinsics.checkNotNull(r30);
        r30.b(r27);
        y r31 = r27.g;
        if (r31 == r27) goto L52;
        Intrinsics.checkNotNull(r31);
        if (r31.e == false) goto L50;
        int r32 = r27.f20354c - r27.f20353b;
        y r33 = r27.g;
        Intrinsics.checkNotNull(r33);
        int r34 = 8192 - r33.f20354c;
        y r35 = r27.g;
        Intrinsics.checkNotNull(r35);
        if (r35.d == true) goto L47;
        y r36 = r27.g;
        Intrinsics.checkNotNull(r36);
        r15 = r36.f20353b;
    L47:
        if (r32 > (r34 + r15)) goto L50;
        y r37 = r27.g;
        Intrinsics.checkNotNull(r37);
        r27.d(r37, r32);
        r27.a();
        z.a(r27);
        goto L50
    L52:
        throw new IllegalStateException("cannot compact");
    L65:
        return;
    L55:
        throw new IllegalArgumentException("source == this");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer r10) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        y r5 = this.f20327a;
        if (r5 == null) goto L8;
        int r11 = Math.min(r10.remaining(), r5.f20354c - r5.f20353b);
        r10.put(r5.f20352a, r5.f20353b, r11);
        int r12 = r5.f20353b + r11;
        r5.f20353b = r12;
        this.f20328b -= (long) r11;
        if (r12 != r5.f20354c) goto L7;
        this.f20327a = r5.a();
        z.a(r5);
    L7:
        return r11;
    L8:
        return -1;
    }

    public final int read(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        f4.a.d(r10.length, r11, r12);
        y r5 = this.f20327a;
        if (r5 == null) goto L7;
        int r13 = Math.min(r12, r5.f20354c - r5.f20353b);
        int r14 = r5.f20353b;
        ArraysKt.copyInto(r5.f20352a, r10, r11, r14, r14 + r13);
        int r15 = r5.f20353b + r13;
        r5.f20353b = r15;
        this.f20328b -= (long) r13;
        if (r15 != r5.f20354c) goto L9;
        this.f20327a = r5.a();
        z.a(r5);
        return r13;
    L9:
        return r13;
    L7:
        return -1;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        int r5 = r10.remaining();
        int r11 = r5;
    L3:
        if (r11 <= 0) goto L5;
        y r12 = P(1);
        int r13 = Math.min(r11, 8192 - r12.f20354c);
        r10.get(r12.f20352a, r12.f20354c, r13);
        r11 = r11 - r13;
        r12.f20354c += r13;
        goto L3
    L5:
        this.f20328b += (long) r5;
        return r5;
    }
}
