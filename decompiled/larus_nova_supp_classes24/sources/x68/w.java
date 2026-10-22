package x68;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class w implements Runnable {
    public final /* synthetic */ u a;

    @Override // java.lang.Runnable
    public final void run() {
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L3:
        if (this.a.x.get() == false) goto L12;
        this.a.b(false);     // Catch: Throwable -> L9
        if (this.a.x.get() == false) goto L16;
        this.a.a().postDelayed(this, 10000);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    }

    public w(u r1) {
        this.a = r1;
    }
}
