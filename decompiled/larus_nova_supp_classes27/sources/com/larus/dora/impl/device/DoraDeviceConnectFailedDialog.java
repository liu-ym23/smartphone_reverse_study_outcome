package com.larus.dora.impl.device;

import android.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/dora/impl/device/DoraDeviceConnectFailedDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "markdownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/DoraDeviceViewModel;", "getModel", "()Lcom/larus/dora/impl/device/DoraDeviceViewModel;", "model$delegate", "Lkotlin/Lazy;", "enterPageTraced", "", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDeviceConnectFailedDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int g = 0;
    public final lw8.d d;
    public final Lazy e;
    public boolean f;

    public final int getTheme() {
        return 2131951933;
    }

    public DoraDeviceConnectFailedDialog() {
        this.d = new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraDeviceViewModel.class), new DoraDeviceConnectFailedDialog$special$$inlined$activityViewModels$default$1(this), new DoraDeviceConnectFailedDialog$special$$inlined$activityViewModels$default$2(this));
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.f == true) goto L6;
        j49.b.d();
        this.f = true;
        return;
    }

    public static void S90(DoraDeviceConnectFailedDialog r1) {
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
        int r7 = com.larus.utils.m0.a;
        int r8 = com.larus.utils.m0.a(getContext());
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

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131562162, r8, false);
        int r11 = 2131369511;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r10, 2131369511);
        if (r12 == null) goto L20;
        r11 = 2131369512;
        MarkdownTextView r1 = ViewBindings.findChildViewById(r10, 2131369512);
        if (r1 == null) goto L20;
        r11 = 2131369513;
        AppCompatTextView r2 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131369513);
        if (r2 == null) goto L20;
        r11 = 2131369514;
        if (((DoraTextView) ViewBindings.findChildViewById(r10, 2131369514)) == null) goto L20;
        FrameLayout r13 = (FrameLayout) r10;
        StringBuilder r14 = new StringBuilder();
        StringBuilder r3 = new StringBuilder();
        int r4 = com.larus.utils.j0.a;
        r3.append(com.larus.utils.j0.d(2131902388));
        r3.append('\n');
        r14.append(r3.toString());
        r14.append(com.larus.utils.j0.d(2131902389) + '\n');
        r14.append(com.larus.utils.j0.d(2131902390) + '\n');
        r14.append(com.larus.utils.j0.d(2131902391));
        gw8.c.a.getClass();
        gw8.c r5 = gw8.c.a.b();
        if (r5 == null) goto L13;
        lw8.l r0 = gw8.c.b.b(r5, r1, r14.toString(), false, this.d);
    L14:
        if (r0 == null) goto L16;
        r1.setMarkdown(r0);
    L17:
        e1.d(r12, new d(this));
        e1.d(r2, new e(this));
        e1.d(r13, new f(this));
        return r13;
    L16:
        r1.setText(r14.toString());
        goto L17
    L13:
        r0 = null;
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
