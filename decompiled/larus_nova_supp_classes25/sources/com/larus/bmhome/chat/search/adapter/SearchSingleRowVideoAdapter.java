package com.larus.bmhome.chat.search.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.bmhome.chat.layout.item.b4;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.bmhome.chat.search.holder.SearchCardSingleRowVideoHolder;
import com.larus.bmhome.chat.search.holder.SearchCardUnavailableViewHolder;
import com.larus.bmhome.chat.search.view.SearchVideoLargeCardViewV2;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemType;
import com.larus.utils.e1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pi8.b;
import pi8.c;
import pi8.s;
import ti8.f;
import ti8.g;
import ti8.h;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/search/adapter/SearchSingleRowVideoAdapter;", "Lcom/larus/bmhome/chat/search/adapter/SearchBaseCardAdapter;", "holderCallback", "Lcom/larus/bmhome/chat/search/factory/ISearchHolderCallback;", "imgCallback", "Lcom/larus/bmhome/chat/search/factory/ISearchImgCallback;", "extra", "", "", "<init>", "(Lcom/larus/bmhome/chat/search/factory/ISearchHolderCallback;Lcom/larus/bmhome/chat/search/factory/ISearchImgCallback;Ljava/util/Map;)V", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SearchSingleRowVideoAdapter extends SearchBaseCardAdapter {
    public final b a;
    public final c b;
    public final Map<String, String> c;

    public final void onBindViewHolder(RecyclerView.ViewHolder r25, final int r26) {
        Intrinsics.checkNotNullParameter(r25, "holder");
        ItemData r2 = (ItemData) getItem(r26);
        if ((r25 instanceof SearchCardSingleRowVideoHolder) == false) goto L36;
        if ((r2 instanceof VideoInfo) == false) goto L7;
        final VideoInfo r10 = (VideoInfo) r2;
    L8:
        if (r10 != null) goto L10;
        return;
    L10:
        this.a.b(new s(r10, r26, r25.itemView, true, 16));
        SearchCardSingleRowVideoHolder r1 = (SearchCardSingleRowVideoHolder) r25;
        final c r3 = this.b;
        Intrinsics.checkNotNullParameter(r10, "item");
        SearchVideoLargeCardViewV2 r4 = r1.a;
        Map<String, String> r5 = r1.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r10, "item");
        r4.c.setText(r10.getDescription());
        MessageImageLoader r6 = MessageImageLoader.a;
        if (r5 == null) goto L13;
        String r12 = r5.get("message_id");
    L14:
        MessageImageType r13 = MessageImageType.VIDEO;
        SimpleDraweeView r14 = r4.d;
        String r7 = r10.getImageUrl();
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        IMessageImageLoaderService.a.b(r6, r12, r13, r14, r7, "chat.searchlist_cover_thumb", Integer.valueOf(i5.n()), Integer.valueOf(i5.D()), new f(r3, r10, r26), new g(r3, r26), new h(r3, r10, r26), false, 1024);
        String r15 = r10.getIconUrlCompat();
        if (AppHost.a.isOversea() == false) goto L21;
        MarkdownSourceImageView.f(r4.f, r10.getHostPageUrl(), r10.getIconUrlCompat(), null, 4);
        e1.o(r4.e);
    L34:
        ExpandCardViewMode r8 = this.a.a();
        Intrinsics.checkNotNullParameter(r8, "mode");
        r1.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "mode");
        return;
    L21:
        if (r15 != null) goto L23;
    L26:
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        e1.o(r4.e);
        goto L34
    L29:
        e1.x(r4.e);
        if (r5 == null) goto L32;
        String r16 = r5.get("message_id");
    L33:
        IMessageImageLoaderService.a.b(r6, r16, MessageImageType.IMAGE, r4.e, r15, "chat.searchlist_icon", Integer.valueOf(i5.q()), Integer.valueOf(i5.q()), null, null, null, false, 1920);
        goto L34
    L32:
        r16 = null;
        goto L33
    L23:
        if (r15.length() == 0) goto L26;
        r9 = false;
        goto L27
    L13:
        r12 = null;
        goto L14
    L7:
        r10 = null;
        goto L8
    L36:
        if ((r25 instanceof SearchCardUnavailableViewHolder) == false) goto L40;
        ((SearchCardUnavailableViewHolder) r25).bind("UnSupport item type: " + r2.getSearchItemType() + ", data type: " + Reflection.getOrCreateKotlinClass(r2.getClass()).getSimpleName());
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (r6 != ItemType.TYPE_CARD_VIDEO.getType()) goto L5;
        int r7 = SearchCardSingleRowVideoHolder.c;
        Map<String, String> r8 = this.c;
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new SearchCardSingleRowVideoHolder(new SearchVideoLargeCardViewV2(r5.getContext(), null, 0), r8);
    L5:
        int r9 = SearchCardUnavailableViewHolder.b;
        return SearchCardUnavailableViewHolder.a.a(r5, i5.s(), i5.G());
    }

    public SearchSingleRowVideoAdapter(b4 r2, SearchListBox.c r3, Map r4) {
        Intrinsics.checkNotNullParameter(r2, "holderCallback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
