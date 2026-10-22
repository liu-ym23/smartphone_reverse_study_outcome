package com.ss.android.lark.officesdk.internal;

import java.util.HashMap;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public static final HashMap<String, b> a = null;
    public static final Object b = null;

    static {
        a = new HashMap();
        b = new Object();
    }

    public static void a(String r1, String r2, long r3) {
        b r0 = new b(r1, r2, r3);
        Object r4 = b;
        monitor-enter(r4);
        a.put(r1, r0);     // Catch: Throwable -> L8
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r4);
        JSONObject r6 = new JSONObject();
        r6.put("task_name", r0.a);
        r6.put("phase", r0.b);
        r6.put("cost_ms", r0.c);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
