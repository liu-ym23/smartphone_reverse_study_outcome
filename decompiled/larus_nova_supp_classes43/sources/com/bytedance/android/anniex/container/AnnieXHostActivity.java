package com.bytedance.android.anniex.container;

import android.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0014J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/anniex/container/AnnieXHostActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SCHEMA, "Landroid/net/Uri;", "annieXPageHelper", "Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;", "getAnnieXPageHelper", "()Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;", "annieXPageHelper$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onBackPressed", "finish", "needAdaptNavigationBarPadding", "", "needAdaptStatusBarPadding", "Companion", "ivykit-host-default_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnnieXHostActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int i = 0;
    public Uri g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    public final boolean K1() {
        Uri r0 = this.g;
        if (r0 == null) goto L5;
        String r1 = UriProtector.getQueryParameter(r0, "should_full_screen");
    L7:
        if (Intrinsics.areEqual(r1, "true") == false) goto L9;
    L12:
        boolean r10 = true;
    L14:
        return !r10;
    L9:
        if (Intrinsics.areEqual(r1, "1") == true) goto L12;
        r10 = false;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    /* JADX INFO: Removed unreachable split cross block B:56:0x0119 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        ja.b r10 = ((com.bytedance.android.anniex.container.ui.e) this.h.getValue()).a;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
        r10 = null;
    L5:
        r10.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L47;
        FLogger r11 = FLogger.a;
        r11.i("ActivityLancet", "finish ".concat(AnnieXHostActivity.class.getName()));
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
        com.bytedance.android.anniex.container.ui.e.a((com.bytedance.android.anniex.container.ui.e) this.h.getValue());
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AnnieXHostActivity.class.getName()));
    L5:
        super.onDestroy();
        ja.b r0 = ((com.bytedance.android.anniex.container.ui.e) this.h.getValue()).a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
        r0 = null;
    L8:
        r0.release();
    }

    public AnnieXHostActivity() {
        this.h = LazyKt.lazy(new com.bytedance.android.anniex.container.a());
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        if (r10 == null) goto L12;
        r10.clear();
    L12:
        super.onCreate(r10);
        setContentView(2131558442);
        Intent r11 = getIntent();
        if (r11 == null) goto L15;
        Uri r12 = r11.getData();
    L16:
        this.g = r12;
        ((com.bytedance.android.anniex.container.ui.e) this.h.getValue()).b(this, getIntent());
        return;
    L15:
        r12 = null;
        goto L16
    }
}
