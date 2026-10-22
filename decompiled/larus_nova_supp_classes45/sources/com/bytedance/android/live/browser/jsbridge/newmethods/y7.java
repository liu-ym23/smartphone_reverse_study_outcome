package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "monitorLynx")
public final class y7 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {

    public static class a extends my2.a {
        public static a a;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.newmethods.y7$a$a, reason: collision with other inner class name */
        public class C0118a extends sy2.c {
            public C0118a() {
            }
        }

        public a() {
            if (sy2.e.c == null) goto L5;
        L14:
            sy2.e r0 = sy2.e.c;
            r0.a = "";
            HashMap r1 = (HashMap) sy2.e.b;
            r1.clear();
            r1.put("pv", String.format("tt%s_webview_timing_monitor_pv_service", new Object[]{r0.a}));
            r1.put("overview", String.format("tt%s_webview_timing_monitor_overview_service", new Object[]{r0.a}));
            r1.put("performance", String.format("tt%s_webview_timing_monitor_performance_service", new Object[]{r0.a}));
            r1.put("resource", String.format("tt%s_webview_timing_monitor_resource_service", new Object[]{r0.a}));
            r1.put("error", String.format("tt%s_webview_timing_monitor_error_service", new Object[]{r0.a}));
            r1.put("diff", String.format("tt%s_webview_timing_monitor_diff_service", new Object[]{r0.a}));
            r1.put("custom", String.format("tt%s_webview_timing_monitor_custom_service", new Object[]{r0.a}));
            r1.put("newcustom", String.format("bd%s_hybrid_monitor_custom_service", new Object[]{r0.a}));
            new C0118a();
            String.valueOf(jc1.k.f(IMiddleWareHostContext.class).appId());
            return;
        L5:
            monitor-enter(sy2.e.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (sy2.e.c != null) goto L9;
            sy2.e.c = new sy2.e();     // Catch: Throwable -> L11
        L9:
            monitor-exit(sy2.e.class);     // Catch: Throwable -> L11
            goto L14
        }
    }

    public y7() {
    }

    public final Object invoke(Object r3, CallContext r4) throws Exception {
        JSONObject r5 = (JSONObject) r3;
        String r6 = r5.optString(LiveSlardarConstants.EXTRA_KEY_URL);
        r5.optJSONObject("metrics");
        JSONObject r7 = r5.optJSONObject("extra");
        if (r7 == null) goto L5;
        r7.optString("event_name");
    L5:
        sy2.b r8 = sy2.d.a();
        if (a.a == null) goto L8;
    L17:
        r8.getClass();
        sy2.d.a().getClass();
        if (r6 != null) goto L20;
    L26:
        return null;
    L20:
        if (r6.length() == 0) goto L26;
        URL r0 = new URL(r6);     // Catch: Exception -> L24
        r0.getHost();     // Catch: Exception -> L24
        r0.getPath();     // Catch: Exception -> L24
        throw null;
    L24:
        new String[]{"", ""};
        throw null;
    L8:
        monitor-enter(a.class);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (a.a != null) goto L12;
        a.a = new a();     // Catch: Throwable -> L14
    L12:
        monitor-exit(a.class);     // Catch: Throwable -> L14
        goto L17
    }
}
