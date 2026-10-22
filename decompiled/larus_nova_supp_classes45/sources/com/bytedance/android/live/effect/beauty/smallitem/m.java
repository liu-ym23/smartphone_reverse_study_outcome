package com.bytedance.android.live.effect.beauty.smallitem;

import androidx.recyclerview.widget.LinearLayoutManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m implements LiveBeautySecLevelSlidingTab.b {
    public final /* synthetic */ LiveBeautySecondLevelFragment a;

    public m(LiveBeautySecondLevelFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.beauty.smallitem.LiveBeautySecLevelSlidingTab.b
    public final void a(int r4) {
        LinearLayoutManager r0 = this.a.S90(2131386948).getLayoutManager();
        if (r0 == null) goto L7;
        r0.scrollToPositionWithOffset(this.a.W90(r4), 0);
        this.a.aa0(r4);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }
}
