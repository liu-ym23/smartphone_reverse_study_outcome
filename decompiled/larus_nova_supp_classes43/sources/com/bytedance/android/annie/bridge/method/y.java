package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.GetCurrentTimeResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "getCurrentTime")
public final class y extends e7.g<JsonObject, GetCurrentTimeResultModel> {
    public y() {
    }

    public final void invoke(Object r10, CallContext r11) {
        Intrinsics.checkNotNullParameter((JsonObject) r10, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        long r12 = com.bytedance.android.annie.util.x.b();
        if (r12 == 0) goto L5;
        GetCurrentTimeResultModel r0 = new GetCurrentTimeResultModel();
        r0.a(GetCurrentTimeResultModel.Code.Success);
        GetCurrentTimeResultModel.a r1 = new GetCurrentTimeResultModel.a();
        r1.a(Long.valueOf(r12));
        r0.b(r1);
        finishWithResult(r0);
        return;
    L5:
        JSONObject r13 = new JSONObject();
        r13.put("code", 0);
        finishWithRawResult(r13);
    }
}
