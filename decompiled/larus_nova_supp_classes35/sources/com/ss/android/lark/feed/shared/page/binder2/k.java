package com.ss.android.lark.feed.shared.page.binder2;

import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder;
import com.ss.android.lark.feed.app.entity.UIFeedCard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements bw7.b.c {
    public final /* synthetic */ FeedCommonViewHolder a;

    public final void a() {
    }

    public k(FeedCommonViewHolder r1) {
        this.a = r1;
    }

    public final void b(int r2) {
        if (r2 != 0) goto L4;
    L6:
        FeedCommonViewHolder r3 = this.a;
        ((AbstractSwipeableItemViewHolder) r3).e = 0.0f;
        UIFeedCard r4 = r3.H;
        if (r4 == null) goto L10;
        r4.setSwipeRightPinned(false);
        return;
    L10:
        return;
    L4:
        if (r2 == 1) goto L6;
    }
}
