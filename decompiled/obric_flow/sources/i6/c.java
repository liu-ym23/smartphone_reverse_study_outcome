package i6;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.j;
import com.bytedance.apm.util.g;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import td.d;
import v6.i;
import wc.f;
import wn.h;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends h6.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17506c;
    public boolean d;
    public volatile int e;
    public volatile ArrayList f;
    public ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f17507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f17508i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f17509j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f17510k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f17511l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f17512m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f17513n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public double f17514o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public f f17515p;

    public static void i(String r5, ArrayList r10, JSONObject r11) {
        if (r10 == null) goto L31;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (TextUtils.isEmpty(r5) == true) goto L32;
        String r12 = r11.optString(r5);     // Catch: Exception -> L13 JSONException -> L15
        if (TextUtils.isEmpty(r12) == true) goto L33;
        JSONObject r13 = new JSONObject(r12);     // Catch: Exception -> L13 JSONException -> L15
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L13 JSONException -> L15
        Iterator<String> r15 = r13.keys();     // Catch: Exception -> L13 JSONException -> L15
    L9:
        if (r15.hasNext() == false) goto L17;
        String r16 = r15.next();     // Catch: Exception -> L13 JSONException -> L15
        if (r10.contains(r16) == false) goto L9;
        r14.put(r16, r13.opt(r16));     // Catch: Exception -> L13 JSONException -> L15
        goto L9
    L17:
        r11.put(r5, r14.toString());     // Catch: Exception -> L13 JSONException -> L15
    L34:
        return;
    L33:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
        return;
    L32:
        return;
    }

    @Override // h6.a
    public final boolean a(h6.b r5) {
        return !TextUtils.isEmpty(((j6.a) r5).d);
    }

    @Override // h6.a
    public final void c(h6.b r15) {
        j6.a r16 = (j6.a) r15;
        String r5 = r16.d;
        ArrayList r10 = this.f17509j;
        if (d.d(r10) == false) goto L5;
    L13:
        boolean r11 = j.f3887a;
        if (g.b(null) == false) goto L145;
        JSONObject r12 = r16.f18249h;
        if (r12 != null) goto L136;
    L25:
        String r13 = r16.f18246a;
        JSONObject r14 = r16.c();
        JSONObject r17 = r16.f18249h;
        if (r14 == null) goto L38;
        if (r17 == null) goto L38;
        if (r17.length() <= 0) goto L38;
        Iterator<String> r18 = r17.keys();     // Catch: JSONException -> L36
    L33:
        if (r18.hasNext() == false) goto L38;
        String r19 = r18.next();     // Catch: JSONException -> L36
        r14.put(r19, r17.get(r19));     // Catch: JSONException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
    L38:
        if (r14 != null) goto L41;
        return;
    L41:
        if (TextUtils.equals(r13, "api_all") == false) goto L51;
        if (k() == false) goto L47;
        j(r5, r14);
    L45:
        boolean r20 = true;
    L56:
        if (this.f17512m == false) goto L83;
        String r21 = r16.f18246a;
    L62:
        e = move-exception;
        e.printStackTrace();
        goto L83
    L60:
        if (TextUtils.equals(r21, "api_all") == false) goto L65;
        r14.put("net_log_type", "api_all_v2");     // Catch: Exception -> L62
    L69:
        if (k() == false) goto L74;
        if (this.d == false) goto L74;
        r14.put("inject_tracelog", "01");     // Catch: Exception -> L62
    L78:
        double r22 = this.f17514o;     // Catch: Exception -> L62
        if (r22 == 0.0d) goto L83;
        r14.put("enable_base_api_all", r22);     // Catch: Exception -> L62
    L74:
        if (this.f17506c != 1) goto L78;
        if (this.d == false) goto L78;
        r14.put("inject_tracelog", "02");     // Catch: Exception -> L62
        goto L78
    L65:
        if (TextUtils.equals(r21, "api_error") == false) goto L69;
        r14.put("net_log_type", "api_error_v2");     // Catch: Exception -> L62
    L83:
        i("requestHeader", this.f17510k, r14);
        i("responseHeader", this.f17511l, r14);
        if (this.f17515p != null) goto L86;
    L123:
        h6.a.h(r13, r13, r14, r20, true);
        return;
    L86:
        if ("api_all".equals(r13) == false) goto L123;
        if (r16.f18249h.optBoolean("download", false) == true) goto L123;
        f r110 = this.f17515p;
        JSONObject r111 = r16.f18249h;
        r110.getClass();
        v6.c r112 = v6.b.f22516a;
        boolean r23 = r112.f22517a;
        if (r23 == false) goto L123;
        if (r23 == false) goto L123;
        if (TextUtils.isEmpty(r5) == true) goto L123;
        if (r111 == null) goto L123;
        if (r111.length() == 0) goto L123;
        String r24 = new URL(r5).getPath();     // Catch: Throwable -> L128
        if (TextUtils.isEmpty(r24) == true) goto L123;
        String r25 = r111.optString("net_consume_type", "ttnet");     // Catch: Throwable -> L128
        JSONObject r26 = r111.optJSONObject("request_log");     // Catch: Throwable -> L128
        if (r26 != null) goto L109;
        String r113 = r111.optString("request_log");     // Catch: Throwable -> L128
        if (TextUtils.isEmpty(r113) == true) goto L109;
        r26 = new JSONObject(r113);     // Catch: Throwable -> L128
    L109:
        JSONObject r114 = r26.optJSONObject("response");     // Catch: Throwable -> L128
        if (r114 == null) goto L112;
        long r27 = r114.optLong("received_bytes") + r114.optLong("sent_bytes");     // Catch: Throwable -> L128
    L113:
        r112.f22522j += r27;     // Catch: Throwable -> L128
        if (r27 <= r112.f22524l) goto L120;
        if (r112.f22521i != null) goto L118;
        sg.a r115 = new sg.a();     // Catch: Throwable -> L128
        r115.f21902a = new PriorityQueue(30, new ca.d(4));     // Catch: Throwable -> L128
        r112.f22521i = r115;     // Catch: Throwable -> L128
    L118:
        r112.f22521i.e(new i(r27, r24, r25));     // Catch: Throwable -> L128
    L120:
        if (TextUtils.isEmpty(r5) == false) goto L135;
    L122:
        r112.a(r27, r25, r5);
        v6.d.f22526a.h(r27, r24, r25);
        goto L123
    L135:
        r5 = Uri.parse(r5).buildUpon().clearQuery().build().toString();     // Catch: Exception -> L127 Throwable -> L128
    L112:
        r27 = 0;
        goto L113
    L47:
        if (h.m(r5, this.f, this.g) == false) goto L49;
    L48:
        r20 = false;
        goto L56
    L49:
        r20 = j(r5, r14);
        goto L56
    L51:
        if (TextUtils.equals(r13, "api_error") == false) goto L48;
        if (this.e != 1) goto L48;
    L136:
        String r28 = r12.optString("cronet_internal_error_code");     // Catch: Exception -> L126
        if ("11".equals(r12.optString("cronet_error_code")) == false) goto L25;
        if ("-999".equals(r28) == false) goto L25;
        if (this.f17513n == true) goto L25;
        return;
    L145:
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L13;
        String r29 = Uri.parse(r5).getHost();     // Catch: Throwable -> L125
        Iterator r30 = r10.iterator();     // Catch: Throwable -> L125
    L9:
        if (r30.hasNext() == false) goto L13;
        if (r29.equalsIgnoreCase((String) r30.next()) == false) goto L9;
    }

    @Override // h6.a, pj.a
    public final void d(JSONObject r10, boolean r11) {
        JSONObject r12 = null;
        if (r10 != null) goto L5;
    L8:
        JSONObject r13 = null;
    L9:
        if (r13 != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty("network") == false) goto L13;
        JSONObject r5 = null;
    L14:
        if (r5 == null) goto L49;
        this.f = h.n("api_block_list", r5);
        boolean r14 = false;
        JSONArray r15 = r5.optJSONArray("api_block_list");     // Catch: Exception -> L56
        if (r15 == null) goto L26;
        if (r15.length() <= 0) goto L26;
        int r16 = r15.length();     // Catch: Exception -> L56
        ArrayList r17 = new ArrayList(r16);     // Catch: Exception -> L56
        int r18 = 0;
    L21:
        if (r18 >= r16) goto L27;
        String r19 = r15.getString(r18);     // Catch: Exception -> L56
        if (TextUtils.isEmpty(r19) == true) goto L25;
        r17.add(Pattern.compile(r19));     // Catch: Exception -> L56
    L25:
        r18 = r18 + 1;
    L27:
        this.g = r17;
        this.f17507h = h.o("api_allow_list", r5);
        JSONObject r20 = r5.optJSONObject("api_allow_list");     // Catch: Exception -> L55
        if (r20 != null) goto L31;
    L34:
        boolean r21 = true;
    L35:
        if (r21 == true) goto L36;
        ArrayList r22 = new ArrayList();     // Catch: Exception -> L55
        Iterator<String> r23 = r20.keys();     // Catch: Exception -> L55
    L38:
        if (r23.hasNext() == false) goto L44;
        String r24 = r23.next();     // Catch: Exception -> L55
        if (r20.optInt(r24) != 1) goto L38;
        r22.add(Pattern.compile(r24));     // Catch: Exception -> L55
    L44:
        this.f17508i = r22;
        this.f17506c = r5.optInt("enable_api_all_upload", 0);
        this.d = r5.optBoolean("enable_trace_log", true);
        this.e = r5.optInt("enable_api_error_upload", 1);
        if (r5.optInt("enable_cancel_error_report") != 1) goto L47;
        r14 = true;
    L47:
        this.f17513n = r14;
        this.f17510k = h.o("request_allow_header", r5);
        this.f17511l = h.o("response_allow_header", r5);
        this.f17514o = r5.optDouble("enable_base_api_all", 0.0d);
        goto L49
    L31:
        if (r20.length() == 0) goto L34;
        r21 = false;
    L36:
        r22 = null;
    L26:
        r17 = null;
    L49:
        if (TextUtils.isEmpty("image") == true) goto L52;
        r12 = r13.optJSONObject("image");
    L52:
        if (r12 == null) goto L70;
        this.f17509j = h.o("image_allow_list", r12);
        return;
    L70:
        return;
    L13:
        r5 = r13.optJSONObject("network");
        goto L14
    L5:
        if (TextUtils.isEmpty("network_image_modules") == true) goto L8;
        r13 = r10.optJSONObject("network_image_modules");
        goto L9
    }

    @Override // h6.a
    public final void g(h6.b r5) {
        j6.a r10 = (j6.a) r5;
        if (ActivityLifeObserver.getInstance() != null) goto L6;
        int r11 = 1;
    L7:
        int r12 = r11 ^ 1;     // Catch: JSONException -> L14
        JSONObject r13 = r10.f18249h;     // Catch: JSONException -> L14
        if (r13.isNull("front") == false) goto L10;
        r13.put("front", r12);     // Catch: JSONException -> L14
    L10:
        JSONObject r14 = r10.f18249h;     // Catch: JSONException -> L14
        if (r14.isNull("net_consume_type") == false) goto L17;
        r14.put("net_consume_type", "ttnet");     // Catch: JSONException -> L14
        return;
    L17:
        return;
    L6:
        r11 = !ActivityLifeObserver.getInstance().isForeground() ? 1 : 0;     // Catch: JSONException -> L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final boolean j(String r5, JSONObject r10) {
        if (k() == false) goto L5;
    L10:
        ?? r11 = 1;
    L14:
        r10.put("hit_rules", r11);     // Catch: JSONException -> L13
    L12:
        return r11;
    L5:
        if (this.f17506c != 0) goto L10;
        if (h.m(r5, this.f17507h, this.f17508i) == true) goto L10;
        r11 = 0;
        goto L14
    }

    public final boolean k() {
        if (this.f17512m == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f17514o == 0.0d) goto L7;
        return true;
    }
}
