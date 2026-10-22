package com.bytedance.ttnet.clientkey;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.keva.Keva;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.ttnet.h;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import n4.b;
import n4.c;
import n4.d;
import org.json.JSONArray;
import org.json.JSONObject;
import w4.e;

/* JADX INFO: loaded from: classes.dex */
public class ClientKeyManager {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile ClientKeyManager f2790h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Keva f2791i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile boolean f2792j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f2793k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Map<String, String> f2794l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f2795m = "ClientKeyManager";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f2796n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f2797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f2798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2803g;

    static {
    }

    private ClientKeyManager() {
        this.f2797a = new CopyOnWriteArrayList();
        this.f2798b = new CopyOnWriteArrayList();
        this.f2799c = "";
        this.f2800d = "";
        this.f2801e = "";
        this.f2802f = "";
        this.f2803g = true;
    }

    private void d(JSONObject r10) {
        int r11 = 0;
        boolean r12 = true;
        if (r10.optInt("client_key_sign_enabled", 0) <= 0) goto L5;
        boolean r13 = true;
    L6:
        f2792j = r13;
        if (f2792j == true) goto L14;
        if (Logger.debug() == false) goto L11;
        Logger.d(f2795m, "clear client key storage.");
    L11:
        f2791i.clear();
        return;
    L14:
        if (r10.optInt("rewrite_session_enabled", 1) > 0) goto L17;
        r12 = false;
    L17:
        this.f2803g = r12;
        this.f2797a.clear();
        String r14 = r10.optString("update_host_list", null);
        if (TextUtils.isEmpty(r14) == true) goto L26;
        JSONArray r15 = new JSONArray(r14);
        int r16 = 0;
    L21:
        if (r16 >= r15.length()) goto L26;
        String r17 = r15.getString(r16);
        if (TextUtils.isEmpty(r17) == true) goto L25;
        this.f2797a.add(r17);
    L25:
        r16 = r16 + 1;
    L26:
        this.f2798b.clear();
        String r18 = r10.optString("update_path_list", null);
        if (TextUtils.isEmpty(r18) == true) goto L35;
        JSONArray r19 = new JSONArray(r18);
    L30:
        if (r11 >= r19.length()) goto L42;
        String r20 = r19.getString(r11);
        if (TextUtils.isEmpty(r20) == true) goto L34;
        this.f2798b.add(r20);
    L34:
        r11 = r11 + 1;
        goto L30
    L42:
        return;
    L35:
        return;
    L5:
        r13 = false;
        goto L6
    }

    private static String e(String[] r10, long r11, String r13) {
        if (r10 != null) goto L5;
    L33:
        return null;
    L5:
        if (r10.length < 2) goto L33;
        long r12 = 0;
        if (r11 <= 0) goto L33;
        int r14 = r10.length;
        int r15 = 0;
    L11:
        if (r15 >= r14) goto L18;
        String r16 = r10[r15];
        if (TextUtils.isEmpty(r16) == true) goto L17;
        if (r16.toLowerCase().trim().startsWith("Max-Age=".toLowerCase()) == false) goto L17;
        String[] r17 = r16.split("=");
    L19:
        if (r17 == null) goto L33;
        if (r17.length != 2) goto L33;
        long r18 = Long.parseLong(r17[1]);     // Catch: Throwable -> L34
        if (r18 > 0) goto L27;
        return null;
    L27:
        long r19 = r18 - ((System.currentTimeMillis() - r11) / 1000);     // Catch: Throwable -> L34
        if (r19 <= 0) goto L31;
        r12 = r19;
    L31:
        return r13.replaceFirst(r16.trim(), "Max-Age=" + r12);
    L17:
        r15 = r15 + 1;
        goto L11
    L18:
        r17 = null;
        r16 = null;
        goto L19
    }

    private void f(String r10, String r11) {
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L4
        r12.put("report_time", System.currentTimeMillis() + "");     // Catch: Throwable -> L4
        r12.put("cookie_line", r10);     // Catch: Throwable -> L4
        r12.put("session_id", r11);     // Catch: Throwable -> L4
        r12.put("url", this.f2801e);     // Catch: Throwable -> L4
        h.a("cookie_mismatch", r12);     // Catch: Throwable -> L4
        return;
    }

