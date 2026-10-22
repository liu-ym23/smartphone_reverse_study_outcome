package com.bytedance.frameworks.baselib.network.http;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class a {
    public final List<BaseRequestContext.c> a;
    public final List<a> b;

    public final JSONObject a() {
        if (((CopyOnWriteArrayList) this.b).isEmpty() == false) goto L6;
        return null;
    L6:
        JSONObject r0 = new JSONObject();
        Iterator r1 = ((CopyOnWriteArrayList) this.b).iterator();     // Catch: JSONException -> L13
    L9:
        if (r1.hasNext() == false) goto L12;
        a r2 = (a) r1.next();     // Catch: JSONException -> L13
        JSONObject r3 = new JSONObject();     // Catch: JSONException -> L13
        r3.put("callback_duration", r2.d);     // Catch: JSONException -> L13
        r3.put("request_duration", r2.e);     // Catch: JSONException -> L13
        r3.put("code", r2.c);     // Catch: JSONException -> L13
        r0.put(r2.a + r2.b, r3);     // Catch: JSONException -> L13
    L12:
        return r0;
    }

    public a(List<BaseRequestContext.c> r3) {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        this.b = new CopyOnWriteArrayList();
        if (r3.isEmpty() == true) goto L7;
        r0.addAll(r3);
        return;
    }
}
