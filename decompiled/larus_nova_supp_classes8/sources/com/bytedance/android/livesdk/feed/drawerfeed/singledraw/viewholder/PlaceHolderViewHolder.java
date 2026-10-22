package com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.PlaceHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.SingleDrawFeedAdapter;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.TabListModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/viewholder/PlaceHolderViewHolder;", "Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/viewholder/AbsSingleDrawViewHolder;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlaceHolderViewHolder extends AbsSingleDrawViewHolder {
    public final TextView j;

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.AbsSingleDrawViewHolder
    public final void X3() {
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.AbsSingleDrawViewHolder
    public final void T3(FeedItem r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "feedItem");
        TextView r5 = this.j;
        if (r5 == null) goto L10;
        StringBuilder r0 = new StringBuilder("—");
        PlaceHolder r6 = r3.placeHolder;
        if (r6 == null) goto L7;
        String r7 = r6.getMsg();
    L8:
        r0.append(r7);
        r0.append("—");
        r5.setText(r0.toString());
        return;
    L7:
        r7 = null;
        goto L8
    }

    public PlaceHolderViewHolder(View r2, SingleDrawFeedAdapter r3, RecyclerView r4, TabListModel r5) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        super(r2, r3, r4, r5);
        this.j = (TextView) r2.findViewById(2131386623);
    }
}
