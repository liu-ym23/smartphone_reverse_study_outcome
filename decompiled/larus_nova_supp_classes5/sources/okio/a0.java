package okio;

import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a0 implements Sink {
    public final OutputStream a;
    public final j0 b;

    @Override // okio.Sink, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        this.a.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        this.a.flush();
    }

    public final String toString() {
        return "sink(" + this.a + ')';
    }

    @Override // okio.Sink
    public final j0 timeout() {
        return this.b;
    }

    public a0(OutputStream r2, j0 r3) {
        Intrinsics.checkNotNullParameter(r2, "out");
        Intrinsics.checkNotNullParameter(r3, "timeout");
        this.a = r2;
        this.b = r3;
    }

    @Override // okio.Sink
    public final void write(Buffer r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "source");
        b.b(r8.size(), 0, r9);
    L4:
        if (r9 <= 0) goto L8;
        this.b.g();
        g0 r0 = r8.head;
        Intrinsics.checkNotNull(r0);
        int r2 = (int) Math.min(r9, r0.c - r0.b);
        this.a.write(r0.a, r0.b, r2);
        r0.b += r2;
        long r1 = r2;
        r9 = r9 - r1;
        r8.setSize$okio(r8.size() - r1);
        if (r0.b != r0.c) goto L4;
        r8.head = r0.a();
        h0.a(r0);
        goto L4
    }
}
