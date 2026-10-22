package com.bytedance.crash.dumper;

import com.bytedance.crash.i0;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.m0;
import com.bytedance.crash.monitor.f;
import com.bytedance.crash.monitor.j;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class g {
    public static void a(File r4) {
        com.bytedance.crash.monitor.a r0 = j.a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (new PolarisFileWrapper(r4.getAbsolutePath() + "/tags.txt").exists() == false) goto L8;
        return;
    L8:
        m0 r1 = ((f) r0).c;
        if (r1.q == false) goto L12;
        NativeBridge.n(new PolarisFileWrapper(r4.getAbsolutePath() + "/tags.txt").getAbsolutePath());
        return;
    L12:
        Map r2 = i0.a;
        if (NativeBridge.H() == true) goto L15;
    L17:
        Map r3 = r1.a;
    L19:
        if (r3.size() == 0) goto L33;
        dh4.f r5 = new dh4.f(r4.getAbsolutePath() + "/filters.json");
        r5.j();
        r5.h("filters");
        r5.j();
        Iterator r6 = r3.entrySet().iterator();
        boolean r7 = true;
    L22:
        if (r6.hasNext() == false) goto L28;
        Map.Entry r8 = (Map.Entry) r6.next();
        if (r7 == false) goto L26;
        r7 = false;
    L27:
        r5.h((String) r8.getKey());
        r5.l((String) r8.getValue());
        goto L22
    L26:
        r5.i();
        goto L27
    L28:
        r5.k();
        r5.k();
        r5.g();
        return;
    L33:
        return;
    L15:
        if (r1.q == false) goto L17;
        r3 = NativeBridge.z();
        goto L19
    }

    public static void b(File r8) {
        com.bytedance.crash.monitor.a r0 = j.a;
        if (r0 != null) goto L5;
        return;
    L5:
        m0 r1 = ((f) r0).c;
        r1.getClass();
        HashMap r2 = new HashMap();
        Iterator r3 = ((ConcurrentHashMap) r1.n).keySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L22;
        String r4 = (String) r3.next();
        JSONArray r5 = new JSONArray();
        LinkedList r6 = (LinkedList) ((ConcurrentHashMap) r1.n).get(r4);
        if (r6 == null) goto L20;
        monitor-enter(r6);
        Iterator r7 = r6.iterator();     // Catch: Throwable -> L17
    L13:
        if (r7.hasNext() == false) goto L15;
        r5.put((String) r7.next());     // Catch: Throwable -> L17
        goto L13
    L15:
        monitor-exit(r6);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L20:
        r2.put(r4, r5);
        goto L7
    L22:
        if (r2.isEmpty() == false) goto L31;
        return;
    L31:
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L30
        Iterator r10 = r2.entrySet().iterator();     // Catch: Throwable -> L30
    L26:
        if (r10.hasNext() == false) goto L28;
        Map.Entry r11 = (Map.Entry) r10.next();     // Catch: Throwable -> L30
        r9.put((String) r11.getKey(), r11.getValue());     // Catch: Throwable -> L30
        goto L26
    L28:
        com.bytedance.crash.util.h.i(new PolarisFileWrapper(r8.getAbsolutePath() + "/custom_crash_reason.json"), r9);     // Catch: Throwable -> L30
        return;
    }
}
