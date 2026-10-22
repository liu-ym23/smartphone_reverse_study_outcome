package com.ss.android.lark.flow.feed.page;

import com.ss.android.lark.feed.shared.page.FeedRecyclerView;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements LarkFeedInBoxListAdapter.c {
    public final /* synthetic */ FeedRecyclerView a;

    public final void a() {
        com.ss.android.lark.feed.shared.page.utils.b.a(this.a);
    }

    public final void b() {
        FeedRecyclerView r0 = this.a;
        if (com.ss.android.lark.feed.shared.page.utils.b.b() == false) goto L7;
        if (r0 == null) goto L8;
        r0.getItemAnimator().setRemoveDuration(300);
        r0.getItemAnimator().setMoveDuration(150);
        return;
    L8:
        return;
    }

    public b(FeedRecyclerView r1) {
        this.a = r1;
    }
}
