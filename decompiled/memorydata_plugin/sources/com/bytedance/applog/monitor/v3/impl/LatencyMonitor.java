package com.bytedance.applog.monitor.v3.impl;

import android.util.Pair;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.applog.monitor.v3.f;
import com.bytedance.crash.constants.Constants;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LatencyMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, a> f1705b;
    private com.bytedance.applog.monitor.v3.b c;

    /* JADX INFO: renamed from: com.bytedance.applog.monitor.v3.impl.LatencyMonitor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final enum EventLatencyScope extends Enum<EventLatencyScope> {
        private static final /* synthetic */ EventLatencyScope[] $VALUES = null;
        public static final EventLatencyScope l_0_1 = null;
        public static final EventLatencyScope l_0_60 = null;
        public static final EventLatencyScope l_10_20 = null;
        public static final EventLatencyScope l_120_ = null;
        public static final EventLatencyScope l_1_10 = null;
        public static final EventLatencyScope l_20_30 = null;
        public static final EventLatencyScope l_30_40 = null;
        public static final EventLatencyScope l_40_50 = null;
        public static final EventLatencyScope l_50_60 = null;
        public static final EventLatencyScope l_60_120 = null;

        static {
            EventLatencyScope r0 = new EventLatencyScope("l_0_60", 0);
            l_0_60 = r0;
            EventLatencyScope r1 = new EventLatencyScope("l_0_1", 1);
            l_0_1 = r1;
            EventLatencyScope r3 = new EventLatencyScope("l_1_10", 2);
            l_1_10 = r3;
            EventLatencyScope r5 = new EventLatencyScope("l_10_20", 3);
            l_10_20 = r5;
            EventLatencyScope r7 = new EventLatencyScope("l_20_30", 4);
            l_20_30 = r7;
            EventLatencyScope r9 = new EventLatencyScope("l_30_40", 5);
            l_30_40 = r9;
            EventLatencyScope r11 = new EventLatencyScope("l_40_50", 6);
            l_40_50 = r11;
            EventLatencyScope r13 = new EventLatencyScope("l_50_60", 7);
            l_50_60 = r13;
            EventLatencyScope r15 = new EventLatencyScope("l_60_120", 8);
            l_60_120 = r15;
            EventLatencyScope r14 = new EventLatencyScope("l_120_", 9);
            l_120_ = r14;
            $VALUES = new EventLatencyScope[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        }

        private EventLatencyScope(String r1, int r2) {
            super(r1, r2);
        }

        public static EventLatencyScope valueOf(String r2) {
            return (EventLatencyScope) ZeusTransformUtils.preCheckCast(Enum.valueOf(EventLatencyScope.class, r2), EventLatencyScope.class, "com.obric.memorydata.plugin");
        }

        public static EventLatencyScope[] values() {
            return (EventLatencyScope[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EventLatencyScope[].class, "com.obric.memorydata.plugin");
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1707b;
        StageEventType c;
        EventLatencyScope d;

        private a() {
            this.f1706a = 0;
            this.f1707b = -1;
            this.c = StageEventType.V3_EVENT;
            this.d = EventLatencyScope.l_0_60;
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        public JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put("event", "sdk_event_latency");     // Catch: Throwable -> L5
            JSONObject r1 = new JSONObject();     // Catch: Throwable -> L5
            r1.put("stage", 2);     // Catch: Throwable -> L5
            r1.put("event_priority", this.f1707b);     // Catch: Throwable -> L5
            r1.put(Constants.EVENT_TYPE, this.c.getLabel());     // Catch: Throwable -> L5
            r1.put("interval_scope", this.d.toString());     // Catch: Throwable -> L5
            r1.put("event_count", this.f1706a);     // Catch: Throwable -> L5
            r0.put(TrackerImpl.PARAMS, r1);     // Catch: Throwable -> L5
            r0.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L5
            r0.put("event_id", f.b());     // Catch: Throwable -> L5
            r0.put("datetime", f.d());     // Catch: Throwable -> L5
        L4:
            return r0;
        }

        public long b() {
            return 231;
        }
    }

    public LatencyMonitor(com.bytedance.applog.monitor.v3.b r2) {
        this.f1704a = true;
        this.f1705b = new ConcurrentHashMap();
        this.c = r2;
    }

    private EventLatencyScope a(int r1) {
        if (r1 > 1) goto L7;
        return EventLatencyScope.l_0_1;
    L7:
        if (r1 > 10) goto L11;
        return EventLatencyScope.l_1_10;
    L11:
        if (r1 > 20) goto L15;
        return EventLatencyScope.l_10_20;
    L15:
        if (r1 > 30) goto L19;
        return EventLatencyScope.l_20_30;
    L19:
        if (r1 > 40) goto L23;
        return EventLatencyScope.l_30_40;
    L23:
        if (r1 > 50) goto L27;
        return EventLatencyScope.l_40_50;
    L27:
        if (r1 > 60) goto L31;
        return EventLatencyScope.l_50_60;
    L31:
        if (r1 > 120) goto L35;
        return EventLatencyScope.l_60_120;
    L35:
        return EventLatencyScope.l_120_;
    }

    public Pair<Map<String, JSONObject>, Long> a(long r8) {
        if (this.f1704a == false) goto L23;
        if (this.f1705b.isEmpty() == true) goto L23;
        HashMap r0 = new HashMap();
        Map<String, a> r1 = this.f1705b;
        monitor-enter(r1);
        Iterator<String> r2 = this.f1705b.keySet().iterator();     // Catch: Throwable -> L19
    L11:
        if (r2.hasNext() == false) goto L16;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.f1705b.remove(r3), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r4 == null) goto L11;
        r0.put(r3, r4.a());     // Catch: Throwable -> L19
        r8 = r8 - r4.b();     // Catch: Throwable -> L19
        if (r8 > 0) goto L11;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L19
        return new Pair(r0, Long.valueOf(r8));
    L19:
        th = move-exception;
        throw th;
    L23:
        return new Pair(null, Long.valueOf(r8));
    }

    public void a() {
        this.f1704a = false;
    }

    public void a(int r6, StageEventType r7, int r8) {
        EventLatencyScope r9 = a(r8);
        String r0 = r6 + "_" + r7.toString() + "_" + r9.toString();
        Map<String, a> r1 = this.f1705b;
        monitor-enter(r1);
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.f1705b.get(r0), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r2 != null) goto L7;
        r2 = new a(null);     // Catch: Throwable -> L10
        r2.d = r9;     // Catch: Throwable -> L10
        r2.c = r7;     // Catch: Throwable -> L10
        r2.f1707b = r6;     // Catch: Throwable -> L10
        this.f1705b.put(r0, r2);     // Catch: Throwable -> L10
    L7:
        r2.f1706a++;     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void a(Map<String, JSONObject> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
    }

    public void a(Map<String, JSONObject> r3, JSONArray r4) {
        Iterator r2 = ((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin")).values().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r4.put((JSONObject) ZeusTransformUtils.preCheckCast(r2.next(), JSONObject.class, "com.obric.memorydata.plugin"));
        goto L4
    }
}
