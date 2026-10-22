package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "pixarActivityDidLoad")
public final class d3 extends com.bytedance.ies.web.jsbridge2.f<b30.u.a, JSONObject> {
    public final void onTerminate() {
    }

    public d3() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((b30.u.a) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        xs2.b.a().post(new b30.u());
        finishWithSuccess();
    }
}
