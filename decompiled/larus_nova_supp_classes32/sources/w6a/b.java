package w6a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements Runnable {
    public final /* synthetic */ e a;

    @Override // java.lang.Runnable
    public final void run() {
        e r0 = this.a;     // Catch: Throwable -> L6
        r0.a.setAnimation(r0.e);     // Catch: Throwable -> L6
        if (this.a.a.getKeyframeManager() == null) goto L9;
        this.a.a.getKeyframeManager().c();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public b(e r1) {
        this.a = r1;
    }
}
