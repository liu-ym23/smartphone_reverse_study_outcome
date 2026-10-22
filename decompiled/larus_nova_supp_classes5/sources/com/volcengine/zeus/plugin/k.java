package com.volcengine.zeus.plugin;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.log.ZeusLogger;
import dqc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k implements Runnable {
    public final boolean a;

    @Override // java.lang.Runnable
    public final void run() {
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    L20:
        return;
    L4:
        if (this.a == true) goto L6;
        PolarisFileWrapper r0 = new PolarisFileWrapper(c.d());     // Catch: Throwable -> L12
        ZeusLogger.i("Zeus/init_zeus", "ZeusScanRunnable listPluginDownloadDir, dir = " + r0);     // Catch: Throwable -> L12
        r0.listFiles(new j());     // Catch: Throwable -> L12
    L6:
        String r1 = c.g();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return;
    L9:
        if (GlobalParam.getInstance().isDebug() == false) goto L19;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r1);     // Catch: Throwable -> L12
        ZeusLogger.i("Zeus/init_zeus", "ZeusScanRunnable listPluginDownloadDir, dir = " + r3);     // Catch: Throwable -> L12
        r3.listFiles(new j());     // Catch: Throwable -> L12
        return;
    }

    static {
    }

    public k(boolean r1) {
        this.a = r1;
    }
}
