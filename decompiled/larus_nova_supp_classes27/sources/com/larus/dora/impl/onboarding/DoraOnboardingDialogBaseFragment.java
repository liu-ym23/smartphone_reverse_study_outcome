package com.larus.dora.impl.onboarding;

import android.R;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.dora.impl.databinding.LarusDoraOnboardingDialogBinding;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.onboarding.g.DoraGOnboardingShimmerTextView;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import v19.i5;
import v19.o5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000 L2\u00020\u0001:\u0001LB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010$\u001a\u00020%H&J\b\u0010&\u001a\u00020\u001bH&J\b\u0010'\u001a\u00020\u001bH&J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H&J\u0010\u0010,\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u000201H\u0016J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u001a\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u0002032\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010<\u001a\u00020)H\u0016J\b\u0010=\u001a\u00020)H\u0016J\b\u0010>\u001a\u00020)H\u0002J\u0012\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010A\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010.\u001a\u00020/H\u0004J\u0010\u0010B\u001a\u0002012\u0006\u0010*\u001a\u00020+H\u0014J\u0010\u0010C\u001a\u00020)2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020)H\u0002J\u0010\u0010H\u001a\u00020)2\u0006\u0010.\u001a\u00020/H\u0002J\b\u0010I\u001a\u00020)H\u0002J\b\u0010J\u001a\u00020KH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001b\u0010\u0014\u001a\u00020\u00158DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006M"}, d2 = {"Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogBaseFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingDialogBinding;", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraOnboardingDialogBinding;", "setBinding", "(Lcom/larus/dora/impl/databinding/LarusDoraOnboardingDialogBinding;)V", "interruptDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "needUnbindDialog", "getNeedUnbindDialog", "()Lcom/larus/common_ui/dialog/CommonDialog;", "setNeedUnbindDialog", "(Lcom/larus/common_ui/dialog/CommonDialog;)V", "authDeviceFailedDialog", "getAuthDeviceFailedDialog", "setAuthDeviceFailedDialog", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogViewModel;", "getModel", "()Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogViewModel;", "model$delegate", "Lkotlin/Lazy;", "buryPointSource", "", "getBuryPointSource", "()Ljava/lang/String;", "setBuryPointSource", "(Ljava/lang/String;)V", "scanForALongTimeInMillis", "", "getScanForALongTimeInMillis", "()J", "productType", "Lcom/bytedance/dora/annotation/ProductNameType;", "productTypeDisplayName", "sku", "handleBottomTips", "", "state", "Lcom/larus/dora/impl/onboarding/OnboardingUiState;", "handleMovie", "handleUnbind", "device", "Lcom/bytedance/dora/device/DoraDevice;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onStart", "onStop", "dismissOrShowInterruptDialog", "handleUiState", "", "updateConnectedUI", "getTitleText", "gotoOnboardingPage", "handleAction", "action", "Lcom/larus/dora/impl/onboarding/OnboardingAction;", "showInterruptDialog", "showNeedUnbindDialog", "showAuthDeviceFailedDialog", "shouldAuthDevice", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DoraOnboardingDialogBaseFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int k = 0;
    public LarusDoraOnboardingDialogBinding d;
    public CommonDialog e;
    public CommonDialog f;
    public CommonDialog g;
    public final Lazy h;
    public String i;
    public final long j;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DoraOnboardingDialogBaseFragment a;
        public final /* synthetic */ q0 b;

        public b(DoraOnboardingDialogBaseFragment r1, q0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.X90(((q0.b) this.b).a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraOnboardingDialogBaseFragment a;

        public c(DoraOnboardingDialogBaseFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            DoraOnboardingDialogBaseFragment r3 = this.a;
            r3.Z90((q0) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ DoraOnboardingDialogBaseFragment a;

        public d(DoraOnboardingDialogBaseFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            o0 r9 = (o0) r7;
            final DoraOnboardingDialogBaseFragment r10 = this.a;
            int r0 = DoraOnboardingDialogBaseFragment.k;
            r10.getClass();
            g49.d.d("DoraOnboardingDialogFragment", "handleAction: " + r9);
            boolean r2 = true;
            if ((r9 instanceof o0.c) == false) goto L18;
            final DoraDevice r11 = ((o0.c) r9).a;
            Intrinsics.checkNotNullParameter(r11, "device");
            if (r10.f != null) goto L7;
            String r1 = AppHost.a.getApplication().getString(2131903934, new Object[]{r10.ba0()});
            CommonDialog.a r4 = new CommonDialog.a();
            r4.i(r10.getString(2131902447));
            r4.g(r1);
            CommonDialog.a.f(r4, new f0(r10, r11), r10.getString(2131902418), false, 12);
            CommonDialog.a.e(r4, new g0(r10, r11), r10.getString(2131902465), 4);
            r4.z = false;
            Function0<Boolean> r3 = new b0(r10, r11);
            Intrinsics.checkNotNullParameter(r3, "callback");
            r4.B = r3;
            r10.f = r4.a();
        L7:
            CommonDialog r12 = r10.f;
            if (r12 != null) goto L10;
        L12:
            r2 = false;
        L13:
            if (r2 == true) goto L42;
            CommonDialog r13 = r10.f;
            if (r13 == null) goto L42;
            DoraOnboardingDialogBaseFragment.T90(r13, r10.getChildFragmentManager());
        L42:
            return Unit.INSTANCE;
        L10:
            if (r12.isVisible() != true) goto L12;
        L18:
            if ((r9 instanceof o0.d) == false) goto L24;
            o0.d r14 = (o0.d) r9;
            if (r14.getType() != TOAST_TYPE.TOAST_TYPE_WARNING) goto L22;
            t19.s r15 = t19.s.a;
            Application r5 = AppHost.a.getApplication();
            String r16 = r14.a;
            r15.getClass();
            t19.s.t(r5, r16);
            goto L42
        L22:
            t19.s r17 = t19.s.a;
            Application r6 = AppHost.a.getApplication();
            String r18 = r14.a;
            r17.getClass();
            t19.s.c(r6, r18);
            goto L42
        L24:
            if (Intrinsics.areEqual(r9, o0.a.a) == false) goto L39;
            if (r10.g != null) goto L28;
            CommonDialog.a r20 = new CommonDialog.a();
            r20.i(r10.getString(2131903645));
            r20.g(r10.getString(2131903644));
            CommonDialog.a.f(r20, new c0(r10), r10.getString(2131902851), false, 12);
            r10.g = r20.a();
        L28:
            CommonDialog r21 = r10.g;
            if (r21 != null) goto L31;
        L33:
            r2 = false;
        L34:
            if (r2 == true) goto L42;
            CommonDialog r22 = r10.g;
            if (r22 == null) goto L42;
            DoraOnboardingDialogBaseFragment.T90(r22, r10.getChildFragmentManager());
            goto L42
        L31:
            if (r21.isVisible() != true) goto L33;
        L39:
            if ((r9 instanceof o0.b) == false) goto L44;
            r10.X90(((o0.b) r9).a);
            goto L42
        L44:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    public abstract void Y90(q0 r1);

    public abstract ProductNameType aa0();

    public abstract String ba0();

    public abstract String ca0();

    public final int getTheme() {
        return 2131951935;
    }

    public final DoraOnboardingDialogViewModel V90() {
        return (DoraOnboardingDialogViewModel) this.h.getValue();
    }

    public DoraOnboardingDialogBaseFragment() {
        final Function0<Fragment> r0 = new DoraOnboardingDialogBaseFragment$special$$inlined$viewModels$default$1(this);
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraOnboardingDialogViewModel.class), new DoraOnboardingDialogBaseFragment$special$$inlined$viewModels$default$2(r0), new DoraOnboardingDialogBaseFragment$special$$inlined$viewModels$default$3(r0, this));
        this.i = "";
        this.j = 12000;
    }

    public final void U90() {
        if ((V90().getUiStateFlow().getValue() instanceof q0.c) == false) goto L16;
        g49.d.d("DoraOnboardingDialogFragment", "showInterruptDialog");
        boolean r1 = false;
        if (this.e != null) goto L7;
        String r0 = ba0();
        AppHost.Companion r3 = AppHost.a;
        String r4 = r3.getApplication().getString(2131903937, new Object[]{r0});
        String r2 = r3.getApplication().getString(2131903936, new Object[]{r0});
        CommonDialog.a r5 = new CommonDialog.a();
        r5.i(r4);
        r5.g(r2);
        CommonDialog.a.f(r5, new d0(this), getString(2131903744), false, 12);
        CommonDialog.a.e(r5, new e0(this), getString(2131903743), 4);
        this.e = r5.a();
    L7:
        CommonDialog r6 = this.e;
        if (r6 != null) goto L10;
    L12:
        if (r1 == true) goto L18;
        CommonDialog r7 = this.e;
        if (r7 == null) goto L19;
        T90(r7, getChildFragmentManager());
        return;
    L19:
        return;
    L18:
        return;
    L10:
        if (r6.isVisible() != true) goto L12;
        r1 = true;
        goto L12
    L16:
        g49.d.d("DoraOnboardingDialogFragment", "dismissAllowingStateLoss");
        S90(this);
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L5;
        BottomSheetBehavior.from(r0.findViewById(2131368870)).setHideable(false);
        r0.findViewById(2131389274).setOnClickListener(new y(this));
    L5:
        V90().startScan(aa0(), ca0(), this.j);
    }

    public final void onStop() {
        super/*androidx.fragment.app.DialogFragment*/.onStop();
        V90().stopScan();
    }

    public static void S90(DoraOnboardingDialogBaseFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public int W90(q0 r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        int r1 = 2131902189;
        if (Intrinsics.areEqual(r3, q0.e.a) == false) goto L6;
    L12:
        return r1;
    L6:
        if (Intrinsics.areEqual(r3, q0.f.a) == true) goto L12;
        r1 = 2131903675;
        if ((r3 instanceof q0.d) == true) goto L12;
        boolean r4 = r3 instanceof q0.c;
        goto L12
    }

    public void X90(DoraDevice r6) {
        Intrinsics.checkNotNullParameter(r6, "device");
        Bundle r0 = getArguments();     // Catch: Throwable -> L17
        if (r0 == null) goto L6;
        String r1 = r0.getString("key_dora_onboarding_origin_from");     // Catch: Throwable -> L17
    L7:
        Context r2 = getContext();     // Catch: Throwable -> L17
        if (r2 != null) goto L10;
        return;
    L10:
        Intent r3 = new Intent("action.DEVICE_UPDATE_DYNAMIC");     // Catch: Throwable -> L17
        r3.putExtra("mac", r6.mac);     // Catch: Throwable -> L17
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r3);     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r1, "device_manage") == true) goto L13;
        n1.i();     // Catch: Throwable -> L17
    L13:
        com.bytedance.router.i r4 = SmartRouter.buildRoute(r2, "//dora_onboarding_v2");     // Catch: Throwable -> L17
        r4.d = 2130772372;     // Catch: Throwable -> L17
        r4.e = 2130772399;     // Catch: Throwable -> L17
        DoraOnboardingDevice r7 = x.c(r6);     // Catch: Throwable -> L17
        r4.c.putExtra("key_dora_onboarding_device", r7);     // Catch: Throwable -> L17
        r4.d();     // Catch: Throwable -> L17
        S90(this);     // Catch: Throwable -> L17
        FragmentActivity r8 = getActivity();     // Catch: Throwable -> L17
        if (r8 == null) goto L22;
        r8.finish();     // Catch: Throwable -> L17
        return;
    L22:
        return;
    L6:
        r1 = null;
    L17:
        th = move-exception;
        g49.d.c("DoraOnboardingDialogFragment", "gotoDeviceGuide: exception", th);
        S90(this);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public Object Z90(q0 r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        LarusDoraOnboardingDialogBinding r1 = this.d;
        if (r1 == null) goto L32;
        g49.d.d("DoraOnboardingDialogFragment", "handleUiState: " + r5);
        Intrinsics.checkNotNullParameter(r5, "state");
        Y90(r5);
        if (Intrinsics.areEqual(r5, q0.e.a) == false) goto L8;
        r1.k.setText(2131902189);
        e1.o(r1.j);
        e1.o(r1.e);
        e1.o(r1.f);
        return Unit.INSTANCE;
    L8:
        if (Intrinsics.areEqual(r5, q0.f.a) == false) goto L11;
        r1.k.setText(W90(r5));
        e1.o(r1.j);
        e1.o(r1.e);
        e1.o(r1.f);
        return Unit.INSTANCE;
    L11:
        if ((r5 instanceof q0.d) == false) goto L14;
        da0(r5, ((q0.d) r5).a);
        return Unit.INSTANCE;
    L14:
        if ((r5 instanceof q0.c) == false) goto L17;
        r1.k.setText(W90(r5));
        e1.x(r1.j);
        r1.j.setText(o59.a.d(((q0.c) r5).a));
        e1.o(r1.e);
        e1.x(r1.f);
        return Unit.INSTANCE;
    L17:
        if ((r5 instanceof q0.b) == false) goto L28;
        o5.a(this, "fragment_request_key_onboarding_start", com.larus.utils.f.c(new Pair[0]));
        CommonDialog r0 = this.e;
        if (r0 != null) goto L34;
    L26:
        Handler r2 = new Handler(Looper.getMainLooper());
        b r3 = new b(this, r5);
        r2.postDelayed(r3, 200);
        return r3;
    L34:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L26;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L26
    L28:
        if ((r5 instanceof q0.a) == false) goto L31;
        da0(r5, ((q0.a) r5).a);
        return Unit.INSTANCE;
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        return null;
    }

    public static void T90(CommonDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, null);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void da0(q0 r3, DoraDevice r4) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, "device");
        LarusDoraOnboardingDialogBinding r0 = this.d;
        if (r0 == null) goto L6;
        r0.k.setText(W90(r3));
        e1.x(r0.j);
        r0.j.setText(o59.a.d(r4));
        e1.x(r0.e);
        r0.e.setText(2131903671);
        e1.o(r0.f);
        return;
    }

    public void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        Bundle r13 = getArguments();
        DoraOnboardingDevice r14 = null;
        if (r13 == null) goto L5;
        String r15 = r13.getString("bury_point_source");
    L6:
        if (r15 != null) goto L8;
        r15 = "";
    L8:
        this.i = r15;
        BottomSheetDialog r16 = getDialog();
        if ((r16 instanceof BottomSheetDialog) == false) goto L11;
        BottomSheetDialog r17 = r16;
    L12:
        if (r17 == null) goto L14;
        View r18 = r17.findViewById(2131368870);
    L15:
        int r0 = com.larus.utils.m0.a;
        int r1 = com.larus.utils.m0.a(getContext());
        com.larus.utils.i0.a.getClass();
        int r2 = ((r1 - com.larus.utils.i0.g()) - com.larus.utils.i0.e()) - i5.c0();
        if (r18 == null) goto L18;
        r18.setLayoutParams(r18.getLayoutParams());
        BottomSheetBehavior r3 = BottomSheetBehavior.from(r18);
        r18.setBackgroundResource(R.color.transparent);
        r3.setState(3);
        r3.setPeekHeight(r2);
    L18:
        Lifecycle.State r110 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraOnboardingDialogBaseFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r110, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraOnboardingDialogBaseFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r110, null, this), 3, null);
        LarusDoraOnboardingDialogBinding r111 = this.d;
        if (r111 == null) goto L21;
        e1.d(r111.d, new z(this));
        e1.d(r111.e, new a0(this));
    L21:
        Bundle r112 = getArguments();
        if (r112 == null) goto L24;
        r14 = (DoraOnboardingDevice) r112.getParcelable("auto_connect_device");
    L24:
        if (r14 == null) goto L27;
        V90().bindAndConnect(x.b(r14));
        return;
    L27:
        return;
    L14:
        r18 = null;
        goto L15
    L11:
        r17 = null;
        goto L12
    L5:
        r15 = null;
        goto L6
    }

    public View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        View r16 = r13.inflate(2131562239, r14, false);
        int r17 = 2131369881;
        DoraGOnboardingShimmerTextView r2 = (DoraGOnboardingShimmerTextView) ViewBindings.findChildViewById(r16, 2131369881);
        if (r2 == null) goto L29;
        r17 = 2131369882;
        AppCompatTextView r3 = ViewBindings.findChildViewById(r16, 2131369882);
        if (r3 == null) goto L29;
        r17 = 2131369883;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r16, 2131369883);
        if (r4 == null) goto L29;
        r17 = 2131369884;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r16, 2131369884);
        if (r5 == null) goto L29;
        r17 = 2131369885;
        LinearLayoutCompat r6 = ViewBindings.findChildViewById(r16, 2131369885);
        if (r6 == null) goto L29;
        r17 = 2131369886;
        if (ViewBindings.findChildViewById(r16, 2131369886) == null) goto L29;
        r17 = 2131369887;
        if (((RoundConstraintLayout) ViewBindings.findChildViewById(r16, 2131369887)) == null) goto L29;
        r17 = 2131369888;
        DoraMovieView r7 = (DoraMovieView) ViewBindings.findChildViewById(r16, 2131369888);
        if (r7 == null) goto L29;
        r17 = 2131369889;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r16, 2131369889);
        if (r8 == null) goto L29;
        r17 = 2131369890;
        SimpleDraweeView r9 = ViewBindings.findChildViewById(r16, 2131369890);
        if (r9 == null) goto L29;
        r17 = 2131369891;
        DoraTextView r10 = (DoraTextView) ViewBindings.findChildViewById(r16, 2131369891);
        if (r10 == null) goto L29;
        r17 = 2131369892;
        DoraTextView r11 = (DoraTextView) ViewBindings.findChildViewById(r16, 2131369892);
        if (r11 == null) goto L29;
        FrameLayout r18 = (FrameLayout) r16;
        this.d = new LarusDoraOnboardingDialogBinding(r18, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        return r18;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
