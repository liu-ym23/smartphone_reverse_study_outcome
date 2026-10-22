package com.larus.dora.impl.device.manage.settings;

import android.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.dora.impl.databinding.LarusDoraDialogConnectFailedV2Binding;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.j0;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010*\u001a\u00020\u0017H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsConnectFailedDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel;", "device", "Lcom/bytedance/dora/device/DoraDevice;", "(Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel;Lcom/bytedance/dora/device/DoraDevice;)V", "markdownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "enterPageTraced", "", "getModel", "()Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel;", "setModel", "(Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel;)V", "getDevice", "()Lcom/bytedance/dora/device/DoraDevice;", "setDevice", "(Lcom/bytedance/dora/device/DoraDevice;)V", "onReconnectClick", "Lkotlin/Function0;", "", "getOnReconnectClick", "()Lkotlin/jvm/functions/Function0;", "setOnReconnectClick", "(Lkotlin/jvm/functions/Function0;)V", "getTheme", "", "getFailedMsg", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDeviceSettingsConnectFailedDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int i = 0;
    public final lw8.d d;
    public boolean e;
    public final DoraDeviceSettingsViewModel f;
    public final DoraDevice g;
    public Function0<Unit> h;

    public final int getTheme() {
        return 2131951931;
    }

    public DoraDeviceSettingsConnectFailedDialog() {
        this.d = new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31);
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.e == true) goto L6;
        j49.b.d();
        this.e = true;
        return;
    }

    public static void S90(DoraDeviceSettingsConnectFailedDialog r1) {
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

    public DoraDeviceSettingsConnectFailedDialog(DoraDeviceSettingsViewModel r2, DoraDevice r3) {
        Intrinsics.checkNotNullParameter(r2, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this();
        this.g = r3;
        this.f = r2;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        BottomSheetDialog r5 = getDialog();
        View r0 = null;
        if ((r5 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r6 = r5;
    L6:
        if (r6 == null) goto L8;
        r0 = r6.findViewById(2131368870);
    L8:
        int r7 = m0.a;
        int r8 = m0.a(getContext());
        i0.a.getClass();
        int r9 = ((r8 - i0.g()) - i0.e()) - i5.c0();
        if (r0 == null) goto L12;
        ViewGroup.LayoutParams r10 = r0.getLayoutParams();
        r10.height = r9;
        r0.setLayoutParams(r10);
        BottomSheetBehavior r11 = BottomSheetBehavior.from(r0);
        r0.setBackgroundResource(R.color.transparent);
        r11.setState(3);
        r11.setPeekHeight(r9);
        return;
    L12:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        final LarusDoraDialogConnectFailedV2Binding r7 = LarusDoraDialogConnectFailedV2Binding.a(r4, r5);
        StringBuilder r8 = new StringBuilder();
        if (o59.a.l(this.g) == false) goto L14;
        StringBuilder r9 = new StringBuilder();
        int r2 = j0.a;
        r9.append(j0.d(2131902893));
        r9.append('\n');
        r8.append(r9.toString());
        r8.append(j0.d(2131902890) + '\n');
        r8.append(j0.d(2131902891) + '\n');
        DoraDevice r10 = this.g;
        if (r10 != null) goto L7;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == false) goto L12;
        int r12 = 2131902587;
    L13:
        r8.append(j0.d(r12));
    L15:
        String r13 = r8.toString();
        gw8.c.a.getClass();
        gw8.c r14 = gw8.c.a.b();
        if (r14 == null) goto L18;
        lw8.l r15 = gw8.c.b.b(r14, r7.c, r13, false, this.d);
    L19:
        if (r15 == null) goto L21;
        r7.c.setMarkdown(r15);
    L22:
        e1.d(r7.b, new a(this));
        e1.d(r7.d, new b(this, r7));
        e1.d(r7.a, new c(this));
        return r7.a;
    L21:
        r7.c.setText(r13);
        goto L22
    L18:
        r15 = null;
        goto L19
    L12:
        r12 = 2131902892;
        goto L13
    L7:
        if (r10.productId != ProductNameType.DORA_G2.id) goto L9;
        r11 = true;
        goto L10
    L14:
        StringBuilder r16 = new StringBuilder();
        int r3 = j0.a;
        r16.append(j0.d(2131903950));
        r16.append('\n');
        r8.append(r16.toString());
        r8.append(j0.d(2131903947) + '\n');
        r8.append(j0.d(2131903948) + '\n');
        r8.append(j0.d(2131903949));
        goto L15
    }
}
