package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetLiveNtpTimeResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u4 extends w20.n1<JsonObject, GetLiveNtpTimeResultModel> {
    public u4() {
    }

    public final void invoke(Object r4, CallContext r5) {
        JsonObject r6 = (JsonObject) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        long r0 = com.bytedance.android.livesdk.utils.ntp.e.a();
        ALogger.i("GetLiveNtpTimeMethod", "param: " + r6 + ", currentServerTime: " + r0);
        GetLiveNtpTimeResultModel r7 = new GetLiveNtpTimeResultModel();
        r7.a(GetLiveNtpTimeResultModel.Code.Success);
        GetLiveNtpTimeResultModel.a r8 = new GetLiveNtpTimeResultModel.a();
        r8.a(Long.valueOf(r0));
        Unit r1 = Unit.INSTANCE;
        r7.b(r8);
        finishWithResult(r7);
    }
}
