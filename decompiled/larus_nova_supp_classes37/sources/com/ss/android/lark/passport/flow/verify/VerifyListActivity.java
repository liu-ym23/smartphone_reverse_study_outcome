package com.ss.android.lark.passport.flow.verify;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelLazy;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.flow.passport.ui.widget.common.FlowBaseActivity;
import com.ss.android.lark.flow.passport.ui.widget.common.FlowBaseFragment;
import com.ss.android.lark.flow.passport.ui.widget.utils.FlowUtilKt;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.model.ButtonType;
import com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession;
import com.ss.android.lark.passport.flow.verify.entity.VerifyListStepInfo;
import com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment;
import com.ss.android.lark.passport.flow.verify.view.VerifyFidoFragment;
import com.ss.android.lark.passport.flow.verify.view.VerifyIdpFragment;
import com.ss.android.lark.passport.flow.verify.view.VerifyMoFragment;
import com.ss.android.lark.passport.flow.verify.view.VerifyPwdFragment;
import com.ss.android.lark.passport.flow.verify.view.VerifyQrFragment;
import com.ss.android.lark.passport.flow.verify.viewmodel.AuthListViewModel;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCommonViewModel;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import uzb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/VerifyListActivity;", "Lcom/ss/android/lark/flow/passport/ui/widget/common/FlowBaseActivity;", "<init>", "()V", "stepInfo", "Lcom/ss/android/lark/passport/flow/verify/entity/VerifyListStepInfo;", "repo", "Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "getRepo", "()Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "commonViewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;", "getCommonViewModel", "()Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;", "commonViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/AuthListViewModel;", "getViewModel", "()Lcom/ss/android/lark/passport/flow/verify/viewmodel/AuthListViewModel;", "viewModel$delegate", "navMap", "", "", "Lcom/ss/android/lark/flow/passport/ui/widget/common/FlowBaseFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "onDestroy", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class VerifyListActivity extends FlowBaseActivity {
    public static final /* synthetic */ int g = 0;
    public final ViewModelLazy d;
    public final ViewModelLazy e;
    public final Map<Integer, FlowBaseFragment> f;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.VerifyListActivity$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/AuthListViewModel$ViewState;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.VerifyListActivity$onCreate$1", f = "VerifyListActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<AuthListViewModel.d, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VerifyListActivity this$0;

        public AnonymousClass1(VerifyListActivity r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(AuthListViewModel.d r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AuthListViewModel.d) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r4);
            AuthListViewModel.d r5 = (AuthListViewModel.d) this.L$0;
            if ((r5 instanceof AuthListViewModel.d.a) == false) goto L12;
            PassportLog.d("VerifyListActivity", "AuthListTitle: " + r5);
            int r6 = ((AuthListViewModel.d.a) r5).b;
            FlowBaseFragment r0 = this.this$0.f.get(Boxing.boxInt(r6));
            if (r0 == null) goto L14;
            FlowMfaFlowSession r1 = ((VerifyCommonViewModel) this.this$0.d.getValue()).flowSession$flow_passport_mfa_release();
            if (r1 == null) goto L11;
            r1.v(r6, ((xyb.a) ((VerifyCommonViewModel) this.this$0.d.getValue()).getRepo().getValue()).e.getFlowType());
        L11:
            r0.setArguments(this.this$0.getIntent().getExtras());
            f.a(this.this$0);
            FragmentTransaction r7 = this.this$0.getSupportFragmentManager().beginTransaction();
            r7.setReorderingAllowed(true);
            INVOKEVIRTUAL_com_ss_android_lark_passport_flow_verify_VerifyListActivity$onCreate$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r7, 2131380626, r0);
            r7.commit();
        L14:
            return Unit.INSTANCE;
        L12:
            PassportLog.b("VerifyListActivity", "miss state");
            goto L14
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public static FragmentTransaction INVOKEVIRTUAL_com_ss_android_lark_passport_flow_verify_VerifyListActivity$onCreate$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
            return r2;
        L6:
            return r2.replace(r3, r4);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.VerifyListActivity$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/AuthListViewModel$UIEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.VerifyListActivity$onCreate$2", f = "VerifyListActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<AuthListViewModel.c, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass2 r0 = new AnonymousClass2(r3);
            r0.L$0 = r2;
            return r0;
        }

        public final Object invoke(AuthListViewModel.c r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AuthListViewModel.c) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            if ((((AuthListViewModel.c) this.L$0) instanceof AuthListViewModel.c.a) == false) goto L9;
            return Unit.INSTANCE;
        L9:
            throw new NoWhenBranchMatchedException();
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(VerifyListActivity.class.getName()));
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

    public VerifyListActivity() {
        final Function0 r5 = null;
        this.d = new ViewModelLazy(Reflection.getOrCreateKotlinClass(VerifyCommonViewModel.class), new VerifyListActivity$special$$inlined$viewModels$default$2(this), new VerifyListActivity$special$$inlined$viewModels$default$1(this), new VerifyListActivity$special$$inlined$viewModels$default$3(r5, this));
        this.e = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AuthListViewModel.class), new VerifyListActivity$special$$inlined$viewModels$default$5(this), new VerifyListActivity$viewModel$2(this), new VerifyListActivity$special$$inlined$viewModels$default$6(r5, this));
        this.f = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_PHONE.getValue()), new VerifyCodeFragment()), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_EMAIL.getValue()), new VerifyCodeFragment()), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_SPARE.getValue()), new VerifyCodeFragment()), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_OTP.getValue()), new VerifyCodeFragment()), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_FIDO.getValue()), new VerifyFidoFragment()), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_PASSWORD.getValue()), new VerifyPwdFragment()), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_MO.getValue()), new VerifyMoFragment()), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_B_IDP.getValue()), new VerifyIdpFragment()), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_GOOGLE.getValue()), new VerifyIdpFragment()), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_APPLE_ID.getValue()), new VerifyIdpFragment()), TuplesKt.to(Integer.valueOf(ButtonType.QR_LOGIN_SHOW.getValue()), new VerifyQrFragment()), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_DOUBAO.getValue()), new VerifyIdpFragment())});
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.FragmentActivity*/.onDestroy();
        y1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.fragment.app.FragmentActivity*/.onStop();
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

    public final void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r5);
        setContentView(2131564871);
        VerifyListStepInfo r6 = (VerifyListStepInfo) getIntent().getSerializableExtra("step_info");
        if (r6 != null) goto L13;
        PassportLog.b("VerifyListActivity", "init VerifyList but stepInfo is null");
        return;
    L13:
        ((VerifyCommonViewModel) this.d.getValue()).init(r6.getDefaultVerifyItem(), r6, getIntent().getStringExtra("flow_mfa_flow_id"));
        FlowUtilKt.a(this, ((AuthListViewModel) this.e.getValue()).getViewState(), new AnonymousClass1(this, null));
        FlowUtilKt.b(this, ((AuthListViewModel) this.e.getValue()).getEventState(), new AnonymousClass2(null));
        ((AuthListViewModel) this.e.getValue()).init();
    }
}
