package com.larus.bmhome.chat;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.databinding.LarusPageChatDoubleTabBinding;
import com.larus.bmhome.view.title.ChatTitleTwoTabAdapt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ Ref.IntRef a;
    public final /* synthetic */ ChatDoubleTabFragment b;

    public final void onTabUnselected(TabLayout.Tab r1) {
    }

    public final void onTabReselected(TabLayout.Tab r4) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == true) goto L9;
        return;
    L9:
        if (this.a.element != 1) goto L28;
        LarusPageChatDoubleTabBinding r5 = this.b.e;
        k4 r1 = null;
        if (r5 == null) goto L15;
        ViewPager2 r6 = r5.f;
        if (r6 == null) goto L15;
        RecyclerView.Adapter r7 = r6.getAdapter();
    L17:
        if ((r7 instanceof ChatTitleTwoTabAdapt) == false) goto L19;
        ChatTitleTwoTabAdapt r8 = (ChatTitleTwoTabAdapt) r7;
    L20:
        if (r8 == null) goto L29;
        Object r9 = r8.n.get(1);
        if ((r9 instanceof k4) == false) goto L24;
        r1 = (k4) r9;
    L24:
        if (r1 == null) goto L30;
        r1.t0();
        return;
    L30:
        return;
    L29:
        return;
    L19:
        r8 = null;
    L15:
        r7 = null;
        goto L17
    L28:
        return;
    L5:
        if (this.a.element != r4.getPosition()) goto L7;
        r0 = true;
        goto L7
    }

    public final void onTabSelected(TabLayout.Tab r2) {
        Ref.IntRef r0 = this.a;
        if (r2 == null) goto L5;
        int r3 = r2.getPosition();
    L6:
        r0.element = r3;
        return;
    L5:
        r3 = r0.element;
        goto L6
    }

    public t(Ref.IntRef r1, ChatDoubleTabFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
