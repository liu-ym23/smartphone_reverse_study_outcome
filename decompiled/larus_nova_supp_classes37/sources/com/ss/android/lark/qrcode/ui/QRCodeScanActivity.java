package com.ss.android.lark.qrcode.ui;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
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
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class QRCodeScanActivity extends BaseFragmentActivity {
    public static String b;
    public long a;

    public final boolean isNeedLoginStatus() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
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
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public final ActivityAnimationManager.AnimationConfig getEnterAnimationConfig() {
        if (ForsetiFGHelpers.d() == false) goto L7;
        return new ActivityAnimationManager.AnimationConfig(ActivityAnimationManager.ANIM_HOLD);
    L7:
        return super.getEnterAnimationConfig();
    }

    public final ActivityAnimationManager.AnimationConfig getExitAnimationConfig() {
        if (ForsetiFGHelpers.d() == false) goto L7;
        return new ActivityAnimationManager.AnimationConfig(ActivityAnimationManager.ANIM_HOLD);
    L7:
        return super.getExitAnimationConfig();
    }

    public final void onBackPressed() {
        super.onBackPressed();
        h.c.a.getClass();
        if (h.m() == false) goto L5;
        String r0 = "ve";
    L6:
        c2c.a.a(r0, h.l(), "userexit", System.currentTimeMillis() - this.a);
        return;
    L5:
        r0 = PickerReporterConstants.VALUE.SCENE.OTHERS;
        goto L6
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

    public QRCodeScanActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        fsb.f.c("QRCodeScanActivity").j();
        disableBlackStatusBarBeforeOnCreate();
        super.onCreate(r5);
        int r6 = QRCodeScanFragment.n;
        Intrinsics.checkNotNullParameter(this, "activity");
        FragmentTransaction r7 = getSupportFragmentManager().beginTransaction();
        QRCodeScanFragment r0 = new QRCodeScanFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.content) == true) goto L14;
        r7 = r7.replace(R.id.content, r0);
    L14:
        r7.commit();
        this.a = System.currentTimeMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onWindowFocusChanged(boolean r1) {
        super/*android.app.Activity*/.onWindowFocusChanged(r1);
        fsb.f.b().g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onActivityResult(int r5, int r6, Intent r7) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(r5, r6, r7);
        if (r5 != 1000) goto L17;
        a2c.a r8 = z1c.a.a;
        if (r8 == null) goto L9;
        if (r8.isFeatureGatingEnable("im.scan_code.close_scan_activity_early") == false) goto L9;
    L10:
        if (r7 != null) goto L12;
    L14:
        finish();
        return;
    L12:
        if (r7.getExtras() == null) goto L14;
        z1c.a.C0207a.a((String) r7.getExtras().get("RESULT_PARAM_CONTENT"), this);
    L9:
        if (ForsetiFGHelpers.d() == false) goto L14;
    L17:
        if (r5 != 1001) goto L24;
        if (r7 == null) goto L24;
        String r9 = (String) r7.getExtras().get("RESULT_PARAM_CONTENT");
        a0 r10 = new a0();
        Intrinsics.checkNotNullParameter(r9, "result");
        a.InterfaceC0121a r11 = r10.a;
        if (r11 == null) goto L22;
        s r12 = (s) r11;
        Log.i("QRCodeModule", "Scan time from entering the page to scanning to the result = " + (System.currentTimeMillis() - r12.a));
        r12.b.c.E4(r9);
    L22:
        a2c.a r13 = z1c.a.a;
        z1c.a.C0207a.a(r9, this);
        finish();
        return;
    L24:
        if (r7 != null) goto L26;
        return;
    L26:
        if (r6 == (-1)) goto L29;
        return;
    L29:
        if (r5 != 233) goto L35;
        Fragment r0 = getSupportFragmentManager().findFragmentById(R.id.content);
        if (r0 == null) goto L36;
        r0.onActivityResult(r5, r6, r7);
        return;
    L36:
        return;
    }
}
