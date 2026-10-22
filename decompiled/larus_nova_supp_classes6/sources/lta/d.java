package lta;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d implements Runnable {
    public final /* synthetic */ Context a;

    @Override // java.lang.Runnable
    public final void run() {
        c.b.b(new Object[]{this.a}).edit().putBoolean("_install_started_v2", true).apply();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(Context r1) {
        this.a = r1;
    }
}