    public static Map<String, String> getClientKeyHeaders() {
        if (f2791i != null) goto L5;
        return null;
    L5:
        if (f2792j == true) goto L8;
        return null;
    L8:
        if (f2793k == false) goto L12;
        return f2794l;
    L12:
        return j(f2791i.getString("client_key", ""), f2791i.getString("kms_version", ""));
    }

    private void h(String r10) {
        CookieHandler r11 = CookieHandler.getDefault();
        if (r11 != null) goto L27;
        return;
    L27:
        URI r12 = i.b(this.f2801e);     // Catch: Throwable -> L26
        if (r12 != null) goto L8;
        return;
    L8:
        Map<String, List<String>> r13 = r11.get(r12, null);     // Catch: Throwable -> L26
        if (r13 != null) goto L11;
        return;
    L11:
        if (r13.isEmpty() == false) goto L13;
        return;
    L13:
        if (r13.containsKey("Cookie") == false) goto L30;
        String r14 = r13.get("Cookie").toString();     // Catch: Throwable -> L26
        if (Logger.debug() == false) goto L18;
        Logger.d(f2795m, "cookieStr: " + r14 + " sessionId: " + this.f2800d);     // Catch: Throwable -> L26
    L18:
        if (TextUtils.isEmpty(r14) == false) goto L20;
        l(r10, r11, r12);     // Catch: Throwable -> L26
        r14 = "empty";
    L22:
        f(r14, r10);     // Catch: Throwable -> L26
        return;
    L20:
        if (r14.contains(this.f2800d) == true) goto L31;
        l(r10, r11, r12);     // Catch: Throwable -> L26
        goto L22
    L31:
        return;
    L30:
        return;
    }

    private static String i(d r10, String r11) {
        b r12 = r10.c(r11);
        if (r12 != null) goto L5;
        return "";
    L5:
        return ("" + r12.toString()) + "; ";
    }

    private static Map<String, String> j(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L11;
        HashMap r12 = new HashMap();
        r12.put("x-bd-client-key", r10);
        r12.put("x-bd-kmsv", r11);
        return r12;
    L11:
        return null;
    }

    public static ClientKeyManager k() {
        if (f2790h != null) goto L15;
        monitor-enter(ClientKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2790h != null) goto L9;
        f2790h = new ClientKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ClientKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return f2790h;
    }

    private void l(String r10, CookieHandler r11, URI r12) {
        if (this.f2803g == true) goto L5;
        return;
    L5:
        LinkedHashMap r13 = new LinkedHashMap();
        ArrayList r14 = new ArrayList();
        r14.add(r10);
        r13.put(Api.KEY_SET_COOKIE, r14);
        r11.put(r12, r13);
        if (Logger.debug() == false) goto L9;
        Logger.d(f2795m, "Refresh session cookie: " + r10);
        return;
    }

    private void m(int r10, String r11, String r12, String r13, String r14, String r15, String r16, d r17, String r18) {
        JSONObject r19 = new JSONObject();
        r19.put("origin_sid", r11);
        r19.put("sid", r12);
        r19.put("origin_key", r13);
        r19.put("key", r14);
        r19.put("origin_kms", r15);
        r19.put("kms", r16);
        if (r17 == null) goto L7;
        String r20 = ((i(r17, "x-tt-token") + i(r17, "x-tt-logid")) + i(r17, "x-bd-lanusk")) + i(r17, "x-bd-lanusv");
        if (TextUtils.isEmpty(r20) == true) goto L7;
        r19.put("headers", r20);
    L7:
        h.b("client_key", r19, r10, r18);
    }

