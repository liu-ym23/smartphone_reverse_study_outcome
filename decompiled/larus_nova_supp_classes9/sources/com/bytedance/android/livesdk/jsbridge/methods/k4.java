package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showShortTouchBubble")
public final class k4 extends com.bytedance.ies.web.jsbridge2.f<com.bytedance.android.live.base.model.n, Object> {
    public final String a;

    public final void onTerminate() {
    }

    public k4() {
        this.a = "ShowShortTouchBubbleMethod";
    }

    public final void invoke(Object r4, CallContext r5) {
        com.bytedance.android.live.base.model.n r6 = (com.bytedance.android.live.base.model.n) r4;
        Intrinsics.checkNotNullParameter(r6, "shortTouchArea");
        Intrinsics.checkNotNullParameter(r5, "callContext");
        ALogger.d(this.a, "short touch info is " + GsonProtectorUtils.toJson(new Gson(), r6));
        xs2.b.a().post(new zg1.v(3, r6.type, r6));
        finishWithSuccess();
    }
}
