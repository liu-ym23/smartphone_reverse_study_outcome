package com.bytedance.ies.web.jsbridge2;

import ai.j0;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f6310k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashSet f6311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f6312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6313c;
    public volatile boolean d;
    public a e;
    public c f;
    public final HashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CopyOnWriteArrayList f6314h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f6315i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SSWebView f6316j;

    static {
        f6310k = Pattern.compile("^[0-9a-zA-Z.]+$");
    }

    public u() {
        this.f6312b = new Handler(Looper.getMainLooper());
        this.d = false;
        this.g = new HashMap();
    }

    public static l a(u r12, JSONObject r13) {
        if (r12.d == false) goto L5;
        return null;
    L5:
        String r5 = r13.optString("__callback_id");
        String r10 = r13.optString("func");
        String r11 = r12.b();
        if (r11 != null) goto L13;
        r12.f(null, null, 3, "url_empty", null);
        return null;
    L13:
        String r14 = r13.getString("__msg_type");     // Catch: JSONException -> L11
        String r15 = r13.getString(LynxResourceModule.PARAMS_KEY);     // Catch: JSONException -> L11
        String r16 = r13.getString("JSSDK");     // Catch: JSONException -> L11
        String r17 = r13.optString("namespace");     // Catch: JSONException -> L11
        String r18 = r13.optString("__iframe_url");     // Catch: JSONException -> L11
        Boolean r19 = Boolean.valueOf(r13.optBoolean("shouldHook", false));     // Catch: JSONException -> L11
        k r20 = new k();     // Catch: JSONException -> L11
        r20.f6284a = r16;     // Catch: JSONException -> L11
        r20.f6285b = r14;     // Catch: JSONException -> L11
        r20.f6286c = r10;     // Catch: JSONException -> L11
        r20.d = r15;     // Catch: JSONException -> L11
        r20.e = r5;     // Catch: JSONException -> L11
        r20.f = r17;     // Catch: JSONException -> L11
        r20.g = r18;     // Catch: JSONException -> L11
        r20.f6288i = r19;     // Catch: JSONException -> L11
        return new l(r20);
    L11:
        r12.f(r11, r10, 3, "params_invalid", null);
        return new l(r5, 0);
    }

    public static void d(u r10, l r11) {
        r10.getClass();
        o.f.a();
        if (r10.d == true) goto L60;
        String r5 = (String) r11.f6294j;
        if (r5 != null) goto L8;
    L11:
        String r12 = r10.b();
    L12:
        t r13 = new t();
        if (r12 != null) goto L15;
        String r14 = "null";
    L16:
        r13.a("url", r14);
        r13.b("label_call_origin_url", (CopyOnWriteArrayList) r11.f6296l);
        if (r12 == null) goto L60;
        String r15 = (String) r11.f6292h;
        if (TextUtils.equals(r15, r10.f6313c) == false) goto L22;
    L25:
        c r16 = r10.f;
    L26:
        if (r16 != null) goto L28;
        new StringBuilder("Received call with unknown namespace, ").append(r11);
        t r17 = new t();
        r17.a("reason", "unknown_namespace");
        r17.b("label_abstract_bridge_reject", (CopyOnWriteArrayList) r11.f6296l);
        r10.f(r10.b(), r11.d, 2, "unknown_namespace", (CopyOnWriteArrayList) r11.f6296l);
        r10.c();
        r10.e(r.a(new JsBridgeException(-4, j0.q(new StringBuilder("Namespace "), (String) r11.f6292h, " unknown."))), r11);
        goto L60
    L28:
        zm.c r18 = new zm.c(4);
        r18.f23470b = r12;
        a r19 = r10.e;
        if (r19.f6264a == true) goto L64;
        monitor-enter(r19);
    L34:
        th = move-exception;
        throw th;
    L32:
        if (r19.f6264a == true) goto L36;
        r19.f6264a = true;     // Catch: Throwable -> L34
    L36:
        monitor-exit(r19);     // Catch: Throwable -> L34
    L64:
    L45:
        e = move-exception;
        new StringBuilder("call finished with error, ").append(r11);
        r10.e(r.a(e), r11);
        goto L60
    L41:
        if (r16.b(r11, r18) != null) goto L54;
        new StringBuilder("Received call but not registered, ").append(r11);     // Catch: Exception -> L45
        t r20 = new t();     // Catch: Exception -> L45
        if (r10.d == false) goto L47;
        String r21 = "not_registered_1_release";
    L48:
        r20.a("reason", r21);     // Catch: Exception -> L45
        r20.b("label_abstract_bridge_reject", (CopyOnWriteArrayList) r11.f6296l);     // Catch: Exception -> L45
        String r22 = r10.b();     // Catch: Exception -> L45
        String r23 = r11.d;     // Catch: Exception -> L45
        if (r10.d == false) goto L52;
        String r24 = "not_registered_1_release";
    L53:
        r10.f(r22, r23, 2, r24, (CopyOnWriteArrayList) r11.f6296l);     // Catch: Exception -> L45
        r10.c();     // Catch: Exception -> L45
        r10.e(r.a(new JsBridgeException(-2, "Function " + r11.d + " is not registered.")), r11);     // Catch: Exception -> L45
        goto L60
    L52:
        r24 = "not_registered_1";
        goto L53
    L47:
        r21 = "not_registered_1";
        goto L48
    L54:
        r10.b();     // Catch: Exception -> L45
        String r25 = r11.d;     // Catch: Exception -> L45
        CopyOnWriteArrayList r26 = (CopyOnWriteArrayList) r11.f6296l;     // Catch: Exception -> L45
        Iterator r27 = r10.f6311a.iterator();     // Catch: Exception -> L45
    L56:
        if (r27.hasNext() == false) goto L60;
        i r28 = (i) r27.next();     // Catch: Exception -> L45
        m r29 = o.d;     // Catch: Exception -> L45
        r28.c(r25, new z(r26));     // Catch: Exception -> L45
        goto L56
    L22:
        if (TextUtils.isEmpty(r15) == true) goto L25;
        r16 = (c) r10.g.get(r15);
        goto L26
    L15:
        r14 = r12;
        goto L16
    L8:
        if (r5.isEmpty() == true) goto L11;
        r12 = (String) r11.f6294j;
    L60:
        TextUtils.isEmpty((String) r11.f6292h);
    }

    public final String b() {
        SSWebView r5 = this.f6316j;
        if (r5 == null) goto L10;
        String r10 = r5.getSafeUrl();
        if (TextUtils.isEmpty(r10) == true) goto L7;
        return r10;
    L7:
        return this.f6316j.getUrl();
    L10:
        return r5.getUrl();
    }

    public final void c() {
        Iterator r5 = this.f6311a.iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        ((i) r5.next()).getClass();     // Catch: Throwable -> L8 AbstractMethodError -> L10
    L10:
        e = move-exception;
        new StringBuilder("onRejected AbstractMethodError").append(e.getMessage());
    L8:
        th = move-exception;
        new StringBuilder("onRejected error").append(th.getMessage());
        goto L4
    }

    public final void e(String r10, l r11) {
        if (this.d == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r11.f) == false) goto L9;
        td.d.b("By passing js callback due to empty callback: ", r10);
        return;
    L9:
        Boolean r5 = (Boolean) r11.f6295k;
        if (r5 != null) goto L12;
    L15:
        new t().b("label_pre_callback_origin_url", (CopyOnWriteArrayList) r11.f6296l);
        if (r10.startsWith("{") == true) goto L18;
    L19:
        new IllegalArgumentException("Illegal callback data: ".concat(r10));
    L21:
        if (f6310k.matcher(r11.f).matches() == false) goto L71;
        o.g.a();
        String r12 = androidx.constraintlayout.motion.widget.a.u(new StringBuilder("{\"__msg_type\":\"callback\",\"__callback_id\":\""), r11.f, "\",\"__params\":", r10, "}");
    L46:
        if (TextUtils.isEmpty((String) r11.f6293i) == true) goto L57;
        String r13 = (String) r11.f6293i;
        String r14 = j0.q(androidx.constraintlayout.motion.widget.a.y("javascript:(function(){   const iframe = document.querySelector(atob('", Base64.encodeToString(("iframe[src=\"" + r13 + "\"").getBytes(), 2), "'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(", r12, ", atob('"), Base64.encodeToString(r13.getBytes(), 2), "'));   }})()");
        if (this.d == false) goto L51;
    L67:
        new t().b("label_post_callback_origin_url", (CopyOnWriteArrayList) r11.f6296l);
        return;
    L51:
        if (TextUtils.isEmpty(r14) == true) goto L67;
        ab.b r15 = new ab.b(12, this, false, r14);
        if (Looper.myLooper() == Looper.getMainLooper()) goto L56;
        td.d.b("Received call on sub-thread, posting to main thread: ", r14);
        this.f6312b.post(r15);
        goto L67
    L56:
        r15.run();
        goto L67
    L57:
        String r16 = androidx.constraintlayout.motion.widget.a.u(new StringBuilder("javascript:"), this.f6315i, "._handleMessageFromToutiao(", r12, ")");
        if (this.d == true) goto L67;
        if (TextUtils.isEmpty(r16) == true) goto L67;
        ab.b r17 = new ab.b(12, this, false, r16);
        if (Looper.myLooper() == Looper.getMainLooper()) goto L66;
        td.d.b("Received call on sub-thread, posting to main thread: ", r16);
        this.f6312b.post(r17);
        goto L67
    L66:
        r17.run();
        goto L67
    L71:
        JSONObject r18 = new JSONObject(r10);     // Catch: Exception -> L25
    L26:
        ConcurrentHashMap r19 = new ConcurrentHashMap();
        if (TextUtils.isEmpty("__msg_type") == true) goto L29;
        r19.put("__msg_type", "callback");
    L29:
        String r20 = r11.f;
        if (TextUtils.isEmpty("__callback_id") == true) goto L35;
        if (r20 == null) goto L35;
        r19.put("__callback_id", r20);
    L35:
        if (TextUtils.isEmpty("__params") == true) goto L37;
        r19.put("__params", r18);
    L37:
        JSONObject r21 = new JSONObject();
        Iterator r22 = r19.entrySet().iterator();     // Catch: JSONException -> L44
    L40:
        if (r22.hasNext() == false) goto L42;
        Map.Entry r23 = (Map.Entry) r22.next();     // Catch: JSONException -> L44
        r21.put((String) r23.getKey(), r23.getValue());     // Catch: JSONException -> L44
        goto L40
    L42:
        r12 = r21.toString();     // Catch: JSONException -> L44
    L44:
        r12 = "";
    L25:
        r18 = new JSONObject();
        goto L26
    L18:
        if (r10.endsWith("}") == true) goto L21;
    L12:
        if (r5.booleanValue() == false) goto L15;
        r11.toString();
    }

    public final void f(String r10, String r11, int r12, String r13, CopyOnWriteArrayList r14) {
        Iterator r15 = this.f6311a.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        i r5 = (i) r15.next();
        m r16 = o.d;
        r5.d(r10, r11, r12, r13, new z(r14));
        goto L4
    }

    @JavascriptInterface
    public void invokeMethod(String r5) {
        if (this.d == false) goto L5;
        return;
    L5:
        t r10 = new t();
        r10.f6308b = r10.f.format(new Date());
        r10.d = SystemClock.elapsedRealtime();
        r10.f6309c = System.currentTimeMillis();
        r10.f6307a = "label_pre_call_origin_url";
        TimeLineEvent r11 = new TimeLineEvent(r10, null);
        td.d.b("Received call: ", r5);
        this.f6312b.post(new b(this, r5, r11, 0));
    }
}
