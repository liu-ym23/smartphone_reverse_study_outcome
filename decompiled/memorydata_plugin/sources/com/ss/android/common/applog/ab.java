package com.ss.android.common.applog;

import android.content.Context;
import android.util.Pair;
import com.bytedance.bdinstall.Api;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ConcurrentModificationException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ab f15047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f15048b;

    private ab(Context r3) {
        this.f15048b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public static ab a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f15047a != null) goto L15;
        monitor-enter(ab.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15047a != null) goto L9;
        f15047a = new ab(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ab.class);     // Catch: Throwable -> L11
    L15:
        return f15047a;
    }

    public static String a() {
        return AppLog.v();
    }

    public static long b() {
        return AppLog.t();
    }

    public Pair<Long, String> a(com.ss.android.common.applog.b.d r7, JSONObject r8) {
        if (r7 != null) goto L5;
        return null;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put(Api.KEY_MAGIC, Api.MSG_MAGIC);     // Catch: Throwable -> L18
        r1.put("header", r8);     // Catch: Throwable -> L18
        JSONArray r9 = new JSONArray();     // Catch: Throwable -> L18
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L18
        r2.put("datetime", AppLog.a(r7.k()));     // Catch: Throwable -> L18
        r2.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L18
        r2.put("session_id", r7.f());     // Catch: Throwable -> L18
        r2.put("bg_session", 1);     // Catch: Throwable -> L18
        if (r7.a() == false) goto L10;
        r2.put("from_session", r7.c());     // Catch: Throwable -> L18
    L10:
        if (r7.b() == false) goto L12;
        r2.put("to_session", r7.d());     // Catch: Throwable -> L18
    L12:
        r2.put("duration", r7.j());     // Catch: Throwable -> L18
        r2.put("session_type", r7.g());     // Catch: Throwable -> L18
        r2.put("is_background", false);     // Catch: Throwable -> L18
        AppLog.a(r2);     // Catch: Throwable -> L18
        r9.put(r2);     // Catch: Throwable -> L18
        r1.put("terminate", r9);     // Catch: Throwable -> L18
        com.ss.android.common.b.c.a.c("save task session to db : " + r7.toString());     // Catch: Throwable -> L18
        String r10 = r1.toString();     // Catch: ConcurrentModificationException -> L15 Throwable -> L18
    L16:
        return Pair.create(Long.valueOf(d.a(this.f15048b).a(r10, 0)), r10);
    L15:
        r10 = r1.toString();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void a(com.ss.android.common.applog.b.d r2) {
        com.ss.android.common.applog.b.d r3 = com.ss.android.common.applog.b.d.a(r2);
        if (r3 == null) goto L8;
        t r0 = new t();
        r0.f15101a = r3;
        AppLog r1 = AppLog.a(this.f15048b);
        if (r1 == null) goto L9;
        r1.a(r0);
        return;
    L9:
        return;
    }
}
