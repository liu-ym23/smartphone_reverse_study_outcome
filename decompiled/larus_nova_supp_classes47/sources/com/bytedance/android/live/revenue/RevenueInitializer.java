package com.bytedance.android.live.revenue;

import android.util.Log;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.t1;
import com.bytedance.android.live.gson.BooleanTypeAdapter;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.revenue.platform.container.impl.JsLongTypeAdapter;
import com.bytedance.android.live.revenue.platform.network.api.IDynamicHostNetworkService;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.scope.m;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.ugc.aweme.debug.tag.global.solid.OfflineEnvTag;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import e33.l;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u0010\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J,\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0082\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\u0002R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/revenue/RevenueInitializer;", "", "", "doInit", "initializeDeserializer", "R", "", "name", "Lkotlin/Function0;", "block", "measureWithLiveInitAssistant", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ensureInitialized", "", "initialized", "Z", "com/bytedance/android/live/revenue/RevenueInitializer$a", "isCurThreadIniting", "Lcom/bytedance/android/live/revenue/RevenueInitializer$a;", "<init>", "()V", "revenue-integration_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RevenueInitializer {
    public static final RevenueInitializer INSTANCE = null;
    private static volatile boolean initialized;
    private static final a isCurThreadIniting = null;

    public static final class a extends ThreadLocal<Boolean> {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        public final Boolean initialValue() {
            return Boolean.FALSE;
        }
    }

    private RevenueInitializer() {
    }

    static {
        INSTANCE = new RevenueInitializer();
        isCurThreadIniting = new a();
    }

    private final void doInit() {
        Map r0 = hz.b.a;
        if (k.f(INetworkService.class) == null) goto L5;
        k.f(INetworkService.class).injectProtoDecoders(r0);
    L5:
        cc.a.call("modelx");
        com.bytedance.android.live.revenue.platform.settings.impl.b.a();
        LiveInitAssistant r1 = LiveInitAssistant.INSTANCE;
        r1.markTimeStart("revenue_service_register_duration");
        cc.a.call("scope-modules");
        l[] r2 = t23.a.a;
        m r3 = m.e;
        t23.a r4 = t23.a.b;
        r3.getClass();
        m.e(r4);
        Unit r5 = Unit.INSTANCE;
        r1.markTimeEnd("revenue_service_register_duration");
        Function0 r6 = t1.a;
        AnonymousClass2 r7 = AnonymousClass2.INSTANCE;
        Intrinsics.checkNotNullParameter(r7, "onViolation");
        t1.a = r7;
        r1.markTimeStart("revenue_global_scope_enter_duration");
        cy0.e.a.getClass();
        com.bytedance.android.scope.l.a(cy0.e.a.a);
        r1.markTimeEnd("revenue_global_scope_enter_duration");
        if (LocalTestManager.c(new Class[]{OfflineEnvTag.class}) == false) goto L8;
        cc.a.call("settings");
        wo3.a.a();
    L8:
        Gson r8 = GsonHelper.get();
        Gson r9 = l97.a.a;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        l97.a.a = r8;
        GsonBuilder r10 = GsonHelper.get().newBuilder();
        r10.registerTypeAdapter(Boolean.TYPE, new BooleanTypeAdapter());
        r10.registerTypeAdapter(Boolean.class, new BooleanTypeAdapter());
        r10.registerTypeAdapter(Long.TYPE, new JsLongTypeAdapter());
        r10.registerTypeAdapter(Long.class, new JsLongTypeAdapter());
        Gson r12 = r10.create();
        Gson r13 = uh7.b.a;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        uh7.b.a = r12;
        initializeDeserializer();
    }

    private final void initializeDeserializer() {
        uh7.c r0 = uh7.c.d;
        IDynamicHostNetworkService.b.C0099b r1 = IDynamicHostNetworkService.b.a;
        r0.getClass();
        uh7.c.c(r1);
        uh7.c.c(IDynamicHostNetworkService.b.a.a);
        uh7.c.c(IDynamicHostNetworkService.d.a);
        uh7.c.c(j01.c.g);
        uh7.c.c(lz0.b.a);
        uh7.c.c(com.bytedance.android.live.profit.redpacket.model.e.a);
    }

    public final void ensureInitialized() {
        if (initialized == false) goto L5;
        return;
    L5:
        a r2 = isCurThreadIniting;
        Boolean r3 = r2.get();
        Boolean r4 = Boolean.TRUE;
        if (Intrinsics.areEqual(r3, r4) == false) goto L8;
        return;
    L8:
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L10:
        if (initialized == false) goto L29;
        monitor-exit(this);
        return;
    L29:
        r2.set(r4);     // Catch: Throwable -> L18
        ALogger.i("RevenueInitializer", "run doInit  " + ThreadMethodProxy.currentThread().getName() + "  " + Log.getStackTraceString(new Throwable()) + ' ');     // Catch: Throwable -> L18
        INSTANCE.doInit();     // Catch: Throwable -> L18
        initialized = true;     // Catch: Throwable -> L18
        ALogger.i("RevenueInitializer", "init down");     // Catch: Throwable -> L18
        r2.remove();     // Catch: Throwable -> L26
        ALogger.i("RevenueInitializer", "init finally");     // Catch: Throwable -> L26
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        ALogger.i("RevenueInitializer", "init err " + ThreadMethodProxy.currentThread().getName() + "  " + Log.getStackTraceString(th) + ' ');     // Catch: Throwable -> L23
        if ((th instanceof Exception) == false) goto L22;
        LiveInitAssistant.INSTANCE.reportError(th, "RevenueInitializer_ERR", new HashMap());     // Catch: Throwable -> L23
    L22:
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        isCurThreadIniting.remove();     // Catch: Throwable -> L26
        ALogger.i("RevenueInitializer", "init finally");     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    }

    private final <R> R measureWithLiveInitAssistant(String r2, Function0<? extends R> r3) {
        LiveInitAssistant r0 = LiveInitAssistant.INSTANCE;
        r0.markTimeStart(r2);
        R r4 = (R) r3.invoke();
        r0.markTimeEnd(r2);
        return r4;
    }
}
