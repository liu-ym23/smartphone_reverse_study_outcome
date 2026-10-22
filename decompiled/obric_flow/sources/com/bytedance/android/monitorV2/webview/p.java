package com.bytedance.android.monitorV2.webview;

import com.bytedance.lynx.service.monitor.LynxMonitorService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WebViewMonitorJsBridge f3814c;

    public /* synthetic */ p(WebViewMonitorJsBridge r5, Object r10, int r11) {
        this.f3812a = r11;
        this.f3814c = r5;
        this.f3813b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f3812a) {
            case 0: goto L38;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L42;
            default: goto L4;
        };
    L4:
        c r5 = WebViewMonitorJsBridge.access$100(this.f3814c);
        if (r5 == null) goto L45;
        com.bytedance.android.monitorV2.event.b r10 = (com.bytedance.android.monitorV2.event.b) this.f3813b;
        Intrinsics.checkNotNullParameter(r10, "customEvent");
        f r11 = r5.f3760k;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "event");
        r11.f3775b.c(r11.f3776c, r10, true);
        sj.g.l();
        return;
    L45:
        return;
    L13:
        JSONObject r12 = qo.a.c((String) this.f3813b);
        JSONObject r13 = qo.a.c(r12.optString("performance", ""));
        JSONObject r14 = qo.a.c(r12.optString("resource", ""));
        WebViewMonitorJsBridge.access$200(this.f3814c).post(new q(this, r12.optString("url", ""), r13, r14, qo.a.c(r12.optString("cacheData", ""))));
        return;
    L15:
        c r15 = WebViewMonitorJsBridge.access$100(this.f3814c);
        if (r15 == null) goto L47;
        String r16 = (String) this.f3813b;
        m5.d r17 = r15.f3768t;
        if (r17.f19999a.f19993j == 0) goto L28;
        r17.f20006l = true;
        long r18 = Long.parseLong(r16);     // Catch: NumberFormatException -> L22
    L24:
        long r19 = r18 - r17.f19999a.f19993j;
        r17.f20005k = r19;
        if (r19 >= 0) goto L27;
        r17.f20005k = 0;
    L27:
        d5.b.c("WebPerfReportData", " updateMonitorInitTimeData : " + r17.f20005k);
    L22:
        e = move-exception;
        mn.h.g("default_handle", e);
        r18 = 0;
    L28:
        r15.g();
        return;
    L47:
        return;
    L38:
        JSONArray r20 = new JSONArray((String) this.f3813b);     // Catch: Exception -> L35
        int r21 = 0;
    L32:
        if (r21 >= r20.length()) goto L48;
        WebViewMonitorJsBridge.access$000(this.f3814c).d(r20.getJSONObject(r21));     // Catch: Exception -> L35
        r21 = r21 + 1;
        goto L32
    L48:
        return;
    L35:
        e = move-exception;
        e.printStackTrace();
        return;
    L42:
        JSONObject r22 = qo.a.c((String) this.f3813b);     // Catch: Throwable -> L10
        k.d.k(WebViewMonitorJsBridge.access$000(this.f3814c).a(), r22.optString("type", ""), r22.optJSONObject("category"), r22.optJSONObject(LynxMonitorService.KEY_METRICS));     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        mn.h.g("default_handle", th);
    }
}
