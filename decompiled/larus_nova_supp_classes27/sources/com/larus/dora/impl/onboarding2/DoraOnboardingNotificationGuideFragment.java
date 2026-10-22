package com.larus.dora.impl.onboarding2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.avlink.api.DoraAVLinkDelegate;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraOnboardingV2KeepAliveScrollableBinding;
import com.larus.dora.impl.nl.permission.CategoryWhenNotGranted;
import com.larus.dora.impl.nl.permission.ProactivePermission;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment;
import com.larus.dora.impl.onboarding.OnboardingAvatarProvider;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.larus.home.impl.sdk.s;
import com.larus.image.loader.b0;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/dora/impl/onboarding2/DoraOnboardingNotificationGuideFragment;", "Lcom/larus/dora/impl/onboarding/DoraOnboardingBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingV2KeepAliveScrollableBinding;", "notificationSwitch", "Lcom/larus/bmhome/view/item/ItemTextToggle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initDoraNotification", "setupAvatar", "handleContinueClick", "showProactiveNotificationPrivacyDialog", "checkPermissionAndEnableNotification", "goDeviceManagementPage", "goNotificationSettingPage", "shouldShowSkipButton", "", "getCurrentPageName", "", "getCurrentCardName", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraOnboardingNotificationGuideFragment extends DoraOnboardingBaseFragment {
    public static final /* synthetic */ int o = 0;
    public LarusDoraOnboardingV2KeepAliveScrollableBinding m;
    public ItemTextToggle n;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final boolean ba0() {
        return false;
    }

    public final String k() {
        return "notification_broadcast";
    }

    public final void ca0() {
        if (DoraAVLinkDelegate.b.y() == false) goto L5;
        List r0 = CollectionsKt.listOf(new ProactivePermission[]{ProactivePermission.POST_NOTIFICATION, ProactivePermission.NOTIFICATION_LISTENER});
    L6:
        int r1 = p59.b.a;
        p59.b.c(this, r0, CategoryWhenNotGranted.INTERRUPT, new d(this));
        return;
    L5:
        r0 = CollectionsKt.listOf(ProactivePermission.NOTIFICATION_LISTENER);
        goto L6
    }

    public final void da0() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L7;
        s r1 = r0.s0();
        if (r1 == null) goto L7;
        r1.N(this);
    L7:
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L11;
        r2.finish();
        return;
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final String V90() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("arg_card_name");
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.m = null;
        this.n = null;
    }

    public DoraOnboardingNotificationGuideFragment() {
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        LarusDoraOnboardingV2KeepAliveScrollableBinding r10 = this.m;
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
        this.n = r1;
        ItemGroup r13 = this.f;
        if (r13 == null) goto L14;
        r13.addView(r1);
    L14:
        ItemGroup r14 = this.f;
        if (r14 == null) goto L17;
        e1.x(r14);
    L17:
        LarusDoraOnboardingV2KeepAliveScrollableBinding r15 = this.m;
        if (r15 == null) goto L22;
        CircleSimpleDraweeView r2 = r15.c;
        if (r2 == null) goto L22;
        CircleSimpleDraweeView.f(r2, UriProtector.parse("res://" + AppHost.a.getApplication().getPackageName() + "/2131240605"), null, null, 0, 0, 62);
    L22:
        String r16 = OnboardingAvatarProvider.c;
        if (r16 == null) goto L29;
        LarusDoraOnboardingV2KeepAliveScrollableBinding r17 = this.m;
        if (r17 == null) goto L30;
        CircleSimpleDraweeView r3 = r17.c;
        if (r3 == null) goto L30;
        CircleSimpleDraweeView.f(r3, b0.a(r16, "chat.user_avatar", false, false, 6), null, null, 0, 0, 62);
    L30:
        LarusDoraOnboardingV2KeepAliveScrollableBinding r18 = this.m;
        if (r18 == null) goto L35;
        AppCompatTextView r20 = r18.f;
        if (r20 == null) goto L35;
        r20.setText(2131900385);
    L35:
        LarusDoraOnboardingV2KeepAliveScrollableBinding r21 = this.m;
        if (r21 == null) goto L40;
        DoraUrlSpanTextView r22 = r21.d;
        if (r22 == null) goto L40;
        int r23 = j0.a;
        r22.setUrlSpannedText(j0.d(2131903655));
    L40:
        ItemTextToggle r24 = this.n;
        if (r24 == null) goto L45;
        CustomSwitchCompat r25 = r24.getToggleView();
        if (r25 == null) goto L45;
        r25.setChecked(true);
    L45:
        TextView r26 = this.h;
        if (r26 == null) goto L48;
        e1.x(r26);
        r26.setText(2131902466);
        e1.d(r26, new com.larus.dora.impl.onboarding2.a(this));
    L48:
        FragmentActivity r27 = getActivity();
        if (r27 == null) goto L54;
        View r28 = r27.findViewById(2131369901);
        if (r28 == null) goto L55;
        e1.x(r28);
        e1.d(r28, new b(this));
        return;
    L55:
        return;
    L54:
        return;
    L29:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraOnboardingNotificationGuideFragment$setupAvatar$2(this, null), 3, null);
        goto L30
    L5:
        r11 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDoraOnboardingV2KeepAliveScrollableBinding r4 = LarusDoraOnboardingV2KeepAliveScrollableBinding.a(r1, r2);
        this.m = r4;
        return r4.a;
    }
}
