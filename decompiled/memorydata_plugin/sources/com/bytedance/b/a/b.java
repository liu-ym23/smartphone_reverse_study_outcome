package com.bytedance.b.a;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f1893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1894b;
    private final Map<String, String> c;

    public JSONObject a() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L8
        r0.put("timestamp", this.f1893a);     // Catch: JSONException -> L8
        r0.put("message", this.f1894b);     // Catch: JSONException -> L8
        Map<String, String> r1 = this.c;     // Catch: JSONException -> L8
        if (r1 != null) goto L5;
    L7:
        return r0;
    L5:
        if (r1.size() <= 0) goto L7;
        r0.put("fields", new JSONObject(this.c));     // Catch: JSONException -> L8
    L8:
        return null;
    }
}
