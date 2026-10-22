package com.bytedance.frameworks.baselib.network.http.cookie;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import com.bytedance.frameworks.baselib.network.http.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f2385a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f2386b = null;
    private static final AtomicBoolean c = null;
    private static final CountDownLatch d = null;
    private static final AtomicBoolean e = null;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.cookie.a$a, reason: collision with other inner class name */
    public interface InterfaceC0125a {
        void a();

        void a(String r1, String r2, JSONObject r3);

        void a(boolean r1);

        ArrayList<String> b();
    }

    static {
        f2386b = new Object();
        c = new AtomicBoolean(false);
        d = new CountDownLatch(1);
        e = new AtomicBoolean(false);
    }

    public a() {
    }

    public static void a() {
        e.set(true);
        if (Logger.debug() == false) goto L6;
        Logger.d("CookieInitializer", "setForceDisableWebViewCookieMgr");
        return;
    }

    @Deprecated
    private static void a(Context r4, InterfaceC0125a r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        final InterfaceC0125a r7 = (InterfaceC0125a) ZeusTransformUtils.wrapperContextForParams(r5, InterfaceC0125a.class, "com.obric.memorydata.plugin");
    L21:
        th = move-exception;
        a(th.getMessage(), r7);
        th.printStackTrace();
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(CookieHandler.getDefault(), SSCookieHandler.class) == false) goto L8;
        a(r7);     // Catch: Throwable -> L21
        return;
    L8:
        if (TTNetInitMetrics.c().j != 0) goto L10;
        TTNetInitMetrics r0 = TTNetInitMetrics.c();     // Catch: Throwable -> L21
        r0.j = System.nanoTime();     // Catch: Throwable -> L21
    L10:
        CookieManager r1 = null;
        boolean r2 = e.get();     // Catch: Throwable -> L21
        if (r2 == false) goto L25;
    L16:
        if (r2 == false) goto L18;
        SSCookieHandler.CookieInitType r3 = SSCookieHandler.CookieInitType.INIT_V2_DISABLE_COOKIE_MGR;     // Catch: Throwable -> L21
    L19:
        CookieHandler.setDefault(new SSCookieHandler(r6, r1, r3, new AnonymousClass1(r7)));     // Catch: Throwable -> L21
        a(r7);     // Catch: Throwable -> L21
        TTNetInitMetrics r8 = TTNetInitMetrics.c();     // Catch: Throwable -> L21
        r8.k = System.nanoTime();     // Catch: Throwable -> L21
        return;
    L18:
        r3 = SSCookieHandler.CookieInitType.INIT_V1;     // Catch: Throwable -> L21
        goto L19
    L25:
        r1 = CookieManager.getInstance();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        a(th.getMessage(), r7);     // Catch: Throwable -> L21
        goto L16
    }

    @Deprecated
    private static void a(Context r4, final boolean r5, InterfaceC0125a r6) {
        final Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        final InterfaceC0125a r8 = (InterfaceC0125a) ZeusTransformUtils.wrapperContextForParams(r6, InterfaceC0125a.class, "com.obric.memorydata.plugin");
    L13:
        th = move-exception;
        th.printStackTrace();
        if (g.b(r7) == true) goto L17;
    L19:
        r8.a(r5);
        return;
    L17:
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) goto L19;
        new Handler(Looper.getMainLooper()).post(new $$Lambda$a$eNY2LJJj0Uq_uLWCFHVl6ONCVcw(r7, r5, r8));
        a(th.getMessage(), r8);
        goto L19
    L4:
        if (TTNetInitMetrics.c().j != 0) goto L6;
        TTNetInitMetrics.c().j = System.nanoTime();     // Catch: Throwable -> L13
    L6:
        CookieManager r0 = null;
        if (e.get() == true) goto L9;
        CookieSyncManager.createInstance(r7);     // Catch: Throwable -> L13
        r0 = CookieManager.getInstance();     // Catch: Throwable -> L13
        r0.setAcceptCookie(true);     // Catch: Throwable -> L13
    L9:
        a(r7, r8);     // Catch: Throwable -> L13
        if (Logger.debug() == false) goto L19;
        Logger.d("Process", " CookieManager = " + r0 + " pid = " + Process.myPid());     // Catch: Throwable -> L13
        goto L19
    }

    public static void a(Context r2, boolean r3, boolean r4, InterfaceC0125a r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        InterfaceC0125a r7 = (InterfaceC0125a) ZeusTransformUtils.wrapperContextForParams(r5, InterfaceC0125a.class, "com.obric.memorydata.plugin");
        if (f2385a == true) goto L8;
        if (r7 != null) goto L8;
        throw new AssertionError();
    L8:
        if (r3 == true) goto L10;
        if (r4 == false) goto L15;
        a(r6, false, r7);
        return;
    L15:
        a(r7);
        return;
    L10:
        if (com.bytedance.frameworks.baselib.network.a.b.i() == false) goto L12;
        b(r6, true, r7);
        return;
    L12:
        a(r6, true, r7);
    }

    private static void a(InterfaceC0125a r2) {
        InterfaceC0125a r3 = (InterfaceC0125a) ZeusTransformUtils.wrapperContextForParams(r2, InterfaceC0125a.class, "com.obric.memorydata.plugin");
        d.countDown();
        r3.a();
    }

    private static void a(String r3, InterfaceC0125a r4) {
        InterfaceC0125a r5 = (InterfaceC0125a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0125a.class, "com.obric.memorydata.plugin");
        if (com.bytedance.frameworks.baselib.network.a.b.e() == true) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put(CommonConsts.APM_INNER_EVENT_COST_INIT, "failed");     // Catch: JSONException -> L8
        r1.put(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, r3);     // Catch: JSONException -> L8
    L10:
        r5.a("TTNET-COOKIE", CommonConsts.APM_INNER_EVENT_COST_INIT, r1);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    private static void a(CookieHandler r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (c.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L15;
        Logger.d("CookieInitializer", "CookieInitV2 set cookieHandler:" + r4);
    L15:
        CookieHandler.setDefault(r4);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        c.set(false);
        Logger.e("CookieInitializer", "CookieInitV2 set cookieHandler error", e);
    }

    public static boolean a(Object r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (ZeusTransformUtils.instanceOf(r2, com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L8;
        if (((com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r2, com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.memorydata.plugin")).w == false) goto L8;
        return true;
    }

    public static CookieManager b() {
        Object r0 = f2386b;
        monitor-enter(r0);
        CountDownLatch r1 = d;     // Catch: Throwable -> L6 Exception -> L20
        r1.await(5000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L6 Exception -> L20
        r1.countDown();     // Catch: Throwable -> L6 Exception -> L20
    L6:
        th = move-exception;
        throw th;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L6
        CookieManager r2 = null;
        if (c.get() == false) goto L13;
        return null;
    L13:
        if (e.get() == false) goto L24;
    L17:
        return r2;
    L24:
        r2 = CookieManager.getInstance();     // Catch: Throwable -> L21
        if (r2.acceptCookie() == true) goto L17;
        r2.setAcceptCookie(true);     // Catch: Throwable -> L21
        goto L17
    }

    private static void b(Context r5, boolean r6, InterfaceC0125a r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        final InterfaceC0125a r9 = (InterfaceC0125a) ZeusTransformUtils.wrapperContextForParams(r7, InterfaceC0125a.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d("CookieInitializer", "cookieInitV2 start isMain:" + r6);
    L5:
        TTNetInitMetrics.c().j = System.nanoTime();
    L12:
        th = move-exception;
        Logger.d("CookieInitializer", "cookieInitV2 failed", th);
        a(th.getMessage(), r9);
    L14:
        TTNetInitMetrics.c().k = System.nanoTime();
        a(r9);
        r9.a(r6);
        return;
    L7:
        if (e.get() == false) goto L9;
        SSCookieHandler.CookieInitType r0 = SSCookieHandler.CookieInitType.INIT_V2_DISABLE_COOKIE_MGR;     // Catch: Throwable -> L12
    L10:
        a(new SSCookieHandler(r8, null, r0, new AnonymousClass2(r9)));     // Catch: Throwable -> L12
        goto L14
    L9:
        r0 = SSCookieHandler.CookieInitType.INIT_V2_PREFER_DELAY_COOKIE_MGR;     // Catch: Throwable -> L12
        goto L10
    }

    private static /* synthetic */ void c(Context r2, boolean r3, InterfaceC0125a r4) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, (InterfaceC0125a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0125a.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ void lambda$eNY2LJJj0Uq_uLWCFHVl6ONCVcw(Context r0, boolean r1, InterfaceC0125a r2) {
        c(r0, r1, r2);
    }
}
