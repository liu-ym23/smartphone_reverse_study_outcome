package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetMuteStatusResultModel;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getMuteStatus")
public final class d5 extends w20.p1<JsonObject, GetMuteStatusResultModel> {
    public d5() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        boolean r4 = jc1.k.n(IHostAction.class).getMuteStatus();
        GetMuteStatusResultModel r5 = new GetMuteStatusResultModel();
        r5.a(GetMuteStatusResultModel.Code.Success);
        GetMuteStatusResultModel.a r0 = new GetMuteStatusResultModel.a();
        r0.a(Boolean.valueOf(r4));
        Unit r6 = Unit.INSTANCE;
        r5.b(r0);
        finishWithResult(r5);
    }
}
