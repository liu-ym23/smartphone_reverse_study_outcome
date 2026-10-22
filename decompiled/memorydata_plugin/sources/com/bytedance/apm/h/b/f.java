package com.bytedance.apm.h.b;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.m;
import com.bytedance.apm.util.v;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.commonevent.model.GeneralLegacyEvent;
import com.bytedance.apm6.util.cache.LimitedQueue;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends com.bytedance.apm.h.a {
    private static int l = 0;
    private static int m = 1;
    private static int n = 2;
    private static String p = "bg_never_front";
    private static com.bytedance.apm.d.g w;
    private static LimitedQueue<GeneralLegacyEvent> x;
    private static LimitedQueue<String> y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1346b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long h;
    private long i;
    private long j;
    private long k;
    private int o;
    private long q;
    private Map<String, m<Long, Long>> r;
    private Map<String, m<Long, Long>> s;
    private Map<String, m<Long, Long>> t;
    private long u;
    private g v;
    private JSONObject z;

    /* JADX INFO: renamed from: com.bytedance.apm.h.b.f$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f1348b;
        final /* synthetic */ f c;

        @Override // java.lang.Runnable
        public void run() {
            if (f.a(this.c) != null) goto L5;
            f.a(this.c, new HashMap());
        L5:
            long r0 = System.currentTimeMillis();
            f.a(this.c).put(this.f1347a, new m(Long.valueOf(r0), Long.valueOf(f.b(this.c).l())));
            if (f.c(this.c) != null) goto L8;
            f.b(this.c, new HashMap());
        L8:
            f.c(this.c).put(this.f1347a, new m(Long.valueOf(r0), Long.valueOf(f.b(this.c).c())));
            if (f.d(this.c) != null) goto L11;
            f.c(this.c, new HashMap());
        L11:
            f.d(this.c).put(this.f1347a, new m(Long.valueOf(r0), Long.valueOf(f.b(this.c).b())));
            if (this.f1348b == false) goto L15;
            com.bytedance.apm.h.b.a.a().a(this.f1347a);
            return;
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f1349a = null;

        static {
            f1349a = new f(null);
        }

        static /* synthetic */ f a() {
            return f1349a;
        }
    }

    static {
        x = new LimitedQueue(20);
        y = new LimitedQueue(20);
    }

    private f() {
        this.f1345a = 500000000;
        this.f1346b = 0;
        this.c = 1;
        this.d = -1;
        this.e = 0;
        this.f = 0;
        this.h = 0;
        this.i = 0;
        this.k = 0;
        this.o = l;
        this.g = "traffic";
        g r0 = g.a();
        this.v = r0;
        r0.a(l());
    }

    /* synthetic */ f(AnonymousClass1 r1) {
        this();
    }

    public static f a() {
        return a.a();
    }

    static /* synthetic */ Map a(f r0) {
        return r0.r;
    }

    static /* synthetic */ Map a(f r2, Map r3) {
        Map<String, m<Long, Long>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        r2.r = r4;
        return r4;
    }

    private JSONArray a(Map<String, com.bytedance.apm.h.b.a.C0090a> r6, String r7, JSONArray r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
    L17:
        return null;
    L5:
        if (r9.size() == 0) goto L17;
        Iterator r10 = r9.entrySet().iterator();     // Catch: Exception -> L18
    L9:
        if (r10.hasNext() == false) goto L16;
        JSONObject r2 = ((com.bytedance.apm.h.b.a.C0090a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), com.bytedance.apm.h.b.a.C0090a.class, "com.obric.memorydata.plugin")).a(this.f1346b);     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r7) == true) goto L14;
        r2.put("traffic_category", r7);     // Catch: Exception -> L18
    L14:
        r8.put(r2);     // Catch: Exception -> L18
        goto L9
    L16:
        return r8;
    }

    static /* synthetic */ g b(f r0) {
        return r0.v;
    }

    static /* synthetic */ Map b(f r2, Map r3) {
        Map<String, m<Long, Long>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        r2.s = r4;
        return r4;
    }

    static /* synthetic */ Map c(f r0) {
        return r0.s;
    }

    static /* synthetic */ Map c(f r2, Map r3) {
        Map<String, m<Long, Long>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        r2.t = r4;
        return r4;
    }

    static /* synthetic */ Map d(f r0) {
        return r0.t;
    }

    @Override // com.bytedance.apm.h.a, com.bytedance.services.apm.api.d
    public void a(Activity r3) {
        super.a((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
        this.v.a(true);
    }

    @Override // com.bytedance.apm.h.a
    public void a(JSONObject r8) {
        super.a(r8);
        if (r8.optInt("cause_analysis", 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        com.bytedance.apm.h.b.a.a().b();
        this.f1345a = (r8.optInt("exception_threshold_mb", 500) * 1000) * 1000;
        this.c = (r8.optInt("exception_threshold_bg_mb", 500) * 1000) * 1000;
        this.q = r8.optInt("high_freq_threshold", 200);
        com.bytedance.apm.h.b.a.a().a((r8.optDouble("large_usage_threshold_mb", 10.0d) * 1000.0d) * 1000.0d);
        com.bytedance.apm.h.b.a.a().b(r8.optDouble("alog_record_threshold", 100.0d));
    L8:
        this.f1346b = r8.optLong("record_usage_kb", 1) * 1024;
        boolean r1 = com.bytedance.apm.j.c.d(this.g);
    L10:
        if (x.isEmpty() == true) goto L30;
        GeneralLegacyEvent r3 = (GeneralLegacyEvent) ZeusTransformUtils.preCheckCast(x.pop(), GeneralLegacyEvent.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(y.pop(), String.class, "com.obric.memorydata.plugin");
        if (r1 == false) goto L14;
    L19:
        CommonEventDeliverer.monitorLegacyEvent(r3);
    L21:
        if (com.bytedance.apm.b.k() == false) goto L10;
        String[] r5 = new String[1];
        StringBuilder r6 = new StringBuilder().append("isSample:key:");
        if (r1 == false) goto L25;
    L28:
        boolean r7 = true;
    L29:
        r5[0] = r6.append(r7).toString();
        com.bytedance.apm.e.e.d("Traffic", r5);
        goto L10
    L25:
        if (r8.optInt(r4, 0) == 1) goto L28;
        r7 = false;
        goto L29
    L14:
        if (r8.optInt(r4, 0) == 1) goto L19;
        if (com.bytedance.apm.b.k() == false) goto L21;
        com.bytedance.apm.doctor.a.a(r3.getLogType(), r3.getLogJson(), false);
        goto L21
    L30:
        this.z = r8;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.apm.h.a
    public void b() {
        SharedPreferences r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("traffic_monitor_info", 0);
        long r8 = r4.getLong(CommonConsts.APM_INNER_EVENT_COST_INIT, -1);
        long r13 = r4.getLong("init_ts", 0);
        if (r8 <= (-1)) goto L22;
        long r0 = r4.getLong("usage", 0);
        long r6 = r4.getLong("usage_ts", 0);
        long r2 = r0 - r8;
        if (r2 > 0) goto L29;
    L21:
        f r3 = this;
        String r5 = "usage";
    L23:
        r3.k = r3.v.l();
        SharedPreferences.Editor r1 = r4.edit();
        r1.putLong(CommonConsts.APM_INNER_EVENT_COST_INIT, r3.k);
        r1.putLong("init_ts", System.currentTimeMillis());
        r1.putLong(r5, 0);
        r1.apply();
        return;
    L29:
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L26
        r11.put("total_usage", r2);     // Catch: JSONException -> L26
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L26
        r12.put("total_usage_duration", ((r6 - r13) / 1000) / 60);     // Catch: JSONException -> L26
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L26
        r7.put("init_ts", r13);     // Catch: JSONException -> L26
        r7.put("usage_ts", r6);     // Catch: JSONException -> L26
        r7.put("biz_usage", r4.getLong("biz_usage", 0));     // Catch: JSONException -> L26
        r7.put(CommonConsts.APM_INNER_EVENT_COST_INIT, r8);     // Catch: JSONException -> L26
        r5 = "usage";
        r7.put(r5, r0);     // Catch: JSONException -> L20
        String r9 = r4.getString("biz_json", "");     // Catch: JSONException -> L20
        if (r9 == "") goto L11;
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L20
        r10.put(r5, new JSONArray(r9));     // Catch: JSONException -> L20
        r7.put(MemoryListActivity.JUMP_FROM_DETAIL, r10);     // Catch: JSONException -> L20
    L11:
        com.bytedance.apm.data.a.e r14 = new com.bytedance.apm.data.a.e();     // Catch: JSONException -> L20
        r3 = this;
        r14.a(r3.g).b(r11).c(r12).e(r7);     // Catch: JSONException -> L25
        com.bytedance.apm.e.a.c("APM-Traffic-Detail ", "Init");     // Catch: JSONException -> L25
        if (com.bytedance.apm.e.a.a() == false) goto L16;
        com.bytedance.apm.e.a.c("APM-Traffic-Detail ", JsonUtils.c(r14.a()).toString());     // Catch: JSONException -> L25
    L16:
        r3.a(r14);     // Catch: JSONException -> L25
        com.bytedance.apm.d.g r15 = w;     // Catch: JSONException -> L25
        if (r15 == null) goto L23;
        r15.a(r2);     // Catch: JSONException -> L25
    L20:
        r3 = this;
        goto L23
    L22:
        r3 = this;
        r5 = "usage";
        goto L23
    }

    @Override // com.bytedance.apm.h.a, com.bytedance.services.apm.api.d
    public void b(Activity r3) {
        super.b((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
        p = "bg_ever_front";
        this.v.a(false);
    }

    @Override // com.bytedance.apm.h.a
    public boolean c() {
        return true;
    }

    @Override // com.bytedance.apm.h.a
    public long d() {
        return 600000;
    }

    @Override // com.bytedance.apm.h.a
    public void e() {
        super.e();
        if (l() == true) goto L5;
        p = "bg_ever_front";
    L5:
        long r6 = System.currentTimeMillis();
        long r8 = this.v.l();
        long r10 = this.v.i();
        long r12 = this.v.h();
        long r14 = this.v.k();
        String r16 = "com.obric.memorydata.plugin";
        String r17 = "usage_ts";
        String r18 = "APM-Traffic-Detail ";
        long r2 = this.v.j();
        if (this.d != (-1)) goto L9;
        this.d = r8;
        this.e = r10;
        this.f = r12;
        this.h = r14;
        this.i = r2;
        this.j = r6;
        return;
    L9:
        JSONArray r4 = new JSONArray();
        long r5 = r8 - this.d;
        long r7 = r10 - this.e;
        long r9 = r12 - this.f;
        long r11 = r14 - this.h;
        long r13 = r2 - this.i;
        long r15 = this.f1345a;
        if (r15 > 0) goto L12;
    L15:
        long r19 = this.c;
        if (r19 > 0) goto L18;
    L23:
        v<h> r110 = com.bytedance.apm.h.b.a.a().d();
        if (r110 == null) goto L29;
        if (r110.b() <= 0) goto L29;
        r4.put("large_request");
    L29:
        if (c.a().d() <= this.q) goto L31;
        r4.put("high_feq_request");
    L31:
        this.d = r8;
        this.i = r2;
        this.h = r14;
        this.e = r10;
        this.f = r12;
        JSONArray r3 = new JSONArray();
        com.bytedance.apm.j.c.d(this.g);
        a(com.bytedance.apm.h.b.a.a().e(), "usage_10_minutes", r3);
        a(com.bytedance.apm.h.b.a.a().h(), "wifi_front", r3);
        a(com.bytedance.apm.h.b.a.a().i(), "wifi_back", r3);
        a(com.bytedance.apm.h.b.a.a().g(), "mobile_front", r3);
        a(com.bytedance.apm.h.b.a.a().f(), "mobile_back", r3);
        JSONObject r20 = new JSONObject();
        if (r3.length() > 0) goto L131;
    L125:
        JSONObject r21 = new JSONObject();     // Catch: JSONException -> L99
        r21.put("usage_10_minutes", r5);     // Catch: JSONException -> L99
        r21.put("mobile_back", r7);     // Catch: JSONException -> L99
        r21.put("mobile_front", r9);     // Catch: JSONException -> L99
        r21.put("wifi_back", r11);     // Catch: JSONException -> L98
        String r36 = "usage";
        r21.put("wifi_front", r13);     // Catch: JSONException -> L97
        com.bytedance.apm.d.g r22 = w;     // Catch: JSONException -> L97
        if (r22 == null) goto L41;
        r22.a(r5, r11, r13, r7, r9);     // Catch: JSONException -> L97
    L41:
        JSONObject r23 = new JSONObject();     // Catch: JSONException -> L97
        com.bytedance.apm.data.a.e r24 = new com.bytedance.apm.data.a.e();     // Catch: JSONException -> L97
        JSONObject r25 = new JSONObject();     // Catch: JSONException -> L97
        r25.put(MemoryListActivity.JUMP_FROM_DETAIL, r20);     // Catch: JSONException -> L97
        String r111 = "biz_usage";
        r25.put(r111, com.bytedance.apm.h.b.a.a().j());     // Catch: JSONException -> L122
        r25.put("init_ts", this.j);     // Catch: JSONException -> L122
        String r112 = r17;
        r25.put(r112, r6);     // Catch: JSONException -> L96
        r24.a(this.g).c(r23).b(r21).e(r25);     // Catch: JSONException -> L96
        if (com.bytedance.apm.e.a.a() == false) goto L50;
        String r113 = r18;
        com.bytedance.apm.e.a.c(r113, JsonUtils.c(r24.a()).toString());     // Catch: JSONException -> L121
    L51:
        a(r24);     // Catch: JSONException -> L121
        this.j = r6;     // Catch: JSONException -> L121
        if (r4.length() <= 0) goto L93;
        JSONObject r26 = new JSONObject();     // Catch: JSONException -> L121
        r26.put(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, true);     // Catch: JSONException -> L121
        r26.put(ApiPerfDetails.exceptionType, r4);     // Catch: JSONException -> L121
        Map<String, h> r27 = c.a().c();     // Catch: JSONException -> L121
        if (r27 == null) goto L72;
        Iterator<Map.Entry<String, h>> r28 = r27.entrySet().iterator();     // Catch: JSONException -> L121
        JSONArray r29 = new JSONArray();     // Catch: JSONException -> L121
    L57:
        if (r28.hasNext() == false) goto L68;
        String r114 = r16;
        Map.Entry r115 = (Map.Entry) ZeusTransformUtils.preCheckCast(r28.next(), Map.Entry.class, r114);     // Catch: JSONException -> L67
        Iterator<Map.Entry<String, h>> r116 = r28;
        r17 = r112;
        r18 = r113;
        JSONObject r117 = r23;
        if (((h) ZeusTransformUtils.preCheckCast(r115.getValue(), h.class, r114)).d <= this.q) goto L66;
        JSONObject r30 = new JSONObject();     // Catch: JSONException -> L118
        r30.put("path", ((h) ZeusTransformUtils.preCheckCast(r115.getValue(), h.class, r114)).f1352a);     // Catch: JSONException -> L118
        r30.put("freq", ((h) ZeusTransformUtils.preCheckCast(r115.getValue(), h.class, r114)).d);     // Catch: JSONException -> L118
        r30.put("biz", ((h) ZeusTransformUtils.preCheckCast(r115.getValue(), h.class, r114)).f1353b);     // Catch: JSONException -> L118
        r29.put(r30);     // Catch: JSONException -> L118
    L66:
        r23 = r117;
        r28 = r116;
        r112 = r17;
        r113 = r18;
        r16 = r114;
    L95:
        String r31 = r36;
    L101:
        SharedPreferences.Editor r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), r114), Context.class, r114)).getSharedPreferences("traffic_monitor_info", 0).edit();
        r1.putLong(r31, r8);
        long r32 = this.u + com.bytedance.apm.h.b.a.a().j();
        this.u = r32;
        r1.putLong(r111, r32);
        r1.putLong(r17, System.currentTimeMillis());
        Map<String, com.bytedance.apm.h.b.a.C0090a> r33 = com.bytedance.apm.h.b.a.a().c();
        if (r33 != null) goto L104;
    L112:
        r1.apply();
        if (com.bytedance.apm.b.k() == false) goto L115;
        String r34 = r18;
        Log.d(r34, "traffic since app boot: " + (r8 - this.k));
        Log.d(r34, "traffic stats from biz (include ttnet/ok/httpurl plus trafficStats): " + com.bytedance.apm.h.b.a.a().j());
    L115:
        com.bytedance.apm.h.b.a.a().k();
        c.a().b();
        return;
    L104:
        if (r33.size() <= 0) goto L112;
        JSONArray r35 = new JSONArray();
        Iterator<Map.Entry<String, com.bytedance.apm.h.b.a.C0090a>> r37 = r33.entrySet().iterator();
    L107:
        if (r37.hasNext() == false) goto L111;
        JSONObject r38 = ((com.bytedance.apm.h.b.a.C0090a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r37.next(), Map.Entry.class, r114)).getValue(), com.bytedance.apm.h.b.a.C0090a.class, r114)).a();
        r38.put("traffic_category", "total_usage");     // Catch: Exception -> L120
    L110:
        r35.put(r38);
        goto L107
    L111:
        r1.putString("biz_json", r35.toString());
    L67:
        r17 = r112;
        r18 = r113;
        goto L95
    L68:
        JSONObject r118 = r23;
        r17 = r112;
        r18 = r113;
        r114 = r16;
        if (com.bytedance.apm.e.a.a() == false) goto L71;
        com.bytedance.apm.e.a.c("TrafficHighTreq", r29.toString());     // Catch: JSONException -> L118
    L71:
        r20.put("high_freq", r29);     // Catch: JSONException -> L118
    L73:
        if (r110 == null) goto L87;
        List<E> r39 = r110.a();     // Catch: JSONException -> L118
        if (r39 == 0) goto L87;
        if (r39.size() <= 0) goto L87;
        JSONArray r40 = new JSONArray();     // Catch: JSONException -> L118
        Iterator r41 = r39.iterator();     // Catch: JSONException -> L118
    L79:
        if (r41.hasNext() == false) goto L84;
        h r42 = (h) ZeusTransformUtils.preCheckCast(r41.next(), h.class, r114);     // Catch: JSONException -> L118
        JSONObject r119 = new JSONObject();     // Catch: JSONException -> L118
        r119.put("path", r42.f1352a);     // Catch: JSONException -> L118
        Iterator r120 = r41;
        r31 = r36;
        r119.put(r31, r42.c);     // Catch: JSONException -> L119
        r119.put("biz", r42.f1353b);     // Catch: JSONException -> L119
        r40.put(r119);     // Catch: JSONException -> L119
        r36 = r31;
        r41 = r120;
        goto L79
    L84:
        r31 = r36;
        r20.put("large_usage", r40);     // Catch: JSONException -> L119
        if (com.bytedance.apm.e.a.a() == false) goto L88;
        com.bytedance.apm.e.a.c("TrafficTopK", r40.toString());     // Catch: JSONException -> L119
    L88:
        r26.put(r111, com.bytedance.apm.h.b.a.a().j());     // Catch: JSONException -> L119
        if (com.bytedance.apm.e.a.a() == false) goto L91;
        com.bytedance.apm.e.a.c("TrafficException", r26.toString());     // Catch: JSONException -> L119
    L91:
        r26.put(MemoryListActivity.JUMP_FROM_DETAIL, r20);     // Catch: JSONException -> L119
        com.bytedance.apm.data.a.e r43 = new com.bytedance.apm.data.a.e();     // Catch: JSONException -> L119
        r43.a(this.g).c(r118).b(r21).e(r26);     // Catch: JSONException -> L119
        a(r43);     // Catch: JSONException -> L119
    L87:
        r31 = r36;
        goto L88
    L72:
        r118 = r23;
        r17 = r112;
        r18 = r113;
        r114 = r16;
    L93:
        r17 = r112;
        r18 = r113;
        goto L94
    L50:
        r113 = r18;
    L96:
        r17 = r112;
    L94:
        r114 = r16;
    L97:
        r114 = r16;
        r111 = "biz_usage";
    L98:
        r31 = "usage";
    L100:
        r114 = r16;
        r111 = "biz_usage";
    L99:
        r31 = "usage";
        goto L100
    L131:
        r20.put("usage", r3);     // Catch: Exception -> L117
        goto L125
    L18:
        if ((r7 + r11) <= r19) goto L23;
        if (TextUtils.equals(p, "bg_never_front") == false) goto L22;
        String r121 = "never_front_usage_abnormal";
    L14:
        r4.put(r121);
        goto L23
    L22:
        r121 = "bg_usage_abnormal";
        goto L14
    L12:
        if (r5 <= r15) goto L15;
        r121 = "total_usage_abnormal";
        goto L14
    }
}
