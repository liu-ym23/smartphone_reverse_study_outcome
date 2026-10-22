package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.behavior;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements Runnable {
    public final /* synthetic */ HashMap a;

    public a(HashMap r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        qm0.b r0 = om0.c.g();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.sendLog("livesdk_use_behavior_analysis", this.a, new Object[0]);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
