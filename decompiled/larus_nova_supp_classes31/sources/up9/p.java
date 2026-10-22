package up9;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common_ui.view.BottomOverlayView;
import com.larus.photopicker.v2.impl.BottomPhotoPickerFragmentV2;
import com.larus.photopicker.v2.impl.ui.MotionEventPassBottomSheetDialog;
import com.larus.photopicker.v2.impl.ui.MyBottomSheetBehavior;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.platform.api.f3$a;
import com.larus.platform.service.e2;
import com.larus.utils.e1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p extends w {
    public final Function1<View, View> a;
    public final com.larus.platform.api.b0 b;
    public MotionEventPassBottomSheetDialog c;
    public View d;

    @Override // up9.y
    public final void i(BottomPhotoPickerFragmentV2 r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "bottomSheetDialogFragment");
    }

    @Override // up9.w, up9.y
    public final void a(final FrameLayout r7) {
        Intrinsics.checkNotNullParameter(r7, "designBottomSheet");
        if (e2.a.isPad() == false) goto L15;
        int r0 = f3$a.a();
        View r2 = r7.getChildAt(0);
        if (r2 == null) goto L15;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof FrameLayout.LayoutParams) == false) goto L10;
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r3;
    L12:
        if (r4 == null) goto L14;
        r4.width = r0;
        r4.gravity = 1;
        r2.setLayoutParams(r4);
    L14:
        r2.setOutlineProvider(new m());
        r2.setClipToOutline(true);
        r7.setBackground(null);
        r7.setElevation(0.0f);
        r7.setBackgroundColor(0);
        goto L15
    L10:
        r4 = null;
    L15:
        r7.postDelayed(new l(this, r7), 300);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.app.Dialog, com.larus.photopicker.v2.impl.ui.MotionEventPassBottomSheetDialog] */
    @Override // up9.y
    public final Dialog k(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        ?? r0 = new MotionEventPassBottomSheetDialog(r2);
        this.c = r0;
        return r0;
    }

    @Override // up9.y
    public final void l(BottomSheetDialogFragment r4) {
        Intrinsics.checkNotNullParameter(r4, "bottomSheetDialogFragment");
        Dialog r1 = r4.getDialog();
        if (r1 == null) goto L7;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L7;
        r2.setWindowAnimations(0);
    L7:
        Intrinsics.checkNotNullParameter(r4, "bottomSheetDialogFragment");
        Dialog r5 = r4.getDialog();
        if (r5 == null) goto L11;
        w.p(r5, 0.0f);
        w.q(r5, 0.0f);
        return;
    }

    public p(Function1 r1, com.larus.platform.api.b0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // up9.y
    public final void e(BottomPhotoPickerFragmentV2 r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "bottomSheetDialogFragment");
        MotionEventPassBottomSheetDialog r0 = this.c;
        boolean r1 = false;
        if (r0 == null) goto L5;
        r0.c = false;
    L5:
        Dialog r5 = r3.getDialog();
        if (r5 == null) goto L8;
        w.p(r5, r4);
        w.q(r5, r4);
    L8:
        com.larus.platform.api.b0 r6 = this.b;
        if (r6 == null) goto L11;
        r6.e((int) r4);
    L11:
        BottomOverlayView r7 = this.d;
        if ((r7 instanceof BottomOverlayView) == false) goto L14;
        BottomOverlayView r8 = r7;
    L16:
        if (r8 != null) goto L18;
    L20:
        boolean r9 = false;
    L21:
        if (r9 == true) goto L23;
        return;
    L23:
        if (r4 != 0.0f) goto L25;
        r1 = true;
    L25:
        if (r1 == false) goto L31;
        com.larus.platform.api.b0 r10 = this.b;
        if (r10 == null) goto L32;
        r10.c();
        return;
    L32:
        return;
    L31:
        return;
    L18:
        if (r8.f != true) goto L20;
        r9 = true;
        goto L21
    L14:
        r8 = null;
        goto L16
    }

    @Override // up9.y
    public final void m(BottomPhotoPickerFragmentV2 r1, Function0 r2) {
        Intrinsics.checkNotNullParameter(r1, "bottomSheetDialogFragment");
        r1.Ua();
    }

    @Override // up9.y
    public final void b(BottomPhotoPickerFragmentV2 r3, FrameLayout r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "bottomSheetDialogFragment");
        MotionEventPassBottomSheetDialog r0 = this.c;
        if (r0 == null) goto L6;
        r0.c = true;
    L6:
        if (r5 != 3) goto L8;
        if (r4 == null) goto L20;
        r4.setOutlineProvider(new n());
        r4.setClipToOutline(true);
    L20:
        View r6 = this.d;
        if (r6 == null) goto L27;
        e1.o(r6);
        return;
    L27:
        return;
    L8:
        if (r5 != 4) goto L10;
        if (r4 == null) goto L15;
        r4.setOutlineProvider(new o());
        r4.setClipToOutline(false);
    L15:
        View r7 = this.d;
        if (r7 == null) goto L25;
        e1.x(r7);
        return;
    L25:
        return;
    L10:
        if (r5 != 5) goto L28;
        r3.Uw();
        return;
    }

    @Override // up9.y
    public final void d(MyBottomSheetBehavior r2, int r3, BottomSheetViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "myBottomSheetBehavior");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        r2.setState(4);
        r2.setPeekHeight(r3);
        r4.getBottomSheetOnStateChanged().setValue(4);
    }

    @Override // up9.w, up9.y
    public final void o(FragmentActivity r2, Configuration r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        if (e2.a.a(r2, r3) == false) goto L9;
        if (r4 == null) goto L8;
        r4.invoke();
        return;
    L8:
        return;
    }
}
