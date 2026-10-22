package com.bytedance.android.livesdk.feed;

import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.drawer.ILiveDrawerCommonFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u0 implements LiveDrawerPagerSlidingTabStrip.e {
    public final /* synthetic */ LiveDrawerFeedPageFragment a;

    public u0(LiveDrawerFeedPageFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.feed.LiveDrawerPagerSlidingTabStrip.e
    public final void a(int r6) {
        LiveDrawerPageAdapter r0 = this.a.g;
        Fragment r1 = null;
        if (r0 == null) goto L17;
        if (r6 >= 0) goto L6;
    L14:
        ILiveDrawerCommonFragment r2 = null;
    L15:
        if (r2 == null) goto L17;
        r2.tabOnClick();
        goto L17
    L6:
        if (r6 >= ((ArrayList) r0.a).size()) goto L14;
        com.bytedance.android.livesdk.feed.feed.e r3 = (com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(r0.a, r6);
        if (r3.o() == true) goto L12;
        if (com.bytedance.android.livesdk.feed.tab.repository.newtab.b.c == false) goto L14;
    L12:
        if (r0.c.containsKey(Integer.valueOf(r3.getType())) == false) goto L14;
        r2 = r0.c.get(Integer.valueOf(r3.getType()));
    L17:
        LiveDrawerFeedPageFragment r4 = this.a;
        if (r4.v != r6) goto L31;
        LiveDrawerPageAdapter r5 = r4.g;
        if (r5 == null) goto L22;
        Fragment r7 = r5.getItem(r6);
    L24:
        if ((r7 instanceof LiveDrawerFeedCategoryFragment) == false) goto L27;
        r1 = r7;
    L27:
        LiveDrawerFeedCategoryFragment r8 = (LiveDrawerFeedCategoryFragment) r1;
        if (r8 == null) goto L30;
        r8.refresh();
    L30:
        this.a.DP();
        return;
    L22:
        r7 = null;
        goto L24
    L31:
        r4.v = r6;
    }
}
