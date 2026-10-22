package com.larus.dora.impl.dynamic;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.audio.AudioServiceDelegate;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.dora.IDoraWakeupService;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\"\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/impl/dynamic/DoraDynamicActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Lcom/larus/dora/api/IDoraDynamicActivity;", "<init>", "()V", "fg", "Lcom/larus/dora/impl/dynamic/DoraDynamicFragment;", "TAG", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getBackgroundResource", "onDestroy", "isDoraGManagementEntry", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDynamicActivity extends FlowCommonAppCompatActivity implements t39.k {
    public DoraDynamicFragment g;
    public final String h;

    public final int C1() {
        return 2131102535;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DoraDynamicActivity.class.getName()));
    L5:
        super.onDestroy();
        IObricDoraService r0 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        boolean r1 = true;
        if (r0 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L13;
        return;
    L13:
        if (AudioServiceDelegate.a.e0() == false) goto L29;
        IDoraWakeupService r3 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r3 != null) goto L17;
    L19:
        r1 = false;
    L20:
        if (r1 == false) goto L30;
        FLogger.a.i(this.h, "onDestroy, try close vui session");
        IDoraWakeupService r4 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r4 == null) goto L24;
        r4.l(false);
    L24:
        IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r5 == null) goto L31;
        r5.H0(162);
        return;
    L31:
        return;
    L30:
        return;
    L17:
        if (r3.f() != true) goto L19;
    L29:
        return;
    L8:
        if (r0.t() != true) goto L10;
        r2 = true;
        goto L11
    }

    public DoraDynamicActivity() {
        this.h = "DoraDynamicActivity";
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DoraDynamicActivity.class.getName()));
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        N1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
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
    public final void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r6);
        Bundle r0 = getIntent().getExtras();
        Integer r1 = com.larus.dora.impl.device.t0.a(r0, "product_id");
        if (r1 != null) goto L27;
        if (r0 == null) goto L25;
        String r2 = r0.getString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC);
        if (r2 == null) goto L25;
        Iterator r3 = DoraAdapterExtKt.k(kj4.a.g()).iterator();
    L17:
        if (r3.hasNext() == false) goto L21;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((DoraDevice) r4).mac, r2) == false) goto L17;
    L22:
        DoraDevice r5 = (DoraDevice) r4;
        if (r5 == null) goto L25;
        r1 = Integer.valueOf(r5.productId);
        goto L27
    L21:
        r4 = null;
    L25:
        r1 = null;
    L27:
        if (o59.a.o(r1) == false) goto L31;
        int r7 = m59.b.a;
        if (m59.b.a(this, "//dora_dynamic_list", getIntent().getExtras()) == false) goto L31;
        finish();
        return;
    L31:
        Window r8 = getWindow();
        if (r8 == null) goto L38;
        View r9 = N1(r8);
        if (r9 == null) goto L38;
        IDoraAVLinkService r10 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r10 == null) goto L38;
        r10.v1(r9, getComponentName().getClassName());
    L38:
        setContentView(2131561787);
        if (r6 != null) goto L52;
        DoraDynamicFragment r11 = new DoraDynamicFragment();
        this.g = r11;
        r11.setArguments(getIntent().getExtras());
        FragmentTransaction r12 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r12, r11, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L44;
        r12 = r12.replace(2131373275, r11);
    L44:
        r12.commitAllowingStateLoss();
        return;
    }

    public final void onActivityResult(int r8, int r9, Intent r10) {
        super.onActivityResult(r8, r9, r10);
        boolean r11 = false;
        if (r10 == null) goto L8;
        if (r10.hasExtra("autoStopTimeConfig") != true) goto L8;
        r11 = true;
    L8:
        if (r11 == false) goto L20;
        Bundle r12 = r10.getExtras();
        if (r12 == null) goto L27;
        DoraDynamicFragment r13 = this.g;
        if (r13 == null) goto L28;
        Intrinsics.checkNotNullParameter(r12, "bundle");
        DoraDynamicPagerAdapter r14 = r13.i;
        if (r14 == null) goto L29;
        DoraDynamicListFragment r15 = r14.y2(1);
        if (r15 == null) goto L30;
        DslCardAdapter r16 = r15.g;
        if (r16 == null) goto L31;
        r16.y2(DslCardAdapter.a.InterfaceC0061a.b.a);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L20:
        if (r10 == null) goto L33;
        Bundle r17 = r10.getExtras();
        if (r17 == null) goto L34;
        DoraDynamicFragment r18 = this.g;
        if (r18 == null) goto L35;
        Intrinsics.checkNotNullParameter(r17, "bundle");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DoraDynamicFragment$onIndividualToneResult$1(r17, r18, null), 2, null);
        return;
    L35:
        return;
    L34:
        return;
    }
}
