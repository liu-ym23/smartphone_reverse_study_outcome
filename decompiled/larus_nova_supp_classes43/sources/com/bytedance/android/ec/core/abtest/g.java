package com.bytedance.android.ec.core.abtest;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.b2;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements Runnable {
    public volatile boolean a;
    public final /* synthetic */ long b;

    @Override // java.lang.Runnable
    public final void run() {
        Set<String> r0 = ECProcessMonitor.a;     // Catch: Throwable -> L6
        ECProcessMonitor.k("ecSdkInit_BootFinish", System.currentTimeMillis() - this.b, null, null, 24);     // Catch: Throwable -> L6
        com.bytedance.android.ec.hybrid.card.service.a.a("ec_anr_degrade_ec_settings_preload");     // Catch: Throwable -> L6
        if (this.a == true) goto L9;
        this.a = true;     // Catch: Throwable -> L6
        b2.b(ECSettingsManager$onECSdkInit$action$1$doPreload$1.INSTANCE);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public g(long r1) {
        this.b = r1;
    }
}
