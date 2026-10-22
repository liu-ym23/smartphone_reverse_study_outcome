package com.larus.chat.search.impl.chat;

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
import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.bot.BotModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\r\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005*+,-.B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J:\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'H\u0002J8\u0010(\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'2\u0006\u0010)\u001a\u00020#H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006/"}, d2 = {"Lcom/larus/chat/search/impl/chat/ChatSearchResultAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/chat/search/impl/chat/ChatSearchResult;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "listener", "Lcom/larus/chat/search/impl/chat/SearchItemListener;", "<init>", "(Lcom/larus/chat/search/impl/chat/SearchItemListener;)V", "getListener", "()Lcom/larus/chat/search/impl/chat/SearchItemListener;", "lastItemCount", "", "scrollListener", "com/larus/chat/search/impl/chat/ChatSearchResultAdapter$scrollListener$1", "Lcom/larus/chat/search/impl/chat/ChatSearchResultAdapter$scrollListener$1;", "reset", "", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemViewType", "setAvatar", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", ShareType.URL, "", "resizeWidth", "reSizeHeight", "circle", "", "loadAvatar", "bizTag", "Companion", "SearchChatViewHolder", "SearchChatMoreViewHolder", "SearchMessageMoreViewHolder", "SearchMessageViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatSearchResultAdapter extends ListAdapter<t, RecyclerView.ViewHolder> {
    public static final /* synthetic */ int d = 0;
    public final z a;
    public int b;
    public final ChatSearchResultAdapter$scrollListener$1 c;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/chat/search/impl/chat/ChatSearchResultAdapter$SearchChatMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/chat/search/impl/chat/ChatSearchResultAdapter;Landroid/view/View;)V", "textTitle", "Landroid/widget/TextView;", "imageAvatarSingle", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageAvatarGroup", "imageAvatarFirst", "imageAvatarSecond", "layoutViewMore", "dividerViewMore", "bind", "", "item", "Lcom/larus/chat/search/impl/chat/ChatSearchResult;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SearchChatMoreViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int i = 0;
        public final TextView a;
        public final SimpleDraweeView b;
        public final View c;
        public final SimpleDraweeView d;
        public final SimpleDraweeView e;
        public final View f;
        public final View g;
        public final /* synthetic */ ChatSearchResultAdapter h;

        public SearchChatMoreViewHolder(ChatSearchResultAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.h = r2;
            super(r3);
            this.a = (TextView) r3.findViewById(2131388498);
            this.b = r3.findViewById(2131375061);
            this.c = r3.findViewById(2131375059);
            this.d = r3.findViewById(2131375058);
            this.e = r3.findViewById(2131375060);
            this.f = r3.findViewById(2131377674);
            this.g = r3.findViewById(2131369253);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/chat/search/impl/chat/ChatSearchResultAdapter$SearchChatViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/chat/search/impl/chat/ChatSearchResultAdapter;Landroid/view/View;)V", "textTitle", "Landroid/widget/TextView;", "imageTagIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "imageAvatar", "Lcom/facebook/drawee/view/SimpleDraweeView;", "bind", "", "item", "Lcom/larus/chat/search/impl/chat/ChatSearchResult;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SearchChatViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int e = 0;
        public final TextView a;
        public final AppCompatImageView b;
        public final SimpleDraweeView c;
        public final /* synthetic */ ChatSearchResultAdapter d;

        public SearchChatViewHolder(ChatSearchResultAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.d = r2;
            super(r3);
            this.a = (TextView) r3.findViewById(2131388498);
            this.b = r3.findViewById(2131375079);
            this.c = r3.findViewById(2131375057);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/chat/search/impl/chat/ChatSearchResultAdapter$SearchMessageMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/chat/search/impl/chat/ChatSearchResultAdapter;Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SearchMessageMoreViewHolder extends RecyclerView.ViewHolder {
        public SearchMessageMoreViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/chat/search/impl/chat/ChatSearchResultAdapter$SearchMessageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/chat/search/impl/chat/ChatSearchResultAdapter;Landroid/view/View;)V", "textTitle", "Landroid/widget/TextView;", "imageTagIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "textSubtitle", "textDate", "imageAvatar", "Lcom/facebook/drawee/view/SimpleDraweeView;", "bind", "", "item", "Lcom/larus/chat/search/impl/chat/ChatSearchResult;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SearchMessageViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int g = 0;
        public final TextView a;
        public final AppCompatImageView b;
        public final TextView c;
        public final TextView d;
        public final SimpleDraweeView e;
        public final /* synthetic */ ChatSearchResultAdapter f;

        public SearchMessageViewHolder(ChatSearchResultAdapter r2, View r3) {
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

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.chat.search.impl.chat.ChatSearchResultAdapter$scrollListener$1] */
    public ChatSearchResultAdapter(ChatSearchFragment.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        super(new AnonymousClass1());
        this.a = r2;
        this.c = new ChatSearchResultAdapter$scrollListener$1(this);
    }

    public final int getItemViewType(int r1) {
        return ((t) getItem(r1)).getType();
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onAttachedToRecyclerView(r2);
        r2.addOnScrollListener(this.c);
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onDetachedFromRecyclerView(r2);
        r2.removeOnScrollListener(this.c);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r21, int r22) {
        Intrinsics.checkNotNullParameter(r21, "holder");
        final t r2 = (t) getItem(r22);
        String r4 = null;
        int r8 = 2131240950;
        boolean r12 = false;
        if ((r21 instanceof SearchChatViewHolder) == false) goto L59;
        SearchChatViewHolder r0 = (SearchChatViewHolder) r21;
        Intrinsics.checkNotNull(r2);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "item");
        r0.a.setText(r2.e);
        wc9.e r3 = r2.c;
        if (r3 == null) goto L12;
        Integer r5 = r3.j;
        if (r5 == null) goto L12;
        if (r5.intValue() != 1) goto L12;
        boolean r6 = true;
    L13:
        wc9.e r11 = r2.c;
        if (r11 == null) goto L21;
        Integer r13 = r11.j;
        if (r13 == null) goto L21;
        if (r13.intValue() != 3) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == true) goto L24;
    L40:
        if (r6 == false) goto L45;
        e1.x(r0.b);
        AppCompatImageView r7 = r0.b;
        if (r6 == false) goto L44;
        r8 = v19.c.b(2130971834, r7.getContext(), 2131241987);
    L44:
        r7.setImageResource(r8);
    L46:
        wc9.e r10 = r2.c;
        if (r10 == null) goto L54;
        Integer r14 = r10.j;
        if (r14 == null) goto L54;
        if (r14.intValue() != 2) goto L54;
        r12 = true;
    L54:
        ChatSearchResultAdapter r15 = r0.d;
        SimpleDraweeView r16 = r0.c;
        String r17 = r2.g;
        if (r17 != null) goto L57;
        r17 = "";
    L57:
        y2(r15, r16, r17, i5.Z(), i5.Z(), !r12);
        View r18 = ((RecyclerView.ViewHolder) r0).itemView;
        final ChatSearchResultAdapter r1 = r0.d;
        e1.d(r18, new w(r1, r2));
        return;
    L45:
        e1.o(r0.b);
        goto L46
    L24:
        if (z2.a.chatImmerseEnable() == false) goto L40;
        BotModel r19 = r2.d;
        if (r19 != null) goto L28;
    L30:
        boolean r20 = false;
    L31:
        if (r20 == false) goto L40;
        BotModel r23 = r2.d;
        if (r23 == null) goto L36;
        r4 = r23.getBgImgUrl();
    L36:
        if (o0.d(r4) == false) goto L40;
        BotModel r24 = r2.d;
        if (r24 == null) goto L40;
        r24.getBgImgColor();
        goto L40
    L28:
        if (true != r19.getBgImgOpen()) goto L30;
        r20 = true;
    L21:
        r9 = false;
    L12:
        r6 = false;
        goto L13
    L59:
        if ((r21 instanceof SearchChatMoreViewHolder) == false) goto L86;
        SearchChatMoreViewHolder r25 = (SearchChatMoreViewHolder) r21;
        Intrinsics.checkNotNull(r2);
        r25.getClass();
        Intrinsics.checkNotNullParameter(r2, "item");
        r25.a.setText(r2.e);
        if ((!r2.h.isEmpty()) == false) goto L71;
        e1.o(r25.b);
        e1.x(r25.c);
        ChatSearchResultAdapter r26 = r25.h;
        SimpleDraweeView r27 = r25.d;
        String r28 = (String) CollectionsKt.firstOrNull(r2.h);
        if (r28 != null) goto L65;
        String r29 = "";
    L66:
        y2(r26, r27, r29, i5.J(), i5.J(), true);
        ChatSearchResultAdapter r110 = r25.h;
        SimpleDraweeView r111 = r25.e;
        String r30 = (String) CollectionsKt.getOrNull(r2.h, 1);
        if (r30 != null) goto L69;
        String r112 = "";
    L70:
        y2(r110, r111, r112, i5.J(), i5.J(), true);
    L77:
        if (r2.k == false) goto L79;
        e1.o(r25.f);
    L81:
        if (r2.l == false) goto L83;
        e1.o(r25.g);
    L84:
        View r31 = r25.f;
        final ChatSearchResultAdapter r32 = r25.h;
        e1.d(r31, new v(r2, r32));
        return;
    L83:
        e1.x(r25.g);
        goto L84
    L79:
        e1.x(r25.f);
        goto L81
    L69:
        r112 = r30;
        goto L70
    L65:
        r29 = r28;
        goto L66
    L71:
        e1.x(r25.b);
        e1.o(r25.c);
        ChatSearchResultAdapter r33 = r25.h;
        SimpleDraweeView r34 = r25.b;
        String r35 = r2.g;
        if (r35 != null) goto L74;
        String r36 = "";
    L75:
        y2(r33, r34, r36, i5.Z(), i5.Z(), false);
        goto L77
    L74:
        r36 = r35;
        goto L75
    L86:
        if ((r21 instanceof SearchMessageViewHolder) == false) goto L144;
        SearchMessageViewHolder r37 = (SearchMessageViewHolder) r21;
        Intrinsics.checkNotNull(r2);
        r37.getClass();
        Intrinsics.checkNotNullParameter(r2, "item");
        r37.a.setText(r2.e);
        r37.c.setText(r2.f);
        r37.d.setText(r2.i);
        wc9.e r38 = r2.c;
        if (r38 == null) goto L95;
        Integer r39 = r38.j;
        if (r39 == null) goto L95;
        if (r39.intValue() != 1) goto L95;
        boolean r40 = true;
    L96:
        wc9.e r113 = r2.c;
        if (r113 == null) goto L104;
        Integer r114 = r113.j;
        if (r114 == null) goto L104;
        if (r114.intValue() != 3) goto L104;
        boolean r41 = true;
    L105:
        if (r41 == true) goto L107;
    L123:
        if (r40 == false) goto L128;
        e1.x(r37.b);
        AppCompatImageView r42 = r37.b;
        if (r40 == false) goto L127;
        r8 = v19.c.b(2130971834, r42.getContext(), 2131241987);
    L127:
        r42.setImageResource(r8);
    L129:
        wc9.e r43 = r2.c;
        if (r43 == null) goto L137;
        Integer r44 = r43.j;
        if (r44 == null) goto L137;
        if (r44.intValue() != 2) goto L137;
        r12 = true;
    L137:
        ChatSearchResultAdapter r45 = r37.f;
        SimpleDraweeView r46 = r37.e;
        String r47 = r2.g;
        if (r47 != null) goto L140;
        r47 = "";
    L140:
        y2(r45, r46, r47, i5.Z(), i5.Z(), !r12);
        View r48 = ((RecyclerView.ViewHolder) r37).itemView;
        final ChatSearchResultAdapter r49 = r37.f;
        e1.d(r48, new x(r49, r2));
        return;
    L128:
        e1.o(r37.b);
        goto L129
    L107:
        if (z2.a.chatImmerseEnable() == false) goto L123;
        BotModel r50 = r2.d;
        if (r50 != null) goto L111;
    L113:
        boolean r51 = false;
    L114:
        if (r51 == false) goto L123;
        BotModel r52 = r2.d;
        if (r52 == null) goto L119;
        r4 = r52.getBgImgUrl();
    L119:
        if (o0.d(r4) == false) goto L123;
        BotModel r53 = r2.d;
        if (r53 == null) goto L123;
        r53.getBgImgColor();
        goto L123
    L111:
        if (true != r50.getBgImgOpen()) goto L113;
        r51 = true;
    L104:
        r41 = false;
    L95:
        r40 = false;
        goto L96
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != 0) goto L5;
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562643, r3, false);
        Intrinsics.checkNotNull(r5);
        return new SearchChatViewHolder(this, r5);
    L5:
        if (r4 != 1) goto L7;
        View r6 = LayoutInflater.from(r3.getContext()).inflate(2131562651, r3, false);
        Intrinsics.checkNotNull(r6);
        return new SearchMessageViewHolder(this, r6);
    L7:
        if (r4 == 2) goto L9;
        View r7 = LayoutInflater.from(r3.getContext()).inflate(2131562650, r3, false);
        Intrinsics.checkNotNull(r7);
        return new SearchMessageMoreViewHolder(r7);
    L9:
        View r8 = LayoutInflater.from(r3.getContext()).inflate(2131562642, r3, false);
        Intrinsics.checkNotNull(r8);
        return new SearchChatMoreViewHolder(this, r8);
    }

    public static final void y2(ChatSearchResultAdapter r1, final SimpleDraweeView r2, String r3, final int r4, final int r5, boolean r6) {
        r1.getClass();
        r2.getHierarchy().setFailureImage(2131240119);
        ImageLoaderKt.y(r2, r3, "search.chat_avatar", new u(r2, r4, r5), 4);
        GenericDraweeHierarchy r7 = r2.getHierarchy();
        RoundingParams r8 = r2.getHierarchy().getRoundingParams();
        if (r8 == null) goto L5;
        RoundingParams r9 = r8.setRoundAsCircle(r6);
    L6:
        r7.setRoundingParams(r9);
        return;
    L5:
        r9 = null;
        goto L6
    }
}
