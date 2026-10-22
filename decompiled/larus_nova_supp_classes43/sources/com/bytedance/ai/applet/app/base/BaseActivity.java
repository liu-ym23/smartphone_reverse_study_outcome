package com.bytedance.ai.applet.app.base;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ai.applet.app.view.AppletThemeMode;
import com.bytedance.ai.applet.app.view.k;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dc9.d;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/applet/app/base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "activityThemeMode", "Lcom/bytedance/ai/applet/app/view/AppletThemeMode;", "getActivityThemeMode", "()Lcom/bytedance/ai/applet/app/view/AppletThemeMode;", "activityThemeMode$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupEdgeToEdge", "updateSystemBarAppearance", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseActivity extends AppCompatActivity {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r10 = FLogger.a;
        r10.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r10.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r10.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r10.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r10.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r10.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
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
        r10.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r11 - r13.longValue()) >= 800) goto L13;
        monitor-exit(r12);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public final AppletThemeMode y1() {
        return (AppletThemeMode) this.a.getValue();
    }

    public BaseActivity() {
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new com.bytedance.ai.applet.app.base.a(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z1() {
        Window r0 = getWindow();
        View r1 = getWindow().getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r10 = ThreadMethodProxy.currentThread();
        if (r10 == c.a) goto L7;
        c.a(r10, "getDecorView");
    L7:
        WindowInsetsControllerCompat r11 = WindowCompat.getInsetsController(r0, r1);
        if (y1() != AppletThemeMode.DARK) goto L10;
    L14:
        boolean r12 = false;
    L15:
        if (r11 == null) goto L17;
        r11.setAppearanceLightStatusBars(r12);
    L17:
        if (r11 == null) goto L20;
        r11.setAppearanceLightNavigationBars(r12);
        return;
    L20:
        return;
    L10:
        if (y1() != AppletThemeMode.LIGHT) goto L12;
    L13:
        r12 = true;
        goto L15
    L12:
        if ((getResources().getConfiguration().uiMode & 48) == 32) goto L14;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super.onConfigurationChanged(r10);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (d.a() == true) goto L19;
        int r11 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r10 == null) goto L8;
        Integer r12 = Integer.valueOf(r10.orientation);     // Catch: Throwable -> L17
    L9:
        if (r12 != null) goto L12;
    L14:
        if (r11 != 3) goto L19;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:" + getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        goto L19
    L12:
        if (r12.intValue() == r11) goto L19;
    L8:
        r12 = null;
    L19:
        z1();
        return;
    L17:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        AppCompatDelegate r0 = getDelegate();
        AppletThemeMode r1 = y1();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int[] r11 = k.a.a;
        int r12 = r11[r1.ordinal()];
        if (r12 == 1) goto L18;
        if (r12 == 2) goto L17;
        if (r12 != 3) goto L16;
        int r13 = 2;
    L19:
        r0.setLocalNightMode(r13);
        Resources.Theme r14 = getTheme();
        AppletThemeMode r15 = y1();
        Intrinsics.checkNotNullParameter(r15, "<this>");
        int r16 = r11[r15.ordinal()];
        if (r16 == 1) goto L27;
        if (r16 == 2) goto L26;
        if (r16 != 3) goto L25;
        int r17 = 2131953718;
    L28:
        r14.applyStyle(r17, true);
        getTheme().applyStyle(k.a(y1()), true);
        com.bytedance.ai.applet.base.log.b r18 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("BaseActivity", "apply theme mode: " + y1());
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r10);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        z1();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.content), new b(this));
        int r19 = t2.a.c(this, 2130968825, 2131100405);
        Window r20 = getWindow();
        if (r20 == null) goto L34;
        r20.setBackgroundDrawable(new ColorDrawable(r19));
        return;
    L34:
        return;
    L25:
        throw new NoWhenBranchMatchedException();
    L26:
        r17 = 2131953719;
        goto L28
    L27:
        r17 = 2131953717;
        goto L28
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r13 = 1;
        goto L19
    L18:
        r13 = -100;
        goto L19
    }
}
