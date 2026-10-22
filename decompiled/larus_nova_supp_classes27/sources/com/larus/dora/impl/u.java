package com.larus.dora.impl;

import ak4.a;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.mammon.audiosdk.SAMICoreWakeupParamRequestCallback;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import g49.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u implements SAMICoreWakeupParamRequestCallback {
    public u() {
    }

    public final String onWakeupParamRequest(String r8, int r9) {
        DoraDevice r10 = a.d().a.A;
        JSONObject r11 = new JSONObject();
        int r0 = DoraPreWakeUpTask.d;
        r11.put("model_md5", DoraPreWakeUpTask.Companion.h());
        r11.put("model_path", DoraPreWakeUpTask.Companion.j());
        JSONObject r1 = new JSONObject();
        if (AppHost.a.a().isAppBackground() == false) goto L5;
        int r2 = 1;
    L6:
        r1.put("app_status", r2);
        r1.put("did", com.larus.platform.service.o.a.getDeviceId());
        r1.put("model_info", r11);
        JSONObject r3 = new JSONObject();
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        String r5 = "";
        if (r4 == null) goto L11;
        SessionService r6 = r4.d();
        if (r6 == null) goto L11;
        String r7 = r6.g("dora_full_duplex");
    L12:
        r3.put("app_key", r7);
        r3.put("audio_format", "speech_opus");
        r3.put("business_type", DoraPreWakeUpTask.Companion.g());
        r3.put("token", DoraPreWakeUpTask.Companion.k());
        r3.put("token_type", 1);
        r3.put("url", "https://audio.doubao.com/internal");
        r1.put("query_type", 1);
        if (r10 == null) goto L18;
        String r12 = r10.modelVersion;
        if (r12 == null) goto L18;
        r5 = r12;
    L18:
        r1.put("engine_version", r5);
        String r13 = null;
        if (r10 == null) goto L21;
        String r14 = r10.sn;
    L22:
        r1.put("sn", r14);
        if (r10 == null) goto L26;
        String r15 = r10.softVersion;
        if (r15 == null) goto L26;
    L27:
        r1.put("fw_version", r15);
        StringBuilder r16 = new StringBuilder("initSecondWakeUpCallback current: productId=");
        if (r10 == null) goto L30;
        Integer r17 = Integer.valueOf(r10.productId);
    L31:
        r16.append(r17);
        r16.append(", sn=");
        if (r10 == null) goto L34;
        String r18 = r10.sn;
    L35:
        r16.append(r18);
        r16.append(", version=");
        if (r10 == null) goto L38;
        String r20 = r10.softVersion;
    L39:
        r16.append(r20);
        r16.append(", modelVersion=");
        if (r10 == null) goto L42;
        r13 = r10.modelVersion;
    L42:
        r16.append(r13);
        d.d("DoraPreWakeUpTask", r16.toString());
        r1.put("model_info", r11);
        r1.put("server_param", r3);
        return r1.toString();
    L38:
        r20 = null;
        goto L39
    L34:
        r18 = null;
        goto L35
    L30:
        r17 = null;
    L26:
        r15 = "none";
        goto L27
    L21:
        r14 = null;
    L11:
        r7 = "";
        goto L12
    L5:
        r2 = 3;
        goto L6
    }
}
