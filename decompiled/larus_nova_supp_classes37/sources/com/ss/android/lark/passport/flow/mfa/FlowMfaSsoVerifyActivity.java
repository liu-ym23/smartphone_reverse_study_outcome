package com.ss.android.lark.passport.flow.mfa;

import android.R;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.flow.passport.ui.widget.common.FlowBaseActivity;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.idp_auth.FlowIdpLoginResult;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\tH\u0014J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0014J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowMfaSsoVerifyActivity;", "Lcom/ss/android/lark/flow/passport/ui/widget/common/FlowBaseActivity;", "<init>", "()V", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/ss/android/lark/passport/flow/mfa/FlowMfaFlowSession;", "previousUiListener", "Lkotlin/Function1;", "Lcom/ss/android/lark/passport/flow/mfa/FlowMfaFlowUiResult;", "", "ownsUiListener", "", "uiListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "finish", "onDestroy", "handleFlowResult", "result", "restoreUiListener", "readLoginResult", "Lcom/ss/android/lark/passport/flow/idp_auth/FlowIdpLoginResult;", "Landroid/content/Intent;", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class FlowMfaSsoVerifyActivity extends FlowBaseActivity {
    public static final a h = null;
    public FlowMfaFlowSession d;
    public Function1<? super j, Unit> e;
    public boolean f;
    public final Function1<j, Unit> g;

    public static final class a {
        public a() {
        }
    }

    static {
        h = new a();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0115 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        PassportLog.d("FlowMfaSsoVerify", "finish: close native BIDP loading page");
        z1();
        y1();
        super.finish();
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(FlowMfaSsoVerifyActivity.class.getName()));
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

    public final void onDestroy() {
        PassportLog.d("FlowMfaSsoVerify", "onDestroy");
        super/*androidx.fragment.app.FragmentActivity*/.onDestroy();
    }

    public final void z1() {
        if (this.f == true) goto L5;
        return;
    L5:
        this.f = false;
        FlowMfaFlowSession r0 = this.d;
        if (r0 == null) goto L13;
        Function1<j, Unit> r1 = this.g;
        Function1<? super j, Unit> r2 = this.e;
        Intrinsics.checkNotNullParameter(r1, "listener");
        AtomicReference<Function1<j, Unit>> r3 = r0.i;
    L9:
        if (r3.compareAndSet(r1, (Function1<j, Unit>) r2) == true) goto L13;
        if (r3.get() == r1) goto L9;
    L13:
        this.e = null;
    }

    public FlowMfaSsoVerifyActivity() {
        this.g = new FlowMfaSsoVerifyActivity$uiListener$1(this);
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        PassportLog.d("FlowMfaSsoVerify", "onResume: native BIDP loading page visible");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.fragment.app.FragmentActivity*/.onStop();
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
    public final void onCreate(Bundle r9) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L65
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L65
    L8:
        boolean r0 = false;
        overridePendingTransition(0, 0);
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r9);
        PassportLog.d("FlowMfaSsoVerify", "onCreate: start external browser BIDP callback");
        setContentView(2131561143);
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L11;
        showLoading();
    L12:
        String r1 = getIntent().getStringExtra("flow_mfa_flow_id");
        Intent r2 = getIntent();
        Boolean r4 = null;
        if (Build.VERSION.SDK_INT < 33) goto L15;
        FlowIdpLoginResult r3 = (FlowIdpLoginResult) r2.getSerializableExtra("flow_mfa_login_result", FlowIdpLoginResult.class);
    L19:
        if (r1 == null) goto L21;
        FlowMfaFlowSession r5 = o.a(r1);
    L23:
        if (r1 != null) goto L25;
    L28:
        boolean r6 = true;
    L29:
        if (r6 == true) goto L46;
        if (r3 == null) goto L46;
        if (r5 == null) goto L46;
        if (r5.q() == true) goto L46;
        PassportLog.d("FlowMfaSsoVerify", "external browser BIDP session resolved, bind callback activity");
        this.d = r5;
        if (FlowMfaFlowSession.p(this) == true) goto L38;
        PassportLog.b("FlowMfaSession", "bind BIDP callback activity failed: activity unavailable");
    L39:
        Function1<j, Unit> r7 = this.g;
        Intrinsics.checkNotNullParameter(r7, "listener");
        this.e = r5.i.getAndSet(r7);
        this.f = true;
        PassportLog.d("FlowMfaSsoVerify", "dispatch external browser BIDP result start");
        Intrinsics.checkNotNullParameter(r3, "model");
        if (r5.v.get().a == ExternalBidpCallbackPhase.DISPATCHING) goto L42;
        PassportLog.b("FlowMfaSession", "dispatch external browser BIDP result failed: callback not reserved");
    L43:
        if (r0 == true) goto L45;
        PassportLog.b("FlowMfaSsoVerify", "handle external browser BIDP result failed: dispatch rejected");
        finish();
        return;
    L45:
        PassportLog.d("FlowMfaSsoVerify", "external browser BIDP result accepted for dispatch");
        return;
    L42:
        r0 = r5.n(r3, null, FlowMfaBidpWebActivityType.EXTERNAL_BROWSER_LOADING, "external browser login result");
        goto L43
    L38:
        r5.o.set(new WeakReference(this));
        PassportLog.d("FlowMfaSession", "bind BIDP callback activity success: activity=".concat("FlowMfaSsoVerifyActivity"));
    L46:
        StringBuilder r8 = new StringBuilder("handle external browser BIDP result failed: hasFlowId=");
        if (r1 != null) goto L49;
    L52:
        boolean r10 = true;
    L53:
        r8.append(!r10);
        r8.append(", hasLoginResult=");
        if (r3 == null) goto L56;
        boolean r11 = true;
    L57:
        r8.append(r11);
        r8.append(", hasSession=");
        if (r5 == null) goto L60;
        r0 = true;
    L60:
        r8.append(r0);
        r8.append(", isTerminal=");
        if (r5 == null) goto L63;
        r4 = Boolean.valueOf(r5.q());
    L63:
        r8.append(r4);
        PassportLog.b("FlowMfaSsoVerify", r8.toString());
        finish();
        return;
    L56:
        r11 = false;
        goto L57
    L49:
        if (StringsKt.isBlank(r1) == true) goto L52;
        r10 = false;
        goto L53
    L25:
        if (StringsKt.isBlank(r1) == true) goto L28;
        r6 = false;
        goto L29
    L21:
        r5 = null;
        goto L23
    L15:
        Serializable r12 = r2.getSerializableExtra("flow_mfa_login_result");
        if ((r12 instanceof FlowIdpLoginResult) == false) goto L18;
        r3 = (FlowIdpLoginResult) r12;
        goto L19
    L18:
        r3 = null;
        goto L19
    L11:
        UICallbackExecutor.post(new com.ss.android.lark.flow.passport.ui.widget.common.d(this));
        goto L12
    }
}
