package com.larus.dora.impl.onboarding.lite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.databinding.LarusDoraOnboardingDialogBinding;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.utils.e1;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingDialogFragment;", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogBaseFragment;", "<init>", "()V", "productType", "Lcom/bytedance/dora/annotation/ProductNameType;", "productTypeDisplayName", "", "sku", "gotoOnboardingPage", "", "device", "Lcom/bytedance/dora/device/DoraDevice;", "handleBottomTips", "state", "Lcom/larus/dora/impl/onboarding/OnboardingUiState;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraLiteOnboardingDialogFragment extends DoraOnboardingDialogBaseFragment {
    public static final /* synthetic */ int l = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment
    public final String ca0() {
        return "";
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment
    public final String ba0() {
        int r0 = com.larus.utils.j0.a;
        return com.larus.utils.j0.d(2131903933);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        LarusDoraOnboardingDialogBinding r0 = this.d;
        if (r0 == null) goto L8;
        DoraMovieView r1 = r0.g;
        if (r1 == null) goto L9;
        r1.g();
        r1.f();
        return;
    L9:
        return;
    }

    public DoraLiteOnboardingDialogFragment() {
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment
    public final ProductNameType aa0() {
        return ProductNameType.DORA_LITE;
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment
    public final void X90(DoraDevice r10) {
        Intrinsics.checkNotNullParameter(r10, "device");
        Bundle r4 = getArguments();     // Catch: Throwable -> L27
        if (r4 == null) goto L6;
        String r5 = r4.getString("key_dora_onboarding_origin_from");     // Catch: Throwable -> L27
    L7:
        Context r6 = getContext();     // Catch: Throwable -> L27
        if (r6 != null) goto L10;
        return;
    L10:
        Intent r7 = new Intent("action.DEVICE_UPDATE_DYNAMIC");     // Catch: Throwable -> L27
        r7.putExtra("mac", r10.mac);     // Catch: Throwable -> L27
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r7);     // Catch: Throwable -> L27
        boolean r8 = ObricFeatureServiceDelegate.b.b();     // Catch: Throwable -> L27
        if (Intrinsics.areEqual(r5, "device_manage") == true) goto L14;
        if (r8 == true) goto L14;
        n1.i();     // Catch: Throwable -> L27
    L16:
        com.bytedance.router.i r3 = SmartRouter.buildRoute(r6, "//dora_onboarding_v2");     // Catch: Throwable -> L27
        r3.d = 2130772372;     // Catch: Throwable -> L27
        r3.e = 2130772399;     // Catch: Throwable -> L27
        r3.c.putExtra("key_dora_onboarding_device", com.larus.dora.impl.onboarding.x.c(r10));     // Catch: Throwable -> L27
        r3.c.putExtra("bury_point_source", this.i);     // Catch: Throwable -> L27
        r3.d();     // Catch: Throwable -> L27
        dismissAllowingStateLoss();     // Catch: Exception -> L19 Throwable -> L27
    L23:
        FragmentActivity r11 = getActivity();     // Catch: Throwable -> L27
        if (r11 == null) goto L42;
        r11.finish();     // Catch: Throwable -> L27
        return;
    L42:
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L27
        Throwable r12 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L27
        if (r12 == null) goto L23;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L27
    L14:
        if (r8 == false) goto L16;
        g49.d.d("DoraLiteOnboardingDialogFragment", "skip legacy device management route, from=" + r5);     // Catch: Throwable -> L27
        goto L16
    L6:
        r5 = null;
    L27:
        th = move-exception;
        g49.d.c("DoraLiteOnboardingDialogFragment", "gotoDeviceGuide: exception", th);
        dismissAllowingStateLoss();     // Catch: Exception -> L31
        return;
    L31:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r13 = DialogFragmentLancet.sLastShowStack;
        if (r13 == null) goto L43;
        com.bytedance.crash.d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment
    public final void Y90(com.larus.dora.impl.onboarding.q0 r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        LarusDoraOnboardingDialogBinding r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r3, com.larus.dora.impl.onboarding.q0.e.a) == false) goto L8;
        e1.x(r0.b);
        r0.b.setText(2131903648);
        return;
    L8:
        if (Intrinsics.areEqual(r3, com.larus.dora.impl.onboarding.q0.f.a) == false) goto L11;
        e1.x(r0.b);
        r0.b.setText(2131903649);
        return;
    L11:
        if ((r3 instanceof com.larus.dora.impl.onboarding.q0.d) == false) goto L14;
        e1.o(r0.b);
        return;
    L14:
        if ((r3 instanceof com.larus.dora.impl.onboarding.q0.c) == false) goto L17;
        e1.o(r0.b);
        return;
    L17:
        if ((r3 instanceof com.larus.dora.impl.onboarding.q0.b) == false) goto L19;
        e1.o(r0.b);
        return;
    L19:
        e1.o(r0.b);
    }

    /* JADX WARN: Type inference failed for: r12v14, types: [com.larus.dora.impl.onboarding.lite.h] */
    @Override // com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        final LarusDoraOnboardingDialogBinding r13 = this.d;
        if (r13 == null) goto L5;
        final ?? r14 = new h(r13);
        r13.g.post(new i(r13, r14));
    L5:
        Bundle r15 = getArguments();
        boolean r16 = false;
        if (r15 == null) goto L10;
        boolean r1 = true;
        if (r15.getBoolean("key_dora_onboarding_auto_connect") != true) goto L10;
    L11:
        if (r1 == false) goto L52;
        Bundle r17 = getArguments();
        if (r17 == null) goto L15;
        r16 = r17.getBoolean("key_dora_onboarding_auto_connect", false);
    L15:
        if (r16 == false) goto L52;
        Bundle r18 = getArguments();
        if (r18 == null) goto L22;
        String r110 = r18.getString("key_dora_onboarding_device_name");
        if (r110 == null) goto L22;
        String r2 = r110;
    L23:
        Bundle r111 = getArguments();
        if (r111 == null) goto L29;
        String r112 = r111.getString("key_dora_onboarding_device_mac");
        if (r112 == null) goto L29;
        String r3 = r112;
    L30:
        Bundle r113 = getArguments();
        if (r113 == null) goto L36;
        String r114 = r113.getString("key_dora_onboarding_device_sn");
        if (r114 == null) goto L36;
        String r4 = r114;
    L37:
        ProductNameType r115 = ProductNameType.DORA_LITE;
        int r5 = r115.deviceType;
        Bundle r0 = getArguments();
        if (r0 == null) goto L40;
        int r6 = r0.getInt("key_dora_onboarding_device_sku");
    L41:
        Bundle r7 = getArguments();
        if (r7 == null) goto L45;
        int[] r8 = r7.getIntArray("key_dora_onboarding_device_battery");
        if (r8 == null) goto L45;
    L46:
        int[] r9 = r8;
        Bundle r10 = getArguments();
        if (r10 == null) goto L50;
        int[] r20 = r10.getIntArray("key_dora_onboarding_device_charge");
        if (r20 == null) goto L50;
    L51:
        DoraDevice r116 = com.larus.dora.impl.onboarding.x.b(new DoraOnboardingDevice(r2, r3, r4, r5, r6, r9, r20, r115.id, 1));
        V90().bindAndConnect(r116);
    L50:
        r20 = new int[]{-1, -1, -1};
    L45:
        r8 = new int[]{-1, -1, -1};
        goto L46
    L40:
        r6 = -1;
    L36:
        r4 = "";
    L29:
        r3 = "";
    L22:
        r2 = "";
    L52:
        int r117 = j49.a.a;
        j49.a.g(this.i, "earphone_connection");
        return;
    L10:
        r1 = false;
        goto L11
    }
}
