package com.bytedance.android.live.browser.rts.jsbridge.service;

import com.bytedance.android.live.browser.rts.jsbridge.api.RTSLiveJSBResponseCode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.z;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import p30.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements z<JSONObject> {
    public final /* synthetic */ CallContext a;
    public final /* synthetic */ Function1 b;

    public static final class a implements z.a {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void a(JSONObject r2) {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        public final void onFailed(Throwable r3) {
            Function1 r4 = this.a.b;
            RTSLiveJSBResponseCode r1 = RTSLiveJSBResponseCode.FAILED;
            r4.invoke(new n(new LinkedHashMap()));
        }

        public final void onSucceed(Object r3) {
            if (r3 == null) goto L7;
            RTSLiveJSBResponseCode r1 = RTSLiveJSBResponseCode.FAILED;
            e.a.getClass();
            Map r4 = e.a.a(r3);
            if (r4 != null) goto L6;
            r4 = new LinkedHashMap();
        L6:
            n r0 = new n(r4);
        L8:
            this.a.b.invoke(r0);
            return;
        L7:
            LinkedHashMap r5 = new LinkedHashMap();
            RTSLiveJSBResponseCode r2 = RTSLiveJSBResponseCode.FAILED;
            r0 = new n(r5);
            goto L8
        }
    }

    public final z.a getCallBack() {
        return new a(this);
    }

    public final CallContext a() {
        return this.a;
    }

    public d(CallContext r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
