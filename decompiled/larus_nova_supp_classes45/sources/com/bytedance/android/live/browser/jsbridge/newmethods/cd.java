package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "startAnimationEvent")
public final class cd extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public final void onTerminate() {
    }

    public cd() {
    }

    public final void invoke(Object r2, CallContext r3) {
        JSONObject r4 = (JSONObject) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        String r5 = JSONObjectProtectorUtils.getString(r4, "key");
        if (TextUtils.isEmpty(r5) == true) goto L5;
        b30.e0 r6 = new b30.e0(r5);
        xs2.b.a().post(r6);
    L5:
        finishWithSuccess();
    }
}
