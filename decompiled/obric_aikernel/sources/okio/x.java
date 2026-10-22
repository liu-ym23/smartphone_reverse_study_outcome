package okio;

import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJvmOkio.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmOkio.kt\nokio/OutputStreamSink\n+ 2 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,239:1\n86#2:240\n*S KotlinDebug\n*F\n+ 1 JvmOkio.kt\nokio/OutputStreamSink\n*L\n55#1:240\n*E\n"})
final class x implements d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final OutputStream f12272c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final g0 f12273g;

    public x(OutputStream r10, g0 r11) {
        Intrinsics.checkNotNullParameter(r10, "out");
        Intrinsics.checkNotNullParameter(r11, "timeout");
        this.f12272c = r10;
        this.f12273g = r11;
    }

    @Override // okio.d0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12272c.close();
    }

    @Override // okio.d0, java.io.Flushable
    public void flush() {
        this.f12272c.flush();
    }

    @Override // okio.d0
    public g0 timeout() {
        return this.f12273g;
    }

    public String toString() {
        return "sink(" + this.f12272c + ')';
    }

    @Override // okio.d0
    public void x(d r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        b.b(r10.M(), 0, r11);
    L4:
        if (r11 <= 0) goto L8;
        this.f12273g.f();
        b0 r12 = r10.f12197c;
        Intrinsics.checkNotNull(r12);
        int r13 = (int) Math.min(r11, r12.f12174c - r12.f12173b);
        this.f12272c.write(r12.f12172a, r12.f12173b, r13);
        r12.f12173b += r13;
        long r14 = r13;
        r11 = r11 - r14;
        r10.K(r10.M() - r14);
        if (r12.f12173b != r12.f12174c) goto L4;
        r10.f12197c = r12.b();
        c0.b(r12);
        goto L4
    }
}
