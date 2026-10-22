package com.bytedance.ttnet.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.exception.CdnCacheVerifyException;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f3326a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<b> f3327b;
    private static ReentrantReadWriteLock c;
    private static Lock d;
    private static Lock e;

    /* JADX INFO: renamed from: com.bytedance.ttnet.utils.a$a, reason: collision with other inner class name */
    public static class C0168a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3329b;

        public C0168a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Pattern f3330a;

        public b() {
        }

        public boolean a(String r1) {
            this.f3330a = Pattern.compile(r1);     // Catch: PatternSyntaxException -> L5
            return true;
        L5:
            e = move-exception;
            e.printStackTrace();
            return false;
        }

        public boolean a(URI r4) {
            if (r4 != null) goto L5;
        L14:
            return false;
        L5:
            if (TextUtils.isEmpty(r4.getHost()) == true) goto L14;
            if (this.f3330a == null) goto L14;
            String r1 = r4.getHost();
            if (TextUtils.isEmpty(r4.getPath()) == true) goto L16;
            r1 = r1 + r4.getPath();
        L16:
            return this.f3330a.matcher(r1).matches();
        }
    }

    static {
        f3327b = new ArrayList();
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        c = r0;
        d = r0.readLock();
        e = c.writeLock();
    }

    public static C0168a a(JSONObject r2) {
        int r0 = r2.optInt("ttnet_response_verify_enabled", -1);
        JSONArray r3 = r2.optJSONArray("ttnet_response_verify");
        if (r3 == null) goto L5;
        String r1 = r3.toString();
    L6:
        a(r0, r3);
        C0168a r4 = new C0168a();
        r4.f3328a = r0;
        r4.f3329b = r1;
        return r4;
    L5:
        r1 = "";
        goto L6
    }

    private static String a() {
        return UUID.randomUUID().toString();
    }

    private static String a(URI r0) {
        if (b(r0) == true) goto L5;
        return null;
    L5:
        return a();
    }

    private static void a(int r4, JSONArray r5) {
        int r0 = 0;
        if (r4 <= 0) goto L16;
        ArrayList r6 = new ArrayList();
        if (r5 == null) goto L15;
        int r1 = r5.length();
    L7:
        if (r0 >= r1) goto L14;
        String r2 = r5.optString(r0);
        if (TextUtils.isEmpty(r2) == true) goto L13;
        b r3 = new b();
        if (r3.a(r2) == false) goto L13;
        r6.add(r3);
    L13:
        r0 = r0 + 1;
        goto L7
    L14:
        a(r6);
    L15:
        a(true);
        return;
    L16:
        a(false);
    }

    public static void a(SharedPreferences r3) {
        SharedPreferences r4 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.class, "com.obric.memorydata.plugin");
        int r0 = r4.getInt("ttnet_response_verify_enabled", -1);
        String r5 = r4.getString("ttnet_response_verify", "");
        if (TextUtils.isEmpty(r5) == false) goto L11;
    L8:
        JSONArray r1 = null;
    L9:
        a(r0, r1);
        return;
    L11:
        r1 = new JSONArray(r5);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    public static void a(Request r1, Response r2, com.bytedance.ttnet.b.b r3) {
        if (f3326a == true) goto L5;
        return;
    L5:
        if (r3 != null) goto L8;
        Logger.w("CDN_CACHE_VERIFY", "Req info is null");
        return;
    L8:
        b(r1, r2, r3);
    }

    private static void a(String r2, List<Header> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        String r5 = a(i.a(r2));     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r5) == true) goto L12;
        r4.add(new Header("X-TT-VERIFY-ID", r5));     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void a(String r2, List<Header> r3, RetrofitMetrics r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (f3326a == true) goto L5;
        return;
    L5:
        if (r4 == null) goto L15;
        r4.preCdnCacheVerifyStart();
    L15:
        a(r2, r5);     // Catch: Throwable -> L11
        if (r4 == null) goto L17;
        r4.preCdnCacheVerifyEnd();
        return;
    L17:
        return;
    L11:
        th = move-exception;
        if (r4 == null) goto L14;
        r4.preCdnCacheVerifyEnd();
    L14:
        throw th;
    }

    public static void a(List<b> r2) {
        List<b> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        e.lock();     // Catch: Throwable -> L6
        f3327b = r3;     // Catch: Throwable -> L6
        e.unlock();
        return;
    L6:
        th = move-exception;
        e.unlock();
        throw th;
    }

    public static void a(boolean r0) {
        f3326a = r0;
    }

    private static void b(Request r4, Response r5, com.bytedance.ttnet.b.b r6) {
        Header r1 = r4.getFirstHeader("X-TT-VERIFY-ID");
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getValue();
    L6:
        Header r0 = r5.getFirstHeader("X-TT-VERIFY-ID");
        if (r0 == null) goto L9;
        r2 = r0.getValue();
    L9:
        if (r3 != null) goto L11;
        return;
    L11:
        if (r2 != null) goto L15;
        r6.ae = 1;
        String r7 = "Cdn cache verify accessible";
    L13:
        Logger.w("CDN_CACHE_VERIFY", r7);
    L22:
        c.a r8 = c.b();
        if (r8 == null) goto L37;
        if (r4.getMetrics() == null) goto L44;
        r4.getMetrics().postCdnCacheVerifyStart();
    L44:
        r8.a(r4.getUrl(), r6);     // Catch: Throwable -> L31
        if (r4.getMetrics() == null) goto L37;
        r4.getMetrics().postCdnCacheVerifyEnd();
    L31:
        th = move-exception;
        if (r4.getMetrics() == null) goto L35;
        r4.getMetrics().postCdnCacheVerifyEnd();
    L35:
        throw th;
    L37:
        if (r6.ae == 3) goto L40;
        return;
    L40:
        throw new CdnCacheVerifyException("Fail to verify cdn cache");
    L15:
        if (r3.equals(r2) == false) goto L17;
        r6.ae = 2;
        r7 = "Cdn cache verify success";
        goto L13
    L17:
        r6.ae = 3;
        Logger.w("CDN_CACHE_VERIFY", "Cdn cache verify fail");
        r5.getBody().in().close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.printStackTrace();
        r7 = "Cdn cache verify stream close fail:" + th.toString();
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    private static boolean b(URI r4) {
        d.lock();     // Catch: Throwable -> L12
        Iterator<b> r0 = f3327b.iterator();     // Catch: Throwable -> L12
    L4:
        if (r0.hasNext() == false) goto L10;
        goto L4
    L7:
        if (((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin")).a(r4) == false) goto L4;
        d.unlock();
        return true;
    L10:
        d.unlock();
        return false;
    L12:
        th = move-exception;
        d.unlock();
        throw th;
    }
}
