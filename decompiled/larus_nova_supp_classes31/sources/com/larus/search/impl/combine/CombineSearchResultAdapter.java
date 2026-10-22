package com.larus.search.impl.combine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.search.impl.global.view.SearchResultItemView;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b*\u0001\u000f\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005-./01B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0016J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0016J0\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020'H\u0002J8\u0010(\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010)\u001a\u00020#H\u0002J\r\u0010*\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010+J\b\u0010,\u001a\u0004\u0018\u00010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u00062"}, d2 = {"Lcom/larus/search/impl/combine/CombineSearchResultAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/search/impl/combine/CombineSearchResult;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "listener", "Lcom/larus/search/impl/combine/CombineSearchItemListener;", "eventHelper", "Lcom/larus/search/impl/global/view/SearchResultItemView$EventHelper;", "<init>", "(Lcom/larus/search/impl/combine/CombineSearchItemListener;Lcom/larus/search/impl/global/view/SearchResultItemView$EventHelper;)V", "getListener", "()Lcom/larus/search/impl/combine/CombineSearchItemListener;", "lastItemCount", "", "scrollListener", "com/larus/search/impl/combine/CombineSearchResultAdapter$scrollListener$1", "Lcom/larus/search/impl/combine/CombineSearchResultAdapter$scrollListener$1;", "reset", "", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemViewType", "setAvatar", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "url", "", "resizeWidth", "reSizeHeight", "circle", "", "loadAvatar", "bizTag", "isLoadMoreTypeBot", "()Ljava/lang/Boolean;", "findLastSearchId", "Companion", "SearchBotViewHolder", "SearchLoadMoreViewHolder", "SearchTitleViewHolder", "SearchMessageViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CombineSearchResultAdapter extends ListAdapter<c0, RecyclerView.ViewHolder> {
    public static final /* synthetic */ int e = 0;
    public final a0 a;
    public final SearchResultItemView.b b;
    public int c;
    public final CombineSearchResultAdapter$scrollListener$1 d;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/search/impl/combine/CombineSearchResultAdapter$SearchBotViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Lcom/larus/search/impl/global/view/SearchResultItemView;", "<init>", "(Lcom/larus/search/impl/combine/CombineSearchResultAdapter;Lcom/larus/search/impl/global/view/SearchResultItemView;)V", "getView", "()Lcom/larus/search/impl/global/view/SearchResultItemView;", "bind", "", "item", "Lcom/larus/search/impl/global/model/GlobalSearchResultItem;", "index", "", "eventHelper", "Lcom/larus/search/impl/global/view/SearchResultItemView$EventHelper;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public final class SearchBotViewHolder extends RecyclerView.ViewHolder {
        public final SearchResultItemView a;

        public SearchBotViewHolder(SearchResultItemView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/search/impl/combine/CombineSearchResultAdapter$SearchLoadMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/search/impl/combine/CombineSearchResultAdapter;Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public final class SearchLoadMoreViewHolder extends RecyclerView.ViewHolder {
        public SearchLoadMoreViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/search/impl/combine/CombineSearchResultAdapter$SearchMessageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/search/impl/combine/CombineSearchResultAdapter;Landroid/view/View;)V", "textTitle", "Landroid/widget/TextView;", "imageTagIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "textSubtitle", "textDate", "imageAvatar", "Lcom/facebook/drawee/view/SimpleDraweeView;", "bind", "", "item", "Lcom/larus/search/impl/combine/CombineSearchResult;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public final class SearchMessageViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int g = 0;
        public final TextView a;
        public final AppCompatImageView b;
        public final TextView c;
        public final TextView d;
        public final SimpleDraweeView e;
        public final /* synthetic */ CombineSearchResultAdapter f;

        public SearchMessageViewHolder(CombineSearchResultAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.f = r2;
            super(r3);
            this.a = (TextView) r3.findViewById(2131388498);
            this.b = r3.findViewById(2131375079);
            this.c = (TextView) r3.findViewById(2131388497);
            this.d = (TextView) r3.findViewById(2131388493);
            this.e = r3.findViewById(2131375057);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/search/impl/combine/CombineSearchResultAdapter$SearchTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/search/impl/combine/CombineSearchResultAdapter;Landroid/view/View;)V", "textTitleName", "Landroid/widget/TextView;", "textTitleAll", "dividerTitleTop", "bind", "", "item", "Lcom/larus/search/impl/combine/CombineSearchResult;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public final class SearchTitleViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int e = 0;
        public final TextView a;
        public final View b;
        public final View c;
        public final /* synthetic */ CombineSearchResultAdapter d;

        public SearchTitleViewHolder(CombineSearchResultAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.d = r2;
            super(r3);
            this.a = (TextView) r3.findViewById(2131385617);
            this.b = r3.findViewById(2131385616);
            this.c = r3.findViewById(2131385619);
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

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.search.impl.combine.CombineSearchResultAdapter$scrollListener$1] */
    public CombineSearchResultAdapter(CombineSearchFragment.e r2, CombineSearchFragment.EventHelper r3) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        super(new AnonymousClass1());
        this.a = r2;
        this.b = r3;
        this.d = new CombineSearchResultAdapter$scrollListener$1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "holder");
        final c0 r0 = (c0) getItem(r10);
        if ((r9 instanceof SearchBotViewHolder) == false) goto L6;
        if (r0 == null) goto L57;
        ws9.b r1 = r0.q;
        SearchResultItemView.b r2 = this.b;
        ((SearchBotViewHolder) r9).a.a(r1, r10, r2);
        return;
    L57:
        return;
    L6:
        int r3 = 0;
        RoundingParams r4 = null;
        if ((r9 instanceof SearchMessageViewHolder) == false) goto L36;
        SearchMessageViewHolder r11 = (SearchMessageViewHolder) r9;
        Intrinsics.checkNotNull(r0);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r0, "item");
        r11.a.setText(r0.f);
        r11.c.setText(r0.g);
        r11.d.setText(r0.j);
        wc9.e r12 = r0.d;
        if (r12 == null) goto L16;
        Integer r13 = r12.j;
        if (r13 == null) goto L16;
        if (r13.intValue() != 1) goto L16;
        boolean r14 = true;
    L17:
        if (r14 == false) goto L19;
        e1.x(r11.b);
        r11.b.setImageResource(2131241987);
    L20:
        wc9.e r15 = r0.d;
        if (r15 == null) goto L28;
        Integer r16 = r15.j;
        if (r16 == null) goto L28;
        if (r16.intValue() != 2) goto L28;
        r3 = 1;
    L28:
        CombineSearchResultAdapter r17 = r11.f;
        final SimpleDraweeView r5 = r11.e;
        String r6 = r0.h;
        if (r6 != null) goto L31;
        r6 = "";
    L31:
        final int r7 = i5.Z();
        final int r8 = i5.Z();
        boolean r18 = r3 ^ 1;
        r17.getClass();
        r5.getHierarchy().setFailureImage(2131240119);
        ImageLoaderKt.y(r5, r6, "search.chat_avatar", new d0(r5, r7, r8), 4);
        GenericDraweeHierarchy r19 = r5.getHierarchy();
        RoundingParams r20 = r5.getHierarchy().getRoundingParams();
        if (r20 == null) goto L34;
        r4 = r20.setRoundAsCircle(r18);
    L34:
        r19.setRoundingParams(r4);
        View r110 = ((RecyclerView.ViewHolder) r11).itemView;
        final CombineSearchResultAdapter r21 = r11.f;
        e1.d(r110, new e0(r21, r0));
        return;
    L19:
        e1.o(r11.b);
    L16:
        r14 = false;
        goto L17
    L36:
        if ((r9 instanceof SearchTitleViewHolder) == false) goto L60;
        SearchTitleViewHolder r22 = (SearchTitleViewHolder) r9;
        Intrinsics.checkNotNull(r0);
        r22.getClass();
        Intrinsics.checkNotNullParameter(r0, "item");
        TextView r111 = r22.a;
        i0 r23 = r0.o;
        if (r23 == null) goto L40;
        r4 = r23.a;
    L40:
        r111.setText(r4);
        View r112 = r22.c;
        i0 r24 = r0.o;
        if (r24 == null) goto L43;
        boolean r25 = r24.c;
    L45:
        if (r25 == false) goto L47;
        int r26 = 0;
    L48:
        r112.setVisibility(r26);
        View r113 = r22.b;
        i0 r27 = r0.o;
        if (r27 == null) goto L51;
        boolean r28 = r27.b;
    L52:
        if (r28 == true) goto L55;
        r3 = 8;
    L55:
        r113.setVisibility(r3);
        View r114 = r22.b;
        final CombineSearchResultAdapter r29 = r22.d;
        e1.d(r114, new f0(r29, r0));
        return;
    L51:
        r28 = false;
        goto L52
    L47:
        r26 = 8;
        goto L48
    L43:
        r25 = false;
        goto L45
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 == 16) goto L13;
        if (r4 != 17) goto L7;
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562644, r3, false);
        Intrinsics.checkNotNull(r5);
        return new SearchMessageViewHolder(this, r5);
    L7:
        if (r4 == 48) goto L9;
        View r6 = LayoutInflater.from(r3.getContext()).inflate(2131562650, r3, false);
        Intrinsics.checkNotNull(r6);
        return new SearchLoadMoreViewHolder(r6);
    L9:
        View r7 = LayoutInflater.from(r3.getContext()).inflate(2131562663, r3, false);
        Intrinsics.checkNotNull(r7);
        return new SearchTitleViewHolder(this, r7);
    L13:
        return new SearchBotViewHolder(new SearchResultItemView(r3.getContext(), null));
    }
}
