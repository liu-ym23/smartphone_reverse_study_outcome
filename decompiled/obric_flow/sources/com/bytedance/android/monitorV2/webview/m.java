package com.bytedance.android.monitorV2.webview;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f3803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f3804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet f3805c;
    public final ConcurrentHashMap d;
    public final ConcurrentHashMap e;
    public boolean f;

    public m() {
        this.f3803a = new HashMap();
        this.f3804b = new HashMap();
        this.f3805c = new HashSet();
        new Handler(Looper.getMainLooper());
        this.d = new ConcurrentHashMap(new HashMap());
        this.e = new ConcurrentHashMap(new WeakHashMap());
    }

    public static b a(b r10) {
        b r5 = new b();
        String r11 = r10.d;
        r10.d = r11;
        r5.f3751i = null;
        r5.f3749c = r10.f3749c;
        r5.f3748b = r10.f3748b;
        r5.f3747a = r10.f3747a;
        r5.d = r11;
        r5.f = r10.f;
        if (TextUtils.isEmpty(r10.f3750h) == false) goto L5;
        String r12 = "SlardarHybrid('config',{sendCommonParams:{},monitors:{StaticErrorMonitor:{ignore:[]},StaticPerformanceMonitor:{slowSession:8000,sampleRate:0.1},FPSMonitor:{interval:3000},MemoryMonitor:{interval:3000},PerformanceMonitor:{interval:100,checkPoint:['DOMContentLoaded','load']}}});";
    L6:
        r5.f3750h = r12;
        r5.g = r10.g;
        r5.e = r10.e;
        r5.f3752j = r10.f3752j;
        if (TextUtils.isEmpty("") == true) goto L30;
        JSONObject r13 = qo.a.c("");
        if (r13.opt("webview_classes") != null) goto L11;
        String[] r14 = r5.f3747a;
    L21:
        r5.f3747a = r14;
        if (r13.opt("webview_is_need_monitor") != null) goto L24;
        boolean r15 = r5.f3749c;
    L25:
        r5.f3749c = r15;
        if (TextUtils.isEmpty("") == false) goto L28;
        String r16 = r5.f3750h;
    L29:
        r5.f3750h = r16;
        goto L30
    L28:
        JSONObject r17 = qo.a.c("");
        JSONObject r18 = r17.optJSONObject("apmReportConfig");
        JSONObject r19 = r17.optJSONObject("performanceReportConfig");
        JSONObject r20 = r17.optJSONObject("errorMsgReportConfig");
        JSONObject r21 = r17.optJSONObject("resourceTimingReportConfig");
        JSONObject r22 = r17.optJSONObject("commonReportConfig");
        JSONObject r23 = new JSONObject();
        JSONObject r24 = new JSONObject();
        qo.a.j(r24, "monitors", r23);
        qo.a.j(r22, "sendCommonParams", r23);
        td.b.e(r24, r18);
        td.b.e(r24, r19);
        td.b.e(r24, r20);
        td.b.e(r24, r21);
        r16 = com.lynx.tasm.utils.g.d("SlardarHybrid('config', ", r23.toString(), ")");
        goto L29
    L24:
        r15 = qo.a.c("").optBoolean("webview_is_need_monitor", false);
        goto L25
    L11:
        String[] r25 = new String[0];
        if (TextUtils.isEmpty("") == true) goto L16;
        JSONArray r26 = qo.a.c("").optJSONArray("webview_classes");
        if (r26 == null) goto L16;
        r25 = new String[r26.length()];
        int r27 = r26.length();
        int r28 = 0;
    L18:
        if (r28 >= r27) goto L16;
        r25[r28] = r26.getString(r28);     // Catch: JSONException -> L31
    L20:
        r28 = r28 + 1;
    L16:
        r14 = r25;
    L30:
        return r5;
    L5:
        r12 = r10.f3750h;
        goto L6
    }

    public static String b(WebView r5) {
        if (r5 != null) goto L6;
        return "";
    L6:
        return r5.hashCode() + "";
    }

    public final l c(WebView r10) {
        if (r10 == null) goto L5;
        String r5 = b(r10);
        String r11 = r10.getClass().getName();
        b r12 = (b) this.f3804b.get(r5);
        if (r12 != null) goto L9;
        HashMap r13 = this.f3803a;
        b r14 = (b) r13.get(r11);
        if (r14 != null) goto L13;
        HashSet r15 = this.f3805c;
        if (r15.contains(r11) == true) goto L17;
        Iterator r16 = new HashSet(r13.keySet()).iterator();
    L20:
        if (r16.hasNext() == false) goto L40;
        String r17 = (String) r16.next();
        Class<?> r18 = Class.forName(r11);     // Catch: Throwable -> L24
    L42:
        Class<?> r19 = Class.forName(r17);     // Catch: Throwable -> L28
    L30:
        if (r18 == null) goto L34;
        if (r19 == null) goto L34;
        boolean r20 = r19.isAssignableFrom(r18);
    L35:
        if (r20 == false) goto L20;
        b r21 = (b) r13.get(r17);
        if (r21 == null) goto L20;
        r13.put(r11, r21);
        return new l(com.lynx.tasm.utils.k.j(r11, " isAssignedFrom:", r17), r21);
    L34:
        r20 = false;
    L28:
        th = move-exception;
        mn.h.g("default_handle", th);
        r19 = null;
    L24:
        th = move-exception;
        mn.h.g("default_handle", th);
        r18 = null;
        goto L42
    L40:
        r15.add(r11);
        return new l("objects classes superclass all miss", null);
    L17:
        return new l("webViewClazz in mWebViewMissClasses", null);
    L13:
        return new l("mWebViewClasses:".concat(r11), r14);
    L9:
        return new l(com.lynx.tasm.utils.b.j("mWebViewObjs:", r5, " viewClass:", r11), r12);
    L5:
        return new l("view is null", null);
    }

    public final i d(WebView r5) {
        String r10 = b(r5);
        ConcurrentHashMap r11 = this.d;
        i r12 = (i) r11.get(r10);
        if (r12 != null) goto L8;
        i r13 = new i(new WeakReference(r5), this);
        i r14 = (i) r11.putIfAbsent(r10, r13);
        if (r14 != null) goto L7;
        return r13;
    L7:
        return r14;
    L8:
        return r12;
    }

    public final boolean e(WebView r5) {
        b r10 = c(r5).f3802b;     // Catch: Exception -> L6
        if (r10 == null) goto L8;
        boolean r11 = r10.f3749c;     // Catch: Exception -> L6
    L11:
        if (this.f == r11) goto L13;
        d5.b.f("WebViewMonitorHelperImp", "isNeedMonitor: " + r11);
        this.f = r11;
    L13:
        return r11;
    L8:
        r11 = true;
    L6:
        e = move-exception;
        mn.h.g("default_handle", e);
        r11 = false;
        goto L11
    }

    public final boolean f(WebView r5) {
        Intrinsics.checkNotNullParameter(r5, "webView");
        String r10 = b(r5);
        ConcurrentHashMap r11 = this.e;
        if (r11.containsKey(r10) == true) goto L5;
        r11.put(r10, Boolean.valueOf(com.bytedance.android.monitorV2.webview.ttweb.a.b(r5)));
    L5:
        Boolean r12 = (Boolean) r11.get(r10);
        if (r12 != null) goto L10;
        return false;
    L10:
        return r12.booleanValue();
    }
}
