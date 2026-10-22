package com.larus.avlink.gallery;

import com.larus.avlink.gallery.viewmodel.GalleryViewModel;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    static {
    }

    public static boolean a() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L7;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L7;
        int r2 = r1.X();
    L8:
        FLogger r3 = FLogger.a;
        r3.i(GalleryViewModel.TAG, "batteryState: " + r2);
        if (r2 != 2) goto L11;
        return true;
    L11:
        if (r2 != 0) goto L24;
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L19;
        DeviceService r5 = r4.device();
        if (r5 == null) goto L19;
        int[] r6 = r5.h();
        if (r6 == null) goto L19;
        int r7 = r6[0];
    L20:
        r3.i(GalleryViewModel.TAG, "currentBattery: " + r7);
        if (r7 > 5) goto L25;
        return true;
    L25:
        return false;
    L19:
        r7 = 100;
        goto L20
    L24:
        return false;
    L7:
        r2 = 0;
        goto L8
    }
}
