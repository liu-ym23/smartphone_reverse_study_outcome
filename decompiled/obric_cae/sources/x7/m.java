package x7;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.services.apm.api.IHttpService;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class m implements r7.b, t7.c, u7.b {
    public LinkedList A;
    public final b B;
    public final String C;
    public boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f13638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f13639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q7.d f13640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q7.b f13641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f13642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f13643f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile int f13644g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f13645h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile int f13646i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile int f13647j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile JSONObject f13648k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile IHttpService f13649l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile int f13650m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile int f13651n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile ArrayList f13652o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile ArrayList f13653p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile ArrayList f13654q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile ArrayList f13655r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a f13656s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Map<String, String> f13657t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LinkedList f13658u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f13659v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile boolean f13660w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f13661x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile boolean f13662y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile boolean f13663z;

    public interface a {
        Map<String, String> getCommonParams();

        String getSessionId();
    }

    public m(String r8) {
        this.f13642e = 0;
        this.f13658u = new LinkedList();
        this.f13661x = true;
        this.A = new LinkedList();
        this.C = r8;
        this.f13663z = false;
        this.B = new b();
    }

    public static void j(m r8, JSONObject r10) {
        r8.getClass();
        if (r10.length() <= 0) goto L11;
        r8.u(r10.getJSONObject("ret"));     // Catch: Throwable -> L8
        SharedPreferences.Editor r11 = r8.o().edit();     // Catch: Throwable -> L8
        r11.putLong("monitor_configure_refresh_time", System.currentTimeMillis());     // Catch: Throwable -> L8
        r11.putInt("monitor_config_update", 1);     // Catch: Throwable -> L8
        r11.putString("monitor_net_config", r10.getJSONObject("ret").toString());     // Catch: Throwable -> L8
        r11.apply();     // Catch: Throwable -> L8
        if (r8.f13663z == true) goto L12;
        r8.f13663z = true;     // Catch: Throwable -> L8
        r8.B.b(r8);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public static void l(StringBuilder r8, String r10, String r11) {
        if (r8.charAt(r8.length() - 1) == '?') goto L18;
        r8.append("&");
    L18:
        r8.append(URLEncoder.encode(r10, "UTF-8"));
        r8.append('=');
        r8.append(URLEncoder.encode(r11, "UTF-8"));
        return;
    L10:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L13:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static void m(JSONObject r8, JSONObject r10) {
        if (r8 == null) goto L19;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.length() <= 0) goto L21;
        Iterator<String> r11 = r10.keys();     // Catch: JSONException -> L12
    L9:
        if (r11.hasNext() == false) goto L22;
        String r12 = r11.next();     // Catch: JSONException -> L12
        r8.put(r12, r10.get(r12));     // Catch: JSONException -> L12
        goto L9
    L22:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        return;
    }

    public static boolean q(String r8, ArrayList r10, ArrayList r11) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return false;
    L6:
        if (defpackage.c.P(r10) == true) goto L23;
        Iterator r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L23;
        if (r8.contains((String) r12.next()) == false) goto L9;
        return true;
    L23:
        String r13 = new URI(r8).getPath();     // Catch: Throwable -> L22
        if (defpackage.c.P(r11) == true) goto L21;
        Iterator r14 = r11.iterator();     // Catch: Throwable -> L22
    L17:
        if (r14.hasNext() == false) goto L21;
        if (((Pattern) r14.next()).matcher(r13).matches() == false) goto L17;
        return true;
    L21:
        return false;
    }

    @Override // u7.b
    public final void a(long r8) {
        if (this.f13643f > 0) goto L5;
        return;
    L5:
        v();
    }

    @Override // r7.b
    public final int b() {
        if (this.f13644g > 0) goto L7;
        return 120;
    L7:
        return this.f13644g;
    }

    @Override // r7.b
    public final boolean c() {
        if (this.f13660w == false) goto L6;
        return this.f13660w;
    L6:
        return this.f13659v;
    }

    @Override // t7.c
    public final a3.a d(String r8, byte[] r10) {
        a3.a r11 = new a3.a();
        String r12 = k(r8).toString();     // Catch: Throwable -> L45
        new HashMap();     // Catch: Throwable -> L45
        if (n() == null) goto L25;
        HashMap r13 = new HashMap();     // Catch: Throwable -> L45
        if (r10.length <= 128) goto L18;
        ByteArrayOutputStream r14 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L45
        GZIPOutputStream r15 = new GZIPOutputStream(r14);     // Catch: Throwable -> L45
        r15.write(r10);     // Catch: Throwable -> L11 IOException -> L13
        r15.close();     // Catch: Throwable -> L45
        r10 = r14.toByteArray();     // Catch: Throwable -> L45
        r13.put("Content-Encoding", "gzip");     // Catch: Throwable -> L45
        goto L18
    L11:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L13:
        e = move-exception;
        throw e;     // Catch: Throwable -> L11
    L18:
        if (this.f13661x == false) goto L24;
        byte[] r16 = EncryptorUtil.a(r10.length, r10);     // Catch: Throwable -> L45
        if (r16 == null) goto L22;
        r12 = r12 + "&tt_data=a";     // Catch: Throwable -> L45
        r13.put("Content-Type", "application/octet-stream;tt-data=a");     // Catch: Throwable -> L45
    L22:
        u8.b r17 = n().doPost(r12, r16, r13);     // Catch: Throwable -> L45
    L23:
        byte[] r18 = r17.f12521b;     // Catch: Throwable -> L45
        Map<String, String> r19 = r17.f12520a;     // Catch: Throwable -> L45
        if (r19 != null) goto L29;
    L31:
        String r20 = null;
    L32:
        r11.f51a = 200;     // Catch: Throwable -> L45
        JSONObject r21 = new JSONObject(new String(r18));     // Catch: Throwable -> L45
        String r22 = r21.optString("data");     // Catch: Throwable -> L41
        if (r22.isEmpty() == true) goto L39;
        String r23 = t2.b.t(r20, r22.getBytes());     // Catch: Throwable -> L41
        if (TextUtils.isEmpty(r23) == true) goto L38;
        r21 = new JSONObject(r23);     // Catch: Throwable -> L41
        goto L39
    L38:
        r21.put("message", "success");     // Catch: Throwable -> L41
    L39:
        r11.f52b = r21;     // Catch: Throwable -> L41
    L43:
        r11.f52b = r21;     // Catch: Throwable -> L45
        return r11;
    L41:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L45
        goto L43
    L29:
        if (r19.isEmpty() == true) goto L31;
        r20 = r19.get("ran");     // Catch: Throwable -> L45
        goto L32
    L24:
        r17 = n().doPost(r12, r10, r13);     // Catch: Throwable -> L45
        goto L23
    L25:
        e.a[] r24 = e.a.f13601a;     // Catch: Throwable -> L45
        r17 = e.a(r12, r10, this.f13661x);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        if ((th instanceof d) == false) goto L49;
        int r25 = th.f13600a;
    L50:
        r11.f51a = r25;
        return r11;
    L49:
        r25 = -1;
        goto L50
    }

    @Override // r7.b
    public final JSONObject e() {
        return this.f13639b;
    }

    @Override // r7.b
    public final List f() {
        return this.A;
    }

    @Override // r7.b
    public final int g() {
        if (this.f13646i > 0) goto L7;
        return 4;
    L7:
        return this.f13646i;
    }

    @Override // r7.b
    public final int h() {
        if (this.f13645h > 0) goto L7;
        return 100;
    L7:
        return this.f13645h;
    }

    @Override // r7.b
    public final int i() {
        if (this.f13647j > 0) goto L7;
        return 15;
    L7:
        return this.f13647j;
    }

    public final StringBuilder k(String r8) {
        StringBuilder r10 = new StringBuilder(r8);
        if (TextUtils.isDigitsOnly(r8) == false) goto L5;
    L20:
        return r10;
    L5:
        if (this.f13657t == null) goto L20;
        if (r8.contains("?") == true) goto L10;
        r10.append("?");
    L10:
        l(r10, "sdk_version", String.valueOf(400));
        Map<String, String> r11 = this.f13657t;
        if (r11 == null) goto L20;
        if (r11.size() <= 0) goto L20;
        Iterator<Map.Entry<String, String>> r12 = r11.entrySet().iterator();
    L16:
        if (r12.hasNext() == false) goto L20;
        Map.Entry<String, String> r13 = r12.next();
        if (r13.getKey() == null) goto L16;
        l(r10, String.valueOf(r13.getKey()), String.valueOf(r13.getValue()));
        goto L16
    }

    public final IHttpService n() {
        if (this.f13649l != null) goto L6;
        this.f13649l = (IHttpService) e8.c.a(IHttpService.class);
    L6:
        return this.f13649l;
    }

    public final SharedPreferences o() {
        String r8 = t2.b.C(this.f13638a);
        return this.f13638a.getSharedPreferences("monitor_config" + this.C + r8, 0);
    }

    public final void p() {
        SharedPreferences r8 = o();
        String r10 = r8.getString("monitor_net_config", null);
        this.f13642e = r8.getLong("monitor_configure_refresh_time", 0);
        boolean r11 = false;
        if (r8.getInt("monitor_config_update", 0) != 1) goto L5;
        r11 = true;
    L5:
        u7.a r12 = u7.a.b.f12503a;
        u7.d r13 = r12.f12499a;
        r12.f12501c.add(this);     // Catch: Throwable -> L19
        u7.a.RunnableC0172a r14 = r12.f12500b;
        r13.d(r14);     // Catch: Throwable -> L19
        r13.e(Message.obtain(r13.f12514d, r14), 30000);     // Catch: Throwable -> L19
    L10:
        if (TextUtils.isEmpty(r10) == false) goto L22;
    L17:
        v();
        return;
    L22:
        this.f13663z = true;     // Catch: Exception -> L16
        JSONObject r15 = new JSONObject(r10);     // Catch: Exception -> L16
        if (r11 == true) goto L14;
        r15.remove("report_host_new");     // Catch: Exception -> L16
    L14:
        u(r15);     // Catch: Exception -> L16
    L16:
        Log.e("monitor_config", "config error");
        goto L17
    }

    public final void r(String r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        if (this.f13663z == true) goto L15;
        b r10 = this.B;     // Catch: Throwable -> L17
        o r8 = new o(r11, r12, r13, r14, System.currentTimeMillis());     // Catch: Throwable -> L17
        LinkedList<o> r15 = r10.f13593a;     // Catch: Throwable -> L17
        monitor-enter(r15);     // Catch: Throwable -> L17
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L7:
        if (r10.f13593a.size() <= r10.f13596d) goto L9;
        r10.f13593a.poll();     // Catch: Throwable -> L12
    L9:
        r10.f13593a.add(r8);     // Catch: Throwable -> L12
        monitor-exit(r15);     // Catch: Throwable -> L12
        goto L22
    L21:
        return;
    L15:
        long r16 = System.currentTimeMillis();     // Catch: Throwable -> L17
        u7.a.b.f12503a.a(new l(this, r11, r12, r13, r14, r16));     // Catch: Throwable -> L17
        return;
    }

    public final void s(String r8, int r10, JSONObject r11, JSONObject r12, JSONObject r13, JSONObject r14, long r15) {
        if (r14 == null) goto L61;
    L5:
        r14.put("log_type", "service_monitor");     // Catch: Throwable -> L57
        r14.put("service", r8);     // Catch: Throwable -> L57
        r14.put("status", r10);     // Catch: Throwable -> L57
        Context r16 = this.f13638a;     // Catch: Throwable -> L57
        int r17 = v7.b.f12768a;     // Catch: Throwable -> L57
        boolean r18 = true;
        NetworkInfo r19 = ((ConnectivityManager) r16.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L24
        if (r19 != null) goto L10;
    L22:
        v7.b.a r20 = v7.b.a.f12769b;     // Catch: Throwable -> L24
    L58:
    L25:
        r14.put("network_type", r20.f12775a);     // Catch: Throwable -> L57
        r14.put("value", r11);     // Catch: Throwable -> L57
        if (r12 == null) goto L28;
        r14.put("category", r12);     // Catch: Throwable -> L57
    L28:
        if (r13 == null) goto L31;
        r14.put("metric", r13);     // Catch: Throwable -> L57
    L31:
        if (r14.isNull("timestamp") == false) goto L33;
        r14.put("timestamp", r15);     // Catch: Throwable -> L57
    L33:
        a r21 = this.f13656s;     // Catch: Throwable -> L57
        String r22 = null;
        if (r21 == null) goto L36;
        String r23 = r21.getSessionId();     // Catch: Throwable -> L57
    L38:
        if (TextUtils.isEmpty(r23) == true) goto L44;
        a r110 = this.f13656s;     // Catch: Throwable -> L57
        if (r110 == null) goto L42;
        r22 = r110.getSessionId();     // Catch: Throwable -> L57
    L42:
        r14.put(QesdkUtils.TAGS.JSON_TAG_SESSION_ID, r22);     // Catch: Throwable -> L57
    L44:
        if (this.f13640c != null) goto L46;
        return;
    L46:
        if (this.f13648k != null) goto L48;
    L53:
        r18 = false;
    L54:
        if (r18 == false) goto L64;
        this.f13640c.b(r14, "service_monitor", "service_monitor");     // Catch: Throwable -> L57
        return;
    L64:
        return;
    L48:
        if (TextUtils.isEmpty(r8) == true) goto L53;
        if (this.f13648k.opt(r8) == null) goto L53;
    L36:
        r23 = null;
        goto L38
        goto L65
    L10:
        if (r19.isAvailable() == false) goto L22;
        int r24 = r19.getType();     // Catch: Throwable -> L24
        if (1 != r24) goto L15;
        r20 = v7.b.a.f12772o;     // Catch: Throwable -> L24
        goto L58
    L15:
        if (r24 == 0) goto L17;
    L21:
        r20 = v7.b.a.f12770m;     // Catch: Throwable -> L24
        goto L58
    L17:
        switch(((TelephonyManager) r16.getSystemService("phone")).getNetworkType()) {
            case 3: goto L20;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L20;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L20;
            case 10: goto L20;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L20;
            case 15: goto L20;
            default: goto L21;
        };     // Catch: Throwable -> L24
    L19:
        r20 = v7.b.a.f12773p;     // Catch: Throwable -> L24
        goto L58
    L20:
        r20 = v7.b.a.f12771n;     // Catch: Throwable -> L24
    L24:
        r20 = v7.b.a.f12770m;     // Catch: Throwable -> L57
    L65:
        return;
    L61:
        r14 = new JSONObject();     // Catch: Throwable -> L57
        goto L5
    }

    public final JSONObject t(int r8, long r10, long r11, String r12, String r13, String r14, String r15) {
        if (TextUtils.isEmpty(r12) == false) goto L22;
        return null;
    L22:
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L21
        r16.put("log_type", r12);     // Catch: Exception -> L21
        r16.put("duration", r10);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r13) == true) goto L9;
        r16.put("uri", Uri.parse(r13));     // Catch: Exception -> L21
    L9:
        if (r11 <= 0) goto L11;
        r16.put("timestamp", r11);     // Catch: Exception -> L21
    L11:
        r16.put("status", r8);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r14) == true) goto L16;
        r16.put("ip", r14);     // Catch: Exception -> L21
    L16:
        if (TextUtils.isEmpty(r15) == true) goto L18;
        r16.put("trace_code", r15);     // Catch: Exception -> L21
    L19:
        r16.put("network_type", e.c(this.f13638a).f13608a);     // Catch: Exception -> L21
        return r16;
    L18:
        r16.put("trace_code", "");     // Catch: Exception -> L21
    L21:
        return null;
    }

    public final synchronized void u(JSONObject r11) {
        monitor-enter(this);
        if (r11 != null) goto L91;
        monitor-exit(this);
        return;
    L91:
        JSONObject r8 = r11.optJSONObject("general");     // Catch: Throwable -> L84
        JSONObject r10 = null;
        if (r8 != null) goto L9;
        JSONObject r12 = null;
    L11:
        if (r12 == null) goto L61;
        JSONObject r13 = r12.optJSONObject("fetch_setting");     // Catch: Throwable -> L84
        if (r13 == null) goto L16;
        this.f13643f = r13.optLong("fetch_setting_interval", 1200);     // Catch: Throwable -> L84
    L16:
        if (this.f13643f >= 600) goto L20;
        this.f13643f = 600;     // Catch: Throwable -> L84
    L20:
        if (((System.currentTimeMillis() - this.f13642e) / 1000) <= this.f13643f) goto L22;
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        monitor-exit(this);
        return;
    L26:
        JSONObject r15 = r12.optJSONObject("report_setting");     // Catch: Throwable -> L84
        if (r15 == null) goto L61;
        ArrayList r16 = new ArrayList();     // Catch: Throwable -> L84
        JSONArray r17 = r15.optJSONArray("hosts");     // Catch: Exception -> L87 Throwable -> L84
        if (r17 == null) goto L49;
        if (r17.length() <= 0) goto L49;
        int r18 = r17.length();     // Catch: Exception -> L87 Throwable -> L84
        int r19 = 0;
    L34:
        if (r19 >= r18) goto L49;
        String r20 = r17.getString(r19);     // Catch: Exception -> L87 Throwable -> L84
        if (this.D == false) goto L43;
        if (r20.contains(".snssdk.") == true) goto L41;
        if (r20.contains(".toutiao.") == false) goto L43;
    L41:
        r16.clear();     // Catch: Exception -> L87 Throwable -> L84
    L43:
        if (TextUtils.isEmpty(r20) == true) goto L47;
        if (r20.indexOf(46) <= 0) goto L47;
        r16.add(r20);     // Catch: Exception -> L87 Throwable -> L84
    L47:
        r19 = r19 + 1;
    L49:
        if (r16.isEmpty() == true) goto L51;
        this.A = n.a(r16);     // Catch: Throwable -> L84
    L51:
        int r21 = 120;
        this.f13644g = r15.optInt("uploading_interval", 120);     // Catch: Throwable -> L84
        if (this.f13644g < 0) goto L55;
        r21 = this.f13644g;     // Catch: Throwable -> L84
    L55:
        this.f13644g = r21;     // Catch: Throwable -> L84
        int r22 = 100;
        this.f13645h = r15.optInt("once_max_count", 100);     // Catch: Throwable -> L84
        if (this.f13645h < 0) goto L59;
        r22 = this.f13645h;     // Catch: Throwable -> L84
    L59:
        this.f13645h = r22;     // Catch: Throwable -> L84
        this.f13646i = r15.optInt("max_retry_count", 4);     // Catch: Throwable -> L84
        this.f13647j = r15.optInt("report_fail_base_interval", 15);     // Catch: Throwable -> L84
        r15.optInt("log_send_switch", 1);     // Catch: Throwable -> L84
        r15.optLong("more_channel_stop_interval", 1800);     // Catch: Throwable -> L84
        this.f13661x = r15.optBoolean("enable_encrypt", true);     // Catch: Throwable -> L84
        r15.optLong("memory_store_cache_max_count", 2000);     // Catch: Throwable -> L84
        this.f13659v = r15.optBoolean("log_remove_switch", false);     // Catch: Throwable -> L84
        goto L61
    L22:
        r14 = false;
    L61:
        if (r11.length() > 0) goto L65;
        this.A = null;     // Catch: Throwable -> L84
        monitor-exit(this);
        return;
    L65:
        JSONObject r23 = r11.optJSONObject("custom_event_settings");     // Catch: Throwable -> L84
        if (r23 == null) goto L68;
        this.f13648k = r23.optJSONObject("allow_service_name");     // Catch: Throwable -> L84
        r23.optJSONObject("allow_log_type");     // Catch: Throwable -> L84
    L68:
        JSONObject r110 = r11.optJSONObject("network_image_modules");     // Catch: Throwable -> L84
        if (r110 == null) goto L72;
        r10 = r110.optJSONObject("network");     // Catch: Throwable -> L84
    L72:
        if (r10 == null) goto L75;
        this.f13650m = r10.optInt("enable_api_error_upload", 0);     // Catch: Throwable -> L84
        this.f13651n = r10.optInt("enable_api_all_upload", 0);     // Catch: Throwable -> L84
        this.f13652o = defpackage.c.X("api_block_list", r10);     // Catch: Throwable -> L84
        this.f13653p = defpackage.c.Y("api_block_list", r10);     // Catch: Throwable -> L84
        this.f13654q = defpackage.c.X("api_allow_list", r10);     // Catch: Throwable -> L84
        this.f13655r = defpackage.c.Y("api_allow_list", r10);     // Catch: Throwable -> L84
    L75:
        if (this.f13641d != null) goto L81;
        q7.b r111 = new q7.b(this.f13638a, this.C);     // Catch: Throwable -> L84
        this.f13641d = r111;     // Catch: Throwable -> L84
        u7.c r24 = u7.c.b.f12508a;     // Catch: Throwable -> L84
        u7.d r25 = r24.f12504a;     // Catch: Throwable -> L84
        r24.f12506c.add(r111);     // Catch: Throwable -> L88
        u7.c.a r26 = r24.f12505b;     // Catch: Throwable -> L84
        r25.d(r26);     // Catch: Throwable -> L88
        r25.e(Message.obtain(r25.f12514d, r26), 5000);     // Catch: Throwable -> L88
    L80:
        Context r27 = r111.f10177f;     // Catch: Throwable -> L84
        String r112 = r111.f10176e;     // Catch: Throwable -> L84
        t7.d.f12299b.put(r112, new t7.a(r27, r112));     // Catch: Throwable -> L84
    L81:
        this.f13641d.d();     // Catch: Throwable -> L84
        monitor-exit(this);
        return;
    L9:
        r12 = r8.optJSONObject("slardar_api_settings");     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        throw th;
    }

    public final void v() {
        if (this.f13643f >= 600) goto L6;
        this.f13643f = 600;
    L6:
        if (((System.currentTimeMillis() - this.f13642e) / 1000) <= this.f13643f) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == true) goto L11;
        return;
    L11:
        if (e.d(this.f13638a) == true) goto L13;
        return;
    L13:
        monitor-enter(m.class);
        this.f13642e = System.currentTimeMillis();     // Catch: Throwable -> L18
        monitor-exit(m.class);     // Catch: Throwable -> L18
        u7.a.b.f12503a.a(new h(this));     // Catch: Throwable -> L22
        return;
    L29:
        return;
    L18:
        th = move-exception;
        throw th;
    L8:
        r8 = false;
        goto L9
    }
}
