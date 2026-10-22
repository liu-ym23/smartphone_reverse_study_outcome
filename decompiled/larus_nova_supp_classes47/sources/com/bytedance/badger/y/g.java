package com.bytedance.badger.y;

import com.bytedance.badger.data.EventReportEnum;
import com.bytedance.badger.utils.m;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final List a = null;
    public static final Object b = null;
    public static final LinkedHashMap c = null;
    public static final LinkedHashMap d = null;
    public static final g e = null;

    static {
        e = new g();
        a = CollectionsKt.listOf(new Integer[]{4001, 4002, 4003, 4004, 4005, 4006, 4007, 4008, 4009, 4010, 4011, 4012});
        b = new Object();
        c = new LinkedHashMap();
        d = new LinkedHashMap();
    }

    public g() {
    }

    public static Map g(Map r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r5 = r4.entrySet().iterator();     // Catch: Throwable -> L9
    L5:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) r5.next();     // Catch: Throwable -> L9
        r0.put((String) r1.getKey(), f(r1.getValue(), 0));     // Catch: Throwable -> L9
        goto L5
    L8:
        return r0;
    L9:
        th = move-exception;
        com.bytedance.badger.e.g("event_behavior# ", "snapshotValues failed: " + th.getMessage());
        return MapsKt.emptyMap();
    }

    public final List b(List r5, int r6) {
        if (r6 <= 20) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L14;
        Object r2 = r7.next();
        if (r2 == null) goto L10;
        Object r3 = a(r2, r6 + 1);
        if (r3 == null) goto L7;
        r0.add(r3);
        goto L7
    L10:
        r0.add(null);
        goto L7
    L14:
        return r0;
    }

    public final Map c(Map r8, int r9) {
        if (r9 <= 20) goto L5;
        return null;
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r10 = r8.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L28;
        Map.Entry r2 = (Map.Entry) r10.next();
        Object r3 = r2.getKey();
        Object r4 = r2.getValue();
        if ((r3 instanceof String) == true) goto L11;
        r3 = null;
    L11:
        String r5 = (String) r3;
        if (r5 == null) goto L7;
        String r6 = StringsKt.trim(r5).toString();
        if (r6 == null) goto L7;
        if (r6.length() != 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == true) goto L7;
        if (r6.length() > 128) goto L7;
        if (r4 == null) goto L24;
        Object r12 = a(r4, 1 + r9);
        if (r12 == null) goto L7;
        r0.put(r6, r12);
        goto L7
    L24:
        r0.put(r6, null);
        goto L7
    L18:
        r7 = false;
        goto L19
    L28:
        return r0;
    }

    public static JSONArray d(EventReportEnum r6) {
        JSONArray r0 = new JSONArray();
        Object r1 = b;
        monitor-enter(r1);
        ArrayDeque r7 = (ArrayDeque) c.get(r6);     // Catch: Throwable -> L45
        if (r7 == null) goto L8;
        List r8 = CollectionsKt.toList(r7);     // Catch: Throwable -> L45
    L9:
        monitor-exit(r1);
        if (r8 != null) goto L13;
        r8 = CollectionsKt.emptyList();
    L13:
        Iterator r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L44;
        b r2 = (b) r9.next();
        JSONObject r3 = new JSONObject();
        r3.put("key", r2.a);
        Object r4 = r2.b;
        if (r4 != null) goto L20;
        r3.put("value", JSONObject.NULL);
    L43:
        r3.put("create_time", r2.c);
        r0.put(r3);
        goto L15
    L20:
        if ((r4 instanceof JSONObject) == false) goto L23;
    L42:
        r3.put("value", r4);
        goto L43
    L23:
        if ((r4 instanceof JSONArray) == true) goto L42;
        if ((r4 instanceof Map) == false) goto L30;
        Object r5 = new JSONObject((Map) r4);
    L28:
        r4 = r5;
        goto L42
    L30:
        if ((r4 instanceof List) == false) goto L33;
        r5 = new JSONArray((Collection) r4);
        goto L28
    L33:
        if ((r4 instanceof Boolean) == true) goto L42;
        if ((r4 instanceof Number) == true) goto L42;
        if ((r4 instanceof String) == true) goto L42;
        r4 = r4.toString();
        goto L42
    L44:
        return r0;
    L8:
        r8 = null;
    L45:
        th = move-exception;
        throw th;
    }

    public static JSONObject h(EventReportEnum r6) {
        JSONArray r0 = d(r6);
        Object r1 = b;
        monitor-enter(r1);
        a r7 = (a) d.get(r6);     // Catch: Throwable -> L15
        monitor-exit(r1);
        JSONObject r2 = new JSONObject();
        r2.putOpt("value", r0);
        long r3 = 0;
        if (r7 == null) goto L9;
        long r4 = Long.valueOf(r7.a);
    L10:
        r2.putOpt("create_time", r4);
        if (r7 == null) goto L13;
        r3 = r7.b;
    L13:
        r2.putOpt("update_time", Long.valueOf(r3));
        return r2;
    L9:
        r4 = 0L;
    L15:
        th = move-exception;
        throw th;
    }

    public static void e(EventReportEnum r4, Map r5) {
        com.bytedance.badger.v.d.f0.getClass();
        com.bytedance.badger.v.f r1 = com.bytedance.badger.v.d.W;
        KProperty r2 = com.bytedance.badger.v.d.a[49];
        if (((Boolean) r1.a()).booleanValue() == true) goto L14;
        return;
    L14:
        Map r6 = g(r5);     // Catch: Throwable -> L7
    L16:
        m.a().b(new e(r4, r6));     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        com.bytedance.badger.e.c("event_behavior# ", "record failed: " + th.getMessage(), th);
        return;
    L7:
        th = move-exception;
        com.bytedance.badger.e.g("event_behavior# ", "record ignored: snapshot failed: " + th.getMessage());
        r6 = MapsKt.emptyMap();
        goto L16
    }

    public static Object f(Object r5, int r6) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r6 <= 20) goto L9;
        return null;
    L9:
        if ((r5 instanceof Boolean) == true) goto L55;
        if ((r5 instanceof Number) == true) goto L55;
        if ((r5 instanceof String) == true) goto L55;
        if ((r5 instanceof JSONObject) == true) goto L55;
        if ((r5 instanceof JSONArray) == true) goto L55;
        if ((r5 instanceof Map) == false) goto L44;
        Map r7 = (Map) r5;
        int r8 = r6 + 1;
        if (r8 > 20) goto L42;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r9 = r7.entrySet().iterator();     // Catch: Throwable -> L40
    L31:
        if (r9.hasNext() == false) goto L39;
        Map.Entry r2 = (Map.Entry) r9.next();     // Catch: Throwable -> L40
        Object r3 = r2.getKey();     // Catch: Throwable -> L40
        Object r4 = r2.getValue();     // Catch: Throwable -> L40
        if ((r3 instanceof String) == true) goto L35;
        r3 = null;
    L35:
        String r10 = (String) r3;     // Catch: Throwable -> L40
        if (r10 == null) goto L31;
        r1.put(r10, f(r4, r8 + 1));     // Catch: Throwable -> L40
        goto L31
    L39:
        r5 = r1;
    L40:
        th = move-exception;
        com.bytedance.badger.e.g("event_behavior# ", "snapshotMap failed: " + th.getMessage());
    L42:
        r5 = null;
        goto L55
    L44:
        if ((r5 instanceof List) == false) goto L55;
        List r12 = (List) r5;
        int r13 = r6 + 1;
        if (r13 > 20) goto L71;
        int r0 = r12.size();     // Catch: Throwable -> L57
        ArrayList r14 = new ArrayList(r0);
        int r15 = 0;
    L50:
        if (r15 >= r0) goto L70;
        r14.add(f(r12.get(r15), r13 + 1));
        r15 = r15 + 1;
    L70:
        return r14;
    L72:
        return null;
    L71:
        return null;
    L55:
        return r5;
    }

    public final Object a(Object r5, int r6) {
        if (r6 <= 20) goto L6;
        return null;
    L6:
        if ((r5 instanceof Boolean) == false) goto L9;
        return r5;
    L9:
        if ((r5 instanceof Number) == false) goto L12;
        return r5;
    L12:
        if ((r5 instanceof String) == false) goto L15;
        return r5;
    L15:
        if ((r5 instanceof JSONObject) == false) goto L22;
        JSONObject r7 = (JSONObject) r5;
        Map r0 = new LinkedHashMap();
        Iterator<String> r1 = r7.keys();
    L18:
        if (r1.hasNext() == false) goto L37;
        String r2 = r1.next();
        r0.put(r2, r7.opt(r2));
        goto L18
    L37:
        return c(r0, r6 + 1);
    L22:
        if ((r5 instanceof JSONArray) == false) goto L28;
        JSONArray r8 = (JSONArray) r5;
        ArrayList r3 = new ArrayList();
        int r4 = r8.length();
        int r9 = 0;
    L24:
        if (r9 >= r4) goto L38;
        r3.add(r8.opt(r9));
        r9 = r9 + 1;
        goto L24
    L38:
        return b(r3, r6 + 1);
    L28:
        if ((r5 instanceof Map) == false) goto L31;
        return c((Map) r5, r6 + 1);
    L31:
        if ((r5 instanceof List) == false) goto L34;
        return b((List) r5, r6 + 1);
    L34:
        return null;
    }
}
