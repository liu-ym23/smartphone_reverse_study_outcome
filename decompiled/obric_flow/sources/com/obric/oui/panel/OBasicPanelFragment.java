package com.obric.oui.panel;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.obric.common.oui.R$style;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/panel/OBasicPanelFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "<init>", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OBasicPanelFragment extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f13992c;
    public final boolean d;
    public final int e;

    public OBasicPanelFragment() {
        this.f13990a = -1;
        this.f13991b = true;
        this.f13992c = true;
        this.d = true;
        this.e = R$style.OBasicPanel;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        Dialog r5 = getDialog();     // Catch: Exception -> L14
        if (r5 == null) goto L9;
        Window r10 = r5.getWindow();     // Catch: Exception -> L14
        if (r10 == null) goto L9;
        r10.getDecorView();     // Catch: Exception -> L14
    L9:
        Dialog r11 = getDialog();     // Catch: Exception -> L14
        if ((r11 instanceof BottomSheetDialog) == false) goto L12;
        boolean r12 = ((BottomSheetDialog) r11).d().f13959k;     // Catch: Exception -> L14
    L12:
        super.dismiss();     // Catch: Exception -> L14
        Unit r13 = Unit.INSTANCE;     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        com.lynx.tasm.utils.b.q(Intrinsics.stringPlus("Try exception occur ", e.getMessage()));
        Unit r14 = Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        Dialog r5 = getDialog();
        if (r5 == null) goto L9;
        Window r10 = r5.getWindow();
        if (r10 == null) goto L9;
        r10.getDecorView();
    L9:
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r5) {
        Intrinsics.checkNotNullParameter(r5, "dialog");
        Dialog r10 = getDialog();
        if (r10 == null) goto L9;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L9;
        r11.getDecorView();
    L9:
        super.onCancel(r5);
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r5) {
        OBasePanelDialog r10 = new OBasePanelDialog(requireContext(), this.e);
        r10.f13980j = this.f13990a;
        r10.f13981k = this.f13991b;
        r10.f13982l = null;
        r10.f13985o = this.f13992c;
        r10.f13983m = false;
        r10.f13984n = this.d;
        return r10;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r5) {
        Intrinsics.checkNotNullParameter(r5, "dialog");
        super.onDismiss(r5);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r10);
        Dialog r11 = getDialog();
        if (r11 == null) goto L7;
        r11.setOnShowListener(new h(this));
        return;
    }
}
