package com.larus.dora.impl.device.settings.lab.env.wifi;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.i0;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/wifi/EnvObserveWiFiDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGEnvObserveWifiScanBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "", "onStart", "", "onViewCreated", "view", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnvObserveWiFiDialogFragment extends BottomSheetDialogFragment {
    public final int getTheme() {
        return 2131951935;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L6;
        BottomSheetBehavior.from(r0.findViewById(2131368870)).setHideable(false);
        return;
    }

    public EnvObserveWiFiDialogFragment() {
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
        int r9 = (((r8 - i0.g()) - i0.e()) - i5.c0()) - i5.s0();
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

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562192, r3, false);
        int r6 = 2131369581;
        if (((DoraTextView) ViewBindings.findChildViewById(r5, 2131369581)) == null) goto L17;
        r6 = 2131369582;
        if (((DoraTextView) ViewBindings.findChildViewById(r5, 2131369582)) == null) goto L17;
        r6 = 2131369583;
        if (ViewBindings.findChildViewById(r5, 2131369583) == null) goto L17;
        r6 = 2131369584;
        if (((DoraTextView) ViewBindings.findChildViewById(r5, 2131369584)) == null) goto L17;
        r6 = 2131369585;
        if (((ImageView) ViewBindings.findChildViewById(r5, 2131369585)) == null) goto L17;
        r6 = 2131369586;
        if (((LinearLayout) ViewBindings.findChildViewById(r5, 2131369586)) == null) goto L17;
        return (FrameLayout) r5;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
