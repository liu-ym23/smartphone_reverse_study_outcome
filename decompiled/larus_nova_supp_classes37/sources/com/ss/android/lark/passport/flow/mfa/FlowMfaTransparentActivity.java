package com.ss.android.lark.passport.flow.mfa;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.PassportApmEvent;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.passport.flow.core.router.PassportRouterResult;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowMfaTransparentActivity;", "Landroid/app/Activity;", "<init>", "()V", "triggerMfa", "", "flowId", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/ss/android/lark/passport/flow/mfa/FlowMfaFlowSession;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "finish", "handleIntent", "handleFlowResult", "result", "Lcom/ss/android/lark/passport/flow/mfa/FlowMfaFlowUiResult;", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class FlowMfaTransparentActivity extends Activity {
    public static final /* synthetic */ int d = 0;
    public boolean a;
    public String b;
    public FlowMfaFlowSession c;

    public static final class a {
        public static void a(Context r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "flowId");
            Intent r0 = new Intent(r3, FlowMfaTransparentActivity.class);
            if (Build.VERSION.SDK_INT >= 34) goto L5;
            r0.addFlags(268435456);
        L5:
            r0.addFlags(67108864);
            r0.addFlags(536870912);
            p.a(r0);
            r0.putExtra("flow_mfa_flow_id", r4);
            r0.putExtra("flow_mfa_completed", true);
            r3.startActivity(r0);
        }
    }

    static {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    @Override // android.app.Activity
    public final void finish() {
        FlowMfaFlowSession r2 = this.c;
        if (r2 == null) goto L5;
        r2.i.set(null);
    L5:
        super.finish();
        overridePendingTransition(0, 0);
        if ((this instanceof FragmentActivity) == true) goto L9;
        return;
    L9:
        if ((this instanceof ChatWindowActivity) == true) goto L63;
        FLogger r3 = FLogger.a;
        r3.i("ActivityLancet", "finish ".concat(FlowMfaTransparentActivity.class.getName()));
        long r4 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L51
        if (r6 != null) goto L16;
    L19:
        r5.put(this, Long.valueOf(r4));     // Catch: Throwable -> L51
        monitor-exit(r5);     // Catch: Throwable -> L51
    L48:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L59:
        return;
    L22:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L25;
        r3.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L48
    L54:
        goto L59
    L25:
        if (isFinishing() == true) goto L28;
        r3.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L48
        goto L54
    L28:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L31;
        r3.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L48
        goto L54
    L31:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L34;
        r3.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L48
        goto L54
    L34:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L37;
        r3.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L48
        goto L54
    L37:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L39;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L48
        goto L54
    L39:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L48
        if (r1 == null) goto L54;
        r1.addFlags(268435456);     // Catch: Throwable -> L48
        r1.addFlags(2097152);     // Catch: Throwable -> L48
        r3.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L48
        startActivity(r1);     // Catch: Throwable -> L45
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L48
        goto L54
    L16:
        if ((r4 - r6.longValue()) >= 800) goto L19;
        monitor-exit(r5);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.a == true) goto L6;
        this.a = true;
        return;
    L6:
        String r1 = this.b;
        if (r1 == null) goto L9;
        FlowMfaFlowSession r2 = o.a(r1);
    L10:
        if (r2 != null) goto L12;
    L72:
        finish();
        return;
    L12:
        if (r2.q() == true) goto L72;
        WeakReference<Activity> r4 = r2.m.get();
        if (r4 == null) goto L17;
        Activity r5 = r4.get();
    L19:
        if (r5 != null) goto L21;
    L23:
        boolean r7 = false;
    L25:
        if (r7 == false) goto L27;
        PassportLog.d("FlowMfaSession", "keep MFA session while internal BIDP web is active: activity=".concat(r5.getClass().getSimpleName()));
        boolean r6 = true;
    L34:
        if (r6 == false) goto L36;
        return;
    L36:
        com.ss.android.lark.passport.flow.mfa.a r8 = r2.v.get();
        int r9 = FlowMfaFlowSession.b.a[r8.a.ordinal()];
        if (r9 == 1) goto L60;
        if (r9 != 2) goto L41;
        com.ss.android.lark.passport.flow.mfa.a r10 = com.ss.android.lark.passport.flow.mfa.a.a(r8, ExternalBidpCallbackPhase.RESUMED_WAITING_CALLBACK);
        AtomicReference<com.ss.android.lark.passport.flow.mfa.a> r11 = r2.v;
    L52:
        if (r11.compareAndSet(r8, r10) == true) goto L53;
        if (r11.get() == r8) goto L52;
        boolean r12 = false;
    L57:
        if (r12 == false) goto L36;
        PassportLog.d("FlowMfaSession", "activity resumed before external BIDP callback: attempt=" + r8.b);
        BuildersKt.launch$default(r2.h, null, null, new FlowMfaFlowSession$scheduleExternalBidpCallbackTimeout$1(r2, r10, null), 3, null);
    L59:
        boolean r13 = true;
    L61:
        if (r13 == false) goto L63;
        return;
    L63:
        int r14 = g.a;
        FlowMfaError r15 = new FlowMfaError(FlowMfaErrorCategory.USER_CANCEL, "MFA flow was cancelled", null, null, null, null, 60, null);
        Intrinsics.checkNotNullParameter(r15, "error");
        com.ss.android.lark.passport.flow.mfa.a r16 = r2.v.get();
        PassportLog.d("FlowMfaSession", "cancel MFA session: externalBidpPhase=" + r16.a + ", attempt=" + r16.b);
        if (r2.g.compareAndSet(false, true) == false) goto L70;
        r2.m(FlowMfaBidpWebActivityType.INTERNAL_AUTH);
        a0 r3 = r2.t.getAndSet(null);
        if (r3 == null) goto L69;
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportFactorCancel$1(r3));
    L69:
        r2.t(null, false);
        r2.e.completeExceptionally(new FlowMfaException(r15));
    L70:
        finish();
        return;
    L53:
        r12 = true;
        goto L57
    L41:
        if (r9 != 3) goto L43;
    L49:
        PassportLog.d("FlowMfaSession", "keep session on activity resume: phase=" + r8.a + ", attempt=" + r8.b);
        goto L59
    L43:
        if (r9 == 4) goto L49;
        if (r9 == 5) goto L49;
        throw new NoWhenBranchMatchedException();
    L60:
        r13 = false;
        goto L61
    L27:
        AtomicReference<WeakReference<Activity>> r17 = r2.m;
    L29:
        if (r17.compareAndSet(r4, null) == true) goto L33;
        if (r17.get() == r4) goto L29;
    L33:
        r6 = false;
        goto L34
    L21:
        if (FlowMfaFlowSession.p(r5) != true) goto L23;
        r7 = true;
        goto L25
    L17:
        r5 = null;
        goto L19
    L9:
        r2 = null;
        goto L10
    }

    @Override // android.app.Activity
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

    public FlowMfaTransparentActivity() {
    }

    public final void a(Intent r4) {
        this.b = r4.getStringExtra("flow_mfa_flow_id");
        boolean r1 = false;
        if (r4.getBooleanExtra("flow_mfa_completed", false) == false) goto L6;
        finish();
        return;
    L6:
        String r5 = this.b;
        String r0 = null;
        if (r5 == null) goto L9;
        FlowMfaFlowSession r2 = o.a(r5);
    L10:
        if (r5 != null) goto L12;
    L13:
        r1 = true;
    L14:
        if (r1 == true) goto L38;
        if (r2 == null) goto L38;
        this.c = r2;
        r2.i.set(new FlowMfaTransparentActivity$handleIntent$1(this));
        if (r2.q() == false) goto L21;
        finish();
        return;
    L21:
        Intrinsics.checkNotNullParameter(this, "activity");
        FlowStep r6 = r2.g();
        if (r6 != null) goto L24;
        PassportRouterResult r7 = null;
    L25:
        if (r7 != null) goto L27;
    L33:
        int r3 = g.a;
        if (r7 == null) goto L36;
        r0 = r7.b;
    L36:
        r2.h(g.e(r0));
        finish();
        return;
    L27:
        if (r7.a() == false) goto L33;
        if (r2.q() == false) goto L40;
        finish();
        return;
    L40:
        return;
    L24:
        r7 = r2.A(this, r6);
    L38:
        finish();
        return;
    L12:
        if (StringsKt.isBlank(r5) == false) goto L14;
    L9:
        r2 = null;
        goto L10
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        overridePendingTransition(0, 0);
        super.onCreate(r2);
        a(getIntent());
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent r1) {
        super.onNewIntent(r1);
        if (r1 != null) goto L6;
        finish();
        return;
    L6:
        setIntent(r1);
        a(r1);
    }
}
