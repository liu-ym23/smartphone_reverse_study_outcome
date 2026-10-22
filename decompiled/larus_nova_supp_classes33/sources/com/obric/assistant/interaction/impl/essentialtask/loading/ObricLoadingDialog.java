package com.obric.assistant.interaction.impl.essentialtask.loading;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import com.bytedance.crash.d;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IObricApmService;
import com.obric.assistant.interaction.api.IObricApmServiceKt;
import com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService;
import com.obric.assistant.interaction.api.essentialtask.IEssentialTaskServiceKt;
import com.obric.assistant.interaction.api.essentialtask.IObricLoadingUI;
import com.obric.assistant.interaction.impl.databinding.ObricLoadingUiBinding;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.oui.status.OPageStatus;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0016J5\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020\u0010H\u0016J\b\u0010-\u001a\u00020\u0010H\u0002J \u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u000202H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u00064"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/loading/ObricLoadingDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/obric/assistant/interaction/api/essentialtask/IObricLoadingUI;", "<init>", "()V", "binding", "Lcom/obric/assistant/interaction/impl/databinding/ObricLoadingUiBinding;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "loadingJob", "Lkotlinx/coroutines/Job;", "onCreateTime", "", "onStartTime", "onLoadSucceedCallback", "Lkotlin/Function0;", "", "getOnLoadSucceedCallback", "()Lkotlin/jvm/functions/Function0;", "setOnLoadSucceedCallback", "(Lkotlin/jvm/functions/Function0;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStart", "onStop", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "hideAll", "showLoading", "loading", "", "showInfoWithButton", "info", "btnText", "infoImageResId", "", "onClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "onEssentialTaskFinish", "initView", "report", "type", "duration", "isLoadSucceed", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLoadingDialog extends DialogFragment implements IObricLoadingUI {
    public static final Companion Companion = null;
    private static final String TAG = "ObricLoadingDialog";
    private ObricLoadingUiBinding binding;
    private Job loadingJob;
    private final CoroutineScope mainScope;
    private long onCreateTime;
    private volatile Function0<Unit> onLoadSucceedCallback;
    private long onStartTime;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/loading/ObricLoadingDialog$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.essentialtask.loading.ObricLoadingDialog$onEssentialTaskFinish$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.loading.ObricLoadingDialog$onEssentialTaskFinish$2", f = "ObricLoadingDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ObricLoadingDialog this$0;

        public AnonymousClass2(ObricLoadingDialog r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_essentialtask_loading_ObricLoadingDialog$onEssentialTaskFinish$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(ObricLoadingDialog r1) {
            r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r2 = DialogFragmentLancet.sLastShowStack;
            if (r2 == null) goto L11;
            d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r4);
            CoroutineScope r5 = (CoroutineScope) this.L$0;
            if (this.this$0.isAdded() == false) goto L15;
            ObricLoadingDialog r6 = this.this$0;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
            INVOKEVIRTUAL_com_obric_assistant_interaction_impl_essentialtask_loading_ObricLoadingDialog$onEssentialTaskFinish$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r6);     // Catch: Throwable -> L9
            Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            Throwable r8 = Result.exceptionOrNull-impl(r7);
            if (r8 == null) goto L15;
            FLogger.a.w(ObricLoadingDialog.TAG, "dismissAllowingStateLoss failed. " + r8.getMessage(), r8);
        L9:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
        L15:
            return Unit.INSTANCE;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void S90(Function0 r0, View r1) {
        showInfoWithButton$lambda$5$lambda$4(r0, r1);
    }

    public void onStart() {
        com_obric_assistant_interaction_impl_essentialtask_loading_ObricLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_onStart(this);
    }

    private final void initView() {
        ObricLoadingUiBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        e1.q(r0.loadingStatus);
    }

    @Override // com.obric.assistant.interaction.api.essentialtask.IObricLoadingUI
    public void hideAll() {
        ObricLoadingUiBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        e1.q(r0.loadingStatus);
    }

    public void onDestroy() {
        Job r0 = this.loadingJob;
        boolean r1 = true;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        long r2 = SystemClock.elapsedRealtime() - this.onCreateTime;
        IEssentialTaskService r3 = IEssentialTaskServiceKt.getEssentialTaskServiceDelegate();
        if (r3 != null) goto L8;
    L10:
        r1 = false;
    L11:
        report("lifecycle", r2, r1);
        return;
    L8:
        if (r3.isExecuteSucceed() != true) goto L10;
        goto L10
    }

    @Override // com.obric.assistant.interaction.api.essentialtask.IObricLoadingUI
    public void onEssentialTaskFinish() {
        FLogger r1 = FLogger.a;
        r1.i(TAG, "onEssentialTaskFinish");
        Function0<Unit> r2 = this.onLoadSucceedCallback;
        if (r2 != null) goto L5;
        r1.w(TAG, "onLoadSucceedCallback is null. cannot send result");
    L6:
        BuildersKt.launch$default(this.mainScope, null, null, new AnonymousClass2(this, null), 3, null);
        return;
    L5:
        BuildersKt.launch$default(this.mainScope, null, null, new ObricLoadingDialog$onEssentialTaskFinish$1$1(r2, null), 3, null);
        goto L6
    }

    public ObricLoadingDialog() {
        this.mainScope = CoroutineScopeKt.MainScope();
    }

    public void com_obric_assistant_interaction_impl_essentialtask_loading_ObricLoadingDialog__onStart$___twin___() {
        super.onStart();
        this.onStartTime = SystemClock.elapsedRealtime();
        Dialog r0 = getDialog();
        if (r0 == null) goto L12;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L12;
        WindowCompat.setDecorFitsSystemWindows(r1, false);
        r1.setStatusBarColor(0);
        r1.setNavigationBarColor(0);
        WindowInsetsControllerCompat r2 = WindowCompat.getInsetsController(r1, INVOKEVIRTUAL_com_obric_assistant_interaction_impl_essentialtask_loading_ObricLoadingDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1));
        if (r2 == null) goto L10;
        r2.setAppearanceLightStatusBars(true);
        r2.setAppearanceLightNavigationBars(true);
    L10:
        if (Build.VERSION.SDK_INT < 28) goto L12;
        WindowManager.LayoutParams r3 = r1.getAttributes();
        r3.layoutInDisplayCutoutMode = 1;
        r1.setAttributes(r3);
    L12:
        Dialog r4 = getDialog();
        if (r4 == null) goto L16;
        r4.setOnKeyListener(new DialogInterfaceOnKeyListenerC00782());
        return;
    }

    public void onStop() {
        super.onStop();
        long r0 = SystemClock.elapsedRealtime() - this.onStartTime;
        IEssentialTaskService r2 = IEssentialTaskServiceKt.getEssentialTaskServiceDelegate();
        boolean r3 = false;
        if (r2 != null) goto L5;
    L7:
        report("show", r0, r3);
        return;
    L5:
        if (r2.isExecuteSucceed() != true) goto L7;
        r3 = true;
        goto L7
    }

    public final Function0<Unit> getOnLoadSucceedCallback() {
        return this.onLoadSucceedCallback;
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_essentialtask_loading_ObricLoadingDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void com_obric_assistant_interaction_impl_essentialtask_loading_ObricLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_onStart(ObricLoadingDialog r1) {
        if ((r1 instanceof DialogFragment) == false) goto L5;
        PopupOrDialogVisibilityTracker.bindDialogFragment(r1);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(r1);
    L5:
        r1.com_obric_assistant_interaction_impl_essentialtask_loading_ObricLoadingDialog__onStart$___twin___();
    }

    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        setStyle(0, 2131953332);
        this.onCreateTime = SystemClock.elapsedRealtime();
        this.binding = ObricLoadingUiBinding.inflate(getLayoutInflater());
        initView();
        if (this.onLoadSucceedCallback != null) goto L5;
        FLogger.a.w(TAG, "onLoadSucceedCallback is null");
    L5:
        this.loadingJob = EssentialTaskLoadingHandler.INSTANCE.handleLoading(requireActivity(), this.mainScope, this);
    }

    public final void setOnLoadSucceedCallback(Function0<Unit> r1) {
        this.onLoadSucceedCallback = r1;
    }

    @Override // com.obric.assistant.interaction.api.essentialtask.IObricLoadingUI
    public void showLoading(String r3) {
        Intrinsics.checkNotNullParameter(r3, "loading");
        ObricLoadingUiBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OPageStatus r1 = r0.loadingStatus;
        Intrinsics.checkNotNull(r1);
        j19.c.f(r1);
        r1.setType(1);
        r1.setLoadingResult(r3);
        r1.b(true);
    }

    private static final void showInfoWithButton$lambda$5$lambda$4(Function0 r0, View r1) {
        r0.invoke();
    }

    private final void report(String r4, long r5, boolean r7) {
        IObricApmService r0 = IObricApmServiceKt.getObricApmServiceDelegate();
        if (r0 == null) goto L6;
        JSONObject r1 = new JSONObject();
        r1.put("type", r4);
        r1.put("load_succeed", r7);
        Unit r6 = Unit.INSTANCE;
        JSONObject r8 = new JSONObject();
        r8.put("duration", r5);
        r0.monitorEventForSlardar("obric_loading_ui", r1, r8, null);
        return;
    }

    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        ObricLoadingUiBinding r4 = this.binding;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L6:
        return r4.m1getRoot();
    }

    @Override // com.obric.assistant.interaction.api.essentialtask.IObricLoadingUI
    public void showInfoWithButton(String r2, String r3, Integer r4, final Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, "btnText");
        Intrinsics.checkNotNullParameter(r5, "onClick");
        ObricLoadingUiBinding r6 = this.binding;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L5:
        OPageStatus r7 = r6.loadingStatus;
        Intrinsics.checkNotNull(r7);
        j19.c.f(r7);
        r7.setType(0);
        r7.setTitle("");
        r7.setMessage(r2);
        r7.getButton().setText(r3);
        r7.getButton().setOnClickListener(new c(r5));
        r7.a(true);
    }
}
