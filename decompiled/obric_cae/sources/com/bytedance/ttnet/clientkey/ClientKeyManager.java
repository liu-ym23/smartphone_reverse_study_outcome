package com.bytedance.ttnet.clientkey;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.keva.Keva;
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

/* JADX INFO: loaded from: classes.dex */
public class ClientKeyManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile ClientKeyManager f4078g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Keva f4079h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f4080i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f4081j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static HashMap f4082k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f4083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f4084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4088f;

    public ClientKeyManager() {
        this.f4083a = new CopyOnWriteArrayList();
        this.f4084b = new CopyOnWriteArrayList();
        this.f4085c = "";
        this.f4086d = "";
        this.f4087e = "";
        this.f4088f = "";
    }

    public static HashMap c(String r8, String r10) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L11;
        HashMap r11 = new HashMap();
        r11.put("x-bd-client-key", r8);
        r11.put("x-bd-kmsv", r10);
        return r11;
    L11:
        return null;
    }

    public static ClientKeyManager d() {
        if (f4078g != null) goto L15;
        monitor-enter(ClientKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4078g != null) goto L9;
        f4078g = new ClientKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ClientKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return f4078g;
    }

    public static void e(String r8, CookieHandler r10, URI r11) {
        Map<String, List<String>> r12 = new LinkedHashMap();
        ArrayList r13 = new ArrayList();
        r13.add(r8);
        r12.put("Set-Cookie", r13);
        r10.put(r11, r12);
        Logger.d("ClientKeyManager", "Refresh session cookie: " + r8);
    }

    public static Map<String, String> getClientKeyHeaders() {
        if (f4079h != null) goto L5;
        return null;
    L5:
        if (f4080i == true) goto L8;
        return null;
    L8:
        if (f4081j == false) goto L12;
        return f4082k;
    L12:
        return c(f4079h.getString("client_key", ""), f4079h.getString("kms_version", ""));
    }

    public final void a(String r8) {
        if (f4079h != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L17;
        JSONObject r10 = new JSONObject(r8).getJSONObject("data").optJSONObject("client_key_config");     // Catch: Throwable -> L14
        if (r10 != null) goto L12;
        Logger.d("ClientKeyManager", "clear client key storage.");     // Catch: Throwable -> L14
        f4080i = false;     // Catch: Throwable -> L14
        f4079h.clear();     // Catch: Throwable -> L14
        return;
    L12:
        String r11 = r10.toString();     // Catch: Throwable -> L14
        Logger.d("ClientKeyManager", "config: " + r11);     // Catch: Throwable -> L14
        f4079h.storeString("client_key_config", r11);     // Catch: Throwable -> L14
        b(r10);     // Catch: Throwable -> L14
        return;
    L18:
        return;
    }

    public final void b(JSONObject r8) {
        int r10 = 0;
        if (r8.optInt("client_key_sign_enabled", 0) <= 0) goto L5;
        boolean r11 = true;
    L6:
        f4080i = r11;
        if (f4080i == true) goto L10;
        Logger.d("ClientKeyManager", "clear client key storage.");
        f4079h.clear();
        return;
    L10:
        this.f4083a.clear();
        String r12 = r8.optString("update_host_list", null);
        if (TextUtils.isEmpty(r12) == true) goto L19;
        JSONArray r13 = new JSONArray(r12);
        int r14 = 0;
    L14:
        if (r14 >= r13.length()) goto L19;
        String r15 = r13.getString(r14);
        if (TextUtils.isEmpty(r15) == true) goto L18;
        this.f4083a.add(r15);
    L18:
        r14 = r14 + 1;
    L19:
        this.f4084b.clear();
        String r16 = r8.optString("update_path_list", null);
        if (TextUtils.isEmpty(r16) == true) goto L28;
        JSONArray r17 = new JSONArray(r16);
    L23:
        if (r10 >= r17.length()) goto L35;
        String r18 = r17.getString(r10);
        if (TextUtils.isEmpty(r18) == true) goto L27;
        this.f4084b.add(r18);
    L27:
        r10 = r10 + 1;
        goto L23
    L35:
        return;
    L28:
        return;
    L5:
        r11 = false;
        goto L6
    }
}
