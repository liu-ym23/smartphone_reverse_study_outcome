package com.bytedance.ttnet.clientkey;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.keva.Keva;
import com.bytedance.ttnet.TTNetInit;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ClientKeyManager {
    public static volatile ClientKeyManager g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Keva f7527h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f7528i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f7529j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static HashMap f7530k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CopyOnWriteArrayList f7531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CopyOnWriteArrayList f7532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7533c;
    public String d;
    public String e;
    public String f;

    public static HashMap c(String r5, String r10) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L11;
        HashMap r11 = new HashMap();
        r11.put("x-bd-client-key", r5);
        r11.put("x-bd-kmsv", r10);
        return r11;
    L11:
        return null;
    }

    public static ClientKeyManager d() {
        if (g != null) goto L16;
        monitor-enter(ClientKeyManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L11;
        ClientKeyManager r5 = new ClientKeyManager();     // Catch: Throwable -> L9
        r5.f7531a = new CopyOnWriteArrayList();     // Catch: Throwable -> L9
        r5.f7532b = new CopyOnWriteArrayList();     // Catch: Throwable -> L9
        r5.f7533c = "";     // Catch: Throwable -> L9
        r5.d = "";     // Catch: Throwable -> L9
        r5.e = "";     // Catch: Throwable -> L9
        r5.f = "";     // Catch: Throwable -> L9
        g = r5;     // Catch: Throwable -> L9
    L11:
        monitor-exit(ClientKeyManager.class);     // Catch: Throwable -> L9
    L16:
        return g;
    }

    public static void e(String r5, CookieHandler r10, URI r11) {
        Map<String, List<String>> r12 = new LinkedHashMap();
        ArrayList r13 = new ArrayList();
        r13.add(r5);
        r12.put("Set-Cookie", r13);
        r10.put(r11, r12);
        Logger.d("ClientKeyManager", "Refresh session cookie: " + r5);
    }

    public static Map<String, String> getClientKeyHeaders() {
        if (f7527h != null) goto L5;
        return null;
    L5:
        if (f7528i == true) goto L8;
        return null;
    L8:
        if (f7529j == false) goto L12;
        return f7530k;
    L12:
        return c(f7527h.getString("client_key", ""), f7527h.getString("kms_version", ""));
    }

    public final void a(JSONObject r10) {
        int r5 = 0;
        if (r10.optInt("client_key_sign_enabled", 0) <= 0) goto L5;
        boolean r11 = true;
    L6:
        f7528i = r11;
        if (f7528i == true) goto L10;
        Logger.d("ClientKeyManager", "clear client key storage.");
        f7527h.clear();
        return;
    L10:
        this.f7531a.clear();
        String r12 = r10.optString("update_host_list", null);
        if (TextUtils.isEmpty(r12) == true) goto L19;
        JSONArray r13 = new JSONArray(r12);
        int r14 = 0;
    L14:
        if (r14 >= r13.length()) goto L19;
        String r15 = r13.getString(r14);
        if (TextUtils.isEmpty(r15) == true) goto L18;
        this.f7531a.add(r15);
    L18:
        r14 = r14 + 1;
    L19:
        this.f7532b.clear();
        String r16 = r10.optString("update_path_list", null);
        if (TextUtils.isEmpty(r16) == true) goto L28;
        JSONArray r17 = new JSONArray(r16);
    L23:
        if (r5 >= r17.length()) goto L35;
        String r18 = r17.getString(r5);
        if (TextUtils.isEmpty(r18) == true) goto L27;
        this.f7532b.add(r18);
    L27:
        r5 = r5 + 1;
        goto L23
    L35:
        return;
    L28:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final void b(String r10) {
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L4
        r5.put("report_time", System.currentTimeMillis() + "");     // Catch: Throwable -> L4
        r5.put("cookie_line", r10);     // Catch: Throwable -> L4
        r5.put("session_id", this.d);     // Catch: Throwable -> L4
        r5.put("url", this.e);     // Catch: Throwable -> L4
        TTNetInit.getTTNetDepend();     // Catch: Throwable -> L4
        throw null;     // Catch: Throwable -> L4
    }
}
