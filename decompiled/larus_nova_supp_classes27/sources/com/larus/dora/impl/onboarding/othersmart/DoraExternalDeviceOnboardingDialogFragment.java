package com.larus.dora.impl.onboarding.othersmart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.databinding.LarusDoraOnboardingDialogBinding;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\"\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalDeviceOnboardingDialogFragment;", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogBaseFragment;", "<init>", "()V", "sku", "", "productType", "Lcom/bytedance/dora/annotation/ProductNameType;", "productTypeDisplayName", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "gotoOnboardingPage", "device", "Lcom/bytedance/dora/device/DoraDevice;", "handleUiState", "state", "Lcom/larus/dora/impl/onboarding/OnboardingUiState;", "updateConnectFailedUI", "updateScanUI", "updateFoundDeviceUI", "updateScanForLongTimeUI", "getTitleText", "", "handleBottomTips", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraExternalDeviceOnboardingDialogFragment extends DoraOnboardingDialogBaseFragment {
    public static final /* synthetic */ int m = 0;
    public String l;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment
    public final String ba0() {
        int r0 = com.larus.utils.j0.a;
        return com.larus.utils.j0.d(2131903933);
    }

    public DoraExternalDeviceOnboardingDialogFragment() {
        this.l = "";
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

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment
    public final ProductNameType aa0() {
        return ProductNameType.H_FREE_CLIP_2;
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment
    public final String ca0() {
        return this.l;
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment
    public final int W90(com.larus.dora.impl.onboarding.q0 r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if (Intrinsics.areEqual(r3, com.larus.dora.impl.onboarding.q0.e.a) == false) goto L6;
        return 2131902189;
    L6:
        if (Intrinsics.areEqual(r3, com.larus.dora.impl.onboarding.q0.f.a) == false) goto L9;
        return 2131903843;
    L9:
        if ((r3 instanceof com.larus.dora.impl.onboarding.q0.d) == false) goto L12;
    L10:
        return 2131903675;
    L12:
        if ((r3 instanceof com.larus.dora.impl.onboarding.q0.c) == true) goto L10;
        if ((r3 instanceof com.larus.dora.impl.onboarding.q0.a) == false) goto L10;
        return 2131903839;
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment
    public final void X90(DoraDevice r7) {
        Intrinsics.checkNotNullParameter(r7, "device");
        Context r2 = getContext();     // Catch: Throwable -> L17
        if (r2 != null) goto L6;
        return;
    L6:
        Intent r3 = new Intent("action.DEVICE_UPDATE_DYNAMIC");     // Catch: Throwable -> L17
        r3.putExtra("mac", r7.mac);     // Catch: Throwable -> L17
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r3);     // Catch: Throwable -> L17
        com.bytedance.router.i r4 = SmartRouter.buildRoute(r2, "//dora_onboarding_v2");     // Catch: Throwable -> L17
        r4.d = 2130772372;     // Catch: Throwable -> L17
        r4.e = 2130772399;     // Catch: Throwable -> L17
        String r5 = this.i;     // Catch: Throwable -> L17
        r4.c.putExtra("bury_point_source", r5);     // Catch: Throwable -> L17
        DoraOnboardingDevice r8 = com.larus.dora.impl.onboarding.x.c(r7);     // Catch: Throwable -> L17
        r4.c.putExtra("key_dora_onboarding_device", r8);     // Catch: Throwable -> L17
        r4.d();     // Catch: Throwable -> L17
        dismissAllowingStateLoss();     // Catch: Exception -> L9 Throwable -> L17
    L13:
        FragmentActivity r9 = getActivity();     // Catch: Throwable -> L17
        if (r9 == null) goto L32;
        r9.finish();     // Catch: Throwable -> L17
        return;
    L32:
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r10 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r10 == null) goto L13;
        com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        g49.d.c("DoraExternalDeviceOnboardingDialogFragment", "gotoDeviceGuide: exception", th);
        dismissAllowingStateLoss();     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r11 = DialogFragmentLancet.sLastShowStack;
        if (r11 == null) goto L33;
        com.bytedance.crash.d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment
    public final void Y90(com.larus.dora.impl.onboarding.q0 r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        LarusDoraOnboardingDialogBinding r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r4, com.larus.dora.impl.onboarding.q0.e.a) == false) goto L8;
        e1.x(r0.b);
        r0.b.setText(2131903758);
        return;
    L8:
        if (Intrinsics.areEqual(r4, com.larus.dora.impl.onboarding.q0.f.a) == false) goto L10;
        e1.x(r0.b);
        r0.b.setText(2131903759);
        return;
    L10:
        e1.x(r0.b);
        r0.b.setText(2131903758);
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment
    public final Object Z90(com.larus.dora.impl.onboarding.q0 r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        super.Z90(r3);
        if ((r3 instanceof com.larus.dora.impl.onboarding.q0.d) == false) goto L6;
        ea0(((com.larus.dora.impl.onboarding.q0.d) r3).a);
    L24:
        return Unit.INSTANCE;
    L6:
        if ((r3 instanceof com.larus.dora.impl.onboarding.q0.c) == false) goto L9;
        ea0(((com.larus.dora.impl.onboarding.q0.c) r3).a);
        goto L24
    L9:
        if ((r3 instanceof com.larus.dora.impl.onboarding.q0.f) == false) goto L14;
        LarusDoraOnboardingDialogBinding r4 = this.d;
        if (r4 == null) goto L24;
        DoraMovieView r0 = r4.g;
        r0.g();
        r0.f();
        Intrinsics.checkNotNull(r0);
        e1.o(r0);
        SimpleDraweeView r1 = r4.i;
        Intrinsics.checkNotNull(r1);
        e1.o(r1);
        AppCompatTextView r2 = r4.e;
        Intrinsics.checkNotNull(r2);
        e1.x(r2);
        r2.setText(2131903841);
        AppCompatTextView r5 = r4.c;
        Intrinsics.checkNotNull(r5);
        e1.x(r5);
        r5.setText(2131903102);
        goto L24
    L14:
        if ((r3 instanceof com.larus.dora.impl.onboarding.q0.e) == false) goto L19;
        final LarusDoraOnboardingDialogBinding r6 = this.d;
        if (r6 == null) goto L24;
        e1.x(r6.g);
        r6.g.post(new b(r6));
        goto L24
    L19:
        if ((r3 instanceof com.larus.dora.impl.onboarding.q0.a) == false) goto L24;
        LarusDoraOnboardingDialogBinding r7 = this.d;
        if (r7 == null) goto L24;
        AppCompatTextView r8 = r7.e;
        Intrinsics.checkNotNull(r8);
        e1.x(r8);
        r8.setText(2131903841);
        AppCompatTextView r9 = r7.c;
        Intrinsics.checkNotNull(r9);
        e1.x(r9);
        r9.setText(2131903838);
        e1.o(r7.j);
        e1.o(r7.i);
        goto L24
    }

    public final void ea0(DoraDevice r5) {
        LarusDoraOnboardingDialogBinding r0 = this.d;
        if (r0 == null) goto L6;
        DoraMovieView r1 = r0.g;
        r1.g();
        r1.f();
        Intrinsics.checkNotNull(r1);
        e1.o(r1);
        SimpleDraweeView r2 = r0.i;
        Intrinsics.checkNotNull(r2);
        e1.x(r2);
        GenericDraweeHierarchyBuilder r3 = GenericDraweeHierarchyBuilder.newInstance(r2.getContext().getResources());
        r3.setPlaceholderImage(2131240497);
        ScalingUtils.ScaleType r4 = ScalingUtils.ScaleType.CENTER_INSIDE;
        r3.setPlaceholderImageScaleType(r4);
        r3.setActualImageScaleType(r4);
        r2.setHierarchy(r3.build());
        ImageLoaderKt.u(r2, l59.a.a("https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4/h/scanning_h_resize/${product}/image_${sku}.png", r5, "light"), "dora_dynamic_biz_tag");
        AppCompatTextView r6 = r0.c;
        Intrinsics.checkNotNull(r6);
        e1.o(r6);
        return;
    }

    public final void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L6;
        String r4 = r3.getString("extra_sku");
        if (r4 == null) goto L6;
    L7:
        this.l = r4;
        return;
    L6:
        r4 = "";
        goto L7
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        int r4 = j49.a.a;
        j49.a.g(this.i, "earphone_connection");
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingDialogBaseFragment
    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        super.onCreateView(r3, r4, r5);
        LarusDoraOnboardingDialogBinding r6 = this.d;
        if (r6 == null) goto L5;
        FrameLayout r7 = r6.h;
    L6:
        if (r7 == null) goto L8;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
    L10:
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
    L14:
        if (r9 == null) goto L16;
        r9.height = i5.K();
        r9.topMargin = 0;
        r7.setLayoutParams(r9);
    L16:
        LarusDoraOnboardingDialogBinding r10 = this.d;
        if (r10 == null) goto L19;
        SimpleDraweeView r11 = r10.i;
    L20:
        if (r11 == null) goto L22;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
    L24:
        if ((r12 instanceof FrameLayout.LayoutParams) == false) goto L26;
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12;
    L27:
        if (r13 == null) goto L29;
        r13.width = i5.K();
        r13.height = i5.K();
        r13.gravity = 17;
        r13.setMargins(0, 0, 0, 0);
        r11.setLayoutParams(r13);
    L29:
        LarusDoraOnboardingDialogBinding r14 = this.d;
        if (r14 != null) goto L32;
        return null;
    L32:
        return r14.a;
    L26:
        r13 = null;
        goto L27
    L22:
        r12 = null;
        goto L24
    L19:
        r11 = null;
        goto L20
    L12:
        r9 = null;
        goto L14
    L8:
        r8 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }
}
