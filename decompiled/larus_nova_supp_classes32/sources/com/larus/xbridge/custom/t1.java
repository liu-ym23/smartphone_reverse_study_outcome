package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.IFlowMessageService;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t1 extends bx7.c {
    public final String getName() {
        return "app.notifyAuthResult";
    }

    public t1() {
    }

    public final void a(dx7.b r4, ux7.d.d r5, IvyBridgePlatformType r6) {
        Intrinsics.checkNotNullParameter(r4, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, "type");
        String r7 = r4.getString("messageId");
        if (r7.length() != 0) goto L5;
        boolean r8 = true;
    L7:
        if (r8 == false) goto L10;
        bx7.c.c(this, r5, -3, null, 12);
        return;
    L10:
        IFlowMessageService r9 = (IFlowMessageService) ServiceManager.get().getService(IFlowMessageService.class);
        if (r9 == null) goto L13;
        r9.g(r7, false, null, NameKeys.UnloadStrategy_No_Strategy);
    L13:
        bx7.c.d(this, r5, new LinkedHashMap());
        return;
    L5:
        r8 = false;
        goto L7
    }
}
