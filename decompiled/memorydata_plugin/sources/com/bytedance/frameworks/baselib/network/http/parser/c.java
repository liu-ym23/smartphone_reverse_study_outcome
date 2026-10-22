package com.bytedance.frameworks.baselib.network.http.parser;

import android.text.TextUtils;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.frameworks.baselib.network.http.util.k;
import java.net.URL;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONObject f2528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ReentrantReadWriteLock f2529b;
    private static Lock c;
    private static Lock d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2531b;
        public int c;

        public a() {
        }
    }

    static {
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        f2529b = r0;
        c = r0.readLock();
        d = f2529b.writeLock();
    }

    public static int a(URL r17, a r18) {
        if (r17 != null) goto L64;
        return -1;
    L64:
        c.lock();     // Catch: Throwable -> L63
        JSONObject r8 = f2528a;     // Catch: Throwable -> L63
        if (r8 != null) goto L10;
    L7:
        c.unlock();
        return -1;
    L10:
        if (r8.optInt("enabled", 0) <= 0) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L7;
        JSONArray r10 = f2528a.optJSONArray("rule_list");     // Catch: Throwable -> L63
        if (r10 == null) goto L7;
        if (r10.length() == 0) goto L7;
        int r11 = 0;
    L22:
        if (r11 >= r10.length()) goto L61;
        JSONObject r12 = r10.optJSONObject(r11);     // Catch: Throwable -> L63
        if (r12 == null) goto L60;
        JSONArray r14 = null;
        if (r12.has("host_eq") == false) goto L30;
        JSONArray r13 = r12.optJSONArray("host_eq");     // Catch: Throwable -> L63
        int r15 = 1;
    L33:
        if (r13 == null) goto L60;
        if (a(r17.getHost(), r13, r15) == false) goto L60;
        if (r12.has("path_eq") == false) goto L41;
        int r16 = 3;
        r14 = r12.optJSONArray("path_eq");     // Catch: Throwable -> L63
    L50:
        if (r14 == null) goto L60;
        if (a(r17.getPath(), r14, r16) == false) goto L60;
        JSONObject r19 = r12.optJSONObject(EventBody.KEY_VALUE);     // Catch: Throwable -> L63
        if (r19 == null) goto L60;
        r18.f2530a = r19.optInt("conn_to", -1);     // Catch: Throwable -> L63
        r18.f2531b = r19.optInt("read_to", -1);     // Catch: Throwable -> L63
        r18.c = r19.optInt("write_to", -1);     // Catch: Throwable -> L63
        int r0 = r19.optInt("pro_to", -1);     // Catch: Throwable -> L63
        c.unlock();
        return r0;
    L41:
        if (r12.has("path_prefix") == false) goto L44;
        r16 = 4;
        r14 = r12.optJSONArray("path_prefix");     // Catch: Throwable -> L63
        goto L50
    L44:
        if (r12.has("path_contain") == false) goto L47;
        r16 = 5;
        r14 = r12.optJSONArray("path_contain");     // Catch: Throwable -> L63
        goto L50
    L47:
        if (r12.has("path_pattern") == false) goto L49;
        r16 = 6;
        r14 = r12.optJSONArray("path_pattern");     // Catch: Throwable -> L63
        goto L50
    L49:
        r16 = 0;
        goto L50
    L30:
        if (r12.has("host_wc") == false) goto L32;
        r15 = 2;
        r13 = r12.optJSONArray("host_wc");     // Catch: Throwable -> L63
        goto L33
    L32:
        r15 = 0;
        r13 = null;
    L60:
        r11 = r11 + 1;
        goto L22
    L12:
        r9 = false;
    L61:
        c.unlock();
        return -1;
    }

    public static void a(JSONObject r1) {
        if (r1 != null) goto L10;
        return;
    L10:
        d.lock();     // Catch: Throwable -> L7
        f2528a = r1.optJSONObject("to_config_v1");     // Catch: Throwable -> L7
        d.unlock();
        return;
    L7:
        th = move-exception;
        d.unlock();
        throw th;
    }

    private static boolean a(String r4, JSONArray r5, int r6) {
        if (r4 != null) goto L5;
    L61:
        return false;
    L5:
        if (r4.isEmpty() == true) goto L61;
        if (r5 == null) goto L61;
        if (r5.length() == 0) goto L61;
        switch(r6) {
            case 1: goto L49;
            case 2: goto L40;
            case 3: goto L49;
            case 4: goto L31;
            case 5: goto L22;
            case 6: goto L13;
            default: goto L12;
        };
    L12:
        return false;
    L13:
        int r7 = 0;
    L15:
        if (r7 >= r5.length()) goto L58;
        String r2 = r5.optString(r7);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r2) == true) goto L21;
        if (r4.matches(r2) == false) goto L21;
        return true;
    L21:
        r7 = r7 + 1;     // Catch: Throwable -> L59
    L58:
        return false;
    L22:
        int r8 = 0;
    L24:
        if (r8 >= r5.length()) goto L58;
        String r3 = r5.optString(r8);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r3) == true) goto L30;
        if (r4.contains(r3) == false) goto L30;
        return true;
    L30:
        r8 = r8 + 1;     // Catch: Throwable -> L59
        goto L24
    L31:
        int r9 = 0;
    L33:
        if (r9 >= r5.length()) goto L58;
        String r10 = r5.optString(r9);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r10) == true) goto L39;
        if (r4.startsWith(r10) == false) goto L39;
        return true;
    L39:
        r9 = r9 + 1;     // Catch: Throwable -> L59
        goto L33
    L40:
        int r11 = 0;
    L42:
        if (r11 >= r5.length()) goto L58;
        String r12 = r5.optString(r11);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r12) == true) goto L48;
        if (k.a(r4, r12) == false) goto L48;
        return true;
    L48:
        r11 = r11 + 1;     // Catch: Throwable -> L59
        goto L42
    L49:
        int r13 = 0;
    L51:
        if (r13 >= r5.length()) goto L58;
        String r14 = r5.optString(r13);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r14) == true) goto L57;
        if (r4.equals(r14) == false) goto L57;
        return true;
    L57:
        r13 = r13 + 1;
    L59:
        th = move-exception;
        th.printStackTrace();
        goto L61
    }
}
