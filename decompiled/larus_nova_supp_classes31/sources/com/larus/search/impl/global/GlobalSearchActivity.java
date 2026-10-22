package com.larus.search.impl.global;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
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
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/search/impl/global/GlobalSearchActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "openWithUpDownAnim", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "finish", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GlobalSearchActivity extends FlowCommonAppCompatActivity {
    public boolean g;

    public final boolean H1() {
        return false;
    }

    public final boolean K1() {
        return false;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(GlobalSearchActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:55:0x0115 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if (this.g == false) goto L5;
        int r2 = 2130772405;
    L6:
        overridePendingTransition(0, r2);
        if ((this instanceof ChatWindowActivity) == true) goto L48;
        FLogger r3 = FLogger.a;
        r3.i("ActivityLancet", "finish ".concat(GlobalSearchActivity.class.getName()));
        long r4 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L49
        if (r6 != null) goto L14;
    L17:
        r5.put(this, Long.valueOf(r4));     // Catch: Throwable -> L49
        monitor-exit(r5);     // Catch: Throwable -> L49
    L46:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L52:
        return;
    L20:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L23;
        r3.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L46
        goto L52
    L23:
        if (isFinishing() == true) goto L26;
        r3.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L46
        goto L52
    L26:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L29;
        r3.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L46
        goto L52
    L29:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L32;
        r3.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L46
        goto L52
    L32:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L35;
        r3.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L46
        goto L52
    L35:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L37;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L46
        goto L52
    L37:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L46
        if (r1 == null) goto L52;
        r1.addFlags(268435456);     // Catch: Throwable -> L46
        r1.addFlags(2097152);     // Catch: Throwable -> L46
        r3.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L46
        startActivity(r1);     // Catch: Throwable -> L43
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L46
        goto L52
    L14:
        if ((r4 - r6.longValue()) >= 800) goto L17;
        monitor-exit(r5);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;
    L48:
        return;
    L5:
        r2 = 2130772404;
        goto L6
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

    public GlobalSearchActivity() {
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
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r5);
        setContentView(2131561787);
        Intent r6 = getIntent();
        boolean r0 = false;
        if (r6 == null) goto L13;
        r0 = r6.getBooleanExtra("key_open_with_updown_anim", false);
    L13:
        this.g = r0;
        Window r7 = getWindow();
        if (r7 == null) goto L16;
        View r8 = N1(r7);
    L17:
        setRootView(r8);
        L1();
        GlobalSearchFragment r9 = new GlobalSearchFragment();
        r9.setArguments(getIntent().getExtras());
        FragmentTransaction r1 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L21;
        r1 = r1.replace(2131373275, r9);
    L21:
        r1.commitAllowingStateLoss();
        return;
    L16:
        r8 = null;
        goto L17
    }
}
