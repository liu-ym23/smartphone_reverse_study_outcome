package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJvmOkio.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmOkio.kt\nokio/InputStreamSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,239:1\n1#2:240\n86#3:241\n*S KotlinDebug\n*F\n+ 1 JvmOkio.kt\nokio/InputStreamSource\n*L\n92#1:241\n*E\n"})
class p implements f0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InputStream f12265c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final g0 f12266g;

    public p(InputStream r10, g0 r11) {
        Intrinsics.checkNotNullParameter(r10, "input");
        Intrinsics.checkNotNullParameter(r11, "timeout");
        this.f12265c = r10;
        this.f12266g = r11;
    }

    @Override // okio.f0
    public long S(d r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        if (r11 != 0) goto L6;
        return 0;
    L6:
        if (r11 < 0) goto L8;
        boolean r12 = true;
    L9:
        if (r12 == false) goto L26;
        this.f12266g.f();     // Catch: AssertionError -> L19
        b0 r13 = r10.Q(1);     // Catch: AssertionError -> L19
        int r14 = this.f12265c.read(r13.f12172a, r13.f12174c, (int) Math.min(r11, 8192 - r13.f12174c));     // Catch: AssertionError -> L19
        if (r14 == (-1)) goto L13;
        r13.f12174c += r14;     // Catch: AssertionError -> L19
        long r15 = r14;
        r10.K(r10.M() + r15);     // Catch: AssertionError -> L19
        return r15;
    L13:
        if (r13.f12173b != r13.f12174c) goto L28;
        r10.f12197c = r13.b();     // Catch: AssertionError -> L19
        c0.b(r13);     // Catch: AssertionError -> L19
        return -1;
    L28:
        return -1;
    L19:
        e = move-exception;
        if (t.c(e) == true) goto L23;
        throw e;
    L23:
        throw new IOException(e);
    L26:
        throw new IllegalArgumentException(("byteCount < 0: " + r11).toString());
    L8:
        r12 = false;
        goto L9
    }

    @Override // okio.f0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12265c.close();
    }

    @Override // okio.f0
    public g0 timeout() {
        return this.f12266g;
    }

    public String toString() {
        return "source(" + this.f12265c + ')';
    }
}
