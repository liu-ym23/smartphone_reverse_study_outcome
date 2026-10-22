package com.ss.android.lark.forwardv3;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.activity.ActivityAnimationManager;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z5c.c4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0017J\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/forwardv3/ForwardNewActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "<init>", "()V", "fragment", "Lcom/ss/android/lark/forwardv3/ForwardNewFragment;", "onCreate", "", "bundle", "Landroid/os/Bundle;", "getEnterAnimationConfig", "Lcom/ss/android/lark/base/activity/ActivityAnimationManager$AnimationConfig;", "getExitAnimationConfig", "onBackPressed", "handleBackPressed", "", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardNewActivity extends BaseFragmentActivity {
    public static final /* synthetic */ int b = 0;
    public ForwardNewFragment a;

    public static final class a {
        public a() {
        }

        public static void a(final Context r5, ForwardTemplateNew r6, final int r7, int[] r8, int[] r9, int r10) {
            int r0 = ForwardNewActivity.b;
            if ((r10 & 4) == 0) goto L6;
            r7 = -1;
        L6:
            if ((r10 & 8) == 0) goto L9;
            r8 = null;
        L9:
            if ((r10 & 16) == 0) goto L11;
            r9 = null;
        L11:
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "templateNew");
            final ForsetiNavOptions.DestinationStyle r1 = ForsetiNavOptions.DestinationStyle.FLOAT;
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "templateNew");
            Intrinsics.checkNotNullParameter(r1, "openStyle");
            Log.i("NewForward", "++++++start new forward activity++++++");
            boolean r2 = com.ss.android.lark.forwardv3.utils.b.a("lark.forward.disable_officesdk_available_check", false);
            Log.i("FGUtils", "FG key: lark.forward.disable_officesdk_available_check: " + r2);
            if (r2 == true) goto L18;
            LarkAppContext.Companion.getClass();
            if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L18;
            if (OfficeSDKManager.isAvailable() == true) goto L18;
            Log.w("NewForward", "start aborted: OfficeSDK not available");
            return;
        L18:
            boolean r3 = zib.b.d;
            zib.b.e(c4.d, String.valueOf(r6.getType()));
            long r4 = SystemClock.elapsedRealtime();
            Intent r11 = new Intent();
            r11.putExtra("activity_start_time", r4);
            r11.putExtra("start_by_forward_act", true);
            r11.putExtra("key_intent_forward_template_new", r6);
            if (ForsetiFGHelpers.d() == false) goto L21;
            Log.i("NewForward", "enable responsive component go to ForwardResponsiveActivity");
            r11.setClass(r5, ForwardResponsiveActivity.class).addFlags(65536);
        L34:
            if ((r5 instanceof Activity) == false) goto L36;
            Log.w("NewForward", "source fragment is null, which may affect the processing of returned");
            ((Activity) r5).startActivityForResult(r11, r7);
            return;
        L36:
            Log.w("NewForward", "Starting activity from non-Activity context, adding required flags");
            r11.addFlags(335544320);
            r5.startActivity(r11);
            return;
        L21:
            r11.setClass(r5, ForwardNewActivity.class);
            if (r8 == null) goto L24;
            r11.putExtra("key_intent_transition_anim_in", r8);
        L24:
            if (r9 == null) goto L26;
            r11.putExtra("key_intent_transition_anim_out", r9);
        L26:
            int r12 = com.ss.android.lark.forwardv3.utils.n.a;
            if (com.ss.android.lark.forwardv3.utils.n.f(r5) == false) goto L34;
            if ((r5 instanceof FragmentActivity) == false) goto L34;
            Log.i("NewForward", "enable forseti go to ForwardNewContainerFragment");
            final Bundle r13 = r11.getExtras();
            if (r13 == null) goto L39;
            Log.i("NewForward", "intent contains extras");
            UICallbackExecutor.execute(new ForwardNewActivity$Companion$startInternal$4$1(r5, r13, r1, r7));
            return;
        }
    }

    static {
        new a();
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ForwardNewActivity.class.getName()));
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

    @Deprecated(message = "Deprecated in Java")
    public final void onBackPressed() {
        Log.i("NewForward", "activity on back pressed");
        ForwardNewFragment r0 = this.a;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.Z90() != true) goto L7;
    L8:
        if (r1 == true) goto L11;
        super.onBackPressed();
        return;
    L11:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ForwardNewActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public final ActivityAnimationManager.AnimationConfig getEnterAnimationConfig() {
        Bundle r0 = getIntent().getExtras();
        if (r0 == null) goto L9;
        int[] r1 = r0.getIntArray("key_intent_transition_anim_in");
        if (r1 == null) goto L9;
        return new ActivityAnimationManager.AnimationConfig(r1);
    L9:
        return super.getEnterAnimationConfig();
    }

    public final ActivityAnimationManager.AnimationConfig getExitAnimationConfig() {
        Bundle r0 = getIntent().getExtras();
        if (r0 == null) goto L9;
        int[] r1 = r0.getIntArray("key_intent_transition_anim_out");
        if (r1 == null) goto L9;
        return new ActivityAnimationManager.AnimationConfig(r1);
    L9:
        return super.getEnterAnimationConfig();
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

    public ForwardNewActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L21
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L21
    L8:
        super.onCreate(r5);
        Log.i("NewForward", "activity on create");
        boolean r0 = com.ss.android.lark.forwardv3.utils.b.a("lark.forward.disable_officesdk_available_check", false);
        Log.i("FGUtils", "FG key: lark.forward.disable_officesdk_available_check: " + r0);
        if (r0 == true) goto L15;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L15;
        if (OfficeSDKManager.isAvailable() == true) goto L15;
        Log.w("NewForward", "onCreate aborted: OfficeSDK not available");
        finish();
        return;
    L15:
        int r6 = ForwardNewFragment.t;
        ForwardNewFragment r7 = ForwardNewFragment.a.a(getIntent().getExtras());
        FragmentTransaction r1 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "ForwardNewActivity", R.id.content) == true) goto L19;
        r1.add(R.id.content, r7, "ForwardNewActivity");
    L19:
        r1.commitAllowingStateLoss();
        this.a = r7;
    }
}
