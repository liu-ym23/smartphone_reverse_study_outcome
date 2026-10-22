package com.larus.bmhome.chat.search.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.bmhome.chat.layout.item.b4;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.bmhome.chat.search.holder.SearchCardUnavailableViewHolder;
import com.larus.bmhome.double_post.viewholder.AwemeRecommendContentViewHolder;
import com.larus.bmhome.searchmixedmedia.SearchMixedMediaItemView;
import com.larus.bmhome.video.CardRatioStrategy;
import com.larus.bmhome.video.Content;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemType;
import ip8.e;
import ip8.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pi8.b;
import pi8.g;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/search/adapter/SearchMixedMediaCardAdapter;", "Lcom/larus/bmhome/chat/search/adapter/SearchBaseCardAdapter;", "holderCallback", "Lcom/larus/bmhome/chat/search/factory/ISearchHolderCallback;", "imgCallback", "Lcom/larus/bmhome/chat/search/factory/ISearchImgCallback;", "<init>", "(Lcom/larus/bmhome/chat/search/factory/ISearchHolderCallback;Lcom/larus/bmhome/chat/search/factory/ISearchImgCallback;)V", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SearchMixedMediaCardAdapter extends SearchBaseCardAdapter {
    public final b a;

    public static final class a implements f {
        public final /* synthetic */ int a;

        public final boolean a() {
            return true;
        }

        public final boolean b() {
            return false;
        }

        public final void c() {
        }

        public final int d() {
            return com.larus.bmhome.video.b.d(0, 0, 7) - (this.a / 2);
        }

        public final e e() {
            return null;
        }

        public a(int r1) {
            this.a = r1;
        }
    }

    public SearchMixedMediaCardAdapter(b4 r1, SearchListBox.c r2) {
        Intrinsics.checkNotNullParameter(r1, "holderCallback");
        this.a = r1;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        Content r0 = (ItemData) getItem(r7);
        if ((r6 instanceof AwemeRecommendContentViewHolder) == false) goto L16;
        if ((r0 instanceof Content) == false) goto L7;
        Content r1 = r0;
    L8:
        if (r1 != null) goto L10;
        return;
    L10:
        r1.setRatioStrategy(CardRatioStrategy.FixRatio);
        if (this.a.a() != ExpandCardViewMode.EXPAND_SHARE) goto L13;
        int r2 = i5.E() + i5.j0();
    L14:
        ((AwemeRecommendContentViewHolder) r6).n2(r1, new a(r2));
        this.a.b(new g(r0, r7, r6.itemView));
        return;
    L13:
        r2 = 0;
        goto L14
    L7:
        r1 = null;
        goto L8
    L16:
        if ((r6 instanceof SearchCardUnavailableViewHolder) == false) goto L20;
        ((SearchCardUnavailableViewHolder) r6).bind("UnSupport item type: " + r0.getSearchItemType() + ", data type: " + Reflection.getOrCreateKotlinClass(r0.getClass()).getSimpleName());
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ItemType r0 = ItemType.TYPE_CARD_MIXED_MEDIA;
        if (r4 == r0.getType()) goto L9;
        if (r4 == r0.getType()) goto L9;
        int r5 = SearchCardUnavailableViewHolder.b;
        return SearchCardUnavailableViewHolder.a.a(r3, i5.s(), i5.G());
    L9:
        return new AwemeRecommendContentViewHolder(new SearchMixedMediaItemView(r3.getContext(), null));
    }
}
