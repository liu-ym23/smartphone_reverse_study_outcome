package com.obric.assistant.settings;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.capabilitykit.common.UiType;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0005H\u0014J\u0012\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0004J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/settings/ObricSettingBaseActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "enableFloatingTitleBarTransition", "", "getEnableFloatingTitleBarTransition", "()Z", "adaptSettingStatusBarPadding", "getAdaptSettingStatusBarPadding", "adaptSettingNavigationBarPadding", "getAdaptSettingNavigationBarPadding", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "getBackgroundResource", "", "applyNavigationBarStyle", "isNightMode", "bindSettingRoot", "root", "Landroid/view/View;", "startActivity", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "options", "applySettingNavigationBarStyle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ObricSettingBaseActivity extends FlowCommonAppCompatActivity {
    public final boolean g;

    public int C1() {
        return 2131104374;
    }

    public boolean P1() {
        return false;
    }

    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public ObricSettingBaseActivity() {
        this.g = true;
    }

    public final boolean H1() {
        return O1();
    }

    public final boolean K1() {
        return P1();
    }

    public boolean O1() {
        return !t9a.b.a().b();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0108 */
    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map<Activity, Long> r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = r5.get(this);     // Catch: Throwable -> L45
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
        r1.addFlags(UiType.FLAG_REMOTE_CARD);     // Catch: Throwable -> L42
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
    public final void z1() {
        if (t9a.b.a().b() == true) goto L5;
    L6:
        u.d(this);
    L7:
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 29) goto L10;
        u.g(this, true);
        return;
    L10:
        if (r0 < 29) goto L14;
        getWindow().setNavigationBarContrastEnforced(true);
        return;
    L14:
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 29) goto L7;
        goto L6
    }

    public boolean Q1() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void N1(ObricSettingBaseActivity r4) {
        View r0 = r4.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L7:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "root");
        if (r4.Q1() == false) goto L10;
        ObricFloatingTitleBarTransitionKt.d(r4);
    L10:
        r4.setRootView(r0);
        r4.L1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        c0.a(this);
        super.onCreate(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivity(Intent r3) {
        if (Q1() == true) goto L6;
        super/*android.app.Activity*/.startActivity(r3);
        return;
    L6:
        Boolean r0 = ObricFloatingTitleBarTransitionKt.e(this, r3);
        if (r0 == null) goto L14;
        boolean r1 = r0.booleanValue();
        super/*android.app.Activity*/.startActivity(r3, null);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        ObricFloatingTitleBarTransitionKt.a(r1, e);
        throw e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivity(Intent r2, Bundle r3) {
        if (Q1() == true) goto L6;
        super/*android.app.Activity*/.startActivity(r2, r3);
        return;
    L6:
        Boolean r0 = ObricFloatingTitleBarTransitionKt.e(this, r2);
        if (r0 == null) goto L14;
        boolean r1 = r0.booleanValue();
        super/*android.app.Activity*/.startActivity(r2, r3);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        ObricFloatingTitleBarTransitionKt.a(r1, e);
        throw e;
    }
}
