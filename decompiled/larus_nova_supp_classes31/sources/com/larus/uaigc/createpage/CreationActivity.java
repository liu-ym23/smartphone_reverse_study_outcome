package com.larus.uaigc.createpage;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationInstructionService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.chat.ObricChatUIDelegate;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 &2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001&B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000fH\u0014J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\"\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\rH\u0016J\u0012\u0010$\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010%\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006'"}, d2 = {"Lcom/larus/uaigc/createpage/CreationActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Lcom/larus/uaigc/bean/createpage/ICreationActivity;", "Lcom/larus/uaigc/bean/createpage/ICreationAvatarAbility;", "<init>", "()V", "fg", "Landroidx/fragment/app/Fragment;", "legacyFg", "Lcom/larus/uaigc/createpage/CreationFragment;", "getLegacyFg", "()Lcom/larus/uaigc/createpage/CreationFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "createCreationFragment", "args", "onSaveInstanceState", "outState", "onBackPressed", "getBackgroundResource", "", "needAdaptStatusBarPadding", "", "needAdaptNavigationBarPadding", "getNavigationBarPaddingOnWindowInsets", "imeVisible", "onWindowFocusChanged", "hasFocus", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "finish", "onUploadDigitalAvatarResult", "onDeleteDigitalAvatarResult", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationActivity extends FlowCommonAppCompatActivity implements ny9.e, ny9.f {
    public CreationFragment g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.CreationActivity$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.CreationActivity$onCreate$1", f = "CreationActivity.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Fragment $creationFragment;
        int label;
        final /* synthetic */ CreationActivity this$0;

        public AnonymousClass1(CreationActivity r1, Fragment r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$creationFragment = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$creationFragment, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.app.Activity, com.larus.uaigc.createpage.CreationActivity] */
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            CreationActivity r6 = this.this$0;
            Fragment r2 = this.$creationFragment;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
            INVOKEVIRTUAL_com_larus_uaigc_createpage_CreationActivity$onCreate$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r6.getSupportFragmentManager().beginTransaction(), 2131373275, r2).commitNowAllowingStateLoss();     // Catch: Throwable -> L14
            Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        L16:
            CreationActivity r4 = this.this$0;
            Throwable r8 = Result.exceptionOrNull-impl(r7);
            if (r8 == null) goto L20;
            FLogger.a.e("CreationActivity", "commit CreationFragment failed", r8);
            r4.finish();
        L20:
            return Unit.INSTANCE;
        L14:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ICreationInstructionService.Companion r10 = ICreationInstructionService.a;
            ?? r11 = this.this$0;
            Intent r12 = r11.getIntent();
            this.label = 1;
            if (r10.B(r11, r12, this) != r0) goto L11;
            return r0;
        }

        public static FragmentTransaction INVOKEVIRTUAL_com_larus_uaigc_createpage_CreationActivity$onCreate$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
            return r2;
        L6:
            return r2.replace(r3, r4);
        }
    }

    static {
    }

    public final boolean K1() {
        return false;
    }

    public final boolean H1() {
        return !ObricChatUIDelegate.b.m();
    }

    public final CreationFragment O1() {
        CreationFragment r0 = this.g;
        if ((r0 instanceof CreationFragment) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(CreationActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int C1() {
        if (getIntent().getBooleanExtra("is_enter_template", true) == false) goto L7;
        return v19.c.b(2130970529, this, 2131102529);
    L7:
        return getIntent().getIntExtra("bg_color_resource", v19.c.b(2130970531, this, 2131102535));
    }

    /* JADX INFO: Removed unreachable split cross block B:56:0x0127 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        CreationFragment r2 = O1();
        if (r2 == null) goto L5;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r2), Dispatchers.getMain(), null, new CreationFragment$onActivityFinish$1(r2, null), 2, null);
    L5:
        overridePendingTransition(0, 2130772402);
        if ((this instanceof ChatWindowActivity) == true) goto L47;
        FLogger r3 = FLogger.a;
        r3.i("ActivityLancet", "finish ".concat(CreationActivity.class.getName()));
        long r4 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L48
        if (r6 != null) goto L13;
    L16:
        r5.put(this, Long.valueOf(r4));     // Catch: Throwable -> L48
        monitor-exit(r5);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L53:
        return;
    L19:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r3.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L53
    L22:
        if (isFinishing() == true) goto L25;
        r3.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L53
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r3.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L53
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r3.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L53
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r3.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L53
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L53
    L36:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r1 == null) goto L53;
        r1.addFlags(268435456);     // Catch: Throwable -> L45
        r1.addFlags(2097152);     // Catch: Throwable -> L45
        r3.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r1);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L53
    L13:
        if ((r4 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    public final void onBackPressed() {
        CreationFragment r0 = O1();
        if (r0 == null) goto L5;
        r0.kB(false);
        return;
    L5:
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        N1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public CreationActivity() {
    }

    public static View N1(Window r3) {
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
    public final int F1(boolean r3) {
        if (r3 == false) goto L7;
        if (getIntent().getBooleanExtra("enable_compact_fragment_forseti", false) == false) goto L7;
        return 0;
    L7:
        return com.larus.utils.u.b(this);
    }

    @Override // ny9.f
    public final void M8(Intent r2) {
        CreationFragment r0 = O1();
        if (r0 == null) goto L8;
        ys8.a r1 = (ys8.a) r0.j.getValue();
        if (r1 == null) goto L9;
        r1.mI(r2);
        return;
    L9:
        return;
    }

    @Override // ny9.f
    public final void N8(Intent r1) {
        CreationFragment r2 = O1();
        if (r2 == null) goto L8;
        ys8.a r3 = (ys8.a) r2.j.getValue();
        if (r3 == null) goto L9;
        r3.JI();
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r9) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r9);
        setContentView(2131561787);
        Window r10 = getWindow();
        if (r10 == null) goto L13;
        View r11 = N1(r10);
    L14:
        setRootView(r11);
        L1();
        Bundle r12 = getIntent().getExtras();
        CreationFragment r1 = new CreationFragment();
        r1.setArguments(r12);
        this.g = r1;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(this, r1, null), 2, null);
        if (ObricChatUIDelegate.b.m() == true) goto L24;
        Window r13 = getWindow();
        if (r13 == null) goto L25;
        View r14 = N1(r13);
        if (r14 == null) goto L26;
        int r0 = com.larus.utils.u.b(this);
        int r2 = r14.getPaddingStart();
        int r3 = r14.getPaddingTop();
        int r4 = r14.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r14.getClass().getSimpleName() + ",source:CreationActivity,start:" + r2 + ",top:" + r3 + ",end:" + r4 + ",bottom:" + r0);
        r14.setPaddingRelative(r2, r3, r4, r0);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L13:
        r11 = null;
        goto L14
    }

    public final void onSaveInstanceState(Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "outState");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        getSavedStateRegistry().unregisterSavedStateProvider("android:support:fragments");     // Catch: Throwable -> L5
        super.onSaveInstanceState(r4);     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L14;
        FLogger.a.e("CreationActivity", " onSaveInstanceState error", r6);
        finish();
        return;
    L14:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onWindowFocusChanged(boolean r5) {
        super/*android.app.Activity*/.onWindowFocusChanged(r5);
        CreationFragment r0 = O1();
        if (r0 == null) goto L31;
        ny9.s r1 = r0.V90();
        if (r1 == null) goto L7;
        com.larus.bmhome.actionbar.model.r r2 = r1.k();
    L8:
        if (r5 == true) goto L10;
        return;
    L10:
        if (r2 == null) goto L17;
        Integer r3 = r2.a;
        if (r3 == null) goto L17;
        if (r3.intValue() != 28) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L33;
        FragmentActivity r6 = r0.getActivity();
        if (r6 == null) goto L34;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L35;
        View r8 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L28;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r9 = ThreadMethodProxy.currentThread();
        if (r9 == com.larus.home.impl.utils.c.a) goto L28;
        com.larus.home.impl.utils.c.a(r9, "getDecorView");
    L28:
        if (r8 == null) goto L36;
        r8.setPadding(r8.getPaddingLeft(), 0, r8.getPaddingRight(), r8.getPaddingBottom());
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L17:
        r4 = false;
        goto L18
    L7:
        r2 = null;
        goto L8
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        CreationFragment r4 = O1();
        if (r4 == null) goto L8;
        ys8.a r5 = (ys8.a) r4.j.getValue();
        if (r5 == null) goto L9;
        r5.pz(r2, r3);
        return;
    L9:
        return;
    }
}
