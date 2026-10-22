package com.obric.assistant.interaction.impl.permission;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.g1;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.capabilitykit.common.UiType;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0012\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0015J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\u0006\u0010\u001f\u001a\u00020\u000eJ\b\u0010 \u001a\u00020\u000eH\u0015J\b\u0010!\u001a\u00020\u000eH\u0014J\b\u0010\"\u001a\u00020\u000eH\u0014J\u0012\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/obric/assistant/interaction/impl/permission/PermissionHelperActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "service", "Lcom/larus/platform/api/IPermission;", "getService", "()Lcom/larus/platform/api/IPermission;", "service$delegate", "Lkotlin/Lazy;", "isFinishingNormal", "", "isWaitingPermissionDialogFinish", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "fragmentLifecycleCallbacks", "com/obric/assistant/interaction/impl/permission/PermissionHelperActivity$fragmentLifecycleCallbacks$2$1", "getFragmentLifecycleCallbacks", "()Lcom/obric/assistant/interaction/impl/permission/PermissionHelperActivity$fragmentLifecycleCallbacks$2$1;", "fragmentLifecycleCallbacks$delegate", "onNewIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "handleIntent", "executeTask", "task", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask;", "checkActive", "finishNormal", "finishDirectly", "onResume", "onStop", "onDestroy", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "Companion", "CustomRequestPermissionCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionHelperActivity extends AppCompatActivity {
    public static final Companion Companion = null;
    public static final String TAG = "PermissionHelperActivity";
    private final Lazy fragmentLifecycleCallbacks$delegate;
    private boolean isFinishingNormal;
    private boolean isWaitingPermissionDialogFinish;
    private final Lazy service$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/permission/PermissionHelperActivity$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J8\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/interaction/impl/permission/PermissionHelperActivity$CustomRequestPermissionCallback;", "Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "task", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask;", "taskCallback", "<init>", "(Lcom/obric/assistant/interaction/impl/permission/PermissionHelperActivity;Lcom/obric/assistant/interaction/impl/permission/PermissionTask;Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;)V", "getTask", "()Lcom/obric/assistant/interaction/impl/permission/PermissionTask;", "getTaskCallback", "()Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "onResult", "", "allGranted", "", "grantedList", "", "", "deniedList", "isGoSettingsDialogShown", "onGoSettingsDialogShow", "onGoSettingsDialogDismiss", "isConfirmed", "onSettingPageReturn", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CustomRequestPermissionCallback implements g1.c {
        private final PermissionTask task;
        private final g1.c taskCallback;
        final /* synthetic */ PermissionHelperActivity this$0;

        public void onGoSettingsDialogShow() {
            boolean r0 = PermissionHelperActivity.access$checkActive(this.this$0);
            FLogger.a.i(PermissionHelperActivity.TAG, "permission: onGoSettingsDialogShow, isActive = " + r0);
            g1.c r1 = this.taskCallback;
            if (r1 == null) goto L6;
            r1.onGoSettingsDialogShow();
            return;
        }

        public void onSettingPageReturn() {
            boolean r0 = PermissionHelperActivity.access$checkActive(this.this$0);
            g1.c r1 = this.taskCallback;
            if (r1 == null) goto L5;
            r1.onSettingPageReturn();
        L5:
            FLogger.a.i(PermissionHelperActivity.TAG, "permission: onSettingPageReturn, isActive = " + r0);
        }

        public final PermissionTask getTask() {
            return this.task;
        }

        public final g1.c getTaskCallback() {
            return this.taskCallback;
        }

        public void onGoSettingsDialogDismiss(boolean r5) {
            boolean r0 = PermissionHelperActivity.access$checkActive(this.this$0);
            FLogger.a.i(PermissionHelperActivity.TAG, "permission: isConfirmed = " + r5 + ", isActive = " + r0);
            g1.c r1 = this.taskCallback;
            if (r1 == null) goto L5;
            r1.onGoSettingsDialogDismiss(r5);
        L5:
            if (r0 == false) goto L8;
            PermissionHelperActivity.access$finishNormal(this.this$0);
            return;
        }

        public CustomRequestPermissionCallback(PermissionHelperActivity r2, PermissionTask r3, g1.c r4) {
            Intrinsics.checkNotNullParameter(r3, "task");
            this.this$0 = r2;
            this.task = r3;
            this.taskCallback = r4;
        }

        public void onResult(boolean r5, List<String> r6, List<String> r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r6, "grantedList");
            Intrinsics.checkNotNullParameter(r7, "deniedList");
            boolean r0 = PermissionHelperActivity.access$checkActive(this.this$0);
            FLogger.a.i(PermissionHelperActivity.TAG, "permission: allGranted = " + r5 + ", grantedList = " + r6 + ", deniedList = " + r7 + ", isGoSettingsDialogShown = " + r8 + ", isActive = " + r0);
            if (r0 == false) goto L10;
            if (r8 == true) goto L6;
            PermissionHelperActivity.access$finishNormal(this.this$0);
        L6:
            g1.c r1 = this.taskCallback;
            if (r1 == null) goto L11;
            r1.onResult(r5, r6, r7, r8);
            return;
        L11:
            return;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Unit A1(PermissionHelperActivity r0, PermissionTask r1, boolean r2) {
        return executeTask$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ Unit B1(PermissionHelperActivity r0, PermissionTask r1, boolean r2, List r3, List r4) {
        return executeTask$lambda$3(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit C1(PermissionHelperActivity r0, PermissionTask r1, boolean r2) {
        return executeTask$lambda$2(r0, r1, r2);
    }

    private final void finishNormal() {
        this.isFinishingNormal = true;
        PermissionMediator.INSTANCE.finishTask();
        finishDirectly();
    }

    public static /* synthetic */ PermissionHelperActivity$fragmentLifecycleCallbacks$2$1 y1(PermissionHelperActivity r0) {
        return fragmentLifecycleCallbacks_delegate$lambda$1(r0);
    }

    public static /* synthetic */ g1 z1() {
        return service_delegate$lambda$0();
    }

    public void com_obric_assistant_interaction_impl_permission_PermissionHelperActivity__finish$___twin___() {
        super.finish();
    }

    public void finish() {
        com_obric_assistant_interaction_impl_permission_PermissionHelperActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void onCreate(Bundle r1) {
        com_obric_assistant_interaction_impl_permission_PermissionHelperActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public void onDestroy() {
        com_obric_assistant_interaction_impl_permission_PermissionHelperActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    public void onStop() {
        com_obric_assistant_interaction_impl_permission_PermissionHelperActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    private final boolean checkActive() {
        return PermissionMediator.INSTANCE.isProcessing();
    }

    private final PermissionHelperActivity$fragmentLifecycleCallbacks$2$1 getFragmentLifecycleCallbacks() {
        return (PermissionHelperActivity$fragmentLifecycleCallbacks$2$1) this.fragmentLifecycleCallbacks$delegate.getValue();
    }

    private final g1 getService() {
        return (g1) this.service$delegate.getValue();
    }

    private final void handleIntent() {
        PermissionTask r0 = PermissionMediator.INSTANCE.consumeTask();
        if (r0 != null) goto L6;
        finishDirectly();
        return;
    L6:
        executeTask(r0);
    }

    private static final g1 service_delegate$lambda$0() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPermissionService();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_obric_assistant_interaction_impl_permission_PermissionHelperActivity__onDestroy$___twin___() {
        FLogger.a.d(TAG, "onDestroy " + hashCode());
        super.onDestroy();
        getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(getFragmentLifecycleCallbacks());
    }

    public PermissionHelperActivity() {
        this.service$delegate = LazyKt.lazy(new a());
        this.fragmentLifecycleCallbacks$delegate = LazyKt.lazy(new b(this));
    }

    public void com_obric_assistant_interaction_impl_permission_PermissionHelperActivity__onStop$___twin___() {
        super.onStop();
        if (this.isFinishingNormal == true) goto L8;
        PermissionMediator r0 = PermissionMediator.INSTANCE;
        if (r0.isProcessing() == false) goto L9;
        finishDirectly();
        r0.cancelCurrentTask("Lifecycle Interruption (Screen Off/Background)");
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finishDirectly() {
        finish();
        overridePendingTransition(0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        FLogger.a.d(TAG, "onResume " + hashCode());
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_permission_PermissionHelperActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final /* synthetic */ boolean access$checkActive(PermissionHelperActivity r0) {
        return r0.checkActive();
    }

    public static final /* synthetic */ void access$finishNormal(PermissionHelperActivity r0) {
        r0.finishNormal();
    }

    public static final /* synthetic */ boolean access$isWaitingPermissionDialogFinish$p(PermissionHelperActivity r0) {
        return r0.isWaitingPermissionDialogFinish;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_permission_PermissionHelperActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(PermissionHelperActivity r1) {
        r1.com_obric_assistant_interaction_impl_permission_PermissionHelperActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_permission_PermissionHelperActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_permission_PermissionHelperActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(PermissionHelperActivity r11) {
        r11.com_obric_assistant_interaction_impl_permission_PermissionHelperActivity__finish$___twin___();
        if ((r11 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(PermissionHelperActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map<Activity, Long> r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = r5.get(r11);     // Catch: Throwable -> L50
        if (r6 != null) goto L10;
    L13:
        r5.put(r11, Long.valueOf(r3));     // Catch: Throwable -> L50
        monitor-exit(r5);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L16:
        if (r11.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L20;
        r2.i("ActivityLancet", "quit !resume, current state = " + r11.getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        return;
    L20:
        if (r11.isFinishing() == true) goto L24;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        return;
    L24:
        if (ActivityStartBehavior.isInternalActivityConsumed(r11) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        return;
    L28:
        if (ActivityLancet.isOnlyActivityInTask(r11) == true) goto L32;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        return;
    L32:
        if (ActivityLancet.isExcludedActivity(r11) == false) goto L36;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        return;
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        return;
    L38:
        Intent r1 = r11.getPackageManager().getLaunchIntentForPackage(r11.getPackageName());     // Catch: Throwable -> L47
        if (r1 != null) goto L41;
        return;
    L41:
        r1.addFlags(268435456);     // Catch: Throwable -> L47
        r1.addFlags(UiType.FLAG_REMOTE_CARD);     // Catch: Throwable -> L47
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r11);     // Catch: Throwable -> L47
        r11.startActivity(r1);     // Catch: Throwable -> L44
        r11.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        return;
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }

    public static void com_obric_assistant_interaction_impl_permission_PermissionHelperActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(PermissionHelperActivity r3) {
        if ((r3 instanceof FragmentActivity) == true) goto L5;
    L7:
        r3.com_obric_assistant_interaction_impl_permission_PermissionHelperActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r3) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r3);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r3.getClass().getName()));
        goto L7
    }

    private final void executeTask(final PermissionTask r9) {
        FLogger.a.i(TAG, "executeTask " + r9);
        if ((r9 instanceof PermissionTask.RequestBasic) == false) goto L8;
        g1 r0 = getService();
        if (r0 == null) goto L46;
        r0.a(this, ((PermissionTask.RequestBasic) r9).getManifest(), new c(this, r9));
        return;
    L46:
        return;
    L8:
        if ((r9 instanceof PermissionTask.RequestDetail) == false) goto L13;
        g1 r1 = getService();
        if (r1 == null) goto L48;
        r1.m(this, ((PermissionTask.RequestDetail) r9).getManifest(), new d(this, r9));
        return;
    L48:
        return;
    L13:
        if ((r9 instanceof PermissionTask.RequestWithMap) == false) goto L18;
        g1 r2 = getService();
        if (r2 == null) goto L50;
        PermissionTask.RequestWithMap r3 = (PermissionTask.RequestWithMap) r9;
        r2.b(null, r3.getManifest(), new e(this, r9), r3.getSubTitleMap());
        return;
    L50:
        return;
    L18:
        if ((r9 instanceof PermissionTask.RequestFull) == false) goto L23;
        g1 r4 = getService();
        if (r4 == null) goto L52;
        PermissionTask.RequestFull r5 = (PermissionTask.RequestFull) r9;
        r4.g(this, r5.getManifest(), new CustomRequestPermissionCallback(this, r9, r5.getCallback()), r5.getSubTitleMap(), r5.getTrackInfo(), r5.getShowGoSettingsDialog());
        return;
    L52:
        return;
    L23:
        if ((r9 instanceof PermissionTask.RequestAny) == false) goto L28;
        g1 r6 = getService();
        if (r6 == null) goto L54;
        PermissionTask.RequestAny r7 = (PermissionTask.RequestAny) r9;
        r6.j(null, this, r7.getManifest(), null, new CustomRequestPermissionCallback(this, r9, r7.getCallback()));
        return;
    L54:
        return;
    L28:
        if ((r9 instanceof PermissionTask.ShowSettingDialog) == false) goto L33;
        g1.b r8 = new PermissionHelperActivity$executeTask$wrapperCallback$1(r9, this);
        g1 r10 = getService();
        if (r10 == null) goto L56;
        PermissionTask.ShowSettingDialog r11 = (PermissionTask.ShowSettingDialog) r9;
        r10.l(this, r11.getPermission(), r11.getSubTitle(), r8);
        return;
    L56:
        return;
    L33:
        if ((r9 instanceof PermissionTask.GoSettings) == false) goto L38;
        g1 r12 = getService();
        if (r12 == null) goto L58;
        r12.i(this, new CustomRequestPermissionCallback(this, r9, ((PermissionTask.GoSettings) r9).getCallback()));
        return;
    L58:
        return;
    L38:
        if ((r9 instanceof PermissionTask.RequestNotification) == false) goto L45;
        g1 r13 = getService();
        if (r13 == null) goto L42;
        r13.f(((PermissionTask.RequestNotification) r9).isLaunching());
    L42:
        finishNormal();
        return;
    L45:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.assistant.interaction.impl.permission.PermissionHelperActivity$fragmentLifecycleCallbacks$2$1] */
    private static final PermissionHelperActivity$fragmentLifecycleCallbacks$2$1 fragmentLifecycleCallbacks_delegate$lambda$1(final PermissionHelperActivity r1) {
        return new PermissionHelperActivity$fragmentLifecycleCallbacks$2$1(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_obric_assistant_interaction_impl_permission_PermissionHelperActivity__onCreate$___twin___(Bundle r3) {
        f.a(getTheme());
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r3);
        FLogger.a.d(TAG, "onCreate " + hashCode());
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(2131563332);
        overridePendingTransition(0, 0);
        PermissionMediator.INSTANCE.attachActivity(this);
        handleIntent();
        getSupportFragmentManager().registerFragmentLifecycleCallbacks(getFragmentLifecycleCallbacks(), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(MotionEvent r4) {
        FLogger.a.d(TAG, "unexpected touch event");
        finishDirectly();
        return super/*android.app.Activity*/.dispatchTouchEvent(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onNewIntent(Intent r1) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r1);
        setIntent(r1);
        handleIntent();
    }

    public static final /* synthetic */ void access$setWaitingPermissionDialogFinish$p(PermissionHelperActivity r0, boolean r1) {
        r0.isWaitingPermissionDialogFinish = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_permission_PermissionHelperActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(PermissionHelperActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_obric_assistant_interaction_impl_permission_PermissionHelperActivity__onCreate$___twin___(r2);
    }

    private static final Unit executeTask$lambda$2(PermissionHelperActivity r3, PermissionTask r4, boolean r5) {
        FLogger.a.i(TAG, "permission: allGranted = " + r5);
        if (r3.checkActive() == false) goto L9;
        if (r5 == false) goto L6;
        r3.finishNormal();
    L7:
        ((PermissionTask.RequestBasic) r4).getCallback().invoke(Boolean.valueOf(r5));
        goto L9
    L6:
        r3.isWaitingPermissionDialogFinish = true;
    L9:
        return Unit.INSTANCE;
    }

    private static final Unit executeTask$lambda$4(PermissionHelperActivity r3, PermissionTask r4, boolean r5) {
        FLogger.a.i(TAG, "permission: allGranted = " + r5);
        if (r3.checkActive() == false) goto L9;
        if (r5 == false) goto L6;
        r3.finishNormal();
    L7:
        ((PermissionTask.RequestWithMap) r4).getCallback().invoke(Boolean.valueOf(r5));
        goto L9
    L6:
        r3.isWaitingPermissionDialogFinish = true;
    L9:
        return Unit.INSTANCE;
    }

    private static final Unit executeTask$lambda$3(PermissionHelperActivity r3, PermissionTask r4, boolean r5, List r6, List r7) {
        Intrinsics.checkNotNullParameter(r6, "granted");
        Intrinsics.checkNotNullParameter(r7, "denied");
        FLogger.a.i(TAG, "permissionForDetail: all = " + r5 + ", granted = " + r6 + ", denied = " + r7);
        if (r3.checkActive() == false) goto L9;
        if (r5 == false) goto L6;
        r3.finishNormal();
    L7:
        ((PermissionTask.RequestDetail) r4).getCallback().invoke(Boolean.valueOf(r5), r6, r7);
        goto L9
    L6:
        r3.isWaitingPermissionDialogFinish = true;
    L9:
        return Unit.INSTANCE;
    }
}
