package com.obric.assistant.interaction.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ai.api.AppletExtService;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.home.impl.utils.c;
import com.larus.im.FlowRuntime;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.utils.u0;
import com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL;
import com.obric.aiagent.assistant.idl.u;
import com.obric.aiagent.product.platform.api.app.ObricActivityManager;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager;
import com.obric.assistant.activation.presentation.runtime.manager.h1;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.common.utils.p;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.WindowLayoutInfo;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimationListener;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimationProvider;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import com.obric.assistant.interaction.impl.performance.WindowAnimationBoostCoordinator;
import com.obric.assistant.interaction.impl.window.WindowAppErrorReporter;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.interaction.impl.window.WindowModeDecider;
import com.obric.assistant.interaction.impl.window.behaviors.LockedTopChatActivityCleaner;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.interaction.impl.window.helpers.ActivityManagerLancet;
import com.obric.assistant.interaction.impl.window.helpers.OverlayPermissionGuideActivity;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.performance.WindowColdOpenPreloadCoordinator;
import com.obric.assistant.oauto.IOAutoApi;
import com.obric.assistant.oauto.b;
import com.obric.assistant.spi.chat.ObricInteractionServiceDelegate;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import com.obric.assistant.storage.ObricLowStorageServiceDelegate;
import com.obric.assistant.t1;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import maa.e;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 h2\u00020\u0001:\u0001hB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016Js\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u0019Ju\u0010\u001a\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0003¢\u0006\u0002\u0010\u001cJ<\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00132\u0006\u0010\"\u001a\u00020\bH\u0002J\u001c\u0010#\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J[\u0010$\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\bH\u0016J\u0014\u0010'\u001a\u00020\u00052\n\u0010(\u001a\u00060)j\u0002`*H\u0002J \u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0002J*\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u0005H\u0002J\n\u00104\u001a\u0004\u0018\u000105H\u0002J\b\u00106\u001a\u00020\bH\u0016J\u0010\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020\u00052\u0006\u00108\u001a\u000209H\u0016J\b\u0010;\u001a\u00020\bH\u0016J\b\u0010<\u001a\u00020\bH\u0016J\u0015\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u000205H\u0016¢\u0006\u0002\u0010?J\b\u0010@\u001a\u00020\bH\u0016J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020CH\u0016J\n\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010F\u001a\u00020\bH\u0016J\u0018\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u0016H\u0016J\u0018\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u00162\u0006\u0010L\u001a\u00020\u000bH\u0016J\u0018\u0010M\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\b2\u0006\u0010L\u001a\u00020\u000bH\u0016J \u0010O\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u00162\u0006\u0010P\u001a\u00020\b2\u0006\u0010L\u001a\u00020\u000bH\u0016J\b\u0010Q\u001a\u00020\u0005H\u0016J\b\u0010R\u001a\u00020\bH\u0016J\u0012\u0010S\u001a\u00020\u00052\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u0010\u0010V\u001a\u00020\u00052\u0006\u0010W\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u00020\u00052\u0006\u0010W\u001a\u00020XH\u0016J\u0010\u0010Z\u001a\u00020\u00052\u0006\u0010W\u001a\u00020[H\u0016J\u0010\u0010\\\u001a\u00020\u00052\u0006\u0010W\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020_H\u0016J\u0010\u0010`\u001a\u00020\u00052\u0006\u0010^\u001a\u00020_H\u0016J\b\u0010a\u001a\u00020\u0005H\u0016J\b\u0010b\u001a\u00020\u0005H\u0016J\n\u0010c\u001a\u0004\u0018\u00010/H\u0016J\u000e\u0010d\u001a\u0004\u0018\u00010/*\u00020eH\u0002J\u0012\u0010d\u001a\u0004\u0018\u00010/2\u0006\u0010f\u001a\u00020gH\u0002¨\u0006i"}, d2 = {"Lcom/obric/assistant/interaction/impl/AssistantChatWindowImpl;", "Lcom/obric/assistant/interaction/api/IAssistantChatWindow;", "<init>", "()V", "createChatWindow", "", "preloadWindow", "isPreloaded", "", "openChatWindow", "assistantRequestFrom", "", "wakeUp", "isMicInUse", DBDefinition.EXTRA, "Landroid/os/Bundle;", "checkScreenLock", "interruptMovingBackground", "args", "", "", "vuiId", "", "forceUseDefaultDisplay", "forceOpenActivity", "(Ljava/lang/String;ZLjava/lang/Boolean;Landroid/os/Bundle;ZZLjava/util/Map;Ljava/lang/Integer;ZZ)V", "startChatWindow", "startupAttemptId", "(Ljava/lang/String;ZLjava/lang/Boolean;Landroid/os/Bundle;ZLjava/util/Map;Ljava/lang/Integer;ZZLjava/lang/String;)V", "updateStartupRouteIfRequired", "attemptId", "routeMilestone", "target", "attributes", "updateFirstFrameTarget", "commitStartupRoute", "buildLaunchParams", "(Ljava/lang/String;ZLjava/lang/Boolean;Landroid/os/Bundle;Ljava/util/Map;Ljava/lang/Integer;Z)Landroid/os/Bundle;", "isWindowFeatureEnabled", "recoverMainChatAfterWindowFailure", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "startSideBarActivity", "params", "startChatActivity", "provideWindowVContext", "Lcom/larus/ui/arch/context/external/VContext;", "exitVirtualDisplay", "delayMS", "", "clearTask", "currentActivity", "Landroid/app/Activity;", "isShowing", "stash", "animation", "Lcom/obric/assistant/interaction/api/window/animation/WindowAnimationType;", "pop", "isStashed", "isWindowMode", "isMainBotActivity", "activity", "(Landroid/app/Activity;)Ljava/lang/Boolean;", "hasTopChatActivityMatchingSystemTop", "updateBackgroundDimAmount", "alpha", "", "getWindowLayoutInfo", "Lcom/obric/assistant/interaction/api/WindowLayoutInfo;", "isWindowAnimationRunning", "applyWindowAnimationBoost", "source", "durationMs", "updateWindowAnimationY", "y", "reason", "updateWindowAnimationNoLimitsEnabled", "enabled", "updateWindowAnimationLayout", "noLimitsEnabled", "dismissWindow", "isNewGlobalPanelBlockedByPermission", "setSessionToken", "token", "Landroid/os/IBinder;", "addWindowLifecycleListener", "listener", "Lcom/obric/assistant/spi/window/WindowLifecycleListener;", "removeWindowLifecycleListener", "addWindowAnimationListener", "Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimationListener;", "removeWindowAnimationListener", "addWindowAnimationCreator", "creator", "Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimationProvider;", "removeWindowAnimationCreator", "dismissAllChildDialogs", "onWakeupBlockedBySystemAlertWindowPermission", "getCurrentVContext", "getVContext", "Landroidx/fragment/app/FragmentActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantChatWindowImpl implements IAssistantChatWindow {
    public static final Companion Companion = null;
    private static final String TAG = "AssistantChatWindowImpl";
    private static final String TRACE_START_CHAT_WINDOW = "AssistantChatWindowImpl.startChatWindow";

    static {
        Companion = new Companion(null);
    }

    public AssistantChatWindowImpl() {
    }

    public static /* synthetic */ void a(String r0, AssistantChatWindowImpl r1, boolean r2, Map r3, String r4, boolean r5, Boolean r6, Bundle r7, boolean r8, Integer r9, boolean r10) {
        startChatWindow$lambda$11(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit b(String r0) {
        return openChatWindow$lambda$4(r0);
    }

    public static /* synthetic */ Unit c(AssistantChatWindowImpl r0, String r1, boolean r2, Boolean r3, Bundle r4, boolean r5, Map r6, Integer r7, boolean r8, boolean r9, String r10) {
        return openChatWindow$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ void d(Exception r0) {
        startChatWindow$lambda$11$lambda$10$lambda$9(r0);
    }

    public void dismissAllChildDialogs() {
        PopupOrDialogVisibilityTracker.dismissAllTrackedDialogs$default(null, false, 3, null);
        PopupOrDialogVisibilityTracker.dismissAllTrackedPopupWindows$default(null, false, 3, null);
    }

    private final void clearTask() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 29) goto L26;
        AppHost.Companion r1 = AppHost.a;
        Object r2 = r1.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.ActivityManager");
        PackageManager r3 = r1.getApplication().getPackageManager();
        List<ActivityManager.AppTask> r4 = ((ActivityManager) r2).getAppTasks();
        if (r4 == null) goto L40;
        Iterator<T> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L41;
        ActivityManager.AppTask r6 = (ActivityManager.AppTask) r5.next();
        String r7 = null;
        if (r6 == null) goto L12;
        ActivityManager.RecentTaskInfo r8 = r6.getTaskInfo();
    L13:
        if (r8 == null) goto L14;
        ComponentName r9 = r8.baseActivity;
        if (r9 == null) goto L8;
        ActivityInfo r10 = r3.getActivityInfo(r9, 0);
        if (r10 == null) goto L21;
        r7 = r10.taskAffinity;
    L21:
        FLogger r11 = FLogger.a;
        r11.i(TAG, "clearTask: " + r9 + ".taskAffinity=" + r7);
        if (Intrinsics.areEqual(r7, AppHost.a.getApplication().getPackageName()) == false) goto L8;
        r11.i(TAG, "clearTask: remove task " + r8.taskId + ", baseActivity = " + r9);
        if (r6 == null) goto L8;
        r6.finishAndRemoveTask();
        goto L8
    L14:
        FLogger.a.w(TAG, "clearTask: taskInfo is null");
        goto L8
    L12:
        r8 = null;
        goto L13
    L41:
        return;
    L40:
        return;
    L26:
        FLogger.a.i(TAG, "clearTask: api level is to low: " + r0);
    }

    private final Activity currentActivity() {
        Object r0 = AppHost.a.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.AppTask> r1 = ((ActivityManager) r0).getAppTasks();
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(Integer.valueOf(((ActivityManager.AppTask) r3.next()).getTaskInfo().taskId));
        goto L4
    L6:
        List r4 = AppHost.a.a().g();
        ListIterator r5 = r4.listIterator(r4.size());
    L8:
        if (r5.hasPrevious() == false) goto L19;
        Object r6 = r5.previous();
        LifecycleOwner r7 = (Activity) r6;
        if ((r7 instanceof LifecycleOwner) == true) goto L12;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == false) goto L8;
    L21:
        return (Activity) r6;
    L12:
        if (r7.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L16;
        if (r2.contains(Integer.valueOf(r7.getTaskId())) == false) goto L16;
        r8 = true;
        goto L17
    L19:
        r6 = null;
        goto L21
    }

    public void createChatWindow() {
        boolean r0 = WindowHost.INSTANCE.isWindowMode();
        FLogger.a.i(TAG, "createChatWindow, shouldUseWindowMode=" + r0);
        if (r0 == false) goto L6;
        WindowColdOpenPreloadCoordinator.preloadForColdOpen$default(WindowColdOpenPreloadCoordinator.INSTANCE, "createChatWindow", null, 2, null);
        return;
    }

    public void dismissWindow() {
        FLogger.a.i(TAG, "dismissWindow");
        WindowHost.INSTANCE.dismiss();
    }

    public WindowLayoutInfo getWindowLayoutInfo() {
        return WindowHost.INSTANCE.getWindowLayoutInfo();
    }

    public boolean hasTopChatActivityMatchingSystemTop() {
        return LockedTopChatActivityCleaner.INSTANCE.hasTopChatActivityMatchingSystemTop("AssistantChatWindowImpl#hasTopChatActivityMatchingSystemTop");
    }

    public void interruptMovingBackground() {
        AppHost.Companion r0 = AppHost.a;
        if (r0.a().isAppBackground() == false) goto L6;
        FLogger.a.i(TAG, "interruptMovingBackground: app is in background, no need to interrupt");
        return;
    L6:
        LifecycleOwner r1 = currentActivity();
        if (r1 != null) goto L11;
        FLogger.a.i(TAG, "interruptMovingBackground: no current activity");
        return;
    L11:
        if ((r1 instanceof LifecycleOwner) == true) goto L13;
    L16:
        IOAutoApi r3 = b.a();
        boolean r4 = true;
        if (r3 != null) goto L19;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == false) goto L26;
        FLogger.a.i(TAG, "interruptMovingBackground: assistant is in oauto, no need to interrupt");
        return;
    L26:
        if (INVOKEVIRTUAL_com_obric_assistant_interaction_impl_AssistantChatWindowImpl_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(r1) == false) goto L29;
        FLogger.a.i(TAG, "interruptMovingBackground: has window focus, no need to interrupt");
        return;
    L29:
        AppletExtService r6 = (AppletExtService) ServiceManager.get().getService(AppletExtService.class);
        if (r6 != null) goto L32;
    L34:
        r4 = false;
    L35:
        if (r4 == false) goto L38;
        FLogger.a.i(TAG, "interruptMovingBackground: current activity is mini app");
        return;
    L38:
        FLogger.a.i(TAG, "interruptMovingBackground: move task to front: " + r1.getTaskId() + ", currentActivity = " + r1 + ", isFinishing = " + r1.isFinishing());
        Object r2 = r0.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.ActivityManager");
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_AssistantChatWindowImpl_com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet_moveTaskToFront((ActivityManager) r2, r1.getTaskId(), 0);
        return;
    L32:
        if (r6.o(r1) != true) goto L34;
    L19:
        if (r3.b() != true) goto L21;
        r5 = true;
        goto L22
    L13:
        if (r1.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L16;
        FLogger.a.i(TAG, "interruptMovingBackground: current activity is not resumed, no need to interrupt");
    }

    public boolean isNewGlobalPanelBlockedByPermission() {
        return WindowModeDecider.INSTANCE.isNewGlobalPanelBlockedByPermission();
    }

    public boolean isPreloaded() {
        return WindowHost.INSTANCE.isPreloaded();
    }

    public boolean isShowing() {
        return WindowHost.INSTANCE.isShowing();
    }

    public boolean isStashed() {
        return WindowHost.INSTANCE.isStashed();
    }

    public boolean isWindowAnimationRunning() {
        return WindowHost.INSTANCE.isWindowAnimationRunning();
    }

    public boolean isWindowFeatureEnabled() {
        return WindowModeDecider.INSTANCE.isWindowFeatureEnabled();
    }

    public boolean isWindowMode() {
        return WindowHost.INSTANCE.isWindowMode();
    }

    public void onWakeupBlockedBySystemAlertWindowPermission() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        AppHost.Companion r1 = AppHost.a;     // Catch: Throwable -> L4
        Intent r2 = new Intent(r1.getApplication(), OverlayPermissionGuideActivity.class);     // Catch: Throwable -> L4
        r2.addFlags(268435456);     // Catch: Throwable -> L4
        r2.addFlags(134217728);     // Catch: Throwable -> L4
        r2.putExtra("obric_allow_show_when_locked", true);     // Catch: Throwable -> L4
        r1.getApplication().startActivity(r2);     // Catch: Throwable -> L4
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L12;
        FLogger.a.e(TAG, "onWakeupBlockedBySystemAlertWindowPermission: start activity failed", r4);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public void preloadWindow() {
        WindowHost r0 = WindowHost.INSTANCE;
        boolean r1 = r0.isWindowMode();
        FLogger r2 = FLogger.a;
        r2.i(TAG, "preloadWindow, shouldUseWindowMode=" + r1 + ", isShowing=" + r0.isShowing() + ", isStashed=" + r0.isStashed() + ", isPreloaded=" + r0.isPreloaded());
        if (r1 == true) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    L12:
        r2.i(TAG, "preloadWindow skipped, window already showing, stashed or preloaded");
        return;
    L7:
        if (r0.isStashed() == true) goto L12;
        if (r0.isPreloaded() == true) goto L12;
        Bundle r9 = new Bundle();
        r9.putBoolean("arg_long_press_ai", false);
        Unit r3 = Unit.INSTANCE;
        r0.preload(IAssistantChatWindow.DefaultImpls.buildLaunchParams$default(this, null, false, null, r9, null, null, false, 119, null));
    }

    public t1a.b provideWindowVContext() {
        return WindowHost.INSTANCE.provideWindowVContext();
    }

    public t1a.b getCurrentVContext() {
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L20;
        IAssistantChatWindow r3 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r3 != null) goto L13;
    L15:
        r1 = false;
    L16:
        if (r1 == false) goto L20;
        IAssistantChatWindow r4 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r4 != null) goto L28;
        return null;
    L28:
        return r4.provideWindowVContext();
    L13:
        if (r3.isShowing() != true) goto L15;
    L20:
        Activity r5 = AppHost.a.a().getCurrentActivity();
        if ((r5 instanceof FragmentActivity) == false) goto L23;
        FragmentActivity r6 = (FragmentActivity) r5;
    L24:
        if (r6 != null) goto L26;
        return null;
    L26:
        return getVContext(r6);
    L23:
        r6 = null;
        goto L24
    L5:
        if (r0.isWindowMode() != true) goto L7;
        r2 = true;
        goto L9
    }

    public static boolean INVOKEVIRTUAL_com_obric_assistant_interaction_impl_AssistantChatWindowImpl_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(Activity r3) {
        boolean r4 = r3.hasWindowFocus();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "hasWindowFocus");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "hasWindowFocus");
    L7:
        return r4;
    }

    private final t1a.b getVContext(Fragment r6) {
        if (r6.isAdded() == true) goto L5;
    L39:
        return null;
    L5:
        if (r6.isVisible() == false) goto L39;
        t1a.b r7 = a.g(r6);
        if (r7.getAbility(e.class) != null) goto L10;
        return null;
    L10:
        va8.o r0 = r7.getAbility(va8.o.class);
        if (r0 == null) goto L15;
        com.larus.bmhome.chat.component.bottom.core.a r1 = r0.Uv();
        if (r1 == null) goto L15;
        View r2 = r1.r();
    L16:
        boolean r3 = false;
        if (r2 != null) goto L19;
    L24:
        boolean r4 = false;
    L25:
        if (r4 == false) goto L39;
        ViewParent r5 = r2.getParent();
        if ((r5 instanceof ViewGroup) == false) goto L29;
        ViewGroup r8 = (ViewGroup) r5;
    L30:
        if (r8 != null) goto L32;
    L37:
        if (r3 == false) goto L39;
        return r7;
    L32:
        if (r8.getVisibility() != 0) goto L34;
        boolean r9 = true;
    L35:
        if (r9 != true) goto L37;
        r3 = true;
        goto L37
    L34:
        r9 = false;
        goto L35
    L29:
        r8 = null;
        goto L30
    L19:
        if (r2.getVisibility() != 0) goto L21;
        boolean r10 = true;
    L22:
        if (r10 != true) goto L24;
        r4 = true;
        goto L25
    L21:
        r10 = false;
    L15:
        r2 = null;
        goto L16
    }

    private static final Unit openChatWindow$lambda$4(String r9) {
        FLogger.a.i(TAG, "requestDismissKeyguard onFailed");
        if (r9 == null) goto L6;
        IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.a, r9, "blocked", "dismiss_keyguard_failed", null, 24);
    L6:
        return Unit.INSTANCE;
    }

    private final void recoverMainChatAfterWindowFailure(Exception r11) {
        FLogger r0 = FLogger.a;
        r0.e(TAG, "open Window failed, request idle main chat recovery", r11);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
        i r13 = SmartRouter.buildRoute(AppHost.a.getApplication(), "//flow/chat_page");     // Catch: Throwable -> L5
        r13.c.putExtra("argBotConversationType", 1);     // Catch: Throwable -> L5
        r13.d();     // Catch: Throwable -> L5
        r0.i(TAG, "idle main chat recovery dispatched");     // Catch: Throwable -> L5
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.exceptionOrNull-impl(r14);
        if (r5 == null) goto L13;
        FLogger.a.e(TAG, "dispatch main chat recovery failed", r5);
        WindowAppErrorReporter.report$default(WindowAppErrorReporter.INSTANCE, "window_fallback_to_activity", r5, "dispatch_main_chat", null, 8, null);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public void addWindowAnimationCreator(IWindowAnimationProvider r2) {
        Intrinsics.checkNotNullParameter(r2, "creator");
        WindowHost.INSTANCE.addWindowAnimationCreator(r2);
    }

    public void addWindowAnimationListener(IWindowAnimationListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        WindowHost.INSTANCE.addWindowAnimationListener(r2);
    }

    public void addWindowLifecycleListener(wga.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        WindowHost.INSTANCE.addWindowLifecycleListener(r2);
    }

    public void exitVirtualDisplay(long r8) {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "exitVirtualDisplay: delayMS = " + r8);
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 29) goto L5;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new exitVirtualDisplay.1(r8, null), 3, null);
        return;
    L5:
        r0.w(TAG, "api level is to low: " + r1);
    }

    public Boolean isMainBotActivity(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        WindowUtils r0 = WindowUtils.INSTANCE;
        if ((r3 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r4 = (FragmentActivity) r3;
    L7:
        return Boolean.valueOf(r0.isMainBotActivity(r4));
    L5:
        r4 = null;
        goto L7
    }

    public void pop(WindowAnimationType r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        WindowHost.INSTANCE.pop(r2);
    }

    public void removeWindowAnimationCreator(IWindowAnimationProvider r2) {
        Intrinsics.checkNotNullParameter(r2, "creator");
        WindowHost.INSTANCE.removeWindowAnimationCreator(r2);
    }

    public void removeWindowAnimationListener(IWindowAnimationListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        WindowHost.INSTANCE.removeWindowAnimationListener(r2);
    }

    public void removeWindowLifecycleListener(wga.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        WindowHost.INSTANCE.removeWindowLifecycleListener(r2);
    }

    public void setSessionToken(IBinder r2) {
        WindowHost.INSTANCE.setSessionToken(r2);
    }

    public void stash(WindowAnimationType r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        WindowHost.INSTANCE.stash(r2);
    }

    public void updateBackgroundDimAmount(float r2) {
        WindowHost.INSTANCE.updateBackgroundDimAmount(r2);
    }

    private static final void startChatWindow$lambda$11$lambda$10$lambda$9(Exception r0) {
        throw r0;
    }

    private final t1a.b getVContext(FragmentActivity r3) {
        ObricChatContextServiceDelegate r0 = ObricChatContextServiceDelegate.b;
        if (r0.c(r3) == true) goto L34;
        Iterator r4 = r3.getSupportFragmentManager().getFragments().iterator();
    L7:
        if (r4.hasNext() == false) goto L22;
        Fragment r1 = (Fragment) r4.next();
        if (r1.isAdded() == false) goto L7;
        if (r1.isVisible() == false) goto L7;
        Intrinsics.checkNotNull(r1);
        t1a.b r2 = getVContext(r1);
        if (r2 != null) goto L15;
        Iterator r5 = r1.getChildFragmentManager().getFragments().iterator();
    L18:
        if (r5.hasNext() == false) goto L7;
        Fragment r6 = (Fragment) r5.next();
        Intrinsics.checkNotNull(r6);
        t1a.b r7 = getVContext(r6);
        if (r7 == null) goto L18;
        return r7;
    L15:
        return r2;
    L22:
        return null;
    L34:
        return r0.b(r3);
    }

    private final void commitStartupRoute(String r9, Bundle r10) {
        if (r9 == null) goto L21;
        boolean r1 = true;
        Long r2 = null;
        if ((!StringsKt.isBlank(r9)) == true) goto L7;
        r9 = null;
    L7:
        if (r9 != null) goto L10;
        return;
    L10:
        if (r10 == null) goto L19;
        Long r11 = Long.valueOf(r10.getLong("obric_wake_process_asr_ready_elapsed_ms", -1));
        if (r11.longValue() > 0) goto L15;
        r1 = false;
    L15:
        if (r1 == false) goto L17;
        r2 = r11;
    L17:
        if (r2 == null) goto L19;
        AssistantStartupTelemetry.a.d(r9, "route_ready", r2.longValue());
    L19:
        ObricListeningMainProcessManager.a.getClass();
        Intrinsics.checkNotNullParameter(r9, "attemptId");
        ObricListeningMainProcessManager.k(new h1(r9, false));
        return;
    }

    public void applyWindowAnimationBoost(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        WindowAnimationBoostCoordinator.INSTANCE.boost(r2, r3);
    }

    public void updateWindowAnimationNoLimitsEnabled(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        WindowHost.INSTANCE.updateWindowAnimationNoLimitsEnabled(r2, r3);
    }

    public void updateWindowAnimationY(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        WindowHost.INSTANCE.updateWindowAnimationY(r2, r3);
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_AssistantChatWindowImpl_com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet_moveTaskToFront(ActivityManager r0, int r1, int r2) {
        if (r1 == 0) goto L5;
        r0.moveTaskToFront(r1, r2);
        return;
    L5:
        ActivityManagerLancet.handleFakeMoveTaskToFront(r2);
    }

    private final void startSideBarActivity(Bundle r3, boolean r4, boolean r5) {
        if (r4 == false) goto L4;
        interruptMovingBackground();
    L4:
        FLogger.a.i(TAG, "startSideBarActivity: expand Window to sidebar, defaultDisplay=" + r5);
        i r6 = SmartRouter.buildRoute(new FullScreenChatRouteContext(AppHost.a.getApplication(), r5), "//main_page");
        r6.c.putExtras(r3);
        r6.c.addFlags(335577088);
        r6.d();
    }

    public void updateWindowAnimationLayout(int r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        WindowHost.INSTANCE.updateWindowAnimationLayout(r2, r3, r4);
    }

    private final void startChatActivity(Bundle r8, boolean r9, boolean r10, String r11) {
        if (r9 == false) goto L4;
        interruptMovingBackground();
    L4:
        clearTask();
        Intent r12 = new Intent();
        AppHost.Companion r1 = AppHost.a;
        r12.setComponent(new ComponentName(r1.getApplication(), HomeService.a.r()));
        r12.setFlags(335577088);
        r12.putExtras(r8);
        w9a.a.a.getClass();
        w9a.a.a.a().getClass();
        ObricActivityManager.a.b(r12);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L15
        if (r10 == false) goto L8;
        Application r14 = r1.getApplication();     // Catch: Throwable -> L15
        ActivityOptions r15 = ActivityOptions.makeBasic();     // Catch: Throwable -> L15
        r15.setLaunchDisplayId(0);     // Catch: Throwable -> L15
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r14.startActivity(r12, r15.toBundle());     // Catch: Throwable -> L15
    L9:
        IAgentVoiceInteractionIDL r16 = u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));     // Catch: Throwable -> L15
        if (r16 == null) goto L12;
        r16.onStartChatWindow(AssistantActivityExpandState.CHAT_WINDOW.ordinal());     // Catch: Throwable -> L15
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L15
    L17:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L25;
        FLogger.a.e(TAG, "startChatActivity failed", r19);
        if (r11 == null) goto L26;
        IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.a, r11, "dropped", "start_chat_activity_failed", MapsKt.mapOf(TuplesKt.to("error_type", r19.getClass().getSimpleName())), 8);
        return;
    L26:
        return;
    L25:
        return;
    L12:
        r17 = null;
        goto L13
    L8:
        r1.getApplication().startActivity(r12);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    private final void updateStartupRouteIfRequired(String r7, String r8, String r9, Map<String, String> r10, boolean r11) {
        AssistantStartupTelemetry r0 = AssistantStartupTelemetry.a;
        if (Intrinsics.areEqual(r0.i("first_frame_ready"), r7) == false) goto L8;
        if (r11 == false) goto L26;
        IAssistantStartupTelemetry.a.e(r0, r7, r9, null, r10, 10);
        return;
    L26:
        return;
    L8:
        if (Intrinsics.areEqual(r0.i("camera_content_ready"), r7) == false) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r0.i("rtc_call_content_ready"), r7) == true) goto L28;
        String r12 = "window_content_ready";
        if (Intrinsics.areEqual(r0.i("window_content_ready"), r7) == true) goto L19;
        r12 = "chat_content_ready";
        if (Intrinsics.areEqual(r0.i("chat_content_ready"), r7) == true) goto L19;
        r12 = null;
    L19:
        if (r12 != null) goto L22;
        r0.b(r7, SetsKt.setOf(r8));
    L24:
        IAssistantStartupTelemetry.a.e(r0, r7, r9, null, r10, 10);
        return;
    L22:
        if (Intrinsics.areEqual(r12, r8) == true) goto L24;
        r0.c(r7, r12, r8);
        goto L24
    }

    public Bundle buildLaunchParams(String r5, boolean r6, Boolean r7, Bundle r8, Map<String, ? extends Object> r9, Integer r10, boolean r11) {
        Bundle r0 = new Bundle();
        if (r11 == true) goto L12;
        r0.putBoolean("wakeup_assistant", true);
        r0.putBoolean("arg_wakeup", r6);
        r0.putBoolean("arg_wakeup_not_auto_reset", r6);
        if (r10 == null) goto L7;
        r0.putInt("arg_vuiid", r10.intValue());
    L7:
        r0.putBoolean("arg_launch_floating_window", true);
        r0.putString("wakeup_source", r5);
        r0.putBoolean("obric_allow_show_when_locked", true);
        if (r7 == null) goto L10;
        boolean r12 = r7.booleanValue();
    L11:
        r0.putBoolean("arg_is_mic_in_use", r12);
        goto L12
    L10:
        Set r13 = p.a;
        AppHost.Companion r14 = AppHost.a;
        r12 = p.f(r14.getApplication(), p.b(r14.getApplication()));
    L12:
        r0.putString("as_container", ObricInteractionServiceDelegate.b.a());
        String r15 = null;
        if (r9 == null) goto L15;
        Object r16 = r9.get("data");
    L16:
        FLogger r17 = FLogger.a;
        StringBuilder r18 = new StringBuilder("startChatWindow automic ");
        r18.append(r16);
        r18.append(" and scene : ");
        if (r9 == null) goto L19;
        Object r3 = r9.get("scene");
    L20:
        r18.append(r3);
        r17.i(TAG, r18.toString());
        if (r16 != null) goto L23;
    L30:
        if (r8 == null) goto L32;
        r0.putAll(r8);
    L32:
        r0.putString("argPreviousPage", "wakeup");
        r0.putInt("argBotConversationType", 1);
        return r0;
    L23:
        if ((r16 instanceof Parcelable) == false) goto L30;
        r0.putParcelable("data", (Parcelable) r16);
        Object r19 = r9.get("scene");
        if ((r19 instanceof String) == false) goto L27;
        r15 = (String) r19;
    L27:
        if (r15 != null) goto L29;
        r15 = "";
    L29:
        r0.putString("scene", r15);
        goto L30
    L19:
        r3 = null;
        goto L20
    L15:
        r16 = null;
        goto L16
    }

    private final void startChatWindow(String r14, boolean r15, Boolean r16, Bundle r17, boolean r18, Map<String, ? extends Object> r19, Integer r20, boolean r21, boolean r22, String r23) {
        t0.e(new d(r23, this, r22, r19, r14, r15, r16, r17, r18, r20, r21));
    }

    public void openChatWindow(String r17, boolean r18, Boolean r19, Bundle r20, boolean r21, boolean r22, Map<String, ? extends Object> r23, Integer r24, boolean r25, boolean r26) {
        if (r20 == null) goto L9;
        String r0 = r20.getString("obric_startup_attempt_id");
        if (r0 == null) goto L9;
        if ((!StringsKt.isBlank(r0)) == false) goto L9;
        String r13 = r0;
    L10:
        if (r21 == true) goto L12;
    L20:
        startChatWindow(r17, r18, r19, r20, r22, r23, r24, r25, r26, r13);
        return;
    L12:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L20;
        if (t1.a.i() == true) goto L20;
        FLogger.a.i(TAG, "requestDismissKeyguard");
        if (isWindowMode() == false) goto L19;
        if (r26 == true) goto L19;
        LockedTopChatActivityCleaner.INSTANCE.removeIfNeeded("openChatWindowBeforeDismissKeyguard", false);
    L19:
        com.obric.assistant.spi.keyguard.a.a(new b(this, r17, r18, r19, r20, r22, r23, r24, r25, r26, r13), new c(r13), null, false, 28);
        return;
    L9:
        r13 = null;
        goto L10
    }

    private static final Unit openChatWindow$lambda$2(AssistantChatWindowImpl r3, String r4, boolean r5, Boolean r6, Bundle r7, boolean r8, Map r9, Integer r10, boolean r11, boolean r12, String r13) {
        FLogger.a.i(TAG, "requestDismissKeyguard onSucceeded");
        r3.startChatWindow(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
        return Unit.INSTANCE;
    }

    private static final void startChatWindow$lambda$11(String r32, AssistantChatWindowImpl r33, boolean r34, Map r35, String r36, boolean r37, Boolean r38, Bundle r39, boolean r40, Integer r41, boolean r42) {
        com.obric.assistant.common.utils.i.a r16 = com.obric.assistant.common.utils.i.a(TRACE_START_CHAT_WINDOW);
    L77:
        th = move-exception;
        if (r16 == null) goto L80;
        r16.a();
    L80:
        throw th;
    L5:
        if (ObricLowStorageServiceDelegate.b.a() == false) goto L9;
        FLogger.a.i(TAG, "openChatWindow blocked by low storage");     // Catch: Throwable -> L77
        if (r32 == null) goto L73;
        IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.a, r32, "blocked", "low_storage", null, 24);     // Catch: Throwable -> L77
    L73:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L77
        if (r16 == null) goto L85;
        r16.a();
        return;
    L85:
        return;
    L9:
        long r2 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L77
        boolean r1 = r33.isWindowMode();     // Catch: Throwable -> L77
        if (r1 == false) goto L14;
        if (r34 == true) goto L14;
        boolean r19 = true;
    L16:
        if (r32 == null) goto L29;
        if (r19 == false) goto L19;
        String r22 = "window_content_ready";
    L21:
        if (r19 == false) goto L23;
        String r24 = "window";
    L24:
        if (r19 == false) goto L26;
        Object r3 = "window";
    L27:
        r33.updateStartupRouteIfRequired(r32, r22, r24, MapsKt.mapOf(TuplesKt.to("route", r3)), Intrinsics.areEqual(r36, IInteractionStateService.WAKEUP_SOURCE_VOICE));     // Catch: Throwable -> L77
        goto L29
    L26:
        r3 = "activity";
        goto L27
    L23:
        r24 = "chat";
        goto L24
    L19:
        r22 = "chat_content_ready";
    L29:
        if (r1 == 0) goto L40;
        if (r34 == true) goto L40;
        WindowColdOpenPreloadCoordinator r4 = WindowColdOpenPreloadCoordinator.INSTANCE;     // Catch: Throwable -> L77
        if (r35 == null) goto L34;
        Object r5 = r35.get("scene");     // Catch: Throwable -> L77
    L36:
        if ((r5 instanceof String) == false) goto L38;
        String r6 = (String) r5;     // Catch: Throwable -> L77
    L39:
        r4.preloadForColdOpen("startChatWindow", r6);     // Catch: Throwable -> L77
        goto L40
    L38:
        r6 = null;
        goto L39
    L34:
        r5 = null;
    L40:
        FLogger r7 = FLogger.a;     // Catch: Throwable -> L77
        r7.i(r4, "startChatWindow, assistantRequestFrom=" + r36 + ", wakeUp=" + r37 + ", isMicInUse=" + r38 + ", extra=" + r39 + ", interruptMovingBackground=" + r40 + ", args=" + r35 + ", vuiId=" + r41 + ", forceUseDefaultDisplay = " + r42 + ", forceOpenActivity=" + r34);     // Catch: Throwable -> L77
        Bundle r8 = r33.buildLaunchParams(r36, r37, r38, r39, r35, r41, r34);     // Catch: Throwable -> L77
        if (r32 == null) goto L43;
        r8.putString("obric_startup_attempt_id", r32);     // Catch: Throwable -> L77
    L43:
        boolean r11 = HomeService.a.o();     // Catch: Throwable -> L77
        r7.i(TAG, "startChatWindow, isWindowMode=" + r1 + ", forceOpenActivity=" + r34 + ", enableSideBar=" + r11);     // Catch: Throwable -> L77
        if (r1 == false) goto L63;
        if (r34 == true) goto L63;
    L52:
        e = move-exception;
        FLogger r10 = FLogger.a;     // Catch: Throwable -> L77
        r10.e(TAG, "startChatWindow: open window failed, fallback to Activity \n" + u0.a(e), e);     // Catch: Throwable -> L77
        WindowAppErrorReporter.report$default(WindowAppErrorReporter.INSTANCE, "window_fallback_to_activity", e, "assistant_open_window", null, 8, null);     // Catch: Throwable -> L77
        WindowEvent.INSTANCE.onWindowFallbackToActivity(e);     // Catch: Throwable -> L77
        if (r11 == false) goto L56;
        r33.recoverMainChatAfterWindowFailure(e);     // Catch: Throwable -> L77
    L70:
        IAgentVoiceInteractionIDL r9 = u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));     // Catch: Throwable -> L77
        if (r9 == null) goto L73;
        r9.onStartChatWindow(AssistantActivityExpandState.CHAT_WINDOW.ordinal());     // Catch: Throwable -> L77
        goto L73
    L56:
        if (r32 == null) goto L59;
        r33.updateStartupRouteIfRequired(r32, "chat_content_ready", "chat", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_fallback", "1"), TuplesKt.to("route", "activity")}), Intrinsics.areEqual(r36, IInteractionStateService.WAKEUP_SOURCE_VOICE));     // Catch: Throwable -> L77
    L59:
        r6.commitStartupRoute(r32, r39);     // Catch: Throwable -> L77
        r33.startChatActivity(r8, r40, r42, r32);     // Catch: Throwable -> L77
        if (FlowRuntime.a().isTestChannel() == false) goto L70;
        r10.w(TAG, "start window failed, throw error");     // Catch: Throwable -> L77
        t0.a.post(new e(e));     // Catch: Throwable -> L77
        goto L70
    L48:
        if (r33.isShowing() == false) goto L50;
        r7.i(TAG, "startChatWindow: window is showing, stash it");     // Catch: Exception -> L52 Throwable -> L77
        WindowHost.stashByReason$impl_mainlandRelease$default(WindowHost.INSTANCE, "open chat window", null, 2, null);     // Catch: Exception -> L52 Throwable -> L77
    L50:
        WindowEvent.INSTANCE.beginWindowOpenPerf(r2, "openChatWindow", new WindowEvent.BundleParams(r8));     // Catch: Exception -> L52 Throwable -> L77
        WindowHost.INSTANCE.open(r8);     // Catch: Exception -> L52 Throwable -> L77
        r33.commitStartupRoute(r32, r39);     // Catch: Exception -> L52 Throwable -> L77
    L63:
        if (r34 == false) goto L69;
        if (r11 == false) goto L69;
        WindowHost r12 = WindowHost.INSTANCE;     // Catch: Throwable -> L77
        if (r12.isShowing() == false) goto L68;
        r12.stashWithTransitionOverlayAnimation();     // Catch: Throwable -> L77
    L68:
        r33.startSideBarActivity(r8, r40, r42);     // Catch: Throwable -> L77
    L69:
        r33.commitStartupRoute(r32, r39);     // Catch: Throwable -> L77
        r33.startChatActivity(r8, r40, r42, r32);     // Catch: Throwable -> L77
    L14:
        r19 = false;
        goto L16
    }
}
