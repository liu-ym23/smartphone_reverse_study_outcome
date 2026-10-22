package com.obric.assistant.interaction.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import com.bytedance.ai.api.AppletExtService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.home.api.main.HomeService;
import com.larus.home.api.main.HomeServiceV2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aiagent.assistant.idl.IPlatformApiIDL;
import com.obric.aiagent.assistant.idl.l4;
import com.obric.aiagent.ipc.utils.g;
import com.obric.assistant.interaction.impl.window.helpers.ActivityManagerLancet;
import com.obric.assistant.spi.app.IObricLaunchService;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.utils.e;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004*\u0001\u001b\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/interaction/impl/AppLaunchServiceImpl;", "Lcom/obric/assistant/spi/app/IObricLaunchService;", "<init>", "()V", "initialized", "", "init", "", "resumeOrLaunchNewTask", "doNotResumeWindow", "resumeAssistantTask", "targetActivityName", "", "ignoreWindow", "getAppTaskIds", "", "", "resumeRecentTask", "startLauncherIntent", "getLaunchBridgeIntent", "Landroid/content/Intent;", "getLaunchBridgeActivityName", "getBackgroundAppPkgName", "getPushClickIntent", "launchMainActivity", "monitorUpdateWakeupPkg", "activityLifeCycleCallback", "com/obric/assistant/interaction/impl/AppLaunchServiceImpl$activityLifeCycleCallback$1", "Lcom/obric/assistant/interaction/impl/AppLaunchServiceImpl$activityLifeCycleCallback$1;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppLaunchServiceImpl implements IObricLaunchService {
    public static final Companion Companion = null;
    private static final String KEY_OPEN_METHOD = "open_method";
    private static final Set<String> LAUNCHER_LONG_PRESS_OPEN_METHODS = null;
    private static final String TAG = "AppLaunchServiceImpl";
    private final activityLifeCycleCallback.1 activityLifeCycleCallback;
    private volatile boolean initialized;

    static {
        Companion = new Companion(null);
        LAUNCHER_LONG_PRESS_OPEN_METHODS = SetsKt.setOf(new String[]{"long_press_icon_camera", "long_press_icon_scan", "long_press_icon_call"});
    }

    private final void launchMainActivity() {
        Intent r0 = new Intent();
        AppHost.Companion r2 = AppHost.a;
        r0.setComponent(new ComponentName(r2.getApplication(), HomeServiceV2.a.a()));
        r0.setFlags(335577088);
        r2.getApplication().startActivity(r0);
        FLogger.a.i(TAG, "launch main activity");
    }

    private final void monitorUpdateWakeupPkg() {
        AppHost.a.getApplication().registerActivityLifecycleCallbacks(this.activityLifeCycleCallback);
    }

    public String getBackgroundAppPkgName() {
        Object r0 = "";
        String r1 = AppHost.a.getApplication().getPackageName();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L18
        KClass r3 = Reflection.getOrCreateKotlinClass(IPlatformApiIDL.class);     // Catch: Throwable -> L18
        int r4 = l4.a;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r3, "<this>");     // Catch: Throwable -> L18
        g.a.getClass();     // Catch: Throwable -> L18
        IPlatformApiIDL r5 = g.b(IPlatformApiIDL.class);     // Catch: Throwable -> L18
        Object r6 = null;
        if (r5 == null) goto L14;
        List r7 = r5.getTasksPackages(3, true, false, 0);     // Catch: Throwable -> L18
        if (r7 == null) goto L14;
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L18
    L9:
        if (r8.hasNext() == false) goto L13;
        Object r9 = r8.next();     // Catch: Throwable -> L18
        if ((!Intrinsics.areEqual((String) r9, r1)) == false) goto L9;
        r6 = r9;
    L13:
        r6 = (String) r6;     // Catch: Throwable -> L18
    L14:
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        Object r10 = Result.constructor-impl(r6);     // Catch: Throwable -> L18
    L20:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L24;
        FLogger.a.w(TAG, "getBackgroundAppPkgName failed: " + r11.getMessage(), r11);
    L24:
        if (Result.isFailure-impl(r10) == true) goto L28;
        r0 = r10;
    L28:
        return (String) r0;
    L18:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public String getLaunchBridgeActivityName() {
        return "LaunchBridgeActivity";
    }

    public Intent getLaunchBridgeIntent() {
        return new Intent(AppHost.a.getApplication(), LaunchBridgeActivity.class);
    }

    public Intent getPushClickIntent() {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(AppHost.a.getApplication(), HomeServiceV2.a.a()));
        r0.setFlags(268468224);
        return r0;
    }

    public void init() {
        if (this.initialized == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.initialized == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        this.initialized = true;     // Catch: Throwable -> L15
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
        FLogger.a.d(TAG, "init");
        monitorUpdateWakeupPkg();
    }

    public void startLauncherIntent() {
        HomeService r0 = HomeService.a;
        AppHost.Companion r1 = AppHost.a;
        String r2 = r0.A(r1.getApplication());
        FLogger r3 = FLogger.a;
        r3.i(TAG, "enabledActivity = " + r2);
        Activity r4 = r1.a().getCurrentActivity();
        String r5 = null;
        if (r4 == null) goto L5;
        String r6 = r4.getClass().getName();
    L7:
        if (Intrinsics.areEqual(r6, HomeServiceV2.a.a()) == false) goto L16;
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r7 = ISecPrivacyService.a.a();
        if (r7 == null) goto L13;
        boolean r8 = true;
        if (r7.h() != true) goto L13;
    L14:
        if (r8 == true) goto L16;
        return;
    L13:
        r8 = false;
    L16:
        Intent r9 = r1.getApplication().getPackageManager().getLaunchIntentForPackage(r1.getApplication().getPackageName());
        StringBuilder r10 = new StringBuilder("launcher activity = ");
        if (r9 == null) goto L21;
        ComponentName r11 = r9.getComponent();
        if (r11 == null) goto L21;
        String r12 = r11.getClassName();
    L22:
        r10.append(r12);
        r3.i(TAG, r10.toString());
        if (r9 == null) goto L31;
        if (r2 == null) goto L31;
        ComponentName r13 = r9.getComponent();
        if (r13 == null) goto L29;
        r5 = r13.getClassName();
    L29:
        if (Intrinsics.areEqual(r5, r2) == false) goto L31;
        r3.i(TAG, "launch normally");
        r9.addFlags(268435456);
        r1.getApplication().startActivity(r9);
        return;
    L31:
        launchMainActivity();
        return;
    L21:
        r12 = null;
        goto L22
    L5:
        r6 = null;
        goto L7
    }

    public AppLaunchServiceImpl() {
        this.activityLifeCycleCallback = new activityLifeCycleCallback.1(this);
    }

    public static final /* synthetic */ Set access$getLAUNCHER_LONG_PRESS_OPEN_METHODS$cp() {
        return LAUNCHER_LONG_PRESS_OPEN_METHODS;
    }

    private final List<Integer> getAppTaskIds(boolean r7) {
        List r0 = AppHost.a.a().g();
        if (r0.isEmpty() == true) goto L5;
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator r2 = CollectionsKt.reversed(r0).iterator();
    L8:
        if (r2.hasNext() == false) goto L25;
        Activity r3 = (Activity) r2.next();
        if (r3.isFinishing() == true) goto L8;
        if (r3.isDestroyed() == true) goto L8;
        if (Intrinsics.areEqual(r3.getClass().getSimpleName(), KeyguardService.a.getHelperActivityName()) == true) goto L8;
        if (r7 == false) goto L22;
        int r4 = e.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.getTaskId() != 0) goto L19;
        boolean r5 = true;
    L20:
        if (r5 == true) goto L8;
    L19:
        r5 = false;
    L22:
        if (Intrinsics.areEqual(r3.getClass().getSimpleName(), getLaunchBridgeActivityName()) == true) goto L8;
        FLogger.a.i(TAG, "getAppTaskIds() activity:" + r3 + " add taskId: " + r3.getTaskId());
        r1.add(Integer.valueOf(r3.getTaskId()));
        goto L8
    L25:
        return CollectionsKt.toList(r1);
    L5:
        return CollectionsKt.emptyList();
    }

    private final boolean resumeRecentTask(boolean r7) {
        List<Integer> r8 = getAppTaskIds(r7);
        FLogger r0 = FLogger.a;
        r0.i(TAG, "resumeRecentTask() getTaskIds: " + r8);
        if ((!r8.isEmpty()) == false) goto L6;
        Object r1 = AppHost.a.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.ActivityManager");
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_AppLaunchServiceImpl_com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet_moveTaskToFront((ActivityManager) r1, ((Number) ListProtector.get(r8, 0)).intValue(), 0);
        r0.i(TAG, "resumeAssistantTask resume recent task success, taskId = " + ((Number) ListProtector.get(r8, 0)).intValue());
        return true;
    L6:
        return false;
    }

    public void resumeOrLaunchNewTask(boolean r2) {
        if (resumeAssistantTask(null, r2) == true) goto L6;
        startLauncherIntent();
        return;
    }

    public boolean resumeAssistantTask(String r10, boolean r11) {
        Iterator r0 = CollectionsKt.reversed(AppHost.a.a().g()).iterator();
        boolean r2 = false;
    L4:
        if (r0.hasNext() == false) goto L35;
        Activity r3 = (Activity) r0.next();
        if (r2 == true) goto L34;
        if (r3.isFinishing() == true) goto L34;
        if (r3.isDestroyed() == true) goto L34;
        if (Intrinsics.areEqual(r3.getClass().getSimpleName(), KeyguardService.a.getHelperActivityName()) == true) goto L34;
        if (r11 == false) goto L21;
        int r7 = e.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.getTaskId() != 0) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == true) goto L34;
    L18:
        r8 = false;
    L21:
        if (Intrinsics.areEqual(r3.getClass().getSimpleName(), getLaunchBridgeActivityName()) == true) goto L34;
        if (r3.isTaskRoot() == false) goto L25;
    L28:
        AppletExtService r9 = (AppletExtService) ServiceManager.get().getService(AppletExtService.class);
        if (r9 == null) goto L31;
        boolean r12 = r9.o(r3);
    L32:
        if (r12 == true) goto L34;
        Object r4 = AppHost.a.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.ActivityManager");
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_AppLaunchServiceImpl_com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet_moveTaskToFront((ActivityManager) r4, r3.getTaskId(), 0);
        FLogger.a.i(TAG, "resumeAssistantTask success, taskId = " + r3.getTaskId() + ", activity = " + r3 + ", className:" + r3.getClass().getName() + " targetActivityName: " + r10);
        r2 = true;
        goto L4
    L31:
        r12 = false;
        goto L32
    L25:
        if (o0.d(r10) == false) goto L34;
        if (Intrinsics.areEqual(r3.getClass().getName(), r10) == true) goto L28;
    L34:
        FLogger.a.i(TAG, "no need to resume assistant taskId = " + r3.getTaskId() + ", activity = " + r3 + ", isFinishing = " + r3.isFinishing() + ", isDestroyed = " + r3.isDestroyed() + ", isTaskRoot = " + r3.isTaskRoot() + ", targetActivityName: " + r10);
        goto L4
    L35:
        if (r2 == true) goto L37;
        r2 = resumeRecentTask(r11);
    L37:
        if (r2 == true) goto L39;
        FLogger.a.i(TAG, "resumeAssistantTask failed");
    L39:
        return r2;
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_AppLaunchServiceImpl_com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet_moveTaskToFront(ActivityManager r0, int r1, int r2) {
        if (r1 == 0) goto L5;
        r0.moveTaskToFront(r1, r2);
        return;
    L5:
        ActivityManagerLancet.handleFakeMoveTaskToFront(r2);
    }
}
