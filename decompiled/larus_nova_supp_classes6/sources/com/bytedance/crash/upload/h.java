package com.bytedance.crash.upload;

import com.bytedance.crash.util.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class h {
    public final String a;
    public final String b;
    public final String c;
    public long d;
    public int e;
    public int f;
    public int g;
    public long h;
    public final String i;
    public final JSONObject j;

    public final String toString() {
        return "[" + this.a + " " + this.e + " " + this.f + " " + this.g + " " + this.h + "]";
    }

    public final JSONObject a() {
        JSONObject r1 = new JSONObject();
        this.j.put("aid", this.b);     // Catch: Throwable -> L12
        this.j.put("path", this.c);     // Catch: Throwable -> L12
        this.j.put("update_time", this.d);     // Catch: Throwable -> L12
        JSONObject r2 = this.j;     // Catch: Throwable -> L9
        if (c.d != null) goto L7;
        c.d = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss.SSS", Locale.getDefault());     // Catch: Throwable -> L9
    L7:
        r2.put("update_time_format", c.d.format(new Date(this.d)));     // Catch: Throwable -> L9
    L10:
        this.j.put("strategy", this.e);     // Catch: Throwable -> L12
        this.j.put("alog_strategy", this.f);     // Catch: Throwable -> L12
        this.j.put("retreatCount", this.g);     // Catch: Throwable -> L12
        this.j.put("redirect", this.i);     // Catch: Throwable -> L12
        r1.put(this.a, this.j);     // Catch: Throwable -> L12
        goto L11
    L9:
        this.j.put("update_time_format", "");     // Catch: Throwable -> L12
    L11:
        return r1;
    }

    public h(JSONObject r5) throws JSONException {
        if (r5 == null) goto L7;
        String r0 = r5.optString("aid");
        this.b = r0;
        String r1 = r5.optString("path");
        this.c = r1;
        this.e = r5.optInt("strategy");
        this.f = r5.optInt("alog_strategy");
        this.d = r5.optLong("update_time");
        r5.optString("update_time_format");
        this.g = r5.optInt("retreatCount");
        this.i = r5.optString("redirect");
        this.j = new JSONObject(r5.toString());
        this.a = i.f(r0, r1);
        return;
    L7:
        throw new IllegalArgumentException("json can't be null");
    }

    public h(String r4, String r5) {
        this.b = r4;
        this.c = r5;
        this.e = 0;
        this.f = 0;
        this.d = 0;
        this.g = 0;
        this.h = 0;
        this.i = "";
        JSONObject r0 = new JSONObject();
        this.j = r0;
        this.a = i.f(r4, r5);
        r0.put("aid", r4);     // Catch: Throwable -> L5
        r0.put("path", r5);     // Catch: Throwable -> L5
        return;
    }
}
