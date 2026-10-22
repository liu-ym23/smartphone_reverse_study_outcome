package com.bytedance.applog.monitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class e {
    static List<c> a(Map<String, Map<String, Monitor.b>> r10) {
        List<JSONObject> r11 = c(r10);
        ArrayList r12 = new ArrayList();
        Iterator<JSONObject> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(new c(r13.next()));
        goto L4
    L6:
        return r12;
    }

    static Map<String, Map<String, Monitor.b>> b(List<JSONObject> r13) {
        ConcurrentHashMap r10 = new ConcurrentHashMap();
        if (r13 != null) goto L5;
    L19:
        return r10;
    L5:
        if (r13.size() == 0) goto L19;
        Iterator<JSONObject> r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L19;
        JSONObject r11 = r14.next();
        String r12 = r11.optString("key", "monitor_default");     // Catch: Throwable -> L20
        String r15 = r11.optString("state", "monitor_default");     // Catch: Throwable -> L20
        int r16 = r11.optInt("total", 0);
        long r17 = r11.optLong("duration", -1);
        long r18 = r11.optLong("date", 0);
        if (r18 == 0) goto L9;
        Monitor.b r19 = new Monitor.b(r18);
        r19.f1198a = r16;
        r19.f1199b = r17;
        Map r20 = (Map) r10.get(r12);
        if (r20 != null) goto L18;
        r20 = new ConcurrentHashMap();
        r10.put(r12, r20);
    L18:
        r20.put(r15, r19);
        goto L9
    }

    static List<JSONObject> c(Map<String, Map<String, Monitor.b>> r10) {
        ArrayList r11 = new ArrayList();
        Iterator<Map.Entry<String, Map<String, Monitor.b>>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L24;
        Map.Entry<String, Map<String, Monitor.b>> r13 = r12.next();
        Map<String, Monitor.b> r14 = r13.getValue();
        if (r14 == null) goto L4;
        if (r14.size() == 0) goto L4;
        Iterator<Map.Entry<String, Monitor.b>> r15 = r14.entrySet().iterator();
    L12:
        if (r15.hasNext() == false) goto L4;
        Map.Entry<String, Monitor.b> r16 = r15.next();
        String r17 = r16.getKey();
        Monitor.b r18 = r16.getValue();
        if (r18 == null) goto L12;
        JSONObject r19 = new JSONObject();
        r19.put("key", r13.getKey());     // Catch: Throwable -> L22
        r19.put("state", r17);     // Catch: Throwable -> L22
        r19.put("total", r18.f1198a);     // Catch: Throwable -> L22
        r19.put("date", r18.f1200c);     // Catch: Throwable -> L22
        long r20 = r18.f1199b;     // Catch: Throwable -> L22
        if (r20 == (-1)) goto L20;
        r19.put("duration", r20);     // Catch: Throwable -> L22
    L20:
        r19.put("params_for_special", "applog_trace");     // Catch: Throwable -> L22
        r11.add(r19);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.printStackTrace();
        goto L12
    L24:
        return r11;
    }

    static Map<String, Map<String, Monitor.b>> d(Map<String, Map<String, Monitor.b>>... r17) {
        ConcurrentHashMap r10 = new ConcurrentHashMap();
        int r11 = r17.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L33;
        Iterator<Map.Entry<String, Map<String, Monitor.b>>> r13 = r17[r12].entrySet().iterator();
    L6:
        if (r13.hasNext() == false) goto L32;
        Map.Entry<String, Map<String, Monitor.b>> r14 = r13.next();
        String r15 = r14.getKey();
        Map<String, Monitor.b> r16 = r14.getValue();
        if (r16 == null) goto L6;
        if (r16.size() == 0) goto L6;
        Iterator<Map.Entry<String, Monitor.b>> r18 = r16.entrySet().iterator();
    L14:
        if (r18.hasNext() == false) goto L6;
        Map.Entry<String, Monitor.b> r19 = r18.next();
        String r20 = r19.getKey();
        Monitor.b r21 = r19.getValue();
        Map r22 = (Map) r10.get(r15);
        if (r22 != null) goto L18;
        r22 = new ConcurrentHashMap(4);
        r10.put(r15, r22);
    L18:
        Monitor.b r110 = (Monitor.b) r22.get(r20);
        if (r110 != null) goto L21;
        r110 = new Monitor.b();
        r110.f1199b = -1;
    L21:
        if (r21 == null) goto L14;
        r110.f1198a += r21.f1198a;
        long r111 = r110.f1199b;
        if (r111 != (-1)) goto L26;
        r110.f1199b = r21.f1199b;
    L31:
        r22.put(r20, r110);
        r13 = r13;
        r18 = r18;
        goto L14
    L26:
        long r23 = r21.f1199b;
        if (r23 == (-1)) goto L30;
        r111 = r111 + r23;
    L30:
        r110.f1199b = r111;
        goto L31
    L32:
        r12 = r12 + 1;
        goto L3
    L33:
        return r10;
    }
}
