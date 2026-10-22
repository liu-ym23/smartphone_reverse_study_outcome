package com.bytedance.android.annie.bridge.method.audio;

import com.bytedance.ttnet.TTNetInit;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.InterfaceC0059a r0 = this.a.b;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.d(false);     // Catch: Throwable -> L7
    L5:
        a r1 = this.a;     // Catch: Throwable -> L7
        r1.getClass();     // Catch: Throwable -> L7
        a.a("updateNetworkState");     // Catch: Throwable -> L7
        int r10 = TTNetInit.getEffectiveConnectionType();     // Catch: Throwable -> L7
        AndroidSchedulers.mainThread().scheduleDirect(new f7.a(r1, r10));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
