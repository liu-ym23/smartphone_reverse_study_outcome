package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
class n implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2199a = "n";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2200b;

    static {
    }

    n(Context r3) {
        this.f2200b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    private boolean a(IWsApp r2) {
        IWsApp r1 = (IWsApp) ZeusTransformUtils.wrapperContextForParams(r2, IWsApp.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.getChannelId() > 0) goto L9;
        return false;
    L9:
        if (r1.getAppId() > 0) goto L12;
        return false;
    L12:
        if (com.bytedance.common.utility.h.a(r1.getAppKey()) == false) goto L15;
        return false;
    L15:
        if (r1.getAppVersion() > 0) goto L18;
        return false;
    L18:
        if (r1.getConnectUrls().isEmpty() == false) goto L21;
        return false;
    L21:
        if (com.bytedance.common.utility.h.a(r1.getDeviceId()) == false) goto L24;
        return false;
    L24:
        if (r1.getFPID() > 0) goto L27;
        return false;
    L27:
        if (com.bytedance.common.utility.h.a(r1.getInstallId()) == false) goto L30;
        return false;
    L30:
        if (r1.getPlatform() == 0) goto L32;
        return false;
    L32:
        return true;
    }

    @Override // com.bytedance.common.wschannel.server.g
    public Map<Integer, IWsApp> a() {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = com.bytedance.common.wschannel.l.a(this.f2200b).d();     // Catch: Exception -> L29
        if (Logger.debug() == false) goto L7;
        Logger.d(f2199a, "load from sp wsAppStr: " + r1);     // Catch: Exception -> L29
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return r0;
    L9:
        JSONArray r2 = new JSONArray(r1);     // Catch: Exception -> L29
        int r3 = r2.length();     // Catch: Exception -> L29
        if (r3 > 0) goto L12;
        return r0;
    L12:
        ArrayList<Integer> r4 = com.bytedance.common.wschannel.l.a(this.f2200b).i();     // Catch: Exception -> L29
        if (Logger.debug() == false) goto L15;
        Logger.d(f2199a, "load from sp disabledList: " + r4);     // Catch: Exception -> L29
    L15:
        int r5 = 0;
    L16:
        if (r5 >= r3) goto L26;
        SsWsApp r6 = new SsWsApp.a().a(r2.optJSONObject(r5));     // Catch: Exception -> L29
        if (a(r6) == false) goto L24;
        if (r4 != null) goto L21;
    L23:
        r0.put(Integer.valueOf(WsChannelService.a(r6)), r6);     // Catch: Exception -> L29
        goto L24
    L21:
        if (r4.contains(Integer.valueOf(WsChannelService.a(r6))) == false) goto L23;
    L24:
        r5 = r5 + 1;     // Catch: Exception -> L29
        goto L16
    L26:
        if (Logger.debug() == false) goto L31;
        Logger.d(f2199a, "loadWsChannels final wsApp: " + r0);     // Catch: Exception -> L29
    L31:
        return r0;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    }

    @Override // com.bytedance.common.wschannel.server.g
    public void a(Map<Integer, IWsApp> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        JSONArray r0 = new JSONArray();
        monitor-enter(WsChannelService.class);
        Iterator r9 = r8.entrySet().iterator();     // Catch: Throwable -> L23
    L9:
        if (r9.hasNext() == false) goto L17;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L23
        goto L9
    L12:
        if (a((IWsApp) ZeusTransformUtils.preCheckCast(r2.getValue(), IWsApp.class, "com.obric.memorydata.plugin")) == false) goto L9;
        r0.put(((IWsApp) ZeusTransformUtils.preCheckCast(r2.getValue(), IWsApp.class, "com.obric.memorydata.plugin")).toJson());     // Catch: Exception -> L15 Throwable -> L23
    L17:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L23
        Logger.d(f2199a, "save to sp : " + r0.toString());     // Catch: Exception -> L20
        com.bytedance.common.wschannel.l.a(this.f2200b).a(r0.toString());     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L23:
        th = move-exception;
        throw th;
    }
}
