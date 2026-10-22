package com.obric.assistant.privacy.activity;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0014J\b\u0010 \u001a\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/assistant/privacy/activity/ObricLoginRedirectActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "oneLoginLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "privacyLauncher", "doubaoLoginLauncher", "initProductSdkDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "hasStartLogin", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "initFeatureConfig", "handleLoginRequest", "handlePrivacyResult", "resultCode", "", "handlePrivacyRefused", "checkLoginStatus", "checkSystemLoginSupport", "handleOneLoginResult", "handleAccountLoginResult", "data", "onBackPressed", "onDestroy", "requestPortraitSafely", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLoginRedirectActivity extends AppCompatActivity {
    public static final /* synthetic */ int f = 0;
    public ActivityResultLauncher<Intent> a;
    public ActivityResultLauncher<Intent> b;
    public ActivityResultLauncher<Intent> c;
    public final CompletableDeferred<Unit> d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onBackPressed() {
        Intent r0 = new Intent();
        r0.putExtra("extra_error_code", "login_fail");
        setResult(0, r0);
        overridePendingTransition(0, 0);
        finish();
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ObricLoginRedirectActivity.class.getName()));
    L5:
        super.onDestroy();
        FLogger.a.d("TAG_ObricLoginRedirectActivity", this + " onDestroy()");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y1() {
        if (AccountService.a.isLogin().booleanValue() == false) goto L5;
        FLogger.a.i("TAG_ObricLoginRedirectActivity", this + " User is already logged in");
        setResult(-1);
        overridePendingTransition(0, 0);
        finish();
        return;
    L5:
        FLogger.a.i("TAG_ObricLoginRedirectActivity", this + " User is not logged, checkSystemLoginSupport()");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ObricLoginRedirectActivity$initFeatureConfig$1(this, null), 2, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new ObricLoginRedirectActivity$checkSystemLoginSupport$1(this, null), 2, null);
    }

    public ObricLoginRedirectActivity() {
        this.d = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ObricLoginRedirectActivity.class.getName()));
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
    public final void onCreate(Bundle r7) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        v19.f.a(getTheme());
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r7);
        if (Build.VERSION.SDK_INT != 26) goto L13;
        FLogger.a.i("TAG_ObricLoginRedirectActivity", "skip request portrait for translucent activity on Android O");
    L15:
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L17;
        boolean r0 = true;
    L18:
        u.f(this, !r0);
        FLogger r1 = FLogger.a;
        r1.i("TAG_ObricLoginRedirectActivity", this + " onCreate");
        overridePendingTransition(0, 0);
        this.a = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new com.obric.assistant.privacy.activity.a(this));
        this.b = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new b(this));
        this.c = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new c(this));
        if (r7 == null) goto L21;
        boolean r8 = r7.getBoolean("hasStartLogin", false);
    L22:
        this.e = r8;
        if (r8 == true) goto L34;
        r1.i("TAG_ObricLoginRedirectActivity", this + " onCreate() hasStartLogin: false, call handleLoginRequest()");
        this.e = true;
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r9 = ISecPrivacyService.a.a();
        if (r9 == null) goto L27;
        boolean r10 = r9.h();
    L28:
        if (r10 == true) goto L33;
        r1.i("TAG_ObricLoginRedirectActivity", this + " User has not agreed to privacy policy");
        Intent r11 = new Intent(this, ObricPrivacyAgreeActivity.class);
        r11.putExtra("is_set_result", true);
        r11.putExtra("is_kill_privacy_process", false);
        ActivityResultLauncher<Intent> r2 = this.b;
        if (r2 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("privacyLauncher");
        r2 = null;
    L32:
        r2.launch(r11);
        return;
    L33:
        r1.i("TAG_ObricLoginRedirectActivity", this + " User has agreed to privacy policy, checkLoginStatus");
        y1();
        return;
    L27:
        r10 = false;
        goto L28
    L34:
        r1.i("TAG_ObricLoginRedirectActivity", this + " onCreate() hasStartLogin: true, do nothing");
        return;
    L21:
        r8 = false;
        goto L22
    L17:
        r0 = false;
        goto L18
    L13:
        setRequestedOrientation(1);
        goto L15
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(r3);
        r3.putBoolean("hasStartLogin", this.e);
        FLogger.a.i("TAG_ObricLoginRedirectActivity", this + " onSaveInstanceState() hasStartLogin: " + this.e);
    }
}
