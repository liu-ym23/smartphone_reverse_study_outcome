package com.larus.dora.obric.device_management.explore;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
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
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0014J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016¨\u0006\u0012"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreDetailActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "createDetailFragment", "Landroidx/fragment/app/Fragment;", "getBackgroundResource", "", "onResume", "finish", "needAdaptStatusBarPadding", "", "needAdaptNavigationBarPadding", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGlassesExploreDetailActivity extends FlowCommonAppCompatActivity {

    public static final class a {
    }

    static {
    }

    public final int C1() {
        return 2131103059;
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
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DoraObricGlassesExploreDetailActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        TransitionAnimStyle r2 = TransitionAnimStyle.Standard;
        int r3 = vja.b.a;
        Intrinsics.checkNotNullParameter(this, "activity");
        Intrinsics.checkNotNullParameter(r2, "animStyle");
        int r4 = vja.a.c[r2.ordinal()];
        if (r4 == 1) goto L7;
        if (r4 != 2) goto L7;
        TransitionAnimStyle r5 = TransitionAnimStyle.Modal;
    L9:
        if (r2 == r5) goto L11;
        mja.a.a r6 = mja.a.a;
        mja.a.b("TransitionAnimHelper", "overrideExitAnim, " + r2 + " is deprecated, use " + r5 + " instead，activity: DoraObricGlassesExploreDetailActivity");
    L12:
        int r7 = vja.a.d[r5.ordinal()];
        if (r7 == 1) goto L23;
        if (r7 != 2) goto L16;
        overridePendingTransition(2130772567, 2130772568);
    L25:
        if ((this instanceof ChatWindowActivity) == true) goto L78;
        FLogger r8 = FLogger.a;
        r8.i("ActivityLancet", "finish ".concat(DoraObricGlassesExploreDetailActivity.class.getName()));
        long r9 = SystemClock.uptimeMillis();
        Map r10 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r10);
        Long r11 = (Long) r10.get(this);     // Catch: Throwable -> L67
        if (r11 != null) goto L32;
    L35:
        r10.put(this, Long.valueOf(r9));     // Catch: Throwable -> L67
        monitor-exit(r10);     // Catch: Throwable -> L67
    L64:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L75:
        return;
    L38:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L41;
        r8.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L64
    L70:
        goto L75
    L41:
        if (isFinishing() == true) goto L44;
        r8.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L64
        goto L70
    L44:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L47;
        r8.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L64
        goto L70
    L47:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L50;
        r8.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L64
        goto L70
    L50:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L53;
        r8.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L64
        goto L70
    L53:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L55;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L64
        goto L70
    L55:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L64
        if (r1 == null) goto L70;
        r1.addFlags(268435456);     // Catch: Throwable -> L64
        r1.addFlags(2097152);     // Catch: Throwable -> L64
        r8.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L64
        startActivity(r1);     // Catch: Throwable -> L61
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L64
        goto L70
    L32:
        if ((r9 - r11.longValue()) >= 800) goto L35;
        monitor-exit(r10);     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        throw th;
    L78:
        return;
    L16:
        if (r7 == 3) goto L21;
        mja.a.a r12 = mja.a.a;
        String r13 = "overrideExitAnim, unsupported anim style: " + r2 + "，activity: DoraObricGlassesExploreDetailActivity";
        Intrinsics.checkNotNullParameter("TransitionAnimHelper", "tag");
        Intrinsics.checkNotNullParameter(r13, "msg");
        if (mja.a.a == null) goto L20;
        Intrinsics.checkNotNullParameter("TransitionAnimHelper", "tag");
        Intrinsics.checkNotNullParameter(r13, "msg");
        goto L25
    L20:
        Intrinsics.checkNotNullParameter("TransitionAnimHelper", "tag");
        Intrinsics.checkNotNullParameter(r13, "msg");
        goto L25
    L21:
        overridePendingTransition(2130772573, 2130772574);
        goto L25
    L23:
        overridePendingTransition(2130772530, 2130772531);
        goto L25
    L11:
        mja.a.a r14 = mja.a.a;
        mja.a.d("TransitionAnimHelper", "overrideExitAnim, animStyle: " + r2 + "，activity: DoraObricGlassesExploreDetailActivity");
    L7:
        r5 = r2;
        goto L9
    }

    public final void onResume() {
        super.onResume();
        com.larus.utils.u.f(this, false);
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

    public DoraObricGlassesExploreDetailActivity() {
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
        com.larus.utils.u.f(this, false);
        setContentView(2131561787);
        if (r5 != null) goto L29;
        FragmentTransaction r6 = getSupportFragmentManager().beginTransaction();
        String r0 = getIntent().getStringExtra("arg_detail_page_type");
        if (r0 != null) goto L15;
    L20:
        Fragment r1 = new DoraObricGlassesExploreDetailFragment();
    L21:
        r1.setArguments(getIntent().getExtras());
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L25;
        r6 = r6.replace(2131373275, r1);
    L25:
        r6.commitAllowingStateLoss();
        return;
    L15:
        if (r0.hashCode() != 93508654) goto L20;
        if (r0.equals("basic") == false) goto L20;
        r1 = new DoraObricGlassesBasicDetailFragment();
        goto L21
    }
}
