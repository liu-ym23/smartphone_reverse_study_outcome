package com.larus.profile.impl.info;

import com.google.android.material.tabs.TabLayout;
import com.larus.profile.impl.databinding.LarusPageTabProfileInfoBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ LarusPageTabProfileInfoBinding a;

    public final void onTabReselected(TabLayout.Tab r1) {
    }

    public final void onTabUnselected(TabLayout.Tab r1) {
    }

    public w(LarusPageTabProfileInfoBinding r1) {
        this.a = r1;
    }

    public final void onTabSelected(TabLayout.Tab r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.a.p.setCurrentItem(r2.getPosition());
    }
}
