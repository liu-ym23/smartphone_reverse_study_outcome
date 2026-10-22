package com.larus.community.impl.detail;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.community.api.spi.ICommunityDetailContainerProvider;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.CreationDoSameNotifyInfo;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0014J\"\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/community/impl/detail/CreationDetailActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "fg", "Landroidx/fragment/app/Fragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "openDoSameResultChat", "onBackPressed", "getBackgroundResource", "needAdaptNavigationBarPadding", "", "needAdaptStatusBarPadding", "finish", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int h = 0;
    public Fragment g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.community.impl.detail.CreationDetailActivity$onActivityResult$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.detail.CreationDetailActivity$onActivityResult$1", f = "CreationDetailActivity.kt", i = {}, l = {87, 103}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Intent $data;
        final /* synthetic */ int $requestCode;
        final /* synthetic */ int $resultCode;
        int label;
        final /* synthetic */ CreationDetailActivity this$0;

        public AnonymousClass1(int r1, int r2, CreationDetailActivity r3, Intent r4, Continuation<? super AnonymousClass1> r5) {
            this.$requestCode = r1;
            this.$resultCode = r2;
            this.this$0 = r3;
            this.$data = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$requestCode, this.$resultCode, this.this$0, this.$data, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            e29.g r6 = null;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r14);
        L22:
            this.this$0.finish();
        L42:
            if (this.$requestCode != 200) goto L64;
            if (this.$resultCode != (-1)) goto L64;
            Fragment r15 = this.this$0.g;
            if (r15 != null) goto L49;
            Intrinsics.throwUninitializedPropertyAccessException("fg");
            r15 = null;
        L49:
            if ((r15 instanceof CreationDetailFragment) == false) goto L51;
            CreationDetailFragment r16 = (CreationDetailFragment) r15;
        L52:
            if (r16 == null) goto L54;
            r16.Y90(this.$data);
        L54:
            Fragment r17 = this.this$0.g;
            if (r17 != null) goto L58;
            Intrinsics.throwUninitializedPropertyAccessException("fg");
            r17 = null;
        L58:
            if ((r17 instanceof e29.g) == false) goto L60;
            e29.g r18 = (e29.g) r17;
        L61:
            if (r18 == null) goto L64;
            r18.j6(this.$data);
            goto L64
        L60:
            r18 = null;
            goto L61
        L51:
            r16 = null;
        L64:
            if (this.$requestCode != 1000) goto L85;
            if (this.$resultCode != 370) goto L85;
            Fragment r110 = this.this$0.g;
            if (r110 != null) goto L71;
            Intrinsics.throwUninitializedPropertyAccessException("fg");
            r110 = null;
        L71:
            if ((r110 instanceof CreationDetailFragment) == false) goto L73;
            CreationDetailFragment r111 = (CreationDetailFragment) r110;
        L74:
            if (r111 == null) goto L76;
            r111.Y90(this.$data);
        L76:
            Fragment r112 = this.this$0.g;
            if (r112 != null) goto L80;
            Intrinsics.throwUninitializedPropertyAccessException("fg");
            r112 = null;
        L80:
            if ((r112 instanceof e29.g) == false) goto L82;
            r6 = (e29.g) r112;
        L82:
            if (r6 == null) goto L85;
            r6.j6(this.$data);
            goto L85
        L73:
            r111 = null;
        L85:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r14);
        L40:
            this.this$0.finish();
            goto L42
        L10:
            ResultKt.throwOnFailure(r14);
            if (this.$requestCode != 100) goto L42;
            int r113 = this.$resultCode;
            if (r113 != (-1)) goto L15;
            this.this$0.setResult(-1, this.$data);
            this.label = 1;
            if (DelayKt.delay(100, this) != r0) goto L40;
            return r0;
        L15:
            if (r113 != 371) goto L17;
            Fragment r114 = this.this$0.g;
            if (r114 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("fg");
            r114 = null;
        L26:
            Bundle r115 = r114.getArguments();
            if (r115 == null) goto L29;
            String r11 = r115.getString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD);
        L30:
            IUgcAIGCService.Companion r7 = IUgcAIGCService.a;
            r7.y();
            Intent r116 = this.$data;
            if (r116 == null) goto L35;
            Bundle r117 = r116.getExtras();
            if (r117 == null) goto L35;
            CreationDoSameNotifyInfo r8 = (CreationDoSameNotifyInfo) r117.getParcelable("creation_dosame_notify_info");
        L36:
            final CreationDetailActivity r10 = this.this$0;
            r7.Z(r8, r10, r10, r11, new com.larus.community.impl.detail.a(r10));
        L35:
            r8 = null;
            goto L36
        L29:
            r11 = null;
            goto L30
        L17:
            if (r113 != 372) goto L42;
            this.this$0.setResult(372, this.$data);
            this.label = 2;
            if (DelayKt.delay(100, this) != r0) goto L22;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.detail.CreationDetailActivity$onCreate$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.detail.CreationDetailActivity$onCreate$1", f = "CreationDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CreationDetailActivity this$0;

        public C01591(CreationDetailActivity r1, Continuation<? super C01591> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01591 r0 = new C01591(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r5);
            CoroutineScope r6 = (CoroutineScope) this.L$0;
            CreationDetailActivity r7 = this.this$0;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
            FragmentTransaction r1 = r7.getSupportFragmentManager().beginTransaction();     // Catch: Throwable -> L10
            Fragment r8 = r7.g;     // Catch: Throwable -> L10
            if (r8 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("fg");     // Catch: Throwable -> L10
            r8 = null;
        L8:
            INVOKEVIRTUAL_com_larus_community_impl_detail_CreationDetailActivity$onCreate$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r1, 2131373275, r8).commitNowAllowingStateLoss();     // Catch: Throwable -> L10
            Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
        L12:
            CreationDetailActivity r2 = this.this$0;
            Throwable r10 = Result.exceptionOrNull-impl(r9);
            if (r10 == null) goto L16;
            FLogger.a.e("CreationDetailActivity", "create detail fragment error", r10);
            r2.finish();
        L16:
            return Unit.INSTANCE;
        L10:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L12
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public static FragmentTransaction INVOKEVIRTUAL_com_larus_community_impl_detail_CreationDetailActivity$onCreate$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
            return r2;
        L6:
            return r2.replace(r3, r4);
        }
    }

    static {
    }

    public final int C1() {
        return 2131102529;
    }

    public final boolean H1() {
        return false;
    }

    public final boolean K1() {
        return false;
    }

    public final void onBackPressed() {
        Fragment r0 = this.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("fg");
        r0 = null;
    L6:
        if ((r0 instanceof CreationDetailFragment) == false) goto L16;
        CreationDetailFragment r1 = (CreationDetailFragment) r0;
        com.larus.community.impl.detail.image.a r2 = r1.W90();
        if (r2 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L22;
        r1.quit();
        return;
    L22:
        return;
    L10:
        if (r2.onBackPressed() == true) goto L12;
        r3 = true;
        goto L13
    L16:
        if ((r0 instanceof e29.g) == true) goto L18;
        finish();
        return;
    L18:
        if (((e29.g) r0).K20() == true) goto L24;
        finish();
        return;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(CreationDetailActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 2130772402);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(CreationDetailActivity.class.getName()));
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
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        N1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public CreationDetailActivity() {
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
    public final void onCreate(Bundle r9) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(null);
        setContentView(2131561787);
        Window r0 = getWindow();
        if (r0 == null) goto L13;
        View r1 = N1(r0);
    L14:
        setRootView(r1);
        L1();
        Bundle r2 = getIntent().getExtras();
        if (r2 != null) goto L17;
        r2 = new Bundle();
    L17:
        int r3 = e29.b.a;
        Intrinsics.checkNotNullParameter(r2, "arguments");
        ICommunityDetailContainerProvider r4 = (ICommunityDetailContainerProvider) ServiceManager.get().getService(ICommunityDetailContainerProvider.class);
        if (r4 == null) goto L20;
        Fragment r5 = r4.a(r2);
    L21:
        if (r5 != null) goto L23;
        r5 = new CreationDetailFragment();
    L23:
        this.g = r5;
        r5.setArguments(r2);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new C01591(this, null), 2, null);
        return;
    L20:
        r5 = null;
        goto L21
    L13:
        r1 = null;
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
        FLogger.a.e("CreationDetailActivity", " onSaveInstanceState error", r6);
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

    public final void onActivityResult(int r11, int r12, Intent r13) {
        super.onActivityResult(r11, r12, r13);
        LifecycleCoroutineScope r0 = LifecycleOwnerKt.getLifecycleScope(this);
        if (r0 == null) goto L6;
        BuildersKt.launch$default(r0, null, null, new AnonymousClass1(r11, r12, this, r13, null), 3, null);
        return;
    }
}
