package nu;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f20333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f20334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Inflater f20335c;
    public final s d;
    public final CRC32 e;

    public r(c0 r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        x r10 = new x(r5);
        this.f20334b = r10;
        Inflater r11 = new Inflater(true);
        this.f20335c = r11;
        this.d = new s(r10, r11);
        this.e = new CRC32();
    }

    public static void b(int r5, int r10, String r11) {
        if (r10 != r5) goto L5;
        return;
    L5:
        throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{r11, Integer.valueOf(r10), Integer.valueOf(r5)}, 3)));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.d.close();
    }

    public final void d(long r5, j r10, long r11) {
        y r12 = r10.f20327a;
        Intrinsics.checkNotNull(r12);
    L3:
        int r13 = r12.f20354c;
        int r14 = r12.f20353b;
        if (r5 < (r13 - r14)) goto L7;
        r5 = r5 - ((long) (r13 - r14));
        r12 = r12.f;
        Intrinsics.checkNotNull(r12);
    L7:
        if (r11 <= 0) goto L9;
        int r15 = (int) (((long) r12.f20353b) + r5);
        int r16 = (int) Math.min(r12.f20354c - r15, r11);
        this.e.update(r12.f20352a, r15, r16);
        r11 = r11 - ((long) r16);
        r12 = r12.f;
        Intrinsics.checkNotNull(r12);
        r5 = 0;
        goto L7
    }

    @Override // nu.c0
    public final long read(j r27, long r28) {
        Intrinsics.checkNotNullParameter(r27, "sink");
        if (r28 < 0) goto L64;
        if (r28 != 0) goto L6;
        return 0;
    L6:
        byte r5 = this.f20333a;
        CRC32 r10 = this.e;
        x r15 = this.f20334b;
        if (r5 != 0) goto L47;
        r15.s(10);
        j r14 = r15.f20349a;
        byte r20 = r14.m(3);
        if (((r20 >> 1) & 1) != 1) goto L11;
        boolean r21 = true;
    L12:
        if (r21 == false) goto L14;
        d(0, r14, 10);
    L14:
        b(8075, r15.readShort(), "ID1ID2");
        r15.skip(8);
        if (((r20 >> 2) & 1) != 1) goto L25;
        r15.s(2);
        if (r21 == false) goto L19;
        d(0, r14, 2);
    L19:
        short r11 = r14.readShort();
        long r12 = (short) (((r11 & 255) << 8) | ((r11 & 65280) >>> 8));
        r15.s(r12);
        if (r21 == false) goto L22;
        d(0, r14, r12);
        long r13 = r12;
    L23:
        r15.skip(r13);
        goto L25
    L22:
        r13 = r12;
    L25:
        if (((r20 >> 3) & 1) != 1) goto L34;
        j r25 = r14;
        long r16 = r15.b((byte) 0, 0, Long.MAX_VALUE);
        if (r16 == (-1)) goto L33;
        if (r21 == false) goto L31;
        d(0, r25, r16 + 1);
    L31:
        r4.skip(r16 + 1);
    L36:
        if (((r20 >> 4) & 1) != 1) goto L44;
        long r17 = r15.b((byte) 0, 0, Long.MAX_VALUE);
        if (r17 == (-1)) goto L43;
        if (r21 == false) goto L41;
        d(0, r25, r17 + 1);
    L41:
        r15.skip(r17 + 1);
        goto L44
    L43:
        throw new EOFException();
    L44:
        if (r21 == false) goto L46;
        r15.s(2);
        short r18 = r25.readShort();
        b((short) (((r18 & 255) << 8) | ((r18 & 65280) >>> 8)), (short) r10.getValue(), "FHCRC");
        r10.reset();
    L46:
        this.f20333a = 1;
    L49:
        if (this.f20333a != 1) goto L56;
        long r19 = r27.f20328b;
        long r22 = this.d.read(r27, r28);
        if (r22 == (-1)) goto L54;
        d(r19, r27, r22);
        return r22;
    L54:
        this.f20333a = 2;
    L56:
        if (this.f20333a != 2) goto L59;
        b(r15.E(), (int) r10.getValue(), "CRC");
        b(r15.E(), (int) this.f20335c.getBytesWritten(), "ISIZE");
        this.f20333a = 3;
        if (r15.y() == false) goto L61;
        return -1;
    L61:
        throw new IOException("gzip finished without exhausting source");
    L59:
        return -1;
    L33:
        throw new EOFException();
    L34:
        r25 = r14;
        goto L36
    L11:
        r21 = false;
        goto L12
    L47:
        r15 = r15;
        goto L49
    L64:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r28, "byteCount < 0: ").toString());
    }

    @Override // nu.c0
    public final f0 timeout() {
        return this.f20334b.f20351c.timeout();
    }
}
