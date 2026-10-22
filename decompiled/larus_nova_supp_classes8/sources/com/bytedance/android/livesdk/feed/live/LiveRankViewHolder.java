package com.bytedance.android.livesdk.feed.live;

import android.view.View;
import android.widget.ViewFlipper;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.feed.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveRankViewHolder extends BaseViewHolder<FeedItem> {
    public final ViewFlipper a;

    public LiveRankViewHolder(View r2) {
        super(r2);
        this.a = (ViewFlipper) r2.findViewById(2131374320);
    }

    public final void bind(Object r1, int r2) {
        ((g) ((FeedItem) r1).getItem()).getClass();
        this.a.stopFlipping();
        this.a.setVisibility(8);
    }
}
