package com.obric.assistant.reporter;

import android.os.SystemClock;
import android.provider.Settings;
import com.bytedance.applog.AppLog;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.im.IInstantMessenger;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.IObricPluginActivityRecordHelper;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.reporter.utils.AppStartState;
import com.obric.assistant.reporter.utils.ObricLaunchReportManager;
import com.obric.assistant.reporter.utils.e;
import com.obric.assistant.reporter.utils.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import f09.a;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import nba.i;
import nba.l;
import org.json.JSONObject;
import v48.g;
import v48.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J \u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020\nH\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/assistant/reporter/ObricReporterImpl;", "Lcom/obric/assistant/reporter/IObricReporter;", "<init>", "()V", "reportPerformanceCost", "", "scene", "", "stage", "costMs", "", "success", "", DBDefinition.EXTRA, "", "flushCachedDialogClicks", "lastBackgroundTime", "launchMethod", "launchWakeup", "launchService", "dataLock", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "updateLaunchReportParams", "allowUpdateInForeground", "updateLaunchServiceParams", "updateWakeupSource", "source", "resetLaunchReportParams", "getLaunchMethod", "getLaunchService", "getKeepAliveLevelMode", "getLastLaunchType", "", "initObricAppStartManager", "getCurrentProcessAdj", "markStartedByExternalKeepAliveNormalService", "getWakeupSource", "setLastBackgroundTime", "time", "getLastBackgroundTime", "initLaunchReport", "initFrontierReport", "initBuildChannelWriteValue", "initFlowAppLogObserver", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricReporterImpl implements IObricReporter {
    public String b;
    public String c;
    public String d;
    public final Object e;
    public final CoroutineScope f;

    public static final class b implements a.b {
        public b() {
        }

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
        }

        public final void onAppForeground() {
            AppHost.Companion r0 = AppHost.a;
            r0.a().c(this);
            int r1 = a.a;
            a.a(r0.getApplication());
        }
    }

    public static final class c implements g {
        public final f a;

        public c() {
            ObricLaunchReportManager.a.getClass();
            this.a = new f();
        }

        public final void a(String r2, JSONObject r3) {
            Intrinsics.checkNotNullParameter(r2, "activityName");
            Intrinsics.checkNotNullParameter(r3, "flatParams");
            this.a.a(r2, r3);
        }

        public final void b(String r2, JSONObject r3) {
            Intrinsics.checkNotNullParameter(r2, "activityName");
            Intrinsics.checkNotNullParameter(r3, "flatParams");
            this.a.b(r2, r3);
        }
    }

    public static final class d implements h {
        public d() {
        }

        public final void onSessionBatchEvent(long r4, String r6) {
            FLogger.a.i("ObricReporterImpl", "onSessionBatchEvent: id = " + r4 + ", sessonId = " + r6);
        }

        public final void onSessionStart(long r4, String r6) {
            FLogger.a.i("ObricReporterImpl", "onSessionStart: id = " + r4 + ", sessonId = " + r6);
        }

        public final void onSessionTerminate(long r4, String r6) {
            FLogger r0 = FLogger.a;
            r0.i("ObricReporterImpl", "onSessionTerminate: id = " + r4 + ", sessonId = " + r6);
            ObricLaunchReportManager.a.getClass();
            StringBuilder r5 = new StringBuilder("reportTerminateForAssistant: sessionId = ");
            r5.append(r6);
            r0.i("ObricLaunchReportManager", r5.toString());
            Map r7 = ObricLaunchReportManager.R;
            if (r6 != null) goto L5;
            String r2 = "";
        L6:
            JSONObject r8 = (JSONObject) r7.get(r2);
            if (r8 != null) goto L9;
            r0.i("ObricLaunchReportManager", "reportTerminateForAssistant: sessionId = " + r6 + ", cachedParams is null");
            return;
        L9:
            r0.i("ObricLaunchReportManager", "cachedParams = " + r8);
            by7.g.d.onEvent(ObricLaunchReportManager.c, r8);
            return;
        L5:
            r2 = r6;
            goto L6
        }
    }

    static {
    }

    public final String a() {
        Object r1 = this.e;
        monitor-enter(r1);
        String r2 = this.b;     // Catch: Throwable -> L7
        FLogger.a.d("ObricReporterImpl", "@getLaunchMethod@ " + r2);     // Catch: Throwable -> L7
        monitor-exit(r1);
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public final void c() {
        e r0 = e.a;
        if (e.c != AppStartState.ColdStart) goto L5;
        e.c = AppStartState.WarmStart;
    L5:
        FLogger.a.d("ObricReporterImpl", "markStartedByExternalKeepAliveNormalService");
    }

    public final void d() {
        FLogger.a.d("ObricReporterImpl", "resetLaunchReportParams");
        Object r0 = this.e;
        monitor-enter(r0);
        this.b = IInteractionStateService.WAKE_UP_SOURCE_OTHER;     // Catch: Throwable -> L8
        this.d = "open_doubao";     // Catch: Throwable -> L8
        this.c = "voice.other";     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        IAssistantInteractionServiceKt.getInteractionStateService().setWakeUpAppPkg(IInteractionStateService.WAKE_UP_SOURCE_OTHER, "resetLaunchReportParams");
        return;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.obric.assistant.reporter.ObricReporterImpl$initLaunchReport$2] */
    public final void e() {
        IApplog.Companion r0 = IApplog.a;
        r0.w(new c());
        r0.s(new ObricReporterImpl$initLaunchReport$2(this));
        r0.r(new d());
        Lazy r1 = com.obric.assistant.reporter.utils.c.a;
        AppHost.a.getApplication().registerActivityLifecycleCallbacks(new com.obric.assistant.reporter.utils.b());
    }

    public final void f() {
        nba.c.a.getClass();
        FLogger.a.d("AppLogIDLStub", "init FlowAppLogObserverHelper");
        AppLog.addSessionHook(new nba.g());
        AppLog.addEventObserver(new i());
        AppLog.addDataObserver(new l());
    }

    public final void g() {
        Object r0 = this.e;
        monitor-enter(r0);
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final String getWakeupSource() {
        Object r1 = this.e;
        monitor-enter(r1);
        String r2 = this.c;     // Catch: Throwable -> L7
        FLogger.a.d("ObricReporterImpl", "@getLaunchWakeup@ " + r2);     // Catch: Throwable -> L7
        monitor-exit(r1);
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public final void i() {
        AppHost.Companion r0 = AppHost.a;     // Catch: Exception -> L4
        Settings.Global.putString(r0.getApplication().getContentResolver(), "obric_app_channel_com_larus_nova", r0.getBuildChannel());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        FLogger.a.e("ObricReporterImpl", "initBuildChannelWriteValue try to write settings value error: " + e);
    }

    public final String j() {
        return ObricFeatureServiceDelegate.b.f();
    }

    public final void k() {
        e r0 = e.a;
        if (e.b == true) goto L20;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (e.b == false) goto L11;
        monitor-exit(r0);
        return;
    L11:
        e.b = true;     // Catch: Throwable -> L15
        e.d = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        AppHost.a.a().j(e.e);     // Catch: Throwable -> L15
        FLogger.a.i("ObricAppStartManager", "ObricAppStartManager initialized: applicationOnCreateFinishedElapsedRealtime=" + e.d);     // Catch: Throwable -> L15
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r0);
        t0.a.postDelayed(new com.obric.assistant.reporter.utils.d(), 2000);
        return;
    }

    public final String l() {
        Object r1 = this.e;
        monitor-enter(r1);
        String r2 = this.d;     // Catch: Throwable -> L7
        FLogger.a.d("ObricReporterImpl", "@getLaunchService@ " + r2);     // Catch: Throwable -> L7
        monitor-exit(r1);
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public final int m() {
        e r0 = e.a;
        int r1 = e.c.getValue();
        FLogger.a.d("ObricReporterImpl", "getLastLaunchType: " + r1);
        return r1;
    }

    public final void o() {
        AtomicReference<String> r0 = vfa.c.a;
        IInstantMessenger r1 = (IInstantMessenger) ServiceManager.get().getService(IInstantMessenger.class);
        com.larus.im.network.f r2 = null;
        if (r1 == null) goto L5;
        com.larus.im.network.f r3 = r1.a(0);
    L6:
        if (r3 == null) goto L8;
        r3.a(new vfa.b());
    L8:
        IInstantMessenger r4 = (IInstantMessenger) ServiceManager.get().getService(IInstantMessenger.class);
        if (r4 == null) goto L11;
        r2 = r4.a(0);
    L11:
        if (r2 == null) goto L14;
        r2.i(new vfa.a());
        return;
    L14:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final int q() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Integer.valueOf(CastIntegerProtector.parseInt(StringsKt.trim(FilesKt.readText$default(new PolarisFileWrapper("/proc/self/oom_score_adj"), null, 1, null)).toString())));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L10;
        FLogger.a.w("ObricReporterImpl", "getCurrentProcessAdj failed", r2);
    L10:
        if (Result.isFailure-impl(r1) == false) goto L12;
        r1 = -1;
    L12:
        Number r3 = (Number) r1;
        int r4 = r3.intValue();
        FLogger.a.d("ObricReporterImpl", "getCurrentProcessAdj: " + r4);
        return r3.intValue();
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final void r() {
        AppHost.Companion r0 = AppHost.a;
        if (r0.a().isAppBackground() == true) goto L6;
        int r1 = a.a;
        a.a(r0.getApplication());
        return;
    L6:
        FLogger.a.i("ObricReporterImpl", "flushCachedDialogClicks: app in background, defer until foreground");
        r0.a().j(new b());
    }

    public ObricReporterImpl() {
        this.b = IInteractionStateService.WAKE_UP_SOURCE_OTHER;
        this.c = "voice.other";
        this.d = "open_doubao";
        this.e = new Object();
        this.f = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    }

    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "launchService");
        n(this.b, r3, false);
    }

    public final void p(String r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        FLogger.a.d("ObricReporterImpl", "updateLaunchWakeupSource: wakeupSource = " + r5);
        Object r0 = this.e;
        monitor-enter(r0);
        this.c = r5;     // Catch: Throwable -> L7
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void n(String r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "launchMethod");
        Intrinsics.checkNotNullParameter(r6, "launchService");
        FLogger r0 = FLogger.a;
        r0.d("ObricReporterImpl", "setLaunchReportParams: launchMethod = " + r5 + ", launchService = " + r6 + ", allowUpdateInForeground = " + r7);
        IObricPluginActivityRecordHelper.a.getClass();
        IObricPluginActivityRecordHelper r1 = IObricPluginActivityRecordHelper.a.a();
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.e() != true) goto L7;
    L8:
        if (r7 == false) goto L10;
    L14:
        Object r8 = this.e;
        monitor-enter(r8);
        this.b = r5;     // Catch: Throwable -> L19
        this.d = r6;     // Catch: Throwable -> L19
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r8);
        return;
    L19:
        th = move-exception;
        throw th;
    L10:
        if (AppHost.a.a().isAppBackground() == false) goto L12;
        if (r2 == false) goto L14;
    L12:
        r0.d("ObricReporterImpl", "is not allow update in foreground, ignore");
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final void h(String r13, String r14, long r15, boolean r17, Map<String, String> r18) {
        Intrinsics.checkNotNullParameter(r13, "scene");
        Intrinsics.checkNotNullParameter(r14, "stage");
        CoroutineScope r4 = e.a;
        Intrinsics.checkNotNullParameter(r13, "scene");
        Intrinsics.checkNotNullParameter(r14, "stage");
        BuildersKt.launch$default(e.a, null, null, new ObricPerformanceCostReporter$report$1(r13, r14, r15, r18, r17, null), 3, null);
    }
}
