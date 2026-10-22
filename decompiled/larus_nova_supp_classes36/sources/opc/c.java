package opc;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ Context a;

    public c(Context r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i08.a.b(this.a, y9c.d.h(2131892207));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
