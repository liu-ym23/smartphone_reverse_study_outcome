package c3;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.j;
import com.bytedance.frameworks.baselib.network.http.util.k;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n4.c;
import okhttp3.z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile b f615n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static boolean f616o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f624h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f625i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<String> f626j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f627k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f628l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private c3.a f629m;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f632c;

        a(b r10, String r11, String r12, String r13) {
            this.f630a = r11;
            this.f631b = r12;
            this.f632c = r13;
        }
    }

    /* JADX INFO: renamed from: c3.b$b, reason: collision with other inner class name */
    public interface InterfaceC0028b {
        void a(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110);
    }

    static {
    }

    private b() {
        this.f617a = "";
        this.f618b = "";
        this.f619c = "";
        this.f620d = "";
        this.f621e = "";
        this.f622f = "";
        this.f623g = "";
        this.f625i = new ArrayList();
        this.f626j = new ArrayList();
    }

    private boolean a(c r10, c.a r11) {
        if (TextUtils.isEmpty(r10.A()) == false) goto L6;
        return false;
    L6:
        if ("/get_domains/v5/".equals(r10.A()) == false) goto L8;
        return true;
    L8:
        Iterator<String> r12 = this.f625i.iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        if (k.i(r10.A(), r12.next()) == false) goto L10;
        boolean r13 = true;
    L15:
        if (r13 == true) goto L17;
        return false;
    L17:
        j r14 = new j(r10.G());
        r14.b("okhttp_version", "4.2.228.21-doubao");
        r14.b("use_store_region_cookie", NetConst.ENCRYPT_VERISON_CODE);
        r11.f(r14.c());
        return true;
    L14:
        r13 = false;
        goto L15
    }

    private boolean d(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        Iterator<String> r11 = this.f625i.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        if (k.i(r10, r11.next()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private a e(List<String> r10) {
        if (r10 != null) goto L5;
    L31:
        return null;
    L5:
        if (r10.isEmpty() == true) goto L31;
        if (f616o == false) goto L10;
        String r11 = "store-region=";
        String r12 = "store-region-src=";
    L11:
        Iterator<String> r13 = r10.iterator();
        String r14 = "";
        String r15 = "";
        String r16 = r15;
    L13:
        if (r13.hasNext() == false) goto L24;
        String r17 = r13.next();
        if (r17.toLowerCase().startsWith(r11) == true) goto L16;
        if (r17.toLowerCase().startsWith(r12) == true) goto L19;
        if (r17.toLowerCase().startsWith("region_legacy_user=") == false) goto L13;
        r16 = r17;
        goto L13
    L19:
        r15 = r17;
        goto L13
    L16:
        r14 = r17;
        goto L13
    L24:
        if (TextUtils.isEmpty(r14) == false) goto L26;
        return null;
    L26:
        String r18 = f(r14);
        if (r18.isEmpty() == false) goto L30;
        return null;
    L30:
        return new a(this, r18, f(r15), f(r16));
    L10:
        r11 = "store-country-code=";
        r12 = "store-country-code-src=";
        goto L11
    }

    private String f(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return "";
    L5:
        String[] r11 = r10.split(";");
        if (r11 != null) goto L8;
    L15:
        return "";
    L8:
        if (r11.length <= 0) goto L15;
        String[] r12 = r11[0].trim().split("=");
        if (r12 == null) goto L15;
        if (r12.length != 2) goto L15;
        return r12[1];
    }

    private static String g(Map<String, List<String>> r10, String r11) {
        if (r10 != null) goto L5;
    L18:
        return "";
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        List<String> r12 = null;
        Iterator<String> r13 = r10.keySet().iterator();
    L9:
        if (r13.hasNext() == false) goto L13;
        String r14 = r13.next();
        if (r11.equalsIgnoreCase(r14) == false) goto L9;
        r12 = r10.get(r14);
    L13:
        if (r12 == null) goto L18;
        if (r12.size() <= 0) goto L18;
        return r12.get(r12.size() - 1);
    }

    private String j(String r10, String r11, boolean r12) {
        JSONObject r13 = new JSONObject();
        JSONObject r14 = new JSONObject();
        r14.put("url", r11);     // Catch: JSONException -> L5
        r14.put("logId", r10);     // Catch: JSONException -> L5
        r13.put("tnc", r12);     // Catch: JSONException -> L5
        r13.put("base", r14);     // Catch: JSONException -> L5
        r13.put("report_time", System.currentTimeMillis());     // Catch: JSONException -> L5
        r13.put("store_region", this.f617a);     // Catch: JSONException -> L5
        r13.put("source", this.f618b);     // Catch: JSONException -> L5
        r13.put("region_legacy_user", this.f619c);     // Catch: JSONException -> L5
        r13.put("local", this.f621e);     // Catch: JSONException -> L5
    L8:
        return r13.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static String k() {
        return "ttnet_store_region";
    }

    public static b m() {
        if (f615n != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f615n != null) goto L9;
        f615n = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f615n;
    }

    public static boolean n() {
        return f616o;
    }

    private void p() {
        SharedPreferences r10 = this.f627k.getSharedPreferences("ttnet_store_region", 0);
        this.f617a = r10.getString("store_region", "");
        this.f618b = r10.getString("store_region_src", "");
        this.f619c = r10.getString("region_legacy_user", "");
        this.f620d = r10.getString("store_sec_uid", "");
        this.f622f = r10.getString("update_region_info", "");
        this.f624h = r10.getBoolean("received_region_config", false);
        if (TextUtils.isEmpty(this.f617a) == true) goto L5;
    L7:
        this.f629m.onStoreIdcChanged("", this.f617a, this.f618b, this.f619c, this.f620d, "");
        if (Logger.debug() == false) goto L11;
        Logger.d("StoreRegionManager", "Init region:" + this.f617a + " sec_uid:" + this.f620d + " source:" + this.f618b + " local:" + this.f621e + " init region:" + this.f623g + " region config:" + this.f624h);
        return;
    L11:
        return;
    L5:
        if (TextUtils.isEmpty(this.f621e) == true) goto L7;
        this.f617a = this.f621e;
        this.f618b = "local";
        goto L7
    }

    public void b(Map<String, String> r10) {
        if (this.f628l == false) goto L12;
        if (r10 != null) goto L7;
        return;
    L7:
        if (this.f624h == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.f623g) == true) goto L14;
        r10.put("x-tt-app-init-region", this.f623g);
        return;
    L14:
        return;
    }

    public c c(c r10) {
        if (this.f628l == true) goto L5;
    L44:
        return null;
    L5:
        if (TextUtils.isEmpty(r10.w()) == true) goto L44;
        if (r10.L() == false) goto L10;
        return null;
    L10:
        boolean r11 = false;
        Iterator<String> r12 = this.f626j.iterator();
    L11:
        boolean r13 = true;
        if (r12.hasNext() == false) goto L16;
        if (k.i(r10.w(), r12.next()) == false) goto L11;
        r11 = true;
    L16:
        ArrayList r14 = new ArrayList();
        if (this.f624h == false) goto L19;
    L21:
        r13 = r11;
    L22:
        if (r13 == true) goto L25;
        return null;
    L25:
        if (r10.v() == null) goto L27;
        r14.addAll(r10.v());
    L27:
        c.a r15 = r10.O();
        if (a(r10, r15) == false) goto L32;
    L29:
        r15.b(r14);
        return r15.a();
    L32:
        if (this.f617a.isEmpty() == true) goto L35;
        String r16 = this.f617a;
    L39:
        if (TextUtils.isEmpty(r16) == true) goto L42;
        r14.add(new n4.b("x-tt-store-region", r16));
    L42:
        if (TextUtils.isEmpty(this.f618b) == true) goto L29;
        r14.add(new n4.b("x-tt-store-region-src", this.f618b));
        goto L29
    L35:
        if (this.f621e.isEmpty() == true) goto L37;
        r16 = this.f621e;
        goto L39
    L37:
        r16 = "";
        goto L39
    L19:
        if (TextUtils.isEmpty(this.f623g) == true) goto L21;
        r14.add(new n4.b("x-tt-app-init-region", this.f623g));
        goto L22
    }

    public JSONObject h() {
        if (this.f628l == true) goto L6;
        return null;
    L6:
        JSONObject r10 = new JSONObject();
        r10.put(Api.KEY_REGION, this.f617a);     // Catch: JSONException -> L9
        r10.put("source", this.f618b);     // Catch: JSONException -> L9
        r10.put("local_region", this.f621e);     // Catch: JSONException -> L9
        r10.put("update_region", this.f622f);     // Catch: JSONException -> L9
    L11:
        return r10;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public String i() {
        return this.f617a;
    }

    public void l(String r10, String r11, String r12, Context r13, c3.a r14) {
        if (Logger.debug() == false) goto L6;
        Logger.d("StoreRegionManager", "rule json: " + r11);
    L6:
        if (TextUtils.isEmpty(r11) == true) goto L44;
        if (r13 == null) goto L45;
        if (r14 == null) goto L48;
        JSONObject r15 = new JSONObject(r11);     // Catch: JSONException -> L33
        JSONArray r16 = r15.optJSONArray("update_store_idc_path_list");     // Catch: JSONException -> L33
        int r17 = 0;
        int r18 = 0;
    L12:
        if (r18 >= r16.length()) goto L17;
        String r19 = r16.getString(r18);     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r19) == true) goto L16;
        this.f625i.add(r19);     // Catch: JSONException -> L33
    L16:
        r18 = r18 + 1;     // Catch: JSONException -> L33
        goto L12
    L17:
        JSONArray r20 = r15.optJSONArray("add_store_idc_host_list");     // Catch: JSONException -> L33
    L19:
        if (r17 >= r20.length()) goto L24;
        String r21 = r20.getString(r17);     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r21) == true) goto L23;
        this.f626j.add(r21);     // Catch: JSONException -> L33
    L23:
        r17 = r17 + 1;     // Catch: JSONException -> L33
        goto L19
    L24:
        this.f627k = r13;     // Catch: JSONException -> L33
        this.f629m = r14;     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r10) == true) goto L28;
        this.f621e = r10.toLowerCase();     // Catch: JSONException -> L33
    L28:
        if (this.f626j.isEmpty() == false) goto L30;
        return;
    L30:
        if (this.f625i.isEmpty() == true) goto L47;
        this.f628l = true;     // Catch: JSONException -> L33
        this.f623g = r12;     // Catch: JSONException -> L33
        p();     // Catch: JSONException -> L33
        return;
    L47:
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
        return;
    L48:
        return;
    L45:
        return;
    }

    public boolean o() {
        return this.f628l;
    }

    public void q(String r10, String r11, String r12, String r13, String r14, String r15) {
        if (this.f627k != null) goto L5;
        return;
    L5:
        if (this.f628l == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r11) == false) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r12) == false) goto L13;
        return;
    L13:
        if (this.f617a.equalsIgnoreCase(r11) == true) goto L15;
    L19:
        this.f620d = r14;
        this.f617a = r11;
        this.f618b = r12;
        this.f619c = r13;
        if (Logger.debug() == false) goto L22;
        Logger.d("StoreRegionManager", "saveStoreRegionForCronet region:" + this.f617a + " source:" + this.f618b + " sec uid:" + this.f620d);
    L22:
        SharedPreferences.Editor r16 = this.f627k.getSharedPreferences("ttnet_store_region", 0).edit();
        r16.putString("store_region", this.f617a);
        r16.putString("store_region_src", this.f618b);
        r16.putString("store_sec_uid", this.f620d);
        r16.apply();
        return;
    L15:
        if (this.f618b.equalsIgnoreCase(r12) == false) goto L19;
        if (this.f620d.equalsIgnoreCase(r14) == false) goto L19;
    }

    public void r() {
        if (this.f624h == true) goto L6;
        this.f624h = true;
        SharedPreferences.Editor r10 = this.f627k.getSharedPreferences("ttnet_store_region", 0).edit();
        r10.putBoolean("received_region_config", true);
        r10.apply();
        return;
    }

    public void s(HttpURLConnection r19, byte[] r20, InterfaceC0028b r21) {
        if (r19 != null) goto L5;
        return;
    L5:
        if (this.f628l == true) goto L8;
        return;
    L8:
        if (d(r19.getURL().getPath()) == true) goto L10;
        return;
    L10:
        Map<String, List<String>> r10 = r19.getHeaderFields();
        List<String> r11 = r10.get(Api.KEY_SET_COOKIE);
        if (r11 != null) goto L13;
    L14:
        r11 = r10.get(Api.KEY_SET_COOKIE.toLowerCase());
    L15:
        a r12 = e(r11);
        String r13 = g(r10, "x-tt-with-tnc");
        String r14 = "";
        if (TextUtils.isEmpty(r13) == false) goto L18;
    L23:
        String r15 = "";
    L24:
        if (r12 == null) goto L26;
    L28:
        if (r12 != null) goto L30;
        r12 = new a(this, "", "", "");
    L30:
        String r16 = g(r10, "x-tt-store-sec-uid");
        String r17 = g(r10, "x-tt-logid");
        String r18 = g(r10, "x-tt-tnc-attr");
        String r110 = g(r10, "x-ss-etag");
        String r111 = g(r10, "x-tt-tnc-config");
        JSONObject r22 = new JSONObject();
        r14 = r19.getURL().getPath();     // Catch: JSONException -> L33
        r22.put("url", r19.getURL().getHost() + r14);     // Catch: JSONException -> L33
        r22.put("store_region", r12.f630a + "," + r12.f631b);     // Catch: JSONException -> L33
        r22.put("region_legacy_user", r12.f632c);     // Catch: JSONException -> L33
        r22.put("logId", r17);     // Catch: JSONException -> L33
    L35:
        r21.a(r14, r12.f630a, r12.f631b, r12.f632c, r18, r110, r111, r15, r22.toString(), r16, r17);
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L26:
        if (TextUtils.isEmpty(r15) == false) goto L28;
        return;
    L18:
        if (r13.equals(NetConst.ENCRYPT_VERISON_CODE) == false) goto L23;
        r15 = "{\"data\": " + new JSONObject(new String(r20)).getString("tnc_data") + "}";     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L13:
        if (r11.isEmpty() == false) goto L15;
        goto L14
    }

    public void t(z r22, String r23, byte[] r24) {
        if (this.f628l == true) goto L55;
        return;
    L55:
        URI r10 = k.l(r23);     // Catch: Exception -> L52
        String r11 = r10.getHost() + r10.getPath();     // Catch: Exception -> L52
        if (TextUtils.isEmpty(r10.getPath()) == false) goto L10;
        return;
    L10:
        if (d(r10.getPath()) == true) goto L12;
        return;
    L12:
        a r12 = e(r22.u(Api.KEY_SET_COOKIE));
        String r13 = r22.p("x-ss-etag");
        String r14 = r22.p("x-tt-tnc-attr");
        String r15 = r22.p("x-tt-with-tnc");
        JSONObject r16 = null;
        if (TextUtils.isEmpty(r15) == true) goto L21;
        if (r15.equals(NetConst.ENCRYPT_VERISON_CODE) == false) goto L21;
        r16 = new JSONObject(new String(r24)).getJSONObject("tnc_data");     // Catch: JSONException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
    L21:
        if (r12 != null) goto L25;
        if (r16 == null) goto L25;
        this.f629m.b(r16, r13, r14, false);
        return;
    L25:
        if (r12 != null) goto L28;
        return;
    L28:
        if (Logger.debug() == false) goto L30;
        Logger.d("StoreRegionManager", "origin region:" + this.f617a + " sec_uid:" + this.f620d + " source:" + this.f618b + " local:" + this.f621e);
    L30:
        boolean r17 = !this.f617a.equals(r12.f630a);
        String r18 = r22.p("x-tt-store-sec-uid");
        if (r18 != null) goto L33;
        r18 = "";
    L33:
        SharedPreferences.Editor r19 = this.f627k.getSharedPreferences("ttnet_store_region", 0).edit();
        if (this.f617a.equals(r12.f630a) == true) goto L36;
    L41:
        String r20 = r12.f630a;
        this.f617a = r20;
        this.f618b = r12.f631b;
        this.f620d = r18;
        r19.putString("store_region", r20);
        r19.putString("store_region_src", this.f618b);
        r19.putString("store_sec_uid", this.f620d);
        boolean r21 = true;
    L43:
        if (this.f619c.equals(r12.f632c) == true) goto L46;
        String r25 = r12.f632c;
        this.f619c = r25;
        r19.putString("region_legacy_user", r25);
        r21 = true;
    L46:
        if (Logger.debug() == false) goto L48;
        Logger.d("StoreRegionManager", "update region:" + this.f617a + " sec_uid:" + this.f620d + " source:" + this.f618b + " regionLegacyUser:" + this.f619c + "local:" + this.f621e);
        StringBuilder r110 = new StringBuilder();
        r110.append("save config:");
        r110.append(r21);
        r110.append(" update tnc:");
        r110.append(r17);
        Logger.d("StoreRegionManager", r110.toString());
    L48:
        boolean r26 = this.f629m.b(r16, r13, r14, r17);
        if (r21 == false) goto L57;
        String r27 = r22.p("x-tt-logid");
        String r28 = r10.getPath() + "," + r27 + "," + r12.f630a + "," + r12.f631b;
        this.f622f = r28;
        r19.putString("update_region_info", r28);
        r19.apply();
        this.f629m.a(j(r27, r11, r26), "store_idc");
        this.f629m.onStoreIdcChanged("", this.f617a, this.f618b, this.f619c, this.f620d, r27);
        return;
    L57:
        return;
    L36:
        if (this.f618b.equals(r12.f631b) == false) goto L41;
        if (r18.equals(this.f620d) == false) goto L41;
        r21 = false;
    }
}
