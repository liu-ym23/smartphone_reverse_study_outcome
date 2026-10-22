package com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.SingleDrawFeedAdapter;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.TabListModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/viewholder/EmptySingleDrawViewHolder;", "Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/viewholder/AbsSingleDrawViewHolder;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EmptySingleDrawViewHolder extends AbsSingleDrawViewHolder {
    @Override // com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.AbsSingleDrawViewHolder
    public final void T3(FeedItem r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "feedItem");
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.AbsSingleDrawViewHolder
    public final void X3() {
    }

    public EmptySingleDrawViewHolder(View r2, SingleDrawFeedAdapter r3, RecyclerView r4, TabListModel r5) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        super(r2, r3, r4, r5);
    }
}
