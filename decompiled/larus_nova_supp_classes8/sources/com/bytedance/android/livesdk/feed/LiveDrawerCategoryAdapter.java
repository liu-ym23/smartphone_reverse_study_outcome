package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.paging.adapter.PagingAdapter;
import com.bytedance.android.live.core.paging.viewmodel.PagingViewModel;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter;
import com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment;
import com.bytedance.android.livesdk.feed.fragment.AppointmentListFragment;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/LiveDrawerCategoryAdapter;", "Lcom/bytedance/android/livesdk/feed/adapter/BaseFeedAdapter;", "ErrorViewHolder", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawerCategoryAdapter extends BaseFeedAdapter {
    public final BaseDrawerFeedFragment p;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/LiveDrawerCategoryAdapter$ErrorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ErrorViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final PagingViewModel<?> b;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ ErrorViewHolder a;

            public a(ErrorViewHolder r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r1) {
                this.a.b.retry();
            }
        }

        public final void T3() {
            NetworkStat r0 = (NetworkStat) this.b.refreshStat().getValue();
            ((RecyclerView.ViewHolder) this).itemView.findViewById(2131387295);
            this.a.setOnClickListener(new a(this));
        }

        public ErrorViewHolder(View r2, PagingViewModel<?> r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "viewModel");
            super(r2);
            this.b = r3;
            this.a = r2.findViewById(2131371764);
        }
    }

    public final int getEmptyResId() {
        BaseDrawerFeedFragment r0 = this.p;
        BaseDrawerFeedFragment r2 = null;
        if ((r0 instanceof LiveDrawerFeedCategoryFragment) == true) goto L5;
        r0 = null;
    L5:
        LiveDrawerFeedCategoryFragment r1 = (LiveDrawerFeedCategoryFragment) r0;
        if (r1 != null) goto L8;
    L10:
        BaseDrawerFeedFragment r3 = this.p;
        if ((r3 instanceof AppointmentListFragment) == false) goto L14;
        r2 = r3;
    L14:
        AppointmentListFragment r4 = (AppointmentListFragment) r2;
        if (r4 != null) goto L17;
        return 2131565973;
    L17:
        if (r4.o.getType() != 5) goto L21;
        return 2131565966;
    L21:
        return 2131565973;
    L8:
        if (r1.u.getType() != 5) goto L10;
        return 2131565966;
    }

    @Override // com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter
    public final int E2(int r2) {
        if (r2 != (-1)) goto L5;
        return 2131565981;
    L5:
        if (r2 != 1) goto L7;
    L32:
        return 2131565985;
    L7:
        if (r2 != 3) goto L9;
        return 2131566257;
    L9:
        if (r2 != 6) goto L11;
    L30:
        return 2131566007;
    L11:
        if (r2 == 15) goto L32;
        if (r2 != 19) goto L15;
        return 2131565160;
    L15:
        if (r2 != 24) goto L17;
        return 2131565980;
    L17:
        if (r2 == 10000001) goto L27;
        switch(r2) {
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            default: goto L19;
        };
    L19:
        switch(r2) {
            case 1001: goto L30;
            case 1002: goto L23;
            case 1003: goto L22;
            case 1004: goto L21;
            default: goto L35;
        };
    L21:
        return 2131566266;
    L22:
        return 2131567663;
    L23:
        return 2131567662;
    L35:
        return invalidateType();
    L24:
        return 2131565979;
    L25:
        return 2131565967;
    L26:
        return 2131565982;
    L27:
        return 2131565968;
    }

    public final FeedItem I2(int r1) {
        return (FeedItem) super/*com.bytedance.android.live.core.paging.adapter.PagingAdapter*/.getItem(r1);
    }

    @Override // com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewAttachedToWindow(r2);
        if (r2.getLayoutPosition() != 0) goto L8;
        BaseDrawerFeedFragment r3 = this.p;
        if (r3 == null) goto L9;
        r3.ca0();
        return;
    L9:
        return;
    }

    public final RecyclerView.ViewHolder createFooterViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131565350, r3, false);
        View r0 = null;
        if ((r5 instanceof ViewGroup) == true) goto L5;
        View r6 = null;
    L6:
        ViewGroup r7 = (ViewGroup) r6;
        if (r7 == null) goto L9;
        View r8 = r7.getChildAt(0);
    L11:
        if ((r8 instanceof TextView) == false) goto L14;
        r0 = r8;
    L14:
        TextView r1 = (TextView) r0;
        if (r1 == null) goto L18;
        r1.setTextColor(s1.h(2131108578));
    L18:
        return new PagingAdapter.EndViewHolder(r5);
    L9:
        r8 = null;
        goto L11
    L5:
        r6 = r5;
        goto L6
    }

    public final RecyclerView.ViewHolder createLoadingViewHolder(ViewGroup r3, int r4) {
        if (r4 != (-1091576149)) goto L6;
        Intrinsics.checkNotNull(r3);
        return new ErrorViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131565974, r3, false), getViewModel());
    L6:
        return super/*com.bytedance.android.live.core.paging.adapter.PagingAdapter*/.createLoadingViewHolder(r3, r4);
    }

    public final void onBindLoadingViewHolder(RecyclerView.ViewHolder r1, int r2) {
        super/*com.bytedance.android.live.core.paging.adapter.PagingAdapter*/.onBindLoadingViewHolder(r1, r2);
        if ((r1 instanceof ErrorViewHolder) == false) goto L6;
        ((ErrorViewHolder) r1).T3();
        return;
    }

    public LiveDrawerCategoryAdapter(Map<Integer, ? extends b90.a> r1, f r2, BaseDrawerFeedFragment r3) {
        super(r1, r2);
        this.p = r3;
    }
}
