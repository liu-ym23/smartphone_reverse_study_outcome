package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdkapi.auth.IAuthRoutine;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "doDouyinAuth")
public final class p2 extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    public static class a {

        @SerializedName("source")
        String source;

        public a() {
        }
    }

    public static final class b {

        @SerializedName("status")
        int status;

        public b(int r1) {
            this.status = r1;
        }
    }

    public final void onTerminate() {
    }

    public p2() {
    }

    public final void invoke(Object r3, CallContext r4) throws Exception {
        a r5 = (a) r3;
        Activity r6 = ContextUtil.contextToActivity(r4.getContext());
        if (r6 != null) goto L6;
        finishWithFailure();
    L6:
        if (TTLiveSDK.hostService().user().isLogin() == false) goto L8;
        finishWithResult(new b(0));
    L8:
        jc1.k.f(IAuthRoutine.class).doDouyinAuth(r6, new o2(this), r5.source);
    }
}
