package com.bytedance.android.livesdk.feed.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.paging.adapter.PagingAdapter;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.h;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FeedLiveAdapter extends BaseFeedAdapter {
    public final h p;

    @Override // com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter
    public final int E2(int r2) {
        if (r2 == 1) goto L26;
        if (r2 != 3) goto L7;
        return 2131566257;
    L7:
        if (r2 != 6) goto L9;
        return 2131567660;
    L9:
        if (r2 == 10000001) goto L19;
        switch(r2) {
            case 1001: goto L31;
            case 1002: goto L17;
            case 1003: goto L15;
            case 1004: goto L13;
            default: goto L12;
        };
    L13:
        return 2131566266;
    L15:
        return 2131567663;
    L17:
        return 2131567662;
    L31:
        return 2131567660;
    L12:
        return invalidateType();
    L19:
        return 2131565968;
    L26:
        if (this.p.Ay() == true) goto L28;
        return 2131566258;
    L28:
        return this.p.wY();
    }

    public final RecyclerView.ViewHolder createFooterViewHolder(ViewGroup r3, int r4) {
        return new PagingAdapter.EndViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131565350, r3, false));
    }

    public final RecyclerView.ViewHolder createLoadingViewHolder(ViewGroup r1, int r2) {
        return super/*com.bytedance.android.live.core.paging.adapter.PagingAdapter*/.createLoadingViewHolder(r1, r2);
    }

    public FeedLiveAdapter(Map<Integer, b90.a> r1, f r2, h r3) {
        super(r1, r2);
        this.p = r3;
    }
}
