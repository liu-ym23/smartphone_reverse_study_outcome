package onb;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements c {
    public Executor a;

    public n() {
    }

    public final synchronized Executor a() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.a != null) goto L6;
        this.a = qnb.b.a().b();     // Catch: Throwable -> L14
    L6:
        Executor r0 = this.a;     // Catch: Throwable -> L14
        if ((r0 instanceof ExecutorService) == true) goto L9;
    L11:
        Executor r1 = this.a;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r1;
    L9:
        if (((ExecutorService) r0).isShutdown() == false) goto L11;
        this.a = qnb.b.a().b();     // Catch: Throwable -> L14
        goto L11
    }

    @Override // onb.c
    public final void destroy() {
        rnb.c.c("RnReceiveDispatch", "destroy");
        Executor r0 = this.a;
        if ((r0 instanceof ExecutorService) == false) goto L6;
        ((ExecutorService) r0).shutdown();
        return;
    }

    @Override // onb.c
    public final void submit(Runnable r3) {
        a().execute(r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        rnb.c.a.e("RnReceiveDispatch", th);
    }
}
