package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livehostapi.business.IHostVerify;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "secondValid")
public final class w3 extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {

    public static final class a {

        @SerializedName("decision_config")
        public String decisionConfig;

        @SerializedName("ticket")
        public String ticket;

        public a() {
        }
    }

    public final void onTerminate() {
    }

    public w3() {
    }

    public final void invoke(Object r2, CallContext r3) throws Exception {
        Activity r4 = ContextUtil.contextToActivity(r3.getContext());
        jc1.k.f(IHostVerify.class).startTwiceVerifyWithDialog(r4, ((a) r2).decisionConfig).compose(RxUtil.rxSchedulerHelper()).subscribe(new u3(this), new v3(this));
    }
}
