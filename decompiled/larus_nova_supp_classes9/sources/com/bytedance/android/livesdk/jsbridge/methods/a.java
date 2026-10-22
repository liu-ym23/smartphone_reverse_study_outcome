package com.bytedance.android.livesdk.jsbridge.methods;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "reportALog")
public final class a extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public static final Map<String, LiveTracingMonitor.EventModule> a = null;

    public final void onTerminate() {
    }

    static {
        HashMap r0 = new HashMap();
        a = r0;
        r0.put("ttlive_real_name", LiveTracingMonitor.EventModule.REAL_NAME);
    }

    public a() {
    }

    public final void invoke(Object r6, CallContext r7) throws Exception {
        JSONObject r8 = (JSONObject) r6;
        String r9 = JSONObjectProtectorUtils.getString(r8, "level");
        String r0 = JSONObjectProtectorUtils.getString(r8, "tag");
        String r1 = JSONObjectProtectorUtils.getString(r8, "message");
        if (TextUtils.isEmpty(r9) == false) goto L5;
    L31:
        finishWithFailure();
        return;
    L5:
        if (TextUtils.isEmpty(r0) == true) goto L31;
        if (TextUtils.isEmpty(r1) == true) goto L31;
        JSONObject r10 = r8.optJSONObject("codePosition");
        if (r10 == null) goto L13;
        String r2 = r10.optString("file");
        String r3 = r10.optString("line");
        String r11 = r10.optString("function");
        TextUtils.isEmpty(r2);
        TextUtils.isEmpty(r3);
        TextUtils.isEmpty(r11);
    L13:
        if (((HashMap) a).containsKey(r0) == false) goto L16;
        finishWithFailure(new Throwable("tag 类型不允许调用JSB，需要注册，tag=" + r0));
        return;
    L16:
        if ("info".equals(r9) == false) goto L19;
        ALogger.i(r0, r1);
    L30:
        JSONObject r13 = new JSONObject();
        r13.put("code", 1);
        r13.put("msg", "SUCCESS");
        finishWithResult(r13);
        return;
    L19:
        if ("verbose".equals(r9) == false) goto L22;
        ALogger.v(r0, r1);
        goto L30
    L22:
        if ("warn".equals(r9) == false) goto L25;
        ALogger.w(r0, r1);
        goto L30
    L25:
        if ("error".equals(r9) == false) goto L28;
        ALogger.e(r0, r1);
        goto L30
    L28:
        if ("debug".equals(r9) == false) goto L30;
        ALogger.d(r0, r1);
        goto L30
    }
}
