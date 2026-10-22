package com.volcengine.zeus.service.server;

import android.content.Intent;
import android.os.RemoteException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.ServiceConnection;
import com.volcengine.zeus.log.ZeusLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ServiceManager$c implements Runnable {
    public final /* synthetic */ Intent a;
    public final /* synthetic */ ServiceConnection b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ ServiceManager e;

    @Override // java.lang.Runnable
    public final void run() {
        ServiceManager.access$100(this.e, this.a, this.b, this.c, this.d);     // Catch: Throwable -> L4 RemoteException -> L6
    L16:
        return;
    L6:
        e = move-exception;
        ZeusLogger.errReport("Zeus/service_zeus", "bindService failed", e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }

    public ServiceManager$c(ServiceManager r1, Intent r2, ServiceConnection r3, int r4, String r5) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
