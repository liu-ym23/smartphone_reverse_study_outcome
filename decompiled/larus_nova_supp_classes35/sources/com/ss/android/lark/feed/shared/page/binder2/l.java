package com.ss.android.lark.feed.shared.page.binder2;

import android.view.View;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ FeedExpiredFoldHintViewHolder a;

    public l(FeedExpiredFoldHintViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.b.setVisibility(8);
        com.ss.android.lark.feed.shared.hitpoint.a.c(false);
        LarkFeedInBoxListAdapter.D2(((teb.g) this.a.a).a);
    }
}
