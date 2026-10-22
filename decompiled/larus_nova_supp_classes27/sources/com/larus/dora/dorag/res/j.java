package com.larus.dora.dorag.res;

import com.byted.cast.common.sink.IMessageListener;
import com.byted.cast.common.sink.ServiceInfo;
import com.google.gson.Gson;
import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import org.json.JSONObject;
import t39.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements IMessageListener {
    public final /* synthetic */ DoraByteCastManager a;

    public j(DoraByteCastManager r1) {
        this.a = r1;
    }

    public final String onMessageSync(String r5) {
        FLogger.a.i(this.a.a, "onMessageSync: messageRequest: " + r5);
        return "";
    }

    public final void onMessage(ServiceInfo r10, String r11) {
        FLogger r4 = FLogger.a;
        r4.i(this.a.a, "onMessage: serviceInfo: " + r10 + ", message: " + r11);
        boolean r12 = false;
        if (r11 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L73;
        return;
    L73:
        JSONObject r7 = new JSONObject(r11);     // Catch: Exception -> L70
        if (r7.has("ocrData") == false) goto L26;
        String r13 = r7.optString("ocrData");     // Catch: Exception -> L70
        if (r13.length() != 0) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == false) goto L20;
        r4.e(this.a.a, "parseOcrDataToModel isNullOrEmpty: ".concat(r13));     // Catch: Exception -> L70
        return;
    L20:
        o r14 = (o) new Gson().fromJson(r13, o.class);     // Catch: Exception -> L70
        t39.g r0 = this.a.b;     // Catch: Exception -> L70
        if (r0 == null) goto L26;
        boolean r5 = r14.a();     // Catch: Exception -> L70
        String r8 = r14.b();     // Catch: Exception -> L70
        if (r8 != null) goto L25;
        r8 = "";
    L25:
        r0.d(r5, r8, r14.c());     // Catch: Exception -> L70
        goto L26
    L16:
        r3 = false;
    L26:
        t39.a r1 = null;
        if (r7.has("mirrorData") == false) goto L44;
        JSONObject r15 = r7.optJSONObject("mirrorData");     // Catch: Exception -> L70
        if (r15 == null) goto L44;
        DoraByteCastManager r2 = this.a;     // Catch: Exception -> L70
        s r16 = DoraByteCastManager.m(r2, r15);     // Catch: Exception -> L70
        r2.s = r16;     // Catch: Exception -> L70
        r2.n = r16.h;     // Catch: Exception -> L70
        r2.y(null);     // Catch: Exception -> L70
        if (r2.r() == true) goto L33;
    L40:
        t39.g r9 = r2.b;     // Catch: Exception -> L70
        if (r9 == null) goto L44;
        r9.a(r16);     // Catch: Exception -> L70
        goto L44
    L33:
        if (r2.u == true) goto L40;
        IDoraService r17 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L70
        if (r17 == null) goto L39;
        com.larus.dora.impl.serviceimpl.h r18 = r17.debug();     // Catch: Exception -> L70
        if (r18 == null) goto L39;
        r18.j();     // Catch: Exception -> L70
    L39:
        r2.u = true;     // Catch: Exception -> L70
    L44:
        if (r7.has("monitorData") == false) goto L74;
        JSONObject r110 = r7.optJSONObject("monitorData");     // Catch: Exception -> L70
        if (r110 == null) goto L66;
        this.a.getClass();     // Catch: Exception -> L70
        Integer r20 = DoraByteCastManager.t(r110, "bwAvgKbps");     // Catch: Exception -> L70
        if (r20 == null) goto L66;
        int r21 = r20.intValue();     // Catch: Exception -> L70
        Integer r22 = DoraByteCastManager.t(r110, "estBw");     // Catch: Exception -> L70
        if (r22 == null) goto L66;
        int r23 = r22.intValue();     // Catch: Exception -> L70
        Integer r24 = DoraByteCastManager.t(r110, "failCount");     // Catch: Exception -> L70
        if (r24 == null) goto L66;
        int r25 = r24.intValue();     // Catch: Exception -> L70
        Integer r111 = DoraByteCastManager.t(r110, "flowLevel");     // Catch: Exception -> L70
        if (r111 == null) goto L66;
        int r112 = r111.intValue();     // Catch: Exception -> L70
        if (r21 < 0) goto L66;
        if (r23 < 0) goto L66;
        if (r25 < 0) goto L66;
        if (1 <= r112) goto L61;
    L63:
        if (r12 == false) goto L66;
        r1 = new t39.a(r21, r23, r25, r112);     // Catch: Exception -> L70
        goto L66
    L61:
        if (r112 >= 6) goto L63;
        r12 = true;
    L66:
        if (r1 == null) goto L68;
        DoraByteCastManager.k(this.a, r1);     // Catch: Exception -> L70
        return;
    L68:
        this.a.getClass();     // Catch: Exception -> L70
        return;
    L74:
        return;
    L70:
        e = move-exception;
        FLogger.a.e(this.a.a, "onMessage parse json error", e);
        return;
    L5:
        if (r11.length() == 0) goto L8;
        r6 = false;
        goto L9
    }
}
