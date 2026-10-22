package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.CheckWidgetInstallationResultModel;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "checkWidgetInstallation")
public final class y1 extends w20.t<w20.d8, CheckWidgetInstallationResultModel> {
    public y1() {
    }

    public final void invoke(Object r3, CallContext r4) {
        w20.d8 r5 = (w20.d8) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        IHostBusiness r6 = jc1.k.f(IHostBusiness.class);
        CheckWidgetInstallationResultModel r0 = new CheckWidgetInstallationResultModel();
        r0.b(new CheckWidgetInstallationResultModel.a());
        CheckWidgetInstallationResultModel.a r1 = r0.a();
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r6);
        r1.a(Boolean.valueOf(r6.checkIfAppWidgetInstalled(r5.a())));
    L5:
        finishWithResult(r0);
    }
}
