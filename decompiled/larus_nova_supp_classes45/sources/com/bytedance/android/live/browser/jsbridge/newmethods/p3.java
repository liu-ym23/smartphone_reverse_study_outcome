package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GcpLoadPerfLoadResultModel;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "gcpLoadPerfLoad")
public final class p3 extends w20.a1<w20.g9, GcpLoadPerfLoadResultModel> {
    public p3() {
    }

    public final void invoke(Object r5, CallContext r6) {
        w20.g9 r7 = (w20.g9) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        IHostGameCP r8 = jc1.k.f(IHostGameCP.class);
        if (r8 == null) goto L5;
        IGameCPFmpMonitorService r9 = r8.getGameCPFmpMonitorService();
    L7:
        if (Intrinsics.areEqual(r7.a(), "begin") == false) goto L11;
        if (r9 == null) goto L14;
        r9.markActionStart(String.valueOf(r7.c()), r7.b() + '_' + r7.a(), r7.b() + "_duration", Intrinsics.areEqual(r7.d(), Boolean.TRUE));
    L14:
        GcpLoadPerfLoadResultModel r11 = new GcpLoadPerfLoadResultModel();
        r11.a(GcpLoadPerfLoadResultModel.Code.Success);
        Unit r12 = Unit.INSTANCE;
        finishWithResult(r11);
        return;
    L11:
        if (Intrinsics.areEqual(r7.a(), "end") == false) goto L14;
        if (r9 == null) goto L14;
        r9.markActionEnd(String.valueOf(r7.c()), r7.b() + '_' + r7.a());
        goto L14
    L5:
        r9 = null;
        goto L7
    }
}
