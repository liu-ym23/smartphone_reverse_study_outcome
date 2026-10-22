package com.bytedance.android.livesdk.jsbridge.methods;

import android.view.View;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "localLife.getPageBtm")
public final class a1 extends k<JsonObject, LocalLifeGetPageBtmResultModel> {
    public a1() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        IHostLiveLocalLife r4 = jc1.k.f(IHostLiveLocalLife.class);
        if (r4 != null) goto L5;
        finishWithFailure();
        return;
    L5:
        View r5 = r3.d;
        if (r5 != null) goto L8;
        finishWithFailure();
        return;
    L8:
        JsonObject r6 = r4.getPageBtmInfo(r5);
        LocalLifeGetPageBtmResultModel r7 = new LocalLifeGetPageBtmResultModel();
        r7.a(LocalLifeGetPageBtmResultModel.Code.Success);
        LocalLifeGetPageBtmResultModel.a r0 = new LocalLifeGetPageBtmResultModel.a();
        r0.a(r6);
        Unit r8 = Unit.INSTANCE;
        r7.b(r0);
        finishWithResult(r7);
    }
}
