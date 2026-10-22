package com.bytedance.android.livesdk.jsbridge.methods;

import android.text.TextUtils;
import com.bytedance.android.live.core.ILiveCoreService;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "uploadFullLinkMonitor")
public final class p3 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public static final Map<String, LiveTracingMonitor.EventModule> a = null;

    public final void onTerminate() {
    }

    static {
        HashMap r0 = new HashMap();
        a = r0;
        r0.put("ttlive_real_name", LiveTracingMonitor.EventModule.REAL_NAME);
        r0.put("ttlive_activity", LiveTracingMonitor.EventModule.ACTIVITY);
        r0.put("cooperation_partner", LiveTracingMonitor.EventModule.GAME_PROMOTE);
        r0.put("subscribe_vip", LiveTracingMonitor.EventModule.SUBSCRIBE_VIP);
        r0.put("paid_linkmic", LiveTracingMonitor.EventModule.PAID_LINK_MIC);
        LiveTracingMonitor.EventModule r1 = LiveTracingMonitor.EventModule.PREDICTOR_PLAYING;
        r0.put(r1.getName(), r1);
        LiveTracingMonitor.EventModule r2 = LiveTracingMonitor.EventModule.EXCHANGE;
        r0.put(r2.getName(), r2);
        r0.put("team_fight", LiveTracingMonitor.EventModule.TEAM_FIGHT);
        r0.put("room_battle", LiveTracingMonitor.EventModule.ROOM_BATTLE);
        r0.put("guest_battle", LiveTracingMonitor.EventModule.GUEST_BATTLE);
    }

    public p3() {
    }

    public final void invoke(Object r11, CallContext r13) throws Exception {
        JSONObject r14 = (JSONObject) r11;
        String r0 = JSONObjectProtectorUtils.getString(r14, "serviceName");
        String r15 = JSONObjectProtectorUtils.getString(r14, "event_module");
        JSONObject r3 = JSONObjectProtectorUtils.getJSONObject(r14, "category");
        JSONObject r5 = JSONObjectProtectorUtils.getJSONObject(r14, "extra");
        String r16 = JSONObjectProtectorUtils.getString(r14, "event_type");
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L39:
        finishWithFailure(new Throwable("请求参数错误，serviceName is null  or eventModule is null"));
        return;
    L5:
        if (TextUtils.isEmpty(r15) == true) goto L39;
        HashMap r1 = (HashMap) a;
        if (r1.containsKey(r15) == false) goto L10;
        LiveTracingMonitor.EventModule r2 = (LiveTracingMonitor.EventModule) r1.get(r15);
    L11:
        if (r2 != null) goto L14;
        finishWithFailure(new Throwable("请求参数错误，eventModule = " + r15 + "类型未在客户端注册"));
        return;
    L14:
        if (TextUtils.isEmpty(r16) == true) goto L27;
        LiveTracingMonitor.EventType[] r4 = LiveTracingMonitor.EventType.values();
        if (r4 == null) goto L27;
        if (r4.length == 0) goto L27;
        int r6 = r4.length;
        int r7 = 0;
    L22:
        if (r7 >= r6) goto L27;
        LiveTracingMonitor.EventType r8 = r4[r7];
        if (r8.getName().equals(r16) == true) goto L25;
        r7 = r7 + 1;
        goto L22
    L25:
        LiveTracingMonitor.EventType r9 = r8;
    L28:
        if (r9 != null) goto L30;
        finishWithFailure(new Throwable("请求参数错误，eventType = " + r16 + " 类型未在客户端注册"));
        return;
    L30:
        ILiveCoreService r17 = jc1.k.f(ILiveCoreService.class);
        if (TextUtils.equals(r15, "ttlive_real_name") == true) goto L33;
    L37:
        LiveTracingMonitor.e(r0, r2, r9, r3, null, r5);
    L38:
        finishWithSuccess();
        return;
    L33:
        if (r17.realNameUseTracePlatform() == false) goto L37;
        if (com.bytedance.android.live.core.monitor.trace.c.a() == false) goto L37;
        r17.reportUseTrace(r0, r3, null, r5);
    L27:
        r9 = null;
        goto L28
    L10:
        r2 = null;
        goto L11
    }
}
