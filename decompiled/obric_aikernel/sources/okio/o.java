package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nInflaterSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InflaterSource.kt\nokio/InflaterSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,147:1\n1#2:148\n86#3:149\n*S KotlinDebug\n*F\n+ 1 InflaterSource.kt\nokio/InflaterSource\n*L\n73#1:149\n*E\n"})
public final class o implements f0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f12261c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Inflater f12262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f12263h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f12264i;

    public o(f r10, Inflater r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "inflater");
        this.f12261c = r10;
        this.f12262g = r11;
    }

    private final void f() {
        int r10 = this.f12263h;
        if (r10 != 0) goto L5;
        return;
    L5:
        int r11 = r10 - this.f12262g.getRemaining();
        this.f12263h -= r11;
        this.f12261c.skip(r11);
    }

    @Override // okio.f0
    public long S(d r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "sink");
    L3:
        long r12 = a(r10, r11);
        if (r12 > 0) goto L5;
        if (this.f12262g.finished() == true) goto L16;
        if (this.f12262g.needsDictionary() == true) goto L23;
        if (this.f12261c.n() == false) goto L3;
        throw new EOFException("source exhausted prematurely");
    L23:
        return -1;
    L16:
        return -1;
    L5:
        return r12;
    }

    public final long a(d r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L25;
        if ((!this.f12264i) == false) goto L23;
        if (r11 != 0) goto L26;
        return 0;
    L26:
        b0 r13 = r10.Q(1);     // Catch: DataFormatException -> L19
        int r14 = (int) Math.min(r11, 8192 - r13.f12174c);     // Catch: DataFormatException -> L19
        c();     // Catch: DataFormatException -> L19
        int r15 = this.f12262g.inflate(r13.f12172a, r13.f12174c, r14);     // Catch: DataFormatException -> L19
        f();     // Catch: DataFormatException -> L19
        if (r15 <= 0) goto L16;
        r13.f12174c += r15;     // Catch: DataFormatException -> L19
        long r16 = r15;
        r10.K(r10.M() + r16);     // Catch: DataFormatException -> L19
        return r16;
    L16:
        if (r13.f12173b != r13.f12174c) goto L18;
        r10.f12197c = r13.b();     // Catch: DataFormatException -> L19
        c0.b(r13);     // Catch: DataFormatException -> L19
    L18:
        return 0;
    L19:
        e = move-exception;
        throw new IOException(e);
    L23:
        throw new IllegalStateException("closed".toString());
    L25:
        throw new IllegalArgumentException(("byteCount < 0: " + r11).toString());
    L5:
        r12 = false;
        goto L6
    }

    public final boolean c() {
        if (this.f12262g.needsInput() == true) goto L6;
        return false;
    L6:
        if (this.f12261c.n() == false) goto L9;
        return true;
    L9:
        b0 r10 = this.f12261c.b().f12197c;
        Intrinsics.checkNotNull(r10);
        int r11 = r10.f12174c;
        int r12 = r10.f12173b;
        int r13 = r11 - r12;
        this.f12263h = r13;
        this.f12262g.setInput(r10.f12172a, r12, r13);
        return false;
    }

    @Override // okio.f0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f12264i == false) goto L5;
        return;
    L5:
        this.f12262g.end();
        this.f12264i = true;
        this.f12261c.close();
    }

    @Override // okio.f0
    public g0 timeout() {
        return this.f12261c.timeout();
    }
}
