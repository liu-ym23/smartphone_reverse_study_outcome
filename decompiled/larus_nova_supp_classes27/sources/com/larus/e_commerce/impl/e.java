package com.larus.e_commerce.impl;

import android.app.Application;
import android.os.Looper;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.core.hybrid.ECBridgeProviderInjector;
import com.bytedance.android.ec.host.impl.ECHostAIService;
import com.bytedance.android.ec.host.impl.ECHostService;
import com.bytedance.android.ec.host.impl.HybridHostService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.search.host.impl.ECSearchHostService;
import com.bytedance.android.ecom.live.adapter.ECLiveAdapter;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.live.api.ILiveService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e {
    public static final e a = null;
    public static final ExecutorService b = null;
    public static volatile boolean c;
    public static final Lazy d = null;
    public static final Lazy e = null;

    public e() {
    }

    static {
        a = new e();
        b = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ECInitializerHelper"));
        d = LazyKt.lazy(new a());
        e = LazyKt.lazy(new b());
    }

    public static Object a() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L18
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L18
        FLogger r4 = FLogger.a;     // Catch: Throwable -> L18
        StringBuilder r6 = new StringBuilder("thread: ");     // Catch: Throwable -> L18
        Looper r1 = Looper.myLooper();     // Catch: Throwable -> L18
        if (r1 == null) goto L6;
        Thread r5 = ThreadMethodProxy.getLooperThread(r1);     // Catch: Throwable -> L18
    L7:
        r6.append(r5);     // Catch: Throwable -> L18
        r6.append(" isMainThread:");     // Catch: Throwable -> L18
        r6.append(Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()));     // Catch: Throwable -> L18
        r4.i("InitializerHelper", r6.toString());     // Catch: Throwable -> L18
        final CountDownLatch r7 = new CountDownLatch(1);     // Catch: Throwable -> L18
        final Ref.ObjectRef r8 = new Ref.ObjectRef();     // Catch: Throwable -> L18
        IHybridHostService r9 = com.bytedance.android.ec.hybrid.a.a;     // Catch: Throwable -> L18
        HybridHostService r10 = (HybridHostService) e.getValue();     // Catch: Throwable -> L18
        ExecutorService r11 = TTExecutors.getIOThreadPool();     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r10, "hostService");     // Catch: Throwable -> L18
        com.bytedance.android.ec.hybrid.a.a = r10;     // Catch: Throwable -> L18
        com.bytedance.android.ec.hybrid.a.b = r11;     // Catch: Throwable -> L18
        ECHostService r12 = new ECHostService();     // Catch: Throwable -> L18
        AppHost.Companion r13 = AppHost.a;     // Catch: Throwable -> L18
        ECLiveAdapter.init(r12, r13.isDebug(), new d(r8, r7), r13.getApplication());     // Catch: Throwable -> L18
        if (r7.await(10, TimeUnit.SECONDS) == false) goto L17;
        Throwable r14 = (Throwable) r8.element;     // Catch: Throwable -> L18
        if (r14 != null) goto L15;
        s89.c r15 = s89.c.a;     // Catch: Throwable -> L18
        Lazy r16 = ECBridgeProviderInjector.b;     // Catch: Throwable -> L18
        ((CopyOnWriteArrayList) ECBridgeProviderInjector.a.a().a).add(r15);     // Catch: Throwable -> L18
        t89.b.a();     // Catch: Throwable -> L18
        t89.a.a();     // Catch: Throwable -> L18
        TradeSearch r17 = TradeSearch.a;     // Catch: Throwable -> L18
        ECSearchHostService r18 = new ECSearchHostService();     // Catch: Throwable -> L18
        r17.getClass();     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r18, "hostService");     // Catch: Throwable -> L18
        TradeSearch.b.put(0, r18);     // Catch: Throwable -> L18
        IECAIHostService.a r0 = IECAIHostService.Companion;     // Catch: Throwable -> L18
        Application r20 = r13.getApplication();     // Catch: Throwable -> L18
        ECHostAIService r21 = new ECHostAIService();     // Catch: Throwable -> L18
        r0.getClass();     // Catch: Throwable -> L18
        IECAIHostService.a.b(r20, r21);     // Catch: Throwable -> L18
        long r22 = System.currentTimeMillis() - r3;     // Catch: Throwable -> L18
        IApplog r23 = (IApplog) ServiceManager.get().getService(IApplog.class);     // Catch: Throwable -> L18
        if (r23 == null) goto L22;
        JSONObject r24 = new JSONObject();     // Catch: Throwable -> L18
        r24.put("interval", r22);     // Catch: Throwable -> L18
        Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L18
        r23.reportEvent("init_ecommerce_interval", r24);     // Catch: Throwable -> L18
    L22:
        return Result.constructor-impl(Unit.INSTANCE);
    L15:
        throw r14;     // Catch: Throwable -> L18
    L17:
        throw new TimeoutException("ECLiveAdapter init timeout after 10s");     // Catch: Throwable -> L18
    L6:
        r5 = null;
    L18:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static boolean c() {
        ILiveService r0 = (ILiveService) d.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    public static void b(Function0 r7, Function1 r8) {
        monitor-enter(e.class);
        FLogger r4 = FLogger.a;     // Catch: Throwable -> L47
        r4.i("InitializerHelper", "init thread name:" + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L47
        a.getClass();     // Catch: Throwable -> L47
        if (c() == false) goto L13;
        if (c == false) goto L13;
        if (r7 == null) goto L10;
        r7.invoke();     // Catch: Throwable -> L47
    L10:
        monitor-exit(e.class);
        return;
    L13:
        if (c() == true) goto L27;
        ILiveService r2 = (ILiveService) d.getValue();     // Catch: Throwable -> L47
        if (r2 == null) goto L27;
        Object r3 = r2.f();     // Catch: Throwable -> L47
        Throwable r5 = Result.exceptionOrNull-impl(r3);     // Catch: Throwable -> L47
        if (r5 == null) goto L25;
        r5.printStackTrace();     // Catch: Throwable -> L47
        r4.e("InitializerHelper", "live init failed " + r5.getMessage(), r5);     // Catch: Throwable -> L47
        AppHost.Companion r9 = AppHost.a;     // Catch: Throwable -> L47
        if (r9.isTestChannel() == false) goto L21;
        throw r5;     // Catch: Throwable -> L47
    L21:
        if (r9.isDebugChannel() == true) goto L51;
        if (r8 == null) goto L44;
        r8.invoke(r5);     // Catch: Throwable -> L47
    L44:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L47
        monitor-exit(e.class);
        return;
    L51:
        throw r5;     // Catch: Throwable -> L47
    L25:
        Result.box-impl(r3);     // Catch: Throwable -> L47
    L27:
        if (c == true) goto L44;
        if (c() == false) goto L44;
        Object r1 = a();     // Catch: Throwable -> L47
        if (Result.isSuccess-impl(r1) == false) goto L35;
        Unit r6 = (Unit) r1;     // Catch: Throwable -> L47
        c = true;     // Catch: Throwable -> L47
        r4.i("BackgroundLazyInit", "ECommerce init completed");     // Catch: Throwable -> L47
        if (r7 == null) goto L35;
        r7.invoke();     // Catch: Throwable -> L47
    L35:
        Throwable r11 = Result.exceptionOrNull-impl(r1);     // Catch: Throwable -> L47
        if (r11 == null) goto L44;
        r11.printStackTrace();     // Catch: Throwable -> L47
        r4.e("InitializerHelper", "ecommerce init failed " + r11.getMessage(), r11);     // Catch: Throwable -> L47
        c = false;     // Catch: Throwable -> L47
        AppHost.Companion r0 = AppHost.a;     // Catch: Throwable -> L47
        if (r0.isTestChannel() == false) goto L40;
        throw r11;     // Catch: Throwable -> L47
    L40:
        if (r0.isDebugChannel() == true) goto L52;
        if (r8 == null) goto L44;
        r8.invoke(r11);     // Catch: Throwable -> L47
        goto L44
    L52:
        throw r11;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    }
}
