package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d0 {
    public static final String[] a = null;
    public static final String[] b = null;
    public static final String[] c = null;
    public static eta.b d;
    public static volatile boolean e;
    public static volatile boolean f;
    public static volatile int g;
    public static final Object h = null;
    public static volatile String i;
    public static final ConcurrentHashMap<String, String> j = null;
    public static final ConcurrentHashMap<String, String> k = null;
    public static volatile c0.b l;

    static {
        a = new String[]{"aid", "app_version", "tt_data", "device_id"};
        b = new String[]{"tt_data", "device_platform", "aid", "device_id", "iid"};
        c = new String[]{"aid", "version_code", "ab_version", "device_id", "iid", "device_platform"};
        d = null;
        h = new Object();
        i = "app_log_encrypt_switch_count";
        j = new ConcurrentHashMap();
        k = new ConcurrentHashMap();
    }

    public static void a(Context r4) {
        if (e == true) goto L14;
        if (r4 == null) goto L20;
        Object r0 = h;
        monitor-enter(r0);
        SharedPreferences r5 = r4.getSharedPreferences(i, 0);     // Catch: Throwable -> L15
        g = r5.getInt("app_log_encrypt_faild_count", 0);     // Catch: Throwable -> L15
        SharedPreferences.Editor r6 = r5.edit();     // Catch: Throwable -> L15
        r6.putInt("app_log_encrypt_faild_count", g + 1);     // Catch: Throwable -> L15
        r6.apply();     // Catch: Throwable -> L15
        e = true;     // Catch: Throwable -> L15
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L20:
        return;
    }

    public static String d(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return r4;
    L5:
        Uri.Builder r0 = UriProtector.parse(e(r4, a)).buildUpon();
        r0.appendQueryParameter("tt_info", new String(Base64.encode(b(null, UriProtector.parse(r4).getQuery().getBytes("UTF-8")), 8)));     // Catch: Throwable -> L8
        return r0.build().toString();
    L11:
        return r4;
    }

    public static void f(Context r4) {
        if (f == true) goto L18;
        if (r4 == null) goto L24;
        Object r0 = h;
        monitor-enter(r0);
        SharedPreferences.Editor r5 = r4.getSharedPreferences(i, 0).edit();     // Catch: Throwable -> L19
        if (g <= 2) goto L11;
        g -= 2;     // Catch: Throwable -> L19
    L12:
        r5.putInt("app_log_encrypt_faild_count", g);     // Catch: Throwable -> L19
        r5.apply();     // Catch: Throwable -> L19
        f = true;     // Catch: Throwable -> L19
        goto L20
    L11:
        g = 0;     // Catch: Throwable -> L19
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L24:
        return;
    }

    public static byte[] b(Context r4, byte[] r5) throws Exception {
        byte[] r0 = null;
        if (r5 != null) goto L5;
    L27:
        return null;
    L5:
        if (r5.length <= 0) goto L27;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r2 = new GZIPOutputStream(r1);
        r2.write(r5);     // Catch: Throwable -> L20
        r2.close();
        byte[] r6 = r1.toByteArray();
        if (r4 == null) goto L16;
        a(r4);
        if (g >= 3) goto L19;
        r0 = EncryptorUtil.b(r6, r6.length);
        f(r4);
        if (r0 != null) goto L19;
        e.a().b(StatsCountKeys.ENCRYPT_ERROR_COUNT, 1);
    L19:
        return r0;
    L16:
        r0 = EncryptorUtil.b(r6, r6.length);
        if (r0 != null) goto L19;
        e.a().b(StatsCountKeys.ENCRYPT_ERROR_COUNT, 1);
    L20:
        th = move-exception;
        e.a().b(StatsCountKeys.COMPRESS_ERROR_COUNT, 1);     // Catch: Throwable -> L24
        ita.j.c("AppLog compress with gzip exception: ", th);     // Catch: Throwable -> L24
        r2.close();
        return null;
    L24:
        th = move-exception;
        r2.close();
        throw th;
    }

    public static void c(Map<String, String> r3, Map<String, String> r4) {
        if (r3.isEmpty() == true) goto L17;
        Iterator<Map.Entry<String, String>> r5 = r3.entrySet().iterator();     // Catch: Exception -> L18
    L6:
        if (r5.hasNext() == false) goto L33;
        Map.Entry<String, String> r0 = r5.next();     // Catch: Exception -> L18
        if (r0 == null) goto L6;
        String r1 = r0.getKey();     // Catch: Exception -> L18
        String r2 = r0.getValue();     // Catch: Exception -> L18
        if (StringUtils.isEmpty(r1) == true) goto L6;
        if (StringUtils.isEmpty(r2) == true) goto L6;
        r4.put(r1, r2);     // Catch: Exception -> L18
    L33:
        return;
    L17:
        return;
    }

    public static String e(String r6, String[] r7) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return r6;
    L5:
        Uri r8 = UriProtector.parse(r6);
        HashMap r0 = new HashMap(r7.length);
        int r1 = r7.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        String r3 = r7[r2];
        String r4 = UriProtector.getQueryParameter(r8, r3);
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r0.put(r3, r4);
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        Uri.Builder r9 = r8.buildUpon();
        r9.clearQuery();
        Iterator r10 = r0.keySet().iterator();
    L13:
        if (r10.hasNext() == false) goto L16;
        String r5 = (String) r10.next();
        r9.appendQueryParameter(r5, (String) r0.get(r5));
        goto L13
    L16:
        return r9.build().toString();
    }
}
