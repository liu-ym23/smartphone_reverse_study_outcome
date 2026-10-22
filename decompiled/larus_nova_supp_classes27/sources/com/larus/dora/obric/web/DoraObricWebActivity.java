package com.larus.dora.obric.web;

import android.R;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.home.impl.utils.c;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import e79.a;
import java.util.Locale;
import java.util.Map;
import ts9.b;
import v19.f;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraObricWebActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int g = 0;

    public final int C1() {
        return 2131104374;
    }

    public final boolean K1() {
        return false;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DoraObricWebActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DoraObricWebActivity.class.getName()));
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
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == c.a) goto L9;
        c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public DoraObricWebActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r9) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r9);
        setContentView(2131562236);
        boolean r0 = h.a;
        u.f(this, !h.a(this));
        if (Build.VERSION.SDK_INT < 29) goto L13;
        getWindow().setNavigationBarContrastEnforced(false);
    L13:
        int r1 = b.a;
        Bundle r2 = getIntent().getExtras();
        if (r2 == null) goto L16;
        String r3 = r2.getString("title");
    L17:
        OFloatingTitleBar r4 = findViewById(2131369851);
        r4.R(false);
        com.larus.dora.obric.utils.c.a(r4);
        r4.setBackgroundColor(ContextCompat.getColor(this, 2131104374));
        if (r3 != null) goto L20;
        r3 = "";
    L20:
        r4.setCenterTitle(r3);
        r4.j(-1, new a(this));
        if (r9 != null) goto L49;
        String r10 = b.a(getIntent().getExtras());
        if (TextUtils.isEmpty(r10) == true) goto L30;
        String r5 = UriProtector.parse(r10).getScheme();
        if ("http".equalsIgnoreCase(r5) == false) goto L28;
    L31:
        boolean r6 = true;
    L32:
        if (r6 == true) goto L34;
        finish();
        return;
    L34:
        AbsWebFragment r7 = ss9.b.a.c();
        if (r7 != null) goto L37;
        finish();
        return;
    L37:
        Bundle r8 = getIntent().getExtras();
        if (r8 != null) goto L40;
        Bundle r11 = new Bundle();
    L41:
        int r12 = ContextCompat.getColor(this, 2131104374);
        String r13 = String.format(Locale.ROOT, "#%08X", new Object[]{Integer.valueOf(r12)});
        r11.putString("link_url", r10);
        r11.putString("hide_title_bar", "1");
        r11.putString("is_not_full_page", "1");
        r11.putString("hide_go_forward_and_back", "1");
        r11.putInt("web_view_bg_color", r12);
        r11.putString("status_bar_bg_color", r13);
        r7.setArguments(r11);
        FragmentTransaction r14 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r14, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131369850) == true) goto L45;
        r14 = r14.replace(2131369850, r7);
    L45:
        r14.commitNowAllowingStateLoss();
        return;
    L40:
        r11 = new Bundle(r8);
        goto L41
    L28:
        if ("https".equalsIgnoreCase(r5) == true) goto L31;
    L30:
        r6 = false;
        goto L32
    L49:
        return;
    L16:
        r3 = null;
        goto L17
    }
}
