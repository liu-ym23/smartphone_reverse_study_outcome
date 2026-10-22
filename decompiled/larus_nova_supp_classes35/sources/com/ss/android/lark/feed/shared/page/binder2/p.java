package com.ss.android.lark.feed.shared.page.binder2;

import android.view.View;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements View.OnClickListener {
    public final /* synthetic */ aeb.d a;
    public final /* synthetic */ UIFeedCard b;
    public final /* synthetic */ aeb.a c;

    public p(aeb.d r1, UIFeedCard r2, e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.o(this.b, FeedActionEvent.RIGHT_SWIPE_SHORT, this.c);
        Log.i("FeedSharedModule_FeedCommonViewHolder", "click done view, feedId=" + this.b.getId());
    }
}
