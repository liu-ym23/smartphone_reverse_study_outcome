package com.larus.bmhome.chat.search.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.bmhome.chat.layout.item.b4;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.bmhome.chat.search.ArticleInfo;
import com.larus.bmhome.chat.search.MoreInfo;
import com.larus.bmhome.chat.search.SkeletonInfo;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.bmhome.chat.search.holder.SearchCardMoreViewHolder;
import com.larus.bmhome.chat.search.holder.SearchCardTextImageViewHolder;
import com.larus.bmhome.chat.search.holder.SearchCardVideoViewHolder;
import com.larus.bmhome.chat.search.holder.SearchSkeletonViewHolder;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemType;
import com.larus.utils.e1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oi8.k;
import pi8.b;
import pi8.f;
import pi8.h;
import pi8.s;
import qi8.a;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/search/adapter/SearchNormalCardAdapter;", "Lcom/larus/bmhome/chat/search/adapter/SearchBaseCardAdapter;", "holderCallback", "Lcom/larus/bmhome/chat/search/factory/ISearchHolderCallback;", "extra", "", "", "<init>", "(Lcom/larus/bmhome/chat/search/factory/ISearchHolderCallback;Ljava/util/Map;)V", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SearchNormalCardAdapter extends SearchBaseCardAdapter {
    public final b a;
    public final Map<String, String> b;

    public SearchNormalCardAdapter(b4 r2, Map r3) {
        Intrinsics.checkNotNullParameter(r2, "holderCallback");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r32, int r33) {
        Intrinsics.checkNotNullParameter(r32, "holder");
        ItemData r2 = (ItemData) getItem(r33);
        SkeletonInfo r10 = null;
        ViewGroup.MarginLayoutParams r11 = null;
        String r12 = null;
        String r13 = null;
        MoreInfo r14 = null;
        if ((r32 instanceof SearchCardTextImageViewHolder) == false) goto L63;
        if ((r2 instanceof ArticleInfo) == false) goto L7;
        ArticleInfo r3 = (ArticleInfo) r2;
    L8:
        if (r3 != null) goto L10;
        return;
    L10:
        this.a.b(new f(r3, r33, r32.itemView));
        SearchCardTextImageViewHolder r1 = (SearchCardTextImageViewHolder) r32;
        Map<String, String> r4 = this.b;
        Intrinsics.checkNotNullParameter(r3, "item");
        r1.a.setText(r3.getTitle());
        r1.b.setText(r3.getSummary());
        r1.c.setText(r3.getSiteName());
        String r5 = r3.getIconUrl();
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == false) goto L19;
        e1.o(r1.e);
    L28:
        TextView r7 = r1.a;
        AppHost.Companion r8 = AppHost.a;
        float r9 = 1.0f;
        if (r8.isOversea() == false) goto L31;
        float r15 = 1.0f;
    L32:
        r7.setLineSpacing(0.0f, r15);
        TextView r16 = r1.b;
        if (r8.isOversea() == true) goto L36;
        r9 = 1.1f;
    L36:
        r16.setLineSpacing(0.0f, r9);
        String r17 = r3.getImageUrl();
        if (r17 != null) goto L39;
    L42:
        boolean r18 = true;
    L43:
        if (r18 == false) goto L54;
        e1.x(r1.b);
        ViewGroup.LayoutParams r19 = r1.a.getLayoutParams();
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == false) goto L47;
        r11 = (ViewGroup.MarginLayoutParams) r19;
    L47:
        if (r11 == null) goto L53;
        int r20 = i5.h();
        int r21 = i5.h();
        int r22 = i5.h();
        LruCache<String, k> r23 = SearchListBox.E;
        if (r8.isOversea() == false) goto L51;
        int r24 = i5.r0();
    L52:
        r11.setMargins(r20, r21, r22, r24);
        goto L53
    L51:
        r24 = i5.h();
    L53:
        r1.a.getViewTreeObserver().addOnPreDrawListener(new a(r1));
        e1.o(r1.d);
        return;
    L54:
        e1.q(r1.b);
        e1.x(r1.d);
        MessageImageLoader r110 = MessageImageLoader.a;
        if (r4 == null) goto L57;
        r12 = r4.get("message_id");
    L57:
        String r111 = r12;
        MessageImageType r112 = MessageImageType.IMAGE;
        SimpleDraweeView r25 = r1.d;
        String r26 = r3.getImageUrl();
        if (r26 != null) goto L60;
        String r113 = "";
    L61:
        IMessageImageLoaderService.a.b(r110, r111, r112, r25, r113, "chat.searchlist_cover_thumb", Integer.valueOf(((Number) i5.S0.getValue()).intValue()), Integer.valueOf(((Number) i5.u0.getValue()).intValue()), null, null, null, false, 1920);
        return;
    L60:
        r113 = r26;
        goto L61
    L39:
        if (r17.length() == 0) goto L42;
        r18 = false;
        goto L43
    L31:
        r15 = 1.1f;
        goto L32
    L19:
        e1.x(r1.e);
        MessageImageLoader r114 = MessageImageLoader.a;
        if (r4 == null) goto L22;
        String r115 = r4.get("message_id");
    L23:
        MessageImageType r116 = MessageImageType.IMAGE;
        SimpleDraweeView r27 = r1.e;
        String r28 = r3.getIconUrl();
        if (r28 != null) goto L26;
        String r117 = "";
    L27:
        IMessageImageLoaderService.a.b(r114, r115, r116, r27, r117, "chat.searchlist_icon", Integer.valueOf(i5.q()), Integer.valueOf(i5.q()), null, null, null, false, 1920);
        goto L28
    L26:
        r117 = r28;
        goto L27
    L22:
        r115 = null;
        goto L23
    L13:
        if (r5.length() == 0) goto L16;
        r6 = false;
        goto L17
    L7:
        r3 = null;
        goto L8
    L63:
        if ((r32 instanceof SearchCardVideoViewHolder) == false) goto L96;
        if ((r2 instanceof VideoInfo) == false) goto L67;
        VideoInfo r118 = (VideoInfo) r2;
    L68:
        if (r118 != null) goto L70;
        return;
    L70:
        this.a.b(new s(r118, r33, r32.itemView, false, 24));
        SearchCardVideoViewHolder r29 = (SearchCardVideoViewHolder) r32;
        Map<String, String> r30 = this.b;
        Intrinsics.checkNotNullParameter(r118, "item");
        r29.a.setText(r118.getSourceApp());
        MessageImageLoader r31 = MessageImageLoader.a;
        if (r30 == null) goto L73;
        String r119 = r30.get("message_id");
    L74:
        MessageImageType r210 = MessageImageType.VIDEO;
        SimpleDraweeView r34 = r29.b;
        String r35 = r118.getImageUrl();
        if (r35 != null) goto L77;
        String r211 = "";
    L78:
        IMessageImageLoaderService.a.b(r31, r119, r210, r34, r211, "chat.searchlist_cover_thumb", Integer.valueOf(((Number) i5.S0.getValue()).intValue()), Integer.valueOf(((Number) i5.j1.getValue()).intValue()), null, null, null, false, 1920);
        String r36 = r118.getIconUrl();
        if (r36 != null) goto L81;
    L84:
        boolean r37 = true;
    L85:
        if (r37 == false) goto L87;
        e1.o(r29.c);
        return;
    L87:
        e1.x(r29.c);
        if (r30 == null) goto L90;
        r13 = r30.get("message_id");
    L90:
        String r120 = r13;
        MessageImageType r212 = MessageImageType.IMAGE;
        SimpleDraweeView r38 = r29.c;
        String r39 = r118.getIconUrl();
        if (r39 != null) goto L93;
        String r213 = "";
    L94:
        IMessageImageLoaderService.a.b(r31, r120, r212, r38, r213, "chat.searchlist_icon", Integer.valueOf(i5.q()), Integer.valueOf(i5.q()), null, null, null, false, 1920);
        return;
    L93:
        r213 = r39;
        goto L94
    L81:
        if (r36.length() == 0) goto L84;
        r37 = false;
        goto L85
    L77:
        r211 = r35;
        goto L78
    L73:
        r119 = null;
        goto L74
    L67:
        r118 = null;
        goto L68
    L96:
        if ((r32 instanceof SearchCardMoreViewHolder) == false) goto L104;
        if ((r2 instanceof MoreInfo) == false) goto L100;
        r14 = (MoreInfo) r2;
    L100:
        if (r14 != null) goto L102;
        return;
    L102:
        this.a.b(new h(r14, r33, r32.itemView));
        SearchCardMoreViewHolder r40 = (SearchCardMoreViewHolder) r32;
        SearchCardMoreViewHolder.T3(r14);
        return;
    L104:
        if ((r32 instanceof SearchSkeletonViewHolder) == true) goto L106;
        return;
    L106:
        if ((r2 instanceof SkeletonInfo) == false) goto L108;
        r10 = (SkeletonInfo) r2;
    L108:
        if (r10 != null) goto L110;
        return;
    L110:
        ((SearchSkeletonViewHolder) r32).getClass();
        SearchSkeletonViewHolder.T3(r10);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != ItemType.TYPE_CARD_IMAGE_TEXT.getType()) goto L6;
        int r6 = SearchCardTextImageViewHolder.f;
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r7 = LayoutInflater.from(r4.getContext()).inflate(2131562636, r4, false);
        Intrinsics.checkNotNull(r7);
        return new SearchCardTextImageViewHolder(r7);
    L6:
        if (r5 != ItemType.TYPE_CARD_VIDEO.getType()) goto L9;
        int r8 = SearchCardVideoViewHolder.d;
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r9 = LayoutInflater.from(r4.getContext()).inflate(2131562641, r4, false);
        Intrinsics.checkNotNull(r9);
        return new SearchCardVideoViewHolder(r9);
    L9:
        if (r5 != ItemType.TYPE_CARD_SKELETON.getType()) goto L12;
        int r10 = SearchSkeletonViewHolder.a;
        return SearchSkeletonViewHolder.a.a(r4);
    L12:
        if (r5 != ItemType.TYPE_CARD_MORE.getType()) goto L14;
        int r11 = SearchCardMoreViewHolder.a;
        return SearchCardMoreViewHolder.a.a(r4);
    L14:
        int r12 = SearchCardMoreViewHolder.a;
        return SearchCardMoreViewHolder.a.a(r4);
    }
}
