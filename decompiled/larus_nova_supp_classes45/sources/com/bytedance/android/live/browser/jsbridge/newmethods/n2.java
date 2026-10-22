package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "dismissFinishPage")
public final class n2 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
    public n2() {
    }

    public final Object invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JSONObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        Activity r4 = ContextUtil.contextToActivity(r3.getContext());
        if (r4 == null) goto L6;
        r4.finish();
    L6:
        return new JSONObject();
    }
}
