package com.larus.xbridge.custom;

import android.app.Activity;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larus.common.apphost.AppHost;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k1 extends XCoreBridgeMethod {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "flow.popNativePage";
    }

    public k1() {
    }

    public final void handle(XReadableMap r7, XBridgeMethod.Callback r8, XBridgePlatformType r9) {
        Intrinsics.checkNotNullParameter(r7, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r8, "callback");
        Intrinsics.checkNotNullParameter(r9, "type");
        Activity r10 = AppHost.a.a().getCurrentActivity();
        FLogger r11 = FLogger.a;
        if (r10 == null) goto L6;
        String r0 = r10.getLocalClassName();
        if (r0 == null) goto L6;
    L7:
        r11.i("FlowPopNativePage", "[handle] activity name = ".concat(r0));
        IUgcAIGCService.a.r(r10);
        XCoreBridgeMethod.onSuccess$default(this, r8, new LinkedHashMap(), null, 4, null);
        return;
    L6:
        r0 = NameKeys.UnloadStrategy_No_Strategy;
        goto L7
    }
}
