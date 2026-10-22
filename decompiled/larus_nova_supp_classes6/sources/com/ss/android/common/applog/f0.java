package com.ss.android.common.applog;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import gta.g;
import java.util.ConcurrentModificationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class f0 {
    public static volatile f0 b;
    public final Context a;

    public f0(Context r1) {
        this.a = r1.getApplicationContext();
    }

    public static f0 a(Context r2) {
        if (b != null) goto L15;
        monitor-enter(f0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new f0(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f0.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public final Pair<Long, String> b(g r9, JSONObject r10) {
        JSONObject r0 = new JSONObject();
        r0.put("magic_tag", "ss_app_log");     // Catch: Throwable -> L33
        r0.put("header", r10);     // Catch: Throwable -> L33
        JSONArray r11 = new JSONArray();     // Catch: Throwable -> L33
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L33
        r1.put("datetime", AppLog.m(r9.a));     // Catch: Throwable -> L33
        r1.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L33
        r1.put("session_id", r9.b);     // Catch: Throwable -> L33
        int r3 = 1;
        r1.put("bg_session", 1);     // Catch: Throwable -> L33
        if ((!TextUtils.isEmpty(r9.d)) == false) goto L7;
        r1.put("from_session", r9.d);     // Catch: Throwable -> L33
    L7:
        if ((!TextUtils.isEmpty(r9.f)) == false) goto L9;
        r1.put("to_session", r9.f);     // Catch: Throwable -> L33
    L9:
        r1.put("duration", Math.max(1, Math.max(0, (r9.g - r9.a) - r9.h) / 1000));     // Catch: Throwable -> L33
        boolean r4 = r9.c;     // Catch: Throwable -> L33
        boolean r5 = r9.e;     // Catch: Throwable -> L33
        if (r4 == true) goto L13;
        if (r5 == true) goto L13;
    L20:
        r1.put("session_type", r3);     // Catch: Throwable -> L33
        r1.put("is_background", false);     // Catch: Throwable -> L33
        AppLog r2 = AppLog.s0;     // Catch: Throwable -> L33
        if (r2 != null) goto L40;
    L27:
        r11.put(r1);     // Catch: Throwable -> L33
        r0.put(EventVerify.TYPE_TERMINATE, r11);     // Catch: Throwable -> L33
        r9.a();     // Catch: Throwable -> L33
        String r12 = r0.toString();     // Catch: ConcurrentModificationException -> L30 Throwable -> L33
    L31:
        return Pair.create(Long.valueOf(h.d(this.a).i(r12)), r12);
    L30:
        r12 = r0.toString();     // Catch: Throwable -> L33
        goto L31
    L40:
        r1.put("tea_event_index", r2.I.getAndIncrement());     // Catch: JSONException -> L25 Throwable -> L33
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L33
    L13:
        if (r4 == false) goto L16;
        if (r5 == true) goto L16;
        r3 = 2;
    L16:
        if (r4 == true) goto L19;
        if (r5 == false) goto L19;
        r3 = 3;
    L19:
        r3 = 4;
    L33:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
