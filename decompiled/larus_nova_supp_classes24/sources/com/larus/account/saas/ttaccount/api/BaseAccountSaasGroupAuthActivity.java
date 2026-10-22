package com.larus.account.saas.ttaccount.api;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/larus/account/saas/ttaccount/api/BaseAccountSaasGroupAuthActivity;", "Landroid/app/Activity;", "Lcom/larus/account/saas/ttaccount/api/a;", "<init>", "()V", "a", "account-saas-ttaccount-api_release"}, k = 1, mv = {1, 7, 1})
public abstract class BaseAccountSaasGroupAuthActivity extends Activity implements com.larus.account.saas.ttaccount.api.a {
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.account.saas.ttaccount.api.a
    public final void a(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    @Override // com.larus.account.saas.ttaccount.api.a
    public final void c() {
    }

    public boolean e(int r1, Intent r2) {
        if (r1 != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.account.saas.ttaccount.api.a
    public void hideLoading() {
    }

    @Override // com.larus.account.saas.ttaccount.api.a
    public void showLoading() {
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0112 */
    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
    public void onDestroy() {
        ((IAccountGroupAuthServerService) this.a.getValue()).onDestroy(this);
        super.onDestroy();
    }

    public BaseAccountSaasGroupAuthActivity() {
        this.a = LazyKt.lazy(BaseAccountSaasGroupAuthActivity$groupAuthService$2.INSTANCE);
    }

    @Override // com.larus.account.saas.ttaccount.api.a
    public boolean d(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return false;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        super.onCreate(r2);
        ((IAccountGroupAuthServerService) this.a.getValue()).b(this, this);
    }

    @Override // android.app.Activity
    public final void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r2 != 10001) goto L6;
        ((IAccountGroupAuthServerService) this.a.getValue()).a(this, e(r3, r4), null, null);
        return;
    }
}
