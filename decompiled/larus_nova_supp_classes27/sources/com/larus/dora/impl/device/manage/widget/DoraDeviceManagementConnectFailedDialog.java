package com.larus.dora.impl.device.manage.widget;

import android.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraDialogConnectFailedV2Binding;
import com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.j0;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import lw8.l;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0002J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\u0014\u0010\"\u001a\u0004\u0018\u00010\u00112\b\u0010#\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/dora/impl/device/manage/widget/DoraDeviceManagementConnectFailedDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "markdownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "enterPageTraced", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel;", "getModel", "()Lcom/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel;", "model$delegate", "Lkotlin/Lazy;", "deviceMac", "", "device", "Lcom/bytedance/dora/device/DoraDevice;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "", "getFailedMsg", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "findDeviceByMac", "mac", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDeviceManagementConnectFailedDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int h = 0;
    public final lw8.d d;
    public boolean e;
    public final Lazy f;
    public DoraDevice g;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public DoraDeviceManagementConnectFailedDialog() {
        this.d = new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraGDeviceManagementViewModel.class), new DoraDeviceManagementConnectFailedDialog$special$$inlined$activityViewModels$default$1(this), new DoraDeviceManagementConnectFailedDialog$special$$inlined$activityViewModels$default$2(this));
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.e == true) goto L6;
        j49.b.d();
        this.e = true;
        return;
    }

    public static void S90(DoraDeviceManagementConnectFailedDialog r1) {
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

    public final void onCreate(Bundle r5) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r5);
        Bundle r6 = getArguments();
        DoraDevice r0 = null;
        Object r1 = null;
        if (r6 == null) goto L5;
        String r7 = r6.getString("arg_device_mac");
    L6:
        if (r7 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L21;
        Iterator r3 = DoraAdapterExtKt.k(kj4.a.g()).iterator();
    L16:
        if (r3.hasNext() == false) goto L20;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((DoraDevice) r4).mac, r7) == false) goto L16;
        r1 = r4;
    L20:
        r0 = (DoraDevice) r1;
    L21:
        this.g = r0;
        return;
    L8:
        if (r7.length() == 0) goto L11;
        r2 = false;
        goto L12
    L5:
        r7 = null;
        goto L6
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

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        LarusDoraDialogConnectFailedV2Binding r8 = LarusDoraDialogConnectFailedV2Binding.a(r5, r6);
        StringBuilder r9 = new StringBuilder();
        DoraDevice r10 = this.g;
        boolean r1 = true;
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L9:
        if (r11 == false) goto L20;
        StringBuilder r12 = new StringBuilder();
        int r3 = j0.a;
        r12.append(j0.d(2131902893));
        r12.append('\n');
        r9.append(r12.toString());
        r9.append(j0.d(2131902890) + '\n');
        r9.append(j0.d(2131902891) + '\n');
        DoraDevice r13 = this.g;
        if (r13 != null) goto L13;
    L15:
        r1 = false;
    L16:
        if (r1 == false) goto L18;
        int r14 = 2131902587;
    L19:
        r9.append(j0.d(r14));
    L21:
        String r15 = r9.toString();
        gw8.c.a.getClass();
        gw8.c r16 = gw8.c.a.b();
        if (r16 == null) goto L24;
        l r17 = gw8.c.b.b(r16, r8.c, r15, false, this.d);
    L25:
        if (r17 == null) goto L27;
        r8.c.setMarkdown(r17);
    L28:
        e1.d(r8.b, new com.larus.dora.impl.device.manage.widget.a(this));
        e1.d(r8.d, new b(this));
        e1.d(r8.a, new c(this));
        return r8.a;
    L27:
        r8.c.setText(r15);
        goto L28
    L24:
        r17 = null;
        goto L25
    L18:
        r14 = 2131902892;
        goto L19
    L13:
        if (r13.productId != ProductNameType.DORA_G2.id) goto L15;
    L20:
        StringBuilder r18 = new StringBuilder();
        int r2 = j0.a;
        r18.append(j0.d(2131903950));
        r18.append('\n');
        r9.append(r18.toString());
        r9.append(j0.d(2131903947) + '\n');
        r9.append(j0.d(2131903948) + '\n');
        r9.append(j0.d(2131903949));
        goto L21
    L5:
        if (o59.a.l(r10) != true) goto L7;
        r11 = true;
        goto L9
    }
}
