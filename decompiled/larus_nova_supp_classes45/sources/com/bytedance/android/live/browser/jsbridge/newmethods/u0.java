package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "setBottomBannerVisibility")
public final class u0 extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    public static final class a {

        @SerializedName("visible")
        int visible;

        public a() {
        }
    }

    public u0() {
    }

    public final Object invoke(Object r2, CallContext r3) throws Exception {
        xs2.b.a().post(new b30.b(((a) r2).visible));
        return null;
    }
}
