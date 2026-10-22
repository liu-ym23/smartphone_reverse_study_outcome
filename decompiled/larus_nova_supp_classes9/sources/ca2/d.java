package ca2;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements Runnable {
    public final /* synthetic */ c a;

    @Override // java.lang.Runnable
    public final void run() {
        c r0 = this.a;     // Catch: Throwable -> L7
        r0.v = false;     // Catch: Throwable -> L7
        Iterator<T> r1 = r0.w.iterator();     // Catch: Throwable -> L7
    L4:
        if (r1.hasNext() == false) goto L16;
        ((a) r1.next()).onTransitionEnd(this.a.x);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public d(c r1) {
        this.a = r1;
    }
}
