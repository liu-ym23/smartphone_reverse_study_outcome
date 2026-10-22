package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.avlink.api.DoraAVLinkDelegate;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraOnboardingV2KeepAliveScrollableBinding;
import com.larus.dora.impl.nl.permission.CategoryWhenNotGranted;
import com.larus.dora.impl.nl.permission.ProactivePermission;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\u000fH\u0002J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010&\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006("}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedNotificationFragment;", "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingV2KeepAliveScrollableBinding;", "notificationSwitch", "Lcom/larus/bmhome/view/item/ItemTextToggle;", "streamlinedModel", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "getStreamlinedModel", "()Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "streamlinedModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initNotificationSwitch", "setupButtons", "setupAvatar", "handleContinueClick", "showNotificationPrivacyDialog", "checkPermissionAndEnableNotification", "goNextPage", "shouldShowSkipButton", "", "getCurrentPageName", "", "getCurrentCardName", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraHStreamlinedNotificationFragment extends DoraExternalOnboardingBaseFragment {
    public static final /* synthetic */ int r = 0;
    public LarusDoraOnboardingV2KeepAliveScrollableBinding o;
    public ItemTextToggle p;
    public final Lazy q;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final boolean ba0() {
        return false;
    }

    public final String k() {
        return "notification_broadcast";
    }

    public final void fa0() {
        if (DoraAVLinkDelegate.b.y() == false) goto L5;
        List r0 = CollectionsKt.listOf(new ProactivePermission[]{ProactivePermission.POST_NOTIFICATION, ProactivePermission.NOTIFICATION_LISTENER});
    L6:
        int r1 = p59.b.a;
        p59.b.c(this, r0, CategoryWhenNotGranted.INTERRUPT, new y(this));
        return;
    L5:
        r0 = CollectionsKt.listOf(ProactivePermission.NOTIFICATION_LISTENER);
        goto L6
    }

    public final DoraHStreamlinedOnboardingViewModel ga0() {
        return (DoraHStreamlinedOnboardingViewModel) this.q.getValue();
    }

    public DoraHStreamlinedNotificationFragment() {
        this.q = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraHStreamlinedOnboardingViewModel.class), new DoraHStreamlinedNotificationFragment$special$$inlined$activityViewModels$default$1(this), new DoraHStreamlinedNotificationFragment$special$$inlined$activityViewModels$default$2(this));
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final String V90() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("arg_card_name");
    }

    public final void ha0() {
        ga0().stopTTS("streamlined notification goNextPage");
        Z90(new DoraHStreamlinedKeepAliveFragment());
    }

    public final void onDestroyView() {
        ga0().stopTTS("streamlined notification onDestroyView");
        FragmentActivity r0 = getActivity();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == true) goto L9;
        ga0().releasePageEntryTTS("notification_broadcast");
    L9:
        super.onDestroyView();
        this.o = null;
        this.p = null;
        return;
    L5:
        if (r0.isChangingConfigurations() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        ca0().exitOnboardingMode();
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        LarusDoraOnboardingV2KeepAliveScrollableBinding r10 = this.o;
        if (r10 == null) goto L5;
        ItemGroup r11 = r10.e;
    L6:
        this.f = r11;
        Context r12 = getContext();
        if (r12 == null) goto L17;
        ItemGroup r0 = this.f;
        if (r0 == null) goto L11;
        r0.removeAllViews();
    L11:
        ItemTextToggle r1 = new ItemTextToggle(r12);
        r1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r1.setText(getString(2131904110));
        r1.setTextFontWeight(500);
        r1.setBackgroundResource(2131240618);
        this.p = r1;
        ItemGroup r13 = this.f;
        if (r13 == null) goto L14;
        r13.addView(r1);
    L14:
        ItemGroup r14 = this.f;
        if (r14 == null) goto L17;
        e1.x(r14);
    L17:
        LarusDoraOnboardingV2KeepAliveScrollableBinding r15 = this.o;
        if (r15 == null) goto L22;
        CircleSimpleDraweeView r2 = r15.c;
        if (r2 == null) goto L22;
        CircleSimpleDraweeView.f(r2, UriProtector.parse("res://" + requireContext().getPackageName() + "/2131240605"), null, null, 0, 0, 62);
    L22:
        ga0().fetchAvatarUrl();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedNotificationFragment$setupAvatar$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        LarusDoraOnboardingV2KeepAliveScrollableBinding r16 = this.o;
        if (r16 == null) goto L27;
        AppCompatTextView r17 = r16.f;
        if (r17 == null) goto L27;
        r17.setText(2131900385);
    L27:
        LarusDoraOnboardingV2KeepAliveScrollableBinding r18 = this.o;
        if (r18 == null) goto L32;
        DoraUrlSpanTextView r20 = r18.d;
        if (r20 == null) goto L32;
        int r21 = com.larus.utils.j0.a;
        r20.setUrlSpannedText(com.larus.utils.j0.d(2131903655));
    L32:
        DoraExternalOnboardingViewModel.playPageEntryTTSIfNeeded$default(ga0(), "notification_broadcast", 2131903656, 0, 4, null);
        ItemTextToggle r22 = this.p;
        if (r22 == null) goto L37;
        CustomSwitchCompat r23 = r22.getToggleView();
        if (r23 == null) goto L37;
        r23.setChecked(true);
    L37:
        TextView r24 = this.h;
        if (r24 == null) goto L40;
        e1.x(r24);
        r24.setText(2131902466);
        e1.d(r24, new v(this));
    L40:
        FragmentActivity r25 = getActivity();
        if (r25 == null) goto L46;
        TextView r26 = (TextView) r25.findViewById(2131369901);
        if (r26 == null) goto L47;
        e1.x(r26);
        r26.setText(2131902346);
        e1.d(r26, new w(this));
        return;
    L47:
        return;
    L46:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDoraOnboardingV2KeepAliveScrollableBinding r4 = LarusDoraOnboardingV2KeepAliveScrollableBinding.a(r1, r2);
        this.o = r4;
        return r4.a;
    }
}
