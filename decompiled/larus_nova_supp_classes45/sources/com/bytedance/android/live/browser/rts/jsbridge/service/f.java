package com.bytedance.android.live.browser.rts.jsbridge.service;

import com.bytedance.android.live.browser.rts.jsbridge.api.RTSLiveJSBResponseCode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.z;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import p30.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements z<Object> {
    public final /* synthetic */ CallContext a;
    public final /* synthetic */ Function1 b;

    public static final class a implements z.a {
        public final /* synthetic */ f a;

        public final void a(JSONObject r1) {
        }

        public a(f r1) {
            this.a = r1;
        }

        public final void onFailed(Throwable r4) {
            Function1 r0 = this.a.b;
            RTSLiveJSBResponseCode r2 = RTSLiveJSBResponseCode.FAILED;
            if (r4 == null) goto L6;
            String r5 = r4.getMessage();
            if (r5 == null) goto L6;
        L7:
            r0.invoke(new r(r2, r5));
            return;
        L6:
            r5 = "";
            goto L7
        }

        public final void onSucceed(Object r4) {
            this.a.b.invoke(new r(RTSLiveJSBResponseCode.SUCCESS, "success"));
        }
    }

    public final z.a getCallBack() {
        return new a(this);
    }

    public final CallContext a() {
        return this.a;
    }

    public f(CallContext r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
