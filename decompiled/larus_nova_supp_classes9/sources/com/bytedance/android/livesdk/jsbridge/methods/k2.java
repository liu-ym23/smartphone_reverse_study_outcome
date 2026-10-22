package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "ocrUploadPhoto")
public final class k2 extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {

    public static final class a {

        @SerializedName("compress")
        public int compress;

        @SerializedName("params")
        public g2 params;

        @SerializedName("type")
        public String type;

        public a() {
        }
    }

    public final void onTerminate() {
    }

    public k2() {
    }

    public final void invoke(Object r5, CallContext r6) throws Exception {
        a r7 = (a) r5;
        x80.b r0 = x80.c.a(0);
        v80.e.a r1 = new v80.e.a();
        r1.a = r6.getContext();
        g2 r8 = r7.params;
        String r2 = null;
        if (r8 == null) goto L5;
        String r3 = r8.scene;
    L6:
        r1.b = r3;
        if (r8 == null) goto L9;
        String r4 = r8.mode;
    L10:
        r1.f = r4;
        if (r8 == null) goto L13;
        r2 = r8.ticket;
    L13:
        r1.e = r2;
        r1.d = r7.compress;
        r1.c = r7.type;
        r1.g = new j2(this);
        r0.a.a(new v80.e(r1));
        return;
    L9:
        r4 = "identity_code";
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
