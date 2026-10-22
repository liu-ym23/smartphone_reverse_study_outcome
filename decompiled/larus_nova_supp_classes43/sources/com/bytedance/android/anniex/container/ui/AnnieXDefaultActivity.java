package com.bytedance.android.anniex.container.ui;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXDefaultActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXDefaultActivity extends AppCompatActivity {
    public final Lazy a;

    /* JADX INFO: Removed unreachable split cross block B:56:0x0119 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        ja.b r10 = ((e) this.a.getValue()).a;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
        r10 = null;
    L5:
        r10.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L47;
        FLogger r11 = FLogger.a;
        r11.i("ActivityLancet", "finish ".concat(AnnieXDefaultActivity.class.getName()));
        long r12 = SystemClock.uptimeMillis();
        Map r13 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r13);
        Long r14 = (Long) r13.get(this);     // Catch: Throwable -> L48
        if (r14 != null) goto L13;
    L16:
        r13.put(this, Long.valueOf(r12));     // Catch: Throwable -> L48
        monitor-exit(r13);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L53:
        return;
    L19:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r11.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L53
    L22:
        if (isFinishing() == true) goto L25;
        r11.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L53
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r11.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L53
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r11.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L53
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r11.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L53
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L53
    L36:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r1 == null) goto L53;
        r1.addFlags(268435456);     // Catch: Throwable -> L45
        r1.addFlags(2097152);     // Catch: Throwable -> L45
        r11.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r1);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L53
    L13:
        if ((r12 - r14.longValue()) >= 800) goto L16;
        monitor-exit(r13);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    public final void onBackPressed() {
        e.a((e) this.a.getValue());
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AnnieXDefaultActivity.class.getName()));
    L5:
        super.onDestroy();
        ja.b r0 = ((e) this.a.getValue()).a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
        r0 = null;
    L8:
        r0.release();
    }

    public AnnieXDefaultActivity() {
        this.a = LazyKt.lazy(AnnieXDefaultActivity$annieXPageHelper$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L25
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L25
    L8:
        ((e) this.a.getValue()).getClass();
        if (r10 == null) goto L23;
        Map r0 = x26.a.a;
        w26.g r1 = (w26.g) x26.a.a(w26.g.class);
        if (r1 == null) goto L17;
        w26.e r11 = (w26.e) r1.n0(w26.e.class);
        if (r11 == null) goto L17;
        Boolean r12 = r11.d1();
        if (r12 == null) goto L17;
        boolean r13 = r12.booleanValue();
    L18:
        if (r13 == false) goto L23;
        r10.remove("android:fragments");
        r10.remove("android:support:fragments");
        Bundle r14 = r10.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        if (r14 == null) goto L23;
        r14.remove("android:support:fragments");
    L17:
        r13 = true;
    L23:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r10);
        setContentView(2131558442);
        ((e) this.a.getValue()).b(this, getIntent());
    }
}
