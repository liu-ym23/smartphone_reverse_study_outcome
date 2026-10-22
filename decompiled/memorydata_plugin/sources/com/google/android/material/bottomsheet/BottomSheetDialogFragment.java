package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    private boolean waitingForDismissAllowingStateLoss;

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.BottomSheetDialogFragment$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a extends BottomSheetBehavior.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetDialogFragment f3815a;

        private a(BottomSheetDialogFragment r1) {
            this.f3815a = r1;
        }

        /* synthetic */ a(BottomSheetDialogFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
        public void a(View r1, float r2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
        public void a(View r1, int r2) {
            if (r2 != 5) goto L6;
            BottomSheetDialogFragment.access$100(this.f3815a);
            return;
        }
    }

    public BottomSheetDialogFragment() {
    }

    static /* synthetic */ void access$100(BottomSheetDialogFragment r0) {
        r0.dismissAfterAnimation();
    }

    private void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss == false) goto L5;
        super.dismissAllowingStateLoss();
        return;
    L5:
        super.dismiss();
    }

    private void dismissWithAnimation(BottomSheetBehavior<?> r4, boolean r5) {
        this.waitingForDismissAllowingStateLoss = r5;
        if (r4.getState() != 5) goto L6;
        dismissAfterAnimation();
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(getDialog(), BottomSheetDialog.class) == false) goto L8;
        ((BottomSheetDialog) ZeusTransformUtils.preCheckCast(getDialog(), BottomSheetDialog.class, "com.obric.memorydata.plugin")).removeDefaultCallback();
    L8:
        r4.addBottomSheetCallback(new a(this, null));
        r4.setState(5);
    }

    private boolean tryDismissWithAnimation(boolean r4) {
        Dialog r0 = getDialog();
        if (ZeusTransformUtils.instanceOf(r0, BottomSheetDialog.class) == false) goto L10;
        BottomSheetDialog r1 = (BottomSheetDialog) ZeusTransformUtils.preCheckCast(r0, BottomSheetDialog.class, "com.obric.memorydata.plugin");
        BottomSheetBehavior<FrameLayout> r2 = r1.getBehavior();
        if (r2.isHideable() == true) goto L7;
        return false;
    L7:
        if (r1.getDismissWithAnimation() == false) goto L13;
        dismissWithAnimation(r2, r4);
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
    public Dialog onCreateDialog(Bundle r4) {
        return new BottomSheetDialog((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), getTheme());
    }
}
