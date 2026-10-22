package com.bytedance.android.livesdk.feed.drawerfeed.singledraw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.ui.CenterScrollLayoutManager;
import com.bytedance.android.live.ui.FadingEdgeRecyclerview;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.AbsSingleDrawViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.EmptySingleDrawViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.OperationSingleDrawViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.PlaceHolderViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.RoomSingleDrawViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.TabLoadingViewHolder;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/SingleDrawFeedAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/viewholder/AbsSingleDrawViewHolder;", "a", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleDrawFeedAdapter extends RecyclerView.Adapter<AbsSingleDrawViewHolder> {
    public static final int f = 0;
    public static final int g = 0;
    public static final a h = null;
    public final LinkedList<FeedItem> a;
    public final RecyclerView b;
    public final SingleDrawViewModel c;
    public final Fragment d;
    public final TabListModel e;

    public static final class a {
        public a() {
        }

        public static int a(int r1) {
            if (r1 != 1) goto L6;
            return 2131566004;
        L6:
            if (r1 != 24) goto L9;
            return 2131566003;
        L9:
            if (r1 != 11) goto L12;
            return 2131565999;
        L12:
            if (r1 != SingleDrawFeedAdapter.g) goto L14;
            return 2131566006;
        L14:
            return 2131566000;
        }
    }

    static {
        h = new a();
        f = 3;
        g = 10000;
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final int getItemViewType(int r2) {
        if (this.a.size() > r2) goto L7;
        return -1;
    L7:
        return this.a.get(r2).type;
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        AbsSingleDrawViewHolder r3 = (AbsSingleDrawViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewAttachedToWindow(r3);
        r3.X3();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        AbsSingleDrawViewHolder r4 = (AbsSingleDrawViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        r4.T3(this.a.get(r3), r3);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r4, "parent");
        h.getClass();
        int r0 = a.a(r5);
        View r6 = LayoutInflater.from(r4.getContext()).inflate(r0, r4, false);
        if (r5 != 1) goto L6;
        return new RoomSingleDrawViewHolder(r6, this, this.b, this.e);
    L6:
        if (r5 != 24) goto L9;
        return new OperationSingleDrawViewHolder(r6, this, this.b, this.e);
    L9:
        if (r5 != 11) goto L12;
        return new PlaceHolderViewHolder(r6, this, this.b, this.e);
    L12:
        if (r5 != g) goto L15;
        return new TabLoadingViewHolder(r6, this, this.b, this.e);
    L15:
        return new EmptySingleDrawViewHolder(r6, this, this.b, this.e);
    }

    public SingleDrawFeedAdapter(FadingEdgeRecyclerview r2, CenterScrollLayoutManager r3, SingleDrawViewModel r4, Fragment r5, TabListModel r6) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "layoutManager");
        Intrinsics.checkNotNullParameter(r5, "fragment");
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.a = new LinkedList();
    }
}
