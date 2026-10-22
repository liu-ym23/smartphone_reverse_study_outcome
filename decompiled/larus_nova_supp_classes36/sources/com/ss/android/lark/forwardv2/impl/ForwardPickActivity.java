package com.ss.android.lark.forwardv2.impl;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.activity.ActivityAnimationManager;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dc9.d;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ForwardPickActivity extends BaseFragmentActivity {
    public ForwardPickFragment a;

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
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

    public final void onBackPressed() {
        ForwardPickFragment r0 = this.a;
        if (r0 != null) goto L5;
        boolean r1 = false;
    L6:
        if (r1 == true) goto L9;
        super.onBackPressed();
        return;
    L9:
        return;
    L5:
        r1 = r0.onBackPressed();
        goto L6
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public final ActivityAnimationManager.AnimationConfig getEnterAnimationConfig() {
        Bundle r0 = getIntent().getExtras();
        if (r0 == null) goto L9;
        int[] r1 = r0.getIntArray("key_transition_anim_in");
        if (r1 == null) goto L9;
        return new ActivityAnimationManager.AnimationConfig(r1);
    L9:
        return super.getEnterAnimationConfig();
    }

    public final ActivityAnimationManager.AnimationConfig getExitAnimationConfig() {
        Bundle r0 = getIntent().getExtras();
        if (r0 == null) goto L9;
        int[] r1 = r0.getIntArray("key_transition_anim_out");
        if (r1 == null) goto L9;
        return new ActivityAnimationManager.AnimationConfig(r1);
    L9:
        return super.getExitAnimationConfig();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public ForwardPickActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r6) {
        super.onConfigurationChanged(r6);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (d.a() == true) goto L19;
        int r2 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r6 == null) goto L8;
        Integer r3 = Integer.valueOf(r6.orientation);     // Catch: Throwable -> L17
    L9:
        if (r3 != null) goto L12;
    L14:
        if (r2 != 3) goto L19;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:" + getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        goto L19
    L12:
        if (r3.intValue() == r2) goto L19;
    L8:
        r3 = null;
    L19:
        int r7 = r6.orientation;
        this.a.d.a.e.a.o.notifyDataSetChanged();
        return;
    L17:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r5);
        ForwardPickFragment r6 = new ForwardPickFragment();
        r6.setArguments(getIntent().getExtras());
        FragmentTransaction r0 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.content) == true) goto L14;
        r0.add(R.id.content, r6, null);
    L14:
        r0.commitNowAllowingStateLoss();
        this.a = r6;
    }
}
