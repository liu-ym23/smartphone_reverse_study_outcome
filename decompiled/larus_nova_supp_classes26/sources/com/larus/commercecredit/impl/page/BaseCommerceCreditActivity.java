package com.larus.commercecredit.impl.page;

import android.R;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H$J\b\u0010\u0006\u001a\u00020\u0007H$J\b\u0010\b\u001a\u00020\tH\u0014J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\b\u0010\u0012\u001a\u00020\u0005H$J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0014¨\u0006\u0017"}, d2 = {"Lcom/larus/commercecredit/impl/page/BaseCommerceCreditActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "getActivityTag", "", "createFragment", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "getFragmentArguments", "Landroid/os/Bundle;", "onCreate", "", "savedInstanceState", "setupActivity", "showFragment", "getBackgroundResource", "", "autoEnterPage", "getCommerceCreditCurrentPage", "getPreviousPageName", "getEnterMethod", "finish", "onFinish", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseCommerceCreditActivity extends FlowCommonAppCompatActivity {
    public final int C1() {
        return R.color.transparent;
    }

    public abstract BottomSheetDialogFragment O1();

    public abstract String P1();

    public abstract String Q1();

    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N1() {
        String r5 = Q1();
        String r0 = getIntent().getStringExtra("previous_page");
        if (r0 != null) goto L5;
        String r16 = "";
    L6:
        String r1 = getIntent().getStringExtra("enter_method");
        if (r1 != null) goto L9;
        String r8 = "";
    L10:
        a1.c(null, null, null, null, null, r5, null, null, r8, null, null, null, null, null, null, null, r16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1049729, -1, 7);
        return;
    L9:
        r8 = r1;
        goto L10
    L5:
        r16 = r0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void R1() {
        overridePendingTransition(2130772357, 2130772358);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        R1();
        super.finish();
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

    public BaseCommerceCreditActivity() {
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
        Window r6 = getWindow();
        if (r6 == null) goto L17;
        View r7 = r6.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L18;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L18;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L18:
        setRootView(r7);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        overridePendingTransition(2130772359, 2130772358);
        BottomSheetDialogFragment r8 = O1();     // Catch: Exception -> L30
        Intent r1 = getIntent();     // Catch: Exception -> L30
        if (r1 == null) goto L23;
        Bundle r2 = r1.getExtras();     // Catch: Exception -> L30
        if (r2 == null) goto L23;
    L24:
        r8.setArguments(r2);     // Catch: Exception -> L30
        FragmentManager r3 = getSupportFragmentManager();     // Catch: Exception -> L30
        String r4 = P1();     // Catch: Exception -> L30
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L30
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, r4, r9);     // Catch: Exception -> L30
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r8, r9) == false) goto L39;
    L34:
        N1();
        return;
    L39:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36
    L28:
        r8.show(r3, r4);     // Catch: Exception -> L30
    L23:
        r2 = new Bundle();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        FLogger.a.e(P1(), "show fragment exception: " + e);
        if (isFinishing() == true) goto L34;
        finish();
        goto L34
    L17:
        r7 = null;
        goto L18
    }
}
