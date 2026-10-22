package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.util.t0;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v0 extends t0 {
    public v0() {
    }

    public final void onDoraLinkStateChanged(DoraDevice r4, int r5, int r6) {
        g49.d.d("DoraSyncManager", "onDoraLinkStateChanged: " + ThreadMethodProxy.currentThread());
        if (r4 != null) goto L5;
        return;
    L5:
        String r0 = "";
        if (r6 == 0) goto L14;
        if (r6 != 2) goto L24;
        CoroutineScope r7 = DoraSyncManager.a;
        String r8 = r4.getSerialNumber();
        if (r8 == null) goto L13;
        r0 = r8;
    L13:
        DoraSyncManager.b(r0, 1, "5");
        DoraSyncManager.a();
        return;
    L24:
        return;
    L14:
        Job r9 = DoraSyncManager.b;
        if (r9 == null) goto L17;
        Job.DefaultImpls.cancel$default(r9, null, 1, null);
    L17:
        DoraSyncManager.b = null;
        DoraSyncManager.d.set(false);
        String r10 = r4.getSerialNumber();
        if (r10 == null) goto L21;
        r0 = r10;
    L21:
        DoraSyncManager.b(r0, 2, "6");
    }
}
