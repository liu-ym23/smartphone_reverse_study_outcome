package up9;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.photopicker.v2.impl.BottomPhotoPickerFragmentV2;
import com.larus.photopicker.v2.impl.ui.CameraBottomSheetDialog;
import com.larus.photopicker.v2.impl.ui.MyBottomSheetBehavior;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i extends w {
    public final int a;
    public final com.larus.platform.api.b0 b;
    public MyBottomSheetBehavior c;
    public Context d;
    public CameraBottomSheetDialog e;
    public final Lazy f;
    public final Lazy g;

    @Override // up9.y
    public final void i(BottomPhotoPickerFragmentV2 r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "bottomSheetDialogFragment");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.app.Dialog, com.larus.photopicker.v2.impl.ui.CameraBottomSheetDialog] */
    @Override // up9.y
    public final Dialog k(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.d = r2;
        ?? r0 = new CameraBottomSheetDialog(r2);
        this.e = r0;
        return r0;
    }

    @Override // up9.y
    public final void l(BottomSheetDialogFragment r3) {
        Intrinsics.checkNotNullParameter(r3, "bottomSheetDialogFragment");
        Dialog r0 = r3.getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.setWindowAnimations(0);
    L7:
        Dialog r4 = r3.getDialog();
        if (r4 == null) goto L13;
        w.p(r4, 0.0f);
        w.q(r4, 1.0f);
        Window r5 = r4.getWindow();
        if (r5 == null) goto L14;
        r5.setNavigationBarColor(-16777216);
        return;
    L14:
        return;
    }

    public i(int r1, com.larus.platform.api.b0 r2) {
        this.a = r1;
        this.b = r2;
        this.f = LazyKt.lazy(new b());
        this.g = LazyKt.lazy(new c(this));
    }

    @Override // up9.y
    public final void e(BottomPhotoPickerFragmentV2 r4, float r5) {
        Intrinsics.checkNotNullParameter(r4, "bottomSheetDialogFragment");
        boolean r0 = false;
        if (r5 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L11:
        int r6 = (int) r5;
        r(r4.getDialog(), r6);
        com.larus.platform.api.b0 r7 = this.b;
        if (r7 == null) goto L16;
        r7.e(r6);
        return;
    L16:
        return;
    L8:
        if (r5 != 1.0f) goto L10;
        r0 = true;
    L10:
        if (r0 == true) goto L11;
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // up9.y
    public final void m(BottomPhotoPickerFragmentV2 r1, Function0 r2) {
        Intrinsics.checkNotNullParameter(r1, "bottomSheetDialogFragment");
        r1.Ua();
    }

    public final void r(Dialog r3, int r4) {
        if (((Boolean) this.f.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.d == null) goto L23;
        if (r4 <= 0) goto L9;
        int r5 = ((Number) this.g.getValue()).intValue();
    L10:
        boolean r0 = false;
        if (r3 == null) goto L17;
        Window r1 = r3.getWindow();
        if (r1 == null) goto L17;
        if (r5 != r1.getNavigationBarColor()) goto L17;
        r0 = true;
    L17:
        if (r0 == true) goto L24;
        if (r3 == null) goto L25;
        Window r6 = r3.getWindow();
        if (r6 == null) goto L26;
        r6.setNavigationBarColor(r5);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L9:
        r5 = this.a;
        goto L10
    }

    @Override // up9.y
    public final void b(BottomPhotoPickerFragmentV2 r1, FrameLayout r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "bottomSheetDialogFragment");
        if (r3 != 3) goto L10;
        MyBottomSheetBehavior r4 = this.c;
        if (r4 != null) goto L7;
        return;
    L7:
        if (r4.getPeekHeight() <= 0) goto L12;
        r4.setPeekHeight(0);
        return;
    L12:
        return;
    }

    @Override // up9.y
    public final void d(MyBottomSheetBehavior r3, int r4, BottomSheetViewModel r5) {
        Intrinsics.checkNotNullParameter(r3, "myBottomSheetBehavior");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        this.c = r3;
        r3.setState(4);
        r3.setPeekHeight(0);
        r5.getBottomSheetOnStateChanged().setValue(4);
        CameraBottomSheetDialog r6 = this.e;
        if (r6 == null) goto L5;
        View r7 = r6.findViewById(2131389274);
    L6:
        Context r0 = this.d;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.Activity");
        Activity r1 = (Activity) r0;
        if (r7 == null) goto L9;
        r7.setOnTouchListener(new h(r1, this, r3));
    L9:
        if (r7 == null) goto L12;
        r7.setOnClickListener(null);
        return;
    L12:
        return;
    L5:
        r7 = null;
        goto L6
    }
}
