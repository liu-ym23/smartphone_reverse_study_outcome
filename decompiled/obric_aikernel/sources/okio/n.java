package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nGzipSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GzipSource.kt\nokio/GzipSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 RealBufferedSource.kt\nokio/RealBufferedSource\n+ 4 GzipSource.kt\nokio/-GzipSourceExtensions\n+ 5 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,220:1\n1#2:221\n62#3:222\n62#3:224\n62#3:226\n62#3:227\n62#3:228\n62#3:230\n62#3:232\n202#4:223\n202#4:225\n202#4:229\n202#4:231\n89#5:233\n*S KotlinDebug\n*F\n+ 1 GzipSource.kt\nokio/GzipSource\n*L\n105#1:222\n107#1:224\n119#1:226\n120#1:227\n122#1:228\n133#1:230\n144#1:232\n106#1:223\n117#1:225\n130#1:229\n141#1:231\n187#1:233\n*E\n"})
public final class n implements f0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte f12256c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a0 f12257g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Inflater f12258h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final o f12259i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CRC32 f12260j;

    public n(f0 r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        a0 r11 = new a0(r10);
        this.f12257g = r11;
        Inflater r12 = new Inflater(true);
        this.f12258h = r12;
        this.f12259i = new o(r11, r12);
        this.f12260j = new CRC32();
    }

    private final void a(String r10, int r11, int r12) {
        if (r12 != r11) goto L4;
        return;
    L4:
        String r13 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{r10, Integer.valueOf(r12), Integer.valueOf(r11)}, 3));
        Intrinsics.checkNotNullExpressionValue(r13, "format(this, *args)");
        throw new IOException(r13);
    }

    private final void c() {
        this.f12257g.U(10);
        byte r10 = this.f12257g.f12167g.r(3);
        boolean r11 = true;
        if (((r10 >> 1) & 1) != 1) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        i(this.f12257g.f12167g, 0, 10);
    L8:
        a("ID1ID2", 8075, this.f12257g.readShort());
        this.f12257g.skip(8);
        if (((r10 >> 2) & 1) != 1) goto L11;
        boolean r13 = true;
    L12:
        if (r13 == false) goto L21;
        this.f12257g.U(2);
        if (r12 == false) goto L16;
        i(this.f12257g.f12167g, 0, 2);
    L16:
        long r14 = this.f12257g.f12167g.R() & UShort.MAX_VALUE;
        this.f12257g.U(r14);
        if (r12 == false) goto L19;
        i(this.f12257g.f12167g, 0, r14);
    L19:
        this.f12257g.skip(r14);
    L21:
        if (((r10 >> 3) & 1) != 1) goto L23;
        boolean r15 = true;
    L25:
        if (r15 == false) goto L34;
        long r16 = this.f12257g.a((byte) 0);
        if (r16 == (-1)) goto L32;
        if (r12 == false) goto L30;
        i(this.f12257g.f12167g, 0, r16 + 1);
    L30:
        this.f12257g.skip(r16 + 1);
        goto L34
    L32:
        throw new EOFException();
    L34:
        if (((r10 >> 4) & 1) == 1) goto L37;
        r11 = false;
    L37:
        if (r11 == false) goto L45;
        long r17 = this.f12257g.a((byte) 0);
        if (r17 == (-1)) goto L44;
        if (r12 == false) goto L42;
        i(this.f12257g.f12167g, 0, r17 + 1);
    L42:
        this.f12257g.skip(r17 + 1);
        goto L45
    L44:
        throw new EOFException();
    L45:
        if (r12 == false) goto L48;
        a("FHCRC", this.f12257g.R(), (short) this.f12260j.getValue());
        this.f12260j.reset();
        return;
    L48:
        return;
    L23:
        r15 = false;
        goto L25
    L11:
        r13 = false;
        goto L12
    L5:
        r12 = false;
        goto L6
    }

    private final void f() {
        a("CRC", this.f12257g.H(), (int) this.f12260j.getValue());
        a("ISIZE", this.f12257g.H(), (int) this.f12258h.getBytesWritten());
    }

    private final void i(d r10, long r11, long r12) {
        b0 r13 = r10.f12197c;
    L3:
        Intrinsics.checkNotNull(r13);
        int r14 = r13.f12174c;
        int r15 = r13.f12173b;
        if (r11 < (r14 - r15)) goto L8;
        r11 = r11 - ((long) (r14 - r15));
        r13 = r13.f12177f;
    L8:
        if (r12 <= 0) goto L10;
        int r16 = (int) (((long) r13.f12173b) + r11);
        int r17 = (int) Math.min(r13.f12174c - r16, r12);
        this.f12260j.update(r13.f12172a, r16, r17);
        r12 = r12 - ((long) r17);
        r13 = r13.f12177f;
        Intrinsics.checkNotNull(r13);
        r11 = 0;
        goto L8
    }

    @Override // okio.f0
    public long S(d r12, long r13) {
        Intrinsics.checkNotNullParameter(r12, "sink");
        if (r13 < 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L28;
        if (r13 != 0) goto L10;
        return 0;
    L10:
        if (this.f12256c != 0) goto L13;
        c();
        this.f12256c = 1;
    L13:
        if (this.f12256c != 1) goto L20;
        long r11 = r12.M();
        long r14 = this.f12259i.S(r12, r13);
        if (r14 == (-1)) goto L18;
        i(r12, r11, r14);
        return r14;
    L18:
        this.f12256c = 2;
    L20:
        if (this.f12256c != 2) goto L26;
        f();
        this.f12256c = 3;
        if (this.f12257g.n() == true) goto L26;
        throw new IOException("gzip finished without exhausting source");
    L26:
        return -1;
    L28:
        throw new IllegalArgumentException(("byteCount < 0: " + r13).toString());
    L5:
        r10 = false;
        goto L6
    }

    @Override // okio.f0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12259i.close();
    }

    @Override // okio.f0
    public g0 timeout() {
        return this.f12257g.timeout();
    }
}
