package com.bytedance.ai.applet.components.page;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.utils.g;
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
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0007J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0010R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/applet/components/page/AppletPageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "renderUrlData", "Lcom/bytedance/ai/applet/components/page/RenderUrlData;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "getStatusBarHeight", "", "getNavBarHeight", "setupImmersiveStatusBars", "isDarkMode", "", "setupImmersiveNavigationBars", "light", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPageActivity extends AppCompatActivity {
    public static final /* synthetic */ int b = 0;
    public RenderUrlData a;

    public static final class a {
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r10 = FLogger.a;
        r10.i("ActivityLancet", "finish ".concat(AppletPageActivity.class.getName()));
        long r11 = SystemClock.uptimeMillis();
        Map r12 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r12);
        Long r13 = (Long) r12.get(this);     // Catch: Throwable -> L45
        if (r13 != null) goto L10;
    L13:
        r12.put(this, Long.valueOf(r11));     // Catch: Throwable -> L45
        monitor-exit(r12);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r10.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r10.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r10.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r10.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r10.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
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
        r10.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r11 - r13.longValue()) >= 800) goto L13;
        monitor-exit(r12);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AppletPageActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        final View r0 = findViewById(R.id.content);
        if (r0 == null) goto L6;
        r0.post(new com.bytedance.ai.applet.components.page.a(r0, this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public AppletPageActivity() {
    }

    public static View y1(Window r10) {
        View r11 = r10.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L41
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L41
    L8:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r10);
        ActionBar r11 = getSupportActionBar();     // Catch: Exception -> L13
        if (r11 == null) goto L15;
        r11.hide();     // Catch: Exception -> L13
    L15:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r12 = AppletRuntimeManager.d;
        boolean r1 = true;
        if (r12 != null) goto L18;
    L20:
        boolean r13 = false;
    L21:
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        WindowInsetsControllerCompat r14 = WindowCompat.getInsetsController(getWindow(), y1(getWindow()));
        if (r14 == null) goto L24;
        r14.setAppearanceLightStatusBars(!r13);
    L24:
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setNavigationBarColor(0);
        WindowInsetsControllerCompat r15 = WindowCompat.getInsetsController(getWindow(), y1(getWindow()));
        if (r15 == null) goto L27;
        r15.setAppearanceLightNavigationBars(true);
    L27:
        String r16 = getIntent().getStringExtra("ARG_URL");
        if (r16 != null) goto L30;
    L33:
        if (r1 == false) goto L35;
        g.a.e("AppletPageActivity", "onCreate: url arguments null");
        finish();
        return;
    L35:
        g.a.d("AppletPageActivity", "onCreate: url = " + r16);
        RenderUrlData r17 = c.a(r16);
        this.a = r17;
        FrameLayout r0 = new FrameLayout(this);
        r0.setId(View.generateViewId());
        r0.setBackgroundResource(2131100488);
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setContentView(r0);
        FragmentTransaction r18 = getSupportFragmentManager().beginTransaction();
        int r19 = r0.getId();
        int r20 = RenderFragment.g;
        Intrinsics.checkNotNullParameter(r17, "data");
        RenderFragment r21 = new RenderFragment();
        Bundle r22 = new Bundle();
        r22.putParcelable(Reflection.getOrCreateKotlinClass(RenderUrlData.class).getSimpleName(), r17);
        r21.setArguments(r22);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r18, r21, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r19) == true) goto L39;
        r18 = r18.add(r19, r21);
    L39:
        r18.commit();
        return;
    L30:
        if (r16.length() == 0) goto L33;
        r1 = false;
        goto L33
    L18:
        if (r12.v(null) != true) goto L20;
        r13 = true;
    L13:
        e = move-exception;
        g.a.e("AppletPageActivity", "onCreate: hide action bar error", e);
        goto L15
    }
}
