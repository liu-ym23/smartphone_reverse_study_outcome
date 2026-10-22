package com.volcengine.zeus.service.server;

import android.content.Intent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ServiceManager$a implements Runnable {
    public final /* synthetic */ Intent a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ServiceManager c;

    @Override // java.lang.Runnable
    public final void run() {
        ServiceManager.access$000(this.c, this.a, this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public ServiceManager$a(ServiceManager r1, Intent r2, String r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
