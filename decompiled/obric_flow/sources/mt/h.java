package mt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h implements k {
    public final void b(j r5) {
        io.reactivex.internal.functions.e.d(r5, "observer is null");
        c(r5);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        NullPointerException r10 = new NullPointerException("subscribeActual failed");
        r10.initCause(th);
        throw r10;
    }

    public abstract void c(j r5);
}
