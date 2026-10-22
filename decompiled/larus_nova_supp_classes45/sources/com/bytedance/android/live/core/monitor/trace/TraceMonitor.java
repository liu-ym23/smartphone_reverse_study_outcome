package com.bytedance.android.live.core.monitor.trace;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.p1;
import com.bytedance.android.livesdk.monitor.trace.TraceEventSenderImpl;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task.AtlasSceneSensor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class TraceMonitor {
    public static volatile boolean a;
    public static volatile b60.b b;
    public static volatile c60.a c;
    public static final Object d = null;
    public static volatile List<a60.d> e;
    public static int f;
    public static volatile int g;
    public static volatile ExecutorService h;
    public static Handler i;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static volatile boolean l;
    public static volatile int m;
    public static volatile long n;
    public static final Lazy o = null;
    public static final Lazy p = null;
    public static final Lazy q = null;
    public static CopyOnWriteArrayList<a> r;

    public static final class a {
        public final e a;
        public final JSONObject b;
        public final JSONObject c;
        public final JSONObject d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L14;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            e r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            JSONObject r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            JSONObject r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            JSONObject r11 = this.d;
            if (r11 == null) goto L18;
            r1 = r11.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "MonitorData(traceMeta=" + this.a + ", category=" + this.b + ", metric=" + this.c + ", extra=" + this.d + ")";
        }

        public a(e r2, JSONObject r3) {
            Intrinsics.checkNotNullParameter(r2, "traceMeta");
            this.a = r2;
            this.b = null;
            this.c = null;
            this.d = r3;
        }
    }

    public static final class b implements Runnable {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            TraceMonitor.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ e a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ JSONObject d;

        public c(e r1, JSONObject r2, JSONObject r3, JSONObject r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean r0 = TraceMonitor.a;     // Catch: Throwable -> L4
            TraceMonitor.c(this.a, this.b, this.c, this.d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public TraceMonitor() {
    }

    static {
        d = new Object();
        e = new ArrayList();
        j = LazyKt.lazy(TraceMonitor$handlerThread$2.INSTANCE);
        k = LazyKt.lazy(TraceMonitor$azyncHandler$2.INSTANCE);
        o = LazyKt.lazy(TraceMonitor$traceMonitorSceneOpt$2.INSTANCE);
        p = LazyKt.lazy(TraceMonitor$enableUselessLoopOpt$2.INSTANCE);
        q = LazyKt.lazy(TraceMonitor$maxUselessLoopCount$2.INSTANCE);
    }

    public static final void a() {
        Object r2 = d;
        monitor-enter(r2);
        long r3 = e();     // Catch: Throwable -> L9
        if (r3 > 0) goto L11;
        l = false;     // Catch: Throwable -> L9
        ALogger.i("TraceClientMonitor", "stop delay send. maxCacheTime=" + r3);     // Catch: Throwable -> L9
        monitor-exit(r2);
        return;
    L11:
        long r4 = r3 * ((long) 1000);
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L9
        long r8 = r5 - n;     // Catch: Throwable -> L9
        boolean r1 = true;
        if (r8 < r4) goto L15;
        boolean r11 = true;
    L17:
        if (((Boolean) o.getValue()).booleanValue() == true) goto L19;
    L21:
        boolean r12 = false;
    L22:
        if (r11 == false) goto L34;
        if (r12 == true) goto L34;
        if ((!((ArrayList) e).isEmpty()) == false) goto L32;
        m = 0;     // Catch: Throwable -> L9
        List<a60.d> r13 = e;     // Catch: Throwable -> L9
        e = new ArrayList();     // Catch: Throwable -> L9
        b60.b r14 = b;     // Catch: Throwable -> L9
        if (r14 == null) goto L31;
        TraceEventSenderImpl r15 = r14.b();     // Catch: Throwable -> L9
        if (r15 == null) goto L31;
        r15.b(r13);     // Catch: Throwable -> L9
    L31:
        ALogger.i("TraceClientMonitor", "delay send " + ((ArrayList) r13).size() + " events. gap=" + r8 + "ms. maxCacheTime=" + r4 + "ms");     // Catch: Throwable -> L9
    L33:
        n = r5;     // Catch: Throwable -> L9
    L38:
        if (((Boolean) p.getValue()).booleanValue() == true) goto L40;
    L43:
        if (r1 == false) goto L47;
        Handler r0 = i;     // Catch: Throwable -> L9
        if (r0 == null) goto L48;
        r0.postDelayed(f.a, r4);     // Catch: Throwable -> L9
    L48:
        monitor-exit(r2);
        return;
    L47:
        m = 0;     // Catch: Throwable -> L9
        l = false;     // Catch: Throwable -> L9
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L9
        goto L48
    L40:
        if (m < ((Number) q.getValue()).intValue()) goto L43;
        r1 = false;
        goto L43
    L32:
        m++;     // Catch: Throwable -> L9
    L34:
        if (r12 == false) goto L36;
        n = r5;     // Catch: Throwable -> L9
        goto L38
    L36:
        m++;     // Catch: Throwable -> L9
        r4 = (n + r4) - r5;     // Catch: Throwable -> L9
        goto L38
    L19:
        if (AtlasSceneSensor.INSTANCE.isAtlasCoreScene() == false) goto L21;
        r12 = true;
        goto L22
    L15:
        r11 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public static a60.e f() {
        return LiveInfraSettingKeys.LIVE_TRACE_MONITOR_CONFIG.getValue();
    }

    public static void k() {
        CopyOnWriteArrayList<a> r0 = r;
        if (r0 == null) goto L10;
        Iterator<a> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        a r2 = r1.next();
        if (r2 == null) goto L6;
        ALogger.i("TraceClientMonitor", "report cache monitor: " + d(r2.a));
        i(r2.a, r2.b, r2.c, r2.d);
    L10:
        CopyOnWriteArrayList<a> r3 = r;
        if (r3 == null) goto L13;
        r3.clear();
    L13:
        r = null;
    }

    public static int e() {
        int r4 = -1;
        if (f().j() == 1) goto L10;
        boolean r0 = z50.a.a;
        a60.a r1 = f().b();
        if (r1 == null) goto L8;
        r4 = r1.b();
    L8:
        if (z50.a.a == false) goto L17;
        ALogger.d("LiveTraceScheduleAtomicAbility", "judgeScheduleTraceTime:" + z50.a.b);
        return z50.a.b;
    L17:
        return r4;
    L10:
        boolean r2 = z50.a.a;
        a60.b r3 = f().c();
        if (r3 == null) goto L14;
        r4 = r3.a();
    L14:
        if (z50.a.a == false) goto L19;
        ALogger.d("LiveTraceScheduleAtomicAbility", "judgeScheduleTraceTime:" + z50.a.b);
        return z50.a.b;
    L19:
        return r4;
    }

    public static boolean b(a60.d r5) {
        if (f().h() > 0) goto L5;
        return false;
    L5:
        Object r1 = d;
        monitor-enter(r1);
        String r3 = d60.a.a(CollectionsKt.listOf(r5)).toString();     // Catch: Throwable -> L20
        Charset r4 = Charsets.UTF_8;     // Catch: Throwable -> L20
        if (r3 == null) goto L19;
        int r6 = r3.getBytes(r4).length;     // Catch: Throwable -> L20
        r5.e = r6;     // Catch: Throwable -> L20
        if (r6 <= f().h()) goto L15;
        ALogger.i("TraceMonitor", "trace size = " + r6 + " drop!!");     // Catch: Throwable -> L20
        monitor-exit(r1);
        return true;
    L15:
        f += r6;     // Catch: Throwable -> L20
        monitor-exit(r1);
        return false;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public static String d(e r2) {
        return "productId=" + r2.e + " businessType=" + r2.b + " eventType=" + r2.a + " traceId=" + r2.c + " step=" + r2.f + " logId=" + r2.d;
    }

    @JvmStatic
    public static final void g(com.bytedance.android.livesdk.monitor.trace.a r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Object r0 = d;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (a == true) goto L7;
        b = r2;     // Catch: Throwable -> L10
        c = new c60.a();     // Catch: Throwable -> L10
        g = r2.getConfig().k();     // Catch: Throwable -> L10
        l = false;     // Catch: Throwable -> L10
        h = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("/TraceMonitor"));     // Catch: Throwable -> L10
        i = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L10
        a = true;     // Catch: Throwable -> L10
        k();     // Catch: Throwable -> L10
    L7:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }

    @JvmStatic
    public static final void h(e r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "traceMeta");
        i(r1, null, null, r2);
    }

    public static void j(e r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "traceMeta");
        Intrinsics.checkNotNullParameter(r3, "traceMeta");
        if (a == true) goto L10;
        ALogger.i("TraceClientMonitor", "init false, monitor event before init. " + d(r3));
        if (r != null) goto L7;
        r = new CopyOnWriteArrayList();
    L7:
        CopyOnWriteArrayList<a> r0 = r;
        if (r0 == null) goto L12;
        r0.add(new a(r3, r4));
        return;
    L12:
        return;
    L10:
        ALogger.i("TraceClientMonitor", "init true, report: " + d(r3));
        i(r3, null, null, r4);
    }

    public static void c(e r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        String r0 = r11.a;
        if (com.bytedance.android.live.core.monitor.trace.a.a != null) goto L5;
        com.bytedance.android.live.core.monitor.trace.a.a = (com.bytedance.android.live.core.monitor.trace.a.C0144a) p1.a.getValue();
    L5:
        com.bytedance.android.live.core.monitor.trace.a.C0144a r1 = com.bytedance.android.live.core.monitor.trace.a.a;
        if (r1 != null) goto L8;
    L40:
        b60.b r2 = b;
        if (r2 != null) goto L43;
        return;
    L43:
        a60.e r3 = r2.getConfig();
        if (r3.e() == true) goto L46;
        return;
    L46:
        com.bytedance.android.livesdk.monitor.trace.a.b r4 = r2.a();
        if (r4 == null) goto L49;
        r4.a(r11);
    L49:
        if (r14 != null) goto L51;
        r14 = new JSONObject();
    L51:
        d60.b.a(r14, "timestamp", Long.valueOf(System.currentTimeMillis()));
        a60.d r5 = new a60.d(r11, r12, r13, r14);
        c60.a r15 = c;
        if (r15 != null) goto L54;
    L56:
        r2.c();
        if (b(r5) == false) goto L59;
        return;
    L59:
        int r16 = r3.k();
        List<a60.d> r17 = null;
        if (r16 == 0) goto L116;
        if (r16 != 1) goto L161;
        a60.a r18 = r3.b();
        a60.b r19 = r3.c();
        if (g != 1) goto L68;
        if (l == false) goto L68;
    L87:
        Object r6 = d;
        monitor-enter(r6);
        ((ArrayList) e).add(r5);     // Catch: Throwable -> L112
        if (f().j() == 0) goto L97;
        int r110 = f;     // Catch: Throwable -> L112
        if (r19 == null) goto L94;
        int r111 = r19.b();     // Catch: Throwable -> L112
    L95:
        if (r110 < r111) goto L103;
        List<a60.d> r112 = e;     // Catch: Throwable -> L112
        e = new ArrayList();     // Catch: Throwable -> L112
        n = System.currentTimeMillis();     // Catch: Throwable -> L112
        ALogger.i("TraceClientMonitor", "batch send trace data");     // Catch: Throwable -> L112
    L104:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L112
        monitor-exit(r6);
        if (r112 != null) goto L108;
        return;
    L108:
        if ((!r112.isEmpty()) == false) goto L110;
        r17 = r112;
    L110:
        if (r17 == null) goto L159;
        f = 0;
        r2.b().b(r17);
        ALogger.i("TraceClientMonitor", "batch send " + r17.size() + " events");
        return;
    L159:
        return;
    L103:
        r112 = null;
        goto L104
    L94:
        r111 = 0;
        goto L95
    L97:
        int r114 = ((ArrayList) e).size();     // Catch: Throwable -> L112
        if (r18 == null) goto L100;
        int r115 = r18.a();     // Catch: Throwable -> L112
    L101:
        if (r114 < r115) goto L103;
        r112 = e;     // Catch: Throwable -> L112
        e = new ArrayList();     // Catch: Throwable -> L112
        n = System.currentTimeMillis();     // Catch: Throwable -> L112
        goto L104
    L100:
        r115 = 0;
    L112:
        th = move-exception;
        throw th;
    L68:
        if (e() <= 0) goto L87;
        Object r7 = d;
        monitor-enter(r7);
    L84:
        th = move-exception;
        throw th;
    L72:
        if (g != 1) goto L76;
        if (l == false) goto L76;
    L81:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L84
        monitor-exit(r7);
    L76:
        if (e() <= 0) goto L81;
        ALogger.i("TraceClientMonitor", "switch from REAL_TIME to BATCH");     // Catch: Throwable -> L84
        g = 1;     // Catch: Throwable -> L84
        int r9 = e();     // Catch: Throwable -> L84
        Handler r21 = i;     // Catch: Throwable -> L84
        if (r21 == null) goto L80;
        r21.postDelayed(b.a, ((long) r9) * 1000);     // Catch: Throwable -> L84
    L80:
        l = true;     // Catch: Throwable -> L84
        goto L81
    L161:
        return;
    L116:
        if (g != 1) goto L137;
        Object r116 = d;
        monitor-enter(r116);
    L134:
        th = move-exception;
        throw th;
    L120:
        if (g != 1) goto L125;
        ALogger.i("TraceClientMonitor", "switch from BATCH to REAL_TIME");     // Catch: Throwable -> L134
        Handler r117 = i;     // Catch: Throwable -> L134
        if (r117 == null) goto L124;
        r117.removeCallbacksAndMessages(null);     // Catch: Throwable -> L134
    L124:
        List<a60.d> r118 = e;     // Catch: Throwable -> L134
        e = new ArrayList();     // Catch: Throwable -> L134
        n = System.currentTimeMillis();     // Catch: Throwable -> L134
        g = 0;     // Catch: Throwable -> L134
    L126:
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L134
        monitor-exit(r116);
        if (r118 == null) goto L137;
        if ((!r118.isEmpty()) == false) goto L132;
        r17 = r118;
    L132:
        if (r17 == null) goto L137;
        r2.b().b(r17);
        goto L137
    L125:
        r118 = null;
    L137:
        r2.b().b(CollectionsKt.listOf(r5));
        return;
    L54:
        if (r15.b(r5, r2) == true) goto L56;
        return;
    L8:
        if (r1.enable == false) goto L40;
        if (TextUtils.isEmpty(r0) == true) goto L40;
        if (com.bytedance.android.live.core.monitor.trace.a.c.containsKey(r0) == true) goto L40;
        ConcurrentHashMap<String, Integer> r22 = com.bytedance.android.live.core.monitor.trace.a.b;
        Integer r23 = r22.get(r0);
        if (r23 != null) goto L19;
        r22.put(r0, 1);
    L20:
        long r24 = SystemClock.uptimeMillis();
        if (com.bytedance.android.live.core.monitor.trace.a.d != 0) goto L23;
        com.bytedance.android.live.core.monitor.trace.a.d = r24;
        goto L40
    L23:
        long r25 = r24 - com.bytedance.android.live.core.monitor.trace.a.d;
        if (r25 < r1.a()) goto L40;
        int r26 = (int) (r1.frequencyThreshold * (r25 / 60000.0f));
        HashMap r27 = new HashMap();
        Iterator<Map.Entry<String, Integer>> r28 = r22.entrySet().iterator();
    L28:
        if (r28.hasNext() == false) goto L32;
        Map.Entry<String, Integer> r29 = r28.next();
        if (r29.getValue().intValue() < r26) goto L28;
        com.bytedance.android.live.core.monitor.trace.a.c.put(r29.getKey(), Boolean.TRUE);
        r27.put(r29.getKey(), r29.getValue());
        goto L28
    L32:
        com.bytedance.android.live.core.monitor.trace.a.b.clear();
        com.bytedance.android.live.core.monitor.trace.a.d = SystemClock.uptimeMillis();
        Iterator r31 = r27.entrySet().iterator();
    L34:
        if (r31.hasNext() == false) goto L40;
        Map.Entry r32 = (Map.Entry) r31.next();
        String r33 = (String) r32.getKey();
        JSONObject r34 = new JSONObject();
        r34.put("type", "trace_too_frequent");     // Catch: JSONException -> L139
        r34.put("event_type", r33);     // Catch: JSONException -> L139
    L37:
        int r35 = ((Integer) r32.getValue()).intValue();
        JSONObject r36 = new JSONObject();
        r36.put("count_per_minute", r35);     // Catch: JSONException -> L140
    L39:
        LiveTracingMonitor.i("ttlive_trace_metrics", r34, r36, new JSONObject());
        goto L34
    L19:
        r22.put(r0, Integer.valueOf(r23.intValue() + 1));
        goto L20
    }

    @JvmStatic
    public static final void i(e r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "traceMeta");
        if (a == true) goto L6;
        ALogger.i("TraceClientMonitor", "monitor event before init. " + d(r2));
        return;
    L6:
        b60.b r0 = b;
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.getConfig().a() == false) goto L12;
        ((Handler) k.getValue()).post(new c(r2, r3, r4, r5));
        return;
    L12:
        c(r2, r3, r4, r5);
    }
}
