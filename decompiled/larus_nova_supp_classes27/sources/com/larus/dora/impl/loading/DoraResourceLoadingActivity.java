package com.larus.dora.impl.loading;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.DoraResourceState;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.resource.r;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import m59.b;
import t19.s;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/loading/DoraResourceLoadingActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "resolved", "", "resourceStateCallback", "Lcom/larus/dora/api/IDoraService$ResourceStateCallback;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "getBackgroundResource", "", "handleCurrentResourceState", "handleResourceState", "state", "Lcom/larus/dora/api/DoraResourceState;", "openTargetRoute", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraResourceLoadingActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int i = 0;
    public boolean g;
    public final m59.a h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraResourceState.values().length];
            r0[DoraResourceState.PENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[DoraResourceState.READY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[DoraResourceState.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[DoraResourceState.DISABLED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public final int C1() {
        return 2131102535;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N1() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L7;
        DoraResourceState r1 = r0.S0(DoraEnableScope.G_SERIES);
        if (r1 == null) goto L7;
    L9:
        if (this.g == false) goto L11;
        return;
    L11:
        if (isFinishing() == false) goto L13;
        return;
    L13:
        if (isDestroyed() == true) goto L47;
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L18;
        return;
    L18:
        if (r2 != 2) goto L20;
        this.g = true;
        int r3 = b.a;
        Bundle r4 = getIntent().getExtras();
        Bundle r5 = null;
        if (r4 == null) goto L30;
        String r6 = r4.getString("dora_resource_loading_target_route");
    L31:
        if (r6 == null) goto L40;
        i r7 = SmartRouter.buildRoute(this, r6);
        Bundle r8 = getIntent().getExtras();
        if (r8 == null) goto L37;
        Bundle r9 = r8.getBundle("dora_resource_loading_target_extras");
        if (r9 == null) goto L37;
        r5 = new Bundle(r9);
    L37:
        if (r5 != null) goto L39;
        r5 = new Bundle();
    L39:
        r7.c.putExtras(r5);
        r7.d();
    L40:
        finish();
        return;
    L30:
        r6 = null;
        goto L31
    L20:
        if (r2 != 3) goto L22;
        this.g = true;
        s.a.getClass();
        s.b(this, 2131902866, false);
        finish();
        return;
    L22:
        if (r2 != 4) goto L25;
        this.g = true;
        finish();
        return;
    L25:
        throw new NoWhenBranchMatchedException();
    L47:
        return;
    L7:
        List r10 = r.a;
        r1 = r.c(DoraEnableScope.G_SERIES);
        goto L9
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DoraResourceLoadingActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L5;
        r0.j0(this.h);
    L5:
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L17;
        View r1 = getWindow().getDecorView();     // Catch: Throwable -> L14
        if (c.e == false) goto L12;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L14
        Thread r2 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L14
        if (r2 == c.a) goto L12;
        c.a(r2, "getDecorView");     // Catch: Throwable -> L14
    L12:
        r1.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L14
        return;
    L18:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [m59.a] */
    public DoraResourceLoadingActivity() {
        this.h = new m59.a(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DoraResourceLoadingActivity.class.getName()));
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

    public final void onStart() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStart();
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L5;
        r0.k1(this.h);
    L5:
        N1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        super.onCreate(r2);
        setContentView(2131562291);
        N1();
    }
}
