package com.obric.sva.sdk.apm;

import android.app.Activity;
import android.app.Application;
import android.os.Process;
import b27.j;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.util.a;
import com.bytedance.apm.util.r;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.larus.apm.api.IApmConfigs;
import com.larus.apm.api.IExtraParams;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.e10;
import com.larus.settings.value.f2;
import com.larus.settings.value.te;
import com.larus.settings.value.ur;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.IObricSlardarConfigService;
import com.obric.assistant.common.spi.ObricConfigServiceDelegate;
import com.obric.assistant.common.spi.alog.ObricAlogServiceDelegate;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.memorydata.plugin_api.BuildConfig;
import com.obric.sva.sdk.applog.InteractorApplogHelper;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import is3.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qt9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0013\u001a\u00020\u00122\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0005J,\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\"J\u0014\u0010%\u001a\u00020\u00122\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002"}, d2 = {"Lcom/obric/sva/sdk/apm/InteractorApmHelper;", "", "<init>", "()V", "enableOptApmLooper", "", "getEnableOptApmLooper", "()Z", "enableOptApmLooper$delegate", "Lkotlin/Lazy;", "TAG", "", "apmStarted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "apmInitRequested", "startCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "", "initApm", "onStarted", "configApmOpt", "configBuilder", "Lcom/bytedance/apm/config/ApmInitConfig$Builder;", "configBlockDetect", "configBinderMonitor", "startApm", "did", "notifyApmStarted", "registerDolaCloudControlConsumer", "isMinorMode", "monitorEventForSlardar", EventVerify.TYPE_EVENT_V1, "category", "Lorg/json/JSONObject;", "metric", "extraLog", "registerCrashCallback", "callback", "libs_mainlandRelease", "blockConfig", "Lcom/larus/settings/provider/BlockDetectConfig;"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class InteractorApmHelper {
    public static final InteractorApmHelper INSTANCE = null;
    private static final String TAG = "InteractorApmHelper";
    private static final AtomicBoolean apmInitRequested = null;
    private static final AtomicBoolean apmStarted = null;
    private static final Lazy enableOptApmLooper$delegate = null;
    private static final CopyOnWriteArrayList<Function0<Unit>> startCallbacks = null;

    private InteractorApmHelper() {
    }

    public static /* synthetic */ boolean a() {
        return enableOptApmLooper_delegate$lambda$0();
    }

    public static /* synthetic */ t b() {
        return configBlockDetect$lambda$8();
    }

    public static /* synthetic */ void c(Activity r0) {
        initApm$lambda$6$lambda$5(r0);
    }

    static {
        INSTANCE = new InteractorApmHelper();
        enableOptApmLooper$delegate = LazyKt.lazy(new c());
        apmStarted = new AtomicBoolean(false);
        apmInitRequested = new AtomicBoolean(false);
        startCallbacks = new CopyOnWriteArrayList();
    }

    private static final t configBlockDetect$lambda$8() {
        e10 r0 = e10.a;
        return (t) l0.a(new t(0), new te());
    }

    private static final boolean enableOptApmLooper_delegate$lambda$0() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new f2())).booleanValue();
    }

    private final boolean getEnableOptApmLooper() {
        return ((Boolean) enableOptApmLooper$delegate.getValue()).booleanValue();
    }

    private final void notifyApmStarted() {
        if (apmStarted.get() == true) goto L5;
        return;
    L5:
        CopyOnWriteArrayList<Function0<Unit>> r0 = startCallbacks;
        monitor-enter(r0);
        List r1 = CollectionsKt.toList(r0);     // Catch: Throwable -> L18
        r0.clear();     // Catch: Throwable -> L18
        monitor-exit(r0);
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L17;
        Function0 r3 = (Function0) r2.next();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L15
        r3.invoke();     // Catch: Throwable -> L15
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L17:
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private final void configApmOpt(com.bytedance.apm.config.b.a r3) {
        if (getEnableOptApmLooper() == false) goto L5;
        j.a = true;
        r3.p = true;
        r3.q = true;
    L5:
        r3.o = true;
    }

    private final void configBinderMonitor(com.bytedance.apm.config.b.a r3) {
        e10 r0 = e10.a;
        int r1 = l0.a;
        r3.h = ((Boolean) l0.a(Boolean.FALSE, new ur())).booleanValue();
    }

    private final void configBlockDetect(com.bytedance.apm.config.b.a r7) {
        Lazy r0 = LazyKt.lazy(new a());
        if (SetsKt.setOf(new String[]{"inhouse", "local_test", "auto_test", "beta", BuildConfig.BUILD_TYPE}).contains(AppHost.a.getBuildChannel()) == true) goto L5;
        return;
    L5:
        if (configBlockDetect$lambda$9(r0).b() == false) goto L9;
        r7.c = configBlockDetect$lambda$9(r0).b();
        r7.d = configBlockDetect$lambda$9(r0).c();
        r7.e = configBlockDetect$lambda$9(r0).a();
        return;
    }

    private static final t configBlockDetect$lambda$9(Lazy<t> r0) {
        return (t) r0.getValue();
    }

    private static final void initApm$lambda$6$lambda$5(Activity r3) {
        FLogger.a.i("ActivityLeak", "onActivityLeaked():" + r3.getLocalClassName());
    }

    private final boolean startApm(String r6) {
        if (apmStarted.get() == false) goto L35;
        notifyApmStarted();
        return true;
    L35:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L27
        IApmConfigs r1 = (IApmConfigs) ServiceManager.get().getService(IApmConfigs.class);     // Catch: Throwable -> L27
        if (r1 == null) goto L26;
        ApmStartConfig.Builder r2 = new ApmStartConfig.Builder();     // Catch: Throwable -> L27
        AppHost.Companion r3 = AppHost.a;     // Catch: Throwable -> L27
        ApmStartConfig.Builder r7 = r2.aid(r3.getAppId()).channel(r3.getBuildChannel()).appVersion(r3.getVersionName()).updateVersionCode(String.valueOf(r3.getUpdateVersionCode())).deviceId(r6).useDefaultTTNetImpl(true).releaseBuild(r.a()).requestTagHeaderProvider(new startApm.1.configBuilder.1()).dynamicParams(new startApm.1.configBuilder.2());     // Catch: Throwable -> L27
        Iterator r4 = IExtraParams.a.c().entrySet().iterator();     // Catch: Throwable -> L27
    L10:
        if (r4.hasNext() == false) goto L12;
        Map.Entry r5 = (Map.Entry) r4.next();     // Catch: Throwable -> L27
        r7.param((String) r5.getKey(), (String) r5.getValue());     // Catch: Throwable -> L27
        goto L10
    L12:
        Map r8 = ObricConfigServiceDelegate.b.getCommonParams();     // Catch: Throwable -> L27
        if (r8 == null) goto L19;
        Iterator r9 = r8.entrySet().iterator();     // Catch: Throwable -> L27
    L16:
        if (r9.hasNext() == false) goto L19;
        Map.Entry r10 = (Map.Entry) r9.next();     // Catch: Throwable -> L27
        r7.param((String) r10.getKey(), (String) r10.getValue());     // Catch: Throwable -> L27
    L19:
        if (AppHost.a.isOversea() == false) goto L21;
        r1.g();     // Catch: Throwable -> L27
        ApmStartConfig.Builder r11 = r7.configFetchUrl(null);     // Catch: Throwable -> L27
        r1.e();     // Catch: Throwable -> L27
        ApmStartConfig.Builder r12 = r11.defaultReportUrls(null);     // Catch: Throwable -> L27
        r1.b();     // Catch: Throwable -> L27
        r12.exceptionLogDefaultReportUrls(null);     // Catch: Throwable -> L27
    L21:
        String r13 = ObricAlogServiceDelegate.b.c(a.a(Process.myPid()), null);     // Catch: Throwable -> L27
        if (r13 == null) goto L24;
        r7.setAlogFilesDir(r13);     // Catch: Throwable -> L27
    L24:
        int r14 = com.bytedance.apm.c.b.a;     // Catch: Throwable -> L27
        com.bytedance.apm.c.a(r7.build());     // Catch: Throwable -> L27
        apmStarted.set(true);     // Catch: Throwable -> L27
        ((IObricSlardarConfigService) nda.b.a.getValue()).a();     // Catch: Throwable -> L27
        notifyApmStarted();     // Catch: Throwable -> L27
        Object r15 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L27
    L29:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L34;
        apmInitRequested.set(false);
        FLogger.a.e(TAG, "startApm failed", r16);
        r15 = Boolean.FALSE;
    L34:
        return ((Boolean) r15).booleanValue();
    L26:
        throw new IllegalStateException();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }

    public final void initApm(Function0<Unit> r7) {
        boolean r0 = true;
        if (r7 == null) goto L18;
        CopyOnWriteArrayList<Function0<Unit>> r2 = startCallbacks;
        monitor-enter(r2);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (apmStarted.get() == false) goto L10;
        boolean r3 = true;
    L13:
        monitor-exit(r2);
    L19:
        if (r3 == false) goto L30;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L26
        if (r7 == null) goto L23;
        r7.invoke();     // Catch: Throwable -> L26
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L24:
        Result.constructor-impl(r8);     // Catch: Throwable -> L26
        return;
    L23:
        r8 = null;
    L26:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L30:
        if (apmStarted.get() == false) goto L34;
        notifyApmStarted();
        return;
    L34:
        if (apmInitRequested.compareAndSet(false, true) == true) goto L57;
        return;
    L57:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L41
        ApmAgent.FAST_MODE = true;     // Catch: Throwable -> L41
        jt3.a.a = true;     // Catch: Throwable -> L41
        ((hs3.a) is3.a.h()).d = true;     // Catch: Throwable -> L41
        ((hs3.a) d.a.a).d = true;     // Catch: Throwable -> L41
        ns3.c r10 = new ns3.c(false, false, false);     // Catch: Throwable -> L41
        com.bytedance.apm.config.b.a r5 = new com.bytedance.apm.config.b.a();     // Catch: Throwable -> L41
        r5.m = r10;     // Catch: Throwable -> L41
        r5.i = "com.larus.nova:interactor";     // Catch: Throwable -> L41
        r5.b = 20000000;     // Catch: Throwable -> L41
        r5.g = false;     // Catch: Throwable -> L41
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L41
        configBinderMonitor(r5);     // Catch: Throwable -> L41
        AppHost.Companion r11 = AppHost.a;     // Catch: Throwable -> L41
        r5.j = r11.isDebug();     // Catch: Throwable -> L41
        r5.k = true;     // Catch: Throwable -> L41
        r5.n = false;     // Catch: Throwable -> L41
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L41
        configApmOpt(r5);     // Catch: Throwable -> L41
        com.bytedance.apm.config.a.a r6 = new com.bytedance.apm.config.a.a();     // Catch: Throwable -> L41
        r6.a = false;     // Catch: Throwable -> L41
        r6.c = true;     // Catch: Throwable -> L41
        r6.b = 60000;     // Catch: Throwable -> L41
        r6.d = true;     // Catch: Throwable -> L41
        r6.e = new b();     // Catch: Throwable -> L41
        r5.l = new com.bytedance.apm.config.a(r6);     // Catch: Throwable -> L41
        com.bytedance.apm.config.b r12 = new com.bytedance.apm.config.b(r5);     // Catch: Throwable -> L41
        int r13 = com.bytedance.apm.c.b.a;     // Catch: Throwable -> L41
        Application r14 = r11.getApplication();     // Catch: Throwable -> L41
        ApmDelegate.g.a.c(r14, r12);     // Catch: Throwable -> L41
        if (com.bytedance.apm.d.c == false) goto L39;
        bt3.c.a().b(new com.bytedance.apm.b());     // Catch: Throwable -> L41
    L39:
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L43:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 != null) goto L53;
        InteractorApplogHelper r17 = InteractorApplogHelper.INSTANCE;
        String r18 = r17.getDeviceId();
        if (r18.length() > 0) goto L49;
        r0 = false;
    L49:
        if (r0 == false) goto L51;
        startApm(r18);
        return;
    L51:
        r17.addGetAppLogIdListener(new AnonymousClass5());
        return;
    L53:
        apmInitRequested.set(false);
        FLogger.a.e(TAG, "initApm failed", r16);
        throw r16;
    L41:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    L10:
        if (r2.contains(r7) == true) goto L12;
        r2.add(r7);     // Catch: Throwable -> L15
    L12:
        r3 = false;
        goto L13
    L18:
        r3 = false;
        goto L19
    }

    public final void registerCrashCallback(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Npth.registerCrashCallback(new registerCrashCallback.crashCallback.1(r2), CrashType.ALL);
    }

    public final void registerDolaCloudControlConsumer(boolean r4) {
        if (AppHost.a.isOversea() == false) goto L9;
        FLogger.a.d(TAG, "registerDolaCloudControlConsumer, isMinorMode: " + r4);
        registerDolaCloudControlConsumer.1 r0 = new registerDolaCloudControlConsumer.1(r4);
        if (x8a.c.k == false) goto L7;
        x8a.c.b().c(r0);
        return;
    L7:
        x8a.c.h = r0;
        return;
    }

    public static final /* synthetic */ boolean access$startApm(InteractorApmHelper r0, String r1) {
        return r0.startApm(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void initApm$default(InteractorApmHelper r0, Function0 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.initApm(r1);
    }

    public static /* synthetic */ boolean startApm$default(InteractorApmHelper r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "";
    L6:
        return r0.startApm(r1);
    }

    public final void monitorEventForSlardar(String r4, JSONObject r5, JSONObject r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r4, EventVerify.TYPE_EVENT_V1);
        FLogger.a.d(TAG, "monitorEventForSlardar, event: " + r4 + ", category: " + r5 + ", metric: " + r6 + ", extraLog: " + r7);
        ApmAgent.monitorEvent(r4, r5, r6, r7);
    }
}
