package com.ss.android.lark.conditional.access.nopermission.ui;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.conditional.access.nopermission.manager.DialogInfo;
import com.ss.android.lark.conditional.access.nopermission.manager.SecurityDialogUtil;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0014¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/PopupWindowActivityV2;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Lcom/ss/android/lark/conditional/access/nopermission/ui/IPopupActivity;", "<init>", "()V", "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "popupDialog", "onNewIntent", "intent", "Landroid/content/Intent;", "isDoAnimationWithDefault", BuildConfig.FLAVOR, "finish", "onDestroy", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupWindowActivityV2 extends BaseFragmentActivity implements r {

    public static final class a {
    }

    static {
    }

    public final boolean isDoAnimationWithDefault() {
        return false;
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0124 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        int r2 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PopupDialogActivityV2", hashCode() + ",finish");
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r3 = FLogger.a;
        r3.i("ActivityLancet", "finish ".concat(PopupWindowActivityV2.class.getName()));
        long r4 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r4));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r3.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r3.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r3.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r3.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r3.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(Bridge.TRANSFER_MAX_SIZE);     // Catch: Throwable -> L42
        r3.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r4 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(PopupWindowActivityV2.class.getName()));
    L5:
        super.onDestroy();
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PopupDialogActivityV2", hashCode() + ",onDestroy");
        SecurityDialogUtil.c = null;
        WeakReference<Activity> r1 = SecurityDialogUtil.b;
        if (r1 == null) goto L9;
        r1.clear();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z1() {
        String r2 = getIntent().getStringExtra("traceId");
        if (r2 != null) goto L24;
        r2 = qqb.a.d();
    L24:
        String r4 = qqb.a.d();     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r2, "traceId");     // Catch: Throwable -> L17
        qqb.a.g(r2);     // Catch: Throwable -> L17
        int r3 = ScsLogger.a;     // Catch: Throwable -> L17
        ScsLogger.d("SecurityPolicy_PopupDialogActivityV2", hashCode() + ",popupDialog");     // Catch: Throwable -> L17
        int r5 = getIntent().getIntExtra("DIALOG_TYPE", -1);     // Catch: Throwable -> L17
        InternalSecurityAction r6 = SecurityDialogUtil.c;     // Catch: Throwable -> L17
        ScsLogger.d("SecurityPolicy_PopupDialogActivityV2", "popupDialog, dialogType is " + r5);     // Catch: Throwable -> L17
        if (r5 == (-1)) goto L12;
        if (r6 == null) goto L12;
        finish();     // Catch: Throwable -> L17
    L10:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r4, "traceId");
        qqb.a.g(r4);
        return;
    L12:
        int r0 = getIntent().getIntExtra("popup_title", 2131892673);     // Catch: Throwable -> L17
        int r1 = getIntent().getIntExtra("popup_content", 2131892674);     // Catch: Throwable -> L17
        if (getIntent().getParcelableExtra("popup_action") == null) goto L10;
        if (r6 == null) goto L10;
        int r7 = getIntent().getIntExtra("popup_primary_button", 2131890503);     // Catch: Throwable -> L17
        DialogInfo r8 = new DialogInfo();     // Catch: Throwable -> L17
        r8.a = r0;     // Catch: Throwable -> L17
        r8.b = r1;     // Catch: Throwable -> L17
        r8.c = r7;     // Catch: Throwable -> L17
        Map<String, Integer> r9 = com.ss.android.lark.conditional.access.nopermission.manager.a.a;     // Catch: Throwable -> L17
        com.ss.android.lark.conditional.access.nopermission.manager.a.b(this, r8, r6);     // Catch: Throwable -> L17
    L17:
        th = th;
    L21:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r4, "traceId");
        qqb.a.g(r4);
        throw th;
    L19:
        th = th;
        r4 = BuildConfig.FLAVOR;
        goto L21
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

    public PopupWindowActivityV2() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        overridePendingTransition(0, 0);
        disableColorNavigationBarBeforeOnCreate();
        super.onCreate(r3);
        int r4 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PopupDialogActivityV2", hashCode() + ",onCreate");
        getWindow().setStatusBarColor(0);
        WeakReference<Activity> r5 = SecurityDialogUtil.b;
        if (r5 == null) goto L13;
        Activity r6 = r5.get();
    L14:
        if (r6 == null) goto L16;
        finish();
        return;
    L16:
        SecurityDialogUtil.b = new WeakReference(this);
        z1();
        return;
    L13:
        r6 = null;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNewIntent(Intent r2) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r2);
        int r3 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PopupDialogActivityV2", hashCode() + ",onNewIntent");
        WeakReference<Activity> r4 = SecurityDialogUtil.b;
        if (r4 == null) goto L5;
        Activity r5 = r4.get();
    L6:
        if (r5 != null) goto L9;
        SecurityDialogUtil.b = new WeakReference(this);
        z1();
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
