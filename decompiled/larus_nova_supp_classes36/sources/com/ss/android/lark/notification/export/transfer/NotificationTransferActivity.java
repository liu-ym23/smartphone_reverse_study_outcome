package com.ss.android.lark.notification.export.transfer;

import android.R;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashSet;
import java.util.Map;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class NotificationTransferActivity extends AppCompatActivity {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        Log.i("NotificationTransferActivity", "onDestroy");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == c.a) goto L9;
        c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public NotificationTransferActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r9) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        Log.i("NotificationTransferActivity", "onCreate");
        Intent r0 = getIntent();
        if (r0 != null) goto L58;
    L14:
        boolean r1 = true;
    L16:
        if (r1 == true) goto L18;
        getIntent().replaceExtras(null);
        Log.w("NotificationTransferActivity", "checkParamsValidity: true");
    L18:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r9);
        Intent r10 = getIntent();
        Intent r4 = (Intent) r10.getParcelableExtra("extra_original_intent");
        if (r4 != null) goto L56;
        Log.e("NotificationTransferActivity", "splashRoute: originalIntent == null, something must be wrong !!!");
    L54:
        finish();
        overridePendingTransition(0, 0);
        return;
    L56:
        r4.setExtrasClassLoader(NotificationClickEvent.class.getClassLoader());     // Catch: Throwable -> L25
        NotificationClickEvent r5 = (NotificationClickEvent) r4.getParcelableExtra("notification_click_event");     // Catch: Throwable -> L25
        if (r5 == null) goto L27;
        r5.g0();     // Catch: Throwable -> L25
    L27:
        Log.i("NotificationTransferActivity", "splashRoute: originalIntent got! Try to start final notification page now!");
        PassportcConvention.e(r4, LarkContext.getApplication());
        if (FeatureGatingModule.getFeatureGatingService().isEnable("key_safe_start_activity_v1") == false) goto L30;
        y1(r4);
        goto L54
    L30:
        if (Build.VERSION.SDK_INT < 36) goto L52;
        r10.setComponent(r4.getComponent());
        r10.replaceExtras(r4.getExtras());
        r10.setFlags(r4.getFlags());
        r10.removeExtra("extra_original_intent");
        ActivityInfo r2 = r4.resolveActivityInfo(getApplicationContext().getPackageManager(), 65536);
        if (r2 != null) goto L34;
    L45:
        Log.i("NotificationTransferActivity", "startActivitySafely: start inner activity");
        Log.i("NotificationTransferActivity", "startActivitySafely: Starting merged intent.");     // Catch: Exception -> L48 SecurityException -> L50
        startActivity(r10);     // Catch: Exception -> L48 SecurityException -> L50
    L50:
        e = move-exception;
        Log.e("NotificationTransferActivity", "startActivitySafely: Still failed after merging intents.", e);
        startActivity(r4);
    L48:
        e = move-exception;
        Log.e("NotificationTransferActivity", "startActivitySafely: Failed to start activity.", e);
        goto L54
    L34:
        if (r2.exported == false) goto L45;
        r10.setFlags(r4.getFlags() & (-196));
        HashSet r3 = new HashSet();
        r3.add("android.intent.action.CHOOSER");
        r3.add("android.intent.action.SEND");
        r3.add("android.intent.action.SEND_MULTIPLE");
        r3.add("android.media.action.IMAGE_CAPTURE");
        r3.add("android.media.action.IMAGE_CAPTURE_SECURE");
        r3.add("android.media.action.VIDEO_CAPTURE");
        if (r3.contains(r4.getAction()) == false) goto L38;
        Log.e("NotificationTransferActivity", "startActivitySafely: Action in blockAllowList, Do Nothing. " + r4.getAction());
        goto L54
    L38:
        Log.i("NotificationTransferActivity", "startActivitySafely: start exported activity");
        Log.i("NotificationTransferActivity", "startActivitySafely: Starting merged intent.");     // Catch: Exception -> L41 SecurityException -> L43
        startActivity(r10);     // Catch: Exception -> L41 SecurityException -> L43
    L43:
        e = move-exception;
        Log.e("NotificationTransferActivity", "startActivitySafely: Still failed after merging intents.", e);
        startActivity(r4);
    L41:
        e = move-exception;
        Log.e("NotificationTransferActivity", "startActivitySafely: Failed to start activity.", e);
        goto L54
    L52:
        y1(r4);
    L25:
        th = move-exception;
        Log.e("NotificationTransferActivity", "splashRoute: notification_click_event failed", th, true);
        goto L27
    L58:
        r0.getIntExtra("checkParamsValidity", 0);     // Catch: Exception -> L15
    L15:
        r1 = false;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y1(Intent r4) {
        ActivityInfo r0 = r4.resolveActivityInfo(getApplicationContext().getPackageManager(), 65536);
        if (r0 != null) goto L5;
    L11:
        Log.i("NotificationTransferActivity", "startActivitySafely: start inner activity");
        startActivity(r4);
        return;
    L5:
        if (r0.exported == false) goto L11;
        r4.setFlags(r4.getFlags() & (-196));
        HashSet r1 = new HashSet();
        r1.add("android.intent.action.CHOOSER");
        r1.add("android.intent.action.SEND");
        r1.add("android.intent.action.SEND_MULTIPLE");
        r1.add("android.media.action.IMAGE_CAPTURE");
        r1.add("android.media.action.IMAGE_CAPTURE_SECURE");
        r1.add("android.media.action.VIDEO_CAPTURE");
        if (r1.contains(r4.getAction()) == false) goto L10;
        Log.e("NotificationTransferActivity", "startActivitySafely: Action in blockAllowList, Do Nothing. " + r4.getAction());
        return;
    L10:
        Log.i("NotificationTransferActivity", "startActivitySafely: start exported activity");
        startActivity(r4);
    }
}
