package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDialogFragment extends DialogFragment {
    public AppCompatDialogFragment() {
    }

    public AppCompatDialogFragment(@LayoutRes int r10) {
        super(r10);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle r10) {
        return new AppCompatDialog(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog r10, int r11) {
        if ((r10 instanceof AppCompatDialog) == false) goto L13;
        AppCompatDialog r12 = (AppCompatDialog) r10;
        if (r11 != 1) goto L7;
    L12:
        r12.supportRequestWindowFeature(1);
        return;
    L7:
        if (r11 == 2) goto L12;
        if (r11 != 3) goto L16;
        r10.getWindow().addFlags(24);
        goto L12
    L16:
        return;
    L13:
        super.setupDialog(r10, r11);
    }
}
