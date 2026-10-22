package com.larus.xbridge.custom;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i1 extends XCoreBridgeMethod {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "flow.openMembershipPipoPay";
    }

    public i1() {
    }

    public final XBridgeMethod.Access getAccess() {
        return XBridgeMethod.Access.PRIVATE;
    }

    public final void handle(XReadableMap r8, XBridgeMethod.Callback r9, XBridgePlatformType r10) {
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, "type");
        XCoreBridgeMethod.onFailure$default(this, r9, 0, "fail, pipo pay is not supported on mainland", null, 8, null);
    }
}
