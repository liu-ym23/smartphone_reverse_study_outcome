package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.OpenPanelInRoomResultModel;
import com.bytedance.android.livesdk.vscore_api.paidlive.IPaidOuterService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openPanelInRoom")
public final class y8 extends w20.r4<w20.qc, OpenPanelInRoomResultModel> {
    public y8() {
    }

    public final void invoke(Object r2, CallContext r3) {
        w20.qc r4 = (w20.qc) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        IPaidOuterService r5 = jc1.k.f(IPaidOuterService.class);
        if (r5 == null) goto L6;
        r5.openPanelInRoom(r4.a());
        return;
    }
}
