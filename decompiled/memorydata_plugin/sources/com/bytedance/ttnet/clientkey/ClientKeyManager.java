package com.bytedance.ttnet.clientkey;

import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.keva.Keva;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.ttnet.config.d;
import com.bytedance.ttnet.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ClientKeyManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ClientKeyManager f3218a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Keva f3219b = null;
    private static volatile boolean e = false;
    private static boolean j = true;
    private static Map<String, String> k = null;
    private static final String l = "ClientKeyManager";
    private List<String> c;
    private List<String> d;
    private String f;
    private String g;
    private String h;
    private String i;
    private boolean m;

    static {
    }

    private ClientKeyManager() {
        this.c = new CopyOnWriteArrayList();
        this.d = new CopyOnWriteArrayList();
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.m = true;
    }

    public static ClientKeyManager a() {
        if (f3218a != null) goto L15;
        monitor-enter(ClientKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3218a != null) goto L9;
        f3218a = new ClientKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ClientKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return f3218a;
    }

    private static String a(Response r1, String r2) {
        Header r3 = r1.getFirstHeader(r2);
        if (r3 != null) goto L5;
        return "";
    L5:
        return ("" + r3.toString()) + "; ";
    }

    private static String a(String[] r10, long r11, String r13) {
        if (r10 != null) goto L5;
    L33:
        return null;
    L5:
        if (r10.length < 2) goto L33;
        long r3 = 0;
        if (r11 <= 0) goto L33;
        int r1 = r10.length;
        int r5 = 0;
    L11:
        if (r5 >= r1) goto L18;
        String r7 = r10[r5];
        if (TextUtils.isEmpty(r7) == true) goto L17;
        if (r7.toLowerCase().trim().startsWith("Max-Age=".toLowerCase()) == false) goto L17;
        String[] r12 = r7.split("=");
    L19:
        if (r12 == null) goto L33;
        if (r12.length != 2) goto L33;
        long r2 = Long.parseLong(r12[1]);     // Catch: Throwable -> L34
        if (r2 > 0) goto L27;
        return null;
    L27:
        long r4 = r2 - ((System.currentTimeMillis() - r11) / 1000);     // Catch: Throwable -> L34
        if (r4 <= 0) goto L31;
        r3 = r4;
    L31:
        return r13.replaceFirst(r7.trim(), "Max-Age=" + r3);
    L17:
        r5 = r5 + 1;
        goto L11
    L18:
        r12 = null;
        r7 = null;
        goto L19
    }

    private void a(int r2, String r3, String r4, String r5, String r6, String r7, String r8, Response r9, String r10) {
        JSONObject r1 = new JSONObject();
        r1.put("origin_sid", r3);
        r1.put("sid", r4);
        r1.put("origin_key", r5);
        r1.put("key", r6);
        r1.put("origin_kms", r7);
        r1.put("kms", r8);
        if (r9 == null) goto L7;
        String r11 = ((a(r9, "x-tt-token") + a(r9, "x-tt-logid")) + a(r9, "x-bd-lanusk")) + a(r9, "x-bd-lanusv");
        if (TextUtils.isEmpty(r11) == true) goto L7;
        r1.put("headers", r11);
    L7:
        h.a("client_key", r1, r2, r10);
    }

    private void a(String r7) {
        CookieHandler r1 = CookieHandler.getDefault();
        if (r1 != null) goto L27;
        return;
    L27:
        URI r2 = i.a(this.h);     // Catch: Throwable -> L26
        if (r2 != null) goto L8;
        return;
    L8:
        Map<String, List<String>> r3 = r1.get(r2, null);     // Catch: Throwable -> L26
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.isEmpty() == false) goto L13;
        return;
    L13:
        if (r3.containsKey("Cookie") == false) goto L30;
        String r0 = ((List) ZeusTransformUtils.preCheckCast(r3.get("Cookie"), List.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L26
        if (Logger.debug() == false) goto L18;
        Logger.d(l, "cookieStr: " + r0 + " sessionId: " + this.g);     // Catch: Throwable -> L26
    L18:
        if (TextUtils.isEmpty(r0) == false) goto L20;
        a(r7, r1, r2);     // Catch: Throwable -> L26
        r0 = "empty";
    L22:
        a(r0, r7);     // Catch: Throwable -> L26
        return;
    L20:
        if (r0.contains(this.g) == true) goto L31;
        a(r7, r1, r2);     // Catch: Throwable -> L26
        goto L22
    L31:
        return;
    L30:
        return;
    }

    private void a(String r6, String r7) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("report_time", System.currentTimeMillis() + "");     // Catch: Throwable -> L4
        r0.put("cookie_line", r6);     // Catch: Throwable -> L4
        r0.put("session_id", r7);     // Catch: Throwable -> L4
        r0.put("url", this.h);     // Catch: Throwable -> L4
        h.a("cookie_mismatch", r0);     // Catch: Throwable -> L4
        return;
    }

    private void a(String r3, CookieHandler r4, URI r5) {
        if (this.m == true) goto L5;
        return;
    L5:
        LinkedHashMap r2 = new LinkedHashMap();
        ArrayList r0 = new ArrayList();
        r0.add(r3);
        r2.put(Api.KEY_SET_COOKIE, r0);
        r4.put(r5, r2);
        if (Logger.debug() == false) goto L9;
        Logger.d(l, "Refresh session cookie: " + r3);
        return;
    }

    private void a(JSONObject r7) {
        int r1 = 0;
        boolean r2 = true;
        if (r7.optInt("client_key_sign_enabled", 0) <= 0) goto L5;
        boolean r0 = true;
    L6:
        e = r0;
        if (e == true) goto L14;
        if (Logger.debug() == false) goto L11;
        Logger.d(l, "clear client key storage.");
    L11:
        f3219b.clear();
        return;
    L14:
        if (r7.optInt("rewrite_session_enabled", 1) > 0) goto L17;
        r2 = false;
    L17:
        this.m = r2;
        this.c.clear();
        String r3 = r7.optString("update_host_list", null);
        if (TextUtils.isEmpty(r3) == true) goto L26;
        JSONArray r4 = new JSONArray(r3);
        int r5 = 0;
    L21:
        if (r5 >= r4.length()) goto L26;
        String r6 = r4.getString(r5);
        if (TextUtils.isEmpty(r6) == true) goto L25;
        this.c.add(r6);
    L25:
        r5 = r5 + 1;
    L26:
        this.d.clear();
        String r8 = r7.optString("update_path_list", null);
        if (TextUtils.isEmpty(r8) == true) goto L35;
        JSONArray r9 = new JSONArray(r8);
    L30:
        if (r1 >= r9.length()) goto L42;
        String r10 = r9.getString(r1);
        if (TextUtils.isEmpty(r10) == true) goto L34;
        this.d.add(r10);
    L34:
        r1 = r1 + 1;
        goto L30
    L42:
        return;
    L35:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private static Map<String, String> b(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L11;
        HashMap r0 = new HashMap();
        r0.put("x-bd-client-key", r2);
        r0.put("x-bd-kmsv", r3);
        return r0;
    L11:
        return null;
    }

    private void b(Request r16, Response r17) {
        URI r0 = i.a(r16.getUrl());     // Catch: Throwable -> L5
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (this.c.isEmpty() == true) goto L20;
        Iterator<String> r1 = this.c.iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        if (k.a(r0.getHost(), (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L12;
        boolean r2 = true;
    L17:
        if (r2 == true) goto L20;
        return;
    L16:
        r2 = false;
    L20:
        if (this.d.isEmpty() == true) goto L27;
        Iterator<String> r3 = this.d.iterator();
    L23:
        if (r3.hasNext() == false) goto L27;
        if (k.a(r0.getPath(), (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L23;
        boolean r4 = true;
    L28:
        if (r4 == true) goto L30;
        return;
    L30:
        List<Header> r5 = r17.headers(Api.KEY_SET_COOKIE);
        if (r5 != null) goto L33;
    L40:
        String r11 = "";
    L41:
        String[] r6 = r11.split(";");
        if (r6 != null) goto L44;
    L46:
        String r12 = "";
    L48:
        if (TextUtils.isEmpty(r12) == false) goto L51;
        return;
    L51:
        if (Logger.debug() == false) goto L53;
        Logger.d(l, "original sessionid: " + this.g + " new sessionid: " + r12);
    L53:
        Header r7 = r17.getFirstHeader("x-bd-lanusk");
        Header r8 = r17.getFirstHeader("x-bd-lanusv");
        if (r7 == null) goto L64;
        if (r8 == null) goto L64;
        String r9 = r7.getValue();
        String r10 = r8.getValue();
        if (TextUtils.isEmpty(r9) == false) goto L59;
    L62:
        int r13 = 1;
    L67:
        String r14 = "";
        String r15 = r14;
    L68:
        if (r13 != 0) goto L75;
    L70:
        this.f = r14;
        this.i = r15;
        String r18 = r16.getUrl();
        this.h = r18;
        this.g = r12;
        f3219b.storeString("session_url", r18);
        f3219b.storeString("session_id", r11);
        f3219b.storeString("client_key", this.f);
        f3219b.storeString("kms_version", this.i);
        f3219b.storeLong("session_time", System.currentTimeMillis());
        k = b(this.f, this.i);
        if (Logger.debug() == false) goto L88;
        Logger.d(l, "save session url: " + this.h + " session cookie: " + r11 + " client key: " + this.f + " kms version: " + this.i);
        return;
    L88:
        return;
    L75:
        a(r13, this.g, r12, this.f, r14, this.i, r15, r17, r0.getPath());     // Catch: Throwable -> L74
        goto L70
    L59:
        if (TextUtils.isEmpty(r10) == true) goto L62;
        r14 = r9;
        r15 = r10;
        r13 = 0;
    L64:
        if (r12.equals(this.g) == false) goto L66;
        String r19 = this.f;
        r15 = this.i;
        r13 = 2;
        r14 = r19;
        goto L68
    L66:
        r13 = 3;
        goto L67
    L44:
        if (r6.length <= 0) goto L46;
        r12 = r6[0].trim();
        goto L48
    L33:
        if (r5.isEmpty() == true) goto L40;
        Iterator<Header> r20 = r5.iterator();
    L36:
        if (r20.hasNext() == false) goto L40;
        String r21 = ((Header) ZeusTransformUtils.preCheckCast(r20.next(), Header.class, "com.obric.memorydata.plugin")).getValue().trim();
        if (r21.toLowerCase().startsWith("sessionid=") == false) goto L36;
        r11 = r21;
    L27:
        r4 = false;
    L5:
        r0 = null;
        goto L6
    }

    public static Map<String, String> getClientKeyHeaders() {
        if (f3219b != null) goto L5;
        return null;
    L5:
        if (e == true) goto L8;
        return null;
    L8:
        if (j == false) goto L12;
        return k;
    L12:
        return b(f3219b.getString("client_key", ""), f3219b.getString("kms_version", ""));
    }

    public synchronized void a(Request r2, Response r3) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (f3219b != null) goto L6;
    L22:
        monitor-exit(this);
        return;
    L6:
        if (e == false) goto L22;
        if (r2.getMetrics() == null) goto L27;
        r2.getMetrics().updateClientKeyStart();     // Catch: Throwable -> L24
    L27:
        b(r2, r3);     // Catch: Throwable -> L17
    L13:
        if (r2.getMetrics() == null) goto L15;
        r2.getMetrics().updateClientKeyEnd();     // Catch: Throwable -> L24
    L15:
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        if (r2.getMetrics() == null) goto L21;
        r2.getMetrics().updateClientKeyEnd();     // Catch: Throwable -> L24
    L21:
        throw th;     // Catch: Throwable -> L24
    }

    public void a(Object r6) {
        if (f3219b != null) goto L5;
        return;
    L5:
        if (d.a(r6) == false) goto L26;
        JSONObject r7 = d.b(r6);     // Catch: Throwable -> L23
        if (r7 == null) goto L11;
        JSONObject r8 = r7.getJSONObject("data").optJSONObject("client_key_config");     // Catch: Throwable -> L23
    L12:
        if (r8 == null) goto L14;
        String r1 = r8.toString();     // Catch: Throwable -> L23
        if (Logger.debug() == false) goto L21;
        Logger.d(l, "config: " + r1);     // Catch: Throwable -> L23
    L21:
        f3219b.storeString("client_key_config", r1);     // Catch: Throwable -> L23
        a(r8);     // Catch: Throwable -> L23
        return;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(l, "clear client key storage.");     // Catch: Throwable -> L23
    L16:
        e = false;     // Catch: Throwable -> L23
        f3219b.clear();     // Catch: Throwable -> L23
        return;
    L11:
        r8 = null;
        goto L12
    L27:
        return;
    }

    public void a(List<Header> r4, RetrofitMetrics r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (f3219b != null) goto L5;
        return;
    L5:
        if (e == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.f) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.i) == true) goto L21;
        if (r5 == null) goto L13;
        r5.addClientKeyStart();
    L13:
        r6.add(new Header("x-bd-client-key", this.f));
        r6.add(new Header("x-bd-kmsv", this.i));
        if (r5 == null) goto L20;
        r5.addClientKeyEnd();
        return;
    L20:
        return;
    }

    public void a(boolean r7) {
        j = r7;
        f3219b = Keva.getRepo("ttnet_client_key_config", 1);     // Catch: Throwable -> L5
    L7:
        Keva r8 = f3219b;
        if (r8 != null) goto L10;
        return;
    L10:
        String r9 = r8.getString("client_key_config", "");
        if (TextUtils.isEmpty(r9) == true) goto L14;
        a(new JSONObject(r9));     // Catch: Throwable -> L37
    L14:
        if (e == true) goto L16;
        return;
    L16:
        String r0 = f3219b.getString("session_id", "");
        long r2 = f3219b.getLong("session_time", 0);
        this.h = f3219b.getString("session_url", "");
        this.f = f3219b.getString("client_key", "");
        String r1 = f3219b.getString("kms_version", "");
        this.i = r1;
        k = b(this.f, r1);
        if (r0.isEmpty() == false) goto L19;
        return;
    L19:
        if (this.h.isEmpty() == true) goto L43;
        String[] r3 = r0.split(";");
        if (r3 == null) goto L27;
        if (r3.length <= 0) goto L27;
        this.g = r3[0].trim();
    L27:
        if (TextUtils.isEmpty(this.g) == false) goto L29;
        return;
    L29:
        String r4 = a(r3, r2, r0);
        if (TextUtils.isEmpty(r4) == true) goto L33;
        r0 = r4;
    L33:
        if (Logger.debug() == false) goto L35;
        Logger.d(l, "client key: " + this.f + " | kms version: " + this.i + " | session cookie: " + r0 + " | sessionid: " + this.g + " | session time: " + r2 + " session url: " + this.h + " config: " + r9);
    L35:
        a(r0);
        return;
    L43:
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }
}
