package com.larus.chat.job.impl.page;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.chat.job.api.IChatJobFragmentFactory;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0002¨\u0006\u0011"}, d2 = {"Lcom/larus/chat/job/impl/page/ChatJobActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "needAdaptNavigationBarPadding", "", "needAdaptStatusBarPadding", "setupSystemBars", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobActivity extends FlowCommonAppCompatActivity {

    public static final class a {
    }

    static {
    }

    public final boolean H1() {
        return false;
    }

    public final boolean K1() {
        return false;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ChatJobActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O1() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), true);
        ViewCompat.requestApplyInsets(N1(getWindow()));
        int r0 = gz8.g.a;
        Intrinsics.checkNotNullParameter(this, "context");
        int r1 = v19.c.a(2130970529, this, 2131102529);
        getWindow().setStatusBarColor(r1);
        getWindow().setNavigationBarColor(r1);
        boolean r2 = v19.h.a;
        boolean r3 = !v19.h.b(this);
        WindowInsetsControllerCompat r4 = WindowCompat.getInsetsController(getWindow(), N1(getWindow()));
        if (r4 == null) goto L6;
        r4.setAppearanceLightStatusBars(r3);
        r4.setAppearanceLightNavigationBars(r3);
        return;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ChatJobActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void onResume() {
        super.onResume();
        O1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        N1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public ChatJobActivity() {
    }

    public static View N1(Window r3) {
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
    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super.onConfigurationChanged(r5);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L14
        if (dc9.d.a() == true) goto L16;
        int r1 = getRequestedOrientation();     // Catch: Throwable -> L14
        Integer r6 = Integer.valueOf(r5.orientation);     // Catch: Throwable -> L14
        if (r6 != null) goto L9;
    L11:
        if (r1 != 3) goto L16;
        setRequestedOrientation(1);     // Catch: Throwable -> L14
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:ChatJobActivity portrait");     // Catch: Throwable -> L14
        goto L16
    L9:
        if (r6.intValue() != r1) goto L11;
    L16:
        O1();
        return;
    L14:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r5);
        O1();
        setContentView(2131561890);
        Window r0 = getWindow();
        if (r0 == null) goto L13;
        View r1 = N1(r0);
    L14:
        setRootView(r1);
        L1();
        if (r5 != null) goto L40;
        IChatJobFragmentFactory.a.getClass();
        IChatJobFragmentFactory r6 = (IChatJobFragmentFactory) ServiceManager.get().getService(IChatJobFragmentFactory.class);
        if (r6 == null) goto L22;
        ChatJobFragment r7 = r6.a(getIntent().getExtras());
        if (r7 == null) goto L22;
    L35:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L29
        FragmentTransaction r3 = getSupportFragmentManager().beginTransaction();     // Catch: Throwable -> L29
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r3, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131377228) == true) goto L27;
        r3 = r3.replace(2131377228, r7);     // Catch: Throwable -> L29
    L27:
        r3.commitNowAllowingStateLoss();     // Catch: Throwable -> L29
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L39;
        FLogger.a.e("ChatJobActivity", "attach ChatJobFragment failed", r9);
        return;
    L39:
        return;
    L29:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L22:
        r7 = new ChatJobFragment();
        r7.setArguments(getIntent().getExtras());
        goto L35
    L40:
        return;
    L13:
        r1 = null;
        goto L14
    }
}
