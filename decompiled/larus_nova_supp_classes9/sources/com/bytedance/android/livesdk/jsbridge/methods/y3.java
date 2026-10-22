package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "sendPoiLog")
public final class y3 extends r<z3, SendPoiLogResultModel> {
    public y3() {
    }

    public final void invoke(Object r9, CallContext r10) {
        z3 r11 = (z3) r9;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "context");
        String r2 = r11.e();
        if (r2 == null) goto L8;
        HashMap r13 = (HashMap) GsonProtectorUtils.fromJson(GsonHelper.get(), r11.f(), new x3().getType());
        if (r13 != null) goto L7;
        r13 = new HashMap();
    L7:
        HashMap r3 = r13;
        TTLiveSDK.hostService().hostLiveLocalLife().sendPoiLog(r2, r3, r11.b(), r11.d(), r11.a(), r11.c());
    L8:
        SendPoiLogResultModel r14 = new SendPoiLogResultModel();
        r14.a(SendPoiLogResultModel.Code.Success);
        r14.b("success");
        Unit r15 = Unit.INSTANCE;
        finishWithResult(r14);
    }
}
