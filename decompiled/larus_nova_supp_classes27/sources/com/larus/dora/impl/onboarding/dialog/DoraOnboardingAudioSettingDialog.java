package com.larus.dora.impl.onboarding.dialog;

import a69.b;
import a69.c;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.databinding.LarusDoraOnboardingBluetoothSettingDialogBinding;
import com.larus.dora.impl.view.DoraMovieView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import g49.d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0014\u0010\u001a\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/dora/impl/onboarding/dialog/DoraOnboardingAudioSettingDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onDismissListener", "Lkotlin/Function0;", "", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingBluetoothSettingDialogBinding;", "dismissByConfirm", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "setOnDismissListener", "listener", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraOnboardingAudioSettingDialog extends DialogFragment {
    public static final /* synthetic */ int f = 0;
    public LarusDoraOnboardingBluetoothSettingDialogBinding d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    public DoraOnboardingAudioSettingDialog() {
    }

    public final void S90(DialogInterface r8) {
        Intrinsics.checkNotNullParameter(r8, "dialog");
        super.onDismiss(r8);
        LarusDoraOnboardingBluetoothSettingDialogBinding r9 = this.d;
        if (r9 == null) goto L8;
        DoraMovieView r10 = r9.f;
        if (r10 == null) goto L8;
        r10.f();
    L8:
        if (this.e == false) goto L10;
        int r11 = j49.a.a;
        DoraBuryPointManager.a.L("dora_floating_window_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "hw_volume_sync_switch_popup"), TuplesKt.to("window_content_action", "open_hw_volume_sync")}));
        return;
    L10:
        int r12 = j49.a.a;
        DoraBuryPointManager.a.L("dora_floating_window_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "hw_volume_sync_switch_popup"), TuplesKt.to("window_content_action", "close_hw_volume_sync")}));
    }

    public final void onDismiss(DialogInterface r2) {
        S90(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        final LarusDoraOnboardingBluetoothSettingDialogBinding r5 = this.d;
        if (r5 == null) goto L14;
        DoraDevice r6 = ak4.a.d().current();
        if (r6 == null) goto L7;
        Boolean r7 = Boolean.valueOf(o59.a.l(r6));
    L9:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L11;
        int r8 = 2131903643;
    L12:
        r5.e.setText(2131903654);
        r5.d.setText(r8);
        r5.f.post(new a69.a(r5));
        r5.b.setOnClickListener(new b(this));
        r5.c.setOnClickListener(new c(this));
        return;
    L11:
        r8 = 2131903653;
        goto L12
    L7:
        r7 = null;
        goto L9
    }

    public final void show(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        if (DeviceUtils.isHuawei() == false) goto L11;
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L13
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r2);     // Catch: Throwable -> L13
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r2) == false) goto L22;
    L10:
        d.d("DoraOnboardingBluetoothSettingDialog", "show");     // Catch: Throwable -> L13
        int r5 = j49.a.a;     // Catch: Throwable -> L13
        j49.a.a();     // Catch: Throwable -> L13
        goto L11
    L22:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19 Throwable -> L13
    L9:
        super.show(r3, r4);     // Catch: Throwable -> L13
    L11:
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L24;
        d.c("DoraOnboardingBluetoothSettingDialog", "show exception", r7);
        return;
    L24:
        return;
    L13:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131562237, r10, false);
        int r13 = 2131365114;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r12, 2131365114);
        if (r2 == null) goto L25;
        r13 = 2131367639;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r12, 2131367639);
        if (r3 == null) goto L25;
        r13 = 2131368971;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r12, 2131368971);
        if (r4 == null) goto L25;
        r13 = 2131368982;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r12, 2131368982);
        if (r5 == null) goto L25;
        r13 = 2131368986;
        DoraMovieView r6 = (DoraMovieView) ViewBindings.findChildViewById(r12, 2131368986);
        if (r6 == null) goto L25;
        r13 = 2131369197;
        View r7 = ViewBindings.findChildViewById(r12, 2131369197);
        if (r7 == null) goto L25;
        LinearLayout r14 = (LinearLayout) r12;
        LarusDoraOnboardingBluetoothSettingDialogBinding r15 = new LarusDoraOnboardingBluetoothSettingDialogBinding(r14, r2, r3, r4, r5, r6, r7);
        Dialog r16 = getDialog();
        if (r16 == null) goto L17;
        r16.setCanceledOnTouchOutside(true);
    L17:
        Dialog r17 = getDialog();
        if (r17 == null) goto L22;
        Window r18 = r17.getWindow();
        if (r18 == null) goto L22;
        r18.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(requireContext(), 2131106784)));
        r18.setFlags(512, 512);
    L22:
        this.d = r15;
        return r14;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
