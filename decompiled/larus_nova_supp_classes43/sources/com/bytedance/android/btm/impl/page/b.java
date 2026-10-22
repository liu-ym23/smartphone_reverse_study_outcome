package com.bytedance.android.btm.impl.page;

import com.bytedance.android.btm.impl.util.f;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final CopyOnWriteArrayList<f<Object>> a = null;
    public static Object b;
    public static Object c;
    public static String d;

    static {
        a = new CopyOnWriteArrayList();
    }

    public final String toString() {
        JSONObject r0 = new JSONObject();
        Object r10 = b;     // Catch: Throwable -> L18
        if (r10 == null) goto L6;
        String r11 = r10.getClass().getCanonicalName();     // Catch: Throwable -> L18
    L7:
        r0.put("resumedPage", r11);     // Catch: Throwable -> L18
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L18
        Iterator<f<Object>> r12 = a.iterator();     // Catch: Throwable -> L18
    L9:
        if (r12.hasNext() == false) goto L15;
        Object r13 = r12.next().get();     // Catch: Throwable -> L18
        if (r13 == null) goto L13;
        String r14 = r13.getClass().getCanonicalName();     // Catch: Throwable -> L18
    L14:
        r1.put(r14);     // Catch: Throwable -> L18
        goto L9
    L13:
        r14 = null;
        goto L14
    L15:
        r0.put("stack", r1);     // Catch: Throwable -> L18
        goto L17
    L6:
        r11 = null;
    L17:
        return r0.toString();
    }
}
