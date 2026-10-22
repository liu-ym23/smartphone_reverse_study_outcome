package com.bytedance.applog.monitor.v3.impl;

import android.text.TextUtils;
import com.bytedance.applog.log.n;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class c$a {
    public final String a;
    public final String b;
    public final long c;
    public final boolean d;
    public final int e;
    public final int f;
    public final long g;
    public final String h;
    public final long i;
    public final JSONObject j;

    public final JSONObject b() {
        JSONObject r0 = new JSONObject();
        r0.put("request_id", this.a);     // Catch: Throwable -> L12
        r0.put("url", this.b);     // Catch: Throwable -> L12
        r0.put("req_body_length", this.c);     // Catch: Throwable -> L12
        r0.put("is_success", this.d);     // Catch: Throwable -> L12
        r0.put("status_code", this.e);     // Catch: Throwable -> L12
        r0.put("error_code", this.f);     // Catch: Throwable -> L12
        r0.put("resp_body_length", this.g);     // Catch: Throwable -> L12
        r0.put("message", this.h);     // Catch: Throwable -> L12
        r0.put("duration", this.i);     // Catch: Throwable -> L12
        JSONObject r1 = this.j;     // Catch: Throwable -> L12
        if (r1 != null) goto L6;
    L14:
        return r0;
    L6:
        if (r1.length() <= 0) goto L14;
        Iterator<String> r2 = this.j.keys();     // Catch: Throwable -> L12
    L9:
        if (r2.hasNext() == false) goto L14;
        String r3 = r2.next();     // Catch: Throwable -> L12
        r0.put(r3, this.j.get(r3));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        n.w().r(8, c.f, "NetworkInfo toFlatJson failed", th, new Object[0]);
        goto L14
    }

    public final JSONObject c() {
        JSONObject r0 = new JSONObject();
        r0.put("request_id", this.a);     // Catch: Throwable -> L9
        r0.put("url", this.b);     // Catch: Throwable -> L9
        r0.put("req_body_length", this.c);     // Catch: Throwable -> L9
        r0.put("is_success", this.d);     // Catch: Throwable -> L9
        r0.put("status_code", this.e);     // Catch: Throwable -> L9
        r0.put("error_code", this.f);     // Catch: Throwable -> L9
        r0.put("resp_body_length", this.g);     // Catch: Throwable -> L9
        r0.put("message", this.h);     // Catch: Throwable -> L9
        r0.put("duration", this.i);     // Catch: Throwable -> L9
        JSONObject r1 = this.j;     // Catch: Throwable -> L9
        if (r1 != null) goto L6;
    L11:
        return r0;
    L6:
        if (r1.length() <= 0) goto L11;
        r0.put("extras", this.j);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        n.w().r(8, c.f, "NetworkInfo toJson failed", th, new Object[0]);
        goto L11
    }

    public static c$a a(String r23) {
        if (TextUtils.isEmpty(r23) == false) goto L10;
        return null;
    L10:
        JSONObject r0 = new JSONObject(r23);     // Catch: Throwable -> L7
        return new c$a(r0.optString("request_id"), r0.optString("url"), r0.optLong("req_body_length"), r0.optBoolean("is_success"), r0.optInt("status_code"), r0.optInt("error_code"), r0.optLong("resp_body_length"), r0.optString("message"), r0.optLong("duration"), r0.optJSONObject("extras"));
    L7:
        th = move-exception;
        n.w().r(8, c.f, "NetworkInfo fromJson failed", th, new Object[0]);
        return null;
    }

    public c$a(String r1, String r2, long r3, boolean r5, int r6, int r7, long r8, String r10, long r11, JSONObject r13) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r10;
        this.i = r11;
        this.j = r13;
    }
}
