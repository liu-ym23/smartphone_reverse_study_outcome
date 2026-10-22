package kib;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.forwardv2.e;
import hib.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ a.b a;

    public b(a.b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.getClass();     // Catch: Throwable -> L4
        d r0 = e.a;     // Catch: Throwable -> L4
        e.a.a().getEventParams();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
