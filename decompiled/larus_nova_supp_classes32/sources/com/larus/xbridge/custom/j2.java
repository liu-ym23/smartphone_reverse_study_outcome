package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.business.debug.api.DebugBaseService;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j2 extends bx7.c {
    public final String getName() {
        return "app.switchFlightVersion";
    }

    public j2() {
    }

    public final void a(dx7.b r2, ux7.d.d r3, IvyBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "type");
        DebugBaseService r5 = (DebugBaseService) ServiceManager.get().getService(DebugBaseService.class);
        if (r5 == null) goto L6;
        r5.d();
        return;
    }
}
