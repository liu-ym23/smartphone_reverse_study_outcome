package com.bytedance.applog.monitor.v3.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.log.q;
import com.bytedance.applog.monitor.v3.f;
import com.bytedance.applog.monitor.v3.g;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f1712a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1713b;
    private Handler c;
    private final Map<String, a> d;
    private SharedPreferences e;
    private final com.bytedance.applog.monitor.v3.b f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f1714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f1715b;
        private final long c;
        private final boolean d;
        private final int e;
        private final int f;
        private final long g;
        private final String h;
        private final long i;
        private final JSONObject j;

        public a(String r1, String r2, long r3, boolean r5, int r6, int r7, long r8, String r10, long r11, JSONObject r13) {
            this.f1714a = r1;
            this.f1715b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r10;
            this.i = r11;
            this.j = r13;
        }

        public static a a(String r23) {
            if (TextUtils.isEmpty(r23) == false) goto L10;
            return null;
        L10:
            JSONObject r0 = new JSONObject(r23);     // Catch: Throwable -> L7
            return new a(r0.optString("request_id"), r0.optString("url"), r0.optLong("req_body_length"), r0.optBoolean(LocationMonitorConst.IS_SUCCESS), r0.optInt("status_code"), r0.optInt("error_code"), r0.optLong("resp_body_length"), r0.optString("message"), r0.optLong("duration"), r0.optJSONObject("extras"));
        L7:
            th = move-exception;
            q.a().a(8, b.c(), "NetworkInfo fromJson failed", th, new Object[0]);
            return null;
        }

        static /* synthetic */ String a(a r0) {
            return r0.f1714a;
        }

        public long a() {
            return ((long) ((this.f1714a.length() + this.f1715b.length()) + this.h.length())) + 200;
        }

        public JSONObject b() {
            JSONObject r0 = new JSONObject();
            r0.put("request_id", this.f1714a);     // Catch: Throwable -> L9
            r0.put("url", this.f1715b);     // Catch: Throwable -> L9
            r0.put("req_body_length", this.c);     // Catch: Throwable -> L9
            r0.put(LocationMonitorConst.IS_SUCCESS, this.d);     // Catch: Throwable -> L9
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
            q.a().a(8, b.c(), "NetworkInfo toJson failed", th, new Object[0]);
            goto L11
        }
    }

    static {
        f1712a = Collections.singletonList("NetworkMonitor");
    }

    public b(com.bytedance.applog.monitor.v3.b r2) {
        this.f1713b = false;
        this.d = new ConcurrentHashMap();
        this.f = r2;
    }

    private void a(a r4) {
        this.d.put(a.a(r4), r4);
        Handler r5 = this.c;
        if (r5 == null) goto L6;
        r5.removeMessages(8);
        this.c.sendEmptyMessageDelayed(8, 500);
        return;
    }

    static /* synthetic */ List c() {
        return f1712a;
    }

    private void d() {
        SharedPreferences r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        Map<String, ?> r1 = r0.getAll();
        if (r1.isEmpty() == false) goto L8;
        return;
    L8:
        Map<String, a> r2 = this.d;
        monitor-enter(r2);
        Iterator<Map.Entry<String, ?>> r3 = r1.entrySet().iterator();     // Catch: Throwable -> L26
    L12:
        if (r3.hasNext() == false) goto L21;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (TextUtils.isEmpty((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin")) == true) goto L12;
        if ("uptime".equals(r4.getKey()) == true) goto L12;
        a r5 = a.a((String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L26
        if (r5 == null) goto L12;
        this.d.put(a.a(r5), r5);     // Catch: Throwable -> L26
        goto L12
    L21:
        monitor-exit(r2);     // Catch: Throwable -> L26
        Handler r6 = this.c;
        if (r6 == null) goto L41;
        r6.removeMessages(8);
        this.c.sendEmptyMessageDelayed(8, 500);
        return;
    L41:
        return;
    L26:
        th = move-exception;
        throw th;
    }

    private void e() {
        SharedPreferences.Editor r0 = this.e.edit();
        Map<String, a> r1 = this.d;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.d.size() <= 1000) goto L7;
        r0.clear();     // Catch: Throwable -> L14
        this.d.clear();     // Catch: Throwable -> L14
    L7:
        Iterator<Map.Entry<String, a>> r6 = this.d.entrySet().iterator();     // Catch: Throwable -> L14
    L9:
        if (r6.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        r0.putString((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), ((a) ZeusTransformUtils.preCheckCast(r2.getValue(), a.class, "com.obric.memorydata.plugin")).b().toString());     // Catch: Throwable -> L14
        goto L9
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L14
        r0.apply();
    }

    public Pair<Map<String, a>, Long> a(long r7) {
        if (this.d.isEmpty() == true) goto L5;
        HashMap r0 = new HashMap();
        Map<String, a> r1 = this.d;
        monitor-enter(r1);
        Iterator<Map.Entry<String, a>> r6 = this.d.entrySet().iterator();     // Catch: Throwable -> L21
    L10:
        if (r6.hasNext() == false) goto L18;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        a r4 = (a) ZeusTransformUtils.preCheckCast(r2.getValue(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r4 == null) goto L10;
        r7 = r7 - r4.a();     // Catch: Throwable -> L21
        if (r7 <= 0) goto L18;
        r0.put(r3, r4);     // Catch: Throwable -> L21
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L21
        return new Pair(r0, Long.valueOf(r7));
    L21:
        th = move-exception;
        throw th;
    L5:
        return new Pair(null, Long.valueOf(r7));
    }

    public void a(Context r3, HandlerThread r4, String r5) {
        this.e = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(r5 + "@applog_monitor_network", 0);
        this.f1713b = g.a(this.f.k(), 10000);
        Handler r6 = new Handler(r4.getLooper(), this);
        this.c = r6;
        r6.removeMessages(8);
        this.c.sendEmptyMessageDelayed(8, 500);
        this.c.sendEmptyMessageDelayed(24, Math.max(10000, this.f.g() - 10000) + new SecureRandom().nextInt(WsConstants.APP_STATE_CHANGE_SERVICE));
    }

    public void a(String r20, String r21, long r22, boolean r24, int r25, int r26, long r27, String r29, long r30, JSONObject r32) {
        if (this.f1713b == true) goto L5;
        return;
    L5:
        q.a().b(8, f1712a, "onRequestFinished {} -> {}, {}, {}, {}, {}, {}, {}, {}", new Object[]{r20, r21, Long.valueOf(r22), Boolean.valueOf(r24), Integer.valueOf(r25), Integer.valueOf(r26), Long.valueOf(r27), r29, Long.valueOf(r30), r32});
        a r1 = new a(r20, r21, r22, r24, r25, r26, r27, r29, r30, r32);
        Handler r2 = this.c;
        if (r2 == null) goto L8;
        r2.sendMessage(r2.obtainMessage(16, r1));
        return;
    L8:
        a(r1);
    }

    public void a(Map<String, a> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L23;
        Map<String, a> r0 = this.d;
        monitor-enter(r0);
        Iterator r7 = r6.entrySet().iterator();     // Catch: Throwable -> L16
    L11:
        if (r7.hasNext() == false) goto L13;
        String r1 = (String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        this.d.remove(r1);     // Catch: Throwable -> L16
        goto L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L16
        this.c.removeMessages(8);
        this.c.sendEmptyMessageDelayed(8, 500);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public void a(Map<String, a> r7, JSONArray r8) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == false) goto L15;
        return;
    L15:
        Iterator r9 = r6.entrySet().iterator();     // Catch: Throwable -> L12
    L7:
        if (r9.hasNext() == false) goto L22;
        a r10 = (a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r10 == null) goto L7;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L12
        r1.put("event", "sdk_network");     // Catch: Throwable -> L12
        r1.put(TrackerImpl.PARAMS, r10.b());     // Catch: Throwable -> L12
        r1.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L12
        r1.put("event_id", f.b());     // Catch: Throwable -> L12
        r1.put("datetime", f.d());     // Catch: Throwable -> L12
        r8.put(r1);     // Catch: Throwable -> L12
        goto L7
    L22:
        return;
    L12:
        th = move-exception;
        q.a().a(8, f1712a, "appendMapToJSONArray failed", th, new Object[0]);
    }

    public boolean a() {
        return this.f1713b;
    }

    public void b() {
        this.f1713b = false;
        this.d.clear();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r3) {
        int r0 = r3.what;
        if (r0 != 8) goto L5;
        e();
        return false;
    L5:
        if (r0 != 16) goto L7;
        a((a) ZeusTransformUtils.preCheckCast(r3.obj, a.class, "com.obric.memorydata.plugin"));
        return false;
    L7:
        if (r0 != 24) goto L16;
        d();
        return false;
    L16:
        return false;
    }
}