    public void a(List<b> r10, RetrofitMetrics r11) {
        if (f2791i != null) goto L5;
        return;
    L5:
        if (f2792j == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.f2799c) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.f2802f) == true) goto L19;
        Long r12 = Long.valueOf(SystemClock.uptimeMillis());
        r10.add(new b("x-bd-client-key", this.f2799c));
        r10.add(new b("x-bd-kmsv", this.f2802f));
        if (r11 == null) goto L18;
        r11.f2430c0 = SystemClock.uptimeMillis() - r12.longValue();
        r11.f2442i0 = true;
        return;
    L18:
        return;
    }

    public void b(boolean r10) {
        f2793k = r10;
        f2791i = Keva.getRepo("ttnet_client_key_config", 1);     // Catch: Throwable -> L5
    L7:
        Keva r11 = f2791i;
        if (r11 != null) goto L10;
        return;
    L10:
        String r12 = r11.getString("client_key_config", "");
        if (TextUtils.isEmpty(r12) == true) goto L14;
        d(new JSONObject(r12));     // Catch: Throwable -> L37
    L14:
        if (f2792j == true) goto L16;
        return;
    L16:
        String r13 = f2791i.getString("session_id", "");
        long r14 = f2791i.getLong("session_time", 0);
        this.f2801e = f2791i.getString("session_url", "");
        this.f2799c = f2791i.getString("client_key", "");
        String r15 = f2791i.getString("kms_version", "");
        this.f2802f = r15;
        f2794l = j(this.f2799c, r15);
        if (r13.isEmpty() == false) goto L19;
        return;
    L19:
        if (this.f2801e.isEmpty() == true) goto L43;
        String[] r16 = r13.split(";");
        if (r16 == null) goto L27;
        if (r16.length <= 0) goto L27;
        this.f2800d = r16[0].trim();
    L27:
        if (TextUtils.isEmpty(this.f2800d) == false) goto L29;
        return;
    L29:
        String r17 = e(r16, r14, r13);
        if (TextUtils.isEmpty(r17) == true) goto L33;
        r13 = r17;
    L33:
        if (Logger.debug() == false) goto L35;
        Logger.d(f2795m, "client key: " + this.f2799c + " | kms version: " + this.f2802f + " | session cookie: " + r13 + " | sessionid: " + this.f2800d + " | session time: " + r14 + " session url: " + this.f2801e + " config: " + r12);
    L35:
        h(r13);
        return;
    L43:
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public void c(Object r10) {
        if (f2791i != null) goto L5;
        return;
    L5:
        if (e.c(r10) == false) goto L26;
        JSONObject r11 = e.d(r10);     // Catch: Throwable -> L23
        if (r11 == null) goto L11;
        JSONObject r12 = r11.getJSONObject("data").optJSONObject("client_key_config");     // Catch: Throwable -> L23
    L12:
        if (r12 == null) goto L14;
        String r13 = r12.toString();     // Catch: Throwable -> L23
        if (Logger.debug() == false) goto L21;
        Logger.d(f2795m, "config: " + r13);     // Catch: Throwable -> L23
    L21:
        f2791i.storeString("client_key_config", r13);     // Catch: Throwable -> L23
        d(r12);     // Catch: Throwable -> L23
        return;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(f2795m, "clear client key storage.");     // Catch: Throwable -> L23
    L16:
        f2792j = false;     // Catch: Throwable -> L23
        f2791i.clear();     // Catch: Throwable -> L23
        return;
    L11:
        r12 = null;
        goto L12
    L27:
        return;
    }

    public synchronized void g(c r18, d r19) {
        monitor-enter(this);
    L95:
        th = move-exception;
        throw th;
    L5:
        if (f2791i != null) goto L7;
    L93:
        monitor-exit(this);
        return;
    L7:
        if (f2792j == false) goto L93;
        Long r12 = Long.valueOf(SystemClock.uptimeMillis());     // Catch: Throwable -> L95
        URI r10 = null;
        r10 = i.b(r18.G());     // Catch: Throwable -> L98
    L12:
        if (r10 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        int r11 = 1;
        if (this.f2797a.isEmpty() == true) goto L28;
        Iterator<String> r13 = this.f2797a.iterator();     // Catch: Throwable -> L95
    L19:
        if (r13.hasNext() == false) goto L23;
        if (k.i(r10.getHost(), r13.next()) == false) goto L19;
        boolean r14 = true;
    L24:
        if (r14 == true) goto L28;
        monitor-exit(this);
        return;
    L23:
        r14 = false;
    L28:
        if (this.f2798b.isEmpty() == true) goto L35;
        Iterator<String> r15 = this.f2798b.iterator();     // Catch: Throwable -> L95
    L31:
        if (r15.hasNext() == false) goto L35;
        if (k.i(r10.getPath(), r15.next()) == false) goto L31;
        boolean r16 = true;
    L36:
        if (r16 == true) goto L39;
        monitor-exit(this);
        return;
    L39:
        String r17 = "";
        List<b> r20 = r19.h(Api.KEY_SET_COOKIE);     // Catch: Throwable -> L95
        if (r20 != null) goto L42;
    L49:
        String r110 = "";
    L50:
        String[] r21 = r110.split(";");     // Catch: Throwable -> L95
        if (r21 != null) goto L53;
    L55:
        String r111 = r17;
        if (TextUtils.isEmpty(r111) == false) goto L60;
        monitor-exit(this);
        return;
    L60:
        if (Logger.debug() == false) goto L62;
        Logger.d(f2795m, "original sessionid: " + this.f2800d + " new sessionid: " + r111);     // Catch: Throwable -> L95
    L62:
        String r22 = "";
        String r23 = "";
        b r24 = r19.c("x-bd-lanusk");     // Catch: Throwable -> L95
        b r25 = r19.c("x-bd-lanusv");     // Catch: Throwable -> L95
        if (r24 == null) goto L73;
        if (r25 == null) goto L73;
        String r26 = r24.b();     // Catch: Throwable -> L95
        r23 = r25.b();     // Catch: Throwable -> L95
        if (TextUtils.isEmpty(r26) == false) goto L68;
    L71:
        r22 = "";
        r23 = "";
    L77:
        String r112 = r22;
        int r27 = r11;
    L78:
        String r113 = r23;
        if (r27 != 0) goto L103;
    L84:
        String r28 = r113;
    L85:
        this.f2799c = r112;     // Catch: Throwable -> L95
        this.f2802f = r28;     // Catch: Throwable -> L95
        String r29 = r18.G();     // Catch: Throwable -> L95
        this.f2801e = r29;     // Catch: Throwable -> L95
        this.f2800d = r111;     // Catch: Throwable -> L95
        f2791i.storeString("session_url", r29);     // Catch: Throwable -> L95
        f2791i.storeString("session_id", r110);     // Catch: Throwable -> L95
        f2791i.storeString("client_key", this.f2799c);     // Catch: Throwable -> L95
        f2791i.storeString("kms_version", this.f2802f);     // Catch: Throwable -> L95
        f2791i.storeLong("session_time", System.currentTimeMillis());     // Catch: Throwable -> L95
        f2794l = j(this.f2799c, this.f2802f);     // Catch: Throwable -> L95
        if (r18.z() == null) goto L89;
        r18.z().f2432d0 = SystemClock.uptimeMillis() - r12.longValue();     // Catch: Throwable -> L95
    L89:
        if (Logger.debug() == false) goto L91;
        Logger.d(f2795m, "save session url: " + this.f2801e + " session cookie: " + r110 + " client key: " + this.f2799c + " kms version: " + this.f2802f);     // Catch: Throwable -> L95
    L91:
        monitor-exit(this);
        return;
    L103:
        r28 = r113;
        m(r27, this.f2800d, r111, this.f2799c, r112, this.f2802f, r113, r19, r10.getPath());     // Catch: Throwable -> L99
        goto L85
    L68:
        if (TextUtils.isEmpty(r23) == true) goto L71;
        r112 = r26;
        r27 = 0;
    L73:
        if (r111.equals(this.f2800d) == false) goto L76;
        r22 = this.f2799c;     // Catch: Throwable -> L95
        r23 = this.f2802f;     // Catch: Throwable -> L95
        r11 = 2;
        goto L77
    L76:
        r11 = 3;
        goto L77
    L53:
        if (r21.length <= 0) goto L55;
        r17 = r21[0].trim();     // Catch: Throwable -> L95
        goto L55
    L42:
        if (r20.isEmpty() == true) goto L49;
        Iterator<b> r30 = r20.iterator();     // Catch: Throwable -> L95
    L45:
        if (r30.hasNext() == false) goto L49;
        String r31 = r30.next().b().trim();     // Catch: Throwable -> L95
        if (r31.toLowerCase().startsWith("sessionid=") == false) goto L45;
        r110 = r31;
    L35:
        r16 = false;
        goto L36
    }
}
