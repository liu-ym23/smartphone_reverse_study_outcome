package com.larus.account.saas.jsb.core.auth;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sdk.account.platform.base.ActivityResultHandler;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/jsb/core/auth/ActivityResultAuthProxyActivity;", "Landroid/app/Activity;", "<init>", "()V", "account-saas-jsb-core_release"}, k = 1, mv = {1, 7, 1})
public final class ActivityResultAuthProxyActivity extends Activity {
    public static final /* synthetic */ int d = 0;
    public ActivityResultHandler a;
    public Function0<Unit> b;
    public boolean c;

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    public final void b() {
        if (this.c == false) goto L5;
        return;
    L5:
        this.c = true;
        this.a = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Function0<Unit> r2 = this.b;     // Catch: Throwable -> L12
        if (r2 == null) goto L9;
        r2.invoke();     // Catch: Throwable -> L12
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Result.constructor-impl(r3);     // Catch: Throwable -> L12
    L14:
        this.b = null;
        finish();
        overridePendingTransition(0, 0);
        return;
    L9:
        r3 = null;
    L12:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0110 */
    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ActivityResultAuthProxyActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L48
        if (r6 != null) goto L13;
    L16:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L48
        monitor-exit(r5);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r2.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r1 == null) goto L51;
        r1.addFlags(268435456);     // Catch: Throwable -> L45
        r1.addFlags(2097152);     // Catch: Throwable -> L45
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r1);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        if (this.c == true) goto L14;
        this.c = true;
        this.a = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        Function0<Unit> r2 = this.b;     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        r2.invoke();     // Catch: Throwable -> L11
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(r3);     // Catch: Throwable -> L11
    L13:
        this.b = null;
        goto L14
    L8:
        r3 = null;
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        super.onDestroy();
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

    public ActivityResultAuthProxyActivity() {
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r2);
        ConcurrentHashMap<String, a.C0063a> r3 = a.a;
        Intent r4 = getIntent();
        if (r4 == null) goto L16;
        String r5 = r4.getStringExtra("account_saas_auth_request_id");
        if (r5 == null) goto L16;
        a.C0063a r6 = a.a.remove(r5);
    L17:
        if (r6 != null) goto L24;
        b();
        return;
    L24:
        r6.a.invoke(this);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        r6.b.invoke(th);
        b();
        return;
    L16:
        r6 = null;
        goto L17
    }

    public final void a(ActivityResultHandler r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        if (this.c == false) goto L7;
        if (r3 == null) goto L9;
        r3.invoke();
        return;
    L9:
        return;
    L7:
        this.a = r2;
        this.b = r3;
    }

    @Override // android.app.Activity
    public final void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        ActivityResultHandler r0 = this.a;
        if (r0 == null) goto L6;
        r0.onActivityResult(r2, r3, r4);
        return;
    }
}
