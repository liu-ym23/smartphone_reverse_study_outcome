package com.bytedance.android.livesdk.feed.squarefeed.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import b90.a;
import com.bytedance.android.live.core.paging.adapter.PagingAdapter;
import com.bytedance.android.livesdkapi.feed.constant.FeedStyle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/squarefeed/adapter/OpenFeedAdapter;", "Lcom/bytedance/android/livesdk/feed/squarefeed/adapter/BaseOpenFeedAdapter;", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class OpenFeedAdapter extends BaseOpenFeedAdapter {
    public final FeedStyle q;

    @Override // com.bytedance.android.livesdk.feed.squarefeed.adapter.BaseOpenFeedAdapter
    public final int D2(int r2) {
        if (r2 == 1) goto L6;
        return invalidateType();
    L6:
        if (this.q != FeedStyle.SIMPLE_LIST) goto L9;
        return 2131566259;
    L9:
        return invalidateType();
    }

    public OpenFeedAdapter(Map<Integer, ? extends a> r2, FeedStyle r3) {
        Intrinsics.checkNotNullParameter(r2, "factories");
        Intrinsics.checkNotNullParameter(r3, "feedStyle");
        super(r2);
        this.q = r3;
    }

    public final RecyclerView.ViewHolder createFooterViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new PagingAdapter.EndViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131565350, r3, false));
    }

    public final RecyclerView.ViewHolder createLoadingViewHolder(ViewGroup r1, int r2) {
        return super/*com.bytedance.android.live.core.paging.adapter.PagingAdapter*/.createLoadingViewHolder(r1, r2);
    }
}
