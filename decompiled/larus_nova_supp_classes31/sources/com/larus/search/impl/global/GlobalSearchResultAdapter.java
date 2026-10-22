package com.larus.search.impl.global;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.paging.PagingDataAdapter;
import com.larus.search.impl.global.view.SearchResultItemView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u000eR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/search/impl/global/GlobalSearchResultAdapter;", "Lcom/larus/paging/PagingDataAdapter;", "Lcom/larus/search/impl/global/model/GlobalSearchResultItemWrapper;", "Lcom/larus/search/impl/global/GlobalSearchResultAdapter$ItemHolder;", "<init>", "()V", "eventHelper", "Lcom/larus/search/impl/global/view/SearchResultItemView$EventHelper;", "setEventHelper", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemData", "Companion", "ItemHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GlobalSearchResultAdapter extends PagingDataAdapter<ws9.c, ItemHolder> {
    public static final GlobalSearchResultAdapter$Companion$diff$1 d = null;
    public SearchResultItemView.b c;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/search/impl/global/GlobalSearchResultAdapter$ItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Lcom/larus/search/impl/global/view/SearchResultItemView;", "<init>", "(Lcom/larus/search/impl/global/view/SearchResultItemView;)V", "getView", "()Lcom/larus/search/impl/global/view/SearchResultItemView;", "bind", "", "item", "Lcom/larus/search/impl/global/model/GlobalSearchResultItem;", "index", "", "eventHelper", "Lcom/larus/search/impl/global/view/SearchResultItemView$EventHelper;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class ItemHolder extends RecyclerView.ViewHolder {
        public final SearchResultItemView a;

        public ItemHolder(SearchResultItemView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2;
        }
    }

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.search.impl.global.GlobalSearchResultAdapter$Companion$diff$1] */
    static {
        d = new GlobalSearchResultAdapter$Companion$diff$1();
    }

    public GlobalSearchResultAdapter() {
        super(d);
    }

    public final ws9.c B2(int r4) {
        if (r4 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L15;
        com.larus.paging.e r3 = ((PagingDataAdapter) this).a;
        r3.getClass();
        r3.e = true;     // Catch: Throwable -> L12
        Object r5 = r3.f.b(r4);     // Catch: Throwable -> L12
        r3.e = false;
        return (ws9.c) r5;
    L12:
        th = move-exception;
        r3.e = false;
        throw th;
    L15:
        return null;
    L5:
        if (r4 >= getItemCount()) goto L7;
        r2 = true;
        goto L8
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        ItemHolder r6 = (ItemHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        com.larus.paging.e r0 = ((PagingDataAdapter) this).a;
        r0.getClass();
        r0.e = true;     // Catch: Throwable -> L8
        Object r1 = r0.f.b(r5);     // Catch: Throwable -> L8
        r0.e = false;
        ws9.c r2 = (ws9.c) r1;
        if (r2 == null) goto L13;
        ws9.b r3 = r2.b;
        SearchResultItemView.b r7 = this.c;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r3, "item");
        r6.a.a(r3, r5, r7);
        return;
    L13:
        return;
    L8:
        th = move-exception;
        r0.e = false;
        throw th;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new ItemHolder(new SearchResultItemView(r3.getContext(), null));
    }
}
