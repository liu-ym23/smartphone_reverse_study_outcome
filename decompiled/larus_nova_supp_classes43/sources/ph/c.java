package ph;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements Runnable {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.a(false);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }
}
