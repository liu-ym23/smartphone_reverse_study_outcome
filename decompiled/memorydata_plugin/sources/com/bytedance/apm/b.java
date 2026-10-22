package com.bytedance.apm;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.MonitorableInterceptor;
import com.bytedance.services.apm.api.IHttpService;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f1109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1110b;
    private static boolean c;
    private static boolean d;
    private static JSONObject e;
    private static com.bytedance.apm.core.b f;
    private static Map<String, String> g;
    private static IHttpService h;
    private static com.bytedance.services.apm.api.h i;
    private static long j;
    private static volatile int k;
    private static boolean l;
    private static long m;
    private static long n;
    private static String o;
    private static boolean p;
    private static boolean q;
    private static boolean r;
    private static long s;
    private static boolean t;
    private static boolean u;
    private static d v;
    private static boolean w;
    private static c x;
    private static com.bytedance.apm.core.d y;
    private static MonitorableInterceptor z;

    static {
        e = new JSONObject();
        f = new com.bytedance.apm.core.a();
        g = Collections.emptyMap();
        h = new DefaultHttpServiceImpl();
        j = -1;
        k = -1;
        l = false;
        s = 0;
        t = true;
        u = true;
        w = false;
        x = null;
        y = null;
    }

    public static com.bytedance.services.apm.api.c a(String r2, List<File> r3, Map<String, String> r4) {
        List<File> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        return h.uploadFiles(r2, r5, r6);
    }

    public static com.bytedance.services.apm.api.c a(String r2, Map<String, String> r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return h.doGet(r2, r4);
    }

    public static com.bytedance.services.apm.api.c a(String r2, byte[] r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        return h.doPost(r2, r3, r5);
    }

    public static com.bytedance.services.apm.api.g a(String r1, String r2, boolean r3) {
        return h.buildMultipartUpload(r1, r2, r3);
    }

    public static com.bytedance.services.apm.api.g a(String r2, String r3, boolean r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        return h.buildMultipartUpload(r2, r3, r4, r6);
    }

    public static String a(long r2) {
        long r3 = r2 - n;
        if (r3 >= 30000) goto L7;
        return "0 - 30s";
    L7:
        if (r3 >= 60000) goto L11;
        return "30s - 1min";
    L11:
        if (r3 >= 120000) goto L15;
        return "1min - 2min";
    L15:
        if (r3 >= 300000) goto L19;
        return "2min - 5min";
    L19:
        if (r3 >= 600000) goto L23;
        return "5min - 10min";
    L23:
        if (r3 >= 1800000) goto L27;
        return "10min - 30min";
    L27:
        if (r3 >= ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS) goto L30;
        return "30min - 1h";
    L30:
        return "1h - ";
    }

    public static void a(boolean r0) {
        f1110b = r0;
        ApmContext.setDebugMode(k());
    }

    public static boolean a() {
        return w;
    }

    public static boolean a(String r2, String r3) {
        if (e != null) goto L6;
        return false;
    L6:
        if (r2.equals("release_build") == false) goto L12;
        return false;
    L12:
        e.put(r2, r3);     // Catch: JSONException -> L11
        return true;
    L11:
        return false;
    }

    public static MonitorableInterceptor b() {
        return z;
    }

    public static void b(long r4) {
        if (r4 > 0) goto L5;
        return;
    L5:
        long r2 = m;
        if (r2 != 0) goto L8;
    L9:
        m = r4;
        return;
    L8:
        if (r4 < r2) goto L9;
    }

    public static void b(boolean r0) {
        c = r0;
    }

    public static boolean c() {
        return t;
    }

    public static c d() {
        return x;
    }

    public static String e() {
        if (TextUtils.isEmpty(o) == false) goto L6;
        o = com.bytedance.apm.util.a.a(Process.myPid());
    L6:
        return o;
    }

    public static boolean f() {
        boolean r1 = true;
        if (p == false) goto L6;
        return true;
    L6:
        if (f1109a == null) goto L8;
        String r0 = e();
        if (r0 != null) goto L12;
    L14:
        if (r0 != null) goto L16;
    L18:
        r1 = false;
    L19:
        p = r1;
    L21:
        return p;
    L16:
        if (r0.equals(f1109a.getPackageName()) == false) goto L18;
    L12:
        if (r0.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR) == false) goto L14;
        p = false;
        goto L21
    L8:
        return g();
    }

    public static boolean g() {
        if (p == false) goto L5;
        return true;
    L5:
        String r0 = e();
        if (r0 != null) goto L8;
    L11:
        return true;
    L8:
        if (r0.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR) == false) goto L11;
        return false;
    }

    public static Context getContext() {
        return f1109a;
    }

    public static boolean h() {
        return l;
    }

    public static long i() {
        if (j != (-1)) goto L6;
        j = System.currentTimeMillis();
    L6:
        return j;
    }

    public static int j() {
        return k;
    }

    public static boolean k() {
        if (f1110b == false) goto L5;
    L8:
        return true;
    L5:
        if (d == true) goto L8;
        return false;
    }

    public static boolean l() {
        return c;
    }

    public static com.bytedance.services.apm.api.h m() {
        return i;
    }

    public static boolean n() {
        JSONObject r0 = e;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.optString("channel") != null) goto L8;
        return false;
    L8:
        return e.optString("channel").contains("local");
    }

    public static synchronized d o() {
        monitor-enter(b.class);
        d r1 = v;     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Map<String, String> p() {
        monitor-enter(b.class);
        com.bytedance.apm.core.d r1 = y;     // Catch: Throwable -> L25
        if (r1 == null) goto L17;
        Map<String, String> r2 = r1.a();     // Catch: Throwable -> L25
        if (r2 == null) goto L17;
        if (r2.size() <= 0) goto L17;
        if (v.l() == null) goto L15;
        HashMap r3 = new HashMap(v.l());     // Catch: Throwable -> L25
        r3.putAll(r2);     // Catch: Throwable -> L25
        monitor-exit(b.class);
        return r3;
    L15:
        monitor-exit(b.class);
        return r2;
    L17:
        d r4 = v;     // Catch: Throwable -> L25
        if (r4 == null) goto L23;
        Map<String, String> r5 = r4.l();     // Catch: Throwable -> L25
        monitor-exit(b.class);
        return r5;
    L23:
        monitor-exit(b.class);
        return null;
    L25:
        th = move-exception;
        throw th;
    }

    public static synchronized Map<String, String> q() {
        monitor-enter(b.class);
        com.bytedance.apm.core.d r1 = y;     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        Map<String, String> r2 = r1.a();     // Catch: Throwable -> L16
        if (r2 == null) goto L13;
        if (r2.size() <= 0) goto L13;
        HashMap r3 = new HashMap(g);     // Catch: Throwable -> L16
        r3.putAll(r2);     // Catch: Throwable -> L16
        monitor-exit(b.class);
        return r3;
    L13:
        Map<String, String> r4 = g;     // Catch: Throwable -> L16
        monitor-exit(b.class);
        return r4;
    L16:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static JSONObject r() {
        return e;
    }

    public static JSONObject s() {
        return new JSONObject(String.valueOf(e));
    L5:
        return new JSONObject();
    }

    public static com.bytedance.apm.core.b t() {
        return f;
    }

    public static IHttpService u() {
        return h;
    }

    public static long v() {
        if (n != 0) goto L6;
        n = System.currentTimeMillis();
    L6:
        return n;
    }

    public static long w() {
        return m;
    }

    public static boolean x() {
        return r;
    }

    public static boolean y() {
        return q;
    }
}
