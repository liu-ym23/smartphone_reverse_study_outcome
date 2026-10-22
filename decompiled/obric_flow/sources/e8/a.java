package e8;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements RejectedExecutionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16778a;

    public /* synthetic */ a(int r5) {
        this.f16778a = r5;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable r5, ThreadPoolExecutor r10) {
        switch(this.f16778a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        if (r5 == null) goto L6;
        t2.f.f.execute(r5);
    L6:
        if (r10 == null) goto L11;
        t2.f.f22097c.submit(new com.obric.oui.lisitem.a(this, r10));
        return;
    L11:
        return;
    L9:
        Executors.newCachedThreadPool().execute(r5);
    }
}
