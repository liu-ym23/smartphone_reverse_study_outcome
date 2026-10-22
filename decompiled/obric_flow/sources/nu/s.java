package nu;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f20338c;
    public final Inflater d;

    public s(x r5, Inflater r10) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r10, "inflater");
        this.f20338c = r5;
        this.d = r10;
    }

    public final long b(j r10, long r11) {
        Inflater r5 = this.d;
        Intrinsics.checkNotNullParameter(r10, "sink");
        if (r11 < 0) goto L35;
        if (this.f20337b == true) goto L33;
        if (r11 != 0) goto L36;
        return 0;
    L36:
        y r12 = r10.P(1);     // Catch: DataFormatException -> L24
        int r13 = (int) Math.min(r11, 8192 - r12.f20354c);     // Catch: DataFormatException -> L24
        boolean r14 = r5.needsInput();     // Catch: DataFormatException -> L24
        x r15 = this.f20338c;
        if (r14 == true) goto L14;
    L17:
        int r16 = r5.inflate(r12.f20352a, r12.f20354c, r13);     // Catch: DataFormatException -> L24
        int r17 = this.f20336a;     // Catch: DataFormatException -> L24
        if (r17 == 0) goto L21;
        int r18 = r17 - r5.getRemaining();     // Catch: DataFormatException -> L24
        this.f20336a -= r18;     // Catch: DataFormatException -> L24
        r15.skip(r18);     // Catch: DataFormatException -> L24
    L21:
        if (r16 <= 0) goto L27;
        r12.f20354c += r16;     // Catch: DataFormatException -> L24
        long r19 = r16;
        r10.f20328b += r19;     // Catch: DataFormatException -> L24
        return r19;
    L27:
        if (r12.f20353b != r12.f20354c) goto L29;
        r10.f20327a = r12.a();     // Catch: DataFormatException -> L24
        z.a(r12);     // Catch: DataFormatException -> L24
    L29:
        return 0;
    L14:
        if (r15.y() == true) goto L17;
        y r110 = r15.f20349a.f20327a;     // Catch: DataFormatException -> L24
        Intrinsics.checkNotNull(r110);     // Catch: DataFormatException -> L24
        int r20 = r110.f20354c;     // Catch: DataFormatException -> L24
        int r21 = r110.f20353b;     // Catch: DataFormatException -> L24
        int r22 = r20 - r21;     // Catch: DataFormatException -> L24
        this.f20336a = r22;     // Catch: DataFormatException -> L24
        r5.setInput(r110.f20352a, r21, r22);     // Catch: DataFormatException -> L24
    L24:
        e = move-exception;
        throw new IOException(e);
    L33:
        throw new IllegalStateException("closed");
    L35:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r11, "byteCount < 0: ").toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f20337b == false) goto L5;
        return;
    L5:
        this.d.end();
        this.f20337b = true;
        this.f20338c.close();
    }

    @Override // nu.c0
    public final long read(j r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "sink");
    L3:
        long r11 = b(r5, r10);
        if (r11 > 0) goto L5;
        Inflater r12 = this.d;
        if (r12.finished() == true) goto L16;
        if (r12.needsDictionary() == true) goto L23;
        if (this.f20338c.y() == false) goto L3;
        throw new EOFException("source exhausted prematurely");
    L23:
        return -1;
    L16:
        return -1;
    L5:
        return r11;
    }

    @Override // nu.c0
    public final f0 timeout() {
        return this.f20338c.f20351c.timeout();
    }
}
