package com.larus.avlink.performance;

import com.flow.performance.thermal.SystemBatteryRecoder;
import com.larus.dora.api.IDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g implements SystemBatteryRecoder.e {
    public /* synthetic */ g() {
    }

    public final Map a() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.e0() != true) goto L7;
    L9:
        return MapsKt.mapOf(TuplesKt.to("dora_location_poll_enabled", Boolean.valueOf(r1)));
    L7:
        r1 = false;
        goto L9
    }
}
