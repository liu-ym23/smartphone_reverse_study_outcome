package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.LiveOpenFeaturePanelViewModel;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements AppBarLayout.OnOffsetChangedListener {
    public final /* synthetic */ LiveOpenFeatureChooseListFragment a;

    public f(LiveOpenFeatureChooseListFragment r1) {
        this.a = r1;
    }

    public final void onOffsetChanged(AppBarLayout r5, int r6) {
        LiveOpenFeatureChooseListFragment r7 = this.a;
        if (r6 != 0) goto L5;
        boolean r1 = true;
    L6:
        r7.getClass();
        RecyclerView.LayoutManager r3 = null;
        if (r6 >= r7.e) goto L14;
        AbsOpenFeaturePanelViewModel r8 = r7.o;
        if ((r8 instanceof LiveOpenFeaturePanelViewModel) == true) goto L11;
        r8 = null;
    L11:
        LiveOpenFeaturePanelViewModel r9 = (LiveOpenFeaturePanelViewModel) r8;
        if (r9 == null) goto L20;
        r9.setDisablePanelDragDown$livebroadcastgame_impl_saasRelease(true);
    L20:
        RecyclerView r11 = this.a.j;
        if (r11 == null) goto L23;
        RecyclerView.LayoutManager r12 = r11.getLayoutManager();
    L25:
        if ((r12 instanceof LinearLayoutManager) == false) goto L28;
        r3 = r12;
    L28:
        LinearLayoutManager r4 = (LinearLayoutManager) r3;
        if (r4 != null) goto L31;
    L33:
        this.a.e = r6;
        return;
    L31:
        if (Math.abs(r6 - this.a.e) < 70) goto L33;
        LiveOpenFeatureChooseListFragment r13 = this.a;
        LiveOpenFeatureChooseListFragment.W90(r4, r13.l, new LiveOpenFeatureChooseListFragment$processGroupListVisibleScroll$1(r13), new LiveOpenFeatureChooseListFragment$processGroupListVisibleScroll$2(r13, r4));
        goto L33
    L23:
        r12 = null;
        goto L25
    L14:
        AbsOpenFeaturePanelViewModel r14 = r7.o;
        if ((r14 instanceof LiveOpenFeaturePanelViewModel) == true) goto L17;
        r14 = null;
    L17:
        LiveOpenFeaturePanelViewModel r15 = (LiveOpenFeaturePanelViewModel) r14;
        if (r15 == null) goto L20;
        r15.setDisablePanelDragDown$livebroadcastgame_impl_saasRelease(true ^ r1);
        goto L20
    L5:
        r1 = false;
        goto L6
    }
}
