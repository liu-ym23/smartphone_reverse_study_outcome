package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.auth.IAuthRoutine;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getPhoneNumber")
public final class r9 extends com.bytedance.ies.web.jsbridge2.f<Object, Object> {

    public static final class a {

        @SerializedName("phone_number")
        String phoneNumber;

        public a(String r1) {
            this.phoneNumber = r1;
        }
    }

    public final void onTerminate() {
    }

    public r9() {
    }

    public final void invoke(Object r1, CallContext r2) throws Exception {
        jc1.k.f(IAuthRoutine.class).getCurrentAccountPhoneNumber(new q9(this));
    }
}
