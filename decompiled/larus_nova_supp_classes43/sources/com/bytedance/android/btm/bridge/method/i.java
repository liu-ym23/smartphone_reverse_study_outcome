package com.bytedance.android.btm.bridge.method;

import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "btm.getBTMSdkInfo")
public final class i extends XCoreBridgeMethod implements com.bytedance.sdk.xbridge.cn.protocol.h {
    public final String a;
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access b;

    public i() {
        this.a = "btm.getBTMSdkInfo";
        this.b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(final XReadableMap r10, com.bytedance.ies.xbridge.XBridgeMethod.Callback r11, XBridgePlatformType r12) {
        int r13 = h.a;
        ALogger.c(ALogger.d, "FE_getBtmSdkInfo", new GetSdkInfoHelper$handle$1(r10));
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("btm_sdk_version", "2.0.4.i18n-rc.176");
        r14.put("btm_sdk_version_int", 2000418226);
        r14.put("debug", Boolean.FALSE);
        r14.put("region", "cn");
        r14.put("os", "Android");
        j.b(this, r11, r14);
    }
}
