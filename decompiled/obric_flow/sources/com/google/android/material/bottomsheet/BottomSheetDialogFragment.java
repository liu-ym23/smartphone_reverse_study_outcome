package com.google.android.material.bottomsheet;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    private boolean waitingForDismissAllowingStateLoss;

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.BottomSheetDialogFragment$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class BottomSheetDismissCallback extends BottomSheetBehavior.BottomSheetCallback {
        final /* synthetic */ BottomSheetDialogFragment this$0;

        private BottomSheetDismissCallback(BottomSheetDialogFragment r5) {
            this.this$0 = r5;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@NonNull View r5, float r10) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@NonNull View r5, int r10) {
            if (r10 != 5) goto L6;
            BottomSheetDialogFragment.access$100(this.this$0);
            return;
        }

        public /* synthetic */ BottomSheetDismissCallback(BottomSheetDialogFragment r5, AnonymousClass1 r10) {
            this(r5);
        }
    }

    public BottomSheetDialogFragment() {
    }

    public static /* synthetic */ void access$100(BottomSheetDialogFragment r5) {
        r5.dismissAfterAnimation();
    }

    private void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss == false) goto L5;
        super.dismissAllowingStateLoss();
        return;
    L5:
        super.dismiss();
    }

    private void dismissWithAnimation(@NonNull BottomSheetBehavior<?> r5, boolean r10) {
        this.waitingForDismissAllowingStateLoss = r10;
        if (r5.getState() != 5) goto L6;
        dismissAfterAnimation();
        return;
    L6:
        if ((getDialog() instanceof BottomSheetDialog) == false) goto L8;
        ((BottomSheetDialog) getDialog()).removeDefaultCallback();
    L8:
        r5.addBottomSheetCallback(new BottomSheetDismissCallback(this, null));
        r5.setState(5);
    }

    private boolean tryDismissWithAnimation(boolean r5) {
        Dialog r10 = getDialog();
        if ((r10 instanceof BottomSheetDialog) == false) goto L10;
        BottomSheetDialog r11 = (BottomSheetDialog) r10;
        BottomSheetBehavior<FrameLayout> r12 = r11.getBehavior();
        if (r12.isHideable() == true) goto L7;
        return false;
    L7:
        if (r11.getDismissWithAnimation() == false) goto L13;
        dismissWithAnimation(r12, r5);
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
    public Dialog onCreateDialog(@Nullable Bundle r5) {
        return new BottomSheetDialog(getContext(), getTheme());
    }

    @SuppressLint({"ValidFragment"})
    public BottomSheetDialogFragment(@LayoutRes int r5) {
        super(r5);
    }
}
