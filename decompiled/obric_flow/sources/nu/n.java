package nu;

import java.util.zip.Deflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f20330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Deflater f20331c;

    public n(j r5, Deflater r10) {
        Intrinsics.checkNotNullParameter(r5, "sink");
        Intrinsics.checkNotNullParameter(r10, "deflater");
        w r11 = f4.b.d(r5);
        Intrinsics.checkNotNullParameter(r11, "sink");
        Intrinsics.checkNotNullParameter(r10, "deflater");
        this.f20330b = r11;
        this.f20331c = r10;
    }

    public final void b(boolean r10) {
        w r5 = this.f20330b;
        j r11 = r5.f20346a;
    L3:
        y r12 = r11.P(1);
        Deflater r13 = this.f20331c;
        byte[] r14 = r12.f20352a;
        if (r10 == false) goto L6;
        int r15 = r12.f20354c;
        int r16 = r13.deflate(r14, r15, 8192 - r15, 2);
    L7:
        if (r16 > 0) goto L8;
        if (r13.needsInput() == false) goto L3;
        if (r12.f20353b != r12.f20354c) goto L21;
        r11.f20327a = r12.a();
        z.a(r12);
        return;
    L21:
        return;
    L8:
        r12.f20354c += r16;
        r11.f20328b += (long) r16;
        r5.k();
        goto L3
    L6:
        int r17 = r12.f20354c;
        r16 = r13.deflate(r14, r17, 8192 - r17);
        goto L7
    }

    @Override // nu.a0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Deflater r5 = this.f20331c;
        if (this.f20329a == false) goto L22;
        return;
    L22:
        r5.finish();     // Catch: Throwable -> L7
        b(false);     // Catch: Throwable -> L7
        th = null;
    L24:
        r5.end();     // Catch: Throwable -> L10
    L26:
        this.f20330b.close();     // Catch: Throwable -> L15
    L18:
        this.f20329a = true;
        if (th != null) goto L21;
        return;
    L21:
        throw th;
    L15:
        th = move-exception;
        if (th != null) goto L18;
        th = th;
    L10:
        th = move-exception;
        if (th != null) goto L26;
        th = th;
    L7:
        th = th;
        goto L24
    }

    @Override // nu.a0, java.io.Flushable
    public final void flush() {
        b(true);
        this.f20330b.flush();
    }

    @Override // nu.a0
    public final f0 timeout() {
        return this.f20330b.f20348c.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f20330b + ')';
    }

    @Override // nu.a0
    public final void write(j r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        f4.a.d(r10.f20328b, 0, r11);
    L4:
        if (r11 <= 0) goto L9;
        y r5 = r10.f20327a;
        Intrinsics.checkNotNull(r5);
        int r12 = (int) Math.min(r11, r5.f20354c - r5.f20353b);
        this.f20331c.setInput(r5.f20352a, r5.f20353b, r12);
        b(false);
        long r13 = r12;
        r10.f20328b -= r13;
        int r14 = r5.f20353b + r12;
        r5.f20353b = r14;
        if (r14 != r5.f20354c) goto L8;
        r10.f20327a = r5.a();
        z.a(r5);
    L8:
        r11 = r11 - r13;
        goto L4
    }
}
