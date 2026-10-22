package com.larus.ugc.perf.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public final String a;
    public final long b;
    public final ConcurrentHashMap<String, String> c;
    public final ConcurrentHashMap<String, Object> d;

    public static final class a {
    }

    static {
    }

    public final JSONObject c() {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, String>> r1 = this.c.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<String, String> r2 = r1.next();
        r0.put(r2.getKey(), r2.getValue());
        goto L4
    L6:
        r0.put("cost_time", String.valueOf(System.currentTimeMillis() - this.b));
        Iterator<Map.Entry<String, Object>> r3 = this.d.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry<String, Object> r4 = r3.next();
        r0.putOpt(r4.getKey(), r4.getValue());
        goto L8
    L10:
        return r0;
    }

    public final long a() {
        return System.currentTimeMillis() - this.b;
    }

    public final String toString() {
        return c().toString();
    }

    public g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        this.a = r3;
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.b = System.currentTimeMillis();
    }

    public final Object b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        String r0 = this.c.get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.d.get(r2);
    }

    public final void e(Pair<String, ? extends Object> r3) {
        if (r3 == null) goto L5;
        ConcurrentHashMap<String, Object> r0 = this.d;
        Object r1 = r3.getFirst();
        String r2 = (String) r1;
        r0.put(r2, r3.getSecond());
        return;
    }

    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.c.put(r2, r3);
    }
}
