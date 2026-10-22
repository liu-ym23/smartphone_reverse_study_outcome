package com.larus.dora.obric.device_management.device_home;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0014J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u001e"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "handleEntry", "source", "", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "needAdaptStatusBarPadding", "", "needAdaptNavigationBarPadding", "getBackgroundResource", "", "updateImmersiveSystemBars", "registerBackPressedHandler", "isDesktopShortcutEntry", "moveShortcutTaskToBack", "redirectToUnifiedEntry", "showDeviceHomeFragment", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricDeviceHomeActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int g = 0;

    public static final class a {
    }

    static {
    }

    public final int C1() {
        return 2131104268;
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
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DoraObricDeviceHomeActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O1() {
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r0 = true;
    L6:
        com.larus.utils.u.f(this, !r0);
        getWindow().setBackgroundDrawableResource(2131104268);
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DoraObricDeviceHomeActivity.class.getName()));
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

    public DoraObricDeviceHomeActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N1(String r9) {
        int r0 = DoraObricDeviceHomeShortcutActivity.a;
        boolean r2 = false;
        if (DoraObricDeviceHomeShortcutActivity.a.a() == true) goto L17;
        if (isFinishing() == false) goto L7;
        return;
    L7:
        if (isDestroyed() == true) goto L89;
        g49.d.d("DoraObricDeviceHomeActivity", "redirectToUnifiedEntry source=".concat(r9));
        Intent r10 = getIntent();
        Intrinsics.checkNotNullParameter(this, "context");
        Intent r1 = new Intent(this, DoraObricDeviceHomeShortcutActivity.class);
        r1.setAction("android.intent.action.VIEW");
        r1.setData(DoraObricDeviceHomeShortcutActivity.a.c());
        if (r10 == null) goto L14;
        Bundle r11 = r10.getExtras();
        if (r11 == null) goto L14;
        r1.putExtras(r11);
    L14:
        r1.putExtra("start_from", "desktop_shortcut");
        r1.putExtra(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, "desktop_shortcut");
        startActivity(r1);
        finish();
        overridePendingTransition(0, 0);
        return;
    L89:
        return;
    L17:
        if (isFinishing() == false) goto L19;
    L84:
        g49.d.d("DoraObricDeviceHomeActivity", "showDeviceHomeFragment skip destroyed, source=".concat(r9));
        return;
    L19:
        if (isDestroyed() == true) goto L84;
        DoraObricDeviceHomeFragment r3 = getSupportFragmentManager().findFragmentById(2131373275);
        Integer r5 = null;
        if ((r3 instanceof DoraObricDeviceHomeFragment) == false) goto L24;
        DoraObricDeviceHomeFragment r4 = r3;
    L25:
        if (r4 != null) goto L27;
        g49.d.d("DoraObricDeviceHomeActivity", "showDeviceHomeFragment source=".concat(r9));
        FragmentTransaction r12 = getSupportFragmentManager().beginTransaction();
        DoraObricDeviceHomeFragment r6 = new DoraObricDeviceHomeFragment();
        r6.setArguments(getIntent().getExtras());
        Unit r7 = Unit.INSTANCE;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r12, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L83;
        r12 = r12.replace(2131373275, r6);
    L83:
        r12.commitNowAllowingStateLoss();
        return;
    L27:
        if (Intrinsics.areEqual(r9, "onNewIntent") == false) goto L78;
        g49.d.d("DoraObricDeviceHomeActivity", "showDeviceHomeFragment update existing, source=".concat(r9));
        Bundle r13 = getIntent().getExtras();
        r4.J = r13;
        r4.K = true;
        r4.C = DoraObricDeviceHomeFragment.sa0(r13);
        if (r13 == null) goto L38;
        String r8 = r13.getString("obric_device_home_diary_date");
        if (r8 == null) goto L38;
        if (r8.length() <= 0) goto L35;
        boolean r14 = true;
    L36:
        if (r14 == false) goto L38;
    L39:
        r4.D = r8;
        if (r4.N == false) goto L71;
        r4.ia0().onEntryArgumentsChanged(r13);
        List<r1> r15 = ((DoraObricDeviceHomeViewModel.c) r4.ia0().getUiState().getValue()).m;
        if (r4.aa0(r15) == false) goto L44;
        Iterator<r1> r16 = r15.iterator();
        int r17 = 0;
    L55:
        if (r16.hasNext() == false) goto L63;
        if (r16.next().b != r4.ha0()) goto L59;
        boolean r18 = true;
    L60:
        if (r18 == true) goto L64;
        r17 = r17 + 1;
    L64:
        Integer r20 = Integer.valueOf(r17);
        if (r20.intValue() < 0) goto L67;
        r2 = true;
    L67:
        if (r2 == false) goto L69;
        r5 = r20;
    L69:
        if (r5 == null) goto L73;
        int r21 = r5.intValue();
        r4.j = Integer.valueOf(r21);
        r4.ma0(r15);
        DoraObricDeviceHomeFragment.pa0(r4, r21);
    L73:
        if (r4.isResumed() == true) goto L75;
    L77:
        r4.M = true;
        return;
    L75:
        if (r4.N == false) goto L77;
        r4.qa0();
        return;
    L59:
        r18 = false;
        goto L60
    L63:
        r17 = -1;
        goto L64
    L44:
        if (r4.ha0() != DoraObricDeviceHomeTabPage.DIARY) goto L73;
        String r22 = r4.D;
        if (r22 == null) goto L73;
        r4.D = null;
        Fragment r23 = r4.getChildFragmentManager().findFragmentByTag("ObricDeviceHomeDiaryFragment");
        if (r23 == null) goto L73;
        DoraObricDeviceHomeFragment.ua0(r23, r22);
        goto L73
    L71:
        r4.L = true;
        goto L73
    L35:
        r14 = false;
    L38:
        r8 = null;
        goto L39
    L78:
        g49.d.d("DoraObricDeviceHomeActivity", "showDeviceHomeFragment keep existing, source=".concat(r9));
        return;
    L24:
        r4 = null;
        goto L25
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
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:DoraObricDeviceHomeActivity portrait");     // Catch: Throwable -> L14
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
    public final void onCreate(Bundle r2) {
        if (com.larus.platform.service.z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r2);
        int r3 = m59.b.a;
        if (m59.b.a(this, "//flow/dora/obric_device_home", getIntent().getExtras()) == false) goto L13;
        finish();
        return;
    L13:
        O1();
        setContentView(2131561787);
        getOnBackPressedDispatcher().addCallback(this, new DoraObricDeviceHomeActivity$registerBackPressedHandler$1(this));
        N1("onCreate");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNewIntent(Intent r2) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r2);
        setIntent(r2);
        int r0 = m59.b.a;
        if (r2 == null) goto L5;
        Bundle r3 = r2.getExtras();
    L7:
        if (m59.b.a(this, "//flow/dora/obric_device_home", r3) == false) goto L10;
        finish();
        return;
    L10:
        N1("onNewIntent");
        return;
    L5:
        r3 = null;
        goto L7
    }
}
