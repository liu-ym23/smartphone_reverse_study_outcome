package com.larus.dora.impl.onboarding.othersmart;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraHOnboardingRadioBinding;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment;
import com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedNotificationFragment;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.larus.utils.e1;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalSmartOnboardingRadioFragment;", "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraHOnboardingRadioBinding;", "shouldUseSaxOnboardingFlow", "", "bindRadioHintText", "", "isSax", "buildWalkieHintSpannable", "", "fullText", "", "highlightText", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "goNextPage", "onSkipButtonClicked", "getCurrentPageName", "getCurrentCardName", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraExternalSmartOnboardingRadioFragment extends DoraExternalOnboardingBaseFragment {
    public static final /* synthetic */ int p = 0;
    public LarusDoraHOnboardingRadioBinding o;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<Object> {
        public final /* synthetic */ VideoPlayView a;

        public b(VideoPlayView r1) {
            this.a = r1;
        }

        public final void onFailure(String r1, Throwable r2) {
            this.a.M();
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            this.a.M();
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraExternalSmartOnboardingRadioFragment a;

        public c(DoraExternalSmartOnboardingRadioFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            if ((((com.larus.dora.impl.onboarding.othersmart.a) r2) instanceof com.larus.dora.impl.onboarding.othersmart.a.C0089a) == false) goto L11;
            DoraExternalSmartOnboardingRadioFragment r4 = this.a;
            if (r4.o == null) goto L11;
            r4.ca0().enterOnboardingMode(true);
            if (DoraExternalSmartOnboardingRadioFragment.ga0() == false) goto L9;
            r4.ca0().enterRadioOnlyMode(true);
            goto L11
        L9:
            r4.ca0().enterKeyLongPressOnlyMode(true);
        L11:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final String k() {
        return "gesture_wakeup_guidance";
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final String V90() {
        DoraSetting.a.getClass();
        if (DoraSetting.m() == false) goto L5;
        return "new_gesture_card";
    L5:
        return null;
    }

    public final void fa0() {
        DoraSetting.a.getClass();
        if (DoraSetting.m() == false) goto L16;
        DoraUserSettingsManager r0 = DoraUserSettingsManager.a;
        IObricDoraService r1 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.n() != true) goto L9;
    L10:
        if (r2 == false) goto L12;
        g49.d.d("DoraExternalOnboardingBaseFragment", "skip notification guide for OBRIC proactive setting hidden");
    L12:
        if (r2 == false) goto L15;
        ea0();
        return;
    L15:
        DoraHStreamlinedNotificationFragment r3 = new DoraHStreamlinedNotificationFragment();
        Bundle r4 = new Bundle();
        r4.putString("arg_card_name", "new_broadcast_intro_card");
        r3.setArguments(r4);
        Z90(r3);
        return;
    L9:
        r2 = false;
        goto L10
    L16:
        ea0();
    }

    public static boolean ga0() {
        DoraDevice r0 = DoraAdapterExtKt.h(kj4.a.g());
        if (r0 == null) goto L10;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (r0.productId != ProductNameType.H_FREE_BUDS_PRO_5.id) goto L7;
        boolean r4 = true;
    L8:
        if (r4 != true) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == true) goto L30;
        if (r0 == null) goto L19;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (r0.productId != ProductNameType.H_GUITAR.id) goto L16;
        boolean r6 = true;
    L17:
        if (r6 != true) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == true) goto L30;
        if (r0 == null) goto L28;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (r0.productId != ProductNameType.H_DOLPHIN.id) goto L25;
        boolean r1 = true;
    L26:
        if (r1 != true) goto L28;
        boolean r2 = true;
    L29:
        if (r2 == true) goto L30;
        return false;
    L25:
        r1 = false;
    L28:
        r2 = false;
        goto L29
    L16:
        r6 = false;
    L19:
        r7 = false;
    L30:
        return true;
    L7:
        r4 = false;
    L10:
        r5 = false;
        goto L11
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void aa0() {
        ca0().stopTTS("onSkipButtonClicked");
        fa0();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ca0().stopTTS("DoraOnboardingRadioFragment#onDestroyView");
    }

    public DoraExternalSmartOnboardingRadioFragment() {
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        if (DoraOnboardingBaseFragment.Y90() == false) goto L9;
        LarusDoraHOnboardingRadioBinding r9 = this.o;
        if (r9 == null) goto L9;
        AppCompatTextView r10 = r9.c;
        if (r10 == null) goto L9;
        r10.setText(2131903142);
    L9:
        TextView r11 = this.h;
        if (r11 == null) goto L18;
        e1.x(r11);
        if (DoraOnboardingBaseFragment.Y90() == true) goto L14;
    L16:
        int r12 = 2131902338;
    L17:
        r11.setText(r12);
        e1.d(r11, new y(this));
        goto L18
    L14:
        if (DoraOnboardingBaseFragment.X90() == true) goto L16;
        r12 = 2131902340;
    L18:
        Lifecycle.State r13 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraExternalSmartOnboardingRadioFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r13, null, this), 3, null);
        if (ga0() == false) goto L21;
        DoraExternalOnboardingViewModel.enterRadioOnlyMode$default(ca0(), false, 1, null);
    L22:
        ca0().stopTTS("DoraOnboardingRadioFragment#onViewCreated");
        DoraSetting.a.getClass();
        if (DoraSetting.m() == true) goto L25;
    L28:
        int r14 = 2131903134;
    L29:
        DoraExternalOnboardingViewModel r15 = ca0();
        int r0 = com.larus.utils.j0.a;
        r15.playTTS(com.larus.utils.j0.d(r14));
        return;
    L25:
        if (ga0() == true) goto L28;
        r14 = 2131903676;
        goto L29
    L21:
        DoraExternalOnboardingViewModel.enterKeyLongPressOnlyMode$default(ca0(), false, 1, null);
        goto L22
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextView] */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.widget.TextView, com.larus.dora.impl.view.DoraUrlSpanTextView] */
    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        ConstraintLayout r0 = r17.inflate(2131562205, r18, false);
        ConstraintLayout r1 = r0;
        int r3 = 2131369923;
        ?? r9 = (DoraUrlSpanTextView) ViewBindings.findChildViewById(r0, 2131369923);
        if (r9 == 0) goto L32;
        r3 = 2131369924;
        VideoPlayView r10 = (VideoPlayView) ViewBindings.findChildViewById(r0, 2131369924);
        if (r10 == null) goto L32;
        r3 = 2131369925;
        ?? r11 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369925);
        if (r11 == 0) goto L32;
        r3 = 2131369941;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131369941);
        if (r8 == null) goto L32;
        final LarusDoraHOnboardingRadioBinding r2 = new LarusDoraHOnboardingRadioBinding(r1, r9, r10, r11, r8);
        DoraDevice r4 = DoraAdapterExtKt.h(kj4.a.g());
        boolean r5 = v19.h.a;
        Context r6 = getContext();
        if (r6 != null) goto L14;
        r6 = AppHost.a.getApplication();
    L14:
        if (v19.h.b(r6) == false) goto L16;
        String r7 = "dark";
    L17:
        final String r12 = l59.a.a("https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4//h/onboarding/talkie-walkie/${product}/v1/video_${sku}_${light_mode}.mp4", r4, r7);
        final String r13 = l59.a.a("https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4//h/onboarding/talkie-walkie/${product}/v1/image_${sku}_${light_mode}.png", r4, r7);
        g49.d.a("DoraExternalSmartOnboardingRadioFragment", "realCoverPath = " + r13 + ", realVideoPath = " + r12);
        r10.post(new x(r2, r12, r13));
        Intrinsics.checkNotNull(r2);
        if (ga0() == false) goto L21;
        r11.setText(2131903136);
        int r14 = com.larus.utils.j0.a;
        r9.setText(com.larus.utils.j0.d(2131903135));
    L29:
        this.o = r2;
        return r1;
    L21:
        r11.setText(2131903141);
        int r15 = com.larus.utils.j0.a;
        CharSequence r16 = com.larus.utils.j0.d(2131903140);
        String r20 = com.larus.utils.j0.d(2131903136);
        String r21 = "“" + r20 + 8221;
        if (StringsKt.contains$default(r16, r21, false, 2, null) == false) goto L24;
        r20 = r21;
    L24:
        int r22 = StringsKt.indexOf$default(r16, r20, 0, false, 6, null);
        if (r22 < 0) goto L28;
        int r23 = v19.c.a(2130972079, requireContext(), 2131103136);
        SpannableString r24 = new SpannableString(r16);
        r24.setSpan(new ForegroundColorSpan(r23), r22, r20.length() + r22, 33);
        r16 = r24;
    L28:
        r9.setText(r16);
        goto L29
    L16:
        r7 = "light";
    L32:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r3)));
    }
}
