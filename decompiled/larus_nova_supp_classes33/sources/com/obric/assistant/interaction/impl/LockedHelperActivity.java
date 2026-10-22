package com.obric.assistant.interaction.impl;

import android.R;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.JobKt;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0015J\b\u0010\f\u001a\u00020\tH\u0015J\b\u0010\r\u001a\u00020\tH\u0014J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0012\u0010\u0005\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/interaction/impl/LockedHelperActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/obric/assistant/activity/IObricMiddleHelperActivity;", "<init>", "()V", "dismissCallback", "com/obric/assistant/interaction/impl/LockedHelperActivity$dismissCallback$1", "Lcom/obric/assistant/interaction/impl/LockedHelperActivity$dismissCallback$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onDestroy", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LockedHelperActivity extends AppCompatActivity implements lba.a {
    private final LockedHelperActivity$dismissCallback$1 dismissCallback;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.LockedHelperActivity$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.LockedHelperActivity$onCreate$2", f = "ObricKeyguardServiceImpl.kt", i = {0}, l = {469}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KeyguardManager $keyguardManager;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ LockedHelperActivity this$0;

        public AnonymousClass2(LockedHelperActivity r1, KeyguardManager r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$keyguardManager = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$keyguardManager, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0064 -> B:25:0x00e5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0091 -> B:25:0x00e5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00c7 -> B:25:0x00e5). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            int r2 = this.I$1;
            int r3 = this.I$0;
            KeyguardManager r4 = (KeyguardManager) this.L$2;
            lba.a r5 = (LockedHelperActivity) this.L$1;
            CoroutineScope r6 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r13);
            AnonymousClass2 r14 = this;
        L25:
            r2 = r2 + 1;
        L9:
            if (r2 >= r3) goto L27;
            FLogger r7 = FLogger.a;
            r7.i("DismissKeyguardHelper", r5.hashCode() + " repeat checking...");
            if (JobKt.isActive(r6.getCoroutineContext()) == true) goto L14;
            r7.i("DismissKeyguardHelper", r5.hashCode() + " coroutine canceled");
            goto L25
        L14:
            if (r5.isFinishing() == true) goto L24;
            r7.i("DismissKeyguardHelper", r5.hashCode() + " finishing or destroyed");
            CoroutineScopeKt.cancel$default(r6, null, 1, null);
            goto L25
        L16:
            if (r5.isDestroyed() == false) goto L19;
        L24:
            r7.i("DismissKeyguardHelper", r5.hashCode() + " finishing or destroyed");
            CoroutineScopeKt.cancel$default(r6, null, 1, null);
            goto L25
        L19:
            if (r4.isKeyguardLocked() == true) goto L21;
            r7.i("DismissKeyguardHelper", r5.hashCode() + " check keyguard unlocked");
            ObricKeyguardServiceImpl.Companion.onKeyguardDismissSucceeded$impl_mainlandRelease();
            r5.finishAndRemoveTask();
            CoroutineScopeKt.cancel$default(r6, null, 1, null);
            goto L25
        L21:
            r14.L$0 = r6;
            r14.L$1 = r5;
            r14.L$2 = r4;
            r14.I$0 = r3;
            r14.I$1 = r2;
            r14.label = 1;
            if (DelayKt.delay(500, r14) != r0) goto L25;
            return r0;
        L27:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            CoroutineScope r15 = (CoroutineScope) this.L$0;
            r6 = r15;
            r5 = this.this$0;
            r4 = this.$keyguardManager;
            r2 = 0;
            r3 = 3;
            r14 = this;
            goto L9
        }
    }

    public void com_obric_assistant_interaction_impl_LockedHelperActivity__finish$___twin___() {
        super.finish();
    }

    public void com_obric_assistant_interaction_impl_LockedHelperActivity__onStop$___twin___() {
        super.onStop();
    }

    public void finish() {
        com_obric_assistant_interaction_impl_LockedHelperActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void onCreate(Bundle r1) {
        com_obric_assistant_interaction_impl_LockedHelperActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public void onDestroy() {
        com_obric_assistant_interaction_impl_LockedHelperActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    public void onStop() {
        com_obric_assistant_interaction_impl_LockedHelperActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        FLogger.a.i("DismissKeyguardHelper", "onResume " + hashCode());
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        Object r0 = getSystemService("keyguard");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
        if (((KeyguardManager) r0).isKeyguardLocked() == true) goto L6;
        ObricKeyguardServiceImpl.Companion.onKeyguardDismissSucceeded$impl_mainlandRelease();
        finishAndRemoveTask();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.assistant.interaction.impl.LockedHelperActivity$dismissCallback$1] */
    public LockedHelperActivity() {
        this.dismissCallback = new LockedHelperActivity$dismissCallback$1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_obric_assistant_interaction_impl_LockedHelperActivity__onDestroy$___twin___() {
        super.onDestroy();
        FLogger.a.i("DismissKeyguardHelper", "onDestroy " + hashCode());
        ObricKeyguardServiceImpl.Companion.onLockedHelperActivityDestroyed$impl_mainlandRelease(this);
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_LockedHelperActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
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
    public static void com_obric_assistant_interaction_impl_LockedHelperActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(LockedHelperActivity r1) {
        r1.com_obric_assistant_interaction_impl_LockedHelperActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_LockedHelperActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_LockedHelperActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(LockedHelperActivity r11) {
        r11.com_obric_assistant_interaction_impl_LockedHelperActivity__finish$___twin___();
        if ((r11 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(LockedHelperActivity.class.getName()));
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

    public static void com_obric_assistant_interaction_impl_LockedHelperActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(LockedHelperActivity r3) {
        if ((r3 instanceof FragmentActivity) == true) goto L5;
    L7:
        r3.com_obric_assistant_interaction_impl_LockedHelperActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r3) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r3);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r3.getClass().getName()));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_obric_assistant_interaction_impl_LockedHelperActivity__onCreate$___twin___(Bundle r8) {
        f.a(getTheme());
        FLogger.a.i("DismissKeyguardHelper", "onCreate " + hashCode());
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r8);
        setTurnScreenOn(true);
        getWindow().setStatusBarColor(0);
        Window r0 = getWindow();
        if (r0 == null) goto L7;
        View r1 = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_LockedHelperActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r0);
        if (r1 == null) goto L7;
        r1.setBackgroundColor(0);
    L7:
        Window r2 = getWindow();
        if (r2 == null) goto L10;
        r2.setBackgroundDrawable(new ColorDrawable(0));
    L10:
        getWindow().setGravity(8388659);
        Window r3 = getWindow();
        WindowManager.LayoutParams r4 = getWindow().getAttributes();
        r4.width = 1;
        r4.height = 1;
        r4.format = -2;
        r4.flags |= UiType.FLAG_TIMER_CARD;
        r3.setAttributes(r4);
        ObricKeyguardServiceImpl.Companion r9 = ObricKeyguardServiceImpl.Companion;
        r9.onLockedHelperActivityCreated$impl_mainlandRelease(this);
        r9.onRequestDismissKeyguard$impl_mainlandRelease();
        Object r10 = getSystemService("keyguard");
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.app.KeyguardManager");
        KeyguardManager r11 = (KeyguardManager) r10;
        r11.requestDismissKeyguard(this, this.dismissCallback);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass2(this, r11, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(MotionEvent r4) {
        FLogger.a.e("DismissKeyguardHelper", "some terrible things happened, " + r4);
        ObricKeyguardServiceImpl.Companion.onKeyguardDismissSucceeded$impl_mainlandRelease();
        finishAndRemoveTask();
        return super/*android.app.Activity*/.dispatchTouchEvent(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_LockedHelperActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(LockedHelperActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_obric_assistant_interaction_impl_LockedHelperActivity__onCreate$___twin___(r2);
    }
}
