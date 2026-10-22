package l19;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m implements Runnable {
    public final /* synthetic */ l a;

    @Override // java.lang.Runnable
    public final void run() {
        l r0 = this.a;     // Catch: Throwable -> L7
        r0.C = false;     // Catch: Throwable -> L7
        Iterator<T> r1 = r0.D.iterator();     // Catch: Throwable -> L7
    L4:
        if (r1.hasNext() == false) goto L16;
        ((f) r1.next()).onTransitionEnd(r0.E);     // Catch: Throwable -> L7
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

    public m(l r1) {
        this.a = r1;
    }
}
