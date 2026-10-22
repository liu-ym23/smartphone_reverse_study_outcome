package com.larus.bmhome.chat.search.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import c29.a;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.item.b4;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.bmhome.chat.search.ArticleInfo;
import com.larus.bmhome.chat.search.MoreInfo;
import com.larus.bmhome.chat.search.SkeletonInfo;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.bmhome.chat.search.holder.SearchCardMoreViewHolder;
import com.larus.bmhome.chat.search.holder.SearchCardTextTinyViewHolder;
import com.larus.bmhome.chat.search.holder.SearchCardVideoTinyViewHolder;
import com.larus.bmhome.chat.search.holder.SearchSkeletonViewHolder;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemType;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pi8.b;
import pi8.f;
import pi8.h;
import pi8.q;
import pi8.s;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u001a\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/search/adapter/SearchTinyCardAdapter;", "Lcom/larus/bmhome/chat/search/adapter/SearchBaseCardAdapter;", "holderCallback", "Lcom/larus/bmhome/chat/search/factory/ISearchHolderCallback;", "param", "Lcom/larus/bmhome/chat/search/factory/SearchTinyAdapterCreateParam;", "extra", "", "", "<init>", "(Lcom/larus/bmhome/chat/search/factory/ISearchHolderCallback;Lcom/larus/bmhome/chat/search/factory/SearchTinyAdapterCreateParam;Ljava/util/Map;)V", "mRecyclerView", "Landroid/view/ViewGroup;", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "viewType", "", "onBindViewHolder", "", "holder", "position", "measureAlignHeight", "width", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SearchTinyCardAdapter extends SearchBaseCardAdapter {
    public final b a;
    public final q b;
    public final Map<String, String> c;
    public ViewGroup d;

    public static int y2(int r3, ViewGroup r4) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131562639, r4, false);
        r5.measure(View.MeasureSpec.makeMeasureSpec(r3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r5.getMeasuredHeight();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r35, int r36) {
        Intrinsics.checkNotNullParameter(r35, "holder");
        ItemData r2 = (ItemData) getItem(r36);
        boolean r10 = true;
        SkeletonInfo r16 = null;
        Context r17 = null;
        Context r18 = null;
        String r19 = null;
        MoreInfo r110 = null;
        if ((r35 instanceof SearchCardTextTinyViewHolder) == false) goto L50;
        if ((r2 instanceof ArticleInfo) == false) goto L7;
        ArticleInfo r6 = (ArticleInfo) r2;
    L8:
        if (r6 != null) goto L10;
        return;
    L10:
        this.a.b(new f(r6, r36, r35.itemView));
        ViewGroup.LayoutParams r3 = r35.itemView.getLayoutParams();
        Resources r4 = AppHost.a.getApplication().getResources();
        r3.width = (WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).widthPixels - i5.p0()) / 2;
        r3.height = -2;
        r35.itemView.setLayoutParams(r3);
        SearchCardTextTinyViewHolder r5 = (SearchCardTextTinyViewHolder) r35;
        Intrinsics.checkNotNullParameter(r6, "item");
        if (r5.c == false) goto L16;
        a r1 = r5.j.getDelegate();
        Context r7 = ((RecyclerView.ViewHolder) r5).itemView.getContext();
        SimpleDraweeView r8 = r5.i;
        if (r8 == null) goto L15;
        r17 = r8.getContext();
    L15:
        r1.a(ContextCompat.getColor(r7, c.b(2130970531, r17, 2131102535)));
    L21:
        if (r5.b == 5) goto L23;
    L25:
        boolean r9 = false;
    L26:
        if (r9 == false) goto L30;
        e1.x(r5.i);
        e1.o(r5.f);
        e1.o(r5.d);
        e1.o(r5.g);
        String r11 = r6.getImageUrl();
        if (r11 == null) goto L122;
        r5.T3(r36, r5.i, r11, "chat.searchlist_cover_thumb", i5.u(), i5.w0());
        return;
    L122:
        return;
    L30:
        r5.d.setText(r6.getTitle());
        r5.f.setText(r6.getSiteName());
        String r12 = r6.getIconUrl();
        if (r12 == null) goto L33;
        int r13 = 2;
        r5.T3(r36, r5.g, r12, "chat.searchlist_icon", i5.q(), i5.q());
    L34:
        String r14 = r6.getIconUrl();
        if (r14 != null) goto L37;
    L40:
        if (r10 == false) goto L43;
        e1.o(r5.g);
    L43:
        if (r5.b == r13) goto L45;
        return;
    L45:
        if (o0.d(r6.getImageUrl()) == false) goto L125;
        String r15 = r6.getImageUrl();
        if (r15 == null) goto L126;
        a r20 = r5.j.getDelegate();
        Resources r21 = r20.b.getResources();
        r20.m = (int) ((0 * WindowDisplayMetricsOverride.apply(r21, r21.getDisplayMetrics()).density) + 0.5f);
        r20.c();
        e1.x(r5.h);
        r5.h.setAlpha(0.44f);
        e1.x(r5.i);
        r5.T3(r36, r5.i, r15, "chat.searchlist_cover_thumb", i5.u(), i5.w0());
        r5.d.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r5).itemView.getContext(), 2131103298));
        r5.f.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r5).itemView.getContext(), 2131103298));
        return;
    L126:
        return;
    L125:
        return;
    L37:
        if (r14.length() == 0) goto L40;
        r10 = false;
        goto L40
    L33:
        r13 = 2;
        goto L34
    L23:
        if (r5.a != 2) goto L25;
        r9 = true;
        goto L26
    L16:
        a r22 = r5.j.getDelegate();
        Context r23 = ((RecyclerView.ViewHolder) r5).itemView.getContext();
        SimpleDraweeView r24 = r5.i;
        if (r24 == null) goto L19;
        r18 = r24.getContext();
    L19:
        r22.a(ContextCompat.getColor(r23, c.b(2130970529, r18, 2131102529)));
        goto L21
    L7:
        r6 = null;
        goto L8
    L50:
        if ((r35 instanceof SearchCardVideoTinyViewHolder) == false) goto L105;
        if ((r2 instanceof VideoInfo) == false) goto L54;
        VideoInfo r25 = (VideoInfo) r2;
    L55:
        if (r25 != null) goto L57;
        return;
    L57:
        VideoInfo r26 = r25;
        this.a.b(new s(r25, r36, r35.itemView, false, 24));
        ViewGroup.LayoutParams r27 = r35.itemView.getLayoutParams();
        Resources r28 = AppHost.a.getApplication().getResources();
        int r29 = (WindowDisplayMetricsOverride.apply(r28, r28.getDisplayMetrics()).widthPixels - i5.p0()) / 2;
        r27.width = r29;
        r27.height = y2(r29, this.d);
        r35.itemView.setLayoutParams(r27);
        SearchCardVideoTinyViewHolder r30 = (SearchCardVideoTinyViewHolder) r35;
        Map<String, String> r31 = this.c;
        Intrinsics.checkNotNullParameter(r26, "item");
        if (r30.c == false) goto L60;
        r30.j.getDelegate().a(ContextCompat.getColor(((RecyclerView.ViewHolder) r30).itemView.getContext(), c.b(2130970531, ((RecyclerView.ViewHolder) r30).itemView.getContext(), 2131102535)));
    L61:
        r30.d.setText(r26.getSourceApp());
        if (r30.a != 1) goto L68;
        int r32 = r30.b;
        if (r32 != 4) goto L66;
    L67:
        boolean r33 = true;
    L70:
        if (r33 == false) goto L72;
        e1.o(r30.g);
        r30.h.setText(r26.getDescription());
        e1.x(r30.h);
        e1.o(r30.i);
        r30.d.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r30).itemView.getContext(), c.b(2130972082, ((RecyclerView.ViewHolder) r30).itemView.getContext(), 2131103146)));
    L80:
        String r34 = r26.getIconUrl();
        if (r34 != null) goto L83;
    L86:
        boolean r37 = true;
    L87:
        if (r37 == true) goto L89;
    L98:
        e1.x(r30.f);
        String r210 = r26.getIconUrl();
        if (r210 == null) goto L129;
        MessageImageLoader r111 = MessageImageLoader.a;
        if (r31 == null) goto L103;
        r19 = r31.get("message_id");
    L103:
        IMessageImageLoaderService.a.b(r111, r19, MessageImageType.IMAGE, r30.f, r210, "chat.searchlist_icon", Integer.valueOf(i5.q()), Integer.valueOf(i5.q()), null, null, null, false, 1920);
        return;
    L129:
        return;
    L89:
        if (r30.a != 1) goto L95;
        int r38 = r30.b;
        if (r38 != 4) goto L93;
    L96:
        if (r10 == false) goto L98;
        e1.o(r30.f);
        return;
    L93:
        if (r38 == 5) goto L96;
    L95:
        r10 = false;
        goto L96
    L83:
        if (r34.length() == 0) goto L86;
        r37 = false;
        goto L87
    L72:
        MessageImageLoader r211 = MessageImageLoader.a;
        if (r31 == null) goto L75;
        String r212 = r31.get("message_id");
    L76:
        MessageImageType r213 = MessageImageType.VIDEO;
        SimpleDraweeView r39 = r30.e;
        String r40 = r26.getImageUrl();
        if (r40 != null) goto L79;
        r40 = "";
    L79:
        IMessageImageLoaderService.a.b(r211, r212, r213, r39, r40, "chat.searchlist_cover_thumb", Integer.valueOf(((Number) i5.S0.getValue()).intValue()), Integer.valueOf(((Number) i5.j1.getValue()).intValue()), null, null, null, false, 1920);
        goto L80
    L75:
        r212 = null;
        goto L76
    L66:
        if (r32 == 5) goto L67;
    L68:
        r33 = false;
        goto L70
    L60:
        r30.j.getDelegate().a(ContextCompat.getColor(((RecyclerView.ViewHolder) r30).itemView.getContext(), 2131103298));
        goto L61
    L54:
        r25 = null;
        goto L55
    L105:
        if ((r35 instanceof SearchCardMoreViewHolder) == false) goto L114;
        if ((r2 instanceof MoreInfo) == false) goto L109;
        r110 = (MoreInfo) r2;
    L109:
        MoreInfo r41 = r110;
        if (r41 != null) goto L112;
        return;
    L112:
        ViewGroup.LayoutParams r42 = r35.itemView.getLayoutParams();
        r42.width = i5.u();
        r42.height = y2(i5.u(), this.d);
        r35.itemView.setLayoutParams(r42);
        this.a.b(new h(r41, r36, r35.itemView));
        SearchCardMoreViewHolder r43 = (SearchCardMoreViewHolder) r35;
        SearchCardMoreViewHolder.T3(r41);
        return;
    L114:
        if ((r35 instanceof SearchSkeletonViewHolder) == true) goto L116;
        return;
    L116:
        if ((r2 instanceof SkeletonInfo) == false) goto L118;
        r16 = (SkeletonInfo) r2;
    L118:
        if (r16 != null) goto L120;
        return;
    L120:
        ViewGroup.LayoutParams r44 = r35.itemView.getLayoutParams();
        Resources r45 = AppHost.a.getApplication().getResources();
        int r46 = (WindowDisplayMetricsOverride.apply(r45, r45.getDisplayMetrics()).widthPixels - i5.p0()) / 2;
        r44.width = r46;
        r44.height = y2(r46, this.d);
        r35.itemView.setLayoutParams(r44);
        SearchSkeletonViewHolder r47 = (SearchSkeletonViewHolder) r35;
        SearchSkeletonViewHolder.T3(r16);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        this.d = r6;
        if (r7 != ItemType.TYPE_CARD_IMAGE_TEXT.getType()) goto L6;
        int r8 = SearchCardTextTinyViewHolder.k;
        q r9 = this.b;
        int r1 = r9.b;
        int r3 = r9.c;
        boolean r10 = r9.a;
        Intrinsics.checkNotNullParameter(r6, "parent");
        View r11 = LayoutInflater.from(r6.getContext()).inflate(2131562639, r6, false);
        Intrinsics.checkNotNull(r11);
        return new SearchCardTextTinyViewHolder(r11, r1, r3, r10);
    L6:
        if (r7 != ItemType.TYPE_CARD_VIDEO.getType()) goto L9;
        int r12 = SearchCardVideoTinyViewHolder.k;
        q r13 = this.b;
        int r2 = r13.b;
        int r4 = r13.c;
        boolean r14 = r13.a;
        Intrinsics.checkNotNullParameter(r6, "parent");
        View r15 = LayoutInflater.from(r6.getContext()).inflate(2131562640, r6, false);
        Intrinsics.checkNotNull(r15);
        return new SearchCardVideoTinyViewHolder(r15, r2, r4, r14);
    L9:
        if (r7 != ItemType.TYPE_CARD_SKELETON.getType()) goto L12;
        int r16 = SearchSkeletonViewHolder.a;
        return SearchSkeletonViewHolder.a.a(r6);
    L12:
        if (r7 != ItemType.TYPE_CARD_MORE.getType()) goto L14;
        int r17 = SearchCardMoreViewHolder.a;
        return SearchCardMoreViewHolder.a.a(r6);
    L14:
        int r18 = SearchCardMoreViewHolder.a;
        return SearchCardMoreViewHolder.a.a(r6);
    }

    public SearchTinyCardAdapter(b4 r2, q r3, Map r4) {
        Intrinsics.checkNotNullParameter(r2, "holderCallback");
        Intrinsics.checkNotNullParameter(r3, "param");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
