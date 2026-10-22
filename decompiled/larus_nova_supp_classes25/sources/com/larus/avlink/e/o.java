package com.larus.avlink.e;

import com.larus.avlink.platform.AndroidPlatformKt;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int b() {
        FlowDoraSubBizType.a r0 = FlowDoraSubBizType.Companion;
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 == null) goto L7;
        DeviceService r2 = r1.device();
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.y());
    L8:
        r0.getClass();
        return FlowDoraSubBizType.a.b(r3);
    L7:
        r3 = null;
        goto L8
    }

    public static boolean a() {
        AndroidPlatformKt.a();
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        VisionService r1 = r0.V();
        if (r1 == null) goto L9;
        if (r1.y() != true) goto L9;
        return true;
    L9:
        return false;
    }
}
