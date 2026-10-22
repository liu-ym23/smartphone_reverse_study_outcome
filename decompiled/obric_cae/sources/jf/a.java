package jf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f8818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f8819b;

    public a(o r8, m r10) {
        this.f8819b = r8;
        this.f8818a = r10;
    }

    @Override // jf.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        c r8 = this.f8819b;
        r8.j();
        this.f8818a.close();     // Catch: Throwable -> L6 IOException -> L8
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

    @Override // jf.v, java.io.Flushable
    public final void flush() {
        c r8 = this.f8819b;
        r8.j();
        this.f8818a.flush();     // Catch: Throwable -> L6 IOException -> L8
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

    @Override // jf.v
    public final x timeout() {
        return this.f8819b;
    }

    public final String toString() {
        return "AsyncTimeout.sink(" + this.f8818a + ")";
    }

    @Override // jf.v
    public final void write(d r8, long r10) {
        y.a(r8.f8830b, 0, r10);
    L3:
        long r11 = 0;
        if (r10 <= 0) goto L22;
        s r12 = r8.f8829a;
    L7:
        if (r11 >= 65536) goto L12;
        r11 = r11 + ((long) (r12.f8872c - r12.f8871b));
        if (r11 >= r10) goto L10;
        r12 = r12.f8875f;
        goto L7
    L10:
        r11 = r10;
    L12:
        c r13 = this.f8819b;
        r13.j();
        this.f8818a.write(r8, r11);     // Catch: Throwable -> L15 IOException -> L17
        r10 = r10 - r11;
        r13.l(true);
        goto L3
    L17:
        e = move-exception;
        throw r13.k(e);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r13.l(false);
        throw th;
    }
}
