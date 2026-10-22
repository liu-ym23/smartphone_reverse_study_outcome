package com.larus.photopicker.v2.impl;

import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.tabs.TabLayout;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaSelectorBinding;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaMobViewModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class z1 implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ List<MediaTab> a;
    public final /* synthetic */ MediaSelectorFragment b;

    public final void onTabReselected(TabLayout.Tab r1) {
    }

    public final void onTabUnselected(TabLayout.Tab r1) {
    }

    public final void onTabSelected(TabLayout.Tab r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        MediaTab r0 = (MediaTab) ListProtector.get(this.a, r5.getPosition());
        MediaSelectorFragment r1 = this.b;
        int r2 = MediaSelectorFragment.o;
        BottomSheetViewModel r3 = r1.T90();
        if (r3 == null) goto L14;
        MutableLiveData<Integer> r4 = r3.getBottomSheetOnStateChanged();
        if (r4 == null) goto L14;
        Integer r6 = (Integer) r4.getValue();
        if (r6 == null) goto L14;
        if (r6.intValue() != 3) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L17;
        ((MediaMobViewModel) this.b.j.getValue()).mobOnTabSelected(r0.getMobName());
    L17:
        MediaSelectorFragment r8 = this.b;
        if (r8.n == true) goto L20;
        ((MediaMobViewModel) r8.j.getValue()).mobClickTab(r0);
    L20:
        LarusFragmentMediaSelectorBinding r9 = this.b.f;
        if (r9 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L23:
        ViewPager2 r10 = r9.g;
        if (r10.getCurrentItem() == r5.getPosition()) goto L26;
        r10.setCurrentItem(r5.getPosition());
    L26:
        this.b.n = false;
        return;
    L14:
        r7 = false;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z1(List<? extends MediaTab> r1, MediaSelectorFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
