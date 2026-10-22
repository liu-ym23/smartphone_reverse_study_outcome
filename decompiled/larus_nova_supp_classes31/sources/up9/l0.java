package up9;

import android.app.Dialog;
import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.photopicker.v2.impl.BottomPhotoPickerFragmentV2;
import com.larus.photopicker.v2.impl.ui.MyBottomSheetBehavior;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l0 extends w {
    @Override // up9.y
    public final void e(BottomPhotoPickerFragmentV2 r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "bottomSheetDialogFragment");
    }

    @Override // up9.y
    public final Dialog k(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return null;
    }

    public l0() {
    }

    @Override // up9.y
    public final void l(BottomSheetDialogFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "bottomSheetDialogFragment");
        Intrinsics.checkNotNullParameter(r2, "bottomSheetDialogFragment");
        Dialog r3 = r2.getDialog();
        if (r3 == null) goto L6;
        w.p(r3, 0.0f);
        w.q(r3, 0.0f);
        return;
    }

    @Override // up9.y
    public final void i(BottomPhotoPickerFragmentV2 r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "bottomSheetDialogFragment");
        Dialog r0 = r2.getDialog();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getWindow() == null) goto L12;
        if (r3 == false) goto L8;
        float r4 = 1.0f;
    L9:
        w.p(r2.getDialog(), r4);
        w.q(r2.getDialog(), r4);
        return;
    L8:
        r4 = 0.0f;
        goto L9
    }

    @Override // up9.y
    public final void m(BottomPhotoPickerFragmentV2 r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "bottomSheetDialogFragment");
        r2.Uw();
        if (r3 == null) goto L6;
        r3.invoke();
        return;
    }

    @Override // up9.y
    public final void b(BottomPhotoPickerFragmentV2 r1, FrameLayout r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "bottomSheetDialogFragment");
        if (r3 != 4) goto L5;
    L7:
        r1.Uw();
        return;
    L5:
        if (r3 == 5) goto L7;
    }

    @Override // up9.y
    public final void d(MyBottomSheetBehavior r1, int r2, BottomSheetViewModel r3) {
        Intrinsics.checkNotNullParameter(r1, "myBottomSheetBehavior");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        r1.setState(3);
        r3.getBottomSheetOnStateChanged().setValue(3);
    }
}
