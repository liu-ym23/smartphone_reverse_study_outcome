package c39;

import com.google.android.material.tabs.TabLayout;
import com.larus.discover.impl.databinding.LarusDiscoverMainLayoutBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ LarusDiscoverMainLayoutBinding a;

    public final void onTabReselected(TabLayout.Tab r1) {
    }

    public final void onTabUnselected(TabLayout.Tab r1) {
    }

    public a(LarusDiscoverMainLayoutBinding r1) {
        this.a = r1;
    }

    public final void onTabSelected(TabLayout.Tab r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.a.c.getCurrentItem() == r3.getPosition()) goto L8;
        this.a.c.setCurrentItem(r3.getPosition());
        return;
    }
}
