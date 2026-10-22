package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class u implements Source {
    public final InputStream a;
    public final j0 b;

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, okio.Sink
    public final void close() {
        this.a.close();
    }

    public final String toString() {
        return "source(" + this.a + ')';
    }

    @Override // okio.Source, okio.Sink
    public final j0 timeout() {
        return this.b;
    }

    public u(InputStream r2, j0 r3) {
        Intrinsics.checkNotNullParameter(r2, "input");
        Intrinsics.checkNotNullParameter(r3, "timeout");
        this.a = r2;
        this.b = r3;
    }

    @Override // okio.Source
    public final long read(Buffer r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "sink");
        if (r5 != 0) goto L6;
        return 0;
    L6:
        if (r5 < 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L26;
        this.b.g();     // Catch: AssertionError -> L19
        g0 r0 = r4.writableSegment$okio(1);     // Catch: AssertionError -> L19
        int r6 = this.a.read(r0.a, r0.c, (int) Math.min(r5, 8192 - r0.c));     // Catch: AssertionError -> L19
        if (r6 == (-1)) goto L13;
        r0.c += r6;     // Catch: AssertionError -> L19
        long r7 = r6;
        r4.setSize$okio(r4.size() + r7);     // Catch: AssertionError -> L19
        return r7;
    L13:
        if (r0.b != r0.c) goto L28;
        r4.head = r0.a();     // Catch: AssertionError -> L19
        h0.a(r0);     // Catch: AssertionError -> L19
        return -1;
    L28:
        return -1;
    L19:
        e = move-exception;
        if (Okio.isAndroidGetsocknameError(e) == true) goto L23;
        throw e;
    L23:
        throw new IOException(e);
    L26:
        throw new IllegalArgumentException(("byteCount < 0: " + r5).toString());
    L8:
        r1 = false;
        goto L9
    }
}
