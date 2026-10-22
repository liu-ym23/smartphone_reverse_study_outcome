package com.bytedance.android.ec.core.monitor;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements SDKMonitor.IGetExtendParams {
    public g() {
    }

    public final Map<String, String> getCommonParams() {
        Pair[] r0 = new Pair[1];
        String r10 = ECAppInfoService.e.getAppId();
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r0[0] = new Pair("host_aid", r10);
        return MapsKt.mutableMapOf(r0);
    }

    public final String getSessionId() {
        return null;
    }
}
