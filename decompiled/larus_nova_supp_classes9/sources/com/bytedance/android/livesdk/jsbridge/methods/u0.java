package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.lottie.ILottieService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "finishLottieAnimation")
public final class u0 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final void onTerminate() {
    }

    public u0() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JSONObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        jc1.k.n(ILottieService.class).finishLottieAnimation();
        finishWithSuccess();
    }
}
