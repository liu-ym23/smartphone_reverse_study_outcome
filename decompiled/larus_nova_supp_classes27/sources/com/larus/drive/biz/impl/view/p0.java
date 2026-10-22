package com.larus.drive.biz.impl.view;

import androidx.viewpager2.widget.ViewPager2;
import com.larus.drive.biz.impl.databinding.LarusPageDriveMainBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p0 implements q79.a {
    public final /* synthetic */ AbsDriveListFragment a;
    public final /* synthetic */ DriveMainFragment b;

    @Override // q79.a
    public final void refresh() {
        this.a.ba0(true);
    }

    @Override // q79.a
    public final void a() {
        DriveMainFragment r0 = this.b;
        LarusPageDriveMainBinding r1 = r0.j;
        if (r1 == null) goto L11;
        ViewPager2 r2 = r1.j;
        if (r2 != null) goto L8;
        return;
    L8:
        if (r0.p == 1) goto L12;
        r2.setCurrentItem(1);
        return;
    L12:
        return;
    }

    public p0(AbsDriveListFragment r1, DriveMainFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
