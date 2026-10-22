package com.larus.avlink.gallery.silent;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import h49.e;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SilentSyncManager$init$linkListener$1 implements e {
    public SilentSyncManager$init$linkListener$1() {
    }

    public final void a(int r7) {
        BuildersKt.launch$default(SilentSyncManager.d, null, null, new SilentSyncManager$init$linkListener$1$onDoraLinkStateChanged$1(r7, null), 3, null);
    }

    public final void b(int r3) {
        if (r3 != 2) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L13;
        FLogger.a.i("SilentSyncManager", "DoraLink connected, taking silent trans state");
        IDoraService r5 = SilentSyncManager.c;
        if (r5 == null) goto L14;
        DeviceService r6 = r5.device();
        if (r6 == null) goto L15;
        r6.M0();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r4 = false;
        goto L6
    }
}
