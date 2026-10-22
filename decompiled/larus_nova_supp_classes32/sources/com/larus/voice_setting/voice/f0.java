package com.larus.voice_setting.voice;

import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f0 implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ ViewPager2 a;
    public final /* synthetic */ DoubleTabTtsSpeakerSettingFragment b;

    public final void onTabReselected(TabLayout.Tab r1) {
    }

    public final void onTabUnselected(TabLayout.Tab r1) {
    }

    public final void onTabSelected(TabLayout.Tab r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (this.a.getCurrentItem() != r6.getPosition()) goto L7;
        FLogger.a.i("DoubleTabTtsSpeakerSettingFragment", "onTabSelected draw  tab:" + r6.getPosition() + "viewPager:" + this.a.getCurrentItem());
        return;
    L7:
        if (this.b.E == false) goto L10;
        FLogger.a.i("DoubleTabTtsSpeakerSettingFragment", "[onTabSelected]: ignore selection during rebuild, tab=" + r6.getPosition() + ", viewPager=" + this.a.getCurrentItem());
        return;
    L10:
        FLogger.a.i("DoubleTabTtsSpeakerSettingFragment", "onTabSelected click  tab:" + r6.getPosition() + "viewPager:" + this.a.getCurrentItem());
        this.a.setCurrentItem(r6.getPosition(), false);
    }

    public f0(ViewPager2 r1, DoubleTabTtsSpeakerSettingFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
