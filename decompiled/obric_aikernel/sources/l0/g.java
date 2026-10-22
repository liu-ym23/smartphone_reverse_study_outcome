package l0;

import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.util.y;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.commonevent.model.GeneralLegacyEvent;
import com.bytedance.apm6.util.cache.LimitedQueue;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.request.track.ApiPerfDetails;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends i0.a {
    private static LimitedQueue<GeneralLegacyEvent> A = null;
    private static LimitedQueue<String> B = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static String f10802y = "bg_never_front";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static d0.g f10803z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f10804l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f10805m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f10806n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f10807o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f10808p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f10809q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f10810r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f10811s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f10812t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f10813u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f10814v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f10815w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private h f10816x;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f10817a = null;

        static {
            f10817a = new g(null);
        }

        static /* synthetic */ g a() {
            return f10817a;
        }
    }

    static {
        A = new LimitedQueue(20);
        B = new LimitedQueue(20);
    }

    private g() {
        this.f10804l = 500000000;
        this.f10805m = 0;
        this.f10806n = 1;
        this.f10807o = -1;
        this.f10808p = 0;
        this.f10809q = 0;
        this.f10810r = 0;
        this.f10811s = 0;
        this.f10813u = 0;
        this.f9290j = "traffic";
        h r10 = h.e();
        this.f10816x = r10;
        r10.k(e());
    }

    /* synthetic */ g(f r10) {
        this();
    }

    public static g o() {
        return a.a();
    }

    private JSONArray p(Map<String, l0.a.c> r10, String r11, JSONArray r12) {
        if (r10 != null) goto L5;
    L17:
        return null;
    L5:
        if (r10.size() == 0) goto L17;
        Iterator<Map.Entry<String, l0.a.c>> r13 = r10.entrySet().iterator();     // Catch: Exception -> L18
    L9:
        if (r13.hasNext() == false) goto L16;
        JSONObject r14 = r13.next().getValue().c(this.f10805m);     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r11) == true) goto L14;
        r14.put("traffic_category", r11);     // Catch: Exception -> L18
    L14:
        r12.put(r14);     // Catch: Exception -> L18
        goto L9
    L16:
        return r12;
    }

    public static void q(d0.g r10) {
        f10803z = r10;
    }

    @Override // i0.a
    protected void c(JSONObject r10) {
        super.c(r10);
        if (r10.optInt("cause_analysis", 0) != 1) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        l0.a.j().u();
        this.f10804l = (r10.optInt("exception_threshold_mb", 500) * 1000) * 1000;
        this.f10806n = (r10.optInt("exception_threshold_bg_mb", 500) * 1000) * 1000;
        this.f10814v = r10.optInt("high_freq_threshold", 200);
        l0.a.j().s((r10.optDouble("large_usage_threshold_mb", 10.0d) * 1000.0d) * 1000.0d);
        l0.a.j().o(r10.optDouble("alog_record_threshold", 100.0d));
    L8:
        this.f10805m = r10.optLong("record_usage_kb", 1) * 1024;
        boolean r12 = o0.c.c(this.f9290j);
    L10:
        if (A.isEmpty() == true) goto L30;
        GeneralLegacyEvent r13 = A.pop();
        String r14 = B.pop();
        if (r12 == false) goto L14;
    L19:
        CommonEventDeliverer.monitorLegacyEvent(r13);
    L21:
        if (com.bytedance.apm.d.D() == false) goto L10;
        String[] r15 = new String[1];
        StringBuilder r16 = new StringBuilder();
        r16.append("isSample:key:");
        if (r12 == false) goto L25;
    L28:
        boolean r17 = true;
    L29:
        r16.append(r17);
        r15[0] = r16.toString();
        e0.e.b("Traffic", r15);
        goto L10
    L25:
        if (r10.optInt(r14, 0) == 1) goto L28;
        r17 = false;
        goto L29
    L14:
        if (r10.optInt(r14, 0) == 1) goto L19;
        if (com.bytedance.apm.d.D() == false) goto L21;
        a0.a.b(r13.getLogType(), r13.getLogJson(), false);
        goto L21
    L30:
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // i0.a
    protected boolean f() {
        return true;
    }

    @Override // i0.a
    protected void h() {
        SharedPreferences r10 = com.bytedance.apm.d.g().getSharedPreferences("traffic_monitor_info", 0);
        long r11 = r10.getLong(CommonConsts.APM_INNER_EVENT_COST_INIT, -1);
        long r13 = r10.getLong("init_ts", 0);
        if (r11 <= (-1)) goto L22;
        long r12 = r10.getLong("usage", 0);
        long r14 = r10.getLong("usage_ts", 0);
        long r15 = r12 - r11;
        if (r15 > 0) goto L29;
    L21:
        g r16 = this;
        String r17 = "usage";
    L23:
        r16.f10813u = r16.f10816x.h();
        SharedPreferences.Editor r18 = r10.edit();
        r18.putLong(CommonConsts.APM_INNER_EVENT_COST_INIT, r16.f10813u);
        r18.putLong("init_ts", System.currentTimeMillis());
        r18.putLong(r17, 0);
        r18.apply();
        return;
    L29:
        JSONObject r19 = new JSONObject();     // Catch: JSONException -> L26
        r19.put("total_usage", r15);     // Catch: JSONException -> L26
        JSONObject r110 = new JSONObject();     // Catch: JSONException -> L26
        r110.put("total_usage_duration", ((r14 - r13) / 1000) / 60);     // Catch: JSONException -> L26
        JSONObject r20 = new JSONObject();     // Catch: JSONException -> L26
        r20.put("init_ts", r13);     // Catch: JSONException -> L26
        r20.put("usage_ts", r14);     // Catch: JSONException -> L26
        r20.put("biz_usage", r10.getLong("biz_usage", 0));     // Catch: JSONException -> L26
        r20.put(CommonConsts.APM_INNER_EVENT_COST_INIT, r11);     // Catch: JSONException -> L26
        r17 = "usage";
        r20.put(r17, r12);     // Catch: JSONException -> L20
        String r21 = r10.getString("biz_json", "");     // Catch: JSONException -> L20
        if (r21 == "") goto L11;
        JSONObject r22 = new JSONObject();     // Catch: JSONException -> L20
        r22.put(r17, new JSONArray(r21));     // Catch: JSONException -> L20
        r20.put("detail", r22);     // Catch: JSONException -> L20
    L11:
        y.e r23 = new y.e();     // Catch: JSONException -> L20
        r16 = this;
        r23.k(r16.f9290j).i(r19).h(r110).g(r20);     // Catch: JSONException -> L25
        e0.a.b("APM-Traffic-Detail ", "Init");     // Catch: JSONException -> L25
        if (e0.a.e() == false) goto L16;
        e0.a.b("APM-Traffic-Detail ", com.bytedance.apm.util.i.c(r23.c()).toString());     // Catch: JSONException -> L25
    L16:
        r16.k(r23);     // Catch: JSONException -> L25
        d0.g r24 = f10803z;     // Catch: JSONException -> L25
        if (r24 == null) goto L23;
        r24.b(r15);     // Catch: JSONException -> L25
    L20:
        r16 = this;
        goto L23
    L22:
        r16 = this;
        r17 = "usage";
        goto L23
    }

    @Override // i0.a
    protected void i() {
        super.i();
        if (e() == true) goto L5;
        f10802y = "bg_ever_front";
    L5:
        long r10 = System.currentTimeMillis();
        long r11 = this.f10816x.h();
        long r12 = this.f10816x.f();
        long r13 = this.f10816x.g();
        long r14 = this.f10816x.i();
        String r17 = "APM-Traffic-Detail ";
        long r15 = this.f10816x.j();
        if (this.f10807o != (-1)) goto L9;
        this.f10807o = r11;
        this.f10808p = r12;
        this.f10809q = r13;
        this.f10810r = r14;
        this.f10811s = r15;
        this.f10812t = r10;
        return;
    L9:
        JSONArray r16 = new JSONArray();
        long r18 = r11 - this.f10807o;
        long r19 = r12 - this.f10808p;
        long r20 = r13 - this.f10809q;
        long r21 = r14 - this.f10810r;
        long r110 = r15 - this.f10811s;
        long r111 = this.f10804l;
        if (r111 > 0) goto L12;
    L15:
        long r112 = this.f10806n;
        if (r112 > 0) goto L18;
    L23:
        y<i> r113 = l0.a.j().k();
        if (r113 == null) goto L29;
        if (r113.c() <= 0) goto L29;
        r16.put("large_request");
    L29:
        if (c.d().e() <= this.f10814v) goto L31;
        r16.put("high_feq_request");
    L31:
        this.f10807o = r11;
        this.f10811s = r15;
        this.f10810r = r14;
        this.f10808p = r12;
        this.f10809q = r13;
        JSONArray r22 = new JSONArray();
        o0.c.c(this.f9290j);
        p(l0.a.j().g(), "usage_10_minutes", r22);
        p(l0.a.j().i(), "wifi_front", r22);
        p(l0.a.j().h(), "wifi_back", r22);
        p(l0.a.j().f(), "mobile_front", r22);
        p(l0.a.j().e(), "mobile_back", r22);
        JSONObject r23 = new JSONObject();
        if (r22.length() <= 0) goto L128;
        r23.put("usage", r22);     // Catch: Exception -> L109
    L128:
        JSONObject r24 = new JSONObject();     // Catch: JSONException -> L91
        r24.put("usage_10_minutes", r18);     // Catch: JSONException -> L91
        r24.put("mobile_back", r19);     // Catch: JSONException -> L91
        r24.put("mobile_front", r20);     // Catch: JSONException -> L91
        r24.put("wifi_back", r21);     // Catch: JSONException -> L91
        String r114 = "detail";
        r24.put("wifi_front", r110);     // Catch: JSONException -> L90
        d0.g r25 = f10803z;     // Catch: JSONException -> L90
        if (r25 == null) goto L39;
        r25.a(r18, r21, r110, r19, r20);     // Catch: JSONException -> L90
    L39:
        JSONObject r26 = new JSONObject();     // Catch: JSONException -> L90
        y.e r27 = new y.e();     // Catch: JSONException -> L90
        JSONObject r28 = new JSONObject();     // Catch: JSONException -> L90
        r28.put(r114, r23);     // Catch: JSONException -> L90
        String r29 = "biz_usage";
        r28.put(r29, l0.a.j().d());     // Catch: JSONException -> L88
        g r30 = this;
        r28.put("init_ts", r30.f10812t);     // Catch: JSONException -> L113
        String r31 = "usage_ts";
        r28.put(r31, r10);     // Catch: JSONException -> L111
        r27.k(r30.f9290j).h(r26).i(r24).g(r28);     // Catch: JSONException -> L111
        if (e0.a.e() == true) goto L48;
        String r115 = r17;
    L51:
        r30.k(r27);     // Catch: JSONException -> L110
        r30.f10812t = r10;     // Catch: JSONException -> L110
        if (r16.length() <= 0) goto L87;
        JSONObject r32 = new JSONObject();     // Catch: JSONException -> L110
        r32.put(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, true);     // Catch: JSONException -> L110
        r32.put(ApiPerfDetails.exceptionType, r16);     // Catch: JSONException -> L110
        Map<String, i> r33 = c.d().c();     // Catch: JSONException -> L110
        if (r33 == null) goto L69;
        Iterator<Map.Entry<String, i>> r34 = r33.entrySet().iterator();     // Catch: JSONException -> L110
        JSONArray r116 = new JSONArray();     // Catch: JSONException -> L110
    L57:
        if (r34.hasNext() == false) goto L65;
        Map.Entry<String, i> r117 = r34.next();     // Catch: JSONException -> L110
        String r118 = r115;
        String r119 = r114;
        JSONObject r120 = r26;
        JSONObject r121 = r32;
        if (r117.getValue().f10823i <= r30.f10814v) goto L64;
        JSONObject r35 = new JSONObject();     // Catch: JSONException -> L111
        r35.put("path", r117.getValue().f10820c);     // Catch: JSONException -> L111
        r35.put("freq", r117.getValue().f10823i);     // Catch: JSONException -> L111
        r35.put("biz", r117.getValue().f10821g);     // Catch: JSONException -> L111
        r116.put(r35);     // Catch: JSONException -> L111
    L64:
        r26 = r120;
        r114 = r119;
        r115 = r118;
        r32 = r121;
        goto L57
    L65:
        JSONObject r122 = r26;
        JSONObject r123 = r32;
        r17 = r115;
        String r124 = r114;
        if (e0.a.e() == false) goto L68;
        e0.a.b("TrafficHighTreq", r116.toString());     // Catch: JSONException -> L111
    L68:
        r23.put("high_freq", r116);     // Catch: JSONException -> L111
    L70:
        if (r113 == null) goto L82;
        List<E> r36 = r113.d();     // Catch: JSONException -> L111
        if (r36 == 0) goto L82;
        if (r36.size() <= 0) goto L82;
        JSONArray r37 = new JSONArray();     // Catch: JSONException -> L111
        Iterator r38 = r36.iterator();     // Catch: JSONException -> L111
    L77:
        if (r38.hasNext() == false) goto L79;
        i r39 = (i) r38.next();     // Catch: JSONException -> L111
        JSONObject r125 = new JSONObject();     // Catch: JSONException -> L111
        r125.put("path", r39.f10820c);     // Catch: JSONException -> L111
        r125.put("usage", r39.f10822h);     // Catch: JSONException -> L111
        r125.put("biz", r39.f10821g);     // Catch: JSONException -> L111
        r37.put(r125);     // Catch: JSONException -> L111
        goto L77
    L79:
        r23.put("large_usage", r37);     // Catch: JSONException -> L111
        if (e0.a.e() == false) goto L82;
        e0.a.b("TrafficTopK", r37.toString());     // Catch: JSONException -> L111
    L82:
        JSONObject r40 = r123;
        r40.put(r29, l0.a.j().d());     // Catch: JSONException -> L111
        if (e0.a.e() == false) goto L85;
        e0.a.b("TrafficException", r40.toString());     // Catch: JSONException -> L111
    L85:
        r40.put(r124, r23);     // Catch: JSONException -> L111
        y.e r41 = new y.e();     // Catch: JSONException -> L111
        r41.k(r30.f9290j).h(r122).i(r24).g(r40);     // Catch: JSONException -> L111
        r30.k(r41);     // Catch: JSONException -> L111
        goto L93
    L69:
        r122 = r26;
        r123 = r32;
        r17 = r115;
        r124 = r114;
    L87:
        r17 = r115;
        goto L93
    L48:
        r115 = r17;
        e0.a.b(r115, com.bytedance.apm.util.i.c(r27.c()).toString());     // Catch: JSONException -> L110
    L93:
        SharedPreferences.Editor r42 = com.bytedance.apm.d.g().getSharedPreferences("traffic_monitor_info", 0).edit();
        r42.putLong("usage", r11);
        long r43 = r30.f10815w + l0.a.j().d();
        r30.f10815w = r43;
        r42.putLong(r29, r43);
        r42.putLong(r31, System.currentTimeMillis());
        Map<String, l0.a.c> r44 = l0.a.j().l();
        if (r44 != null) goto L96;
    L104:
        r42.apply();
        if (com.bytedance.apm.d.D() == false) goto L107;
        String r45 = r17;
        Log.d(r45, "traffic since app boot: " + (r11 - r30.f10813u));
        Log.d(r45, "traffic stats from biz (include ttnet/ok/httpurl plus trafficStats): " + l0.a.j().d());
    L107:
        l0.a.j().c();
        c.d().b();
        return;
    L96:
        if (r44.size() <= 0) goto L104;
        JSONArray r46 = new JSONArray();
        Iterator<Map.Entry<String, l0.a.c>> r47 = r44.entrySet().iterator();
    L99:
        if (r47.hasNext() == false) goto L103;
        JSONObject r48 = r47.next().getValue().b();
        r48.put("traffic_category", "total_usage");     // Catch: Exception -> L112
    L102:
        r46.put(r48);
        goto L99
    L103:
        r42.putString("biz_json", r46.toString());
    L89:
        r31 = "usage_ts";
    L88:
        r30 = this;
    L90:
        r30 = this;
    L92:
        r31 = "usage_ts";
        r29 = "biz_usage";
    L91:
        r30 = this;
        goto L92
    L18:
        if ((r19 + r21) <= r112) goto L23;
        if (TextUtils.equals(f10802y, "bg_never_front") == false) goto L22;
        String r126 = "never_front_usage_abnormal";
    L14:
        r16.put(r126);
        goto L23
    L22:
        r126 = "bg_usage_abnormal";
        goto L14
    L12:
        if (r18 <= r111) goto L15;
        r126 = "total_usage_abnormal";
        goto L14
    }

    @Override // i0.a
    protected long n() {
        return 600000;
    }

    @Override // i0.a, t4.d
    public void onBackground(Activity r10) {
        super.onBackground(r10);
        this.f10816x.k(true);
    }

    @Override // i0.a, t4.d
    public void onFront(Activity r10) {
        super.onFront(r10);
        f10802y = "bg_ever_front";
        this.f10816x.k(false);
    }
}
