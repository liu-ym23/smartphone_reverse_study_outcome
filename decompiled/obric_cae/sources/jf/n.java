package jf;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f8858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InputStream f8859b;

    public n(InputStream r8, x r10) {
        this.f8858a = r10;
        this.f8859b = r8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f8859b.close();
    }

    @Override // jf.w
    public final x timeout() {
        return this.f8858a;
    }

    public final String toString() {
        return "source(" + this.f8859b + ")";
    }

    @Override // jf.w
    public final long u(d r8, long r10) {
        if (r10 < 0) goto L30;
        if (r10 != 0) goto L6;
        return 0;
    L6:
        boolean r11 = true;
        this.f8858a.f();     // Catch: AssertionError -> L16
        s r12 = r8.C(1);     // Catch: AssertionError -> L16
        int r13 = this.f8859b.read(r12.f8870a, r12.f8872c, (int) Math.min(r10, 8192 - r12.f8872c));     // Catch: AssertionError -> L16
        if (r13 == (-1)) goto L10;
        r12.f8872c += r13;     // Catch: AssertionError -> L16
        long r14 = r13;
        r8.f8830b += r14;     // Catch: AssertionError -> L16
        return r14;
    L10:
        if (r12.f8871b != r12.f8872c) goto L32;
        r8.f8829a = r12.a();     // Catch: AssertionError -> L16
        t.a(r12);     // Catch: AssertionError -> L16
        return -1;
    L32:
        return -1;
    L16:
        e = move-exception;
        if (e.getCause() != null) goto L20;
    L24:
        r11 = false;
    L25:
        if (r11 == true) goto L27;
        throw e;
    L27:
        throw new IOException(e);
    L20:
        if (e.getMessage() == null) goto L24;
        if (e.getMessage().contains("getsockname failed") == false) goto L24;
    L30:
        throw new IllegalArgumentException(android.aimedia.a.d("byteCount < 0: ", r10));
    }
}
