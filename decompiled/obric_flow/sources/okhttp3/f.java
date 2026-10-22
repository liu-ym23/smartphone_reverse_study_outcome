package okhttp3;

import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends nu.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.lynx.tasm.t f20645a;

    public f(com.lynx.tasm.t r5, nu.a0 r10) {
        this.f20645a = r5;
        super(r10);
    }

    @Override // nu.o, nu.a0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        g r5 = (g) this.f20645a.f;
        monitor-enter(r5);
        com.lynx.tasm.t r10 = this.f20645a;     // Catch: Throwable -> L13
        if (r10.f10962b == false) goto L9;
        monitor-exit(r5);
        return;
    L9:
        r10.f10962b = true;     // Catch: Throwable -> L13
        ((g) r10.f).getClass();     // Catch: Throwable -> L13
        monitor-exit(r5);
        super.close();
        ((DiskLruCache.Editor) this.f20645a.e).commit();
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
