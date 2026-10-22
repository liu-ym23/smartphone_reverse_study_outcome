package ze;

import we.i;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends hf.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ g f14372n;

    public c(jf.f r8, jf.e r10, g r11) {
        this.f14372n = r11;
        super(r8, r10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        g r8 = this.f14372n;
        i r10 = r8.f14403d;
        monitor-enter(r10);
        af.c r11 = r8.f14414o;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        r8.i(true, r11, -1, null);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
