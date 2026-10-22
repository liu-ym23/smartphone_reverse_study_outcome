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
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f1720a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1721b;
    private Handler c;
    private final Map<String, Integer> d;
    private SharedPreferences e;
    private final com.bytedance.applog.monitor.v3.b f;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f1722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f1723b;

        public a(String r1, int r2) {
            this.f1722a = r1;
            this.f1723b = r2;
        }

        static /* synthetic */ String a(a r0) {
            return r0.f1722a;
        }

        static /* synthetic */ int b(a r0) {
            return r0.f1723b;
        }
    }

    static {
        f1720a = Collections.singletonList("StatsMonitor");
    }

    public d(com.bytedance.applog.monitor.v3.b r2) {
        this.f1721b = true;
        this.d = new ConcurrentHashMap();
        this.f = r2;
    }

    private void a(a r5) {
        Map<String, Integer> r0 = this.d;
        monitor-enter(r0);
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.d.get(a.a(r5)), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r1 == null) goto L7;
        int r2 = r1.intValue();     // Catch: Throwable -> L14
    L8:
        int r3 = r2 + a.b(r5);     // Catch: Throwable -> L14
        this.d.put(a.a(r5), Integer.valueOf(r3));     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        Handler r6 = this.c;
        if (r6 == null) goto L19;
        r6.removeMessages(8);
        this.c.sendEmptyMessageDelayed(8, 500);
        return;
    L19:
        return;
    L7:
        r2 = 0;
    L14:
        th = move-exception;
        throw th;
    }

    private void b() {
        SharedPreferences r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        long r1 = r0.getLong("uptime", 0);
        if (r1 > 0) goto L8;
    L11:
        Map<String, ?> r2 = this.e.getAll();
        if (r2.isEmpty() == false) goto L14;
        return;
    L14:
        Map<String, Integer> r3 = this.d;
        monitor-enter(r3);
        Iterator<Map.Entry<String, ?>> r4 = r2.entrySet().iterator();     // Catch: Throwable -> L37
    L18:
        if (r4.hasNext() == false) goto L32;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r6) == true) goto L18;
        if ("uptime".equals(r5.getKey()) == true) goto L18;
        if (r5.getValue() == null) goto L27;
        int r7 = ((Integer) ZeusTransformUtils.preCheckCast(r5.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L37
    L28:
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(this.d.get(r6), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        if (r8 == null) goto L30;
        this.d.put(r6, Integer.valueOf(r7 + r8.intValue()));     // Catch: Throwable -> L37
        goto L18
    L30:
        this.d.put(r6, Integer.valueOf(r7));     // Catch: Throwable -> L37
        goto L18
    L27:
        r7 = 0;
        goto L28
    L32:
        monitor-exit(r3);     // Catch: Throwable -> L37
        Handler r9 = this.c;
        if (r9 == null) goto L53;
        r9.removeMessages(8);
        this.c.sendEmptyMessageDelayed(8, 500);
        return;
    L53:
        return;
    L37:
        th = move-exception;
        throw th;
    L8:
        if ((System.currentTimeMillis() - r1) <= TimeUnit.DAYS.toMillis(this.f.h())) goto L11;
        this.e.edit().clear().apply();
    }

    private void c() {
        SharedPreferences.Editor r0 = this.e.edit();
        r0.clear();
        Map<String, Integer> r1 = this.d;
        monitor-enter(r1);
        Iterator<Map.Entry<String, Integer>> r6 = this.d.entrySet().iterator();     // Catch: Throwable -> L15
    L6:
        if (r6.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r2.getValue() == null) goto L10;
        int r4 = ((Integer) ZeusTransformUtils.preCheckCast(r2.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L15
    L11:
        r0.putInt(r3, r4);     // Catch: Throwable -> L15
        goto L6
    L10:
        r4 = 0;
        goto L11
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L15
        r0.putLong("uptime", System.currentTimeMillis());
        r0.apply();
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public Pair<Map<String, Integer>, Long> a(long r7) {
        if (this.d.isEmpty() == false) goto L7;
        return new Pair(null, Long.valueOf(r7));
    L7:
        return new Pair(new HashMap(this.d), Long.valueOf(r7 - (((long) this.d.size()) * 30)));
    }

    public void a() {
        this.f1721b = false;
        this.d.clear();
    }

    public void a(Context r3, HandlerThread r4, String r5) {
        this.e = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(r5 + "@applog_monitor_stats", 0);
        Handler r6 = new Handler(r4.getLooper(), this);
        this.c = r6;
        r6.removeMessages(8);
        this.c.sendEmptyMessageDelayed(8, 500);
        this.c.sendEmptyMessageDelayed(24, Math.max(10000, this.f.g() - 10000) + new SecureRandom().nextInt(WsConstants.APP_STATE_CHANGE_SERVICE));
    }

    public void a(String r3, int r4) {
        if (this.f1721b == true) goto L5;
        return;
    L5:
        a r0 = new a(r3, r4);
        Handler r5 = this.c;
        if (r5 == null) goto L8;
        r5.sendMessageDelayed(r5.obtainMessage(16, r0), 16);
        return;
    L8:
        a(r0);
    }

    public void a(Map<String, Integer> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.isEmpty() == true) goto L39;
        Map<String, Integer> r0 = this.d;
        monitor-enter(r0);
        Iterator r10 = r9.entrySet().iterator();     // Catch: Throwable -> L25
    L11:
        if (r10.hasNext() == false) goto L22;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r1.getValue() == null) goto L15;
        int r3 = ((Integer) ZeusTransformUtils.preCheckCast(r1.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L25
    L16:
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(this.d.get(r2), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r4 == null) goto L11;
        int r5 = Math.max(0, r4.intValue() - r3);     // Catch: Throwable -> L25
        if (r5 == 0) goto L20;
        this.d.put(r2, Integer.valueOf(r5));     // Catch: Throwable -> L25
        goto L11
    L20:
        this.d.remove(r2);     // Catch: Throwable -> L25
        goto L11
    L15:
        r3 = 0;
        goto L16
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L25
        this.c.removeMessages(8);
        this.c.sendEmptyMessageDelayed(8, 500);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public void a(Map<String, Integer> r7, JSONArray r8) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        JSONObject r9 = new JSONObject();
        r9.put("event", "sdk_stats");     // Catch: Throwable -> L16
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L16
        Iterator r10 = r6.entrySet().iterator();     // Catch: Throwable -> L16
    L8:
        if (r10.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r2.getValue(), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r3 == null) goto L8;
        if (r3.intValue() <= 0) goto L8;
        r1.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), r3);     // Catch: Throwable -> L16
        goto L8
    L14:
        r9.put(TrackerImpl.PARAMS, r1);     // Catch: Throwable -> L16
        r9.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L16
        r9.put("event_id", f.b());     // Catch: Throwable -> L16
        r9.put("datetime", f.d());     // Catch: Throwable -> L16
    L18:
        r8.put(r9);
        return;
    L16:
        th = move-exception;
        q.a().a(8, f1720a, "appendMapToJSONArray failed", th, new Object[0]);
        goto L18
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r3) {
        int r0 = r3.what;
        if (r0 != 8) goto L5;
        c();
        return false;
    L5:
        if (r0 != 16) goto L7;
        a((a) ZeusTransformUtils.preCheckCast(r3.obj, a.class, "com.obric.memorydata.plugin"));
        return false;
    L7:
        if (r0 != 24) goto L16;
        b();
        return false;
    L16:
        return false;
    }
}
