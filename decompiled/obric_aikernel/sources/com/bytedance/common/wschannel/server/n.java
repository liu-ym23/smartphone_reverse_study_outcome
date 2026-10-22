package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.SsWsApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
class n implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f1465b = "n";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1466a;

    static {
    }

    n(Context r10) {
        this.f1466a = r10;
    }

    private boolean c(IWsApp r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.getChannelId() > 0) goto L9;
        return false;
    L9:
        if (r10.getAppId() > 0) goto L12;
        return false;
    L12:
        if (com.bytedance.common.utility.g.b(r10.getAppKey()) == false) goto L15;
        return false;
    L15:
        if (r10.getAppVersion() > 0) goto L18;
        return false;
    L18:
        if (r10.getConnectUrls().isEmpty() == false) goto L21;
        return false;
    L21:
        if (com.bytedance.common.utility.g.b(r10.getDeviceId()) == false) goto L24;
        return false;
    L24:
        if (r10.getFPID() > 0) goto L27;
        return false;
    L27:
        if (com.bytedance.common.utility.g.b(r10.getInstallId()) == false) goto L30;
        return false;
    L30:
        if (r10.getPlatform() == 0) goto L32;
        return false;
    L32:
        return true;
    }

    @Override // com.bytedance.common.wschannel.server.g
    public Map<Integer, IWsApp> a() {
        LinkedHashMap r10 = new LinkedHashMap();
        String r11 = com.bytedance.common.wschannel.l.f(this.f1466a).e();     // Catch: Exception -> L29
        if (Logger.debug() == false) goto L7;
        Logger.d(f1465b, "load from sp wsAppStr: " + r11);     // Catch: Exception -> L29
    L7:
        if (TextUtils.isEmpty(r11) == false) goto L9;
        return r10;
    L9:
        JSONArray r12 = new JSONArray(r11);     // Catch: Exception -> L29
        int r13 = r12.length();     // Catch: Exception -> L29
        if (r13 > 0) goto L12;
        return r10;
    L12:
        ArrayList<Integer> r14 = com.bytedance.common.wschannel.l.f(this.f1466a).a();     // Catch: Exception -> L29
        if (Logger.debug() == false) goto L15;
        Logger.d(f1465b, "load from sp disabledList: " + r14);     // Catch: Exception -> L29
    L15:
        int r15 = 0;
    L16:
        if (r15 >= r13) goto L26;
        SsWsApp r16 = new SsWsApp.b().b(r12.optJSONObject(r15));     // Catch: Exception -> L29
        if (c(r16) == false) goto L24;
        if (r14 != null) goto L21;
    L23:
        r10.put(Integer.valueOf(WsChannelService.d(r16)), r16);     // Catch: Exception -> L29
        goto L24
    L21:
        if (r14.contains(Integer.valueOf(WsChannelService.d(r16))) == false) goto L23;
    L24:
        r15 = r15 + 1;     // Catch: Exception -> L29
        goto L16
    L26:
        if (Logger.debug() == false) goto L31;
        Logger.d(f1465b, "loadWsChannels final wsApp: " + r10);     // Catch: Exception -> L29
    L31:
        return r10;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    }

    @Override // com.bytedance.common.wschannel.server.g
    public void b(Map<Integer, IWsApp> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        JSONArray r11 = new JSONArray();
        monitor-enter(WsChannelService.class);
        Iterator<Map.Entry<Integer, IWsApp>> r12 = r10.entrySet().iterator();     // Catch: Throwable -> L22
    L8:
        if (r12.hasNext() == false) goto L16;
        Map.Entry<Integer, IWsApp> r13 = r12.next();     // Catch: Throwable -> L22
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L8
    L11:
        if (c(r13.getValue()) == false) goto L8;
        r11.put(r13.getValue().toJson());     // Catch: Exception -> L14 Throwable -> L22
    L16:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L22
        Logger.d(f1465b, "save to sp : " + r11.toString());     // Catch: Exception -> L19
        com.bytedance.common.wschannel.l.f(this.f1466a).l(r11.toString());     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L22:
        th = move-exception;
        throw th;
    }
}
