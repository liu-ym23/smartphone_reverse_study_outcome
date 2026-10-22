package com.bytedance.android.ec.core.abtest;

import com.bytedance.android.ec.core.utils.b2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements Runnable {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r0 = this.a;     // Catch: Throwable -> L6
        r0.getClass();     // Catch: Throwable -> L6
        com.bytedance.android.ec.hybrid.card.service.a.a("ec_anr_degrade_ec_settings_preload");     // Catch: Throwable -> L6
        if (r0.a == true) goto L9;
        r0.a = true;     // Catch: Throwable -> L6
        b2.b(ECSettingsManager$onECSdkInit$action$1$doPreload$1.INSTANCE);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
