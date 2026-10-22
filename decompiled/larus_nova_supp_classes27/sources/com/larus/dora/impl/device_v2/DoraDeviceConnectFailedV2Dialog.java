package com.larus.dora.impl.device_v2;

import android.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.dora.device.DoraDevice;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.dora.impl.databinding.LarusDoraDialogConnectFailedV2Binding;
import com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/larus/dora/impl/device_v2/DoraDeviceConnectFailedV2Dialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2;", "device", "Lcom/bytedance/dora/device/DoraDevice;", "(Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2;Lcom/bytedance/dora/device/DoraDevice;)V", "markdownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "enterPageTraced", "", "getModel", "()Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2;", "setModel", "(Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2;)V", "getDevice", "()Lcom/bytedance/dora/device/DoraDevice;", "setDevice", "(Lcom/bytedance/dora/device/DoraDevice;)V", "getTheme", "", "getFailedMsg", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDeviceConnectFailedV2Dialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int h = 0;
    public final lw8.d d;
    public boolean e;
    public final DoraDynamicViewModelV2 f;
    public final DoraDevice g;

    public final int getTheme() {
        return 2131951931;
    }

    public DoraDeviceConnectFailedV2Dialog() {
        this.d = new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31);
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.e == true) goto L6;
        j49.b.d();
        this.e = true;
        return;
    }

    public static void S90(DoraDeviceConnectFailedV2Dialog r1) {
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

    public DoraDeviceConnectFailedV2Dialog(DoraDynamicViewModelV2 r2, DoraDevice r3) {
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
        com.larus.utils.i0.a.getClass();
        int r9 = ((r8 - com.larus.utils.i0.g()) - com.larus.utils.i0.e()) - i5.c0();
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
        LarusDoraDialogConnectFailedV2Binding r7 = LarusDoraDialogConnectFailedV2Binding.a(r4, r5);
        StringBuilder r8 = new StringBuilder();
        if (o59.a.l(this.g) == false) goto L5;
        StringBuilder r9 = new StringBuilder();
        int r1 = com.larus.utils.j0.a;
        r9.append(com.larus.utils.j0.d(2131902893));
        r9.append('\n');
        r8.append(r9.toString());
        r8.append(com.larus.utils.j0.d(2131902890) + '\n');
        r8.append(com.larus.utils.j0.d(2131902891) + '\n');
        r8.append(com.larus.utils.j0.d(2131902892));
    L6:
        String r10 = r8.toString();
        gw8.c.a.getClass();
        gw8.c r11 = gw8.c.a.b();
        if (r11 == null) goto L9;
        lw8.l r12 = gw8.c.b.b(r11, r7.c, r10, false, this.d);
    L10:
        if (r12 == null) goto L12;
        r7.c.setMarkdown(r12);
    L13:
        e1.d(r7.b, new u(this));
        e1.d(r7.d, new v(this));
        e1.d(r7.a, new w(this));
        return r7.a;
    L12:
        r7.c.setText(r10);
        goto L13
    L9:
        r12 = null;
        goto L10
    L5:
        StringBuilder r13 = new StringBuilder();
        int r2 = com.larus.utils.j0.a;
        r13.append(com.larus.utils.j0.d(2131903950));
        r13.append('\n');
        r8.append(r13.toString());
        r8.append(com.larus.utils.j0.d(2131903947) + '\n');
        r8.append(com.larus.utils.j0.d(2131903948) + '\n');
        r8.append(com.larus.utils.j0.d(2131903949));
        goto L6
    }
}
