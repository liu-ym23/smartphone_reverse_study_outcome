package com.larus.bmhome.view;

import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/larus/bmhome/view/ChatTitleAlignLeftStyle$setupWithViewPager$2", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTitleAlignLeftStyle$setupWithViewPager$2 extends ViewPager2.OnPageChangeCallback {
    public final /* synthetic */ ChatTitleAlignLeftStyle a;

    public ChatTitleAlignLeftStyle$setupWithViewPager$2(ChatTitleAlignLeftStyle r1) {
        this.a = r1;
    }

    public final void onPageSelected(int r2) {
        TabLayout.Tab r3 = this.a.getBinding().A.getTabAt(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isSelected() == true) goto L9;
        r3.select();
        return;
    }
}
