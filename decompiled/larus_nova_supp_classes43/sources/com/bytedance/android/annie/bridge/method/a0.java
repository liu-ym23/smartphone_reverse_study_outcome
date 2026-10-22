package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.GetCurrentTimeResultModel;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast", name = "getCurrentTimeSaas")
public final class a0 extends e7.g<JsonObject, GetCurrentTimeResultModel> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public a0() {
    }

    public final void invoke(Object r10, CallContext r11) {
        Intrinsics.checkNotNullParameter((JsonObject) r10, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        long r12 = p6.b();
        if (r12 == 0) goto L5;
        GetCurrentTimeResultModel r0 = new GetCurrentTimeResultModel();
        r0.a(GetCurrentTimeResultModel.Code.Success);
        GetCurrentTimeResultModel.a r1 = new GetCurrentTimeResultModel.a();
        r1.a(Long.valueOf(r12));
        Unit r13 = Unit.INSTANCE;
        r0.b(r1);
        finishWithResult(r0);
        return;
    L5:
        JSONObject r14 = new JSONObject();
        r14.put("code", 0);
        Unit r15 = Unit.INSTANCE;
        finishWithRawResult(r14);
    }
}
