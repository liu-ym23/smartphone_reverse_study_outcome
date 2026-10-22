package jf;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f8848b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Inflater f8849m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final l f8850n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CRC32 f8851o;

    public k(w r8) {
        this.f8847a = 0;
        this.f8851o = new CRC32();
        if (r8 == null) goto L7;
        Inflater r10 = new Inflater(true);
        this.f8849m = r10;
        Logger r11 = p.f8861a;
        r r12 = new r(r8);
        this.f8848b = r12;
        this.f8850n = new l(r12, r10);
        return;
    L7:
        throw new IllegalArgumentException("source == null");
    }

    public static void a(int r8, int r10, String r11) {
        if (r10 != r8) goto L5;
        return;
    L5:
        throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{r11, Integer.valueOf(r10), Integer.valueOf(r8)}));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f8850n.close();
    }

    public final void i(d r8, long r10, long r11) {
        s r12 = r8.f8829a;
    L3:
        int r13 = r12.f8872c;
        int r14 = r12.f8871b;
        if (r10 < (r13 - r14)) goto L7;
        r10 = r10 - ((long) (r13 - r14));
        r12 = r12.f8875f;
    L7:
        if (r11 <= 0) goto L9;
        int r15 = (int) (((long) r12.f8871b) + r10);
        int r16 = (int) Math.min(r12.f8872c - r15, r11);
        this.f8851o.update(r12.f8870a, r15, r16);
        r11 = r11 - ((long) r16);
        r12 = r12.f8875f;
        r10 = 0;
        goto L7
    }

    @Override // jf.w
    public final x timeout() {
        return this.f8848b.timeout();
    }

    @Override // jf.w
    public final long u(d r28, long r29) {
        if (r29 < 0) goto L65;
        if (r29 != 0) goto L6;
        return 0;
    L6:
        int r8 = this.f8847a;
        CRC32 r10 = this.f8851o;
        r r15 = this.f8848b;
        if (r8 != 0) goto L47;
        r15.L(10);
        d r14 = r15.f8866a;
        byte r20 = r14.n(3);
        if (((r20 >> 1) & 1) != 1) goto L11;
        boolean r21 = true;
    L12:
        if (r21 == false) goto L14;
        i(r15.f8866a, 0, 10);
    L14:
        a(8075, r15.readShort(), "ID1ID2");
        r15.skip(8);
        if (((r20 >> 2) & 1) != 1) goto L25;
        r15.L(2);
        if (r21 == false) goto L19;
        i(r15.f8866a, 0, 2);
    L19:
        short r11 = r14.readShort();
        Charset r12 = y.f8885a;
        int r13 = r11 & 65535;
        long r16 = (short) (((r13 & 255) << 8) | ((r13 & 65280) >>> 8));
        r15.L(r16);
        if (r21 == false) goto L22;
        i(r15.f8866a, 0, r16);
        long r17 = r16;
    L23:
        r15.skip(r17);
        goto L25
    L22:
        r17 = r16;
    L25:
        if (((r20 >> 3) & 1) != 1) goto L34;
        r r18 = r15;
        long r19 = r15.a((byte) 0, 0, Long.MAX_VALUE);
        if (r19 == (-1)) goto L33;
        if (r21 == false) goto L31;
        i(r18.f8866a, 0, r19 + 1);
    L31:
        r18.skip(r19 + 1);
    L36:
        if (((r20 >> 4) & 1) != 1) goto L44;
        long r110 = r18.a((byte) 0, 0, Long.MAX_VALUE);
        if (r110 == (-1)) goto L43;
        if (r21 == false) goto L41;
        i(r18.f8866a, 0, r110 + 1);
    L41:
        r18.skip(r110 + 1);
        goto L44
    L43:
        throw new EOFException();
    L44:
        if (r21 == false) goto L46;
        r18.L(2);
        short r22 = r14.readShort();
        Charset r23 = y.f8885a;
        int r24 = r22 & 65535;
        a((short) (((r24 & 255) << 8) | ((r24 & 65280) >>> 8)), (short) r10.getValue(), "FHCRC");
        r10.reset();
    L46:
        int r25 = 1;
        this.f8847a = 1;
    L49:
        if (this.f8847a != r25) goto L56;
        long r26 = r28.f8830b;
        long r27 = this.f8850n.u(r28, r29);
        if (r27 == (-1)) goto L54;
        i(r28, r26, r27);
        return r27;
    L54:
        this.f8847a = 2;
    L56:
        if (this.f8847a != 2) goto L62;
        a(r18.i0(), (int) r10.getValue(), "CRC");
        a(r18.i0(), (int) this.f8849m.getBytesWritten(), "ISIZE");
        this.f8847a = 3;
        if (r18.U() == false) goto L61;
        return -1;
    L61:
        throw new IOException("gzip finished without exhausting source");
    L62:
        return -1;
    L33:
        throw new EOFException();
    L34:
        r18 = r15;
        goto L36
    L11:
        r21 = false;
        goto L12
    L47:
        r25 = 1;
        r18 = r15;
        goto L49
    L65:
        throw new IllegalArgumentException(android.aimedia.a.d("byteCount < 0: ", r29));
    }
}
