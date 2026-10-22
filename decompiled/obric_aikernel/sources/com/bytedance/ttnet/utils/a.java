package com.bytedance.ttnet.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.exception.CdnCacheVerifyException;
import com.bytedance.frameworks.baselib.network.http.util.i;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f2935a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<b> f2936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ReentrantReadWriteLock f2937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Lock f2938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Lock f2939e;

    /* JADX INFO: renamed from: com.bytedance.ttnet.utils.a$a, reason: collision with other inner class name */
    public static class C0075a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2941b;

        public C0075a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Pattern f2942a;

        public b() {
        }

        public boolean a(URI r10) {
            if (r10 != null) goto L5;
        L14:
            return false;
        L5:
            if (TextUtils.isEmpty(r10.getHost()) == true) goto L14;
            if (this.f2942a == null) goto L14;
            String r11 = r10.getHost();
            if (TextUtils.isEmpty(r10.getPath()) == true) goto L16;
            r11 = r11 + r10.getPath();
        L16:
            return this.f2942a.matcher(r11).matches();
        }

        public boolean b(String r10) {
            this.f2942a = Pattern.compile(r10);     // Catch: PatternSyntaxException -> L5
            return true;
        L5:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    static {
        f2936b = new ArrayList();
        ReentrantReadWriteLock r10 = new ReentrantReadWriteLock();
        f2937c = r10;
        f2938d = r10.readLock();
        f2939e = f2937c.writeLock();
    }

    private static boolean a(URI r10) {
        f2938d.lock();     // Catch: Throwable -> L12
        Iterator<b> r11 = f2936b.iterator();     // Catch: Throwable -> L12
    L4:
        if (r11.hasNext() == false) goto L10;
        goto L4
    L7:
        if (r11.next().a(r10) == false) goto L4;
        f2938d.unlock();
        return true;
    L10:
        f2938d.unlock();
        return false;
    L12:
        th = move-exception;
        f2938d.unlock();
        throw th;
    }

    private static String b() {
        return UUID.randomUUID().toString();
    }

    private static String c(URI r10) {
        if (a(r10) == true) goto L5;
        return null;
    L5:
        return b();
    }

    public static void d(SharedPreferences r10) {
        int r11 = r10.getInt("ttnet_response_verify_enabled", -1);
        String r12 = r10.getString("ttnet_response_verify", "");
        if (TextUtils.isEmpty(r12) == false) goto L11;
    L8:
        JSONArray r13 = null;
    L9:
        j(r11, r13);
        return;
    L11:
        r13 = new JSONArray(r12);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    public static C0075a e(JSONObject r10) {
        int r11 = r10.optInt("ttnet_response_verify_enabled", -1);
        JSONArray r12 = r10.optJSONArray("ttnet_response_verify");
        if (r12 == null) goto L5;
        String r13 = r12.toString();
    L6:
        j(r11, r12);
        C0075a r14 = new C0075a();
        r14.f2940a = r11;
        r14.f2941b = r13;
        return r14;
    L5:
        r13 = "";
        goto L6
    }

    public static void f(n4.c r10, n4.d r11, a5.b r12) {
        if (f2935a == true) goto L5;
        return;
    L5:
        if (r12 != null) goto L8;
        Logger.w("CDN_CACHE_VERIFY", "Req info is null");
        return;
    L8:
        g(r10, r11, r12);
    }

    private static void g(n4.c r10, n4.d r11, a5.b r12) {
        n4.b r13 = r10.u("X-TT-VERIFY-ID");
        String r14 = null;
        if (r13 == null) goto L5;
        String r15 = r13.b();
    L6:
        n4.b r16 = r11.c("X-TT-VERIFY-ID");
        if (r16 == null) goto L9;
        r14 = r16.b();
    L9:
        if (r15 != null) goto L11;
        return;
    L11:
        if (r14 != null) goto L15;
        r12.T = 1;
        String r17 = "Cdn cache verify accessible";
    L13:
        Logger.w("CDN_CACHE_VERIFY", r17);
    L22:
        c.a r18 = c.b();
        if (r18 == null) goto L26;
        r18.a(r10.G(), r12);
    L26:
        if (r12.T == 3) goto L29;
        return;
    L29:
        throw new CdnCacheVerifyException("Fail to verify cdn cache");
    L15:
        if (r15.equals(r14) == false) goto L17;
        r12.T = 2;
        r17 = "Cdn cache verify success";
        goto L13
    L17:
        r12.T = 3;
        Logger.w("CDN_CACHE_VERIFY", "Cdn cache verify fail");
        r11.a().c().close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.printStackTrace();
        r17 = "Cdn cache verify stream close fail:" + th.toString();
        goto L13
    L5:
        r15 = null;
        goto L6
    }

    public static void h(String r10, List<n4.b> r11) {
        if (f2935a == true) goto L5;
        return;
    L5:
        i(r10, r11);
    }

    private static void i(String r10, List<n4.b> r11) {
        String r12 = c(i.b(r10));     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r12) == true) goto L11;
        r11.add(new n4.b("X-TT-VERIFY-ID", r12));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    private static void j(int r10, JSONArray r11) {
        int r12 = 0;
        if (r10 <= 0) goto L16;
        ArrayList r13 = new ArrayList();
        if (r11 == null) goto L15;
        int r14 = r11.length();
    L7:
        if (r12 >= r14) goto L14;
        String r15 = r11.optString(r12);
        if (TextUtils.isEmpty(r15) == true) goto L13;
        b r16 = new b();
        if (r16.b(r15) == false) goto L13;
        r13.add(r16);
    L13:
        r12 = r12 + 1;
        goto L7
    L14:
        l(r13);
    L15:
        k(true);
        return;
    L16:
        k(false);
    }

    public static void k(boolean r10) {
        f2935a = r10;
    }

    public static void l(List<b> r10) {
        f2939e.lock();     // Catch: Throwable -> L5
        f2936b = r10;     // Catch: Throwable -> L5
        f2939e.unlock();
        return;
    L5:
        th = move-exception;
        f2939e.unlock();
        throw th;
    }
}
