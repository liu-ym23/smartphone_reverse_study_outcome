package com.bytedance.android.livesdk.feed.squarefeed.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.rank.a;
import com.bytedance.android.live.core.paging.adapter.PagingAdapter;
import com.bytedance.android.live.core.paging.adapter.SimplePagingAdapter;
import com.bytedance.android.livesdkapi.feed.constant.FeedStyle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/squarefeed/adapter/OpenRankAdapter;", "Lcom/bytedance/android/live/core/paging/adapter/SimplePagingAdapter;", "Lcom/bytedance/android/live/base/model/rank/a;", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class OpenRankAdapter extends SimplePagingAdapter<a> {
    public final FeedStyle c;

    public OpenRankAdapter(Map<Integer, ? extends b90.a> r2, FeedStyle r3) {
        Intrinsics.checkNotNullParameter(r2, "factories");
        Intrinsics.checkNotNullParameter(r3, "feedStyle");
        super(new RankItemComparator(), r2);
        this.c = r3;
    }

    public final RecyclerView.ViewHolder createFooterViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new PagingAdapter.EndViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131565350, r3, false));
    }

    public final RecyclerView.ViewHolder createLoadingViewHolder(ViewGroup r1, int r2) {
        return super/*com.bytedance.android.live.core.paging.adapter.PagingAdapter*/.createLoadingViewHolder(r1, r2);
    }

    public final int getNormalViewType(int r1, Object r2) {
        a r3 = (a) r2;
        if (this.c != FeedStyle.SIMPLE_LIST) goto L6;
        return 2131565987;
    L6:
        return invalidateType();
    }
}
