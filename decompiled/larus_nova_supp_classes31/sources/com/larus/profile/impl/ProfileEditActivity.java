package com.larus.profile.impl;

import android.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.profile.impl.relaxedit.ProfileEditRelaxKmpFragment;
import com.larus.settings.value.b7;
import com.larus.settings.value.e10;
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
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/profile/impl/ProfileEditActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "isFromH5AccountSetting", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getBackgroundResource", "", "finish", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileEditActivity extends FlowCommonAppCompatActivity {
    public boolean g;

    public final int C1() {
        return 2131102535;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ProfileEditActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if (this.g == false) goto L6;
        overridePendingTransition(0, 0);
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ProfileEditActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L48
        if (r6 != null) goto L13;
    L16:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L48
        monitor-exit(r5);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L56:
        return;
    L19:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L45
    L51:
        goto L56
    L22:
        if (isFinishing() == true) goto L25;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r1 == null) goto L51;
        r1.addFlags(268435456);     // Catch: Throwable -> L45
        r1.addFlags(2097152);     // Catch: Throwable -> L45
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r1);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L48
    L48:
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

    public ProfileEditActivity() {
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
    public final void onCreate(Bundle r11) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r11);
        AtomicBoolean r12 = a1.l;
        long r0 = System.currentTimeMillis();
        Uri r13 = getIntent().getData();
        if (r13 == null) goto L13;
        String r14 = UriProtector.getQueryParameter(r13, "scene");
    L14:
        boolean r15 = Intrinsics.areEqual(r14, "account");
        this.g = r15;
        if (r15 == false) goto L17;
        overridePendingTransition(0, 0);
    L17:
        setContentView(2131561787);
        Window r16 = getWindow();
        if (r16 == null) goto L20;
        View r17 = N1(r16);
    L21:
        setRootView(r17);
        L1();
        Bundle r18 = getIntent().getExtras();
        if (r18 == null) goto L24;
        Bundle r3 = new Bundle(r18);
    L25:
        int r19 = y0.a;
        Intent r110 = getIntent();
        Intrinsics.checkNotNullParameter(r3, "arguments");
        int r5 = com.larus.profile.impl.relaxedit.l.a;
        String r7 = "relax_kmp";
        if (AppHost.a.isDebug() == false) goto L55;
        if (r110 == null) goto L34;
        String r6 = r110.getStringExtra("relax_kmp");
        if (r6 == null) goto L34;
        if ((!StringsKt.isBlank(r6)) == false) goto L34;
    L35:
        if (r6 != null) goto L46;
        if (r110 == null) goto L44;
        Uri r111 = r110.getData();
        if (r111 == null) goto L44;
        r6 = UriProtector.getQueryParameter(r111, "relax_kmp");
        if (r6 == null) goto L44;
        if ((!StringsKt.isBlank(r6)) == true) goto L46;
    L44:
        r6 = null;
    L46:
        if (StringsKt.equals(r6, "1", true) == false) goto L48;
    L57:
        Boolean r112 = Boolean.TRUE;
    L58:
        if (r112 == null) goto L60;
        boolean r113 = r112.booleanValue();
    L61:
        String r8 = "native";
        if (r113 == true) goto L65;
        r7 = "native";
    L65:
        FLogger.a.i("ProfileEditFragmentFactory", "create profile edit page mode=".concat(r7));
        if (r113 == false) goto L68;
        r8 = "relax";
    L68:
        Intrinsics.checkNotNullParameter(r3, "arguments");
        Intrinsics.checkNotNullParameter(r8, "variant");
        r3.putString("profile_edit_perf_variant", r8);
        r3.putLong("profile_edit_perf_open_start_ms", r0);
        r3.putBoolean("profile_edit_perf_is_cold_start", !a1.l.getAndSet(true));
        r3.putBoolean("profile_edit_perf_report_enabled", true);
        if (r113 == false) goto L71;
        Fragment r114 = new ProfileEditRelaxKmpFragment();
    L72:
        r114.setArguments(r3);
        FragmentTransaction r1 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r114, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L76;
        r1 = r1.replace(2131373275, r114);
    L76:
        r1.commitAllowingStateLoss();
        return;
    L71:
        r114 = new ProfileEditFragment();
        goto L72
    L60:
        e10 r115 = e10.a;
        int r116 = com.larus.utils.l0.a;
        r113 = ((Boolean) com.larus.utils.l0.a(Boolean.FALSE, new b7())).booleanValue();
        goto L61
    L48:
        if (StringsKt.equals(r6, "true", true) == true) goto L57;
        if (StringsKt.equals(r6, "0", true) == false) goto L53;
    L56:
        r112 = Boolean.FALSE;
        goto L58
    L53:
        if (StringsKt.equals(r6, "false", true) == false) goto L55;
    L34:
        r6 = null;
    L55:
        r112 = null;
        goto L58
    L24:
        r3 = new Bundle();
        goto L25
    L20:
        r17 = null;
        goto L21
    L13:
        r14 = null;
        goto L14
    }
}
