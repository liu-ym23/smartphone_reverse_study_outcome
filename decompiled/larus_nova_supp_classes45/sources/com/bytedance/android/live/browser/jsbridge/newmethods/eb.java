package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.RequestPinWidgetResultModel;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "requestPinWidget")
public final class eb extends w20.k5<w20.kd, RequestPinWidgetResultModel> {
    public eb() {
    }

    public final void invoke(Object r5, CallContext r6) {
        w20.kd r7 = (w20.kd) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        IHostBusiness r0 = jc1.k.n(IHostBusiness.class);
        Integer r1 = r7.b();
        if (r1 != null) goto L6;
    L8:
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.intValue() != 2) goto L15;
        r0.updateAppWidget(r6.getContext(), r7.a());
        return;
    L15:
        return;
    L6:
        if (r1.intValue() != 1) goto L8;
        r0.requestPinWidget(r6.getContext(), r7.a());
    }
}
