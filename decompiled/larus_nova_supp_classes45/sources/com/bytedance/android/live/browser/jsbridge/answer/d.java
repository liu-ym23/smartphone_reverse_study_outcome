package com.bytedance.android.live.browser.jsbridge.answer;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetStreamTimeStampResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.y2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.getStreamTimeStamp")
public final class d extends y2<JsonObject, LiveGetStreamTimeStampResultModel> {
    public d() {
    }

    public final void invoke(Object r3, CallContext r4) {
        Intrinsics.checkNotNullParameter((JsonObject) r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        LiveGetStreamTimeStampResultModel r5 = new LiveGetStreamTimeStampResultModel();
        r5.a(LiveGetStreamTimeStampResultModel.Code.Success);
        LiveGetStreamTimeStampResultModel.a r6 = new LiveGetStreamTimeStampResultModel.a();
        r6.a(String.valueOf(com.bytedance.android.livesdk.utils.ntp.e.a()));
        Unit r0 = Unit.INSTANCE;
        r5.b(r6);
        finishWithResult(r5);
    }
}
