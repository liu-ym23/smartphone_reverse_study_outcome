package com.obric.assistant.interaction.impl.window.helpers;

import android.R;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindow$DefaultImpls;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.state.api.v2.core.ObricDeviceStateDelegate;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u000e\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0015J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0015J\u001a\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0003J\b\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\u0011H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\""}, d2 = {"Lcom/obric/assistant/interaction/impl/window/helpers/OverlayPermissionGuideActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "goSettingLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "shouldFinishOnDialogDismiss", "", "permissionDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "isNightMode", "screenStateListener", "com/obric/assistant/interaction/impl/window/helpers/OverlayPermissionGuideActivity$screenStateListener$1", "Lcom/obric/assistant/interaction/impl/window/helpers/OverlayPermissionGuideActivity$screenStateListener$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onDestroy", "onKeyDown", "keyCode", "", "event", "Landroid/view/KeyEvent;", "showPermissionDialogIfNeeded", "openOverlayPermissionSetting", "buildOverlayPermissionIntent", "hasSystemAlertWindowPermission", "launchAssistantAfterPermissionGranted", "finishDirectly", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OverlayPermissionGuideActivity extends AppCompatActivity {
    public static final Companion Companion = null;
    private static final String REQUEST_FROM = "system_alert_window_permission";
    private static final String TAG = "WindowPermissionHelperActivity";
    private final ActivityResultLauncher<Intent> goSettingLauncher;
    private boolean isNightMode;
    private com.obric.oui.dialog.v2.alert.c permissionDialog;
    private final OverlayPermissionGuideActivity$screenStateListener$1 screenStateListener;
    private boolean shouldFinishOnDialogDismiss;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/helpers/OverlayPermissionGuideActivity$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_FROM", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void A1(ActivityResult r0) {
        goSettingLauncher$lambda$0(r0);
    }

    public static /* synthetic */ Unit B1(OverlayPermissionGuideActivity r0, DialogInterface r1, int r2) {
        return showPermissionDialogIfNeeded$lambda$2(r0, r1, r2);
    }

    private static final void goSettingLauncher$lambda$0(ActivityResult r0) {
    }

    public static /* synthetic */ Unit y1(OverlayPermissionGuideActivity r0, DialogInterface r1, int r2) {
        return showPermissionDialogIfNeeded$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ void z1(OverlayPermissionGuideActivity r0, DialogInterface r1) {
        showPermissionDialogIfNeeded$lambda$3(r0, r1);
    }

    public void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__finish$___twin___() {
        super.finish();
    }

    public void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__onStop$___twin___() {
        super.onStop();
    }

    public void finish() {
        com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void onCreate(Bundle r1) {
        com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public void onDestroy() {
        com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    public void onStop() {
        com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean hasSystemAlertWindowPermission() {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return true;
    L7:
        return Settings.canDrawOverlays(this);
    }

    private final void launchAssistantAfterPermissionGranted() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        IAssistantChatWindow r1 = IAssistantChatWindowKt.getAssistantChatWindow();     // Catch: Throwable -> L8
        if (r1 == null) goto L5;
        IAssistantChatWindow$DefaultImpls.openChatWindow$default(r1, REQUEST_FROM, false, null, null, false, true, null, null, false, false, 972, null);     // Catch: Throwable -> L8
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L16;
        FLogger.a.e(TAG, "launchAssistantAfterPermissionGranted failed", r4);
        return;
    L16:
        return;
    L5:
        r2 = null;
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showPermissionDialogIfNeeded() {
        if (this.permissionDialog == null) goto L5;
        return;
    L5:
        com.obric.oui.dialog.v2.alert.g r0 = new com.obric.oui.dialog.v2.alert.g(this);
        r0.w = false;
        String r2 = getString(2131912707);
        r0.j = false;
        r0.h = r2;
        r0.i = getString(2131912706);
        com.obric.oui.dialog.v2.alert.g.c(r0);
        r0.e(getString(2131912704), new a(this));
        r0.h(getString(2131912705), new b(this));
        com.obric.oui.dialog.v2.alert.c r1 = r0.a();
        r1.setOnDismissListener(new c(this));
        this.permissionDialog = r1;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r1);
    }

    public void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__onDestroy$___twin___() {
        ObricDeviceStateDelegate.b.a(this.screenStateListener);
        com.obric.oui.dialog.v2.alert.c r0 = this.permissionDialog;
        if (r0 == null) goto L5;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r0);
    L5:
        this.permissionDialog = null;
        super.onDestroy();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.assistant.interaction.impl.window.helpers.OverlayPermissionGuideActivity$screenStateListener$1] */
    public OverlayPermissionGuideActivity() {
        this.goSettingLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new d());
        this.shouldFinishOnDialogDismiss = true;
        this.screenStateListener = new OverlayPermissionGuideActivity$screenStateListener$1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Intent buildOverlayPermissionIntent() {
        String r0 = getPackageName();
        Intent r1 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", UriProtector.parse("package:" + r0));
        r1.addFlags(1073741824);
        if (r1.resolveActivity(getPackageManager()) == null) goto L6;
        return r1;
    L6:
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", UriProtector.parse("package:" + r0)).addFlags(1073741824);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void finishDirectly() {
        finish();
        overridePendingTransition(0, 0);
    }

    private final void openOverlayPermissionSetting() {
        Intent r0 = buildOverlayPermissionIntent();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        this.goSettingLauncher.launch(r0);     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L13;
        FLogger.a.e(TAG, "open overlay permission setting failed", r3);
        finishDirectly();
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        if (hasSystemAlertWindowPermission() == false) goto L5;
        launchAssistantAfterPermissionGranted();
        finishDirectly();
        return;
    L5:
        showPermissionDialogIfNeeded();
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(com.obric.oui.dialog.v2.alert.c r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(com.obric.oui.dialog.v2.alert.c r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(OverlayPermissionGuideActivity r1) {
        r1.com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(OverlayPermissionGuideActivity r11) {
        r11.com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__finish$___twin___();
        if ((r11 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(OverlayPermissionGuideActivity.class.getName()));
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

    public static void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(OverlayPermissionGuideActivity r3) {
        if ((r3 instanceof FragmentActivity) == true) goto L5;
    L7:
        r3.com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r3) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r3);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r3.getClass().getName()));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__onCreate$___twin___(Bundle r4) {
        v19.f.a(getTheme());
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r4);
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L5;
        setShowWhenLocked(false);
    L5:
        boolean r5 = true;
        supportRequestWindowFeature(1);
        ActionBar r1 = getSupportActionBar();
        if (r1 == null) goto L9;
        r1.hide();
    L9:
        if ((getResources().getConfiguration().uiMode & 48) == 32) goto L12;
        r5 = false;
    L12:
        this.isNightMode = r5;
        boolean r2 = v19.h.a;
        v19.h.a = r5;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()).setBackgroundColor(0);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(2131563332);
        overridePendingTransition(0, 0);
        if (hasSystemAlertWindowPermission() == false) goto L16;
        finishDirectly();
        return;
    L16:
        showPermissionDialogIfNeeded();
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        if (Build.VERSION.SDK_INT < 29) goto L19;
        getWindow().setStatusBarContrastEnforced(false);
        getWindow().setNavigationBarContrastEnforced(false);
    L19:
        ObricDeviceStateDelegate.b.b(this.screenStateListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(OverlayPermissionGuideActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(r1) == false) goto L8;
        v19.f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__onCreate$___twin___(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void showPermissionDialogIfNeeded$lambda$3(OverlayPermissionGuideActivity r0, DialogInterface r1) {
        r0.permissionDialog = null;
        if (r0.shouldFinishOnDialogDismiss == true) goto L5;
        return;
    L5:
        if (r0.isFinishing() == true) goto L9;
        r0.finishDirectly();
        return;
    }

    public boolean onKeyDown(int r2, KeyEvent r3) {
        if (r2 != 4) goto L7;
        finishDirectly();
        return true;
    L7:
        return super.onKeyDown(r2, r3);
    }

    private static final Unit showPermissionDialogIfNeeded$lambda$1(OverlayPermissionGuideActivity r0, DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
        r0.shouldFinishOnDialogDismiss = true;
        r1.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit showPermissionDialogIfNeeded$lambda$2(OverlayPermissionGuideActivity r0, DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
        r0.shouldFinishOnDialogDismiss = false;
        r1.dismiss();
        r0.openOverlayPermissionSetting();
        return Unit.INSTANCE;
    }
}
