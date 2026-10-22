package com.obric.assistant.interaction.impl.activityresult;

import android.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import me.ele.lancet.base.annotations.Skip;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u000f\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0015J\b\u0010\u0015\u001a\u00020\u0012H\u0014J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00070\u00070\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/interaction/impl/activityresult/ActivityResultHelperActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "requestId", "", "targetIntent", "Landroid/content/Intent;", "isResultHandled", "", "launchDispatched", "activityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "systemEventReceiver", "com/obric/assistant/interaction/impl/activityresult/ActivityResultHelperActivity$systemEventReceiver$1", "Lcom/obric/assistant/interaction/impl/activityresult/ActivityResultHelperActivity$systemEventReceiver$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "handleSuccess", "data", "handleCancel", WindowEvent.Params.REASON, "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityResultHelperActivity extends FragmentActivity {
    public static final Companion Companion = null;
    public static final String KEY_INTENT = "key_target_intent";
    public static final String KEY_REQUEST_ID = "key_request_id";
    private final ActivityResultLauncher<Intent> activityLauncher;
    private boolean isResultHandled;
    private boolean launchDispatched;
    private String requestId;
    private final ActivityResultHelperActivity$systemEventReceiver$1 systemEventReceiver;
    private Intent targetIntent;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/impl/activityresult/ActivityResultHelperActivity$Companion;", "", "<init>", "()V", "KEY_INTENT", "", "KEY_REQUEST_ID", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void y1(ActivityResultHelperActivity r0, ActivityResult r1) {
        activityLauncher$lambda$0(r0, r1);
    }

    public void com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity__finish$___twin___() {
        super.finish();
    }

    public void com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity__onStop$___twin___() {
        super.onStop();
    }

    public void finish() {
        com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void onCreate(Bundle r1) {
        com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public void onStop() {
        com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.interaction.impl.activityresult.ActivityResultHelperActivity$systemEventReceiver$1] */
    public ActivityResultHelperActivity() {
        this.activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new c(this));
        this.systemEventReceiver = new ActivityResultHelperActivity$systemEventReceiver$1(this);
    }

    public void onDestroy() {
        super.onDestroy();
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this, this.systemEventReceiver);     // Catch: Exception -> L5
    L7:
        if (this.isResultHandled == true) goto L12;
        ActivityResultHelperImpl.Companion.dispatchCancel$impl_mainlandRelease(this.requestId);
        return;
    }

    public void onResume() {
        super.onResume();
        if (this.launchDispatched == false) goto L5;
        return;
    L5:
        if (this.isResultHandled == true) goto L24;
        Intent r0 = this.targetIntent;
        if (r0 != null) goto L10;
    L18:
        finish();
        return;
    L10:
        if (this.requestId == null) goto L18;
        this.launchDispatched = true;
        this.activityLauncher.launch(r0);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        handleCancel("Launch Failed: " + e.getMessage());
        return;
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ActivityResultHelperActivity r1) {
        r1.com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(ActivityResultHelperActivity r11) {
        r11.com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity__finish$___twin___();
        if ((r11 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ActivityResultHelperActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map<Activity, Long> r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = r5.get(r11);     // Catch: Throwable -> L50
        if (r6 != null) goto L10;
    L13:
        r5.put(r11, Long.valueOf(r3));     // Catch: Throwable -> L50
        monitor-exit(r5);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L16:
        if (r11.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L20;
        r2.i("ActivityLancet", "quit !resume, current state = " + r11.getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        return;
    L20:
        if (r11.isFinishing() == true) goto L24;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        return;
    L24:
        if (ActivityStartBehavior.isInternalActivityConsumed(r11) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        return;
    L28:
        if (ActivityLancet.isOnlyActivityInTask(r11) == true) goto L32;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        return;
    L32:
        if (ActivityLancet.isExcludedActivity(r11) == false) goto L36;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        return;
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        return;
    L38:
        Intent r1 = r11.getPackageManager().getLaunchIntentForPackage(r11.getPackageName());     // Catch: Throwable -> L47
        if (r1 != null) goto L41;
        return;
    L41:
        r1.addFlags(268435456);     // Catch: Throwable -> L47
        r1.addFlags(UiType.FLAG_REMOTE_CARD);     // Catch: Throwable -> L47
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r11);     // Catch: Throwable -> L47
        r11.startActivity(r1);     // Catch: Throwable -> L44
        r11.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        return;
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }

    private final void handleCancel(String r2) {
        if (this.isResultHandled == true) goto L5;
        this.isResultHandled = true;
        ActivityResultHelperImpl.Companion.dispatchCancel$impl_mainlandRelease(this.requestId);
    L5:
        finish();
    }

    private final void handleSuccess(Intent r3) {
        if (this.isResultHandled == true) goto L5;
        this.isResultHandled = true;
        ActivityResultHelperImpl.Companion.dispatchSuccess$impl_mainlandRelease(this.requestId, r3);
    L5:
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity__onCreate$___twin___(Bundle r9) {
        super.onCreate(r9);
        this.requestId = getIntent().getStringExtra(KEY_REQUEST_ID);
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 33) goto L5;
        Intent r0 = (Intent) getIntent().getParcelableExtra(KEY_INTENT, Intent.class);
    L6:
        this.targetIntent = r0;
        if (r0 != null) goto L9;
    L18:
        finish();
        return;
    L9:
        if (this.requestId == null) goto L18;
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L14;
        setShowWhenLocked(false);
    L14:
        IntentFilter r4 = new IntentFilter();
        r4.addAction("android.intent.action.SCREEN_OFF");
        r4.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        if (r10 < 33) goto L20;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.systemEventReceiver, r4, "android.permission.WRITE_SETTINGS", t0.a, 2);
        return;
    L20:
        return;
    L5:
        r0 = (Intent) getIntent().getParcelableExtra(KEY_INTENT);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(ActivityResultHelperActivity r1, BroadcastReceiver r2) {
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r1.unregisterReceiver(r2);
        return;
    L14:
    L8:
        e = move-exception;
        if (r2 == null) goto L11;
        Npth.addTag("unregisterReceiver", r2.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L16;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    public static final /* synthetic */ void access$handleCancel(ActivityResultHelperActivity r0, String r1) {
        r0.handleCancel(r1);
    }

    private static final void activityLauncher$lambda$0(ActivityResultHelperActivity r2, ActivityResult r3) {
        if (r3.getResultCode() != (-1)) goto L5;
        r2.handleSuccess(r3.getData());
        return;
    L5:
        r2.handleCancel("User Canceled or Back Pressed");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(ActivityResultHelperActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity__onCreate$___twin___(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_obric_assistant_interaction_impl_activityresult_ActivityResultHelperActivity_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ActivityResultHelperActivity r8, BroadcastReceiver r9, IntentFilter r10, String r11, Handler r12, int r13) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L32:
    L26:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
        throw e;
    L30:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10, r11, r12, r13);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, r13, r11, r12, 5, r8);     // Catch: Exception -> L26
        int r1 = r0.result;     // Catch: Exception -> L26
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10, r11, r12, r13);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10, r11, r12, r13);
    L25:
        return r8.registerReceiver(r9, r10, r11, r12, r13);
    }
}
