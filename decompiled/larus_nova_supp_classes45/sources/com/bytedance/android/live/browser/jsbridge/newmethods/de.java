package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.webkit.WebView;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "webviewNavigation")
public final class de extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
    public final WebView a;

    public static final class a {
    }

    static {
    }

    public de(WebView r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5, CallContext r6) {
        JSONObject r7 = (JSONObject) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        String r8 = r7.optString("type");
        int r9 = 0;
        if (r8 == null) goto L25;
        int r1 = r8.hashCode();
        if (r1 == (-892481550)) goto L23;
        if (r1 == (-677145915)) goto L18;
        if (r1 != 3015911) goto L25;
        if (r8.equals(NewBroadcastMonitor.CAPTURE.BACK) == false) goto L25;
        WebView r11 = this.a;
        if (r11 == null) goto L24;
        r11.goBack();
    L24:
        int r12 = 1;
    L26:
        JSONObject r2 = new JSONObject();
        r2.put("code", r12);
        JSONObject r13 = new JSONObject();
        WebView r3 = this.a;
        if (r3 != null) goto L29;
    L31:
        int r4 = 0;
    L32:
        r13.put("canGoBack", r4);
        WebView r14 = this.a;
        if (r14 != null) goto L35;
    L37:
        r13.put("canGoForward", r9);
        r2.put("data", r13);
        return r2;
    L35:
        if (r14.canGoForward() != true) goto L37;
        r9 = 1;
        goto L37
    L29:
        if (r3.canGoBack() != true) goto L31;
        r4 = 1;
        goto L32
    L18:
        if (r8.equals("forward") == false) goto L25;
        WebView r15 = this.a;
        if (r15 == null) goto L24;
        r15.goForward();
        goto L24
    L23:
        if (r8.equals("status") == true) goto L24;
    L25:
        r12 = 0;
        goto L26
    }
}
