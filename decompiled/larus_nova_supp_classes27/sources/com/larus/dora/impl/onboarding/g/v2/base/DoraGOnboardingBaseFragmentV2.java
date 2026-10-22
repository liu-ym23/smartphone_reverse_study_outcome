package com.larus.dora.impl.onboarding.g.v2.base;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.f0;
import com.larus.common_ui.dialog.p0;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.y;
import com.larus.dora.impl.util.s;
import com.larus.utils.i0;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0016J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%J\b\u0010'\u001a\u00020(H\u0002J6\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020+2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e00H\u0004J\b\u00101\u001a\u00020\u001eH\u0004J\b\u00102\u001a\u00020(H\u0004J\b\u00103\u001a\u00020(H\u0004J\u0012\u00104\u001a\u00020+2\b\b\u0001\u00105\u001a\u000206H\u0004J\u001c\u00107\u001a\u00020+2\b\b\u0001\u00108\u001a\u0002062\b\b\u0001\u00109\u001a\u000206H\u0004J\b\u0010:\u001a\u00020\u001eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016¨\u0006<"}, d2 = {"Lcom/larus/dora/impl/onboarding/g/v2/base/DoraGOnboardingBaseFragmentV2;", "Lcom/larus/dora/impl/onboarding/DoraOnboardingBaseFragment;", "Lcom/larus/dora/impl/onboarding/g/v2/infz/IDoraGOnboardingState;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/DoraGOnboardingViewModelV2;", "getViewModel", "()Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/DoraGOnboardingViewModelV2;", "viewModel$delegate", "Lkotlin/Lazy;", "mSkipGuideDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "getMSkipGuideDialog", "()Lcom/larus/common_ui/dialog/CommonDialog;", "setMSkipGuideDialog", "(Lcom/larus/common_ui/dialog/CommonDialog;)V", "mLinkDialogJob", "Lkotlinx/coroutines/Job;", "getMLinkDialogJob", "()Lkotlinx/coroutines/Job;", "setMLinkDialogJob", "(Lkotlinx/coroutines/Job;)V", "mWearDialogJob", "getMWearDialogJob", "setMWearDialogJob", "mCallDialogJob", "getMCallDialogJob", "setMCallDialogJob", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "next", "fragment", "Landroidx/fragment/app/Fragment;", "nextWithAnim", "isCurrentProductEnabled", "", "showSkipGuideDialog", "type", "", "title", "message", "confirm", "confirmFunc", "Lkotlin/Function0;", "dismissSkipGuideDialog", "currentLinkState", "currentWearState", "getStringResVal", "key", "", "spliceTwoStringResValWithLineBreak", "keyOne", "keyTwo", "onSkipButtonClicked", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DoraGOnboardingBaseFragmentV2 extends DoraOnboardingBaseFragment implements e69.a {
    public static final /* synthetic */ int r = 0;
    public final Lazy m;
    public CommonDialog n;
    public Job o;
    public Job p;
    public Job q;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ DoraGOnboardingBaseFragmentV2 a;

        public b(DoraGOnboardingBaseFragmentV2 r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            y r3 = (y) r1;
            if ((r3 instanceof y.b) == false) goto L5;
            y.b r4 = (y.b) r3;
        L6:
            if (r4 == null) goto L10;
            this.a.bO(r4.a);
            return Unit.INSTANCE;
        L10:
            return Unit.INSTANCE;
        L5:
            r4 = null;
            goto L6
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraGOnboardingBaseFragmentV2 a;

        public c(DoraGOnboardingBaseFragmentV2 r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            com.larus.dora.impl.onboarding.g.v2.viewmodel.n r4 = (com.larus.dora.impl.onboarding.g.v2.viewmodel.n) r2;
            if ((r4 instanceof com.larus.dora.impl.onboarding.g.v2.viewmodel.n.a) == false) goto L5;
            com.larus.dora.impl.onboarding.g.v2.viewmodel.n.a r5 = (com.larus.dora.impl.onboarding.g.v2.viewmodel.n.a) r4;
        L6:
            if (r5 == null) goto L10;
            this.a.Ir(r5.a, r5.b);
            return Unit.INSTANCE;
        L10:
            return Unit.INSTANCE;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ DoraGOnboardingBaseFragmentV2 a;

        public d(DoraGOnboardingBaseFragmentV2 r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            com.larus.dora.impl.onboarding.g.v2.viewmodel.o r3 = (com.larus.dora.impl.onboarding.g.v2.viewmodel.o) r1;
            if ((r3 instanceof com.larus.dora.impl.onboarding.g.v2.viewmodel.o.b) == false) goto L5;
            com.larus.dora.impl.onboarding.g.v2.viewmodel.o.b r4 = (com.larus.dora.impl.onboarding.g.v2.viewmodel.o.b) r3;
        L6:
            if (r4 == null) goto L10;
            this.a.jL(r4.a);
            return Unit.INSTANCE;
        L10:
            return Unit.INSTANCE;
        L5:
            r4 = null;
            goto L6
        }
    }

    public static final class e<T> implements FlowCollector {
        public final /* synthetic */ DoraGOnboardingBaseFragmentV2 a;

        public e(DoraGOnboardingBaseFragmentV2 r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            boolean r3 = ((Boolean) r1).booleanValue();
            this.a.S30(r3);
            return Unit.INSTANCE;
        }
    }

    public static final class f implements p0 {
        public final /* synthetic */ Function0<Unit> a;
        public final /* synthetic */ String b;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            this.a.invoke();
            int r0 = j49.a.a;
            j49.a.j(this.b);
        }

        public f(Function0<Unit> r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final void ea0() {
        StringBuilder r0 = new StringBuilder("dismissSkipGuideDialog, hasDialog=");
        if (this.n == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        g49.d.d("DoraGOnboardingBaseFragmentV2", r0.toString());
        CommonDialog r2 = this.n;
        if (r2 != null) goto L16;
    L14:
        this.n = null;
        return;
    L16:
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L14;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    L5:
        r1 = false;
        goto L6
    }

    public final DoraGOnboardingViewModelV2 ga0() {
        return (DoraGOnboardingViewModelV2) this.m.getValue();
    }

    public final String ia0() {
        StringBuilder r0 = new StringBuilder();
        int r1 = j0.a;
        r0.append(j0.d(2131902815));
        r0.append('\n');
        r0.append(j0.d(2131902813));
        return r0.toString();
    }

    public DoraGOnboardingBaseFragmentV2() {
        this.m = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraGOnboardingViewModelV2.class), new DoraGOnboardingBaseFragmentV2$special$$inlined$activityViewModels$default$1(this), new DoraGOnboardingBaseFragmentV2$special$$inlined$activityViewModels$default$2(this));
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public void aa0() {
        ga0().exitOnboarding();
        ga0().stopTTS("onSkipButtonClicked");
    }

    public final boolean ca0() {
        Object r0 = ga0().getLinkStateFlow().getValue();
        if ((r0 instanceof com.larus.dora.impl.onboarding.g.v2.viewmodel.o.b) == false) goto L5;
        com.larus.dora.impl.onboarding.g.v2.viewmodel.o.b r1 = (com.larus.dora.impl.onboarding.g.v2.viewmodel.o.b) r0;
    L6:
        if (r1 != null) goto L10;
        return true;
    L10:
        return r1.a;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean da0() {
        Object r0 = ga0().getWearStateFlow().getValue();
        if ((r0 instanceof y.b) == false) goto L5;
        y.b r1 = (y.b) r0;
    L6:
        if (r1 != null) goto L10;
        return true;
    L10:
        return r1.a;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void Z90(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        int r0 = s.a;
        DoraOnboardingDevice r1 = ga0().getDoraOnboardingDevice();
        if (r1 == null) goto L5;
        Integer r3 = Integer.valueOf(r1.h);
    L7:
        if (s.c(r3) == true) goto L12;
        g49.d.d("DoraGOnboardingBaseFragmentV2", "Dora G is disabled, block G onboarding navigation");
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L14;
        r4.finish();
        return;
    L14:
        return;
    L12:
        super.Z90(r2);
        return;
    L5:
        r3 = null;
        goto L7
    }

    public final String fa0(int r2) {
        int r0 = j0.a;
        return j0.d(r2);
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super.onViewCreated(r20, r21);
        int r2 = s.a;
        DoraOnboardingDevice r3 = ga0().getDoraOnboardingDevice();
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.h);
    L7:
        if (s.c(r4) == true) goto L12;
        g49.d.d("DoraGOnboardingBaseFragmentV2", "Dora G is disabled, finish G onboarding page");
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L27;
        r1.finish();
        return;
    L27:
        return;
    L12:
        TextView r5 = this.j;
        if (r5 == null) goto L19;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L18;
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) r6;
        i0.a.getClass();
        ((ViewGroup.MarginLayoutParams) r7).topMargin = i0.g();
        r5.setLayoutParams(r7);
        int r8 = j0.a;
        r5.setText(j0.d(2131902808));
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L19:
        View r9 = r20.findViewById(2131369876);
        if (r9 == null) goto L22;
        r9.setBackgroundResource(2131103047);
    L22:
        View r10 = r20.findViewById(2131369442);
        if (r10 == null) goto L25;
        ViewCompat.setOnApplyWindowInsetsListener(r10, new com.larus.dora.impl.onboarding.g.v2.base.a());
    L25:
        Lifecycle.State r11 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOnboardingBaseFragmentV2$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r11, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOnboardingBaseFragmentV2$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r11, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOnboardingBaseFragmentV2$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r11, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOnboardingBaseFragmentV2$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r11, null, this), 3, null);
        return;
    L5:
        r4 = null;
        goto L7
    }

    public final void ha0(String r7, String r8, String r9, String r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r7, "type");
        Intrinsics.checkNotNullParameter(r8, "title");
        Intrinsics.checkNotNullParameter(r9, "message");
        Intrinsics.checkNotNullParameter(r10, "confirm");
        Intrinsics.checkNotNullParameter(r11, "confirmFunc");
        if (isAdded() == true) goto L5;
    L25:
        g49.d.d("DoraGOnboardingBaseFragmentV2", "showSkipGuideDialog aborted, type=" + r7 + ", isAdded=" + isAdded() + ", isResumed=" + isResumed());
        return;
    L5:
        if (isResumed() == false) goto L25;
        Context r2 = getContext();
        if (r2 != null) goto L12;
        g49.d.d("DoraGOnboardingBaseFragmentV2", "showSkipGuideDialog aborted, type=" + r7 + ", context is null");
        return;
    L12:
        if (getChildFragmentManager().isStateSaved() == false) goto L15;
        g49.d.d("DoraGOnboardingBaseFragmentV2", "showSkipGuideDialog aborted, type=" + r7 + ", childFragmentManager stateSaved");
        return;
    L15:
        CommonDialog r3 = this.n;
        if (r3 != null) goto L27;
    L23:
        CommonDialog.a r4 = new CommonDialog.a();
        Intrinsics.checkNotNullParameter(r8, "title");
        r4.a = r8;
        Intrinsics.checkNotNullParameter(r9, "message");
        r4.i = r9;
        CommonDialog.a.f(r4, new f(r11, r7), r10, false, 12);
        f0 r12 = new f0(null, Integer.valueOf(ContextCompat.getColor(r2, 2131103136)), Typeface.DEFAULT_BOLD, 1);
        Intrinsics.checkNotNullParameter(r12, "commonDialogTextStyleConfig");
        r4.D = r12;
        r4.z = false;
        CommonDialog r13 = r4.a();
        r13.setCancelable(false);
        g49.d.d("DoraGOnboardingBaseFragmentV2", "showSkipGuideDialog show, type=" + r7 + ", title=" + r8);
        r13.T90(getChildFragmentManager(), null);
        int r14 = j49.a.a;
        j49.a.k(r7);
        this.n = r13;
        return;
    L27:
        r3.dismissAllowingStateLoss();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L23;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L23
    }
}
