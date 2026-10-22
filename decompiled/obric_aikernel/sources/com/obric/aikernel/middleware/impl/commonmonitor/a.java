package com.obric.aikernel.middleware.impl.commonmonitor;

import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.network.NetworkAllowState;
import k6.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends b {
    public a() {
    }

    @Override // com.bytedance.apm.f
    public boolean getServiceSwitch(String r10) {
        if (Intrinsics.areEqual(r10, "close_cloud_request") == false) goto L9;
        if (NetworkAllowState.INSTANCE.isAllowNetworkRequestNow() == true) goto L9;
        AIKLog.INSTANCE.d("MemoryCloudMessageWidget", "close cloud message when network window closed");
        return true;
    L9:
        return super.getServiceSwitch(r10);
    }
}
