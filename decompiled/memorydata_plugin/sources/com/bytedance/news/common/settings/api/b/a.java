package com.bytedance.news.common.settings.api.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.news.common.settings.api.g;
import com.bytedance.news.common.settings.internal.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile com.bytedance.news.common.settings.api.a f2918a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f2919b = null;
    private static volatile boolean j = false;
    private static volatile boolean k = false;
    private static volatile long l = -1;
    private static volatile long m = -1;
    private static ConcurrentHashMap n;
    private static ConcurrentHashMap o;
    private static c p;
    private JSONObject c;
    private SharedPreferences d;
    private SharedPreferences e;
    private SharedPreferences f;
    private SharedPreferences.Editor g;
    private SharedPreferences.Editor h;
    private volatile boolean i;

    static {
        n = new ConcurrentHashMap();
        o = new ConcurrentHashMap();
    }

    private a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.d = r4.getSharedPreferences("__ab_vid_info.sp", 0);
        this.f = r4.getSharedPreferences("__ab_exposed_info.sp", 0);
        SharedPreferences r5 = r4.getSharedPreferences("__ab_local_exposed_info.sp", 0);
        this.e = r5;
        this.h = r5.edit();
        this.g = this.f.edit();
        String r6 = this.d.getString("key_vid_info", "");
        if (TextUtils.isEmpty(r6) == true) goto L11;
        this.c = new JSONObject(r6);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static a a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f2919b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2919b != null) goto L9;
        f2919b = new a(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f2919b;
    }

    public static void a(long r0) {
        l = r0;
    }

    public static void a(com.bytedance.news.common.settings.api.a r2) {
        com.bytedance.news.common.settings.api.a r3 = (com.bytedance.news.common.settings.api.a) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.news.common.settings.api.a.class, "com.obric.memorydata.plugin");
        if (f2918a != null) goto L6;
        f2918a = r3;
        return;
    }

    public static void a(c r2) {
        p = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
    }

    public static void a(boolean r0) {
        j = r0;
    }

    public static void b(boolean r0) {
        k = r0;
    }

    public static boolean b() {
        return j;
    }

    public static long c() {
        if (l >= 0) goto L5;
        l = System.currentTimeMillis();
    L5:
        m = System.currentTimeMillis() - l;
        return m;
    }

    public static boolean c(String r2) {
        if (k == true) goto L5;
        return false;
    L5:
        if (n.containsKey(r2) == true) goto L10;
        n.put(r2, "");
        return true;
    L10:
        return false;
    }

    public String a() {
        if (this.c == null) goto L15;
        StringBuilder r1 = new StringBuilder();
        Iterator<?> r4 = this.f.getAll().values().iterator();     // Catch: Exception -> L13
    L6:
        if (r4.hasNext() == false) goto L17;
        Object r5 = r4.next();     // Catch: Exception -> L13
        if (r1.length() <= 0) goto L11;
        r1.append(",");     // Catch: Exception -> L13
    L11:
        r1.append(r5);     // Catch: Exception -> L13
    L17:
        if (this.e == null) goto L33;
        if (r1 != null) goto L37;
        r1 = new StringBuilder();
    L37:
        Iterator<Map.Entry<String, ?>> r7 = this.e.getAll().entrySet().iterator();     // Catch: Exception -> L31
    L21:
        if (r7.hasNext() == false) goto L33;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L31
        if (TextUtils.equals((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin"), "key_update_version_code") == true) goto L21;
        Object r8 = r6.getValue();     // Catch: Exception -> L31
        if (r1.length() <= 0) goto L29;
        r1.append(",");     // Catch: Exception -> L31
    L29:
        r1.append(r8);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L33:
        if (r1 != null) goto L35;
        return null;
    L35:
        return r1.toString();
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L15:
        r1 = null;
        goto L17
    }

    public void a(String r5) {
        long r0 = System.currentTimeMillis();
        o.put(r5, Long.valueOf(r0));
        if (f2918a == null) goto L12;
        if (f2918a.a().booleanValue() == false) goto L12;
        c r1 = p;
        if (r1 == null) goto L12;
        g r2 = r1.q();
        if (r2 == null) goto L12;
        r2.a("settings_auto_test", r5);
    L12:
        if (this.c == null) goto L33;
        monitor-enter(this);
        JSONObject r3 = this.c;     // Catch: Throwable -> L30
        if (r3 == null) goto L28;
        long r4 = r3.optLong(r5);     // Catch: Throwable -> L30
        if (r4 <= 0) goto L28;
        if (this.f.contains(r5) == true) goto L36;
        this.g.putString(r5, String.valueOf(r4)).apply();     // Catch: Throwable -> L30
        goto L28
    L36:
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L30
        goto L28
    L23:
        if (r4 == Long.parseLong(this.f.getString(r5, "0"))) goto L28;
        this.g.putString(r5, String.valueOf(r4)).apply();     // Catch: Exception -> L26 Throwable -> L30
    L28:
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    }

    public synchronized void a(JSONObject r6) {
        monitor-enter(this);
        this.c = r6;     // Catch: Throwable -> L19
        this.d.edit().putString("key_vid_info", r6.toString()).apply();     // Catch: Throwable -> L19
        Iterator<String> r7 = this.f.getAll().keySet().iterator();     // Catch: Throwable -> L19
    L5:
        if (r7.hasNext() == false) goto L16;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (this.c.has(r0) == false) goto L8;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        goto L5
    L11:
        if (this.c.optLong(r0) == Long.parseLong(this.f.getString(r0, "0"))) goto L5;
        this.g.remove(r0);     // Catch: Exception -> L14 Throwable -> L19
    L8:
        this.g.remove(r0);     // Catch: Throwable -> L19
        goto L5
    L16:
        this.g.apply();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public void b(String r5) {
        if (this.i == false) goto L5;
        return;
    L5:
        this.i = true;
        SharedPreferences r0 = this.e;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.h == null) goto L21;
        String r1 = r0.getString("key_update_version_code", "");
        if (TextUtils.isEmpty(r1) == false) goto L16;
        boolean r2 = TextUtils.isEmpty(r5);
        SharedPreferences.Editor r4 = this.h;
        if (r2 == false) goto L14;
        SharedPreferences.Editor r6 = r4.putString("key_update_version_code", "");
    L18:
        r6.apply();
        return;
    L14:
        r6 = r4.putString("key_update_version_code", r5);
        goto L18
    L16:
        if (TextUtils.equals(r1, r5) == true) goto L22;
        r6 = this.h.clear();
        goto L18
    L22:
        return;
    }
}
