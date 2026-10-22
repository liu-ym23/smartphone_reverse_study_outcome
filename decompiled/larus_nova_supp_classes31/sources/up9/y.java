package up9;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.photopicker.v2.impl.BottomPhotoPickerFragmentV2;
import com.larus.photopicker.v2.impl.ui.MyBottomSheetBehavior;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface y extends j0 {
    void a(FrameLayout r1);

    void b(BottomPhotoPickerFragmentV2 r1, FrameLayout r2, int r3);

    void d(MyBottomSheetBehavior r1, int r2, BottomSheetViewModel r3);

    void e(BottomPhotoPickerFragmentV2 r1, float r2);

    void i(BottomPhotoPickerFragmentV2 r1, boolean r2);

    Dialog k(Context r1);

    void l(BottomSheetDialogFragment r1);

    void m(BottomPhotoPickerFragmentV2 r1, Function0 r2);

    void o(FragmentActivity r1, Configuration r2, Function0<Unit> r3);
}
