package i4;

import android.text.TextUtils;
import android.util.Pair;
import c4.m;
import com.obric.cae.cloud.CloudServiceConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x4.b0;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f8227b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ b0 f8228m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f8229n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ f f8230o;

    public g(f r8, int r10, long r11, b0 r12, String r13) {
        this.f8230o = r8;
        this.f8226a = r10;
        this.f8227b = r11;
        this.f8228m = r12;
        this.f8229n = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r8 = "gzip";
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r11 >= this.f8226a) goto L91;
        f r13 = this.f8230o;
        if (r12 >= 2) goto L7;
        Thread.sleep(3000);     // Catch: InterruptedException -> L92
    L11:
        long r14 = this.f8227b;
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L86
        b r16 = r13.f8220s.f8201g;     // Catch: Throwable -> L86
        if (r16 != null) goto L97;
    L33:
        r13.f8218q.put("feature_options", r13.f8223v);     // Catch: Throwable -> L86
        r15.put(CloudServiceConstants.OCloud.HEADER, r13.f8218q);     // Catch: Throwable -> L86
        JSONArray r17 = new JSONArray();     // Catch: Throwable -> L86
        Pair<Map<String, j4.d.a>, Long> r18 = r13.f8214m.c(r14);     // Catch: Throwable -> L86
        Object r19 = r18.first;     // Catch: Throwable -> L86
        if (r19 == null) goto L36;
        r13.f8214m.getClass();     // Catch: Throwable -> L31
        j4.d.b((Map) r19, r17);     // Catch: Throwable -> L31
        r14 = ((Long) r18.second).longValue();     // Catch: Throwable -> L31
    L36:
        ConcurrentHashMap r110 = r13.f8215n.f8634m;     // Catch: Throwable -> L86
        if (r110.isEmpty() == false) goto L40;
        Pair r111 = new Pair(null, Long.valueOf(r14));     // Catch: Throwable -> L31
    L99:
        Object r20 = r111.first;     // Catch: Throwable -> L84
        if (r20 != null) goto L95;
    L49:
        Pair<Map<String, JSONObject>, Long> r21 = r13.f8213b.a(r14);     // Catch: Throwable -> L84
        Object r22 = r21.first;     // Catch: Throwable -> L84
        if (r22 == null) goto L56;
        r13.f8213b.getClass();     // Catch: Throwable -> L47
        Iterator r23 = ((Map) r22).values().iterator();     // Catch: Throwable -> L47
    L53:
        if (r23.hasNext() == false) goto L55;
        r17.put((JSONObject) r23.next());     // Catch: Throwable -> L47
        goto L53
    L55:
        r14 = ((Long) r21.second).longValue();     // Catch: Throwable -> L47
    L56:
        Pair<Map<String, JSONObject>, Long> r24 = r13.f8216o.a(r14);     // Catch: Throwable -> L84
        Object r112 = r24.first;     // Catch: Throwable -> L84
        if (r112 == null) goto L63;
        r13.f8216o.getClass();     // Catch: Throwable -> L47
        Iterator r25 = ((Map) r112).values().iterator();     // Catch: Throwable -> L47
    L60:
        if (r25.hasNext() == false) goto L62;
        r17.put((JSONObject) r25.next());     // Catch: Throwable -> L47
        goto L60
    L62:
        r14 = ((Long) r24.second).longValue();     // Catch: Throwable -> L47
    L63:
        Pair<Map<String, j4.c.a>, Long> r113 = r13.f8217p.b(r14);     // Catch: Throwable -> L84
        Object r114 = r113.first;     // Catch: Throwable -> L84
        if (r114 == null) goto L67;
        r13.f8217p.getClass();     // Catch: Throwable -> L47
        j4.c.a((Map) r114, r17);     // Catch: Throwable -> L47
        r14 = ((Long) r113.second).longValue();     // Catch: Throwable -> L47
    L67:
        if (r17.length() != 0) goto L70;
        m.u().l(8, f.f8209w, "report break for no any event!", new Object[0]);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Throwable r115 = th;
        String r116 = r8;
    L89:
        int r26 = 0;
        m.u().m(8, f.f8209w, "report to server failed!", r115, new Object[0]);
        r12 = r12 + 1;
    L90:
        r11 = r11 + 1;
        r10 = r26;
        r8 = r116;
        goto L4
    L69:
        return;
    L70:
        r15.put("event_v3", r17);     // Catch: Throwable -> L84
        byte[] r27 = t2.b.r(r15.toString().getBytes("UTF-8"));     // Catch: Throwable -> L84
        HashMap r117 = new HashMap();     // Catch: Throwable -> L84
        r117.put("log-encode-type", r8);     // Catch: Throwable -> L84
        r117.put("Content-Encoding", r8);     // Catch: Throwable -> L84
        r117.put("Content-Type", "application/octet-stream;tt-data=b");     // Catch: Throwable -> L84
        r117.put("x-tt-request-tag", "t=0");     // Catch: Throwable -> L84
        String r28 = this.f8228m.post(this.f8229n, r27, r117);     // Catch: Throwable -> L84
        c4.g r29 = m.u();     // Catch: Throwable -> L84
        List<String> r118 = f.f8209w;     // Catch: Throwable -> L84
        r116 = r8;
        r29.l(8, r118, "report with left body size left: {} and response: {}.", new Object[]{Long.valueOf(r14), r28});     // Catch: Throwable -> L82
        if (TextUtils.isEmpty(r28) == false) goto L75;
    L80:
        r12 = r12 + 1;
    L81:
        r26 = 0;
        goto L90
    L75:
        if ("success".equals(new JSONObject(r28).getString("message")) == false) goto L80;
        m.u().g(8, r118, "report to server success!", new Object[0]);     // Catch: Throwable -> L82
        r13.f8214m.f((Map) r18.first);     // Catch: Throwable -> L82
        r13.f8215n.d((Map) r111.first);     // Catch: Throwable -> L82
        j4.a r30 = r13.f8213b;     // Catch: Throwable -> L82
        Map r31 = (Map) r21.first;     // Catch: Throwable -> L82
        r30.getClass();     // Catch: Throwable -> L82
        j4.b r32 = r13.f8216o;     // Catch: Throwable -> L82
        Map r33 = (Map) r24.first;     // Catch: Throwable -> L82
        r32.getClass();     // Catch: Throwable -> L82
        r13.f8217p.c((Map) r113.first);     // Catch: Throwable -> L82
        if (r14 <= 0) goto L81;
        return;
    L82:
        th = th;
    L88:
        r115 = th;
        goto L89
    L95:
        r13.f8215n.getClass();     // Catch: Throwable -> L47
        j4.e.a((Map) r20, r17);     // Catch: Throwable -> L47
        r14 = ((Long) r111.second).longValue();     // Catch: Throwable -> L47
    L84:
        th = th;
        r116 = r8;
        goto L88
    L40:
        r111 = new Pair(new HashMap(r110), Long.valueOf(r14 - (((long) r110.size()) * 30)));     // Catch: Throwable -> L84
        goto L99
    L97:
        y3.c r119 = ((y3.e) r16).f13956a;     // Catch: Throwable -> L31
        r3.c r120 = r119.f13937m;     // Catch: Throwable -> L31
        if (r120.f11404l != null) goto L18;
        r120.H.b("Init first please to get header", new Object[r10]);     // Catch: Throwable -> L31
        JSONObject r34 = null;
    L19:
        r119.f13937m.getClass();     // Catch: Throwable -> L31
        String[] r121 = new String[3];     // Catch: JSONException -> L22 Throwable -> L31
        r121[r10] = "carrier_region";     // Catch: JSONException -> L22 Throwable -> L31
        r121[1] = "region";     // Catch: JSONException -> L22 Throwable -> L31
        r121[2] = "app_region";     // Catch: JSONException -> L22 Throwable -> L31
        JSONObject r122 = new JSONObject(r34, r121);     // Catch: JSONException -> L22 Throwable -> L31
    L23:
        if (r122 == null) goto L33;
        if (r122.length() <= 0) goto L33;
        Iterator<String> r35 = r122.keys();     // Catch: Throwable -> L31
    L28:
        if (r35.hasNext() == false) goto L33;
        String r123 = r35.next();     // Catch: Throwable -> L31
        r13.f8218q.put(r123, r122.opt(r123));     // Catch: Throwable -> L31
    L22:
        r122 = null;
        goto L23
    L18:
        r34 = r120.f11404l.a();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        r115 = th;
        r116 = r8;
        r11 = r11;
    L86:
        th = th;
        r116 = r8;
        r11 = r11;
        goto L88
    L7:
        m.u().l(8, f.f8209w, "report failed and break with try 2 times: {}.", new Object[r10]);
        r13.a(1, "monitor_report_failed_2_tries");
        return;
    }
}
