package up9;

import androidx.viewpager2.widget.ViewPager2;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b0 extends v {
    @Override // up9.i0
    public final void h(ViewPager2 r2) {
        Intrinsics.checkNotNullParameter(r2, "viewPager");
        r2.setUserInputEnabled(true);
    }

    public b0(BottomSheetViewModel r1, boolean r2) {
        super(r1, r2);
    }

    @Override // up9.i0
    public final void j(ViewPager2 r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "viewPager");
        if (r4 == true) goto L7;
        if (r3 == true) goto L7;
        boolean r5 = false;
    L8:
        v.p(this, r2, r5);
        return;
    L7:
        r5 = true;
        goto L8
    }
}
