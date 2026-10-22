package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "setAppointmentStatus")
public final class ac extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public final void onTerminate() {
    }

    public ac() {
    }

    public final void invoke(Object r3, CallContext r4) {
        JSONObject r5 = (JSONObject) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        boolean r6 = JSONObjectProtectorUtils.getBoolean(r5, "status");
        qm1.a r7 = new qm1.a(CastLongProtector.parseLong(JSONObjectProtectorUtils.getString(r5, "appointment_id")), r6);
        xs2.b.a().post(r7);
    }
}
