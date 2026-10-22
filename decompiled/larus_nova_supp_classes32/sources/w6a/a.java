package w6a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements Runnable {
    public final /* synthetic */ e a;

    @Override // java.lang.Runnable
    public final void run() {
        e r0 = this.a;     // Catch: Throwable -> L4
        r0.a.setAnimation(r0.e);     // Catch: Throwable -> L4
        this.a.a.requestLayout();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(e r1) {
        this.a = r1;
    }
}
