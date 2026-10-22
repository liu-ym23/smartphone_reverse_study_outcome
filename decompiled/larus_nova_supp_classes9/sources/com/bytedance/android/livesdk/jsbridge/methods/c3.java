package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "pixActivity")
public final class c3 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final void onTerminate() {
    }

    public c3() {
    }

    public final void invoke(Object r3, CallContext r4) {
        JSONObject r5 = (JSONObject) r3;
        Intrinsics.checkNotNullParameter(r5, "msg");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r6 = r5.optString("type");
        if (r6 == null) goto L27;
        int r0 = r6.hashCode();
        if (r0 == (-1157320344)) goto L25;
        if (r0 == (-672946791)) goto L16;
        if (r0 != 772280203) goto L27;
        if (r6.equals("take_off_pix_prop") == false) goto L27;
        xs2.b.a().post(new b30.w());
        finishWithSuccess();
        return;
    L16:
        if (r6.equals("start_random_link") == false) goto L27;
        if (r5.has("args") == false) goto L20;
        JSONObject r7 = JSONObjectProtectorUtils.getJSONObject(r5, "args");
    L21:
        if (r7 == null) goto L23;
        boolean r8 = r7.optBoolean("is_pix_activity", false);
        xs2.b.a().post(new b30.v(r8));
        finishWithSuccess();
        return;
    L23:
        finishWithFailure();
        return;
    L20:
        r7 = null;
        goto L21
    L25:
        if (r6.equals("open_pix_activity_h5") == false) goto L27;
        com.bytedance.android.livesdk.sharedpref.e r9 = com.bytedance.android.livesdk.sharedpref.b.H2;
        Boolean r10 = Boolean.TRUE;
        r9.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r9, r10);
        finishWithSuccess();
        return;
    L27:
        finishWithFailure();
    }
}
