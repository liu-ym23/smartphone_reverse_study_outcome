package com.larus.bmhome.view;

import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatTitleAlignLeftStyle$f implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ ViewPager2 a;

    public final void onTabReselected(TabLayout.Tab r1) {
    }

    public final void onTabUnselected(TabLayout.Tab r1) {
    }

    public ChatTitleAlignLeftStyle$f(ViewPager2 r1) {
        this.a = r1;
    }

    public final void onTabSelected(TabLayout.Tab r3) {
        if (r3 == null) goto L7;
        int r4 = r3.getPosition();
        ViewPager2 r0 = this.a;
        if (r0.getCurrentItem() == r4) goto L8;
        r0.setCurrentItem(r4);
        return;
    L8:
        return;
    }
}
