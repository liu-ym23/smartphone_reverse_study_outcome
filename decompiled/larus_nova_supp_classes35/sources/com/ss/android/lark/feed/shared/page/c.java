package com.ss.android.lark.feed.shared.page;

import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements LarkFeedInBoxListAdapter.c {
    public final /* synthetic */ FeedItemsFragment a;

    @Override // com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter.c
    public final void a() {
        FeedItemsFragment r0 = this.a;
        cfb.a r1 = FeedItemsFragment.Q;
        com.ss.android.lark.feed.shared.page.utils.b.a(r0.X90());
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter.c
    public final void b() {
        FeedItemsFragment r0 = this.a;
        cfb.a r1 = FeedItemsFragment.Q;
        FeedRecyclerView r2 = r0.X90();
        if (com.ss.android.lark.feed.shared.page.utils.b.b() == false) goto L7;
        if (r2 == null) goto L8;
        r2.getItemAnimator().setRemoveDuration(300);
        r2.getItemAnimator().setMoveDuration(150);
        return;
    L8:
        return;
    }

    public c(FeedItemsFragment r1) {
        this.a = r1;
    }
}
