package mt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements c {
    public final void b(b r5) {
        io.reactivex.internal.functions.e.d(r5, "observer is null");
        c(r5);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
        NullPointerException r10 = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        r10.initCause(th);
        throw r10;
    }

    public abstract void c(b r5);
}
