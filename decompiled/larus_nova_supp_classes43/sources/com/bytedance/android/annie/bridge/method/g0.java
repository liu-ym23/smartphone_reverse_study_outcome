package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.GetUserInfoResultModel;
import com.bytedance.android.annie.service.userinfo.IUserInfoService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "getUserInfo")
public final class g0 extends e7.j<JsonObject, GetUserInfoResultModel> {
    public g0() {
    }

    public final void invoke(Object r10, CallContext r11) {
        Intrinsics.checkNotNullParameter((JsonObject) r10, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        IUserInfoService r12 = (IUserInfoService) Annie.getService(IUserInfoService.class, r11.a());
        GetUserInfoResultModel r13 = new GetUserInfoResultModel();
        r12.hasLogin();
        r13.a(GetUserInfoResultModel.Code.Success);
        r13.c("Call Success !");
        r13.b(Boolean.FALSE);
        r13.d(new GetUserInfoResultModel.a());
        finishWithResult(r13);
    }
}
