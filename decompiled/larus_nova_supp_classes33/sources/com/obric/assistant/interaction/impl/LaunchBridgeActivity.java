package com.obric.assistant.interaction.impl;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.spi.app.IObricLaunchService;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0014¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/impl/LaunchBridgeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LaunchBridgeActivity extends AppCompatActivity {
    public static final Companion Companion = null;
    private static final String TAG = "LaunchBridgeActivity";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/LaunchBridgeActivity$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public void com_obric_assistant_interaction_impl_LaunchBridgeActivity__finish$___twin___() {
        super.finish();
    }

    public void com_obric_assistant_interaction_impl_LaunchBridgeActivity__onDestroy$___twin___() {
        super.onDestroy();
    }

    public void com_obric_assistant_interaction_impl_LaunchBridgeActivity__onStop$___twin___() {
        super.onStop();
    }

    public void finish() {
        com_obric_assistant_interaction_impl_LaunchBridgeActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void onCreate(Bundle r1) {
        com_obric_assistant_interaction_impl_LaunchBridgeActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public void onDestroy() {
        com_obric_assistant_interaction_impl_LaunchBridgeActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    public void onStop() {
        com_obric_assistant_interaction_impl_LaunchBridgeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        FLogger.a.e(TAG, "onResume");
        IObricLaunchService r0 = (IObricLaunchService) ServiceManager.get().getService(IObricLaunchService.class);
        if (r0 == null) goto L5;
        r0.resumeOrLaunchNewTask(false);
    L5:
        finish();
    }

    public LaunchBridgeActivity() {
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_LaunchBridgeActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_LaunchBridgeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(LaunchBridgeActivity r1) {
        r1.com_obric_assistant_interaction_impl_LaunchBridgeActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_LaunchBridgeActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_LaunchBridgeActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(LaunchBridgeActivity r11) {
        r11.com_obric_assistant_interaction_impl_LaunchBridgeActivity__finish$___twin___();
        if ((r11 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(LaunchBridgeActivity.class.getName()));
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

    public static void com_obric_assistant_interaction_impl_LaunchBridgeActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(LaunchBridgeActivity r3) {
        if ((r3 instanceof FragmentActivity) == true) goto L5;
    L7:
        r3.com_obric_assistant_interaction_impl_LaunchBridgeActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r3) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r3);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r3.getClass().getName()));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_obric_assistant_interaction_impl_LaunchBridgeActivity__onCreate$___twin___(Bundle r4) {
        f.a(getTheme());
        FLogger.a.e(TAG, "onCreate");
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r4);
        getWindow().setStatusBarColor(0);
        Window r5 = getWindow();
        if (r5 == null) goto L7;
        View r6 = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_LaunchBridgeActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r5);
        if (r6 == null) goto L7;
        r6.setBackgroundColor(0);
    L7:
        Window r7 = getWindow();
        if (r7 == null) goto L10;
        r7.setBackgroundDrawable(new ColorDrawable(0));
    L10:
        getWindow().setGravity(8388659);
        Window r8 = getWindow();
        WindowManager.LayoutParams r0 = getWindow().getAttributes();
        r0.width = 1;
        r0.height = 1;
        r0.format = -2;
        r0.flags = ((r0.flags | 16) | 8) | UiType.FLAG_TIMER_CARD;
        r8.setAttributes(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_LaunchBridgeActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(LaunchBridgeActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_obric_assistant_interaction_impl_LaunchBridgeActivity__onCreate$___twin___(r2);
    }
}
