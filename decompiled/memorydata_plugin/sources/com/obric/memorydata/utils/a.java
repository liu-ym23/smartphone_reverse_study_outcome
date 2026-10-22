package com.obric.memorydata.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryActivity;
import com.obric.memorydata.memory.ui.detail.MemoryDetailActivity;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.memory.ui.settings.MemorySettingsActivity;
import com.obric.memorydata.memory.ui.settings.SmartMemorySettingsActivity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin_api.MemoryPluginActiveProvider;
import com.obric.memorydata.plugin_api.MemoryPluginActiveProviderRegistry;
import com.obric.memorydata.recommend.guide.ScreenObservationGuideFeatureActivity;
import com.obric.memorydata.recommend.settings.ScreenObservationSettingsActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000*\u0001\u0013\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/memorydata/utils/ActivityStack;", "Lcom/obric/memorydata/utils/EmptyActivityLifecycleCallbacks;", "Lcom/obric/memorydata/plugin_api/MemoryPluginActiveProvider;", "<init>", "()V", "TAG", "", "FLOW_APP_LOG_DISCONNECT_DELAY_MS", "", "activityStack", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/app/Activity;", "mainHandler", "Landroid/os/Handler;", "applicationContext", "Landroid/content/Context;", "flowAppLogBindFlags", "", "flowAppLogBindListener", "com/obric/memorydata/utils/ActivityStack$flowAppLogBindListener$1", "Lcom/obric/memorydata/utils/ActivityStack$flowAppLogBindListener$1;", "disconnectFlowAppLogRunnable", "Ljava/lang/Runnable;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "application", "Landroid/app/Application;", "registerEnterpriseAccountFinishHook", "registerLogoutFinishHook", "clearMemoryAppTasksOnMain", "onActivityStarted", "activity", "onActivityResumed", "onActivityPaused", "onActivityStopped", "bindFlowAppLog", "scheduleFlowAppLogDisconnect", "cancelFlowAppLogDisconnect", "getLaunchService", "isActive", "", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends s implements MemoryPluginActiveProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13146a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList<Activity> f13147b = null;
    private static final Handler c = null;
    private static Context d;
    private static int e;
    private static final C0718a f = null;
    private static final Runnable g = null;

    /* JADX INFO: renamed from: com.obric.memorydata.utils.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/utils/ActivityStack$flowAppLogBindListener$1", "Lcom/obric/aiagent/flow/applog/IRegisterIPCListener;", "onSuccess", "", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0718a implements com.obric.aiagent.flow.applog.b {
        C0718a() {
        }

        @Override // com.obric.aiagent.flow.applog.b
        public void a() {
            RunLog.INSTANCE.debug("ActivityStack", "applog ipc onSuccess, did = " + AppContext.INSTANCE.getServerDeviceId());
        }

        @Override // com.obric.aiagent.flow.applog.b
        public void b() {
            com.obric.aiagent.flow.applog.b.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/memorydata/utils/ActivityStack$registerEnterpriseAccountFinishHook$1", "Lcom/obric/memorydata/middleware/api/app/EnterpriseAccountListener;", "onEnterEnterprise", "", "onExitEnterprise", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.middleware.api.app.b {
        b() {
        }

        @Override // com.obric.memorydata.middleware.api.app.b
        public void a() {
            a.a(a.f13146a);
        }

        @Override // com.obric.memorydata.middleware.api.app.b
        public void b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/utils/ActivityStack$registerLogoutFinishHook$1", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "onLogin", "", "userId", "", "onLogout", "lastUserId", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.memorydata.middleware.api.app.d {
        c() {
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "userId");
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void b(String r1) {
            Intrinsics.checkNotNullParameter(r1, "lastUserId");
            a.a(a.f13146a);
        }
    }

    static {
        f13146a = new a();
        f13147b = new CopyOnWriteArrayList();
        c = new Handler(Looper.getMainLooper());
        e = 1;
        f = new C0718a();
        g = $$Lambda$a$DeN81iITtSw1CSm21zbIpz7kJs4.INSTANCE;
    }

    private a() {
    }

    private final String a(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, MemoryListActivity.class) == false) goto L6;
        return "open_global_mem_page";
    L6:
        if (ZeusTransformUtils.instanceOf(r1, AutoMemoryActivity.class) == false) goto L9;
        return "open_auto_mem_pro";
    L9:
        if (ZeusTransformUtils.instanceOf(r1, MemoryDetailActivity.class) == false) goto L12;
        return "open_mem_detail";
    L12:
        if (ZeusTransformUtils.instanceOf(r1, ScreenObservationGuideFeatureActivity.class) == false) goto L15;
        return "open_screen_mem_onboarding";
    L15:
        if (ZeusTransformUtils.instanceOf(r1, SmartMemorySettingsActivity.class) == false) goto L18;
        return "open_auto_mem_settings_page";
    L18:
        if (ZeusTransformUtils.instanceOf(r1, MemorySettingsActivity.class) == false) goto L21;
        return "open_global_mem_settings_page";
    L21:
        if (ZeusTransformUtils.instanceOf(r1, ScreenObservationSettingsActivity.class) == false) goto L23;
        return "open_screen_mem_settings_page";
    L23:
        return "";
    }

    private final void a() {
        UserSettings.INSTANCE.registerEnterpriseAccountListener((com.obric.memorydata.middleware.api.app.b) ZeusTransformUtils.preCheckCast(new b(), com.obric.memorydata.middleware.api.app.b.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(a r0) {
        r0.c();
    }

    private final void b() {
        UserSettings.INSTANCE.registerLoginStateListener((com.obric.memorydata.middleware.api.app.d) ZeusTransformUtils.preCheckCast(new c(), com.obric.memorydata.middleware.api.app.d.class, "com.obric.memorydata.plugin"));
    }

    private final void c() {
        j.a($$Lambda$a$pBlQlEhTwA6R9ciQ20svv2wFP4.INSTANCE);
    }

    private final void d() {
        com.obric.aiagent.flow.applog.a r0 = com.obric.aiagent.flow.applog.a.f5912a;
        Context r8 = d;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        r8 = null;
    L5:
        com.obric.aiagent.flow.applog.a.a(r0, r8, (com.obric.aiagent.flow.applog.b) ZeusTransformUtils.preCheckCast(f, com.obric.aiagent.flow.applog.b.class, "com.obric.memorydata.plugin"), e, 0, 8, null);
    }

    private final void e() {
        Handler r3 = c;
        Runnable r0 = g;
        r3.removeCallbacks(r0);
        r3.postDelayed(r0, 60000);
    }

    private final void f() {
        c.removeCallbacks(g);
    }

    private static final void g() {
        if (f13147b.isEmpty() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ActivityStack", "disconnect FlowAppLog after all activities stopped for 60s", false, 4, null);
        com.obric.aiagent.flow.applog.a.f5912a.a();
        return;
    }

    private static final Unit h() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ActivityStack", "clearMemoryAppTasksOnMain start", false, 4, null);
        com.obric.memorydata.memory.utils.e.f11535a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void lambda$DeN81iITtSw1CSm21zbIpz7kJs4() {
        g();
    }

    /* JADX INFO: renamed from: lambda$pBlQlEhTwA6-R9ciQ20svv2wFP4, reason: not valid java name */
    public static /* synthetic */ Unit m1241lambda$pBlQlEhTwA6R9ciQ20svv2wFP4() {
        return h();
    }

    public final void a(Application r4, int r5) {
        Application r6 = (Application) ZeusTransformUtils.wrapperContextForParams(r4, Application.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "application");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "getApplicationContext(...)");
        d = r0;
        e = r5;
        r6.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) ZeusTransformUtils.preCheckCast(this, Application.ActivityLifecycleCallbacks.class, "com.obric.memorydata.plugin"));
        MemoryPluginActiveProviderRegistry.getInstance().addProvider((MemoryPluginActiveProvider) ZeusTransformUtils.preCheckCast(this, MemoryPluginActiveProvider.class, "com.obric.memorydata.plugin"));
        a();
        b();
    }

    public boolean isActive() {
        return !((Collection) ZeusTransformUtils.preCheckCast(f13147b, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
    }

    @Override // com.obric.memorydata.utils.s, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r7) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r7, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "activity");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ActivityStack", "onpause, activity is " + r6, false, 4, null);
        com.obric.aiagent.platform.a.d.f5954a.b("ActivityStack", "PluginApplication onActivityPaused: " + r6.getClass().getName());
        com.obric.aiagent.flow.applog.a.f5912a.b();
    }

    @Override // com.obric.memorydata.utils.s, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "activity");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ActivityStack", "onresume, activity is " + r9, false, 4, null);
        f();
        d();
        if (f13147b.size() != 1) goto L7;
        com.obric.aiagent.platform.a.d.f5954a.b("ActivityStack", "PluginApplication setLaunchService: " + a(r9));
        if (Intrinsics.areEqual(a(r9), "") == true) goto L7;
        com.obric.aiagent.flow.applog.a.f5912a.b(a(r9));
    L7:
        com.obric.aiagent.flow.applog.a r7 = com.obric.aiagent.flow.applog.a.f5912a;
        String r0 = r9.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(r0, "getName(...)");
        r7.a(r0, r9.hashCode());
    }

    @Override // com.obric.memorydata.utils.s, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "activity");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ActivityStack", "onstart, activity is " + r9, false, 4, null);
        f();
        CopyOnWriteArrayList<Activity> r7 = f13147b;
        r7.remove(r9);
        r7.add(r9);
        MemoryPluginActiveProviderRegistry.getInstance().onActiveChange();
    }

    @Override // com.obric.memorydata.utils.s, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r10) {
        Activity r11 = (Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "activity");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ActivityStack", "onstop, activity is " + r11, false, 4, null);
        CopyOnWriteArrayList<Activity> r0 = f13147b;
        if (r0.remove(r11) == true) goto L5;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ActivityStack", "onstop, activity is " + r11 + ", but not found in stack", null, 4, null);
    L5:
        MemoryPluginActiveProviderRegistry.getInstance().onActiveChange();
        com.obric.aiagent.flow.applog.a.f5912a.c();
        if (r0.isEmpty() == false) goto L9;
        com.obric.aiagent.platform.a.d.f5954a.b("ActivityStack", "PluginApplication clearLaunchService");
        com.obric.aiagent.flow.applog.a.f5912a.d();
        e();
        return;
    }
}
