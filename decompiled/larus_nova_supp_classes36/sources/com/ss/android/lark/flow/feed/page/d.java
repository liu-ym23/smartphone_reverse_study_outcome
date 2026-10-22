package com.ss.android.lark.flow.feed.page;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.feed.shared.page.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements FeedListAdapter.g {
    public final /* synthetic */ FlowMixedFeedFragment a;

    public d(FlowMixedFeedFragment r1) {
        this.a = r1;
    }

    public final void a(int r5, UIFeedCard r6) {
        FlowMixedFeedFragment r0 = this.a;
        cfb.a r1 = FlowMixedFeedFragment.N;
        s r2 = r0.Y90().get();
        if (r2 != null) goto L5;
        return;
    L5:
        int r3 = this.a.W90().getItemCount() - r5;
        FlowMixedFeedFragment r4 = this.a;
        if (r3 >= r4.p) goto L9;
        r2.onItemChanged(r5, r6, r4.o);
        return;
    }
}
