package jf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f8820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f8821b;

    public b(o r8, n r10) {
        this.f8821b = r8;
        this.f8820a = r10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        c r8 = this.f8821b;
        r8.j();
        this.f8820a.close();     // Catch: Throwable -> L6 IOException -> L8
        r8.l(true);
        return;
    L8:
        e = move-exception;
        throw r8.k(e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r8.l(false);
        throw th;
    }

    @Override // jf.w
    public final x timeout() {
        return this.f8821b;
    }

    public final String toString() {
        return "AsyncTimeout.source(" + this.f8820a + ")";
    }

    @Override // jf.w
    public final long u(d r8, long r10) {
        c r11 = this.f8821b;
        r11.j();
        long r12 = this.f8820a.u(r8, r10);     // Catch: Throwable -> L6 IOException -> L8
        r11.l(true);
        return r12;
    L6:
        th = move-exception;
        r11.l(false);
        throw th;
    L8:
        e = move-exception;
        throw r11.k(e);     // Catch: Throwable -> L6
    }
}
