package com.larus.dora.impl;

import com.larus.vesdk.api.IVeSDK;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class n implements Runnable {
    public /* synthetic */ n() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        IVeSDK r0 = (IVeSDK) ServiceManager.get().getService(IVeSDK.class);
        if (r0 == null) goto L5;
        r0.e();
    L5:
        int r1 = DoraPreWakeUpTask.d;
        DoraPreWakeUpTask.Companion.e();
    }
}
