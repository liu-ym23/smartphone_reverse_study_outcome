package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraOnboardingV2KeepAliveScrollableBinding;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.impl.onboarding.DoraOnboardingKeepAliveViewModel;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel;
import com.larus.dora.impl.view.DoraItemTextToggleSubTitle;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010#\u001a\u00020\u0018H\u0002J\u0012\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010'\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\b\u0010)\u001a\u00020\u0018H\u0002J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020&H\u0016J\n\u00100\u001a\u0004\u0018\u00010&H\u0016J\b\u00101\u001a\u00020\u0018H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedKeepAliveFragment;", "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingV2KeepAliveScrollableBinding;", "keepAliveModel", "Lcom/larus/dora/impl/onboarding/DoraOnboardingKeepAliveViewModel;", "getKeepAliveModel", "()Lcom/larus/dora/impl/onboarding/DoraOnboardingKeepAliveViewModel;", "keepAliveModel$delegate", "Lkotlin/Lazy;", "streamlinedModel", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "getStreamlinedModel", "()Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "streamlinedModel$delegate", "waitCdmOnJob", "Lkotlinx/coroutines/Job;", "cdmSwitch", "Lcom/larus/dora/impl/view/DoraItemTextToggleSubTitle;", "notificationSwitch", "Lcom/larus/bmhome/view/item/ItemTextToggle;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initKeepAliveCdm", "updateCdmEnableDeviceDesc", "deviceName", "", "initNotificationSwitch", "setupAvatar", "goNextPage", "onAttach", "context", "Landroid/content/Context;", "shouldShowSkipButton", "", "getCurrentPageName", "getCurrentCardName", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraHStreamlinedKeepAliveFragment extends DoraExternalOnboardingBaseFragment {
    public static final /* synthetic */ int u = 0;
    public LarusDoraOnboardingV2KeepAliveScrollableBinding o;
    public final Lazy p;
    public final Lazy q;
    public Job r;
    public DoraItemTextToggleSubTitle s;
    public ItemTextToggle t;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ DoraHStreamlinedKeepAliveFragment a;

        public b(DoraHStreamlinedKeepAliveFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            DoraOnboardingKeepAliveViewModel.AuthButtonState r4 = (DoraOnboardingKeepAliveViewModel.AuthButtonState) r2;
            DoraHStreamlinedKeepAliveFragment r5 = this.a;
            int r0 = DoraHStreamlinedKeepAliveFragment.u;
            TextView r6 = r5.h;
            if (r6 == null) goto L6;
            r6.setText(r4.getResId());
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final String V90() {
        return "new_keepalive_card";
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final boolean ba0() {
        return false;
    }

    public final String k() {
        return "keep_active";
    }

    public final DoraOnboardingKeepAliveViewModel fa0() {
        return (DoraOnboardingKeepAliveViewModel) this.p.getValue();
    }

    public final DoraHStreamlinedOnboardingViewModel ga0() {
        return (DoraHStreamlinedOnboardingViewModel) this.q.getValue();
    }

    public DoraHStreamlinedKeepAliveFragment() {
        this.p = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraOnboardingKeepAliveViewModel.class), new DoraHStreamlinedKeepAliveFragment$special$$inlined$activityViewModels$default$1(this), new DoraHStreamlinedKeepAliveFragment$special$$inlined$activityViewModels$default$2(this));
        this.q = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraHStreamlinedOnboardingViewModel.class), new DoraHStreamlinedKeepAliveFragment$special$$inlined$activityViewModels$default$3(this), new DoraHStreamlinedKeepAliveFragment$special$$inlined$activityViewModels$default$4(this));
    }

    public final void ha0() {
        ga0().stopTTS("streamlined keep alive goNextPage");
        Z90(new DoraHStreamlinedCompletionFragment());
    }

    public final void onDestroyView() {
        ga0().stopTTS("streamlined keep alive onDestroyView");
        FragmentActivity r0 = getActivity();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == true) goto L9;
        ga0().releasePageEntryTTS("keep_active");
    L9:
        Job r2 = this.r;
        if (r2 == null) goto L12;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L12:
        super.onDestroyView();
        this.o = null;
        this.s = null;
        this.t = null;
        return;
    L5:
        if (r0.isChangingConfigurations() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        fa0().createCompanionDeviceAssociator(this);
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        ca0().exitOnboardingMode();
    }

    /* JADX WARN: Type inference failed for: r1v20, types: [android.view.ViewGroup, com.larus.bmhome.view.item.ItemTextView, com.larus.dora.impl.view.DoraItemTextToggleSubTitle] */
    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r15);
        LarusDoraOnboardingV2KeepAliveScrollableBinding r16 = this.o;
        if (r16 == null) goto L5;
        ItemGroup r17 = r16.e;
    L6:
        this.f = r17;
        Context r18 = getContext();
        if (r18 == null) goto L66;
        ItemGroup r1 = this.f;
        if (r1 == null) goto L11;
        r1.removeAllViews();
    L11:
        int r2 = 0;
        if (fa0().isCdmSwitchExposed() == false) goto L48;
        g49.d.d("DoraHStreamlinedKeepAliveFragment", "cdm switch exposed");
        ?? r3 = new DoraItemTextToggleSubTitle(r18);
        r3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r3.setText(getString(2131903313));
        r3.setTextFontWeight(500);
        this.s = r3;
        DoraOnboardingDevice r4 = ca0().getDoraOnboardingDevice();
        if (r4 == null) goto L16;
        String r5 = r4.a;
    L17:
        if (r5 != null) goto L19;
    L22:
        boolean r6 = true;
    L23:
        if (r6 == true) goto L32;
        DoraItemTextToggleSubTitle r7 = this.s;
        if (r7 == null) goto L27;
        r7.setSubTitle(getString(2131903294) + r5);
    L27:
        DoraItemTextToggleSubTitle r8 = this.s;
        if (r8 == null) goto L37;
        TextView r9 = r8.getSubTitle();
        if (r9 == null) goto L37;
        e1.x(r9);
    L37:
        DoraItemTextToggleSubTitle r10 = this.s;
        if (r10 == null) goto L42;
        CustomSwitchCompat r11 = r10.getToggleView();
        if (r11 == null) goto L42;
        r11.setChecked(true);
    L42:
        DoraItemTextToggleSubTitle r12 = this.s;
        if (r12 == null) goto L45;
        r12.getToggleView().setOnCheckedChangeListener(new s(this));
    L45:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedKeepAliveFragment$initKeepAliveCdm$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        ItemGroup r13 = this.f;
        if (r13 == null) goto L49;
        r13.addView(this.s);
    L49:
        ItemTextToggle r20 = new ItemTextToggle(r18);
        r20.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r20.setText(getString(2131903315));
        r20.setTextFontWeight(500);
        this.t = r20;
        ItemGroup r110 = this.f;
        if (r110 == null) goto L52;
        r110.addView(r20);
    L52:
        ItemGroup r111 = this.f;
        if (r111 == null) goto L66;
        e1.x(r111);
        int r21 = r111.getChildCount();
    L55:
        if (r2 >= r21) goto L66;
        View r22 = r111.getChildAt(r2);
        if (r21 != 1) goto L59;
        int r23 = 2131240618;
    L65:
        r22.setBackgroundResource(r23);
        r2 = r2 + 1;
        goto L55
    L59:
        if (r2 != 0) goto L62;
        r23 = 2131240620;
        goto L65
    L62:
        if (r2 != (r21 - 1)) goto L64;
        r23 = 2131240619;
        goto L65
    L64:
        r23 = 2131240617;
        goto L65
    L32:
        DoraItemTextToggleSubTitle r24 = this.s;
        if (r24 == null) goto L37;
        TextView r25 = r24.getSubTitle();
        if (r25 == null) goto L37;
        e1.o(r25);
        goto L37
    L19:
        if (r5.length() == 0) goto L22;
        r6 = false;
        goto L23
    L16:
        r5 = null;
        goto L17
    L48:
        fa0().setCdmSwitchOn(false);
    L66:
        TextView r112 = this.h;
        if (r112 == null) goto L69;
        e1.x(r112);
        r112.setText(2131903738);
        e1.d(r112, new p(this));
    L69:
        Lifecycle.State r113 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedKeepAliveFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r113, null, this), 3, null);
        FragmentActivity r26 = getActivity();
        if (r26 == null) goto L74;
        TextView r27 = (TextView) r26.findViewById(2131369901);
        if (r27 == null) goto L74;
        e1.x(r27);
        r27.setText(2131902346);
        e1.d(r27, new q(this));
    L74:
        LarusDoraOnboardingV2KeepAliveScrollableBinding r28 = this.o;
        if (r28 == null) goto L79;
        DoraUrlSpanTextView r30 = r28.d;
        if (r30 == null) goto L79;
        int r31 = com.larus.utils.j0.a;
        r30.setUrlSpannedText(com.larus.utils.j0.d(2131903752));
    L79:
        DoraExternalOnboardingViewModel.playPageEntryTTSIfNeeded$default(ga0(), "keep_active", 2131903754, 0, 4, null);
        LarusDoraOnboardingV2KeepAliveScrollableBinding r32 = this.o;
        if (r32 == null) goto L84;
        CircleSimpleDraweeView r33 = r32.c;
        if (r33 == null) goto L84;
        CircleSimpleDraweeView.f(r33, UriProtector.parse("res://" + requireContext().getPackageName() + "/2131240621"), null, null, 0, 0, 62);
    L84:
        ga0().fetchAvatarUrl();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedKeepAliveFragment$setupAvatar$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r113, null, this), 3, null);
        ItemTextToggle r114 = this.t;
        if (r114 == null) goto L93;
        r114.getToggleView().setChecked(true);
        r114.getToggleView().setOnCheckedChangeListener(new r(this));
        return;
    L93:
        return;
    L5:
        r17 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDoraOnboardingV2KeepAliveScrollableBinding r4 = LarusDoraOnboardingV2KeepAliveScrollableBinding.a(r1, r2);
        this.o = r4;
        return r4.a;
    }
}
