package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    private boolean waitingForDismissAllowingStateLoss;

    static /* synthetic */ class a {
    }

    private class b extends BottomSheetBehavior.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetDialogFragment f3061a;

        private b(BottomSheetDialogFragment r10) {
            this.f3061a = r10;
        }

        /* synthetic */ b(BottomSheetDialogFragment r10, a r11) {
            this(r10);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void b(@NonNull View r10, float r11) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void c(@NonNull View r10, int r11) {
            if (r11 != 5) goto L6;
            BottomSheetDialogFragment.access$100(this.f3061a);
            return;
        }
    }

    public BottomSheetDialogFragment() {
    }

    static /* synthetic */ void access$100(BottomSheetDialogFragment r10) {
        r10.dismissAfterAnimation();
    }

    private void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss == false) goto L5;
        super.dismissAllowingStateLoss();
        return;
    L5:
        super.dismiss();
    }

    private void dismissWithAnimation(@NonNull BottomSheetBehavior<?> r10, boolean r11) {
        this.waitingForDismissAllowingStateLoss = r11;
        if (r10.getState() != 5) goto L6;
        dismissAfterAnimation();
        return;
    L6:
        if ((getDialog() instanceof BottomSheetDialog) == false) goto L8;
        ((BottomSheetDialog) getDialog()).removeDefaultCallback();
    L8:
        r10.addBottomSheetCallback(new b(this, null));
        r10.setState(5);
    }

    private boolean tryDismissWithAnimation(boolean r10) {
        Dialog r11 = getDialog();
        if ((r11 instanceof BottomSheetDialog) == false) goto L10;
        BottomSheetDialog r12 = (BottomSheetDialog) r11;
        BottomSheetBehavior<FrameLayout> r13 = r12.getBehavior();
        if (r13.isHideable() == true) goto L7;
        return false;
    L7:
        if (r12.getDismissWithAnimation() == false) goto L13;
        dismissWithAnimation(r13, r10);
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (tryDismissWithAnimation(false) == true) goto L6;
        super.dismiss();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        if (tryDismissWithAnimation(true) == true) goto L6;
        super.dismissAllowingStateLoss();
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle r10) {
        return new BottomSheetDialog(getContext(), getTheme());
    }
}
