package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "fansClubMsgGuide")
public final class tc extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    public static final class a {

        @SerializedName("content")
        String content;

        @SerializedName("source")
        String source;

        public a() {
        }
    }

    public tc() {
    }

    public final Object invoke(Object r3, CallContext r4) throws Exception {
        a r5 = (a) r3;
        xs2.b.a().post(new b30.c0(r5.content, r5.source));
        return null;
    }
}
