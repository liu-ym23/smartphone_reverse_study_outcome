package com.obric.assistant.interaction.impl.activityresult;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.service.ActivityProxyListener;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u000e\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0015J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0014J+\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0002\u0010\u001eJ\"\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006'"}, d2 = {"Lcom/obric/assistant/interaction/impl/activityresult/ActivityResultProxyActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "mListener", "Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;", "activityReadyDispatched", "", "fragmentLifecycleCallbacksRegistered", "localTerminalGate", "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyTerminalGate;", "onResumeCount", "", "fragmentLifecycleCallbacks", "com/obric/assistant/interaction/impl/activityresult/ActivityResultProxyActivity$fragmentLifecycleCallbacks$1", "Lcom/obric/assistant/interaction/impl/activityresult/ActivityResultProxyActivity$fragmentLifecycleCallbacks$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "checkFinishIfNeed", "onDestroy", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "shouldDispatchResult", "listener", "dispatchDestroyCancel", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityResultProxyActivity extends FragmentActivity {
    public static final Companion Companion = null;
    private static final String TAG = "ActivityResultProxyActivity";
    private boolean activityReadyDispatched;
    private final ActivityResultProxyActivity$fragmentLifecycleCallbacks$1 fragmentLifecycleCallbacks;
    private boolean fragmentLifecycleCallbacksRegistered;
    private final ActivityProxyTerminalGate localTerminalGate;
    private ActivityProxyListener mListener;
    private int onResumeCount;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/activityresult/ActivityResultProxyActivity$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public void com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity__finish$___twin___() {
        super.finish();
    }

    public void com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity__onStop$___twin___() {
        super.onStop();
    }

    public void finish() {
        com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void onCreate(Bundle r1) {
        com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public void onDestroy() {
        super.onDestroy();     // Catch: Throwable -> L11
        if (this.fragmentLifecycleCallbacksRegistered == false) goto L6;
        getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this.fragmentLifecycleCallbacks);     // Catch: Throwable -> L11
        this.fragmentLifecycleCallbacksRegistered = false;     // Catch: Throwable -> L11
    L6:
        ActivityProxyListener r1 = this.mListener;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        dispatchDestroyCancel(r1);     // Catch: Throwable -> L11
    L9:
        this.mListener = null;
        return;
    L11:
        th = move-exception;
        this.mListener = null;
        throw th;
    }

    public void onStop() {
        com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.interaction.impl.activityresult.ActivityResultProxyActivity$fragmentLifecycleCallbacks$1] */
    public ActivityResultProxyActivity() {
        this.localTerminalGate = new ActivityProxyTerminalGate();
        this.fragmentLifecycleCallbacks = new ActivityResultProxyActivity$fragmentLifecycleCallbacks$1(this);
    }

    private final void checkFinishIfNeed() {
        if (getSupportFragmentManager().getFragments().size() > 0) goto L6;
        FLogger.a.i(String.valueOf(Reflection.getOrCreateKotlinClass(ActivityResultProxyActivity.class).getSimpleName()), "finishIfNeed onResumeCount:" + this.onResumeCount + " finish this activity");
        finish();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        super.onResume();
        int r0 = this.onResumeCount + 1;
        this.onResumeCount = r0;
        if (r0 < 2) goto L6;
        checkFinishIfNeed();
    L6:
        if (this.activityReadyDispatched == false) goto L8;
        return;
    L8:
        ActivityProxyListener r1 = this.mListener;
        if (r1 != null) goto L12;
        finish();
        return;
    L12:
        this.activityReadyDispatched = true;
        r1.onActivityReady(this);
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final /* synthetic */ void access$checkFinishIfNeed(ActivityResultProxyActivity r0) {
        r0.checkFinishIfNeed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ActivityResultProxyActivity r1) {
        r1.com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(ActivityResultProxyActivity r11) {
        r11.com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity__finish$___twin___();
        if ((r11 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ActivityResultProxyActivity.class.getName()));
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

    private final void dispatchDestroyCancel(ActivityProxyListener r4) {
        ActivityProxyTerminalOwner r1 = null;
        if ((r4 instanceof ActivityProxyCancelCallback) == false) goto L5;
        ActivityProxyCancelCallback r0 = (ActivityProxyCancelCallback) r4;
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if ((r4 instanceof ActivityProxyTerminalOwner) == false) goto L11;
        r1 = (ActivityProxyTerminalOwner) r4;
    L11:
        if (r1 == null) goto L17;
        if (r1.getProxyTerminalGate().isCompleted() == true) goto L20;
        r0.onProxyCanceled(ActivityProxyCancelReason.PROXY_DESTROYED_BEFORE_RESULT);
        return;
    L20:
        return;
    L17:
        if (this.localTerminalGate.tryComplete() == false) goto L21;
        r0.onProxyCanceled(ActivityProxyCancelReason.PROXY_DESTROYED_BEFORE_RESULT);
        return;
    L21:
        return;
    L5:
        r0 = null;
        goto L6
    }

    private final boolean shouldDispatchResult(ActivityProxyListener r2) {
        if ((r2 instanceof ActivityProxyTerminalOwner) == false) goto L5;
        ActivityProxyTerminalOwner r3 = (ActivityProxyTerminalOwner) r2;
    L6:
        if (r3 == null) goto L10;
        return true;
    L10:
        return this.localTerminalGate.tryComplete();
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        Intent r7 = getIntent();
        long r0 = -1;
        if (r7 == null) goto L6;
        r0 = r7.getLongExtra(ActivityProxyRequestStoreKt.EXTRA_PROXY_REQUEST_TOKEN, -1);
    L6:
        if (r0 > 0) goto L9;
        FLogger.a.w(TAG, "finish because proxy request token is invalid: " + r0);
        finish();
        return;
    L9:
        ActivityProxyListener r2 = ActivityResultHelperImpl.Companion.consumeListener$impl_mainlandRelease(r0);
        this.mListener = r2;
        if (r2 != null) goto L14;
        FLogger.a.w(TAG, "finish because proxy request listener is missing, token=" + r0);
        finish();
        return;
    L14:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L16;
        setShowWhenLocked(false);
    L16:
        getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.fragmentLifecycleCallbacks, true);
        this.fragmentLifecycleCallbacksRegistered = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(ActivityResultProxyActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity__onCreate$___twin___(r2);
    }

    public void onActivityResult(int r4, int r5, Intent r6) {
        super.onActivityResult(r4, r5, r6);
        ActivityProxyListener r0 = this.mListener;
        if (r0 != null) goto L15;
        finish();
        return;
    L15:
    L12:
        th = move-exception;
        this.mListener = null;
        finish();
        throw th;
    L8:
        if (shouldDispatchResult(r0) == false) goto L10;
        r0.onActivityResult(r4, r5, r6);     // Catch: Throwable -> L12
    L10:
        this.mListener = null;
        finish();
    }

    public void onRequestPermissionsResult(int r5, String[] r6, int[] r7) {
        Intrinsics.checkNotNullParameter(r6, "permissions");
        Intrinsics.checkNotNullParameter(r7, "grantResults");
        ActivityProxyListener r0 = this.mListener;
        if (r0 != null) goto L15;
        com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity_androidx_fragment_app_FragmentActivity_onRequestPermissionsResult_super(this, r5, r6, r7);
        return;
    L15:
    L12:
        th = move-exception;
        this.mListener = null;
        finish();
        throw th;
    L8:
        if (shouldDispatchResult(r0) == false) goto L10;
        r0.onActivityResult(r5, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", r6).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", r7));     // Catch: Throwable -> L12
    L10:
        this.mListener = null;
        finish();
    }

    private static void com_obric_assistant_interaction_impl_activityresult_ActivityResultProxyActivity_androidx_fragment_app_FragmentActivity_onRequestPermissionsResult_super(FragmentActivity r18, int r19, String[] r20, int[] r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19), r20, r21};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102611);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102611, "androidx/fragment/app/FragmentActivity", "onRequestPermissionsResult", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        super.onRequestPermissionsResult(r19, r20, r21);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
