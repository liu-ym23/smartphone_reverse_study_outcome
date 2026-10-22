package com.larus.search.impl.combine.recommend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.search.impl.combine.CombineSearchFragment;
import com.larus.search.impl.combine.c0;
import com.larus.search.impl.global.view.SearchResultItemView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ws9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u000f\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001f !B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0016J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\""}, d2 = {"Lcom/larus/search/impl/combine/recommend/SearchRecommendBotAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/search/impl/combine/CombineSearchResult;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "listener", "Lcom/larus/search/impl/combine/recommend/RecommendBotItemListener;", "eventHelper", "Lcom/larus/search/impl/global/view/SearchResultItemView$EventHelper;", "<init>", "(Lcom/larus/search/impl/combine/recommend/RecommendBotItemListener;Lcom/larus/search/impl/global/view/SearchResultItemView$EventHelper;)V", "getListener", "()Lcom/larus/search/impl/combine/recommend/RecommendBotItemListener;", "lastItemCount", "", "scrollListener", "com/larus/search/impl/combine/recommend/SearchRecommendBotAdapter$scrollListener$1", "Lcom/larus/search/impl/combine/recommend/SearchRecommendBotAdapter$scrollListener$1;", "reset", "", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemViewType", "Companion", "SearchBotViewHolder", "SearchLoadMoreViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SearchRecommendBotAdapter extends ListAdapter<c0, RecyclerView.ViewHolder> {
    public final com.larus.search.impl.combine.recommend.a a;
    public final SearchResultItemView.b b;
    public int c;
    public final SearchRecommendBotAdapter$scrollListener$1 d;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/search/impl/combine/recommend/SearchRecommendBotAdapter$SearchBotViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Lcom/larus/search/impl/global/view/SearchResultItemView;", "<init>", "(Lcom/larus/search/impl/combine/recommend/SearchRecommendBotAdapter;Lcom/larus/search/impl/global/view/SearchResultItemView;)V", "getView", "()Lcom/larus/search/impl/global/view/SearchResultItemView;", "bind", "", "item", "Lcom/larus/search/impl/global/model/GlobalSearchResultItem;", "index", "", "eventHelper", "Lcom/larus/search/impl/global/view/SearchResultItemView$EventHelper;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public final class SearchBotViewHolder extends RecyclerView.ViewHolder {
        public final SearchResultItemView a;

        public SearchBotViewHolder(SearchResultItemView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/search/impl/combine/recommend/SearchRecommendBotAdapter$SearchLoadMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/search/impl/combine/recommend/SearchRecommendBotAdapter;Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public final class SearchLoadMoreViewHolder extends RecyclerView.ViewHolder {
        public SearchLoadMoreViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemViewType(int r1) {
        return ((c0) getItem(r1)).getType();
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onAttachedToRecyclerView(r2);
        r2.addOnScrollListener(this.d);
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onDetachedFromRecyclerView(r2);
        r2.removeOnScrollListener(this.d);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.search.impl.combine.recommend.SearchRecommendBotAdapter$scrollListener$1] */
    public SearchRecommendBotAdapter(CombineSearchFragment.d r2, CombineSearchFragment.EventHelper r3) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        super(new AnonymousClass1());
        this.a = r2;
        this.b = r3;
        this.d = new SearchRecommendBotAdapter$scrollListener$1(this);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        c0 r0 = (c0) getItem(r4);
        if ((r3 instanceof SearchBotViewHolder) == false) goto L7;
        if (r0 == null) goto L8;
        b r1 = r0.q;
        SearchResultItemView.b r2 = this.b;
        ((SearchBotViewHolder) r3).a.a(r1, r4, r2);
        return;
    L8:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 == 16) goto L7;
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562650, r3, false);
        Intrinsics.checkNotNull(r5);
        return new SearchLoadMoreViewHolder(r5);
    L7:
        return new SearchBotViewHolder(new SearchResultItemView(r3.getContext(), null));
    }
}
