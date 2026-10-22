package com.obric.assistant.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.ObricFragmentLocalDataSearchConfirmBinding;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0002J\"\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/settings/LocalDataSearchConfirmFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricFragmentLocalDataSearchConfirmBinding;", "viewModel", "Lcom/obric/assistant/settings/LocalDataSearchConfirmViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getTheme", "safeDismiss", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalDataSearchConfirmFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int f = 0;
    public ObricFragmentLocalDataSearchConfirmBinding d;
    public LocalDataSearchConfirmViewModel e;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131951939;
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
        FLogger.a.e("LocalDataSearchConfirmFragment", "dismiss failed because: " + e.getMessage(), e);
    }

    public LocalDataSearchConfirmFragment() {
    }

    public final void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        LocalDataSearchConfirmViewModel r3 = (LocalDataSearchConfirmViewModel) new ViewModelProvider(requireActivity()).get(LocalDataSearchConfirmViewModel.class);
        this.e = r3;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L6:
        if (r3.getResult() != null) goto L9;
        S90();
        return;
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r1, r2, r3);
        S90();
        LocalDataSearchConfirmViewModel r4 = this.e;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L5:
        MutableLiveData<Boolean> r5 = r4.getResult();
        if (r5 == null) goto L9;
        r5.setValue(Boolean.valueOf(ObricPersonalContextSettingApiDelegate.b.q()));
        return;
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ChatConstraintLayout r11 = r8.inflate(2131564001, r9, false);
        int r12 = 2131364598;
        Button r3 = (Button) ViewBindings.findChildViewById(r11, 2131364598);
        if (r3 == null) goto L31;
        ChatConstraintLayout r4 = r11;
        r12 = 2131390273;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131390273);
        if (r5 == null) goto L31;
        r12 = 2131390392;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131390392);
        if (r6 == null) goto L31;
        r12 = 2131391606;
        if (((TextView) ViewBindings.findChildViewById(r11, 2131391606)) == null) goto L31;
        this.d = new ObricFragmentLocalDataSearchConfirmBinding(r4, r3, r4, r5, r6);
        setCancelable(false);
        String r13 = tga.b.a();
        ObricFragmentLocalDataSearchConfirmBinding r14 = this.d;
        if (r14 == null) goto L15;
        TextView r15 = r14.e;
        if (r15 == null) goto L15;
        r15.setText(getString(2131912234, new Object[]{r13}));
    L15:
        ObricFragmentLocalDataSearchConfirmBinding r16 = this.d;
        if (r16 == null) goto L20;
        Button r17 = r16.b;
        if (r17 == null) goto L20;
        r17.setOnClickListener(new l(this));
    L20:
        ObricFragmentLocalDataSearchConfirmBinding r18 = this.d;
        if (r18 == null) goto L25;
        TextView r19 = r18.d;
        if (r19 == null) goto L25;
        r19.setOnClickListener(new m(this));
    L25:
        ObricFragmentLocalDataSearchConfirmBinding r20 = this.d;
        if (r20 != null) goto L32;
        return null;
    L32:
        return r20.c;
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
