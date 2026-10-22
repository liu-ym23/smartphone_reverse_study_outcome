package com.bytedance.android.live.browser.rts.jsbridge.service;

import com.bytedance.android.live.browser.rts.jsbridge.api.RTSLiveJSBResponseCode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.z;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import p30.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements z<JsonObject> {
    public final /* synthetic */ CallContext a;
    public final /* synthetic */ Function1 b;

    public static final class a implements z.a {
        public final /* synthetic */ b a;

        public final void a(JSONObject r1) {
        }

        public a(b r1) {
            this.a = r1;
        }

        public final void onFailed(Throwable r4) {
            this.a.b.invoke(new g("", RTSLiveJSBResponseCode.FAILED, ""));
        }

        public final void onSucceed(Object r6) {
            if ((r6 instanceof JsonObject) == false) goto L15;
            e.a r0 = e.a;
            JsonObject r7 = (JsonObject) r6;
            JsonElement r1 = r7.get("data");
            if ((r1 instanceof JsonObject) == true) goto L7;
            r1 = null;
        L7:
            JsonObject r2 = (JsonObject) r1;
            if (r2 != null) goto L10;
            r2 = new JsonObject();
        L10:
            r0.getClass();
            Map r3 = e.a.c(r2);
            Function1 r4 = this.a.b;
            RTSLiveJSBResponseCode r5 = RTSLiveJSBResponseCode.SUCCESS;
            String r8 = r7.get("key");
            if (r8 != null) goto L13;
            r8 = "";
        L13:
            r4.invoke(new g(r8, r5, r3));
            return;
        }
    }

    public final z.a getCallBack() {
        return new a(this);
    }

    public final CallContext a() {
        return this.a;
    }

    public b(CallContext r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
