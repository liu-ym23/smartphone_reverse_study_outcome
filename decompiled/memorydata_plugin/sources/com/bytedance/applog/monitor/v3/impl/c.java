package com.bytedance.applog.monitor.v3.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.log.j;
import com.bytedance.applog.log.q;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.applog.monitor.v3.f;
import com.bytedance.applog.monitor.v3.g;
import com.bytedance.applog.monitor.v3.h;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.constants.Constants;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements Handler.Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f1716b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f1717a;
    private boolean c;
    private Handler d;
    private SharedPreferences e;
    private final com.bytedance.applog.monitor.v3.b f;
    private boolean g;
    private final AtomicBoolean h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private h f1718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private EventStage f1719b;
        private boolean c;

        public a(EventStage r2, h r3) {
            this.c = false;
            this.f1719b = r2;
            this.f1718a = r3;
        }

        static /* synthetic */ EventStage a(a r0) {
            return r0.f1719b;
        }

        static /* synthetic */ EventStage a(a r0, EventStage r1) {
            r0.f1719b = r1;
            return r1;
        }

        public static a a(String r18, String r19) {
            String r1 = null;
            if (TextUtils.isEmpty(r19) == false) goto L5;
            return null;
        L5:
            List<String> r0 = f.a(r19, '|');
            if (r0.isEmpty() == false) goto L8;
            return null;
        L8:
            if (((String) ZeusTransformUtils.preCheckCast(r0.get(0), String.class, "com.obric.memorydata.plugin")).equals("v3") == false) goto L18;
            int r2 = -1;
            r2 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r0.get(2), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L25
        L11:
            int r12 = r2;
            EventStage r3 = EventStage.valueOf((String) ZeusTransformUtils.preCheckCast(r0.get(3), String.class, "com.obric.memorydata.plugin"));
            if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r0.get(1), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L16;
            r1 = (String) ZeusTransformUtils.preCheckCast(r0.get(1), String.class, "com.obric.memorydata.plugin");
        L16:
            return new a(r3, new h(r1, r12, (String) ZeusTransformUtils.preCheckCast(r0.get(4), String.class, "com.obric.memorydata.plugin"), r18, Long.parseLong((String) ZeusTransformUtils.preCheckCast(r0.get(5), String.class, "com.obric.memorydata.plugin")), StageEventType.parse((String) ZeusTransformUtils.preCheckCast(r0.get(6), String.class, "com.obric.memorydata.plugin"))));
        L18:
            if (r0.size() != 4) goto L22;
            return new a(EventStage.valueOf((String) ZeusTransformUtils.preCheckCast(r0.get(0), String.class, "com.obric.memorydata.plugin")), new h((String) ZeusTransformUtils.preCheckCast(r0.get(1), String.class, "com.obric.memorydata.plugin"), r18, Long.parseLong((String) ZeusTransformUtils.preCheckCast(r0.get(2), String.class, "com.obric.memorydata.plugin")), StageEventType.V3_EVENT));
        L22:
            if (r0.size() == 5) goto L24;
            return null;
        L24:
            return new a(EventStage.valueOf((String) ZeusTransformUtils.preCheckCast(r0.get(0), String.class, "com.obric.memorydata.plugin")), new h((String) ZeusTransformUtils.preCheckCast(r0.get(1), String.class, "com.obric.memorydata.plugin"), r18, Long.parseLong((String) ZeusTransformUtils.preCheckCast(r0.get(2), String.class, "com.obric.memorydata.plugin")), StageEventType.parse((String) ZeusTransformUtils.preCheckCast(r0.get(3), String.class, "com.obric.memorydata.plugin"))));
        }

        static /* synthetic */ boolean a(a r0, boolean r1) {
            r0.c = r1;
            return r1;
        }

        static /* synthetic */ h b(a r0) {
            return r0.f1718a;
        }

        static /* synthetic */ boolean c(a r0) {
            return r0.c;
        }

        public JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put("monitor_id", this.f1718a.f1703b);     // Catch: Throwable -> L19
            if (this.f1718a.d == null) goto L7;
            r0.put(Constants.EVENT_TYPE, this.f1718a.d.getLabel());     // Catch: Throwable -> L19
        L7:
            if (TextUtils.isEmpty(this.f1718a.f1702a) == true) goto L10;
            r0.put("event", this.f1718a.f1702a);     // Catch: Throwable -> L19
        L10:
            if (this.f1718a.c <= 0) goto L13;
            r0.put("local_time_ms", this.f1718a.c);     // Catch: Throwable -> L19
        L13:
            if (TextUtils.isEmpty(this.f1718a.e) == true) goto L16;
            r0.put("event_priority", this.f1718a.e);     // Catch: Throwable -> L19
        L16:
            if (this.f1718a.f < 0) goto L18;
            r0.put("global_priority", this.f1718a.f);     // Catch: Throwable -> L19
        L18:
            return r0;
        }

        public long b() {
            h r2 = this.f1718a;
            if (r2 == null) goto L5;
            int r3 = r2.f1702a.length();
        L7:
            return r3 + 133;
        L5:
            r3 = 0;
            goto L7
        }

        public String c() {
            StringBuilder r0 = new StringBuilder().append("v3|");
            if (TextUtils.isEmpty(this.f1718a.e) == false) goto L5;
            String r1 = "";
        L7:
            return r0.append(r1).append("|").append(this.f1718a.f).append("|").append(this.f1719b.name()).append("|").append(this.f1718a.f1702a).append("|").append(this.f1718a.c).append("|").append(this.f1718a.d.name()).toString();
        L5:
            r1 = this.f1718a.e;
            goto L7
        }
    }

    static {
        f1716b = Collections.singletonList("SentryMonitor");
    }

    public c(com.bytedance.applog.monitor.v3.b r3) {
        this.f1717a = Collections.synchronizedMap(new LinkedHashMap());
        this.c = true;
        this.g = true;
        this.h = new AtomicBoolean(false);
        this.f = r3;
    }

    private void a(a r7) {
        q.a().b(8, f1716b, "start handle stage ({})", new Object[]{r7});
        Map<String, a> r0 = this.f1717a;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (b(a.b(r7).f1702a) == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L8:
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f1717a.get(a.b(r7).f1703b), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r1 != null) goto L11;
        this.f1717a.put(a.b(r7).f1703b, r7);     // Catch: Throwable -> L19
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L19
        Handler r8 = this.d;
        if (r8 == null) goto L23;
        r8.removeMessages(4);
        this.d.sendEmptyMessageDelayed(4, 500);
        return;
    L23:
        return;
    L11:
        a.a(r1, false);     // Catch: Throwable -> L19
        a.b(r1).a(a.b(r7));     // Catch: Throwable -> L19
        if (a.a(r7).ordinal() <= a.a(r1).ordinal()) goto L14;
        a.a(r1, a.a(r7));     // Catch: Throwable -> L19
        goto L14
    }

    private void c() {
        q.a().b(8, f1716b, "start flush cache map (size={}) to sp...", new Object[]{Integer.valueOf(this.f1717a.size())});
        SharedPreferences.Editor r0 = this.e.edit();
        Map<String, a> r1 = this.f1717a;
        monitor-enter(r1);
        Iterator<Map.Entry<String, a>> r2 = this.f1717a.entrySet().iterator();     // Catch: Throwable -> L15
    L6:
        if (r2.hasNext() == false) goto L12;
        a r4 = (a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (a.c(r4) == true) goto L6;
        if (b(a.b(r4).f1702a) == false) goto L6;
        r0.putString(a.b(r4).f1703b, r4.c());     // Catch: Throwable -> L15
        a.a(r4, true);     // Catch: Throwable -> L15
        goto L6
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L15
        r0.putLong("uptime", System.currentTimeMillis());
        r0.apply();
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void d() {
        if (this.e != null) goto L5;
        return;
    L5:
        q.a().b(8, f1716b, "start load cache map from sp...", new Object[0]);
        long r0 = this.e.getLong("uptime", 0);
        if (r0 > 0) goto L8;
    L11:
        Map<String, ?> r1 = this.e.getAll();
        if (r1.isEmpty() == false) goto L14;
        return;
    L14:
        HashMap r2 = new HashMap(r1.size() * 2);
        Iterator<Map.Entry<String, ?>> r3 = r1.entrySet().iterator();
    L16:
        if (r3.hasNext() == false) goto L26;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r5) == true) goto L16;
        if ("uptime".equals(r5) == true) goto L16;
        a r6 = a.a(r5, (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.memorydata.plugin"));
        if (r6 == null) goto L16;
        a.a(r6, true);
        r2.put(r5, r6);
        goto L16
    L26:
        Map<String, a> r7 = this.f1717a;
        monitor-enter(r7);
        Iterator r8 = r2.entrySet().iterator();     // Catch: Throwable -> L39
    L30:
        if (r8.hasNext() == false) goto L37;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        a r11 = (a) ZeusTransformUtils.preCheckCast(r9.getValue(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        if (this.f1717a.containsKey(r9.getKey()) == false) goto L36;
        a r12 = (a) ZeusTransformUtils.preCheckCast(this.f1717a.get(r9.getKey()), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        if (r12 == null) goto L36;
        a.a(r11, false);     // Catch: Throwable -> L39
        a.b(r11).a(a.b(r12));     // Catch: Throwable -> L39
    L36:
        this.f1717a.put(r10, r11);     // Catch: Throwable -> L39
        goto L30
    L37:
        monitor-exit(r7);     // Catch: Throwable -> L39
        return;
    L39:
        th = move-exception;
        throw th;
    L8:
        if ((System.currentTimeMillis() - r0) <= TimeUnit.DAYS.toMillis(this.f.h())) goto L11;
        this.e.edit().clear().apply();
    }

    private void e() {
        if (this.f1717a.isEmpty() == false) goto L5;
        return;
    L5:
        q.a().b(8, f1716b, "start reset cache map...", new Object[0]);
        if (b() == false) goto L8;
    L13:
        Map<String, a> r0 = this.f1717a;
        monitor-enter(r0);
        Iterator<Map.Entry<String, a>> r1 = this.f1717a.entrySet().iterator();     // Catch: Throwable -> L23
    L17:
        if (r1.hasNext() == false) goto L21;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (b(a.b((a) ZeusTransformUtils.preCheckCast(r2.getValue(), a.class, "com.obric.memorydata.plugin")).f1702a) == true) goto L17;
        this.f1717a.remove(r2.getKey());     // Catch: Throwable -> L23
        goto L17
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    L8:
        if (this.f.m() != null) goto L10;
    L11:
        this.f1717a.clear();
        return;
    L10:
        if (this.f.m().isEmpty() == false) goto L13;
        goto L11
    }

    public Pair<Map<String, a>, Long> a(long r7) {
        if (this.f1717a.isEmpty() == true) goto L5;
        LinkedHashMap r0 = new LinkedHashMap();
        Map<String, a> r1 = this.f1717a;
        monitor-enter(r1);
        Iterator<Map.Entry<String, a>> r6 = this.f1717a.entrySet().iterator();     // Catch: Throwable -> L16
    L10:
        if (r6.hasNext() == false) goto L13;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2.getValue(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        r0.put(r2.getKey(), r3);     // Catch: Throwable -> L16
        r7 = r7 - r3.b();     // Catch: Throwable -> L16
        if (r7 >= 0) goto L10;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return new Pair(r0, Long.valueOf(r7));
    L16:
        th = move-exception;
        throw th;
    L5:
        return new Pair(null, Long.valueOf(r7));
    }

    public void a() {
        q.a().b(8, f1716b, "init with disabled", new Object[0]);
        this.c = false;
        this.f1717a.clear();
        this.h.set(true);
    }

    public void a(Context r8, HandlerThread r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        j r0 = q.a();
        List<String> r1 = f1716b;
        r0.b(8, r1, "init with prefix sp: {}.", new Object[]{r10});
        if (this.h.compareAndSet(false, true) == true) goto L7;
        q.a().d(8, r1, "init failed for already initialized with sp prefix:{}.", new Object[]{r10});
        return;
    L7:
        if (this.f.i() == true) goto L10;
        q.a().b(8, r1, "init but disabled!!!", new Object[0]);
        this.g = false;
        this.f1717a.clear();
        this.c = false;
        return;
    L10:
        this.g = g.a(this.f.j(), 10000);
        q.a().b(8, r1, "sentry acceptAllEvents = {}", new Object[]{Boolean.valueOf(this.g)});
        this.e = r11.getSharedPreferences(r10 + "@applog_monitor_sentry", 0);
        if (b() == true) goto L13;
        e();
    L13:
        Handler r12 = new Handler(r9.getLooper(), this);
        this.d = r12;
        r12.removeMessages(4);
        this.d.sendEmptyMessageDelayed(4, 500);
        this.d.sendEmptyMessageDelayed(12, Math.max(10000, this.f.g() - 10000) + ((long) new SecureRandom().nextInt(WsConstants.APP_STATE_CHANGE_SERVICE)));
    }

    public void a(String r13, int r14, EventStage r15, String r16, String r17, long r18, StageEventType r20) {
        if (this.c == true) goto L5;
    L14:
        q.a().b(8, f1716b, "stage nothing for disabled!!!", new Object[0]);
        return;
    L5:
        if (this.f.i() == false) goto L14;
        a r1 = new a(r15, new h(r13, r14, r16, r17, r18, r20));
        if (this.d != null) goto L10;
    L12:
        a(r1);
        return;
    L10:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L12;
        Handler r0 = this.d;
        r0.sendMessage(r0.obtainMessage(8, r1));
    }

    public void a(Map<String, a> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.isEmpty() == true) goto L34;
        SharedPreferences.Editor r0 = null;
        SharedPreferences r1 = this.e;
        if (r1 == null) goto L10;
        r0 = r1.edit();
    L10:
        Map<String, a> r2 = this.f1717a;
        monitor-enter(r2);
        Iterator r8 = r7.keySet().iterator();     // Catch: Throwable -> L22
    L14:
        if (r8.hasNext() == false) goto L18;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        this.f1717a.remove(r3);     // Catch: Throwable -> L22
        if (r0 == null) goto L14;
        r0.remove(r3);     // Catch: Throwable -> L22
        goto L14
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L22
        if (r0 == null) goto L33;
        r0.apply();
        return;
    L33:
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public void a(Map<String, a> r6, JSONArray r7) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        HashMap r8 = new HashMap();
        Iterator r9 = r5.values().iterator();
    L7:
        if (r9.hasNext() == false) goto L12;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r9.next(), a.class, "com.obric.memorydata.plugin");
        JSONArray r2 = (JSONArray) ZeusTransformUtils.preCheckCast(r8.get(a.a(r1)), JSONArray.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L11;
        r2 = new JSONArray();
        r8.put(a.a(r1), r2);
    L11:
        r2.put(r1.a());
        goto L7
    L12:
        JSONObject r10 = new JSONObject();
        r10.put("event", "sdk_stage");     // Catch: Throwable -> L20
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L20
        Iterator r11 = r8.entrySet().iterator();     // Catch: Throwable -> L20
    L15:
        if (r11.hasNext() == false) goto L17;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        r3.put(((EventStage) ZeusTransformUtils.preCheckCast(r4.getKey(), EventStage.class, "com.obric.memorydata.plugin")).toString(), r4.getValue());     // Catch: Throwable -> L20
        goto L15
    L17:
        r10.put(TrackerImpl.PARAMS, r3);     // Catch: Throwable -> L20
        r10.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L20
        r10.put("event_id", f.b());     // Catch: Throwable -> L20
        r10.put("datetime", f.d());     // Catch: Throwable -> L20
    L18:
        r7.put(r10);
    }

    public boolean a(String r3) {
        if (b() == false) goto L5;
        return true;
    L5:
        if (this.h.get() == true) goto L8;
        return true;
    L8:
        if (b(r3) == true) goto L10;
        return false;
    L10:
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(this.f.m().get(r3), Integer.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L13;
    L17:
        return false;
    L13:
        if (r2.intValue() <= 0) goto L17;
        return g.a(r2.intValue(), 10000);
    }

    public boolean b() {
        if (this.g == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f.l() == true) goto L8;
        return false;
    }

    public boolean b(String r2) {
        if (b() == false) goto L7;
        return true;
    L7:
        if (this.f.m() != null) goto L11;
        return false;
    L11:
        return this.f.m().containsKey(r2);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r3) {
        int r0 = r3.what;
        if (r0 != 4) goto L5;
        c();
        return false;
    L5:
        if (r0 != 8) goto L7;
        a((a) ZeusTransformUtils.preCheckCast(r3.obj, a.class, "com.obric.memorydata.plugin"));
        return false;
    L7:
        if (r0 != 12) goto L16;
        d();
        return false;
    L16:
        return false;
    }
}
