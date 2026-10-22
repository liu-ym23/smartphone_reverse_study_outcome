package com.bytedance.frameworks.baselib.network.http.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.j;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f2425a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f2426b;
    private static boolean p;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private boolean j;
    private List<String> k;
    private List<String> l;
    private Context m;
    private boolean n;
    private com.bytedance.frameworks.baselib.network.http.d.a o;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f2427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f2428b;
        String c;
        final /* synthetic */ b d;

        a(b r1, String r2, String r3, String r4) {
            this.d = r1;
            this.f2427a = r2;
            this.f2428b = r3;
            this.c = r4;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.d.b$b, reason: collision with other inner class name */
    public interface InterfaceC0128b {
        void notifyStoreRegionUpdatedForCronet(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11);
    }

    static {
    }

    private b() {
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.k = new ArrayList();
        this.l = new ArrayList();
    }

    private a a(List<String> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L5;
    L31:
        return null;
    L5:
        if (r12.isEmpty() == true) goto L31;
        if (p == false) goto L10;
        String r2 = "store-region=";
        String r3 = "store-region-src=";
    L11:
        Iterator r13 = r12.iterator();
        String r4 = "";
        String r5 = "";
        String r6 = r5;
    L13:
        if (r13.hasNext() == false) goto L24;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        if (r7.toLowerCase().startsWith(r2) == true) goto L16;
        if (r7.toLowerCase().startsWith(r3) == true) goto L19;
        if (r7.toLowerCase().startsWith("region_legacy_user=") == false) goto L13;
        r6 = r7;
        goto L13
    L19:
        r5 = r7;
        goto L13
    L16:
        r4 = r7;
        goto L13
    L24:
        if (TextUtils.isEmpty(r4) == false) goto L26;
        return null;
    L26:
        String r14 = b(r4);
        if (r14.isEmpty() == false) goto L30;
        return null;
    L30:
        return new a(this, r14, b(r5), b(r6));
    L10:
        r2 = "store-country-code=";
        r3 = "store-country-code-src=";
        goto L11
    }

    public static b a() {
        if (f2426b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2426b != null) goto L9;
        f2426b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f2426b;
    }

    private String a(String r4, String r5, boolean r6) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        r1.put("url", r5);     // Catch: JSONException -> L5
        r1.put("logId", r4);     // Catch: JSONException -> L5
        r0.put("tnc", r6);     // Catch: JSONException -> L5
        r0.put("base", r1);     // Catch: JSONException -> L5
        r0.put("report_time", System.currentTimeMillis());     // Catch: JSONException -> L5
        r0.put("store_region", this.c);     // Catch: JSONException -> L5
        r0.put(AILabCheckPermissionTask.KEY_SOURCE, this.d);     // Catch: JSONException -> L5
        r0.put("region_legacy_user", this.e);     // Catch: JSONException -> L5
        r0.put("local", this.g);     // Catch: JSONException -> L5
    L8:
        return r0.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private static String a(Map<String, List<String>> r6, String r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
    L18:
        return "";
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L18;
        List r2 = null;
        Iterator r3 = r8.keySet().iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        if (r7.equalsIgnoreCase(r4) == false) goto L9;
        r2 = (List) ZeusTransformUtils.preCheckCast(r8.get(r4), List.class, "com.obric.memorydata.plugin");
    L13:
        if (r2 == null) goto L18;
        if (r2.size() <= 0) goto L18;
        return (String) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), String.class, "com.obric.memorydata.plugin");
    }

    private boolean a(Request r6, Request.Builder r7) {
        if (TextUtils.isEmpty(r6.getPath()) == false) goto L6;
        return false;
    L6:
        if ("/get_domains/v5/".equals(r6.getPath()) == false) goto L8;
        return true;
    L8:
        Iterator<String> r5 = this.k.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        if (k.a(r6.getPath(), (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L10;
        boolean r8 = true;
    L15:
        if (r8 == true) goto L17;
        return false;
    L17:
        j r9 = new j(r6.getUrl());
        r9.a("okhttp_version", "4.2.243.22-doubao");
        r9.a("use_store_region_cookie", "1");
        r7.url(r9.a());
        return true;
    L14:
        r8 = false;
        goto L15
    }

    private boolean a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        Iterator<String> r4 = this.k.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        if (k.a(r5, (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private String b(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return "";
    L5:
        String[] r2 = r3.split(";");
        if (r2 != null) goto L8;
    L15:
        return "";
    L8:
        if (r2.length <= 0) goto L15;
        String[] r4 = r2[0].trim().split("=");
        if (r4 == null) goto L15;
        if (r4.length != 2) goto L15;
        return r4[1];
    }

    public static boolean f() {
        return p;
    }

    public static String g() {
        return "ttnet_store_region";
    }

    private void h() {
        SharedPreferences r0 = this.m.getSharedPreferences("ttnet_store_region", 0);
        this.c = r0.getString("store_region", "");
        this.d = r0.getString("store_region_src", "");
        this.e = r0.getString("region_legacy_user", "");
        this.f = r0.getString("store_sec_uid", "");
        this.h = r0.getString("update_region_info", "");
        this.j = r0.getBoolean("received_region_config", false);
        if (TextUtils.isEmpty(this.c) == true) goto L5;
    L7:
        this.o.a("", this.c, this.d, this.e, this.f, "");
        if (Logger.debug() == false) goto L11;
        Logger.d("StoreRegionManager", "Init region:" + this.c + " sec_uid:" + this.f + " source:" + this.d + " local:" + this.g + " init region:" + this.i + " region config:" + this.j);
        return;
    L11:
        return;
    L5:
        if (TextUtils.isEmpty(this.g) == true) goto L7;
        this.c = this.g;
        this.d = "local";
        goto L7
    }

    public Request a(Request r8) {
        if (this.n == true) goto L5;
    L44:
        return null;
    L5:
        if (TextUtils.isEmpty(r8.getHost()) == true) goto L44;
        if (r8.isPureRequest() == false) goto L10;
        return null;
    L10:
        boolean r0 = false;
        Iterator<String> r2 = this.l.iterator();
    L11:
        boolean r4 = true;
        if (r2.hasNext() == false) goto L16;
        if (k.a(r8.getHost(), (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L11;
        r0 = true;
    L16:
        ArrayList r3 = new ArrayList();
        if (this.j == false) goto L19;
    L21:
        r4 = r0;
    L22:
        if (r4 == true) goto L25;
        return null;
    L25:
        if (r8.getHeaders() == null) goto L27;
        r3.addAll(r8.getHeaders());
    L27:
        Request.Builder r1 = r8.newBuilder();
        if (a(r8, r1) == false) goto L32;
    L29:
        r1.headers(r3);
        return r1.build();
    L32:
        if (this.c.isEmpty() == true) goto L35;
        String r9 = this.c;
    L39:
        if (TextUtils.isEmpty(r9) == true) goto L42;
        r3.add(new Header("x-tt-store-region", r9));
    L42:
        if (TextUtils.isEmpty(this.d) == true) goto L29;
        r3.add(new Header("x-tt-store-region-src", this.d));
        goto L29
    L35:
        if (this.g.isEmpty() == true) goto L37;
        r9 = this.g;
        goto L39
    L37:
        r9 = "";
        goto L39
    L19:
        if (TextUtils.isEmpty(this.i) == true) goto L21;
        r3.add(new Header("x-tt-app-init-region", this.i));
        goto L22
    }

    public void a(String r7, String r8, String r9, Context r10, com.bytedance.frameworks.baselib.network.http.d.a r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        com.bytedance.frameworks.baselib.network.http.d.a r13 = (com.bytedance.frameworks.baselib.network.http.d.a) ZeusTransformUtils.wrapperContextForParams(r11, com.bytedance.frameworks.baselib.network.http.d.a.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L6;
        Logger.d("StoreRegionManager", "rule json: " + r8);
    L6:
        if (TextUtils.isEmpty(r8) == true) goto L44;
        if (r12 == null) goto L45;
        if (r13 == null) goto L48;
        JSONObject r0 = new JSONObject(r8);     // Catch: JSONException -> L33
        JSONArray r14 = r0.optJSONArray("update_store_idc_path_list");     // Catch: JSONException -> L33
        int r2 = 0;
        int r3 = 0;
    L12:
        if (r3 >= r14.length()) goto L17;
        String r4 = r14.getString(r3);     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r4) == true) goto L16;
        this.k.add(r4);     // Catch: JSONException -> L33
    L16:
        r3 = r3 + 1;     // Catch: JSONException -> L33
        goto L12
    L17:
        JSONArray r15 = r0.optJSONArray("add_store_idc_host_list");     // Catch: JSONException -> L33
    L19:
        if (r2 >= r15.length()) goto L24;
        String r1 = r15.getString(r2);     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r1) == true) goto L23;
        this.l.add(r1);     // Catch: JSONException -> L33
    L23:
        r2 = r2 + 1;     // Catch: JSONException -> L33
        goto L19
    L24:
        this.m = ZeusTransformUtils.wrapperContext(r12, "com.obric.memorydata.plugin");     // Catch: JSONException -> L33
        this.o = r13;     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r7) == true) goto L28;
        this.g = r7.toLowerCase();     // Catch: JSONException -> L33
    L28:
        if (this.l.isEmpty() == false) goto L30;
        return;
    L30:
        if (this.k.isEmpty() == true) goto L47;
        this.n = true;     // Catch: JSONException -> L33
        this.i = r9;     // Catch: JSONException -> L33
        h();     // Catch: JSONException -> L33
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

    public void a(String r1, String r2, String r3, String r4, String r5, String r6) {
        if (this.m != null) goto L5;
        return;
    L5:
        if (this.n == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r3) == false) goto L13;
        return;
    L13:
        if (f2425a == true) goto L22;
        if (this.c == null) goto L20;
        if (this.d != null) goto L22;
    L20:
        throw new AssertionError();
    L22:
        if (this.c.equalsIgnoreCase(r2) == true) goto L24;
    L28:
        this.f = r5;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        if (Logger.debug() == false) goto L31;
        Logger.d("StoreRegionManager", "saveStoreRegionForCronet region:" + this.c + " source:" + this.d + " sec uid:" + this.f);
    L31:
        SharedPreferences.Editor r7 = this.m.getSharedPreferences("ttnet_store_region", 0).edit();
        r7.putString("store_region", this.c);
        r7.putString("store_region_src", this.d);
        r7.putString("store_sec_uid", this.f);
        r7.apply();
        return;
    L24:
        if (this.d.equalsIgnoreCase(r3) == false) goto L28;
        if (this.f.equalsIgnoreCase(r5) == false) goto L28;
    }

    public void a(HttpURLConnection r16, byte[] r17, InterfaceC0128b r18) {
        InterfaceC0128b r3 = (InterfaceC0128b) ZeusTransformUtils.wrapperContextForParams(r18, InterfaceC0128b.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L5;
        return;
    L5:
        if (this.n == true) goto L8;
        return;
    L8:
        if (a(r16.getURL().getPath()) == true) goto L10;
        return;
    L10:
        Map<String, List<String>> r4 = r16.getHeaderFields();
        List<String> r5 = (List) ZeusTransformUtils.preCheckCast(r4.get(Api.KEY_SET_COOKIE), List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L13;
    L14:
        r5 = (List) ZeusTransformUtils.preCheckCast(r4.get(Api.KEY_SET_COOKIE.toLowerCase()), List.class, "com.obric.memorydata.plugin");
    L15:
        a r2 = a(r5);
        String r0 = a(r4, "x-tt-with-tnc");
        String r6 = "";
        if (TextUtils.isEmpty(r0) == false) goto L18;
    L23:
        String r11 = "";
    L24:
        if (r2 == null) goto L26;
    L28:
        if (r2 != null) goto L30;
        r2 = new a(this, "", "", "");
    L30:
        String r13 = a(r4, "x-tt-store-sec-uid");
        String r14 = a(r4, "x-tt-logid");
        String r8 = a(r4, "x-tt-tnc-attr");
        String r9 = a(r4, "x-ss-etag");
        String r10 = a(r4, "x-tt-tnc-config");
        JSONObject r1 = new JSONObject();
        r6 = r16.getURL().getPath();     // Catch: JSONException -> L33
        r1.put("url", r16.getURL().getHost() + r6);     // Catch: JSONException -> L33
        r1.put("store_region", r2.f2427a + "," + r2.f2428b);     // Catch: JSONException -> L33
        r1.put("region_legacy_user", r2.c);     // Catch: JSONException -> L33
        r1.put("logId", r14);     // Catch: JSONException -> L33
    L35:
        r3.notifyStoreRegionUpdatedForCronet(r6, r2.f2427a, r2.f2428b, r2.c, r8, r9, r10, r11, r1.toString(), r13, r14);
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L26:
        if (TextUtils.isEmpty(r11) == false) goto L28;
        return;
    L18:
        if (r0.equals("1") == false) goto L23;
        r11 = "{\"data\": " + new JSONObject(new String(r17)).getString("tnc_data") + "}";     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L13:
        if (r5.isEmpty() == false) goto L15;
        goto L14
    }

    public void a(Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (this.n == false) goto L12;
        if (r4 != null) goto L7;
        return;
    L7:
        if (this.j == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.i) == true) goto L14;
        r4.put("x-tt-app-init-region", this.i);
        return;
    L14:
        return;
    }

    public void a(Response r22, String r23, byte[] r24) {
        if (this.n == true) goto L54;
        return;
    L54:
        URI r3 = k.a(r23);     // Catch: Exception -> L53
        String r4 = r3.getHost() + r3.getPath();     // Catch: Exception -> L53
        if (r3 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r3.getPath()) == false) goto L11;
        return;
    L11:
        if (a(r3.getPath()) == true) goto L13;
        return;
    L13:
        a r5 = a(r22.headers(Api.KEY_SET_COOKIE));
        String r6 = r22.header("x-ss-etag");
        String r7 = r22.header("x-tt-tnc-attr");
        String r0 = r22.header("x-tt-with-tnc");
        JSONObject r8 = null;
        if (TextUtils.isEmpty(r0) == true) goto L22;
        if (r0.equals("1") == false) goto L22;
        r8 = new JSONObject(new String(r24)).getJSONObject("tnc_data");     // Catch: JSONException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L22:
        if (r5 != null) goto L26;
        if (r8 == null) goto L26;
        this.o.a(r8, r6, r7, false);
        return;
    L26:
        if (r5 != null) goto L29;
        return;
    L29:
        if (Logger.debug() == false) goto L31;
        Logger.d("StoreRegionManager", "origin region:" + this.c + " sec_uid:" + this.f + " source:" + this.d + " local:" + this.g);
    L31:
        boolean r9 = !this.c.equals(r5.f2427a);
        String r14 = r22.header("x-tt-store-sec-uid");
        if (r14 != null) goto L34;
        r14 = "";
    L34:
        SharedPreferences.Editor r13 = this.m.getSharedPreferences("ttnet_store_region", 0).edit();
        if (this.c.equals(r5.f2427a) == true) goto L37;
    L42:
        this.c = r5.f2427a;
        this.d = r5.f2428b;
        this.f = r14;
        r13.putString("store_region", this.c);
        r13.putString("store_region_src", this.d);
        r13.putString("store_sec_uid", this.f);
        boolean r1 = true;
    L44:
        if (this.e.equals(r5.c) == true) goto L47;
        String r2 = r5.c;
        this.e = r2;
        r13.putString("region_legacy_user", r2);
        r1 = true;
    L47:
        if (Logger.debug() == false) goto L49;
        Logger.d("StoreRegionManager", "update region:" + this.c + " sec_uid:" + this.f + " source:" + this.d + " regionLegacyUser:" + this.e + "local:" + this.g);
        Logger.d("StoreRegionManager", "save config:" + r1 + " update tnc:" + r9);
    L49:
        boolean r10 = this.o.a(r8, r6, r7, r9);
        if (r1 == false) goto L59;
        String r11 = r22.header("x-tt-logid");
        String r12 = r3.getPath() + "," + r11 + "," + r5.f2427a + "," + r5.f2428b;
        this.h = r12;
        r13.putString("update_region_info", r12);
        r13.apply();
        this.o.a(a(r11, r4, r10), "store_idc");
        this.o.a("", this.c, this.d, this.e, this.f, r11);
        return;
    L59:
        return;
    L37:
        if (this.d.equals(r5.f2428b) == false) goto L42;
        if (r14.equals(this.f) == false) goto L42;
        r1 = false;
    }

    public void b() {
        if (this.j == true) goto L6;
        this.j = true;
        SharedPreferences.Editor r3 = this.m.getSharedPreferences("ttnet_store_region", 0).edit();
        r3.putBoolean("received_region_config", true);
        r3.apply();
        return;
    }

    public boolean c() {
        return this.n;
    }

    public String d() {
        return this.c;
    }

    public JSONObject e() {
        if (this.n == true) goto L6;
        return null;
    L6:
        JSONObject r0 = new JSONObject();
        r0.put(Api.KEY_REGION, this.c);     // Catch: JSONException -> L9
        r0.put(AILabCheckPermissionTask.KEY_SOURCE, this.d);     // Catch: JSONException -> L9
        r0.put("local_region", this.g);     // Catch: JSONException -> L9
        r0.put("update_region", this.h);     // Catch: JSONException -> L9
    L11:
        return r0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
