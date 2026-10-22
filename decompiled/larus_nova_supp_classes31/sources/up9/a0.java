package up9;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaSelectorBinding;
import com.larus.photopicker.v2.impl.ui.MyTitleViewBehavior;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a0 extends v {
    public AppBarLayout.Behavior c;
    public MyTitleViewBehavior d;

    @Override // up9.v, up9.i0
    public final void onDestroyView() {
        this.c = null;
        this.d = null;
    }

    @Override // up9.v, up9.i0
    public final void f(LarusFragmentMediaSelectorBinding r4) {
        Intrinsics.checkNotNullParameter(r4, "binding");
        super.f(r4);
        CoordinatorLayout.LayoutParams r0 = r4.j.getLayoutParams();
        CoordinatorLayout.Behavior r2 = null;
        if ((r0 instanceof CoordinatorLayout.LayoutParams) == false) goto L5;
        CoordinatorLayout.LayoutParams r1 = r0;
    L6:
        if (r1 == null) goto L8;
        CoordinatorLayout.Behavior r3 = r1.getBehavior();
    L10:
        if ((r3 instanceof MyTitleViewBehavior) == false) goto L13;
        r2 = r3;
    L13:
        MyTitleViewBehavior r5 = (MyTitleViewBehavior) r2;
        if (r5 == null) goto L16;
        r5.a = false;
    L16:
        r4.b.setExpanded(false);
        return;
    L8:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // up9.i0
    public final void h(ViewPager2 r2) {
        Intrinsics.checkNotNullParameter(r2, "viewPager");
        r2.setUserInputEnabled(false);
    }

    public a0(BottomSheetViewModel r1, boolean r2) {
        super(r1, r2);
    }

    @Override // up9.i0
    public final void j(ViewPager2 r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "viewPager");
        v.p(this, r1, r3);
    }

    @Override // up9.v, up9.i0
    public final void g(LifecycleOwner r2, final LarusFragmentMediaSelectorBinding r3, BottomSheetViewModel r4, MediaGalleryLiveDataViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(r4, "nonNullBottomSheetViewModel");
        Intrinsics.checkNotNullParameter(r5, "mediaGalleryViewModel");
        super.g(r2, r3, r4, r5);
        r4.getOnSlide().observe(r2, new v.a(new z(r3, this)));
    }
}
