package com.larus.dora.impl.serviceimpl;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.util.t0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class VisionService$init$1 extends t0 {
    public final /* synthetic */ VisionService a;

    public VisionService$init$1(VisionService r1) {
        this.a = r1;
    }

    public final void onDoraLinkStateChanged(DoraDevice r7, int r8, int r9) {
        super.onDoraLinkStateChanged(r7, r8, r9);
        if (r9 != 2) goto L14;
        IDoraService r10 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r10 == null) goto L11;
        DeviceService r11 = r10.device();
        if (r11 == null) goto L11;
        boolean r12 = true;
        if (r11.C() != true) goto L11;
    L12:
        if (r12 == false) goto L16;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new VisionService$init$1$onDoraLinkStateChanged$1(this.a, null), 2, null);
        return;
    L16:
        return;
    L11:
        r12 = false;
        goto L12
    L14:
        FLogger.a.i("VisionService", "Clear cache");
        this.a.d = null;
    }
}
