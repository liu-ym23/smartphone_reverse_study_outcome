package com.larus.bmhome.chat.search.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.item.b4;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.bmhome.chat.search.holder.SearchCardImageViewHolder;
import com.larus.bmhome.chat.search.holder.SearchCardUnavailableViewHolder;
import com.larus.bmhome.chat.search.view.SearchImageCardView;
import com.larus.im.bean.message.ImageDisplaySize;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemType;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.platform.service.e2;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import pi8.b;
import pi8.e;
import v19.i5;
import yc9.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u001a\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00190\u00180\u0017H\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\nH\u0002J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/search/adapter/SearchImage4CardAdapter;", "Lcom/larus/bmhome/chat/search/adapter/SearchBaseCardAdapter;", "holderCallback", "Lcom/larus/bmhome/chat/search/factory/ISearchHolderCallback;", "extra", "", "", "<init>", "(Lcom/larus/bmhome/chat/search/factory/ISearchHolderCallback;Ljava/util/Map;)V", "imageViewHolder", "", "Lcom/larus/bmhome/chat/search/holder/SearchCardImageViewHolder;", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getImageHolderViewList", "", "Lkotlin/Pair;", "Landroid/view/View;", "getImageInfoList", "Lcom/larus/im/bean/message/SearchImageInfo;", "parseImageViewData", "Lcom/larus/bmhome/chat/search/view/SearchImageCardViewData;", "imageInfo", "expandCardViewMode", "Lcom/larus/bmhome/chat/search/factory/ExpandCardViewMode;", "needShowSourceIcon", "", "onViewRecycled", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SearchImage4CardAdapter extends SearchBaseCardAdapter {
    public final b a;
    public final Map<String, String> b;
    public final List<SearchCardImageViewHolder> c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ImageDisplaySize.values().length];
            r0[ImageDisplaySize.small.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ImageDisplaySize.medium.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.search.adapter.SearchImage4CardAdapter$onBindViewHolder$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<List<SearchImageInfo>> {
        public AnonymousClass1(Object r8) {
            super(0, r8, SearchImage4CardAdapter.class, "getImageInfoList", "getImageInfoList()Ljava/util/List;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final List<SearchImageInfo> m106invoke() {
            List r0 = ((SearchImage4CardAdapter) ((CallableReference) this).receiver).getCurrentList();
            ArrayList r1 = new ArrayList();
            Iterator r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            Object r3 = r2.next();
            if ((r3 instanceof SearchImageInfo) == false) goto L4;
            r1.add(r3);
            goto L4
        L8:
            ArrayList r4 = new ArrayList();
            Iterator r5 = r1.iterator();
        L9:
            boolean r6 = true;
            if (r5.hasNext() == false) goto L15;
            Object r7 = r5.next();
            if ((!((SearchImageInfo) r7).isPlaceHolder()) == false) goto L15;
            r4.add(r7);
        L15:
            ArrayList r8 = new ArrayList();
            SearchImageInfo r9 = (SearchImageInfo) CollectionsKt.lastOrNull(r4);
            if (r9 == null) goto L18;
            List r10 = r9.getFoldImageInfoList();
        L19:
            r8.addAll(r4);
            List r11 = r10;
            if (r11 != null) goto L22;
        L25:
            if (r6 == true) goto L27;
            r8.addAll(r11);
        L27:
            return r8;
        L22:
            if (r11.isEmpty() == true) goto L25;
            r6 = false;
            goto L25
        L18:
            r10 = null;
            goto L19
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return m106invoke();
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.search.adapter.SearchImage4CardAdapter$onBindViewHolder$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<List<? extends Pair<? extends Integer, ? extends View>>> {
        public AnonymousClass2(Object r8) {
            super(0, r8, SearchImage4CardAdapter.class, "getImageHolderViewList", "getImageHolderViewList()Ljava/util/List;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final List<Pair<Integer, View>> m107invoke() {
            List<SearchCardImageViewHolder> r0 = ((SearchImage4CardAdapter) ((CallableReference) this).receiver).c;
            ArrayList r1 = new ArrayList();
            Iterator r2 = ((ArrayList) r0).iterator();
        L4:
            if (r2.hasNext() == false) goto L11;
            SearchCardImageViewHolder r3 = (SearchCardImageViewHolder) r2.next();
            if (r3.getAdapterPosition() == (-1)) goto L8;
            Pair r4 = new Pair(Integer.valueOf(r3.getAdapterPosition()), ((RecyclerView.ViewHolder) r3).itemView);
        L9:
            if (r4 == null) goto L4;
            r1.add(r4);
            goto L4
        L8:
            r4 = null;
            goto L9
        L11:
            return r1;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return m107invoke();
        }
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r2);
        TypeIntrinsics.asMutableCollection(this.c).remove(r2);
    }

    public SearchImage4CardAdapter(b4 r2, Map r3) {
        Intrinsics.checkNotNullParameter(r2, "holderCallback");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.widget.FrameLayout, com.larus.bmhome.chat.search.view.SearchImageCardView, com.larus.common_ui.widget.roundlayout.RoundFrameLayout, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, ti8.a] */
    public final void onBindViewHolder(RecyclerView.ViewHolder r25, int r26) {
        Intrinsics.checkNotNullParameter(r25, "holder");
        SearchImageInfo r2 = (ItemData) getItem(r26);
        if ((r25 instanceof SearchCardImageViewHolder) == false) goto L80;
        String r9 = null;
        if ((r2 instanceof SearchImageInfo) == false) goto L7;
        SearchImageInfo r10 = r2;
    L8:
        if (r10 != null) goto L11;
        return;
    L11:
        if (r10.isPlaceHolder() == false) goto L13;
    L16:
        ExpandCardViewMode r3 = this.a.a();
        boolean r4 = true;
        if (r26 != 1) goto L19;
        boolean r22 = true;
    L20:
        s r5 = r10.getDisplaySetting();
        if (r5 != null) goto L23;
        r5 = new s(ImageDisplaySize.small, false, false, false, false);
    L23:
        int r6 = a.a[r5.a.ordinal()];
        if (r6 != 1) goto L26;
        int r7 = ti8.b.m;
        String r15 = r10.getUri();
        String r14 = r10.getThumbUrl();
        boolean r8 = r5.b;
        boolean r11 = r5.c;
        boolean r12 = r5.d;
        boolean r13 = r5.e;
        List r16 = r10.getFoldImageInfoList();
        if (r16 == null) goto L37;
        int r17 = r16.size();
    L38:
        String r23 = r10.getMainSiteUrl();
        Intrinsics.checkNotNullParameter(r3, "expandCardViewMode");
        if (e2.a.isPad() == false) goto L42;
        Lazy r18 = i5.k1;
        Pair r19 = new Pair(Integer.valueOf(((Number) r18.getValue()).intValue()), Integer.valueOf(((Number) r18.getValue()).intValue()));
    L48:
        final ti8.b r20 = new ti8.b(((Number) r19.getFirst()).intValue(), ((Number) r19.getSecond()).intValue(), r14, r15, r17, i5.q(), r8, r11, r12, r13, r22, r23);
    L49:
        SearchCardImageViewHolder r1 = (SearchCardImageViewHolder) r25;
        Map<String, String> r21 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r20, "imageViewData");
        ?? r24 = r1.a;
        r24.getClass();
        Intrinsics.checkNotNullParameter(r20, "viewData");
        r24.setLayoutParams(new FrameLayout.LayoutParams(r20.a, r20.b));
        String r27 = r20.d;
        if (r27 != null) goto L52;
    L55:
        boolean r28 = true;
    L56:
        if (r28 == false) goto L64;
        String r29 = r20.c;
        if (r29 != null) goto L60;
    L63:
        if (r4 == false) goto L64;
    L72:
        if (r20.e <= 0) goto L74;
        e1.x(r24.d);
        e1.x(r24.e);
        r24.d.setText("+" + r20.e);
    L75:
        SearchImageCardView.a(r24.getDelegate(), r20);
        SimpleDraweeView r30 = r24.c;
        ?? r31 = new ti8.a(r20);
        Intrinsics.checkNotNullParameter(r30, "<this>");
        Intrinsics.checkNotNullParameter(r31, "block");
        RoundingParams r32 = r30.getHierarchy().getRoundingParams();
        if (r32 != null) goto L78;
        r32 = new RoundingParams();
    L78:
        r31.invoke(r32);
        r30.getHierarchy().setRoundingParams(r32);
        SearchImageCardView.a(r24.d.getDelegate(), r20);
        SearchImageCardView.a(r24.e.getDelegate(), r20);
        return;
    L74:
        e1.o(r24.d);
        e1.o(r24.e);
        goto L75
    L60:
        if (r29.length() == 0) goto L63;
        r4 = false;
    L64:
        e1.x(r24.c);
        MessageImageLoader r110 = MessageImageLoader.a;
        if (r21 == null) goto L67;
        r9 = r21.get("message_id");
    L67:
        String r111 = r9;
        MessageImageType r112 = MessageImageType.IMAGE;
        SimpleDraweeView r113 = r24.c;
        String r33 = r20.c;
        if (r33 != null) goto L70;
        r33 = "";
    L70:
        IMessageImageLoaderService.a.b(r110, r111, r112, r113, r33, "chat.searchlist_cover_thumb", Integer.valueOf(i5.s()), Integer.valueOf(((Number) i5.p1.getValue()).intValue()), null, null, null, false, 1920);
        goto L72
    L52:
        if (r27.length() == 0) goto L55;
        r28 = false;
        goto L56
    L42:
        switch(ti8.b.a.C0087a.a[r3.ordinal()]) {
            case 1: goto L47;
            case 2: goto L47;
            case 3: goto L47;
            case 4: goto L46;
            case 5: goto L45;
            case 6: goto L45;
            default: goto L44;
        };
    L45:
        Lazy r114 = i5.U0;
        r19 = new Pair(Integer.valueOf(((Number) r114.getValue()).intValue()), Integer.valueOf(((Number) r114.getValue()).intValue()));
        goto L48
    L46:
        r19 = new Pair(Integer.valueOf(i5.x()), Integer.valueOf(i5.x()));
        goto L48
    L47:
        r19 = new Pair(Integer.valueOf(i5.s()), Integer.valueOf(i5.s()));
        goto L48
    L44:
        throw new NoWhenBranchMatchedException();
    L37:
        r17 = 0;
        goto L38
    L26:
        if (r6 != 2) goto L33;
        int r34 = ti8.b.m;
        String r115 = r10.getUri();
        String r116 = r10.getThumbUrl();
        boolean r35 = r5.b;
        boolean r36 = r5.c;
        boolean r37 = r5.d;
        boolean r38 = r5.e;
        List r39 = r10.getFoldImageInfoList();
        if (r39 == null) goto L30;
        int r117 = r39.size();
    L31:
        String r210 = r10.getMainSiteUrl();
        Lazy r40 = i5.x1;
        r20 = new ti8.b(((Number) r40.getValue()).intValue(), ((Number) r40.getValue()).intValue(), r116, r115, r117, i5.q(), r35, r36, r37, r38, r22, r210);
        goto L49
    L30:
        r117 = 0;
        goto L31
    L33:
        throw new NoWhenBranchMatchedException();
    L19:
        r22 = false;
        goto L20
    L13:
        if (((ArrayList) this.c).contains(r25) == true) goto L15;
        ((ArrayList) this.c).add(r25);
    L15:
        this.a.b(new e(r10, r26, r25.itemView, new AnonymousClass1(this), new AnonymousClass2(this)));
        goto L16
    L7:
        r10 = null;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (r6 != ItemType.TYPE_CARD_IMAGE.getType()) goto L5;
        int r7 = SearchCardImageViewHolder.b;
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new SearchCardImageViewHolder(new SearchImageCardView(r5.getContext(), null, 6, 0));
    L5:
        int r8 = SearchCardUnavailableViewHolder.b;
        return SearchCardUnavailableViewHolder.a.a(r5, i5.s(), i5.s());
    }
}
