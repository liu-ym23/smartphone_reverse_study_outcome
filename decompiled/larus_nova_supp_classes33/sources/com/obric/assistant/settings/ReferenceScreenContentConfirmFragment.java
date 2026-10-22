package com.obric.assistant.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.ObricFragmentReferenceScreenContentConfirmBinding;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/settings/ReferenceScreenContentConfirmFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricFragmentReferenceScreenContentConfirmBinding;", "viewModel", "Lcom/obric/assistant/settings/ReferenceScreenContentConfirmViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "getTheme", "", "onDestroyView", "safeDismiss", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReferenceScreenContentConfirmFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int f = 0;
    public ObricFragmentReferenceScreenContentConfirmBinding d;
    public ReferenceScreenContentConfirmViewModel e;

    public static final class a {
        public static MutableLiveData a(FragmentActivity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            ReferenceScreenContentConfirmFragment r1 = new ReferenceScreenContentConfirmFragment();     // Catch: Exception -> L10
            ReferenceScreenContentConfirmViewModel r2 = (ReferenceScreenContentConfirmViewModel) new ViewModelProvider(r4).get(ReferenceScreenContentConfirmViewModel.class);     // Catch: Exception -> L10
            r2.setResult(new MutableLiveData());     // Catch: Exception -> L10
            FragmentManager r5 = r4.getSupportFragmentManager();     // Catch: Exception -> L10
            LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L10
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "ReferenceScreenContentConfirmFragment", r3);     // Catch: Exception -> L10
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r1, r3) == false) goto L16;
        L8:
            return r2.getResult();
        L16:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
        L7:
            r1.show(r5, "ReferenceScreenContentConfirmFragment");     // Catch: Exception -> L10
        L10:
            e = move-exception;
            FLogger.a.e("ReferenceScreenContentConfirmFragment", "show ReferenceScreenContentConfirmFragment exception: " + e);
            return null;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951939;
    }

    public final void onDestroyView() {
        this.d = null;
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public final void S90() {
        FragmentActivity r0 = getActivity();     // Catch: Exception -> L15
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L22;
        dismiss();     // Catch: Exception -> L10
    L24:
        return;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Exception -> L15
        Throwable r2 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L15
        if (r2 == null) goto L23;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L15
        return;
    L23:
        return;
    L22:
        return;
    L5:
        if (r0.isFinishing() == true) goto L7;
        r1 = true;
    L15:
        e = move-exception;
        FLogger.a.e("ReferenceScreenContentConfirmFragment", "dismiss failed because: " + e.getMessage(), e);
    }

    public ReferenceScreenContentConfirmFragment() {
    }

    public final void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        ReferenceScreenContentConfirmViewModel r3 = (ReferenceScreenContentConfirmViewModel) new ViewModelProvider(requireActivity()).get(ReferenceScreenContentConfirmViewModel.class);
        this.e = r3;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L6:
        if (r3.getResult() != null) goto L9;
        S90();
        return;
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        ChatConstraintLayout r12 = r9.inflate(2131564006, r10, false);
        int r13 = 2131364596;
        Button r3 = (Button) ViewBindings.findChildViewById(r12, 2131364596);
        if (r3 == null) goto L36;
        ChatConstraintLayout r4 = r12;
        r13 = 2131390273;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r12, 2131390273);
        if (r5 == null) goto L36;
        r13 = 2131390392;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r12, 2131390392);
        if (r6 == null) goto L36;
        r13 = 2131391606;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r12, 2131391606);
        if (r7 == null) goto L36;
        this.d = new ObricFragmentReferenceScreenContentConfirmBinding(r4, r3, r4, r5, r6, r7);
        setCancelable(false);
        ObricFragmentReferenceScreenContentConfirmBinding r14 = this.d;
        if (r14 == null) goto L15;
        TextView r15 = r14.f;
        if (r15 == null) goto L15;
        r15.setText(getString(2131912389));
    L15:
        ObricFragmentReferenceScreenContentConfirmBinding r16 = this.d;
        if (r16 == null) goto L20;
        TextView r17 = r16.e;
        if (r17 == null) goto L20;
        r17.setText(getString(2131912388));
    L20:
        ObricFragmentReferenceScreenContentConfirmBinding r18 = this.d;
        if (r18 == null) goto L25;
        Button r19 = r18.b;
        if (r19 == null) goto L25;
        r19.setOnClickListener(new e1(this));
    L25:
        ObricFragmentReferenceScreenContentConfirmBinding r20 = this.d;
        if (r20 == null) goto L30;
        TextView r21 = r20.d;
        if (r21 == null) goto L30;
        r21.setOnClickListener(new f1(this));
    L30:
        ObricFragmentReferenceScreenContentConfirmBinding r22 = this.d;
        if (r22 != null) goto L37;
        return null;
    L37:
        return r22.c;
    L36:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
