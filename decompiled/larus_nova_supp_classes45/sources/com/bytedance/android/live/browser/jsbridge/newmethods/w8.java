package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.room.api.IMatchShareService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openOutSitePushAuthPanel")
public final class w8 extends o<JsonObject, OpenOutSitePushAuthPanelResultModel> {
    public w8() {
    }

    public final void invoke(Object r3, CallContext r4) {
        JsonObject r5 = (JsonObject) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        if ((!Intrinsics.areEqual(r5.get("push_guide_share_scene").getAsString(), "after_live_reservation")) == false) goto L5;
        finishWithFailure(new IllegalArgumentException());
    L5:
        IMatchShareService r6 = jc1.k.f(IMatchShareService.class);
        if (r6 == null) goto L11;
        Pair r7 = r6.openPushGuideDialogForSaas();
        int r8 = ((Number) r7.component1()).intValue();
        String r9 = (String) r7.component2();
        if (r8 != 0) goto L10;
        OpenOutSitePushAuthPanelResultModel r11 = new OpenOutSitePushAuthPanelResultModel();
        r11.a(OpenOutSitePushAuthPanelResultModel.Code.Failed);
        JsonObject r12 = new JsonObject();
        r12.addProperty("msg", "msg");
        Unit r0 = Unit.INSTANCE;
        r11.b(r12);
        finishWithResult(r11);
        return;
    L10:
        finishWithRawResult(new JSONObject("{\"code\": 1, \"msg\": \"" + r9 + "\"}"));
        return;
    L11:
        finishWithRawResult(new JSONObject("{\"code\": 1, \"msg\": \"IMatchShareService null\"}"));
    }
}
