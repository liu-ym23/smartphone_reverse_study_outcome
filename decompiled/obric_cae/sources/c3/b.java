package c3;

import android.text.TextUtils;
import android.util.Log;
import c2.k;
import com.obric.cae.smartNetwork.trafficMonitor.TrafficMonitorUtil;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import o2.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3310b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f3311m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d f3312n;

    public b(d r8, int r10, String r11) {
        this.f3312n = r8;
        this.f3309a = r10;
        this.f3310b = "";
        this.f3311m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d r8 = this.f3312n;
        boolean r10 = r8.a();
        s2.a r11 = s2.a.C0150a.f12020a;
        if (r10 == false) goto L14;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r11.f12019b != null) goto L8;
        r11.f12019b = new a.C0038a(new a.C0038a.C0039a());     // Catch: Throwable -> L11
    L8:
        a.C0038a r12 = r11.f12019b;     // Catch: Throwable -> L11
        monitor-exit(r11);
        r12.getClass();
    L14:
        String r13 = this.f3310b;
        String r14 = this.f3311m;
        long r15 = r8.f3321b;
        String r16 = r8.f3324e;
        ConcurrentHashMap<String, r2.a> r17 = r8.f3322c;
        JSONArray r18 = new JSONArray();
    L46:
        e = e;
        String r19 = r13;
        String r110 = r14;
    L48:
        long r20 = r15;
    L50:
        e.printStackTrace();
    L51:
        if (r17 == null) goto L53;
        r17.clear();
    L53:
        JSONObject r21 = new JSONObject();
        r21.put(QesdkUtils.TAGS.JSON_TAG_NAME, r16);     // Catch: JSONException -> L82
        r21.put("page_type", r16);     // Catch: JSONException -> L82
        r21.put("start", r8.f3320a);     // Catch: JSONException -> L82
        r21.put("end", r20);     // Catch: JSONException -> L82
        r21.put("spans", r18);     // Catch: JSONException -> L82
        r21.put("collect_from", 2);     // Catch: JSONException -> L82
        r21.put("page_name", r110);     // Catch: JSONException -> L82
        int r22 = this.f3309a;
        if (r22 == (-1)) goto L59;
        r21.put("launch_mode", r22);     // Catch: JSONException -> L82
    L59:
        if (r19.isEmpty() == true) goto L62;
        r21.put("custom_launch_mode", r19);     // Catch: JSONException -> L82
    L62:
        if (r8.a() == false) goto L64;
        r11.a().getClass();
    L64:
        JSONObject r23 = new JSONObject();
        r23.put("trace", r21);     // Catch: JSONException -> L83
    L66:
        e r24 = new e(r8.f3323d, "", null, null, r23);
        r24.f9641e = l3.a.a().c(false);
        if (k.d() == false) goto L80;
        String r25 = "reportAsync: " + r23;
        if (r25 == null) goto L80;
        if (r25.length() == 0) goto L80;
        if (r25.length() > TrafficMonitorUtil.THRESHOLD_3GB) goto L77;
    L79:
        Log.d("AppStartStats", r25);
    L77:
        if (r25.length() <= 3072) goto L79;
        String r26 = r25.substring(0, TrafficMonitorUtil.THRESHOLD_3GB);
        r25 = r25.replace(r26, "");
        Log.d("AppStartStats", r26);
    L80:
        n2.a.i().d(r24);
        return;
    L16:
        if (TextUtils.equals(r14, t2.b.f12261u) == false) goto L18;
        r18 = t2.b.i();     // Catch: JSONException -> L46
    L18:
        if (r17 != null) goto L20;
    L49:
        r19 = r13;
        r110 = r14;
        r20 = r15;
        goto L51
    L20:
        if (r17.isEmpty() == true) goto L49;
        Iterator<Map.Entry<String, r2.a>> r27 = r17.entrySet().iterator();     // Catch: JSONException -> L46
    L22:
        if (r27.hasNext() == false) goto L49;
        Map.Entry<String, r2.a> r111 = r27.next();     // Catch: JSONException -> L46
        String r112 = r111.getKey();     // Catch: JSONException -> L46
        r2.a r113 = r111.getValue();     // Catch: JSONException -> L46
        r27 = r27;
        if (r113.f11388b == 0) goto L22;
        JSONObject r28 = new JSONObject();     // Catch: JSONException -> L46
        String[] r29 = r112.split("#");     // Catch: JSONException -> L46
        r19 = r13;
        r110 = r14;
        if (r29.length == 2) goto L92;
        r20 = r15;
        if (r29.length != 1) goto L88;
        String r30 = r29[0];     // Catch: JSONException -> L44
    L41:
        r28.put("span_name", r30);     // Catch: JSONException -> L44
    L88:
        r28.put("start", r113.f11387a);     // Catch: JSONException -> L44
        r28.put("end", r113.f11388b);     // Catch: JSONException -> L44
        r28.put("thread", r113.f11389c);     // Catch: JSONException -> L44
        r18.put(r28);     // Catch: JSONException -> L44
        r13 = r19;
        r14 = r110;
        r15 = r20;
    L44:
        e = e;
        goto L50
    L92:
    L36:
        e = e;
        goto L48
    L31:
        if ("page_load_trace".equals(r8.f3323d) == false) goto L34;
        r28.put(QesdkUtils.TAGS.JSON_TAG_NAME, r29[1]);     // Catch: JSONException -> L36
        r20 = r15;
        goto L88
    L34:
        r20 = r15;
        r28.put("module_name", r29[0]);     // Catch: JSONException -> L44
        r30 = r29[1];     // Catch: JSONException -> L44
        goto L41
    }
}
