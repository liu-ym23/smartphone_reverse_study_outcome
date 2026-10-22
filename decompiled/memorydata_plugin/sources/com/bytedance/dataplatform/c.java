package com.bytedance.dataplatform;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.rpc.internal.RpcUtils;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2254a = false;
    private static Map<String, String> k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2255b;
    private final Context c;
    private JSONObject d;
    private Map<String, Integer> e;
    private final Map<String, Object> f;
    private j g;
    private i h;
    private f i;
    private Future j;
    private final Map<String, Runnable> l;

    static {
        k = new ConcurrentHashMap();
    }

    c(Application r3, String r4, boolean r5, j r6, h r7, i r8, Map<String, String> r9, Set<String> r10) {
        Application r11 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        j r12 = (j) ZeusTransformUtils.wrapperContextForParams(r6, j.class, "com.obric.memorydata.plugin");
        h r13 = (h) ZeusTransformUtils.wrapperContextForParams(r7, h.class, "com.obric.memorydata.plugin");
        i r14 = (i) ZeusTransformUtils.wrapperContextForParams(r8, i.class, "com.obric.memorydata.plugin");
        Map<String, String> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Set r16 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        this.f = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.f2255b = r4;
        k = r15;
        Context r17 = ZeusTransformUtils.wrapperContext(r11, "com.obric.memorydata.plugin");
        this.c = r17;
        this.d = a.a(r17, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_CACHE");
        this.e = a.a(r17, "CLIENT_EXPERIMENT_CACHE_TAG");
        this.i = new f(r11, r13, r16);
        b.f2250b.a(this.i);
        this.g = r12;
        this.h = r14;
        if (r5 == false) goto L6;
        this.j = l.a(new AnonymousClass1(this), 2000, ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS);
        return;
    }

    private void a() {
        StringBuilder r4 = new StringBuilder(this.f2255b);     // Catch: Exception -> L28
        if (k.isEmpty() == false) goto L7;
    L18:
        JSONObject r3 = new JSONObject(this.h.request(r4.toString()));     // Catch: Exception -> L28
        if (r3.has("code") == true) goto L21;
        return;
    L21:
        if (r3.has("data") == true) goto L24;
        return;
    L24:
        if (r3.optInt("code", -1) == 0) goto L26;
        return;
    L26:
        a(r3.getJSONObject("data"));     // Catch: Exception -> L28
        return;
    L7:
        if (this.f2255b.indexOf(63) >= 0) goto L9;
        r4.append("?");     // Catch: Exception -> L28
    L10:
        boolean r5 = true;
        Iterator<Map.Entry<String, String>> r7 = k.entrySet().iterator();     // Catch: Exception -> L28
    L12:
        if (r7.hasNext() == false) goto L18;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L28
        if (r5 == false) goto L16;
        r5 = false;
    L17:
        r4.append(URLEncoder.encode((String) ZeusTransformUtils.preCheckCast(r8.getKey(), String.class, "com.obric.memorydata.plugin"), RpcUtils.CHARSET_UTF8)).append("=").append(URLEncoder.encode((String) ZeusTransformUtils.preCheckCast(r8.getValue(), String.class, "com.obric.memorydata.plugin"), RpcUtils.CHARSET_UTF8));     // Catch: Exception -> L28
        goto L12
    L16:
        r4.append("&");     // Catch: Exception -> L28
        goto L17
    L9:
        r4.append("&");     // Catch: Exception -> L28
    }

    static /* synthetic */ void a(c r0) {
        r0.a();
    }

    private void a(JSONObject r11) {
        JSONObject r0 = new JSONObject();
        HashMap r1 = new HashMap();
        HashMap r2 = new HashMap();
        Iterator<String> r3 = r11.keys();
    L4:
        if (r3.hasNext() == false) goto L31;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        JSONObject r5 = r11.getJSONObject(r4);     // Catch: JSONException -> L35
        if (f2254a == false) goto L12;
        Object r6 = r5.opt("val");     // Catch: JSONException -> L35
        if (r6 == null) goto L4;
    L13:
        r0.put(r4, r6);     // Catch: JSONException -> L35
        if (f2254a == true) goto L17;
        String r7 = r5.getString("vid");     // Catch: JSONException -> L35
    L20:
        if (TextUtils.isEmpty(r7) == true) goto L4;
        r1.put(r4, r7);     // Catch: JSONException -> L35
        if (f2254a == false) goto L26;
        long r8 = r5.optLong("et", 0);     // Catch: JSONException -> L35
    L28:
        if (r8 <= 0) goto L4;
        r2.put(r7, Long.valueOf(r8));     // Catch: JSONException -> L35
        goto L4
    L26:
        r8 = r5.getLong("et");     // Catch: JSONException -> L35
        goto L28
    L17:
        r7 = r5.optString("vid", null);     // Catch: JSONException -> L35
        goto L20
    L12:
        r6 = r5.get("val");     // Catch: JSONException -> L35
        goto L13
    L31:
        this.f.clear();
        this.d = r0;
        a.a(this.c, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_CACHE", r0);
        this.i.a(r1, r2);
        g r10 = d.a();
        if (r10 == null) goto L51;
        r10.onLibraExperimentChanged(r11);
        return;
    }

    public void a(String r1) {
        this.i.a(r1);
    }

    synchronized void a(Map<String, String> r5) {
        monitor-enter(this);
        Map<? extends String, ? extends String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Future r0 = this.j;     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        r0.cancel(true);     // Catch: Throwable -> L11
    L6:
        if (r6 == null) goto L8;
        k.putAll(r6);     // Catch: Throwable -> L11
    L8:
        this.j = l.a(new AnonymousClass2(this), 0, ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
