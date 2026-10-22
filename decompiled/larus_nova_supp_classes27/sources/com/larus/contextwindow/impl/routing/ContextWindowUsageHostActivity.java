package com.larus.contextwindow.impl.routing;

import android.R;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.contextwindow.api.ContextWindowEnterFrom;
import com.larus.contextwindow.api.ContextWindowEntryRequest;
import com.larus.contextwindow.api.ContextWindowHiddenReason;
import com.larus.contextwindow.api.ContextWindowSnapshot;
import com.larus.contextwindow.impl.ui.d;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import t19.s;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J(\u0010\u001b\u001a\u0004\u0018\u0001H\u001c\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u001d*\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0082\b¢\u0006\u0002\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/contextwindow/impl/routing/ContextWindowUsageHostActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Lcom/larus/contextwindow/impl/ui/ContextWindowUsageSheetDismissListener;", "<init>", "()V", "coldStartResolver", "Lcom/larus/contextwindow/impl/routing/ContextWindowColdStartResolver;", "resolveJob", "Lkotlinx/coroutines/Job;", "resolving", "", "panelShown", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onContextWindowUsageSheetDismissed", "handleIntent", "sourceIntent", "finishUnavailable", "reason", "Lcom/larus/contextwindow/api/ContextWindowHiddenReason;", "enterFrom", "Lcom/larus/contextwindow/api/ContextWindowEnterFrom;", "parcelableExtra", "T", "Landroid/os/Parcelable;", "key", "", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/os/Parcelable;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowUsageHostActivity extends FlowCommonAppCompatActivity implements d {
    public static final /* synthetic */ int k = 0;
    public final ContextWindowColdStartResolver g;
    public Job h;
    public boolean i;
    public boolean j;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.contextwindow.impl.ui.d
    public final void R() {
        if (this.j == true) goto L5;
        return;
    L5:
        if (isChangingConfigurations() == true) goto L9;
        finish();
        return;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ContextWindowUsageHostActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public ContextWindowUsageHostActivity() {
        this.g = new ContextWindowColdStartResolver(0);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ContextWindowUsageHostActivity.class.getName()));
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

    public final void O1(Intent r10) {
        if (this.i == false) goto L5;
        return;
    L5:
        if (this.j == false) goto L8;
        return;
    L8:
        if (r10 != null) goto L10;
        ContextWindowEntryRequest r2 = null;
    L15:
        if (r2 == null) goto L37;
        com.larus.contextwindow.impl.service.a.a.getClass();
        if (com.larus.contextwindow.impl.service.a.b(r2) == false) goto L37;
        y29.b.a.getClass();
        if (y29.b.a() == true) goto L23;
        N1(ContextWindowHiddenReason.FEATURE_OFF, r2.d);
        return;
    L23:
        if (r10 != null) goto L25;
        ContextWindowSnapshot r11 = null;
    L30:
        if (r11 != null) goto L32;
    L35:
        this.i = true;
        this.h = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ContextWindowUsageHostActivity$handleIntent$1(r11, this, r2, null), 3, null);
        return;
    L32:
        if (com.larus.contextwindow.impl.service.a.c(r2, r11) == true) goto L35;
        N1(ContextWindowHiddenReason.USAGE_INVALID, r2.d);
        return;
    L25:
        if (Build.VERSION.SDK_INT < 33) goto L27;
        Parcelable r12 = (Parcelable) r10.getParcelableExtra("context_window_snapshot", ContextWindowSnapshot.class);
    L28:
        r11 = (ContextWindowSnapshot) r12;
        goto L30
    L27:
        r12 = r10.getParcelableExtra("context_window_snapshot");
    L37:
        ContextWindowHiddenReason r13 = ContextWindowHiddenReason.INVALID_CONVERSATION;
        if (r2 == null) goto L41;
        ContextWindowEnterFrom r0 = r2.d;
        if (r0 == null) goto L41;
    L42:
        N1(r13, r0);
        return;
    L41:
        r0 = ContextWindowEnterFrom.UNKNOWN;
        goto L42
    L10:
        if (Build.VERSION.SDK_INT < 33) goto L12;
        Parcelable r3 = (Parcelable) r10.getParcelableExtra("context_window_request", ContextWindowEntryRequest.class);
    L13:
        r2 = (ContextWindowEntryRequest) r3;
        goto L15
    L12:
        r3 = r10.getParcelableExtra("context_window_request");
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r2);
        if (getSupportFragmentManager().findFragmentByTag("ContextWindowUsageSheet") == null) goto L13;
        this.j = true;
        return;
    L13:
        O1(getIntent());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNewIntent(Intent r4) {
        Intrinsics.checkNotNullParameter(r4, "intent");
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r4);
        setIntent(r4);
        if (getSupportFragmentManager().findFragmentByTag("ContextWindowUsageSheet") == null) goto L5;
        return;
    L5:
        Job r0 = this.h;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        this.i = false;
        this.j = false;
        O1(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N1(ContextWindowHiddenReason r8, ContextWindowEnterFrom r9) {
        a39.a.a.getClass();
        a39.a.a(r8, r9);
        s.j(s.a, this, getString(2131901000), null, false, 28);
        finish();
    }
}
