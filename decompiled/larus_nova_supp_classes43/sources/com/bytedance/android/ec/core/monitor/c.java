package com.bytedance.android.ec.core.monitor;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final Map<String, a> a = null;
    public static final v b = null;

    public c() {
    }

    static {
        a = new HashMap();
        b = new v();
    }

    public static void d(String r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        a r0 = (a) ((HashMap) a).get(r12);
        if (r0 != null) goto L38;
    L36:
        ((HashMap) a).remove(r12);
        return;
    L38:
        n r1 = r0.f;     // Catch: Exception -> L34
        if (r1 == null) goto L9;
        r1.a(r0.b);     // Catch: Exception -> L34
    L9:
        Map<String, String> r10 = r0.c;     // Catch: Exception -> L34
        Long r11 = null;
        if ((r10 instanceof Map) == true) goto L12;
        r10 = null;
    L12:
        if (r10 != null) goto L14;
        r10 = MapsKt.emptyMap();     // Catch: Exception -> L34
    L14:
        JSONObject r13 = new JSONObject(r10);     // Catch: Exception -> L34
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L34
        Map<String, String> r15 = r0.d;     // Catch: Exception -> L34
        if ((r15 instanceof Map) == true) goto L17;
        r15 = null;
    L17:
        if (r15 != null) goto L19;
        r15 = MapsKt.emptyMap();     // Catch: Exception -> L34
    L19:
        JSONObject r16 = new JSONObject(r15);     // Catch: Exception -> L34
        Iterator r17 = ((HashMap) r0.b).entrySet().iterator();     // Catch: Exception -> L34
    L21:
        if (r17.hasNext() == false) goto L25;
        Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Exception -> L34
        String r19 = (String) r18.getKey();     // Catch: Exception -> L34
        long r110 = ((Number) r18.getValue()).longValue();     // Catch: Exception -> L34
        if (r110 <= 0) goto L21;
        r14.put(r19, String.valueOf(r110));     // Catch: Exception -> L34
        goto L21
    L25:
        n r20 = r0.f;     // Catch: Exception -> L34
        if (r20 == null) goto L28;
        r11 = r20.b(r0.b);     // Catch: Exception -> L34
    L28:
        if (r11 != null) goto L30;
    L32:
        int r21 = ECMonitorService.b;     // Catch: Exception -> L34
        ECMonitorService.a.a(r0.e, r13, r14, r16);     // Catch: Exception -> L34
        goto L36
    L30:
        if (r11.longValue() <= 0) goto L32;
        r14.put(MetricNames.RENDER_DURATION.getMetricNames(), String.valueOf(r11.longValue()));     // Catch: Exception -> L34
    L34:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L36
    }

    public static void g(q r1) {
        Intrinsics.checkNotNullParameter(r1, "monitorSceneWrapper");
        jh.b.c.getClass();
        jh.b.a.a(r1).a();
    }

    public static void i(q r1) {
        Intrinsics.checkNotNullParameter(r1, "monitorSceneWrapper");
        jh.b.c.getClass();
        jh.b.a.a(r1).stop();
    }

    public static String c(MonitorScenes r10, n r11) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        String r1 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullParameter(r10, "scene");
        String r12 = r10.getSceneName();
        if (r11 != null) goto L5;
        r11 = b;
    L5:
        a r0 = new a(r12, r11);
        if (r1 != null) goto L8;
    L11:
        boolean r13 = true;
    L12:
        if (r13 == false) goto L14;
        r1 = UUID.randomUUID().toString();
    L14:
        ((HashMap) a).put(r1, r0);
        return r1;
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r13 = false;
        goto L12
    }

    public static void j(String r1, MetricNames r10) {
        Intrinsics.checkNotNullParameter(r10, "metricName");
        if (r1 != null) goto L5;
        return;
    L5:
        a r11 = (a) ((HashMap) a).get(r1);
        if (r11 == null) goto L9;
        r11.a(r10.getMetricNames());
        return;
    }

    public static void a(String r10, MetricNames r11, long r12) {
        Intrinsics.checkNotNullParameter(r11, "metricName");
        if (r10 != null) goto L5;
        return;
    L5:
        a r13 = (a) ((HashMap) a).get(r10);
        if (r13 == null) goto L11;
        String r14 = r11.getMetricNames();
        Intrinsics.checkNotNullParameter(r14, "metricName");
        if (r12 <= 0) goto L12;
        Map<String, Long> r15 = r13.b;
        HashMap r16 = (HashMap) r15;
        r16.put(r14, Long.valueOf(r12));
        return;
    L12:
        return;
    }

    public static void b(MonitorScenes r10, Map r11, Map r12) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        JSONObject r0 = new JSONObject();
        if (r11 == null) goto L8;
        Iterator r13 = r11.entrySet().iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) r13.next();
        r0.put((String) r1.getKey(), (String) r1.getValue());
    L8:
        JSONObject r14 = new JSONObject();
        if (r12 == null) goto L14;
        Iterator r15 = r12.entrySet().iterator();
    L12:
        if (r15.hasNext() == false) goto L14;
        Map.Entry r16 = (Map.Entry) r15.next();
        r14.put((String) r16.getKey(), (String) r16.getValue());
    L14:
        JSONObject r17 = new JSONObject();
        int r18 = ECMonitorService.b;
        ECMonitorService.a.a(r10.getSceneName(), r14, r0, r17);
    }

    public static void e(String r1, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (r1 != null) goto L5;
        return;
    L5:
        a r12 = (a) ((HashMap) a).get(r1);
        if (r12 == null) goto L9;
        ((HashMap) r12.c).put(r10, r11);
        return;
    }

    public static void f(String r1, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (r1 != null) goto L5;
        return;
    L5:
        a r12 = (a) ((HashMap) a).get(r1);
        if (r12 == null) goto L9;
        ((HashMap) r12.d).put(r10, r11);
        return;
    }

    public static void h(String r10, MetricNames r11, Long r12) {
        Intrinsics.checkNotNullParameter(r11, "metricName");
        if (r10 != null) goto L5;
        return;
    L5:
        a r13 = (a) ((HashMap) a).get(r10);
        if (r13 == null) goto L13;
        String r14 = r11.getMetricNames();
        Intrinsics.checkNotNullParameter(r14, "metricName");
        Map<String, Long> r15 = r13.a;
        if (r12 == null) goto L10;
        long r0 = r12.longValue();
    L11:
        HashMap r16 = (HashMap) r15;
        r16.put(r14, Long.valueOf(r0));
        return;
    L10:
        r0 = SystemClock.elapsedRealtime();
        goto L11
    }
}
