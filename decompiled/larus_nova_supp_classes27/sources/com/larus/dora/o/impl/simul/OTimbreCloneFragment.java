package com.larus.dora.o.impl.simul;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.o.impl.databinding.DoraOFragmentTimbreCloneBinding;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/dora/o/impl/simul/OTimbreCloneFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/dora/o/impl/databinding/DoraOFragmentTimbreCloneBinding;", "restartDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "switchListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showRestartDialog", "isChecked", "", "saveTimbreCloneOption", "restoreSwitchState", "targetState", "onDestroyView", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OTimbreCloneFragment extends Fragment {
    public static final /* synthetic */ int g = 0;
    public DoraOFragmentTimbreCloneBinding d;
    public com.obric.oui.dialog.v2.alert.c e;
    public final c0 f;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.dora.o.impl.simul.c0] */
    public OTimbreCloneFragment() {
        this.f = new c0(this);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        com.obric.oui.dialog.v2.alert.c r0 = this.e;
        if (r0 == null) goto L5;
        S90(r0);
    L5:
        this.e = null;
        this.d = null;
    }

    public static void S90(com.obric.oui.dialog.v2.alert.c r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        DoraOFragmentTimbreCloneBinding r5 = this.d;
        if (r5 == null) goto L7;
        OFloatingTitleBar r6 = r5.c;
        if (r6 == null) goto L7;
        r6.setCenterTitle(getString(2131903477));
        OFloatingTitleBar.k(r6, new d0(this), 2);
    L7:
        DoraOFragmentTimbreCloneBinding r7 = this.d;
        if (r7 == null) goto L12;
        OCardListItem r8 = r7.b;
        if (r8 == null) goto L12;
        u69.b.a(r8, null);
    L12:
        DoraOFragmentTimbreCloneBinding r9 = this.d;
        if (r9 == null) goto L23;
        OCardListItem r10 = r9.b;
        if (r10 == null) goto L23;
        OSwitch r11 = r10.getEndSwitch();
        if (r11 == null) goto L23;
        if (DoraConfig.a.getString("key_timbre_clone", "").length() <= 0) goto L21;
        boolean r12 = true;
    L22:
        r11.setChecked(r12);
        r11.setOnCheckedChangeListener(this.f);
        goto L23
    L21:
        r12 = false;
    L23:
        DoraOFragmentTimbreCloneBinding r13 = this.d;
        if (r13 == null) goto L29;
        OCardListItem r14 = r13.b;
        if (r14 == null) goto L30;
        r14.setOnContentClickListener(new e0(this));
        return;
    L30:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131560150, r3, false);
        int r6 = 2131388651;
        OCardListItem r7 = ViewBindings.findChildViewById(r5, 2131388651);
        if (r7 == null) goto L9;
        r6 = 2131388653;
        OFloatingTitleBar r0 = ViewBindings.findChildViewById(r5, 2131388653);
        if (r0 == null) goto L9;
        ConstraintLayout r8 = r5;
        this.d = new DoraOFragmentTimbreCloneBinding(r8, r7, r0);
        return r8;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
