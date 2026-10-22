package com.obric.oui.sheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.obric.oui.common.util.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u8.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/oui/sheet/OSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "<init>", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OSheet extends BottomSheetDialogFragment {
    public OSheet() {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r10) {
        OBottomSheetDialog r11 = new OBottomSheetDialog(requireContext(), k.AppBottomSheetDialogTheme);
        BottomSheetBehavior<FrameLayout> r12 = r11.getBehavior();
        Intrinsics.checkNotNullExpressionValue(r12, "behavior");
        r12.setSkipCollapsed(true);
        BottomSheetBehavior<FrameLayout> r13 = r11.getBehavior();
        Intrinsics.checkNotNullExpressionValue(r13, "behavior");
        Context r14 = r11.getContext();
        Intrinsics.checkNotNullExpressionValue(r14, "context");
        r13.setPeekHeight(f.d(r14));
        return r11;
    }
}
