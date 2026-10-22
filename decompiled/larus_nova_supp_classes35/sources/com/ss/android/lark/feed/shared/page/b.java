package com.ss.android.lark.feed.shared.page;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements FeedListAdapter.g {
    public final /* synthetic */ FeedItemsFragment a;

    public b(FeedItemsFragment r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter.g
    public final void a(int r3, UIFeedCard r4) {
        LarkFeedInBoxListAdapter r0 = this.a.u;
        if (r0 == null) goto L5;
        int r1 = r0.getItemCount();
    L7:
        if ((r1 - r3) >= this.a.I) goto L14;
        StringBuilder r2 = new StringBuilder("onItemChanged3, position = ");
        r2.append(r3);
        r2.append(", feedItemCount = ");
        LarkFeedInBoxListAdapter r5 = this.a.u;
        if (r5 == null) goto L11;
        Integer r6 = Integer.valueOf(r5.getItemCount());
    L12:
        r2.append(r6);
        Log.d("FeedSharedModule_FeedItemsFragment", r2.toString());
        this.a.W90().onItemChanged(r3, r4, this.a.m);
        return;
    L11:
        r6 = null;
        goto L12
    L14:
        return;
    L5:
        r1 = 0;
        goto L7
    }
}
