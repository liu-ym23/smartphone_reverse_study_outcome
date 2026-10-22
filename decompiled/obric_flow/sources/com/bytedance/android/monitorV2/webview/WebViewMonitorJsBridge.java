package com.bytedance.android.monitorV2.webview;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
class WebViewMonitorJsBridge {
    private static final String TAG = "WebViewMonitorJsBridge";
    private Handler mainHandler;
    private i webViewDataManager;

    public WebViewMonitorJsBridge(i r5) {
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.webViewDataManager = r5;
    }

    public static /* synthetic */ void a(c r5, String r10, JSONObject r11) {
        lambda$config$0(r5, r10, r11);
    }

    public static /* synthetic */ i access$000(WebViewMonitorJsBridge r5) {
        return r5.webViewDataManager;
    }

    public static /* synthetic */ c access$100(WebViewMonitorJsBridge r5) {
        return r5.getNavigationManager();
    }

    public static /* synthetic */ Handler access$200(WebViewMonitorJsBridge r5) {
        return r5.mainHandler;
    }

    private c getNavigationManager() {
        return this.webViewDataManager.f;
    }

    private static void lambda$config$0(c r5, String r10, JSONObject r11) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.d.isEmpty() == false) goto L6;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r5.d = r10;
    L6:
        JSONObject r12 = oo.j.f(r11);
        r5.e = qo.a.q(r5.e, r12);
    }

    @JavascriptInterface
    public void batch(String r5) {
        d5.b.f(TAG, "batch: " + r5);
        this.mainHandler.post(new p(this, r5, 0));
    }

    @JavascriptInterface
    public void config(String r5) {
        d5.b.f(TAG, "config: " + r5);
        final JSONObject r10 = qo.a.c(r5);
        final String r11 = r10.optString("bid", "");
        final c r12 = getNavigationManager();
        this.mainHandler.post(new n(r12, r11, r10));
        if (r12 != null) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L9;
        String r13 = com.bytedance.android.monitorV2.exception.b.f3568a;
        com.bytedance.android.monitorV2.exception.b.a(r12.f3755b, r11);
        return;
    }

    @JavascriptInterface
    public void cover(String r5, String r10) {
        d5.b.f(TAG, "cover: eventType: " + r10);
        this.mainHandler.post(new o(this, r5, r10, 0));
    }

    @JavascriptInterface
    public void customReport(String r5, String r10, String r11, boolean r12, String r13, String r14, String r15) {
        d5.b.f(TAG, "customReport: event: " + r5);
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r13) == false) goto L10;
        if (r12 == false) goto L9;
        int r16 = 2;
    L16:
        JSONObject r17 = qo.a.c(r11);     // Catch: Throwable -> L13
        JSONObject r18 = qo.a.c(r10);     // Catch: Throwable -> L13
        JSONObject r19 = qo.a.c(r14);     // Catch: Throwable -> L13
        JSONObject r20 = qo.a.c(r15);     // Catch: Throwable -> L13
        com.bytedance.ies.web.jsbridge2.l r21 = new com.bytedance.ies.web.jsbridge2.l(r5, 1);     // Catch: Throwable -> L13
        r21.f6292h = r17;     // Catch: Throwable -> L13
        r21.f6293i = r18;     // Catch: Throwable -> L13
        r21.f6294j = r19;     // Catch: Throwable -> L13
        r21.f6295k = r20;     // Catch: Throwable -> L13
        r21.b(r16);     // Catch: Throwable -> L13
        this.mainHandler.post(new p(this, new com.bytedance.android.monitorV2.event.b(r21.a()), 4));     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        mn.h.g("default_handle", th);
        return;
    L9:
        r16 = 0;
        goto L16
    L10:
        r16 = Integer.parseInt(r13);
        goto L16
    }

    @JavascriptInterface
    public String getInfo() {
        d5.b.f(TAG, "getInfo");
        JSONObject r5 = new JSONObject();
        Lazy r10 = com.bytedance.android.monitorV2.constant.a.f3521a;
        Intrinsics.checkNotNullParameter("monitor_validation_switch", STGroup.DICT_KEY);
        Application r11 = com.bytedance.android.monitorV2.constant.a.f3523c;
        boolean r12 = false;
        if (r11 != null) goto L6;
    L11:
        qo.a.j(Boolean.valueOf(r12), "need_report", r5);
        qo.a.t(WsConstants.KEY_SDK_VERSION, "9.0.0", r5);
        return r5.toString();
    L6:
        if (com.bytedance.android.monitorV2.constant.a.f3522b != null) goto L8;
        com.bytedance.android.monitorV2.constant.a.f3522b = r11.getSharedPreferences("monitor_sdk", 4);
    L8:
        SharedPreferences r13 = com.bytedance.android.monitorV2.constant.a.f3522b;
        if (r13 == null) goto L11;
        r12 = r13.getBoolean("monitor_validation_switch", false);
        goto L11
    }

    @JavascriptInterface
    public String getVersion() {
        return "9.0.0";
    }

    @JavascriptInterface
    public void injectJS() {
        d5.b.f(TAG, "inject js");
        this.mainHandler.post(new r(this, 0));
    }

    @JavascriptInterface
    public void reportDirectly(String r5, String r10) {
        d5.b.f(TAG, "reportDirectly: eventType: " + r10);
        this.mainHandler.post(new o(this, r5, r10, 1));
    }

    @JavascriptInterface
    public void reportPageLatestData(String r5) {
        d5.b.f(TAG, "report latest page data");
        Handler r10 = com.bytedance.android.monitorV2.executor.b.f3573a;
        p r11 = new p(this, r5, 2);
        Intrinsics.checkNotNullParameter(r11, "runnable");
        com.bytedance.android.monitorV2.executor.b.a().execute(new c1.a(r11, 2));
    }

    @JavascriptInterface
    public void reportPiaInfo(String r5) {
        this.mainHandler.post(new p(this, r5, 3));
    }

    @JavascriptInterface
    public void reportVerifiedData(String r5) {
        d5.b.f(TAG, "reportVerifiedData" + r5);
        Lazy r10 = com.bytedance.android.monitorV2.constant.a.f3521a;
        Intrinsics.checkNotNullParameter("monitor_validation_switch", STGroup.DICT_KEY);
        Application r11 = com.bytedance.android.monitorV2.constant.a.f3523c;
        boolean r12 = false;
        if (r11 != null) goto L6;
    L11:
        if (r12 == false) goto L18;
        JSONObject r13 = qo.a.c(r5);
        a5.c r14 = com.bytedance.android.monitorV2.m.f3713a;
        Intrinsics.checkNotNullParameter(r13, "jsonObject");
        a5.c r15 = com.bytedance.android.monitorV2.m.f3713a;
        if (r15 == null) goto L15;
        String r16 = r15.e;
    L16:
        qo.a.t(WsConstants.KEY_DEVICE_ID, r16, r13);
        qo.a.k("timestamp", System.currentTimeMillis(), r13);
        com.bytedance.android.monitorV2.m.c(r13.toString());
        return;
    L15:
        r16 = null;
        goto L16
    L18:
        return;
    L6:
        if (com.bytedance.android.monitorV2.constant.a.f3522b != null) goto L8;
        com.bytedance.android.monitorV2.constant.a.f3522b = r11.getSharedPreferences("monitor_sdk", 4);
    L8:
        SharedPreferences r17 = com.bytedance.android.monitorV2.constant.a.f3522b;
        if (r17 == null) goto L11;
        r12 = r17.getBoolean("monitor_validation_switch", false);
        goto L11
    }

    @JavascriptInterface
    public void sendInitTimeInfo(String r5) {
        d5.b.f(TAG, "sendInitTimeInfo: " + r5);
        this.mainHandler.post(new p(this, r5, 1));
    }

    @JavascriptInterface
    public void terminatedPreCollect(String r5) {
        d5.b.f(TAG, "terminatedPreCollect: " + r5);
        this.mainHandler.post(new r(this, 1));
    }
}
