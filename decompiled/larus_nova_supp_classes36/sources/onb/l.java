package onb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements c {
    @Override // onb.c
    public final void destroy() {
    }

    public l() {
    }

    @Override // onb.c
    public final void submit(Runnable r3) {
        qnb.b.a().a().execute(r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        rnb.c.a.e("JSDispatcher", th);
    }
}
