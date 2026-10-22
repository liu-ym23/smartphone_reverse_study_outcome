package com.larus.account.saas.ui.security;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/ui/security/FlowAccountAppealDialogActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "a", "account-saas-ui-android_release"}, k = 1, mv = {1, 7, 1})
public final class FlowAccountAppealDialogActivity extends FragmentActivity {
    public static e48.b d;
    public static Function1<? super e48.a, Unit> e;
    public e48.b a;
    public Function1<? super e48.a, Unit> b;
    public boolean c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.account.saas.ui.security.FlowAccountAppealDialogActivity$onCreate$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<e48.a, Unit> {
        public AnonymousClass1(Object r8) {
            super(1, r8, FlowAccountAppealDialogActivity.class, "onDialogAction", "onDialogAction(Lcom/larus/account/saas/security/model/AccountRiskDialogAction;)V", 0);
        }

        public final void invoke(e48.a r3) {
            Intrinsics.checkNotNullParameter(r3, IP0SubProcess.P0_PROCESS_NAME);
            FlowAccountAppealDialogActivity r0 = (FlowAccountAppealDialogActivity) ((CallableReference) this).receiver;
            e48.b r1 = FlowAccountAppealDialogActivity.d;
            r0.getClass();
            if ((r3 instanceof e48.a.b) == true) goto L11;
            r0.y1(r3);
            return;
        L11:
            r0.y1(r3);     // Catch: Throwable -> L6
            r0.finish();
            return;
        L6:
            th = move-exception;
            r0.finish();
            throw th;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((e48.a) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(FlowAccountAppealDialogActivity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy() {
        if (isFinishing() == false) goto L9;
        y1(e48.a.b.a);
        e48.b r0 = this.a;
        Function1<? super e48.a, Unit> r1 = this.b;
        if (d != r0) goto L9;
        if (e != r1) goto L9;
        d = null;
        e = null;
    L9:
        super.onDestroy();
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

    public FlowAccountAppealDialogActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r3);
        e48.b r4 = d;
        this.a = r4;
        this.b = e;
        if (r4 != null) goto L13;
        com.larus.account.saas.runtime.internal.delegate.a.a.f("FlowAccountAppealDialogActivity", "pending risk info is missing");
        finish();
        return;
    L13:
        b.a(this, r4, new AnonymousClass1(this));
    }

    public final void y1(e48.a r2) {
        if ((r2 instanceof e48.a.b) == true) goto L5;
    L8:
        Function1<? super e48.a, Unit> r0 = this.b;
        if (r0 == null) goto L12;
        r0.invoke(r2);
        return;
    L12:
        return;
    L5:
        if (this.c == false) goto L7;
        return;
    L7:
        this.c = true;
        goto L8
    }
}
