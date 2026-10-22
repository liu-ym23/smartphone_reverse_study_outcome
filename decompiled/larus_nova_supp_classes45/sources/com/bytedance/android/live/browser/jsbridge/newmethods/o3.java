package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GcpLoadPerfFinishLoadWithErrorResultModel;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "gcpLoadPerfFinishLoadWithError")
public final class o3 extends w20.z0<w20.f9, GcpLoadPerfFinishLoadWithErrorResultModel> {
    public o3() {
    }

    public final void invoke(Object r2, CallContext r3) {
        w20.f9 r4 = (w20.f9) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        IHostGameCP r5 = jc1.k.f(IHostGameCP.class);
        if (r5 == null) goto L5;
        IGameCPFmpMonitorService r6 = r5.getGameCPFmpMonitorService();
    L6:
        if (r6 == null) goto L8;
        r6.stopFmpTrack(String.valueOf(r4.b()), String.valueOf(r4.a()));
    L8:
        GcpLoadPerfFinishLoadWithErrorResultModel r7 = new GcpLoadPerfFinishLoadWithErrorResultModel();
        r7.a(GcpLoadPerfFinishLoadWithErrorResultModel.Code.Success);
        Unit r8 = Unit.INSTANCE;
        finishWithResult(r7);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
