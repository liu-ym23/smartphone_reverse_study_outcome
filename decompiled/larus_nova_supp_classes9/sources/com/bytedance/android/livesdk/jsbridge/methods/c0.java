package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livehostapi.business.IHostVerify;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdkapi.eventbus.LiveRealStartEvent;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c0 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final String a;

    public final void onTerminate() {
    }

    public c0(String r1) {
        this.a = r1;
    }

    public final void invoke(Object r3, CallContext r4) throws Exception {
        Context r5 = r4.getContext();
        String r0 = this.a;
        j(r5, r0, (JSONObject) r3, new b0(this));
    }

    public static void j(Context r10, String r11, JSONObject r13, final ILiveService.JsbHandleCallback r14) {
        if (r13 != null) goto L41;
        r13 = new JSONObject();
    L41:
        r13.put("method", r11);     // Catch: Exception -> L40
    L8:
        if ("recharge".equals(r13.optString("enter_from")) == false) goto L24;
        if (r13.has("is_minor") == false) goto L21;
        Activity r15 = ContextUtil.contextToActivity(r10);
        if ("1".equals(r13.optString("is_minor")) == false) goto L17;
        Intent r16 = new Intent();
        r16.putExtra("key_verify_result", 2);
        if (r15 == null) goto L21;
        r15.setResult(0, r16);
        goto L21
    L17:
        if ("0".equals(r13.optString("is_minor")) == false) goto L21;
        Intent r17 = new Intent();
        r17.putExtra("key_verify_result", 3);
        if (r15 == null) goto L21;
        r15.setResult(-1, r17);
    L21:
        r14.onHandleResult(true, null);
        return;
    L24:
        if (TextUtils.equals(r11, "syncCertificationStatus") == false) goto L30;
        if (r13.optInt("type") != 2) goto L30;
        xs2.b.a().post(new com.bytedance.android.livesdk.event.u(r13.optInt("result", -1)));
        r14.onHandleResult(true, null);
        return;
    L30:
        if ("syncCertificationStatus".equals(r11) == true) goto L43;
    L38:
        jc1.k.f(IHostAction.class).handleSchemaWithCallback(r10, "//verify/handlejsmethods", r13, new a0(r14));
        return;
    L43:
        int r18 = r13.optInt("type");     // Catch: Exception -> L36
        int r3 = r13.optInt("result");     // Catch: Exception -> L36
        int r4 = r13.optInt("is_enter_live");     // Catch: Exception -> L36
        String r1 = r13.optString("enter_from");     // Catch: Exception -> L36
        if ("live_permission_apply".equals(r1) == false) goto L34;
        return;
    L34:
        LiveRealStartEvent r5 = new LiveRealStartEvent(r18, r3, r1, r4);     // Catch: Exception -> L36
        xs2.b.a().post(r5);     // Catch: Exception -> L36
        jc1.k.f(IHostVerify.class).syncVerifyResult(r5);     // Catch: Exception -> L36
        ALogger.i("[LiveVerifyFullTracer]", "syncCertificationStatus, type = " + r18 + ", verifyResult = " + r3 + ", enterFrom = " + r1);     // Catch: Exception -> L36
    L36:
        e = move-exception;
        ALogger.e("syncCertificationStatus", e);
        goto L38
    }
}
